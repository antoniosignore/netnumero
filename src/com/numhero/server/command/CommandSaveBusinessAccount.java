package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.UserDao;

import java.util.Date;
import java.util.logging.Logger;

public class CommandSaveBusinessAccount extends AbstractAuthenticatedCommand<SaveBusinessAccountRequest, SaveBusinessAccountResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveBusinessAccount.class.getName());

    @Inject
    public
    BusinessAccountDao businessAccountDao;

    @Inject
    public
    UserDao userDao;

    @Override
    public SaveBusinessAccountResponse execute(SaveBusinessAccountRequest request) {
        BusinessAccount businessAccount = (BusinessAccount) request.getEntity();

        log.fine("businessAccount : " + businessAccount);

        if (businessAccount.getId() != null){
            preserveBlobFields(businessAccount);
        }

        businessAccountDao.save(businessAccount);

        // Requirement #36 - setting finally the date of the first login where the Business details have been defined
        User user = this.getUser();
        if (user.getLastLogin() == null) {
            user.fLastLogin.setValue(new Date());
            userDao.save(user);
        }

        // createAudit
        SaveBusinessAccountResponse response = new SaveBusinessAccountResponse();
        response.setEntityId(businessAccount.getId());
        return response;
    }

    private void preserveBlobFields(BusinessAccount businessAccount) {
        BusinessAccount businessAccountFromDb = businessAccountDao.get(businessAccount.getId());
        if (businessAccountFromDb == null) {

            throw new RuntimeException("Null business account for id " + businessAccount.getId() +
                    " which was received from the client");
        } else {
            businessAccount.fCompanyLogo.setValue(businessAccountFromDb.fCompanyLogo.getValue());
            businessAccount.fCompanyLogoThumb.setValue(businessAccountFromDb.fCompanyLogoThumb.getValue());
        }
    }
}
