package com.numhero.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Session;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.exception.NotAuthorizedException;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public abstract class AuthenticatedService extends RemoteServiceServlet {
	private static final long serialVersionUID = 1432756766079190277L;
	private static final Logger log = Logger.getLogger(AuthenticatedService.class.getName());

	protected SessionDao sessionDao;
    protected UserDao userDao;
    protected BusinessAccountDao baDao;

    protected AuthenticatedService() {
        sessionDao = NumheroUtils.injector.getInstance(SessionDao.class);
        userDao = NumheroUtils.injector.getInstance(UserDao.class);
        baDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
    }

    protected User authenticateUser() throws NotAuthorizedException {

        HttpServletRequest httpRequest = getHttpRequest();
        String sessionIDFromClient = NumheroUtils.getSessionFromCookie(httpRequest);
        log.fine("sessionIDFromClient " + sessionIDFromClient);

        User ret;
        if (sessionIDFromClient == null) {
            throw new NotAuthorizedException("no session in the cookie!");
        } else {
            ret = loadUserFromSession(sessionIDFromClient);
        }

        return ret;
    }


    protected HttpServletRequest getHttpRequest() {
        return getThreadLocalRequest();
    }

    protected BusinessAccount getBusinessAccountFromRequest(CommandRequest
            request) {
        BusinessAccount ret = null;
        if (request == null || request.getBusinessAccountId() == null) {
            throw new NotAuthorizedException("BaId not present in the request!");
        } else {
            ret = getBusinessAccount(request.getBusinessAccountId());
        }
        return ret;
    }

    private User loadUserFromSession(String httpSessionID) {
        Session session = sessionDao.findBySessionID(httpSessionID);

        if (session == null)
            throw new NotAuthorizedException("invalid sessionID:" + httpSessionID);
        
        User user = userDao.get(session.getUserId());

        if (user == null) {
            throw new NotAuthorizedException("user not found! user.id:"+session.getUserId());
        }

        return user;
    }

    private BusinessAccount getBusinessAccount(String baId) {

        String baLower = baId.toLowerCase();
        log.info("baId.toLowerCase() = " + baLower);

        BusinessAccount ba = baDao.getByUri(baLower);



        if (ba == null) {
            throw new NotAuthorizedException("BusinessAccound not found! baUri:" + baLower);
        }

        return ba;
    }

}
