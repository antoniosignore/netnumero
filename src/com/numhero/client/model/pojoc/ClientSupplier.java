package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.pojoc.DetailBasePojo;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class ClientSupplier extends SearchablePojo implements Suggestion, LedgerAccountIF {
    private static final long serialVersionUID = -5841440363020220285L;

    public StringField fVat = stringField("vat", 20);
    public BooleanField fClient = booleanField("client");
    public BooleanField fSupplier = booleanField("supplier");
    public StringField fCompanyEmail = stringField("companyEmail", 120);
    public StringField fCompanyPhone = stringField("companyPhone", 15);
    public StringField fCompanyFax = stringField("companyFax", 15);
    public StringField fNotes = stringField("notes", 3000);

    public StringField fAddress = stringField("address", 30);
    public StringField fZipCode = stringField("zipCode", 30);
    public StringField fCity = stringField("city", 30);
    public StringField fRegion = stringField("region", 30);
    public EnumField<CountryEnum> fCountry = enumField("country", CountryEnum.GB);

    public StringField fContactName = stringField("contactName", 30);
    public StringField fContactEmail = stringField("contactEmail", 120);
    public StringField fContactPhone = stringField("contactPhone", 15);
    public StringField fContactMobile = stringField("contactMobile", 15);

    private OwnedListField<ClientSupplierContact> fContacts = ownedListField("contacts");

    public DoubleField fLedgerAccountBalanceValue = doubleField("ledgerAccountBalanceValue");
    public DateField fLedgerAccountBalanceDate = dateField("ledgerAccountBalanceDate", new Date());

    @Override
    public Double getBalance() {
        return fLedgerAccountBalanceValue.getValue();
    }

    @Override
    public Date getBalanceDate() {
        return fLedgerAccountBalanceDate.getValue();
    }

    @Override
    public DetailBasePojo createNewDetail(String collectionName) {
        return new ClientSupplierContact();
    }

    public String getCompleteAddress() {
        String ret;
        ret = fAddress.getValue() == null ? "" : fAddress.getValue() + " ";
        if (fZipCode.getValue() != null && fZipCode.getValue().length() > 0) {
            ret += fZipCode.getValue() + ", ";
        }
        if (fCity.getValue() != null && fCity.getValue().length() > 0) {
            ret += fCity.getValue() + ", ";
        }
        if (fCountry.getValue() != null) {
            ret += fCountry.getValue();
        }
        return ret;
    }

    public String getContactDesc() {
        String ret = fContactName.getValue() == null ? "" : fContactName.getValue();
        if (fContactEmail.getValue() != null && fContactEmail.getValue().length() > 0) {
            ret += ", " + fContactEmail.getValue();
        }
        if (fContactMobile.getValue() != null && fContactMobile.getValue().length() > 0) {
            ret += ", " + fContactMobile.getValue();
        }
        return ret;
    }

    public ClientSupplier clone() {
        ClientSupplier ret = new ClientSupplier();
        ret.copyFrom(this);
        return ret;
    }

    @Override
    public AccountingGroupEnum getAccountingGroup() {
        return AccountingGroupEnum.Asset;
    }

    @Override
    public AccountClassEnum getAccountClass() {
        return AccountClassEnum.ClientSupplier;
    }

    @Override
    public Boolean isPersonalLedger() {
        return true;
    }

    @Override
    public String getKind() {
    	return fClient.getValue() ? "Client" : "Supplier";
    }
}
