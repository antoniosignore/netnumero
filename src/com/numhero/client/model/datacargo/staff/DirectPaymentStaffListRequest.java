package com.numhero.client.model.datacargo.staff;

import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.enums.ReceiptStatusEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

public class DirectPaymentStaffListRequest extends BulkActionRequest {

    private ReceiptStatusEnum status;
    private CountryEnum countryCode;

    public DirectPaymentStaffListRequest() {
        setCommand(ApplicationCommandEnum.CommandDirectPaymentStaffMembers);
    }

    public ReceiptStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReceiptStatusEnum status) {
        this.status = status;
    }

    public CountryEnum getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryEnum country) {
        this.countryCode = country;
    }
}