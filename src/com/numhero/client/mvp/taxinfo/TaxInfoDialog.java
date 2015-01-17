package com.numhero.client.mvp.taxinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.CurrencyEnum;

public class TaxInfoDialog extends DialogBox {
    private TaxInfoPanel taxInfoPanel;

    public TaxInfoDialog(final Service<SaveTaxInfoRequest, SaveTaxInfoResponse> taxInfoSaveService, String name) {
        setText(Application.getConstants().newTax());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        taxInfoPanel = new TaxInfoPanel();
        TaxInfo taxInfoC = new TaxInfo();
        taxInfoC.fName.setValue(name);
        taxInfoC.setCurrency(CurrencyEnum.EUR);
        taxInfoPanel.setPojo(taxInfoC);

        taxInfoPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                boolean isValid = taxInfoPanel.saveValuesFromUi();
                if (isValid) {
                    SaveTaxInfoRequest request = new SaveTaxInfoRequest();
                    request.setTaxInfo(getTaxInfoC());
                    Application.showGlasspanelLoading();
                    taxInfoSaveService.execute(request, new ServiceCallbackImpl<SaveTaxInfoResponse>() {
                        @Override
                        public void onSuccess(SaveTaxInfoResponse response) {
                            getTaxInfoC().setId(response.getEntityId());
                            Application.toasterMessage(Application.getConstants().taxInfoSaved());
                            TaxInfoDialog.this.hide();
                        }
                    });
                }
            }
        });
        taxInfoPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TaxInfoDialog.this.hide();
            }
        });
        setWidget(taxInfoPanel);
    }

    public TaxInfo getTaxInfoC() {
        return taxInfoPanel.getTaxInfo();
    }
}
