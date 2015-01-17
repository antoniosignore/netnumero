package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.server.utils.DateUtils;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class ExpenseReceiptDao extends BaseDao<ExpenseReceipt> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(ClientSupplierDao.class.getName());

    public List<ExpenseReceipt> findReceipts(String businessAccountId,
                                             Long clientId,
                                             Long staffId,
                                             Date from,
                                             Date to,
                                             InvoiceStatusEnum status,
                                             ReceiptStatusEnum receiptStatus
    ) {
        Date startOfDay = from != null ? DateUtils.getStartOfDay(from): null;
        Date endOfDay = to != null ? DateUtils.getEndOfDay(to): null;
        List<ExpenseReceipt> list = findByCriteria(businessAccountId,
                DSFilters.eq("clientSupplierID", clientId),
                DSFilters.eq("staffId", staffId) ,
                DSFilters.ge("date", startOfDay) ,
                DSFilters.le("date", endOfDay) ,
                DSFilters.eq("status", status),
                DSFilters.eq(ExpenseReceipt.RECEIPT_STATUS, receiptStatus));
        log.info("list = " + list);
        return list;
    }


}
