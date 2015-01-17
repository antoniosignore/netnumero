package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.*;

public class TaxInfoDao extends BaseSearchableDao<TaxInfo> {
    public Map<Long, TaxInfo> findAllFromInvoice(Invoice invoice) {
        Set<Long> sl = new HashSet<Long>();
        List<InvoiceDetail> d = invoice.getDetails();
        for (InvoiceDetail invoiceDetail : d) {
            sl.add(invoiceDetail.fTax1ID.getValue());
            sl.add(invoiceDetail.fTax2ID.getValue());
        }
        Map<Long, TaxInfo> taxes = new HashMap<Long, TaxInfo>();
        for (Long taxId : sl) {
            if (taxId != null){
                TaxInfo taxInfo = get(taxId);
                taxes.put(taxId, taxInfo);
            }

        }
        return taxes;
    }

	public PaginatedList<TaxInfo> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {

		return findAllPaginatedInternal(businessAccountId, maxResults, TaxInfo.FIELD_NAME, refObjectId, Query.SortDirection.ASCENDING);
	}
}
