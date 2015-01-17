package com.numhero.server.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StringUtils {
    public static final NumberFormat numberFormatter = NumberFormat.getInstance();
    public final static SimpleDateFormat dateFormatter = new SimpleDateFormat();

    static {
        numberFormatter.setGroupingUsed(true);
        numberFormatter.setMinimumFractionDigits(2);
        numberFormatter.setMaximumFractionDigits(2);
        dateFormatter.applyPattern("MMM dd, yyyy");
    }

    public static int strToIntDef(String strValue, int defValue) {
        Integer r = null;
        try {
            r = Integer.valueOf(strValue);
        } catch (NumberFormatException e) {
            return defValue;
        }
        return r;

    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T strToEnumDef(String strValue, T defValue) {
        T ret = null;
        try {
            ret = T.valueOf((Class<T>) defValue.getClass(), strValue);
        } catch (Exception e) {
            return defValue;
        }
        return ret;
    }

    public static String numToStr(double num) {
        return numberFormatter.format(num);
    }

    public static String dateToStr(Date date) {
        return dateFormatter.format(date);
    }

    public static String emptyIfNullStr(String s) {
        return s != null ? s : "";
    }

    public static List<String> splitString(String textToSplit) {
        String[] tokens= textToSplit.split(" ");

        return Arrays.asList(tokens);

    }
}
