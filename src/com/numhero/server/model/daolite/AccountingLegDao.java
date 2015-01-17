package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.AccountingLeg;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.enums.AccountingEntrySide;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class AccountingLegDao extends BaseDao<AccountingLeg> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(ClientSupplierDao.class.getName());


    public List<AccountingLeg> findAllLegsByNominalCode(String businessAccountId,
            String nominalCode,
            Date from,
            Date to){
        return findByCriteria(businessAccountId,
                DSFilters.eq(AccountingLeg.NOMINAL_CODE, nominalCode),
                DSFilters.ge(AccountingLeg.DATE, from),
                DSFilters.le(AccountingLeg.DATE, to));

    }


    public List<AccountingLeg> findByCriteria(
            String businessAccountId,
            Long ledgerAccountId,
//            BusinessTransaction entry,
            AccountingEntrySide doubleEntryType,
            Date from,
            Date to) {

//        log.info("AccountingLegDao.findByCriteria");
//        log.info("businessAccountId = " + businessAccountId);
//        log.info("ledgerAccountId = " + ledgerAccountId);
//        if (entry != null) log.info("entry.getName() = " + entry.getName());
//        log.info("doubleEntryType = " + doubleEntryType);
//        if (from != null) log.info("from.toString() = " + from.toString());
//        if (to != null) log.info("to.toString() = " + to.toString());

        return findByCriteria(businessAccountId,
                DSFilters.eq(AccountingLeg.ACCOUNT_ID, ledgerAccountId) ,
//                (entry != null) ? DSFilters.eq(AccountingLeg.BUSINESS_TRANSACTION_ID, entry.getId()) : null,
                DSFilters.eq(AccountingLeg.DOUBLE_ENTRY_TYPE, doubleEntryType) ,
                DSFilters.ge("date", from),
                DSFilters.le("date", to));

    }


    @Override
    protected String getEntityName() {
        return "BusinessTransaction_detail";
    }
}
