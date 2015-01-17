package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.mvp.taxinfo.TaxInfosPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class TaxInfosPresenterProxy extends PresenterProxy<TaxInfosPresenter> {
    @Override
    protected TaxInfosPresenter createPresenter() {

        return new TaxInfosPresenter(getEventManager(),
                PresenterProxy.<TaxInfoListRequest, TaxInfoListResponse>createNewService(),
                PresenterProxy.<DeleteTaxInfosRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
