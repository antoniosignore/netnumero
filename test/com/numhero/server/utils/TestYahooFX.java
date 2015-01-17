package com.numhero.server.utils;

import com.numhero.client.model.datacargo.currency.ConversionBean;
import com.numhero.server.utils.fx.YahooExchangeRateImport;
import com.numhero.shared.enums.CurrencyEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestYahooFX {


    @Test
    public void testYahooXRate() throws Throwable {
        CurrencyEnum EUR = CurrencyEnum.EUR;
        CurrencyEnum USD = CurrencyEnum.USD;
        CurrencyEnum GBP = CurrencyEnum.GBP;

        ConversionBean rateEURUSD = YahooExchangeRateImport.importExchangeRate(EUR, USD);
        ConversionBean rateGBPUSD = YahooExchangeRateImport.importExchangeRate(GBP, USD);
        ConversionBean rateUSDEUR = YahooExchangeRateImport.importExchangeRate(USD, EUR);
        ConversionBean rateUSDGBP = YahooExchangeRateImport.importExchangeRate(USD, GBP);
        ConversionBean rateEURGBP = YahooExchangeRateImport.importExchangeRate(EUR, GBP);

        System.out.println("EUR = " + rateEURUSD.getExchangeRate());
        System.out.println("GBP = " + rateGBPUSD.getExchangeRate());

        Double hundred = 100D;

        System.out.println("hundred * rateEURUSD.getRate() = " + hundred * rateEURUSD.getExchangeRate());
        System.out.println("hundred * rateGBPUSD.getRate() = " + hundred * rateGBPUSD.getExchangeRate());

        System.out.println("EUR ==> GBP = " + hundred * rateEURUSD.getExchangeRate() * rateUSDGBP.getExchangeRate());
        System.out.println("EUR ==> GBP = " + hundred * rateEURGBP.getExchangeRate());

        System.out.println("EUR ==> GBP = " + getExchange(hundred, CurrencyEnum.EUR, CurrencyEnum.GBP));
        System.out.println("EUR ==> USD = " + getExchange(hundred, CurrencyEnum.EUR, CurrencyEnum.USD));

        assertEquals(rateEURUSD.getExchangeRate(), 0.001, 1 / rateUSDEUR.getExchangeRate());
        assertEquals(rateEURUSD.getExchangeRate() * rateUSDGBP.getExchangeRate(), 0.001, rateEURGBP.getExchangeRate());
    }

    public static Double getExchange(Double amount, CurrencyEnum fromFX, CurrencyEnum toFX) throws Throwable {
        ConversionBean rate = YahooExchangeRateImport.importExchangeRate(fromFX, toFX);
        return amount * rate.getExchangeRate();
    }
}
