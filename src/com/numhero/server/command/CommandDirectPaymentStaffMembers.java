package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.util.ClientUtils;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.model.daolite.BankTransactionDao;
import com.numhero.server.model.daolite.CategoryDao;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.service.DoubleEntryProcessor;
import com.numhero.server.utils.LocalesUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class CommandDirectPaymentStaffMembers extends
        AbstractAuthenticatedCommand<DirectPaymentStaffListRequest, BulkActionResponse> {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandDirectPaymentStaffMembers.class.getName());

    @Inject
    BankAccountDao bankdao;

    @Inject
    ExpenseReceiptDao dao;

    @Inject
    CategoryDao categoryDao;

    @Inject
    DoubleEntryProcessor processor;

    @Inject
    BankTransactionDao bankTransactionDao;

    ResourceBundle bundle;

    @Override
    public BulkActionResponse execute(DirectPaymentStaffListRequest request) {

        ReceiptStatusEnum status = request.getStatus();

        BulkActionResponse resp = new BulkActionResponse();
        List<Long> ids = request.getEntityIdList();

        BankAccount bank = bankdao.getMainTradingAccount(getBusinessAccount().fBusinessAccountUri.getValue());

        bundle = LocalesUtils.getBundle(request.getCountryCode());

        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.fBankAccountId.setValue(bank.getId());
        bankTransaction.fBankAccountName.setValue(bank.getName());
        bankTransaction.fBusinessAccountUri.setValue(getBusinessAccount().fBusinessAccountUri.getValue());
        bankTransaction.fCurrency.setValue(bank.fCurrency.getValue());


        Map<Category, Double> rmap = new HashMap<Category, Double>();

        for (Long s : ids) {
            try {
                ExpenseReceipt receipt = dao.get(s);
                receipt.fReceiptStatus.setValue(status);

                Category category = categoryDao.get(receipt.fCategoryID.getValue());
                rmap.put(category, receipt.fValue.getValue());

                dao.save(receipt);
                resp.getSuccessIdList().add(s);
            } catch (Exception e) {
                resp.getFailureIdList().add(s);
            }
        }

        Double tot = ClientUtils.calculateSumOfDoubles(rmap.values());
        bankTransaction.fValue.setValue(tot);
        Category cat = rmap.keySet().iterator().next(); //TODO getting the first one just for the moment
        bankTransaction.fAccountID.setValue(cat.getId());
        bankTransaction.fAccountName.setValue(cat.fName.getValue());

        bankTransactionDao.save(bankTransaction);

        processor.processReimbursementsPayment(getBusinessAccount(), bankTransaction, rmap);

        resp.setMessage("OK");
        return resp;
    }
}
