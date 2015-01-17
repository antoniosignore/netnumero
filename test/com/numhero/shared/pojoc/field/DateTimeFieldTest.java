package com.numhero.shared.pojoc.field;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class DateTimeFieldTest {

	@Test
	public void fromToString(){
		DateTimeField field = new DateTimeField("last_update");
		assertThat(field.getFieldName(), is("last_update"));

		assertThat(field.getValueAsString(), is(nullValue()));

		field.setValue(new Date(0));
		assertThat(field.getValueAsString(), is("1/1/1970 1:0:0.0")); //2000-02-01 00:00:00.0"
	}

}
