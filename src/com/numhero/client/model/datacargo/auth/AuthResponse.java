package com.numhero.client.model.datacargo.auth;

import com.numhero.shared.datacargo.CommandResponse;

import java.util.Date;

public class AuthResponse implements CommandResponse {
    private String sessionID;
    private Date expirationDate;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
