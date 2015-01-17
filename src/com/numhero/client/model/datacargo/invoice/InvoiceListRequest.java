package com.numhero.client.model.datacargo.invoice;

import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.InvoiceTypeEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class InvoiceListRequest extends ListCommandRequest {

    private InvoiceTypeEnum invoiceType = InvoiceTypeEnum.Invoice;
    private InvoiceStatusEnum status = null;
	//    private Date from;
//    private Date to;

    public InvoiceListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetInvoices);
    }

    public InvoiceListRequest(InvoiceTypeEnum invoiceType, InvoiceStatusEnum status) {
        this();
        this.invoiceType = invoiceType;
        this.status = status;
    }

    public InvoiceListRequest(InvoiceTypeEnum invoiceType) {
        this(invoiceType, null);
    }

    public InvoiceTypeEnum getInvoiceType() {
        return invoiceType;
    }

    public InvoiceStatusEnum getStatus() {
        return status;
    }

//    public Date getFrom() {
//        return from;
//    }
//
//    public void setFrom(Date from) {
//        this.from = from;
//    }
//
//    public Date getTo() {
//        return to;
//    }
//
//    public void setTo(Date to) {
//        this.to = to;
//    }

}
