package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.currency.ConversionBean;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.server.model.daolite.FXDao;

public class CommandGetCurrencyConversion extends AbstractAuthenticatedCommand<GetCurrencyConversionRequest, GetCurrencyConversionResponse> {
    @Inject
    private FXDao fxDao;

    @Override
    public GetCurrencyConversionResponse execute(GetCurrencyConversionRequest request) throws Exception {
        GetCurrencyConversionResponse response = new GetCurrencyConversionResponse();
        response.setData(request.getData());

        for (String key : request.getData().keySet()) {
            ConversionBean cb = request.getData().get(key);

            Double exchangeRate = fxDao.getExchangeRate(cb.getFromCurrency(), cb.getToCurrency());
            log.info(cb.getFromCurrency() + " -> " + cb.getToCurrency() + ": " + exchangeRate);
            cb.setExchangeRate(exchangeRate);
        }
        return response;
    }
}
