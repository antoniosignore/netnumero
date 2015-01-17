package com.numhero.client.model.pojoc;

import javax.jdo.annotations.Persistent;
import java.io.Serializable;

/**
 * session info. Who is session owner and when did they log in,
 */

public class Session implements Serializable {
    private static final long serialVersionUID = -4293165462292442871L;

    @Persistent
    public Long userId;

    @Persistent
    public String sessionID;


    public Session(Long userId, String sessionID) {
        this.userId = userId;
        this.sessionID = sessionID;
    }

    public Long getUserId() {
        return userId;
    }

    public String getSessionID() {
        return sessionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (sessionID != null ? !sessionID.equals(session.sessionID) : session.sessionID != null) return false;
        if (userId != null ? !userId.equals(session.userId) : session.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (sessionID != null ? sessionID.hashCode() : 0);
        return result;
    }
}