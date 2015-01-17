package com.numhero.shared.enums;

public enum TimeFormatEnum {

    hhmmssscolon("hh:mm:sss"),
    hhmmsssdash("hh-mm-sss");

    private String value;

    TimeFormatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value;
    }

    public static TimeFormatEnum getByValue(String value) {
        TimeFormatEnum[] a = TimeFormatEnum.values();
        for (int i = 0; i < a.length; i++) {
            TimeFormatEnum e = a[i];
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        return null;
    }
}
