package com.numhero.client.widget.combobox;

import com.google.gwt.user.client.ui.NetNumeroSuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.service.GetCurrenciesService;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;

public class CurrencySelect extends DropDownBox<ListCommandRequest, ListCommandResponse<CurrencyEnum>> {
    private CurrencyEnum pojo;
    private Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService;


    //todo Mikado remove one of the two constructors
    public CurrencySelect() {
        this(new Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>>(Application.injector.getAsyncService()),
             new Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse>(Application.injector.getAsyncService()));
    }

    public CurrencySelect(Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService,
                          Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        super(getCurrenciesService, new ListCommandRequest());
        this.businessAccountSaveService = businessAccountSaveService;
        suggestBox.setScrollLimit(NetNumeroSuggestBox.DEFAULT_LIMIT + 1);
        sso.setUseCache(false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        ((GetCurrenciesService) getListService).setReturnAllCurrencies(false);
        super.setPojo(pojo);
        this.pojo = (CurrencyEnum) pojo;
    }

    @Override
    public CurrencyEnum getPojo() {
        return pojo;
    }

    @Override
    protected void initPojo() {
        ((GetCurrenciesService) getListService).setReturnAllCurrencies(false);
        if (pojo == null && ClientCache.getCurrentBA() != null) {
            pojo = ClientCache.getCurrentBA().fCurrency.getValue();
        }
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            ((GetCurrenciesService) getListService).setReturnAllCurrencies(true);
            suggestBox.showSuggestionList(true);
        }
    }

    @Override
    protected void itemSelected() {
        if (ClientCache.getCurrentBA() != null && ClientCache.getCurrentBA().addDefaultCurrency(getPojo())) {
            SaveBusinessAccountRequest request = new SaveBusinessAccountRequest();
            request.setBusinessAccount(ClientCache.getCurrentBA());
            businessAccountSaveService.execute(request, new ServiceCallbackImpl<SaveBusinessAccountResponse>() {
                @Override
                public void onSuccess(SaveBusinessAccountResponse response) {
                    Application.toasterMessage(Application.getConstants().defaultCurrenciesSaved());
                }
            });
        }
        super.itemSelected();
    }

    protected ServerSuggestOracle<ListCommandRequest, ListCommandResponse<CurrencyEnum>> createSuggestOracle(
            Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getListService,
            ListCommandRequest request) {

        ServerSuggestOracle<ListCommandRequest, ListCommandResponse<CurrencyEnum>> ret = new ServerSuggestOracle<ListCommandRequest, ListCommandResponse<CurrencyEnum>>(getListService, request) {
            protected boolean showMore(com.numhero.shared.datacargo.ListCommandResponse<CurrencyEnum> response) {
                return !((GetCurrenciesService) CurrencySelect.this.getListService).isReturnAllCurrencies();
            }

        };
        return ret;
    }

    protected void addCommandItems(ServerSuggestOracle<ListCommandRequest, ListCommandResponse<CurrencyEnum>> so) {
        so.addMoreItem();
    }
}
