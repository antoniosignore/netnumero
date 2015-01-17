package com.numhero.server.utils.fx;

import com.numhero.client.model.datacargo.currency.ConversionBean;
import com.numhero.server.NumheroUtils;
import com.numhero.server.service.UrlConnectionClient;
import com.numhero.shared.enums.CurrencyEnum;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class YahooExchangeRateImport {
    private static final Logger log = Logger.getLogger(YahooExchangeRateImport.class.getName());

    private final static String SOURCE_CURRENCY = "_SRC_";
    private final static String DESTINATION_CURRENCY = "_DEST_";

    // Yahoo site to download exchange rate
    private final static String YAHOO_URL_PATTERN = "http://finance.yahoo.com/d/quotes.csv?s=_SRC__DEST_=X&f=sl1d1ba&e=.csv";

    private YahooExchangeRateImport() {
    }

    public static ConversionBean importExchangeRate(CurrencyEnum srcCurrency, CurrencyEnum destCurrency) throws ImportExportException {
        UrlConnectionClient urlConnectionClient = NumheroUtils.injector.getInstance(UrlConnectionClient.class);

        ConversionBean ret = null;
        YahooExchangeRateFilter filter = new YahooExchangeRateFilter();
        String URLString = constructURL(srcCurrency, destCurrency);

        try {
            HttpURLConnection connection = urlConnectionClient.getConnection(URLString);

            InputStream input = null;
            try {
                input = connection.getInputStream();
            } catch (IOException e) {
                log.warning("error in fetching the url " + URLString);
                throw new RuntimeException(e);

            }

            BufferedReader bufferedInput;
            String line;

            bufferedInput = new BufferedReader(new InputStreamReader(input));
            try {
                line = bufferedInput.readLine();
            } finally {
                bufferedInput.close();
            }

            try {
                ret = filter.toExchangeRate(line);
            } catch (Throwable e) {
                throw new IOException("ERROR_DOWNLOADING_QUOTES", e);
            }

        } catch (BindException e) {
            throw new ImportExportException("UNABLE_TO_CONNECT_ERROR :", e);
        } catch (ConnectException e) {
            throw new ImportExportException("UNABLE_TO_CONNECT_ERROR", e);
        } catch (UnknownHostException e) {
            throw new ImportExportException("UNKNOWN_HOST_ERROR" + e.getMessage());
        } catch (NoRouteToHostException e) {
            throw new ImportExportException("DESTINATION_UNREACHABLE_ERROR" + e.getMessage());
        } catch (FileNotFoundException e) {
            throw new ImportExportException("ERROR_DOWNLOADING_QUOTES");
        } catch (IOException e) {
            throw new ImportExportException("ERROR_DOWNLOADING_QUOTES");
        }
        return ret;
    }

    private static String constructURL(CurrencyEnum srcCurrency, CurrencyEnum destCurrency) {
        String URLString = YAHOO_URL_PATTERN;
        URLString = URLString.replaceFirst(SOURCE_CURRENCY, srcCurrency.name());
        URLString = URLString.replaceFirst(DESTINATION_CURRENCY, destCurrency.name());
        return URLString;
    }
}
