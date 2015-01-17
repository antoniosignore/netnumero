package com.numhero.server.model.daolite;

import com.google.appengine.api.datastore.Query;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.server.model.daolite.filter.DSFilters;
import com.numhero.shared.datacargo.PaginatedList;

import java.util.Date;
import java.util.List;


public class BankTransactionDao extends BaseSearchableDao<BankTransaction> {

    /*
    public DateField fDate = dateField("date", new Date());
    public IdField fBankAccountId = idField("bankAccountId");
    public StringField fBankAccountName = stringField("bankAccountName", 100);
    public StringField fNotes = stringField("notes", 100);
    public DoubleField fAmount = doubleField("amount", 0D);
    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.GBP);
    public EnumField<AccountingEntryType> fType = enumField("type", AccountingEntryType.money_in);
     */

    public List<BankTransaction> findByYear(String businessAccountId, Long bankAccountId, Date from, Date to) {
        return findByCriteria(businessAccountId,
                DSFilters.eq("bankAccountId", bankAccountId),
                DSFilters.gt("date", from),
                DSFilters.lt("date", to));
    }

	public PaginatedList<BankTransaction> findAllPaginated(String businessAccountId, int maxResults, Long refObjectId) {
		return findAllPaginatedInternal(businessAccountId, maxResults, BankTransaction.FIELD_LAST_UPDATED, refObjectId, Query.SortDirection.DESCENDING);
	}
}
