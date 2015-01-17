package com.numhero.shared.pojoc.field;


import java.util.Date;

import static com.numhero.shared.util.SharedUtils.dateTimeToStr;
import static com.numhero.shared.util.SharedUtils.strToDate;

public class DateTimeField extends PojoCField<Date> {

	private static final long serialVersionUID = -3106610019702595611L;




	public DateTimeField(String name) {
        super(name);
    }

	public DateTimeField() {
	}

	@Override
	public String getValueAsString() {

		Date d = getValue();
		if (d == null)
			return null;
		String date = dateTimeToStr(d);

		return date;
	}



	@Override
	public void setValueAsString(String value) {

		setValue(strToDate(value));
	}


}
