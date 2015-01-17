package com.numhero.client.model.datacargo.businessaccount;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

public class GetBusinessAccountResponse extends GetSingleEntityResponse<BusinessAccount> {

    User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
