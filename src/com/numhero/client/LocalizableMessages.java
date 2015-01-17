package com.numhero.client;


import com.google.gwt.i18n.client.Messages;

import java.util.Date;


public interface LocalizableMessages extends Messages {

    @DefaultMessage("''{0}'' is not a valid symbol.")
    String invalidSymbol(String symbol);

    @DefaultMessage("Last update: {0,date,medium} {0,time,medium}")
    String lastUpdate(Date timestamp);

    @DefaultMessage("{0,date,long} {0,time,short}")
    String currentDate(Date timestamp);

}