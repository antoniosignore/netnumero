package com.numhero.client.model.datacargo.currency;

import com.numhero.shared.datacargo.CommandResponse;

import java.util.Map;

public class GetCurrencyConversionResponse implements CommandResponse {
    private Map<String, ConversionBean> data;

    public void setData(Map<String, ConversionBean> data) {
		this.data = data;
	}

    public Map<String, ConversionBean> getData() {
		return data;
	}
}
