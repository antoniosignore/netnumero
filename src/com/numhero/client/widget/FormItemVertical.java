package com.numhero.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

import java.util.Iterator;

public class FormItemVertical extends VerticalPanel implements ClickHandler {
    private Label lbTitle;
    private Widget wFocusable;

    private HandlerRegistration clickReg;

    public FormItemVertical() {
        setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
    }

    public FormItemVertical(String title, Widget w) {
        this();
        add(new Label(title));
        add(w);
    }

    @Override
    protected void onLoad() {
        for (Iterator<Widget> itW = iterator(); itW.hasNext();) {
            Widget w = itW.next();
            if (w instanceof Label) {
                lbTitle = (Label) w;
            } else if (w instanceof Focusable) {
                wFocusable = w;
            }
        }
        if (lbTitle != null && wFocusable != null) {
            lbTitle.setStylePrimaryName("formItemLabel");
            clickReg = lbTitle.addClickHandler(this);
        }
    }

    @Override
    protected void onUnload() {
        if (clickReg != null) {
            clickReg.removeHandler();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        ((Focusable) wFocusable).setFocus(true);
    }
}
