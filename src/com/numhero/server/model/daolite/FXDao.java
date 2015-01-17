package com.numhero.server.model.daolite;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.currency.ConversionBean;
import com.numhero.shared.enums.CurrencyEnum;

import java.util.logging.Logger;

import static com.numhero.server.utils.fx.YahooExchangeRateImport.importExchangeRate;

@Singleton
public class FXDao {
    private static final Logger log = Logger.getLogger(FXDao.class.getName());

    private MemcacheService memcache;

    public FXDao() {
        memcache = MemcacheServiceFactory.getMemcacheService("FX");
    }

    public Double get(String currencyExchangeID) {
        return (Double) memcache.get(currencyExchangeID);
    }

    public void save(String currencyID, Double value) {
        memcache.put(currencyID, value, Expiration.byDeltaSeconds(3600 * 24)); //  1 day
    }

    public void delete(String currencyExchangeID) {
        memcache.delete(currencyExchangeID);
    }

    public boolean isPresent(String currencyExchangeID) {
        return memcache.contains(currencyExchangeID);
    }

    public double convertToOtherCurrency(double amount, CurrencyEnum srcCurrency, CurrencyEnum destCurrency) {
        double rate = 1.0;
        if (srcCurrency != destCurrency) {
            rate = getExchangeRate(srcCurrency, destCurrency);
        }
        return amount * rate;
    }

    public double getExchangeRate(CurrencyEnum srcCurrency, CurrencyEnum destCurrency) {
        double rate;
        String fxSymbol = srcCurrency.name() + destCurrency.name();
        if (isPresent(fxSymbol)) {
            rate = get(fxSymbol).doubleValue();
        } else {
            rate = getExchangeRateFromSite(srcCurrency, destCurrency);
            save(fxSymbol, rate);
        }
        return rate;
    }

    private double getExchangeRateFromSite(CurrencyEnum srcCurrency, CurrencyEnum destCurrency) {
        log.info("getExchangeRateFromSite " + srcCurrency + " - " + destCurrency);
        double ret;
        try {
            ConversionBean rate = importExchangeRate(srcCurrency, destCurrency);
            log.info("rate = " + rate);
            ret = rate.getExchangeRate();
        }
        catch (Throwable throwable) {
            log.info("problem accessing Yahoo currency converter" + throwable.getMessage());
//                throw new ClientWarningException("cannotConvertInvoiceCurrencyIntoBaCurrency");
            // worst case cannot convert... return original value
            ret = 1.0;
        }
        return ret;
    }
}
