package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.datacargo.staff.*;
import com.numhero.client.mvp.staff.InternalPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class InternalPresenterProxy extends PresenterProxy<InternalPresenter> {
    @Override
    protected InternalPresenter createPresenter() {

        return new InternalPresenter(getEventManager(),
                PresenterProxy.<GetStaffRequest, GetStaffResponse>createNewService(),
                PresenterProxy.<SaveStaffRequest, SaveStaffResponse>createNewService(),
                PresenterProxy.<DirectPaymentStaffListRequest, BulkActionResponse>createNewService(),
                PresenterProxy.<GetCurrencyConversionRequest, GetCurrencyConversionResponse>createNewService(),
                getConstants());
    }
}
