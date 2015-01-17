package com.numhero.client.widget.combobox;

import com.numhero.shared.enums.UserRoleEnum;


public class UserProfileComboBox extends EnumComboBox<UserRoleEnum> {
    public UserProfileComboBox() {
        super(UserRoleEnum.class);
    }
}
