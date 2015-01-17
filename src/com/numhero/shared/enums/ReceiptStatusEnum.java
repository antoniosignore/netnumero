package com.numhero.shared.enums;

public enum ReceiptStatusEnum {
    Presented("Presented"),
    Paid("Reimbursed"),
    Rejected("Rejected"),
    Archived("Archived");

    private String value;

    ReceiptStatusEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static ReceiptStatusEnum getByDisplayValue(String displayValue) {
        ReceiptStatusEnum[] a = ReceiptStatusEnum.values();
        for (int i = 0; i < a.length; i++) {
            ReceiptStatusEnum e = a[i];
            if (e.toString().equalsIgnoreCase(displayValue)) {
                return e;
            }
        }
        return null;
    }
}
