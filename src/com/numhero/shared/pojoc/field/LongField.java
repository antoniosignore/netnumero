package com.numhero.shared.pojoc.field;

import static com.numhero.shared.util.SharedUtils.strToLong;

public class LongField  extends PojoCField<Long> {

    public LongField(String name) {
        super(name);
    }

	public LongField() {
	}

	@Override
    public void setValueAsString(String value) {
        setValue(strToLong(value));
    }


}
