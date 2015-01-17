package com.numhero.client.model.datacargo.expense;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

import java.util.Date;

public class UnpaidReceiptsListRequest extends CommandRequest {
    private Date fromDate;
    private Date toDate;
    private Long clientId;

    public UnpaidReceiptsListRequest() {
        setCommand(ApplicationCommandEnum.CommandGetUnpaidReceipts);
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

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


}
