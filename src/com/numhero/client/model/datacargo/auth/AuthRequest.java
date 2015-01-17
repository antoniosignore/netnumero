package com.numhero.client.model.datacargo.auth;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class AuthRequest extends CommandRequest {
    private String username;
    private String password;
    private String httpSessionID;

    public AuthRequest() {
        setCommand(ApplicationCommandEnum.CommandLogin);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHttpSessionID() {
        return httpSessionID;
    }

    public void setHttpSessionID(String httpSessionID) {
        this.httpSessionID = httpSessionID;
    }
}
