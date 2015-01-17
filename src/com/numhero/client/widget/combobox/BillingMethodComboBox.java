package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.BillingMethodEnum;


public class BillingMethodComboBox extends EnumComboBox<BillingMethodEnum> {
    public BillingMethodComboBox() {
        super(BillingMethodEnum.class);
    }

    @Override
    protected void addAllItems() {
        for (BillingMethodEnum e : BillingMethodEnum.values()) {
            addItem(e.toString());
        }
    }

    @Override
    public BillingMethodEnum getValue() {                          
        return BillingMethodEnum.getByDisplayValue(getStringValue());
    }

    @Override
    public void setValue(BillingMethodEnum e) {
        if (e != null) {
            super.setValue(e.toString());
        }
    }
}
