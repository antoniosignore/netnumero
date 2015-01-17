package com.numhero.client.mvp.accounting;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.pojoc.AccountBalanceRow;
import com.numhero.client.model.pojoc.LedgerAccountIF;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class LedgerAccountTable extends FlexTableWithHeader {

    public LedgerAccountTable() {
        this.setStyleName("");
        setHeader();
    }
    
    public void setAccountIF(LedgerAccountIF ledgerAccountIF, Service<AccountBalanceRequest, AccountBalanceResponse> getAccountBalance) {
        removeAllRows();

        Long ledgerAccountId = ledgerAccountIF.getId();
        AccountClassEnum ledgerAccountClass = ledgerAccountIF.getAccountClass();

        AccountBalanceRequest request = new AccountBalanceRequest();
        request.setLedgerAccountId(ledgerAccountId);
        request.setLedgerAccountClass(ledgerAccountClass);
        request.setCountry(ClientCache.getCurrentBA().fCountry.getValue());

        getAccountBalance.execute(request, new ServiceCallbackImpl<AccountBalanceResponse>() {
            @Override
            public void onSuccess(AccountBalanceResponse response) {
                List<AccountBalanceRow> list = response.getAccountBalanceRowList();
                refreshTable(list);
            }
        });

    }
  
    public void refreshTable(List<AccountBalanceRow> list) {
         Double balance = 0D;
         if (list.size() == 0) {
             addEmptyStatus(); 
         }
         for (int row = 0; row < list.size(); row++) {
             AccountBalanceRow accountBalanceRow = list.get(row);

             if (row == 0) {
            	 balance = accountBalanceRow.fBalance.getValue();
             }
             
             if (accountBalanceRow.fDebitValue.getValue() > 0) {
                 balance -= accountBalanceRow.fDebitValue.getValue();
             }
             if (accountBalanceRow.fCreditValue.getValue() > 0) {
                 balance += accountBalanceRow.fCreditValue.getValue();
             }
             
             setText(row, 0, DateTimeFormat.getShortDateFormat().format(accountBalanceRow.fDate.getValue()));
             setText(row, 1, accountBalanceRow.fTitle.getValue());
             if (accountBalanceRow.fDebitValue.getValue() != 0)
                 setText(row, 2, SharedUtils.currencyToStr(accountBalanceRow.fDebitValue.getValue(), 2, accountBalanceRow.fCurrency.getValue()));
             else
                 setText(row, 2, "");

             if (accountBalanceRow.fCreditValue.getValue() != 0)
                 setText(row, 3, SharedUtils.currencyToStr(accountBalanceRow.fCreditValue.getValue(), 2, accountBalanceRow.fCurrency.getValue()));
             else
                 setText(row, 3, "");

             setText(row, 4, SharedUtils.currencyToStr(balance, 2, accountBalanceRow.fCurrency.getValue()));
         }
     }

     public void setHeader() {
         setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
         setHeader(1, Application.getConstants().title(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
         setHeader(2, Application.getConstants().debit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
         setHeader(3, Application.getConstants().credit(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
         setHeader(4, Application.getConstants().balance(), HasHorizontalAlignment.ALIGN_LEFT, "100px");
     }
}
