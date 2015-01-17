package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.inject.Inject;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.server.search.TextTokenizer;
import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.SearchReference;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.PojoCField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public abstract class BaseSearchableDao<T extends SearchablePojo> extends BaseDao<T> {
    private static final Logger log = Logger.getLogger(BaseSearchableDao.class.getName());

    @Inject
    protected TextTokenizer textTokenizer;

    public BaseSearchableDao() {
    }

    public T findByName(String businessAccountId, String name) {
        return findUniqueResultByCriteria(businessAccountId, DSFilters.eq(BAPojo.FIELD_NAME, name));
    }

    @Override
    protected void pojoToEntity(T pojo, Entity e) {
        super.pojoToEntity(pojo, e);
        addSearchInfo(pojo, e);
    }

    protected void addSearchInfo(T pojo, Entity ent) {
        StringBuffer searchWords = new StringBuffer();
        String name = pojo.fName.getValue();
        if (name != null)
            name = name.toLowerCase().trim();
        ent.setProperty(FIELD_LOWER_CASE_NAME, name);

        Collection<PojoCField<?>> fl = pojo.getFields();
        for (PojoCField<?> pojoCField : fl) {
            if (pojoCField.isSearchableField()) {
                searchWords.append(pojoCField.getValueAsString());
                searchWords.append(' ');
            }
        }

        ent.setProperty(FIELD_WORDS_FOR_SEARCH, textTokenizer.getTokens(searchWords.toString()));
    }

    public List<T> searchForStartsWith(String startWith, int maxResults, String businessAccountId, DSFilter... f) {
        startWith = startWith.toLowerCase().trim();
        DSFilter[] filters = DSFilters.createArray(f,
                DSFilters.ge(FIELD_LOWER_CASE_NAME, startWith),
                DSFilters.lt(FIELD_LOWER_CASE_NAME, startWith + "\ufffd"));
        return findByCriteria(businessAccountId, maxResults, null, filters);
    }

    public List<T> search(String textToSearch, String businessAccountId) {
        //todo max result
        //todo result in AND not in OR
        List<T> ret = new ArrayList<T>();
        List<String> tokens = textTokenizer.getTokens(textToSearch);
        if (!tokens.isEmpty()) {
            if (tokens.size() > 10) {
                throw new RuntimeException("too many tokens (" + tokens.size() + ")");
            }
            log.fine("tokens size " + tokens.size());

            internalSelect(createQuerySort(SearchablePojo.FIELD_LAST_UPDATED, Query.SortDirection.DESCENDING), ret, 20, where(FIELD_WORDS_FOR_SEARCH).in(tokens), where(SearchablePojo.FIELD_BUSINESS_ACCOUNT_URI).equalsTo(businessAccountId));
        }
        return ret;
    }

    @Override
    protected void afterSave(T pojo, Entity e) {
        super.afterSave(pojo, e);

        saveSearchReference(pojo, e);
    }

    private void saveSearchReference(T pojo, Entity e) {
        SearchReference newPojo = createSearchReference(pojo);
        Key k = KeyFactory.createKey(newPojo.getClass().getSimpleName(), newPojo.fName.getValue());

        // try to retry from db anche check lastModified date for concurrency
        Entity searchEntity = new Entity(k);
        internalPojoToEntity(newPojo, searchEntity);
        searchEntity.setProperty(FIELD_WORDS_FOR_SEARCH, e.getProperty(FIELD_WORDS_FOR_SEARCH));
        ds.put(searchEntity);
    }

    private SearchReference createSearchReference(T pojo) {
        SearchReference s = new SearchReference();
        s.setPojoKind(pojo.getKind());
        s.setPojoName(pojo.getDisplayString());
        s.setPojoId(pojo.getId());
        s.fBusinessAccountUri.setValue(pojo.fBusinessAccountUri.getValue());
        return s;
    }
}
