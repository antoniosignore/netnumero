package com.numhero.shared.pojoc.field;

import java.util.Date;

import static com.numhero.shared.util.SharedUtils.strToDate;

@SuppressWarnings({"deprecation"})   //they are not deprecated on gwt Date
public class DateField extends PojoCField<Date> {

    public DateField(String name) {
        super(name);
    }

    public DateField() {
    }

    @Override
    public void setValueAsString(String value) {
        setValue(strToDate(value));
    }

    @Override
    public String getValueAsString() {
        if (getValue() == null){
            return "";
        }
//TODO uberto user better date library
        String date = (getValue().getDay() + 1) + "/" + (getValue().getMonth() + 1) + "/" + (1900 + getValue().getYear());
        return date;
    }
}
