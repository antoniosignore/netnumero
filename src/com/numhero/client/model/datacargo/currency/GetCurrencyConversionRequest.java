package com.numhero.client.model.datacargo.currency;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

import java.util.HashMap;
import java.util.Map;

public class GetCurrencyConversionRequest extends GetSingleEntityRequest {
    private Map<String, ConversionBean> data = new HashMap<String, ConversionBean>();

    public GetCurrencyConversionRequest() {
        setCommand(ApplicationCommandEnum.CommandGetCurrencyConversion);
    }

    public void addConversionRequest(CurrencyEnum fromCurrency, CurrencyEnum toCurrency) {
    	ConversionBean cb = new ConversionBean();
    	cb.setFromCurrency(fromCurrency);
    	cb.setToCurrency(toCurrency);
    	data.put(cb.getKey(), cb);
    }

    public Map<String, ConversionBean> getData() {
		return data;
	}
}
