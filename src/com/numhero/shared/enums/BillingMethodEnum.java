package com.numhero.shared.enums;

public enum BillingMethodEnum {

    FLAT_AMOUNT ("Flat Amount"),
    PROJECT_RATE("Project Rate"),
    STAFF_RATE("Staff Rate"),
    TASK_RATE("Task Rate");

    private String value;

    BillingMethodEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static BillingMethodEnum getByDisplayValue(String displayValue) {
        BillingMethodEnum[] a = BillingMethodEnum.values();
        for (int i = 0; i < a.length; i++) {
            BillingMethodEnum e = a[i];
            if (e.toString().equalsIgnoreCase(displayValue)) {
                return e;
            }
        }
        return null;
    }

}