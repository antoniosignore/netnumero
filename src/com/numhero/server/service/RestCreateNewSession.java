package com.numhero.server.service;

import com.google.inject.Inject;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Session;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.util.LocationUtils;
import com.numhero.server.NumheroUtils;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.server.utils.XmlResponseParser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

public class RestCreateNewSession {
    @Inject
    protected UserDao userDao;
    @Inject
    protected SessionDao sessionDao;
    @Inject
    protected BusinessAccountDao baDao;
    @Inject
    protected OneWayEncryptionService oneWayEncryption;
    @Inject
    protected UrlConnectionClient urlConnectionClient;
    @Inject
    protected CompanyBuilder companyBuilder;

    private static final Logger log = Logger.getLogger(RestCreateNewSession.class.getName());


    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userId = request.getParameter("userId");
        String userVersion = request.getParameter("userVersion");
        String hash = request.getParameter("hash");
        String requestId = request.getParameter("requestId");
        log.fine("userId " + userId);
        log.fine("userVersion " + userVersion);
        log.fine("hash " + hash);
        log.fine("requestId " + requestId);

        if (userId != null && userVersion != null && hash != null && requestId != null) {

            response.setContentType("text/xml");

            User u = askForUserIfNecessary(userId, userVersion, requestId);
            if (u != null) {
                if (!isValidHash(u, requestId, hash)) {
                    log.info("hash is not valid Calling IP:" + request.getRemoteAddr());

                    response.sendError(403, "Provided hash is not valid. This request is traced.");
                } else {
                    String sid = NumheroUtils.createRandomSessionId();
                    log.info("creating sessionId " + sid);
                    saveSession(sid, u);
                    Cookie sessionCookie = NumheroUtils.createCookie(sid);
                    log.fine("created cookie " + sessionCookie);

                    String newUrl = "/company/" + u.fBusinessAccountUri.getValue() + "#dashboard";
                    response.addCookie(sessionCookie);
                    response.sendRedirect(response.encodeRedirectURL(newUrl));
                }
            } else {
                log.info("user not existing on the portal");
                response.sendError(400);
            }

        } else {
            log.info("not all parameters are present! userId:" + userId + " userVersion:" + userVersion + " hash:" + hash + " requestId:" + requestId);
            response.sendError(400);
        }
    }

    private boolean isValidHash(User u, String requestId, String hash) {
        String correctHash = createSaltedHash(u, requestId);
        boolean ret = correctHash.equals(hash);
        if (!ret) {
            log.fine("calculated hash:" + correctHash + " user hash:" + hash);

            // System.err.println("------expected hash:  " + correctHash);
        }
        return ret;

    }

    public String createSaltedHash(User u, String requestId) {
        String salt = "NetNumeroIsBeautifullySimple";
        String s = u.fUserPortalId.getValue() + requestId + u.fEmail.getValue() + salt;
        String correctHash = oneWayEncryption.hexMD5(s);

        log.fine("created correct hash " + correctHash + " for " + s);
        return correctHash;
    }

    private void saveSession(String sid, User user) {

        Session session = new Session(user.getId(), sid);
        sessionDao.save(session);
    }

    private User askForUserIfNecessary(String userId, String userVersion, String requestId) {

        log.fine("askForUserIfNecessary " + userId);

        User user = userDao.findByPortalUserId(userId);
        if (user == null || !userVersion.equals(user.fVersion.getValue())) {
            user = saveUserFromUrl(userId, requestId, userVersion);
        }
        return user;
    }

    private User saveUserFromUrl(String pUId, String requestId, String userVersion) {
        // TODO move the url to config file
        String urlString = LocationUtils.GET_USER_DATA_URL + "?userId=" + pUId + "&requestId=" + requestId;

        // System.err.println("-------------"+urlString);
        // prepare user
        User u;

        log.fine("askingForUser " + pUId + " to the url " + urlString);
        try {
            HttpURLConnection connection = urlConnectionClient.getConnection(urlString);

            InputStream is = null;
            try {
                is = connection.getInputStream();
            } catch (IOException e) {
                log.warning("error in fetching the url " + urlString);
                throw new RuntimeException(e);

            }
            try {
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    u = getOrCreateUserFromPUId(pUId);
                    XmlResponseParser.parseGetUserData(is, u);
                } else {
                    log.info("resp " + responseCode + " from " + urlString);
                    throw new RuntimeException("resp " + responseCode + " from " + urlString);
                }

            } finally {
                is.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        u.fVersion.setValue(userVersion);  //FIX for the bug on the portal version in xml

        log.fine("saving new version of User " + u.toString());
        userDao.save(u);

        for (String baName : u.getBaUris()) {
            createNewBAIfNotExist(baName, u);

        }
        return u;
    }

    private void createNewBAIfNotExist(String baName, User user) {

        BusinessAccount ba = baDao.getByUri(baName);

        if (ba == null) {
            companyBuilder.build(baName, user.fCountryCode.getValue(), user);
        }
    }

    private User getOrCreateUserFromPUId(String userId) {
        User u = userDao.findByPortalUserId(userId);
        if (u == null) {
            u = new User();
            u.fUserPortalId.setValue(userId);
        }
        return u;
    }
}
