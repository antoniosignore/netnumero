package com.numhero.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class RowElement extends ComplexPanel {
    public RowElement() {
        setElement(DOM.createElement("LI"));
    }

    public void add(Widget w) {
        super.add(w, getElement());
    }

    public void insert(Widget w, int beforeIndex) {
        super.insert(w, getElement(), beforeIndex, true);
    }

    public String getText() {
        return DOM.getInnerText(getElement());
    }

    public void setText(String text) {
        DOM.setInnerText(getElement(), (text == null) ? "" : text);
    }
}
