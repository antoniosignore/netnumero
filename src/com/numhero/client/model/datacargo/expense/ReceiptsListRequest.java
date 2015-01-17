package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.enums.InvoiceStatusEnum;
import com.numhero.shared.enums.ReceiptStatusEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

import java.util.Date;

public class ReceiptsListRequest extends CommandRequest {

    private ReceiptStatusEnum receiptStaffStatus;
    private InvoiceStatusEnum clientStatus;
    private Date fromDate;
    private Date toDate;
    private Long clientId;
    private Long staffId;

    public ReceiptsListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetReceipts);
    }

    public void setClientStatus(InvoiceStatusEnum clientStatus) {
        this.clientStatus = clientStatus;
    }

    public ReceiptStatusEnum getReceiptStaffStatus() {
        return receiptStaffStatus;
    }

    public void setReceiptStaffStatus(ReceiptStatusEnum receiptStaffStatus) {
        this.receiptStaffStatus = receiptStaffStatus;
    }

    public InvoiceStatusEnum getClientStatus() {
        return clientStatus;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
