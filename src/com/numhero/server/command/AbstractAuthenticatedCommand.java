package com.numhero.server.command;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.logging.Logger;

public abstract class AbstractAuthenticatedCommand<REQUEST extends CommandRequest, RESPONSE extends CommandResponse> implements ModelCommand<REQUEST, RESPONSE> {

    protected static final Logger log = Logger.getLogger(AbstractAuthenticatedCommand.class.getName());

    private BusinessAccount ba;
    private User user;

    @Override
    public BusinessAccount getBusinessAccount() {
        return ba;
    }

    @Override
    public void setBusinessAccount(BusinessAccount ba) {
        this.ba = ba;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
