package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.ColorSchemeEnum;


public class ColorComboBox extends EnumComboBox<ColorSchemeEnum> {
    public ColorComboBox() {
        super(ColorSchemeEnum.class);
    }

    @Override
    protected void addAllItems() {
        for (ColorSchemeEnum e : ColorSchemeEnum.values()) {
            addItem(e.toString());
        }
    }

    @Override
    public void setValue(ColorSchemeEnum e) {
        if (e != null) {
            super.setValue(e.toString());
        }
    }
}
