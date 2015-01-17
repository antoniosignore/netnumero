package com.numhero.shared.enums;


public enum ColorSchemeEnum {
    Red("F51000"),
    Blue("2E46F6"),
    Orange("DD5521"),
    Green("00CC00"),
    Purple("990099");

    private final String hexCode;
    private final int intCode;

    private ColorSchemeEnum(String hexCode) {
        this.hexCode = hexCode;
        this.intCode = Integer.valueOf(hexCode, 16);
    }

    public int intColor() {
        return intCode;
    }

    public String hexCode() {
        return hexCode;
    }
}
