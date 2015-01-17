package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedArrayList;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.FieldDsTypeEnum;
import com.numhero.shared.pojoc.field.OwnedListField;
import com.numhero.shared.pojoc.field.PojoCField;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.logging.Logger;

public abstract class BaseDao<T extends BAPojo> {
    private static final Logger log = Logger.getLogger(BaseDao.class.getName());
    public static final int MAX_RESULTS_FOR_PAGE = 1000;

    protected Class<T> persistentClass;

    protected DatastoreService ds;

    private static final int MAX_DETAILS_FOR_POJO = 100;
    private static final String FIELD_COLLECTION_NAME = "___CollectionName";

    public static final String FIELD_LOWER_CASE_NAME = "___LowerCaseName";
    protected static final String FIELD_WORDS_FOR_SEARCH = "___WordsForSearch";

    private MemcacheService pojoCache;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        try {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        catch (Exception ex) {
            throw new RuntimeException("Dao constructor", ex);
        }

        ds = DatastoreServiceFactory.getDatastoreService();
        pojoCache = MemcacheServiceFactory.getMemcacheService("pojo");
    }

    public static QuerySort createQuerySort(String sortFieldName) {
        return new QuerySort(sortFieldName);
    }

    public static QuerySort createQuerySort(String sortFieldName, Query.SortDirection sortDirection) {
        return new QuerySort(sortFieldName, sortDirection);
    }


    @SuppressWarnings("unchecked")
    public T get(Long id) {
        if (id == null) {
            log.warning("empty id in dao get " + getEntityName());
            return null;
        }
        Key k = KeyFactory.createKey(getEntityName(), id);
        T pojo = (T) pojoCache.get(k);
        if (pojo != null) {
            return pojo;
        } else {
            return get(k);
        }
    }


    public void save(T pojo) {
        preSave(pojo);
        //TODO  trigger, version checking
        Entity e = prepareNewEntity(pojo);
        pojoToEntity(pojo, e);

        Transaction tx = ds.beginTransaction();
        try {
            saveInTransaction(pojo, e, tx);
        }
        catch (Throwable t) {
            tx.rollback();
            log.throwing(getClass().getName(), "save", t);
            throw new RuntimeException("Transaction rolled back. Cause:", t);
        }

        afterSave(pojo, e);
    }

    protected void preSave(T pojo) {
        //launch trigger for last minute preparations before saving
    }

    protected void afterSave(T pojo, Entity e) {
        //launch trigger for denormalized references

    }

    private void saveInTransaction(T pojo, Entity e, Transaction tx) {
        ds.put(tx, e);
        Key key = e.getKey();
        pojo.setId(key.getId());

        if (key != null && pojo.getOwnedLists() != null) {
            savePojoChildren(tx, pojo, key);
        }
        tx.commit();
        pojoCache.delete(key);
    }

    private Entity prepareNewEntity(T pojo) {
        Entity e;
        Long id = pojo.getId();
        if (id == null) {

            e = new Entity(pojo.getClass().getSimpleName());
        } else {

            Key k = KeyFactory.createKey(pojo.getClass().getSimpleName(), id);
            //try to retry from db anche check lastModified date for concurrency
            e = new Entity(k);
        }
        return e;
    }

    private List<Key> getListOfChildren(Transaction tx, Key parentKey) {
        ArrayList<Key> ret = new ArrayList<Key>();
        Query q = new Query(detailKindName());

        q.setAncestor(parentKey);
        q.setKeysOnly();
        PreparedQuery pq = ds.prepare(tx, q);

        for (Entity entity : pq.asList(FetchOptions.Builder.withLimit(MAX_DETAILS_FOR_POJO))) {
            ret.add(entity.getKey());
        }
        return ret;
    }

    private void savePojoChildren(Transaction tx, T pojo, Key key) {
        List<Key> lk = getListOfChildren(tx, key);

//        System.err.println("save for ancestor " + key.getKind() + " " + key.getId());
        String kindName = detailKindName();

        Collection<OwnedListField<?>> ol = pojo.getOwnedLists();

        for (OwnedListField<?> ownedList : ol) {
            String fieldName = ownedList.getFieldName();
            for (DetailBasePojo detail : ownedList) {

                Key k = saveDetail(tx, key, detail, fieldName, kindName);
                lk.remove(k);
            }

        }

        if (lk.size() > 0) {
            deleteAll(tx, lk);
        }
    }

    private void deleteAll(Transaction tx, List<Key> keyList) {
        ds.delete(tx, keyList);
    }

    protected String detailKindName() {
        return getEntityName() + "_detail";
    }

    private Key saveDetail(Transaction tx, Key parentKey, DetailBasePojo detail, String collectionName, String detailClassName) {

        Entity e;
        Long id = detail.getId();
        if (id == null) {
            e = new Entity(detailClassName, parentKey);
        } else {
            Key k = KeyFactory.createKey(parentKey, detailClassName, id);
            e = new Entity(k);
        }
        detail.fParentId.setValue(parentKey.getId());
        internalPojoToEntity(detail, e);
        e.setProperty(FIELD_COLLECTION_NAME, collectionName);

        ds.put(tx, e);
        Key key = e.getKey();
        detail.setId(key.getId());
//        System.err.println("saved with key " + key.getId() + " kind " +detailClassName + "  " + e);
        return key;
    }

    public void findAll(List<T> listToAdd, String businessAccountId, int limit) {

//		select(listToAdd, limit, SearchablePojo.FIELD_LAST_UPDATED, whereBa(businessAccountId));
        internalSelect(createQuerySort(SearchablePojo.FIELD_NAME), listToAdd, limit, whereBa(businessAccountId));
    }

    public void findAll(List<T> listToAdd, String businessAccountId, int limit, String order, Query.SortDirection sortDirection) {

//		select(listToAdd, limit, SearchablePojo.FIELD_LAST_UPDATED, whereBa(businessAccountId));
        internalSelect(createQuerySort(order, sortDirection), listToAdd, limit, whereBa(businessAccountId));
    }

    public List<T> findAll(String businessAccountId, int limit) {
        List<T> ret = new ArrayList<T>();
        findAll(ret, businessAccountId, limit);
        return ret;
    }

    public List<T> findAll(String businessAccountId, int limit, String order, Query.SortDirection sortDirection) {
        List<T> ret = new ArrayList<T>();
        findAll(ret, businessAccountId, limit, order, sortDirection);
        return ret;
    }

    public List<T> findAll(String businessAccountId) {
        return findAll(businessAccountId, MAX_RESULTS_FOR_PAGE);
    }

    public List<T> findAll(String businessAccountId, String order, Query.SortDirection sortDirection) {
        return findAll(businessAccountId, MAX_RESULTS_FOR_PAGE, order, sortDirection);
    }

    protected PaginatedList<T> findAllPaginatedInternal(String baUri, int resultsForPage, String orderedFieldName, Long refObjectId, Query.SortDirection direction, DSFilter... otherFilters) {

        PaginatedListParams params = new PaginatedListParams(orderedFieldName, refObjectId, direction, resultsForPage);


        DSFilter pageFilter;
        List<T> list = new ArrayList<T>();

        DSFilter[] filters = composeFilters(otherFilters, whereBa(baUri));
        if (refObjectId == null) {
            internalSelect(createQuerySort(params.orderedFieldName, params.querySortOrder), list, params.resultsForPage, filters);
        } else {
            T refObj = get(refObjectId);
            PojoCField<?> field = refObj.getField(orderedFieldName);
            Object val = field.getValue();
            if (params.querySortOrder == Query.SortDirection.ASCENDING) {
                pageFilter = where(orderedFieldName).greaterThan(val);
            } else {
                pageFilter = where(orderedFieldName).lessThan(val);
            }

            internalSelect(createQuerySort(params.orderedFieldName, params.querySortOrder), list, params.resultsForPage, composeFilters(filters, pageFilter));
        }
        if (params.prevPageAsked) {
            Collections.reverse(list);
        }


        return preparedPaginatedList(params, baUri, list, otherFilters);
    }

    private PaginatedArrayList<T> preparedPaginatedList(PaginatedListParams paginatedListParams, String baUri, List<T> list, DSFilter[] filters) {

        boolean firstPage = true;
        if (needToCheckFirstPage(paginatedListParams.refObjectId, list, paginatedListParams.prevPageAsked)) {
            Object value = list.get(0).getField(paginatedListParams.orderedFieldName).getValue();
            firstPage = checkIsFirstElement(baUri, value, paginatedListParams.orderedFieldName, paginatedListParams.resultSortOrder, filters);
        }

        boolean lastPage = true;
        if (needToCheckLastPage(paginatedListParams.refObjectId, list, paginatedListParams.prevPageAsked)) {
            Object value = list.get(list.size() - 1).getField(paginatedListParams.orderedFieldName).getValue();
            lastPage = checkIsLastElement(baUri, value, paginatedListParams.orderedFieldName, paginatedListParams.resultSortOrder, filters);
        }
        return new PaginatedArrayList<T>(list, lastPage, firstPage);

    }

    private boolean checkIsLastElement(String baUrl, Object value, String orderedFieldName, Query.SortDirection direction, DSFilter[] filters) {
        if (direction == Query.SortDirection.ASCENDING) {
            DSFilter gt = DSFilters.gt(orderedFieldName, value);
            return findByCriteria(baUrl, 1, orderedFieldName, composeFilters(filters, gt)).isEmpty();
        } else {
            DSFilter lt = DSFilters.lt(orderedFieldName, value);
            return findByCriteria(baUrl, 1, orderedFieldName, composeFilters(filters, lt)).isEmpty();
        }
    }

    private boolean checkIsFirstElement(String baUrl, Object value, String orderedFieldName, Query.SortDirection direction, DSFilter[] filters) {
        if (direction == Query.SortDirection.ASCENDING) {
            DSFilter lt = DSFilters.lt(orderedFieldName, value);
            return findByCriteria(baUrl, 1, orderedFieldName, composeFilters(filters, lt)).isEmpty();
        } else {
            DSFilter gt = DSFilters.gt(orderedFieldName, value);
            return findByCriteria(baUrl, 1, orderedFieldName, composeFilters(filters, gt)).isEmpty();
        }
    }

    private boolean needToCheckFirstPage(Long refObjectId, List<T> list, boolean reverseDirection) {
        return !list.isEmpty() && (refObjectId != null || reverseDirection);
    }

    private boolean needToCheckLastPage(Long refObjectId, List<T> list, boolean reverseDirection) {
        return !list.isEmpty() && (refObjectId != null || !reverseDirection);
    }


    protected T selectOneOnBA(String businessAccountId, DSFilter... filters) {

        T ret;
        if (businessAccountId != null) {
            DSFilter baFilter = whereBa(businessAccountId);
            if (filters == null) {
                ret = selectOne(baFilter);
            } else {
                ret = selectOne(composeFilters(filters, baFilter));
            }
        } else {
            throw new RuntimeException("businessId null!");
        }

        return ret;
    }

    private DSFilter[] composeFilters(DSFilter[] filters, DSFilter... otherFilters) {
        DSFilter[] newFilters = new DSFilter[filters.length + otherFilters.length];

        for (int i = 0; i < otherFilters.length; i++) {
            newFilters[i] = otherFilters[i];
        }
        for (int i = otherFilters.length; i < newFilters.length; i++) {
            newFilters[i] = filters[i - otherFilters.length];
        }
        return newFilters;
    }

    private DSFilter whereBa(String businessAccountId) {
        return where(SearchablePojo.FIELD_BUSINESS_ACCOUNT_URI).equalsTo(businessAccountId);
    }

    protected T selectOne(DSFilter... filters) {
        long startMilis = System.currentTimeMillis();
        Query q = new Query(getEntityName());

        for (DSFilter f : filters) {
            if (f != null) {
                f.addFilter(q);
            }

        }

        log.fine("filters " + q.getFilterPredicates().toString());

        PreparedQuery pq = ds.prepare(q);
        Entity entity = pq.asSingleEntity();
        T p = entity == null ? null : createPojoFromEntity(entity);

        long executionTime = System.currentTimeMillis() - startMilis;
        if (executionTime > 500) {
            log.info("!!selectOne " + getEntityName() + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        } else {
            log.fine("selectOne " + getEntityName() + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        }
        return p;
    }

    protected void internalSelect(QuerySort querySort, List<T> listToAdd, int maxResult, DSFilter... filters) {
        long startMilis = System.currentTimeMillis();
        listToAdd.clear();

        Query q = new Query(getEntityName());
//        System.err.println("-------0 kind " + q.getKind());

        for (DSFilter f : filters) {
            //     System.err.println("------- filter " + f);
            f.addFilter(q);
        }

        //           System.err.println("-------sortFieldName " + sortFieldName + " " + sortDirection);
        querySort.setSort(q);


        log.fine("filters " + q.getFilterPredicates().toString());
//        System.err.println("------- predicates " + q.getFilterPredicates().toString());

        PreparedQuery pq = ds.prepare(q);
        for (Entity entity : pq.asList(FetchOptions.Builder.withLimit(maxResult))) {
            listToAdd.add(createPojoFromEntity(entity));
//            System.err.println("---- retrieved --" + entity);
        }

        long executionTime = System.currentTimeMillis() - startMilis;
        if (executionTime > 500) {
            log.info("LONG select " + getEntityName() + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        } else {
            log.fine("select " + getEntityName() + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        }
    }

    protected DSFilter where(String fieldName) {
        DSFilter f = new DSFilter(fieldName);
        return f;
    }

    // ------------------------------------------
    protected List<T> findByCriteria(String businessAccountId, int maxResults, String order, DSFilter... filters) {
        List<T> ret = new ArrayList<T>();

        if (businessAccountId != null) {
            internalSelect(createQuerySort(order), ret, maxResults, composeFilters(filters, whereBa(businessAccountId)));
        } else {
            throw new RuntimeException("businessId null!");
        }

        log.info("number of results: " + ret.size());
        return ret;
    }


    protected List<T> findByCriteria(String businessAccountId, DSFilter... filters) {
        return findByCriteria(businessAccountId, MAX_RESULTS_FOR_PAGE, null, filters);
    }

    protected T findUniqueResultByCriteria(String businessAccountId, DSFilter... filters) {
        List<T> lt = findByCriteria(businessAccountId, filters);
        return getFirstElement(lt);
    }

    protected T getFirstElement(List<T> lt) {
        if (lt != null && lt.size() == 0) {
            return null;
        }
        return lt.get(0);
    }

    protected String getEntityName() {
        return persistentClass.getSimpleName();
    }

    protected T get(Key key) {
        long startMilis = System.currentTimeMillis();

        Entity ent;
        try {
            ent = ds.get(key);
        }
        catch (EntityNotFoundException e1) {
            log.fine("not found. " + getEntityName() + " " + key);
            return null;
        }

        T pojo = createPojoFromEntity(ent);

        long executionTime = System.currentTimeMillis() - startMilis;
        if (executionTime > 100) {
            log.info("!!getObjectById " + getEntityName() + " k:" + key + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        } else {
            log.fine("getObjectById " + getEntityName() + " k:" + key + " took: " + (System.currentTimeMillis() - startMilis) + " ms");
        }

        if (pojo != null && pojo.getOwnedLists() != null) {
            getPojoChildren(pojo, key);
        }

        pojoCache.put(key, pojo, Expiration.byDeltaSeconds(3600));
        return pojo;
    }

    private void getPojoChildren(T pojo, Key parentKey) {
        Query q = new Query(detailKindName());
        q.setAncestor(parentKey);
        //System.err.println("query for ancestor " + KeyFactory.keyToString(parentKey));
        PreparedQuery pq = ds.prepare(q);
        for (Entity entity : pq.asList(FetchOptions.Builder.withLimit(MAX_DETAILS_FOR_POJO))) {
            String cn = (String) entity.getProperty(FIELD_COLLECTION_NAME);

            DetailBasePojo detail = pojo.createNewDetail(cn);
            entityToPojo(entity, detail);

            pojo.getOwnedList(cn).addDetail(detail);
        }
    }

    public void delete(T pojo) {
        delete(pojo.getId());
    }

    public void delete(Long id) {
        Key k = KeyFactory.createKey(getEntityName(), id);
        delete(k);
    }

    protected void delete(Key key) {
        Transaction tx = ds.beginTransaction();
        try {
            ds.delete(tx, key);

            deletePojoChildren(tx, key);
            tx.commit();
            pojoCache.delete(key);
        }
        catch (Exception e) {
            tx.rollback();
        }
    }

    private void deletePojoChildren(Transaction tx, Key key) {
        List<Key> lk = getListOfChildren(tx, key);
        if (lk.size() > 0) {
            deleteAll(tx, lk);
        }
    }

    private T createPojoFromEntity(Entity ent) {
        T pojo = null;
        try {
            pojo = newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        entityToPojo(ent, pojo);
        return pojo;
    }

    protected T newInstance() throws InstantiationException, IllegalAccessException {
        return persistentClass.newInstance();
    }

    protected void entityToPojo(Entity ent, BAPojo pojo) {
        Set<String> fn = pojo.getFieldNames();
        for (String field : fn) {
            dsToPojoField(ent, pojo, field);
        }
    }

    protected void pojoToEntity(T pojo, Entity e) {
        internalPojoToEntity(pojo, e);
    }

    protected void internalPojoToEntity(BAPojo pojo, Entity e) {
        pojo.fLastUpdated.setValue(new Date());
        if (pojo.fCreated.getValue() == null) {
            pojo.fCreated.setValue(pojo.fLastUpdated.getValue());
        }
        Set<String> fn = pojo.getFieldNames();
        for (String field : fn) {
            pojoFieldToDs(pojo, e, field);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void dsToPojoField(Entity ent, BAPojo pojo, String field) {
        PojoCField f = pojo.getField(field);

        if (SearchablePojo.FIELD_ID.equals(field)) {
            f.setValue(ent.getKey().getId());
        } else {
            Object value = ent.getProperty(field);
            if (value == null) {
                f.setValue(null);
            } else if (f.getDsType() == FieldDsTypeEnum.dsNative) {
                f.setValue(value);
            } else if (f.getDsType() == FieldDsTypeEnum.string) {
                f.setValueAsString(value.toString());
            } else if (f.getDsType() == FieldDsTypeEnum.blob) {
                f.setValue(blobToBytes((Blob) value));
            }
        }
    }

    @SuppressWarnings({"rawtypes"})
    private void pojoFieldToDs(BAPojo pojo, Entity e, String field) {
        //TODO add embedded objects
        PojoCField f = pojo.getField(field);
        //System.out.println("----www---saving "  + f + "               of pojo " + pojo);
        if (SearchablePojo.FIELD_ID.equals(field)) {
            ;// skip
        } else if (f.getDsType() == FieldDsTypeEnum.dsNative) {
            e.setProperty(field, f.getValue());
        } else if (f.getDsType() == FieldDsTypeEnum.string) {
            e.setProperty(field, f.getValueAsString());
        } else if (f.getDsType() == FieldDsTypeEnum.blob) {
            e.setProperty(field, bytesToBlob((byte[]) f.getValue()));
        }
    }

    private Blob bytesToBlob(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            return new Blob(bytes);
        }
    }

    private byte[] blobToBytes(Blob blob) {
        if (blob == null) {
            return null;
        } else {
            return blob.getBytes();
        }
    }

}
