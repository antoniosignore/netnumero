package com.numhero.server.utils;

import com.numhero.shared.enums.CountryEnum;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalesUtils {

    public static ResourceBundle getBundle(CountryEnum countryCode) {

        switch (countryCode) {
            case DE:
                return ResourceBundle.getBundle("MessagesBundle", Locale.GERMANY);

            case IT:
                return ResourceBundle.getBundle("MessagesBundle", Locale.ITALY);

            case GB:
                return ResourceBundle.getBundle("MessagesBundle", Locale.UK);
        }
        return
                ResourceBundle.getBundle("MessagesBundle");
    }

}
