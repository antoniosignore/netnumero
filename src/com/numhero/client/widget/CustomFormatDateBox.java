package com.numhero.client.widget;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.datepicker.client.DateBox;

public class CustomFormatDateBox extends DateBox implements Focusable {
    public CustomFormatDateBox() {
        DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
        setFormat(new DateBox.DefaultFormat(dateFormat));
    }
}
