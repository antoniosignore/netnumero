package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class ClientSelect extends DropDownBox<ClientListRequest, ClientSupplierListResponse> {

    private Service<SaveClientSupplierRequest, SaveSingleEntityResponse> saveService;
    private ClientSupplier pojo;

    public ClientSelect(
            DropDownBoxHandler handler,
            Service<ClientListRequest, ClientSupplierListResponse> getListService,
            Service<SaveClientSupplierRequest, SaveSingleEntityResponse> saveService) {
        super(getListService, new ClientListRequest());
        setHandler(handler);
        this.saveService = saveService;
        initPojo();
    }

    public void setClientSupplier(Long clientSupplierId, String companyName) {
        pojo.setId(clientSupplierId);
        pojo.fName.setValue(companyName);
        suggestBox.setValue(companyName, false);
    }

    @Override
    public void setPojo(Suggestion searchablePojo) {
        super.setPojo(searchablePojo);
        if (searchablePojo instanceof ClientSupplier) {
            this.pojo = (ClientSupplier) searchablePojo;
        }
    }

    @Override
    public ClientSupplier getPojo() {
        return pojo;
    }

    @Override
    protected void initPojo() {
        pojo = new ClientSupplier();
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.addKey)) {
            showAddNewDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<ClientListRequest, ClientSupplierListResponse> so) {
        so.addAddNewItem();
        so.addMoreItem();
    }

    private void showAddNewDialog() {
        ClientSupplier pojo = new ClientSupplier();
        if (ClientCache.getCurrentBA() != null) {
            pojo.fCountry.setValue(ClientCache.getCurrentBA().fCountry.getValue());
        }
        pojo.fName.setValue(sso.getLastSuggestRequest());
        pojo.fClient.setValue(true);
        pojo.fSupplier.setValue(false);
        final ClientSupplierDialog dlg = new ClientSupplierDialog(saveService, pojo);
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().getReplacementString());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchClientDialog dlg = new SearchClientDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
