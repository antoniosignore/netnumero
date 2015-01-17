package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.server.model.daolite.filter.DSFilter;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class InvoiceDao extends BaseSearchableDao<Invoice> {

    private static final Logger log = Logger.getLogger(InvoiceDao.class.getName());

    public PaginatedList<Invoice> findAllPaginated(String baUri, int resultsForPage, Long refObjectId,
                                          InvoiceTypeEnum invoiceType,
                                          InvoiceStatusEnum status) {
    	PaginatedList<Invoice> ret;
        DSFilter typeFilter = DSFilters.eq(Invoice.INVOICE_TYPE, invoiceType.name());
        String orderedFieldName = Invoice.FIELD_LAST_UPDATED;
        if (status == null) {
        	DSFilter archivedFilter = DSFilters.eq(Invoice.INVOICE_ARCHIVED, false);
            ret = findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.DESCENDING, typeFilter, archivedFilter);
        } else if (status == InvoiceStatusEnum.Archived) {
        	DSFilter archivedFilter = DSFilters.eq(Invoice.INVOICE_ARCHIVED, true);
            ret = findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.DESCENDING, typeFilter, archivedFilter);
        } else {
            DSFilter statusFilter = DSFilters.eq(Invoice.INVOICE_STATUS, status.name());
            ret = findAllPaginatedInternal(baUri, resultsForPage, orderedFieldName, refObjectId, Query.SortDirection.DESCENDING, typeFilter, statusFilter);
        }
        return ret;
    }

    public List<Invoice> findByTypeAndStatus(String businessAccountId,
                                             InvoiceTypeEnum invoiceType,
                                             InvoiceStatusEnum status,
                                             Date from, Date to) {
    	List<Invoice> ret;
        log.fine("InvoiceDao.findByTypeAndStatus");
        log.fine("invoiceType = " + invoiceType);
        log.fine("status = " + status);
        log.fine("from = " + from);
        log.fine("to = " + to);

        if (status == InvoiceStatusEnum.Archived) {
            ret = getInvoicesArchived(businessAccountId, invoiceType, from, to);
        } else {
            ret = findByCriteria(
                    businessAccountId,
                    DSFilters.eq(Invoice.INVOICE_TYPE, invoiceType.name()),
                    DSFilters.eq(Invoice.INVOICE_STATUS, status.name()) ,
                    DSFilters.ge(Invoice.DATE_RAISED, from),
                    DSFilters.le(Invoice.DATE_RAISED, to),
                    DSFilters.eq(Invoice.INVOICE_ARCHIVED, false));
        }
        return ret;
    }

    private List<Invoice> getInvoicesArchived(String businessAccountId, InvoiceTypeEnum invoiceType, Date from, Date to) {
        return findByCriteria(
                businessAccountId,
                DSFilters.eq("invoiceType", invoiceType.name()),
                DSFilters.eq(Invoice.INVOICE_ARCHIVED, true),
                DSFilters.ge("dateRaised", from),
                DSFilters.le("dateRaised", to));
    }

    public List<Invoice> findUnpaidByType(String businessAccountId) {
        return findByCriteria(
                businessAccountId,
                DSFilters.eq("invoiceType", InvoiceTypeEnum.Invoice.name()),
                DSFilters.ne("invoiceStatus", InvoiceStatusEnum.Paid.name()),
                DSFilters.ne("invoiceStatus", InvoiceStatusEnum.Sent.name()),
				DSFilters.eq(Invoice.INVOICE_ARCHIVED, false));
    }
}
