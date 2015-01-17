package com.numhero.client.mvp.bankaccount;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchBankAccountDialog extends SearchPojoDialog {
    public SearchBankAccountDialog(Service<BankAccountListRequest, BankAccountListResponse> getListService, String search) {
        super(Application.getConstants().searchBankAccounts(), search, getListService, new SearchPanel(new SearchBankAccountTable()), new BankAccountListRequest());
    }
}
