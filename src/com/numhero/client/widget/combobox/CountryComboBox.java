package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.CountryEnum;


public class CountryComboBox extends EnumComboBox<CountryEnum> {
    public CountryComboBox() {
        super(CountryEnum.class);
    }

    @Override
    protected void addAllItems() {
        for (CountryEnum e : CountryEnum.values()) {
            addItem(e.toString());
        }
    }

    @Override
    public CountryEnum getValue() {
        return CountryEnum.getByDisplayValue(getStringValue());
    }

    @Override
    public void setValue(CountryEnum e) {
        if (e != null) {
            super.setValue(e.toString());
        }
    }
}
