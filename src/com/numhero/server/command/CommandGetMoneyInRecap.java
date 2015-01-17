package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest;
import com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.MoneyInOutRecapRow;
import com.numhero.server.model.daolite.FXDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.utils.DateUtils;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;

import java.util.Date;
import java.util.List;

public class CommandGetMoneyInRecap extends AbstractAuthenticatedCommand<MoneyInRecapRequest, MoneyInRecapResponse> {

    @Inject
    InvoiceDao invoiceDao;

    @Inject
    FXDao fxDao;

    @Override
    public MoneyInRecapResponse execute(MoneyInRecapRequest request) throws Exception {

        MoneyInRecapResponse response = new MoneyInRecapResponse();

        Date from = DateUtils.getFirstDayMonth(new Date());
        Date to = new Date();
        buildRows(request, response, from, to);

		//very slow! TODO fix it with 1 query
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

    private Date previousMonth(MoneyInRecapRequest request, MoneyInRecapResponse response, Date from) {
        Date to;
        to = from;
        from = DateUtils.getStartPreviousMonth(from);
        buildRows(request, response, from, to);
        return from;
    }

    private void buildRows(MoneyInRecapRequest request, MoneyInRecapResponse response, Date from, Date to) {
        List<Invoice> invoices = invoiceDao.findByTypeAndStatus(
                request.getBusinessAccountId(),
                InvoiceTypeEnum.Invoice,
                InvoiceStatusEnum.Paid,
                from,
                to);
        Double totInvoice = getTotalValue(invoices);

        invoices = invoiceDao.findByTypeAndStatus(
                request.getBusinessAccountId(),
                InvoiceTypeEnum.Estimate,
                InvoiceStatusEnum.Paid,
                from,
                to);
        Double totEstimates = getTotalValue(invoices);
        response.getRows().add(buildRow(from, totInvoice, totEstimates));
    }

    private MoneyInOutRecapRow buildRow(Date from, Double totInvoices, Double totEstimates) {
        MoneyInOutRecapRow row = new MoneyInOutRecapRow();
        row.fMonth.setValue(DateUtils.getMonth(from));
        row.fYear.setValue(DateUtils.getYear(from));
        row.fCurrency.getValue();
        row.fInvoiceValue.setValue(totInvoices);
        row.fEstimatesValue.setValue(totEstimates);
        return row;
    }

    private Double getTotalValue(List<Invoice> invoices) {
        Double totInvoices = 0D;
        CurrencyEnum baCurrency = getBusinessAccount().fCurrency.getValue();
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);
            if (invoice.getInvoiceStatus() != InvoiceStatusEnum.Draft) {
                CurrencyEnum invoiceCurrency = invoice.fCurrency.getValue();
                if (baCurrency == invoiceCurrency)
                    totInvoices += invoice.getPrice();
                else
                    totInvoices += fxDao.convertToOtherCurrency(invoice.getPrice(), invoiceCurrency, baCurrency);
            }
        }
        return totInvoices;
    }

}
