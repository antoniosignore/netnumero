package com.numhero.server.model;

import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.field.BlobField;

public class BlobPojo extends BAPojo {
	private static final long serialVersionUID = -2572370060001116079L;

	public BlobField fBlob = new BlobField();

    public BlobPojo() {
        fBlob.setFieldName("blob");
        fieldsList.put(fBlob.getFieldName(), fBlob);
    }
}
