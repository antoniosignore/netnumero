package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest;
import com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse;
import com.numhero.client.model.pojoc.AccountBalanceRow;
import com.numhero.client.model.pojoc.LedgerAccountIF;
import com.numhero.client.util.CoreUtils;
import com.numhero.server.model.daolite.*;
import com.numhero.server.utils.CommandUtils;
import com.numhero.server.utils.LocalesUtils;
import com.numhero.shared.enums.AccountClassEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CommandGetAccountBalance extends AbstractAuthenticatedCommand<AccountBalanceRequest, AccountBalanceResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandGetAccountBalance.class.getName());

    @Inject
    CategoryDao categoryDao;

    @Inject
    ClientSupplierDao clientSupplierDao;

    @Inject
    TaxInfoDao taxInfoDao;

    @Inject
    NominalLedgerAccountDao nominalNominalLedgerAccountDao;

    @Inject
    BankAccountDao bankAccountDao;

    @Inject
    AccountingLegDao accountingLegDao;

    @Override
    public AccountBalanceResponse execute(AccountBalanceRequest accountBalanceRequest) throws Exception {

        CoreUtils.debug("CommandGetAccountBalance.execute");
        CoreUtils.debug("accountBalanceRequest = " + accountBalanceRequest.getCountry());
        
        ResourceBundle bundle = LocalesUtils.getBundle(accountBalanceRequest.getCountry());

        Long ledgerId = accountBalanceRequest.getLedgerAccountId();
        if (ledgerId == null) throw new IllegalArgumentException("ledgerId cannot be null");

        AccountClassEnum ledgerClass = accountBalanceRequest.getLedgerAccountClass();
        if (ledgerClass == null) throw new IllegalArgumentException("ledgerClass cannot be null");

        LedgerAccountIF ledger = getLedger(ledgerId, ledgerClass);
        List<AccountBalanceRow> balanceRows = new ArrayList<AccountBalanceRow>();
        if (ledger != null) {
            AccountBalanceRow balanceBDRow = new AccountBalanceRow();
            balanceBDRow.fTitle.setValue(bundle.getString("balance.brought.down"));
            balanceBDRow.fDate.setValue(ledger.getBalanceDate());
            balanceBDRow.fCreditValue.setValue(ledger.getBalance());
            balanceRows.add(balanceBDRow);
            List<AccountBalanceRow> rows = CommandUtils.prepareLedgerBalance(
                    accountBalanceRequest.getBusinessAccountId(),
                    accountBalanceRequest.getLedgerAccountId(),
                    accountingLegDao,
                    accountBalanceRequest.getFrom(),
                    accountBalanceRequest.getTo());

            balanceRows.addAll(rows);
        }
        AccountBalanceResponse response = new AccountBalanceResponse();
        response.setAccountBalanceRowList(balanceRows);
        return response;
    }

    private LedgerAccountIF getLedger(Long ledgerId, AccountClassEnum ledgerClass) {
        LedgerAccountIF ledger = null;
        if (ledgerClass == AccountClassEnum.Category) ledger = categoryDao.get(ledgerId);
        else if (ledgerClass == AccountClassEnum.ClientSupplier) ledger = clientSupplierDao.get(ledgerId);
        else if (ledgerClass == AccountClassEnum.TaxInfo) ledger = taxInfoDao.get(ledgerId);
        else if (ledgerClass == AccountClassEnum.NominalLedgerAccount)
            ledger = nominalNominalLedgerAccountDao.get(ledgerId);
        else if (ledgerClass == AccountClassEnum.BankAccount) ledger = bankAccountDao.get(ledgerId);
        return ledger;
    }
}
