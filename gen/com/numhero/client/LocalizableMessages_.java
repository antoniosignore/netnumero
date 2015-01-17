package com.numhero.client;

public class LocalizableMessages_ implements com.numhero.client.LocalizableMessages {
  
  public java.lang.String invalidSymbol(java.lang.String arg0) {
    return "'" + arg0 + "' is not a valid symbol.";
  }
  
  public java.lang.String currentDate(java.util.Date arg0) {
    return com.google.gwt.i18n.client.DateTimeFormat.getLongDateFormat().format(arg0) + " " + com.google.gwt.i18n.client.DateTimeFormat.getShortTimeFormat().format(arg0);
  }
  
  public java.lang.String lastUpdate(java.util.Date arg0) {
    return "Last update: " + com.google.gwt.i18n.client.DateTimeFormat.getMediumDateFormat().format(arg0) + " " + com.google.gwt.i18n.client.DateTimeFormat.getMediumTimeFormat().format(arg0);
  }
}
