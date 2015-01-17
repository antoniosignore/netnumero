package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.mvp.taxinfo.TaxInfoPanel;
import com.numhero.client.mvp.taxinfo.TaxInfoPresenter;

public class TaxInfoPresenterProxy extends PresenterProxy<TaxInfoPresenter> {
    @Override
    protected TaxInfoPresenter createPresenter() {

        TaxInfoPanel panel = new TaxInfoPanel();
        return new TaxInfoPresenter(getEventManager(),
                PresenterProxy.<GetTaxInfoRequest, GetTaxInfoResponse>createNewService(),
                PresenterProxy.<SaveTaxInfoRequest, SaveTaxInfoResponse>createNewService(),
                panel,
                getConstants());
    }
}
