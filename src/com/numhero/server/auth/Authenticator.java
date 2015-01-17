package com.numhero.server.auth;

import com.numhero.client.model.pojoc.User;


public interface Authenticator {
    public User authenticate(String username, String passwordHash);
}
