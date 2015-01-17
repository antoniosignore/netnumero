package com.numhero.client.model.datacargo.businessaccount;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveBusinessAccountRequest extends SaveSingleEntityRequest {

    public SaveBusinessAccountRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveBusinessAccount);
    }

    public BusinessAccount getBusinessAccount() {
        return (BusinessAccount) getEntity();
    }

    public void setBusinessAccount(BusinessAccount baC) {
        setEntity(baC);
    }

}
