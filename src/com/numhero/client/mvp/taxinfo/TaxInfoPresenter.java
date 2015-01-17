package com.numhero.client.mvp.taxinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericMoneyoutTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class TaxInfoPresenter extends EditPresenter {

    Service<GetTaxInfoRequest, GetTaxInfoResponse> taxinfoGetService;
    Service<SaveTaxInfoRequest, SaveTaxInfoResponse> taxinfosaveService;
    private TaxInfoConstants constants;

    @Inject
    public TaxInfoPresenter(PlaceManager eventManager,
                            Service<GetTaxInfoRequest, GetTaxInfoResponse> taxinfoGetService,
                            Service<SaveTaxInfoRequest, SaveTaxInfoResponse> taxinfosaveService,
                            TaxInfoPanel taxinfoPanel,
                            TaxInfoConstants constants) {
        super(eventManager, new GenericMoneyoutTabEditPage(taxinfoPanel));
        this.taxinfoGetService = taxinfoGetService;
        this.taxinfosaveService = taxinfosaveService;
        this.constants = constants;
    }

    private TaxInfoPanel getTaxInfoPanel() {
        return ((TaxInfoPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getTaxInfoPanel().setPojo(new TaxInfo());
            getView().setDetailTitlePanel(constants.createNewTaxInfo());
        } else {
            getView().setDetailTitlePanel(constants.editTaxInfo());
            GetTaxInfoRequest request = new GetTaxInfoRequest();
            request.setEntityId(getUrl().getId());

            taxinfoGetService.execute(request, new ServiceCallbackImpl<GetTaxInfoResponse>() {
                @Override
                public void onSuccess(GetTaxInfoResponse response) {
                    getTaxInfoPanel().setPojo(response.getEntity());
                }

            });
        }
    }

    private ClickHandler saveTaxInfoHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getTaxInfoPanel().saveValuesFromUi()) {
                    SaveTaxInfoRequest request = new SaveTaxInfoRequest();
                    request.setTaxInfo(getTaxInfoPanel().getTaxInfo());
                    taxinfosaveService.execute(request, new ServiceCallbackImpl<SaveTaxInfoResponse>() {
                        @Override
                        public void onSuccess(SaveTaxInfoResponse response) {
                            Application.toasterMessage(Application.getConstants().taxinfoSaved());
                            Application.getPlaceManager().moveToPlace("taxinfos");
                        }
                    });
                }
            }
        };
        return ret;
    }

    @Override
    protected void onBind() {
        super.onBind();
        TaxInfoPanel panel = getTaxInfoPanel();
        panel.getBtSave().addClickHandler(saveTaxInfoHandler());
        panel.getBtCancel().setHref("#taxinfos");
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    @Override
    protected String getReturnUrl() {
        return "taxinfos";
    }
}
