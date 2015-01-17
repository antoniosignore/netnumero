package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse;
import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.BalanceSheetEnum;

import java.util.ArrayList;
import java.util.List;

public class CommandGetProfitLoss extends AbstractAuthenticatedCommand<GetProfitLossRequest, GetProfitLossResponse> {

    @Inject
    NominalLedgerAccountDao nominalLedgerAccountDao;

    @Inject
    CommandGetTrialBalance commandGetTrialBalance;

    @Override
    public GetProfitLossResponse execute(GetProfitLossRequest request) throws Exception {

        BusinessAccount ba = getBusinessAccount();
        commandGetTrialBalance.setBusinessAccount(ba);

        request.setCountry(ba.fCountry.getValue());
        TrialBalanceResponse trialBalanceResponse = commandGetTrialBalance.execute(request);
        GetProfitLossResponse rsp = new GetProfitLossResponse();

        rsp.setSheetRows(convertToPLRow(trialBalanceResponse, rsp));
        return rsp;
    }

    private List<BalanceSheetRow> convertToPLRow(TrialBalanceResponse trialBalanceResponse, GetProfitLossResponse rsp) {
        rsp.setSales(0D);
        rsp.setCostOfSales(0D);
        List<BalanceSheetRow> PAndL = new ArrayList<BalanceSheetRow>();
        List<BalanceSheetRow> balanceRows = trialBalanceResponse.getTrialRows();
        for (int i = 0; i < balanceRows.size(); i++) {
            BalanceSheetRow balanceSheetRow = balanceRows.get(i);
            if (balanceSheetRow.fBalanceSheetType.getValue() == BalanceSheetEnum.isSales) {
                Double sales = balanceSheetRow.fCreditValue.getValue() + balanceSheetRow.fDebitValue.getValue();
                rsp.setSales(sales);
            }
        }

        Double totCostOfSales = 0D;
        for (int i = 0; i < balanceRows.size(); i++) {
            BalanceSheetRow balanceSheetRow = balanceRows.get(i);
            if (balanceSheetRow.fBalanceSheetType.getValue() == BalanceSheetEnum.isCostOfSales) {
                totCostOfSales += balanceSheetRow.fDebitValue.getValue();
            }
        }

        rsp.setCostOfSales(totCostOfSales);
        rsp.setGrossProfit(rsp.getSales() - rsp.getCostOfSales());

        Double totExpense = 0D;
        for (int i = 0; i < balanceRows.size(); i++) {
            BalanceSheetRow balanceSheetRow = balanceRows.get(i);
            if (balanceSheetRow.fBalanceSheetType.getValue() != BalanceSheetEnum.isCostOfSales &&
                    balanceSheetRow.fAccountingGroup.getValue() == AccountingGroupEnum.Expense) {
                PAndL.add(balanceSheetRow);
                totExpense += balanceSheetRow.fDebitValue.getValue();
            }
        }
        rsp.setTotalExpenses(totExpense);

        return PAndL;
    }
}
