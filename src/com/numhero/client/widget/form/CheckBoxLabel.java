package com.numhero.client.widget.form;

import com.google.gwt.user.client.ui.Label;

public class CheckBoxLabel extends Label {
    private boolean selected;
    private String text;

    public CheckBoxLabel() {
		setHorizontalAlignment(ALIGN_RIGHT);
	}
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        setTextAndIcon();
    }

    @Override
    public void setText(String text) {
        this.text = text;
        setTextAndIcon();
    }

    private void setTextAndIcon() {
        if (selected) {
            getElement().setInnerHTML(
                    "<table border=0 cellpadding=0 cellspacing=0><tr><td class='form-item-label' style='border: none'>" + text + "</td><td>&nbsp;<img src='../i/common/16/check2.png' border=0></td></tr></table>");
        } else {
            getElement().setInnerHTML(text);
        }
    }
}
