package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ClientSupplierEnum;
import com.numhero.shared.pojoc.BAPojo;

import java.util.List;
import java.util.logging.Logger;

public class ClientSupplierDao extends BaseSearchableDao<ClientSupplier> {

    private static final Logger log = Logger.getLogger(ClientSupplierDao.class.getName());

    public ClientSupplier findByName(String businessAccountId, String name) {
        return findUniqueResultByCriteria(businessAccountId, DSFilters.eq(BAPojo.FIELD_NAME, name));
    }

    public ClientSupplier findByVat(String businessAccountId, String vat) {
        return findUniqueResultByCriteria(businessAccountId, DSFilters.eq(BAPojo.FIELD_NAME, vat));
    }

    public List<ClientSupplier> findByType(String businessAccountId, int maxResults, ClientSupplierEnum type) {
        log.info("ClientSupplierDao.findByType");
        log.info("type = " + type);
        log.info("maxResults = " + maxResults);

        if (type == ClientSupplierEnum.client) {
            return findByCriteria(businessAccountId, maxResults, null, DSFilters.eq("client", true));
        } else if (type == ClientSupplierEnum.supplier) {
            return findByCriteria(businessAccountId, maxResults, null, DSFilters.eq("supplier", true));
        } else {
            return findByCriteria(businessAccountId, maxResults, null);
        }
    }

    public List<ClientSupplier> search(String startingKey, int maxResults, String businessAccountId, DSFilter type) {
        return searchForStartsWith(startingKey, maxResults, businessAccountId, type);
    }

    public PaginatedList<ClientSupplier> findAllPaginated(String baUri, int resultsForPage, Long refObjectId,
                                                          ClientSupplierEnum type) {


        String orderedFieldName = ClientSupplier.FIELD_NAME;

        if (type == ClientSupplierEnum.client) {
            return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.ASCENDING, DSFilters.eq("client", true));
        } else if (type == ClientSupplierEnum.supplier) {
            return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.ASCENDING, DSFilters.eq("supplier", true));
        } else {
            return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.ASCENDING);
        }

//        if (status == null) {
//            return typeFilter);
//        } else {
//            DSFilter statusFilter = DSFilters.eq(Invoice.INVOICE_STATUS, DSFilters.quote(status.name()));
//            return findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, typeFilter, statusFilter);
//        }

    }
}
