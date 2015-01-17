package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

import java.util.Date;

public class ReceiptsBillingListRequest extends CommandRequest {
    private Long clientId;
    private Date fromDate;
    private Date toDate;

    public ReceiptsBillingListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBillableReceipts);
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }
}