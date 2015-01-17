package com.numhero.client.service;

import com.google.inject.Singleton;
import com.numhero.client.ClientCache;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GetCurrenciesService extends Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> {
    private boolean returnAllCurrencies;

    public GetCurrenciesService() {
        super(null);
    }

    public void setReturnAllCurrencies(boolean returnAllCurrencies) {
        this.returnAllCurrencies = returnAllCurrencies;
    }

    public boolean isReturnAllCurrencies() {
        return returnAllCurrencies;
    }

    @Override
    public void execute(ListCommandRequest request, ServiceCallback<ListCommandResponse<CurrencyEnum>> serviceCallback) {
        ListCommandResponse<CurrencyEnum> response = new ListCommandResponse<CurrencyEnum>();
        List<CurrencyEnum> currencies = new ArrayList<CurrencyEnum>();
        boolean requestStar = request.getStartingKey().equals("*");
        request.setStartingKey(request.getStartingKey().toUpperCase());
        if (!returnAllCurrencies && ClientCache.getCurrentBA() != null && requestStar) {
            currencies = ClientCache.getCurrentBA().getDefaultCurrencies();
        }

        if (currencies.isEmpty()) {
            for (CurrencyEnum currency : CurrencyEnum.values()) {
                if (requestStar || (currency.name().startsWith(request.getStartingKey()) || currency.getCountry().startsWith(request.getStartingKey()))) {
                    currencies.add(currency);
                }
            }
        }

        response.setEntityList(currencies);
        serviceCallback.onSuccess(response);
    }
}
