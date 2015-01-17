package com.numhero.client.mvp.currency;

import com.numhero.shared.enums.CurrencyEnum;

public class CurrencyConvertBean {
	private double fromAmount;
	private CurrencyEnum fromCurrency;
	private double exchangeRate;
	private double toAmount;
	private CurrencyEnum toCurrency;

	public double getFromAmount() {
		return fromAmount;
	}

	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}

	public CurrencyEnum getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(CurrencyEnum fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getToAmount() {
		return toAmount;
	}

	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}

	public CurrencyEnum getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(CurrencyEnum toCurrency) {
		this.toCurrency = toCurrency;
	}
}
