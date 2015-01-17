package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.UserRoleEnum;
import com.numhero.shared.enums.UserStatusEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.OwnedListField;
import com.numhero.shared.pojoc.field.StringField;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class User extends SearchablePojo {
	private static final long serialVersionUID = 756393981094442645L;

    public StringField fFirstName = stringField("firstName", 30);
    public StringField fLastName = stringField("lastName", 30);
    public StringField fUserPortalId = stringField(USER_PORTAL_ID, 30);
    public DateField fLastLogin = dateField("lastLogin", null);
    public StringField fCountryCode = stringField("countryCode", 2);
    public StringField fEmail = stringField("email", 30);
    public StringField fVersion = stringField("version", 30);

    public EnumField<UserStatusEnum> fUserStatus = enumField("status", UserStatusEnum.ACTIVE);

    public OwnedListField<UserDetail> fBusinessAccountRoles = ownedListField("businessAccountRoles");
    public static final String USER_PORTAL_ID = "userPortalId";

    public String getFirstName() {
        return fFirstName.getValue();
    }

    public void setFirstName(String firstName) {
        fFirstName.setValue(firstName);
    }

    public String getLastName() {
        return fLastName.getValue();
    }

    public void setLastName(String lastName) {
        fLastName.setValue(lastName);
    }

    public Date getLastLogin() {
        return fLastLogin.getValue();
    }

    public void setLastLogin(Date lastLogin) {
        fLastLogin.setValue(lastLogin);
    }

    @Override
    public String getDisplayString() {
        return getFirstName() + " " + getLastName();   //maybe the email instead?
    }

    @Override
    public String getReplacementString() {
        return getDisplayString();
    }

    @Override
    public DetailBasePojo createNewDetail(String collectionName) {
        return new UserDetail();
    }

    public void addRelationToBa(String bAName, UserRoleEnum userRole) {
        UserDetail detail = new UserDetail();
        detail.fRelatedBAUri.setValue(bAName);
        detail.fRole.setValue(userRole);
        fBusinessAccountRoles.addDetail(detail);
    }

    public UserDetail getRelationToBa(String bAName) {
        for (UserDetail businessAccountRole : fBusinessAccountRoles) {
            if (businessAccountRole.fRelatedBAUri.getValue().equals(bAName)) {
                return businessAccountRole;
            }
        }
        throw new RuntimeException("Invalid ba " + bAName);
    }

    public boolean hasRelationToBa(String bAName) {
        for (UserDetail businessAccountRole : fBusinessAccountRoles) {
            if (businessAccountRole.fRelatedBAUri.getValue().equals(bAName)) {
                return true;
            }
        }
        return false;
    }

    public UserRoleEnum getUserProfile() {
        return getRelationToBa(fBusinessAccountUri.getValue()).fRole.getValue();
    }

    public Set<String> getBaUris() {
        Set<String> s = new HashSet<String>();
        for (UserDetail businessAccountRole : fBusinessAccountRoles) {
            s.add(businessAccountRole.fRelatedBAUri.getValue());
        }
        return s;
    }

    public User clone() {
        User ret = new User();
        ret.copyFrom(this);
        return ret;
    }
    
    @Override
    public String getKind() {
    	return "User";
    }
}
