package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.ReceiptStatusEnum;


public class ReceiptStaffStatusComboBox extends EnumComboBox<ReceiptStatusEnum> {
    public ReceiptStaffStatusComboBox() {
        super(ReceiptStatusEnum.class);
    }

    @Override
    protected void addAllItems() {
        addItem("-- ALL --");
        for (ReceiptStatusEnum e : ReceiptStatusEnum.values()) {
            addItem(e.toString());
        }
    }

    @Override
    public ReceiptStatusEnum getValue() {
        return ReceiptStatusEnum.getByDisplayValue(getStringValue());
    }

    @Override
    public void setValue(ReceiptStatusEnum e) {
        if (e != null) {
            super.setValue(e.toString());
        }
    }
}
