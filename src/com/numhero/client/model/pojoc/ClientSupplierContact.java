package com.numhero.client.model.pojoc;

import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.StringField;

public class ClientSupplierContact extends DetailBasePojo {
	private static final long serialVersionUID = 6174042751859896186L;

	public StringField fEmail = stringField("email", 120);
    public StringField fPhone = stringField("phone", 15);
    public StringField fMobile = stringField("mobile", 15);

    public String getCompleteDesc() {
    	String ret = fName.getValue() == null ? "" : fName.getValue() + ", ";
    	if (fEmail.getValue() != null) {
    		ret += fEmail.getValue() + ", ";
    	}
    	if (fPhone.getValue() != null) {
    		ret += fPhone.getValue();
    	}
    	return ret;
    }
}
