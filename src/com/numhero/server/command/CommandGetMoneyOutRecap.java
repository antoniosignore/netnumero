package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest;
import com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.MoneyInOutRecapRow;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.FXDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.DateUtils;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Date;
import java.util.List;

public class CommandGetMoneyOutRecap extends AbstractAuthenticatedCommand<MoneyOutRecapRequest, MoneyOutRecapResponse> {

    @Inject
    InvoiceDao invoiceDao;

    @Inject
    FXDao fxDao;

    @Inject
    ExpenseReceiptDao expenseReceiptDao;

    @Override
    public MoneyOutRecapResponse execute(MoneyOutRecapRequest request) throws Exception {

        MoneyOutRecapResponse response = new MoneyOutRecapResponse();

        Date from = DateUtils.getFirstDayMonth(new Date());
        Date to = new Date();
        buildRows(request, response, from, to);
        //fix with a single query

        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);
        from = previousMonth(request, response, from);

        return response;
    }

    private Date previousMonth(MoneyOutRecapRequest request, MoneyOutRecapResponse response, Date from) {
        Date to;
        to = from;
        from = DateUtils.getStartPreviousMonth(from);
        buildRows(request, response, from, to);
        return from;
    }

    private void buildRows(MoneyOutRecapRequest request, MoneyOutRecapResponse response, Date from, Date to) {
        List<Invoice> invoices = invoiceDao.findByTypeAndStatus(
                request.getBusinessAccountId(),
                InvoiceTypeEnum.Expense,
                null,
                from,
                to);
        Double totInvoice = getTotalValue(invoices);

        // todo = maybe just the paid receipts ????
        List<ExpenseReceipt> expenseReceipts = expenseReceiptDao.findReceipts(request.getBusinessAccountId(), null, null, from, to, null, null);
        Double totReceipts = getTotalExpenseValue(expenseReceipts);

        response.getRows().add(buildRow(from, totInvoice, totReceipts));
    }

    private MoneyInOutRecapRow buildRow(Date from, Double totExpenses, Double totReceipts) {
        MoneyInOutRecapRow row = new MoneyInOutRecapRow();
        row.fMonth.setValue(DateUtils.getMonth(from));
        row.fYear.setValue(DateUtils.getYear(from));
        row.fCurrency.getValue();
        row.fExpensesValue.setValue(totExpenses);
        row.fReceiptsValue.setValue(totReceipts);
        return row;
    }

    private Double getTotalValue(List<Invoice> expenses) {
        Double totInvoices = 0D;
        CurrencyEnum baCurrency = getBusinessAccount().fCurrency.getValue();
        for (int i = 0; i < expenses.size(); i++) {
            Invoice expense = expenses.get(i);
            CurrencyEnum invoiceCurrency = expense.fCurrency.getValue();
            if (baCurrency == invoiceCurrency)
                totInvoices += expense.getPrice();
            else
                totInvoices += fxDao.convertToOtherCurrency(expense.getPrice(), invoiceCurrency, baCurrency);
        }
        return totInvoices;
    }

    private Double getTotalExpenseValue(List<ExpenseReceipt> expenseReceipts) {
        Double totInvoices = 0D;
        CurrencyEnum baCurrency = getBusinessAccount().fCurrency.getValue();
        for (int i = 0; i < expenseReceipts.size(); i++) {
            ExpenseReceipt expenseReceipt = expenseReceipts.get(i);
            CurrencyEnum invoiceCurrency = expenseReceipt.fCurrency.getValue();
            if (baCurrency == invoiceCurrency)
                totInvoices += expenseReceipt.fValue.getValue();
            else
                totInvoices += fxDao.convertToOtherCurrency(expenseReceipt.fValue.getValue(), invoiceCurrency, baCurrency);
        }
        return totInvoices;
    }
}
