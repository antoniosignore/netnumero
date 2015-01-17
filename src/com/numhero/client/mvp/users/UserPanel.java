package com.numhero.client.mvp.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.UserProfileComboBox;
import com.numhero.client.widget.combobox.UserStatusComboBox;
import com.numhero.shared.pojoc.EntityPojo;

public class UserPanel extends AbstractEditEntityPanel {

    interface UserPanelUiBinder extends UiBinder<Widget, UserPanel> {
    }

    private static UserPanelUiBinder uiBinder = GWT.create(UserPanelUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TextBox name;

    @UiField
    TextBox firstName;

    @UiField
    TextBox lastName;

    @UiField
    TextBox password;

    @UiField
    UserProfileComboBox userProfile;

    @UiField
    UserStatusComboBox userStatus;

    @UiField
    CustomFormatDateBox lastLogin;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    public UserPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        createValidator(errorsPanel);
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public User getUser() {
        return (User) pojo;
    }

    public boolean saveValuesFromUi() {
        boolean ret = validator.validate();
        if (ret) {
            User user = (User) pojo;
            user.setFirstName(firstName.getValue());
            user.setLastName(lastName.getValue());
            user.setLastLogin(lastLogin.getValue());
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);
        User user = (User) pojo;
        userProfile.setValue(user.getUserProfile());
        userStatus.setValue(user.fUserStatus.getValue());
        firstName.setValue(user.getFirstName());
        lastLogin.setValue(user.getLastLogin());
        lastName.setValue(user.getLastName());
    }

    @Override
    protected void addValidators() {
        // TODO add validators
    }

}
