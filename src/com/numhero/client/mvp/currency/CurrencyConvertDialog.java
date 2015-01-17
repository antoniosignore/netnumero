package com.numhero.client.mvp.currency;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

import java.util.List;

public class CurrencyConvertDialog extends DialogBox {
    private CurrencyConvertPanel panel;
    private List<CurrencyConvertBean> toConvert;
    private Service<GetCurrencyConversionRequest,GetCurrencyConversionResponse> conversionService;

    public CurrencyConvertDialog(List<CurrencyConvertBean> toConvert, Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService) {
    	this.toConvert = toConvert;
        this.conversionService = conversionService;

        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);
        setText(Application.getConstants().exchangeRatesTitle());

        panel = new CurrencyConvertPanel(toConvert);
        panel.getBtClose().getAnchor().setEnabled(false);
        panel.getBtClose().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CurrencyConvertDialog.this.hide();
            }
        });
        setWidget(panel);

        initExchangeRates();
    }

    private void initExchangeRates() {
        GetCurrencyConversionRequest request = new GetCurrencyConversionRequest();
        request.setBusinessAccountId(ClientCache.getCurrentBA().fBusinessAccountUri.getValue());
        for (CurrencyConvertBean ccb : toConvert) {
        	request.addConversionRequest(ccb.getFromCurrency(), ccb.getToCurrency());
		}
        conversionService.execute(request, new ServiceCallbackImpl<GetCurrencyConversionResponse>() {
            @Override
            public void onSuccess(GetCurrencyConversionResponse response) {
                for (CurrencyConvertBean ccb : toConvert) {
                    String key = ccb.getFromCurrency().name() + ccb.getToCurrency().name();
                    if (response.getData().containsKey(key)) {
                        ccb.setExchangeRate(response.getData().get(key).getExchangeRate());
                        if (ccb.getToAmount() == 0) {
                            ccb.setToAmount(ccb.getFromAmount() * ccb.getExchangeRate());
                        }
                    }
                }

                panel.getCct().setData(toConvert);
                panel.getBtClose().getAnchor().setEnabled(true);
            }
        });
    }

    public List<CurrencyConvertBean> getToConvert() {
		return toConvert;
	}
}
