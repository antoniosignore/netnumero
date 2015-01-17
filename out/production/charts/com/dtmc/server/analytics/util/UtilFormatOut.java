// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilFormatOut.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.*;
import java.util.Currency;
import java.util.Locale;

// Referenced classes of package com.dtmc.server.analytics.util:
//            StringUtil

public class UtilFormatOut
{

    public UtilFormatOut()
    {
    }

    public static String safeToString(Object obj)
    {
        if(obj != null)
            return obj.toString();
        else
            return "";
    }

    public static String formatPrice(Double price)
    {
        if(price == null)
            return "";
        else
            return formatPrice(price.doubleValue());
    }

    public static String formatPrice(double price)
    {
        return priceDecimalFormat.format(price);
    }

    public static String formatCurrency(double price, String isoCode, Locale locale)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        if(isoCode != null && isoCode.length() > 1)
            nf.setCurrency(Currency.getInstance(isoCode));
        else
            System.out.println((new StringBuilder()).append("No isoCode specified to enformat currency value:").append(price).toString());
        return nf.format(price);
    }

    public static String formatCurrency(Double price, String isoCode, Locale locale)
    {
        return formatCurrency(price.doubleValue(), isoCode, locale);
    }

    public static String formatPercentage(Double percentage)
    {
        if(percentage == null)
            return "";
        else
            return formatPercentage(percentage.doubleValue());
    }

    public static String formatPercentage(double percentage)
    {
        return percentageDecimalFormat.format(percentage);
    }

    public static String formatQuantity(Long quantity)
    {
        if(quantity == null)
            return "";
        else
            return formatQuantity(quantity.doubleValue());
    }

    public static String formatQuantity(long quantity)
    {
        return formatQuantity(quantity);
    }

    public static String formatQuantity(Integer quantity)
    {
        if(quantity == null)
            return "";
        else
            return formatQuantity(quantity.doubleValue());
    }

    public static String formatQuantity(int quantity)
    {
        return formatQuantity(quantity);
    }

    public static String formatQuantity(Float quantity)
    {
        if(quantity == null)
            return "";
        else
            return formatQuantity(quantity.doubleValue());
    }

    public static String formatQuantity(float quantity)
    {
        return formatQuantity(quantity);
    }

    public static String formatQuantity(Double quantity)
    {
        if(quantity == null)
            return "";
        else
            return formatQuantity(quantity.doubleValue());
    }

    public static String formatQuantity(double quantity)
    {
        return quantityDecimalFormat.format(quantity);
    }

    public static String formatPaddedNumber(long number, int numericPadding)
    {
        StringBuffer outStrBfr;
        for(outStrBfr = new StringBuffer(Long.toString(number)); numericPadding > outStrBfr.length(); outStrBfr.insert(0, '0'));
        return outStrBfr.toString();
    }

    public static String formatPaddingRemove(String original)
    {
        if(original == null)
            return null;
        StringBuffer orgBuf;
        for(orgBuf = new StringBuffer(original); orgBuf.length() > 0 && orgBuf.charAt(0) == '0'; orgBuf.deleteCharAt(0));
        return orgBuf.toString();
    }

    public static String formatDate(Timestamp timestamp)
    {
        if(timestamp == null)
        {
            return "";
        } else
        {
            DateFormat df = DateFormat.getDateTimeInstance(1, 0);
            java.util.Date date = timestamp;
            return df.format(date);
        }
    }

    public static String makeString(Object obj1)
    {
        if(obj1 != null)
            return obj1.toString();
        else
            return "";
    }

    public static String checkNull(String string1)
    {
        if(string1 != null)
            return string1;
        else
            return "";
    }

    public static String checkNull(String string1, String string2)
    {
        if(string1 != null)
            return string1;
        if(string2 != null)
            return string2;
        else
            return "";
    }

    public static String checkNull(String string1, String string2, String string3)
    {
        if(string1 != null)
            return string1;
        if(string2 != null)
            return string2;
        if(string3 != null)
            return string3;
        else
            return "";
    }

    public static String checkNull(String string1, String string2, String string3, String string4)
    {
        if(string1 != null)
            return string1;
        if(string2 != null)
            return string2;
        if(string3 != null)
            return string3;
        if(string4 != null)
            return string4;
        else
            return "";
    }

    public static String ifNotEmpty(String base, String pre, String post)
    {
        if(base != null && base.length() > 0)
            return (new StringBuilder()).append(pre).append(base).append(post).toString();
        else
            return "";
    }

    public static String checkEmpty(String string1, String string2)
    {
        if(string1 != null && string1.length() > 0)
            return string1;
        if(string2 != null && string2.length() > 0)
            return string2;
        else
            return "";
    }

    public static String checkEmpty(String string1, String string2, String string3)
    {
        if(string1 != null && string1.length() > 0)
            return string1;
        if(string2 != null && string2.length() > 0)
            return string2;
        if(string3 != null && string3.length() > 0)
            return string3;
        else
            return "";
    }

    public static String encodeQuery(String query)
    {
        String retString = replaceString(query, "%", "%25");
        retString = replaceString(retString, " ", "%20");
        return retString;
    }

    public static String encodeQueryValue(String query)
    {
        String retString = replaceString(query, "%", "%25");
        retString = replaceString(retString, " ", "%20");
        retString = replaceString(retString, "&", "%26");
        retString = replaceString(retString, "?", "%3F");
        retString = replaceString(retString, "=", "%3D");
        return retString;
    }

    public static String replaceString(String mainString, String oldString, String newString)
    {
        return StringUtil.replaceString(mainString, oldString, newString);
    }

    public static String decodeQueryValue(String query)
    {
        String retString = replaceString(query, "%25", "%");
        retString = replaceString(retString, "%20", " ");
        retString = replaceString(retString, "%26", "&");
        retString = replaceString(retString, "%3F", "?");
        retString = replaceString(retString, "%3D", "=");
        return retString;
    }

    public static String encodeXmlValue(String inString)
    {
        String retString = inString;
        retString = StringUtil.replaceString(retString, "&", "&amp;");
        retString = StringUtil.replaceString(retString, "<", "&lt;");
        retString = StringUtil.replaceString(retString, ">", "&gt;");
        retString = StringUtil.replaceString(retString, "\"", "&quot;");
        retString = StringUtil.replaceString(retString, "'", "&apos;");
        return retString;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilFormatOut.getName();
    static DecimalFormat priceDecimalFormat = new DecimalFormat("#,##0.00");
    static DecimalFormat percentageDecimalFormat = new DecimalFormat("##0.##%");
    static DecimalFormat quantityDecimalFormat = new DecimalFormat("#,##0.###");

}
