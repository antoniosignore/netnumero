package com.numhero.shared.enums;

public enum DateFormatEnum {

    ddmmyyyycolon("dd:mm:yyyy"),
    ddmmyyyydash("dd-mm-yyyy"),
    ddmmyyyyslash("dd/mm/yyyy");

    private String value;

    DateFormatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value;
    }

    public static DateFormatEnum getByValue(String value) {
        DateFormatEnum[] a = DateFormatEnum.values();
        for (int i = 0; i < a.length; i++) {
            DateFormatEnum e = a[i];
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        return null;
    }
}