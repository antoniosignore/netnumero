package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.UserRoleEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.field.BooleanField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.StringField;

public class UserDetail extends DetailBasePojo {
	private static final long serialVersionUID = -1671636382134790143L;

	public StringField fRelatedBAUri = stringField("relatedBAUri", 60);
    public BooleanField fLastUsed = booleanField("lastUsed");
    public EnumField<UserRoleEnum> fRole = enumField("role", UserRoleEnum.free);
}
