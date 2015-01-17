package com.numhero.server.utils.fx;

import com.numhero.client.model.datacargo.currency.ConversionBean;
import com.numhero.shared.enums.CurrencyEnum;

public class YahooExchangeRateFilter {

    public YahooExchangeRateFilter() {
        // Nothing to do
    }

    /**
     * Parse the given text string and return the exchange rate.
     *
     * @param line a single line of text containing the exchange rate
     * @return the exchange rate
     */
    public ConversionBean toExchangeRate(String line) {
        assert line != null;

        String[] parts = line.split(",");
        int i = 0;

        // Parse to/from currencies.

        // It's actually 6 but we ignore the other entries, as it makes sense to
        // try to be robust and not blow up if Yahoo adds or removes an entry.
        if (parts.length < 3)
            throw new IllegalArgumentException("WRONG_FIELD_COUNT");

        if (parts[i].length() != 10)
            throw new IllegalArgumentException("UNKNOWN_CURRENCY_CODE :" + parts[i]);

        CurrencyEnum srcCurrency = null;
        CurrencyEnum destCurrency = null;

        String srcCurrencyCode = parts[i].substring(1, 4); // "USDJPY=X" -> USD
        String destCurrencyCode = parts[i].substring(4, 7); // "USDJPY=X"-> JPY

        try {
            srcCurrency = CurrencyEnum.valueOf(srcCurrencyCode);
            destCurrency = CurrencyEnum.valueOf(destCurrencyCode);
        } catch (Exception e) {
            throw new IllegalArgumentException("UNKNOWN_CURRENCY_CODE :" + e.getMessage());
        }
        i++;

        // Parse exchange rate
        double exchangeRate = 0.0D;

        try {
            exchangeRate = Double.parseDouble(parts[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR_PARSING_NUMBER " + parts[i]);
        }

        ConversionBean ret = new ConversionBean();
        ret.setFromCurrency(srcCurrency);
        ret.setToCurrency(destCurrency);
        ret.setExchangeRate(exchangeRate);
        return ret;
    }
}
