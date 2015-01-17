package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.bankaccount.*;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.mvp.bankaccount.BankAccountPanel;
import com.numhero.client.mvp.banktransaction.BankTransactionPanel;
import com.numhero.client.mvp.banktransaction.BankTransactionPresenter;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class BankTransactionPresenterProxy extends PresenterProxy<BankTransactionPresenter> {
    @Override
    protected BankTransactionPresenter createPresenter() {
        CategoryPanel categoryPanel = new CategoryPanel();
        BankAccountPanel accountPanel = new BankAccountPanel();
        BankTransactionPanel panel = new BankTransactionPanel(
                PresenterProxy.<BankAccountListRequest, BankAccountListResponse>createNewService(),
                PresenterProxy.<SaveBankAccountRequest, SaveBankAccountResponse>createNewService(),
                accountPanel,
                PresenterProxy.<CategoryListRequest, CategoryListResponse>createNewService(),
                PresenterProxy.<SaveCategoryRequest, SaveSingleEntityResponse>createNewService(),
                categoryPanel);
        return new BankTransactionPresenter(getEventManager(),
                PresenterProxy.<GetBankTransactionRequest, GetBankTransactionResponse>createNewService(),
                PresenterProxy.<SaveBankTransactionRequest, SaveBankTransactionResponse>createNewService(),
                panel,
                PresenterProxy.<GetMainTradingBankAccountRequest, GetMainTradingBankAccountResponse>createNewService(),
                getConstants());
    }
}
