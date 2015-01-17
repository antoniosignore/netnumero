package com.numhero.client.widget.combobox;

import com.google.gwt.user.client.ui.ListBox;

public class ComboBox extends ListBox {
    public ComboBox() {
        super(false);
    }

    public String getStringValue() {
        return getItemText(getSelectedIndex());
    }

    public void setValue(String value) {
        for (int i = 0; i < getItemCount(); i++) {
            if (getItemText(i).equals(value)) {
                setSelectedIndex(i);
                break;
            }
        }
    }
}
