package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.auth.AuthRequest;
import com.numhero.client.model.datacargo.auth.AuthResponse;
import com.numhero.client.model.pojoc.Session;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.auth.Authenticator;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.shared.exception.NotAuthorizedException;

import java.util.logging.Logger;

public class CommandLogin extends AbstractAuthenticatedCommand<AuthRequest, AuthResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandLogin.class.getName());

    @Inject
    Authenticator authenticator;

    @Inject
    OneWayEncryptionService oneWayEncryption;

    @Inject
    SessionDao sessionDao;

    @Override
    public AuthResponse execute(AuthRequest request) {
        AuthResponse response = new AuthResponse();
        try {
            String passwordHash = oneWayEncryption.hexMD5(request.getPassword());
            User user = authenticator.authenticate(request.getUsername(), passwordHash);
            // setup a new session
            Session session = new Session(user.getId(), request.getHttpSessionID());
            sessionDao.save(session);

            response.setSessionID(session.getSessionID());
        } catch (NotAuthorizedException ex) {
            log.severe("Error while processing credentials" + ex);
            throw ex;
        }
        return response;
    }
}
