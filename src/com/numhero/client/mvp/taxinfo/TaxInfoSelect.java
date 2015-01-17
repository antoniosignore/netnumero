package com.numhero.client.mvp.taxinfo;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;

public class TaxInfoSelect extends DropDownBox<TaxInfoListRequest, TaxInfoListResponse> {
    private Service<SaveTaxInfoRequest, SaveTaxInfoResponse> saveService;
    private TaxInfo pojoC;

    public TaxInfoSelect(DropDownBoxHandler handler, Service<TaxInfoListRequest, TaxInfoListResponse> getListService, Service<SaveTaxInfoRequest, SaveTaxInfoResponse> saveService) {
        super(getListService, new TaxInfoListRequest());
        setHandler(handler);

        this.saveService = saveService;

        initPojo();
    }

    @Override
    public void setPojo(Suggestion pojoC) {
        super.setPojo(pojoC);
        if (pojoC instanceof TaxInfo) {
            this.pojoC = (TaxInfo) pojoC;
        }
    }

    @Override
    public TaxInfo getPojo() {
        return pojoC;
    }

    @Override
    protected void initPojo() {
        pojoC = new TaxInfo();
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.addKey)) {
            showAddNewDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<TaxInfoListRequest, TaxInfoListResponse> so) {
        so.addAddNewItem();
    }

    private void showAddNewDialog() {
        final TaxInfoDialog dlg = new TaxInfoDialog(saveService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getTaxInfoC() != null && dlg.getTaxInfoC().getId() != null) {
                    suggestBox.setValue(dlg.getTaxInfoC().getReplacementString());
                    suggestBox.setFocus(true);
                    handler.itemSelected(dlg.getTaxInfoC());
                }
            }
        });
        dlg.center();
    }
}
