package com.numhero.client.model.datacargo.currency;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.numhero.shared.enums.CurrencyEnum;

public class ConversionBean implements IsSerializable {
	private CurrencyEnum fromCurrency;
	private CurrencyEnum toCurrency;
	private double exchangeRate;

	public CurrencyEnum getFromCurrency() {
		return fromCurrency;
	}

	public String getKey() {
		return fromCurrency.name() + toCurrency.name();
	}

	public void setFromCurrency(CurrencyEnum fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public CurrencyEnum getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(CurrencyEnum toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
