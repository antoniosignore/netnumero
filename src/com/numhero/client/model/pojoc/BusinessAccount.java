package com.numhero.client.model.pojoc;

import com.numhero.client.ClientCache;
import com.numhero.shared.enums.*;
import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.field.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BusinessAccount extends BAPojo {
    private static final int DEFAULT_CURRENCIES_LIST_SIZE = 10;

    private static final long serialVersionUID = -1558288185522119402L;

    // company info
    public StringField fVat = stringField("vat", 20);
    public EnumField<DateFormatEnum> fDateFormat = enumField("dateFormat", DateFormatEnum.ddmmyyyydash);
    public EnumField<TimeFormatEnum> fTimeFormat = enumField("timeFormat", TimeFormatEnum.hhmmssscolon);
    public StringField fTaxes = stringField("taxes", 120);
    public EnumField<PaymentMethodEnum> fPaymentMethod = enumField("paymentMethod", PaymentMethodEnum.INVOICE);
    public BlobField fCompanyLogo = blobField("companyLogo");
    public BlobField fCompanyLogoThumb = blobField("companyLogoThumb");

    // contact info
    public StringField fEmail = stringField("email", 120);
    public StringField fWeb = stringField("web", 120);
    public StringField fPhone = stringField("phone", 15);
    public StringField fFax = stringField("fax", 15);

    // address info
    public StringField fAddress = stringField("address", 30);
    public StringField fCity = stringField("city", 30);
    public StringField fRegion = stringField("region", 30);
    public StringField fZipCode = stringField("zipCode", 30);
    public EnumField<CountryEnum> fCountry = enumField("country", CountryEnum.GB);

    // invoices settings
    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public StringField fDefaultCurrencies = stringField("defaultCurrencies", "EUR,USD,GBP,AUD,RON", 50);
    public StringField fPrefix = stringField("prefix", 20);
    // last ID used, not the ID of last invoice
    public LongField fLastInvoiceID = longField("lastInvoiceID");
    public LongField fLastEstimateID = longField("lastEstimateID");
    public LongField fDefaultDaysDue = longField("defaultDaysDue");
    public StringField fTermsConditions = stringField("termsConditions", 500);
    public EnumField<ColorSchemeEnum> fInvoiceColor = enumField("invoiceColorScheme", ColorSchemeEnum.Blue);

    // global counters for dashboard
    public DateField fLastUpdateRecaps = dateField("lastUpdate", new Date());
    public DoubleField fYearCost = doubleField("yearCost", 0D);
    public DoubleField fYearProfit = doubleField("yearProfit", 0D);
    public DoubleField fYearTurnover = doubleField("yearTurnover", 0D);

    public DoubleField fMonthCost = doubleField("monthCost", 0D);
    public DoubleField fMonthProfit = doubleField("monthProfit", 0D);
    public DoubleField fMonthTurnover = doubleField("monthTurnover", 0D);

    public List<CurrencyEnum> getDefaultCurrencies() {
        List<CurrencyEnum> ret = new ArrayList<CurrencyEnum>();
        if (fDefaultCurrencies.getValue() == null) {
            fDefaultCurrencies.setValue("EUR,USD,GBP,AUD,RON");
        }
        String csv = ClientCache.getCurrentBA().fDefaultCurrencies.getValue();
        String[] codes = csv.split(",");
        for (String currencyCode : codes) {
            CurrencyEnum currency = CurrencyEnum.valueOf(currencyCode);
            ret.add(currency);
        }
        return ret;
    }

    public void setDefaultCurrencies(List<CurrencyEnum> currencies) {
        String value = "";
        for (Iterator<CurrencyEnum> itC = currencies.iterator(); itC.hasNext();) {
            CurrencyEnum currency = itC.next();
            value += currency.name();
            if (itC.hasNext()) {
                value += ",";
            }
        }
        fDefaultCurrencies.setValue(value);
    }

    /**
     * returns true if currency is added to the list - it was not already there
     *
     * @param currency
     * @return
     */
    public boolean addDefaultCurrency(CurrencyEnum currency) {
        List<CurrencyEnum> currencies = getDefaultCurrencies();
        int index = currencies.indexOf(currency);
        if (index != 0) {
            if (index > 0) {
                currencies.remove(index);
            } else if (currencies.size() == DEFAULT_CURRENCIES_LIST_SIZE) {
                currencies.remove(currencies.size() - 1);
            }
            currencies.add(0, currency);
            setDefaultCurrencies(currencies);
        }
        return index != 0;
    }
}
