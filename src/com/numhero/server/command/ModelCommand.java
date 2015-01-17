package com.numhero.server.command;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

public interface ModelCommand<REQUEST extends CommandRequest, RESPONSE extends CommandResponse> {

    public void setBusinessAccount(BusinessAccount ba);

    public BusinessAccount getBusinessAccount();

    public void setUser(User user);

    public User getUser();

    public RESPONSE execute(REQUEST request) throws Exception;
}
