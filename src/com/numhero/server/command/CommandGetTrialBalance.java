package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse;
import com.numhero.client.model.pojoc.AccountBalanceRow;
import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.BalanceSheetEnum;

import java.util.ArrayList;
import java.util.List;

public class CommandGetTrialBalance extends AbstractAuthenticatedCommand<TrialBalanceRequest, TrialBalanceResponse> {

    @Inject
    NominalLedgerAccountDao nominalLedgerAccountDao;

    @Inject
    CommandGetAccountBalance commandGetAccountBalance;

    @Override
    public TrialBalanceResponse execute(TrialBalanceRequest request) throws Exception {

        BusinessAccount ba = getBusinessAccount();

        List<NominalLedgerAccount> nominalLedgerAccounts = nominalLedgerAccountDao.findAll(request.getBusinessAccountId());
        List<BalanceSheetRow> responses = new ArrayList<BalanceSheetRow>();
        for (int i = 0; i < nominalLedgerAccounts.size(); i++) {
            NominalLedgerAccount nominalLedgerAccount = nominalLedgerAccounts.get(i);
            request.setLedgerAccountId(nominalLedgerAccount.getId());
            request.setLedgerAccountClass(AccountClassEnum.NominalLedgerAccount);
            request.setCountry(ba.fCountry.getValue());
            commandGetAccountBalance.setBusinessAccount(ba);
            AccountBalanceResponse response = commandGetAccountBalance.execute(request);
            responses.add(convertToTrialBalanceRow(
                    response,
                    nominalLedgerAccount.fName.getValue(),
                    nominalLedgerAccount.fAccountingGroup.getValue(),
                    nominalLedgerAccount.fBalanceSheetType.getValue(),
                    ba));
        }

        TrialBalanceResponse rsp = new TrialBalanceResponse();
        rsp.setTrialRows(responses);
        return rsp;
    }

    private BalanceSheetRow convertToTrialBalanceRow(AccountBalanceResponse response,
                                                     String name,
                                                     AccountingGroupEnum type,
                                                     BalanceSheetEnum value,
                                                     BusinessAccount ba) {

        BalanceSheetRow balanceSheetRow = new BalanceSheetRow();
        balanceSheetRow.fCurrency.setValue(ba.fCurrency.getValue());
        balanceSheetRow.fNominalLedgerName.setValue(name);
        balanceSheetRow.fAccountingGroup.setValue(type);
        balanceSheetRow.fBalanceSheetType.setValue(value);

        List<AccountBalanceRow> list = response.getAccountBalanceRowList();
        Double balance = 0D;
        for (int row = 0; row < list.size(); row++) {
            AccountBalanceRow accountBalanceRow = list.get(row);

            if (row == 0) balance = accountBalanceRow.fBalance.getValue();

            if (accountBalanceRow.fDebitValue.getValue() > 0)
                balance -= accountBalanceRow.fDebitValue.getValue();
            if (accountBalanceRow.fCreditValue.getValue() > 0)
                balance += accountBalanceRow.fCreditValue.getValue();

            if (balance < 0)
                balanceSheetRow.fDebitValue.setValue(balance);
            else
                balanceSheetRow.fCreditValue.setValue(balance);
        }
        return balanceSheetRow;
    }
}
