package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.InvoiceStatusEnum;


public class ReceiptClientStatusComboBox extends EnumComboBox<InvoiceStatusEnum> {
    public ReceiptClientStatusComboBox() {
        super(InvoiceStatusEnum.class);
    }

    @Override
    protected void addAllItems() {
        addItem("-- ALL --");
        for (InvoiceStatusEnum e : InvoiceStatusEnum.values()) {
            if (e == InvoiceStatusEnum.Billed ||
                    e == InvoiceStatusEnum.Unbilled)
                addItem(e.toString());
        }
    }

    @Override
    public InvoiceStatusEnum getValue() {
        String s = getStringValue();
        if (s.equalsIgnoreCase(InvoiceStatusEnum.Billed.toString()))
            return InvoiceStatusEnum.Billed;
        return InvoiceStatusEnum.Unbilled;

    }

    @Override
    public void setValue(InvoiceStatusEnum e) {
        if (e != null) {
            super.setValue(e.toString());
        }
    }
}
