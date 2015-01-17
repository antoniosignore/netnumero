package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.StaffTypeEnum;
import com.numhero.shared.enums.TimeUnitEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class Staff extends SearchablePojo implements Suggestion {
    private static final long serialVersionUID = 4405160132870228493L;

    public EnumField<StaffTypeEnum> fStaffType = enumField("staffType", StaffTypeEnum.Internal);
    public IdField fUserId = idField("userId");
    public StringField fEmail = stringField("email", 120);
    public StringField fPhone = stringField("phone", 15);
    public StringField fFax = stringField("fax", 15);
    public StringField fMobile = stringField("mobile", 15);
    public StringField fAddress = stringField("address", 30);
    public StringField fCity = stringField("city", 30);
    public StringField fRegion = stringField("region", 30);
    public StringField fZipCode = stringField("zipCode", 30);
    public EnumField<CountryEnum> fCountry = enumField("country", CountryEnum.GB);
    public StringField fNotes = stringField("notes", 3000);
    public DoubleField fBillingRate = doubleField("billingRate");
    public EnumField<TimeUnitEnum> fTimeUnit = enumField("timeUnit", TimeUnitEnum.Day);

    public EnumField<CurrencyEnum> fCurrency = enumField("currency", CurrencyEnum.EUR);
    public DoubleField fValue = doubleField("value", 0D);
    public DateField fDate = dateField("date", new Date());
    public BooleanField fIsAdmin = booleanField("isAdmin", false);

    public StaffTypeEnum getStaffType() {
        return fStaffType.getValue();
    }

    public void setStaffType(StaffTypeEnum staffType) {
        fStaffType.setValue(staffType);
    }

    public String getEmail() {
        return fEmail.getValue();
    }

    public void setEmail(String email) {
        fEmail.setValue(email);
    }

    public String getPhone() {
        return fPhone.getValue();
    }

    public void setPhone(String contactPhone) {
        fPhone.setValue(contactPhone);
    }

    public String getMobile() {
        return fMobile.getValue();
    }

    public void setMobile(String contactPhone) {
        fMobile.setValue(contactPhone);
    }

    public String getFax() {
        return fFax.getValue();
    }

    public void setFax(String companyFax) {
        fFax.setValue(companyFax);
    }

    public String getAddress() {
        return fAddress.getValue();
    }

    public void setAddress(String address) {
        fAddress.setValue(address);
    }

    public String getCity() {
        return fCity.getValue();
    }

    public void setCity(String city) {
        fCity.setValue(city);
    }

    public String getRegion() {
        return fRegion.getValue();
    }

    public void setRegion(String region) {
        fRegion.setValue(region);
    }

    public String getZipCode() {
        return fZipCode.getValue();
    }

    public void setZipCode(String zipCode) {
        fZipCode.setValue(zipCode);
    }

    public String getNotes() {
        return fNotes.getValue();
    }

    public void setNotes(String notes) {
        fNotes.setValue(notes);
    }

    @Override
    public String getDisplayString() {
        return fName.getValue();
    }

    @Override
    public String getReplacementString() {
        return fName.getValue();
    }

    public Staff clone() {
        Staff ret = new Staff();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public String getKind() {
    	return fStaffType.getValue() == StaffTypeEnum.Contractor ? StaffTypeEnum.Contractor.name() : StaffTypeEnum.Internal.name();
    }
}
