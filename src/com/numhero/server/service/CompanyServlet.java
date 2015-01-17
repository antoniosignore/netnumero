package com.numhero.server.service;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Session;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.util.ClientUtils;
import com.numhero.client.util.LocationUtils;
import com.numhero.server.NumheroUtils;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.shared.enums.UserRoleEnum;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class CompanyServlet extends HttpServlet {
    private static final long serialVersionUID = -4549098676007117162L;

    private static Logger log = Logger.getLogger(CompanyServlet.class.getName());

    private OneWayEncryptionService encryptionService;
    private UserDao userDao;
    private BusinessAccountDao baDao;
    private SessionDao sessionDao;

    public static final String SAMPLE_COMPANY = "mycompany"; //lowercase
    private CompanyBuilder companyBuilder;
    public static final String GUESTUSER_PORTAL_ID = "-1";

    public CompanyServlet() {
        baDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
        userDao = NumheroUtils.injector.getInstance(UserDao.class);
        encryptionService = NumheroUtils.injector.getInstance(OneWayEncryptionService.class);
        sessionDao = NumheroUtils.injector.getInstance(SessionDao.class);
        companyBuilder = NumheroUtils.injector.getInstance(CompanyBuilder.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("received unexpected Post " + request.getRequestURI());
        response.sendError(404);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("received get " + request.getRequestURI());

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        String baId = ClientUtils.getCompanyNameFromUri(request.getRequestURI());

        log.info("baId = " + baId);


        String sessionId;
//		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Development) {
// we want it on prod as well
        if (SAMPLE_COMPANY.equalsIgnoreCase(baId)) {
            sessionId = createSessionIfNotPresent(response);
            log.info("default BA created cookie for sessionId " + sessionId);
        } else {
            sessionId = NumheroUtils.getSessionFromCookie(request);
        }

        String html;

        if (isValidCompany(baId, sessionId)) {
            html = startUpHtml();
            out.println(html);
        } else {
            log.info("not valid company. Redirect to " + LocationUtils.CUSTOMER_ACCOUNT_LOGIN_URL);
            response.sendRedirect(response.encodeRedirectURL(LocationUtils.CUSTOMER_ACCOUNT_LOGIN_URL));
            //html = errorPageHtml();
        }

        log.info("finish serving get " + request.getRequestURI());

    }

    private boolean isValidCompany(String baId, String sessionId) {
        log.fine("businessId:" + baId + " sessionId:" + sessionId);
        if (sessionId == null) {
            return false;
        }
        Session session = sessionDao.findBySessionID(sessionId);
        if (session == null) {
            log.severe("session not found! " + sessionId);
            return false;
        }
        if (baId != null) {
            BusinessAccount ba = baDao.getByUri(baId);

            if (ba != null) {

                User u = loadUserFromSession(session);
                log.fine("user:" + u.toString());
                if (u == null) {
                    log.severe("session not valid! " + sessionId);
                    return false;
                }
                if (u.hasRelationToBa(baId)) {
                    return true;
                } else {
                    log.severe("user not associated with company name! " + baId + "  " + u.toString());
                    return false;
                }

            } else {
                log.severe("company name not valid! " + baId);
                return false;
            }
        } else
            return false;

    }


    private User loadUserFromSession(Session session) {

        User user = userDao.get(session.getUserId());

        return user;
    }

    private String createSessionIfNotPresent(HttpServletResponse response) {
        String httpSessionID = NumheroUtils.createRandomSessionId();

        User user = getOrCreateGuestUser();
        getOrCreateBusinessAccount(SAMPLE_COMPANY, user);
        createDummySession(user, httpSessionID);
        Cookie sessionCookie = NumheroUtils.createCookie(httpSessionID);

        response.addCookie(sessionCookie);
        log.fine("created session Id " + httpSessionID);
        return httpSessionID;
    }


    private BusinessAccount getOrCreateBusinessAccount(String baId, User user) {
        log.info("CompanyServlet.getOrCreateBusinessAccount");
        BusinessAccount ba = baDao.getByUri(baId);
        if (ba == null) {
            companyBuilder.build(baId, user.fCountryCode.getValue(), user);
        }
        return ba;

    }

    private void createDummySession(User user, String httpSessionID) {
        Session session = new Session(user.getId(), httpSessionID);
        sessionDao.save(session);
    }

    protected User getOrCreateGuestUser() {


        log.info("CompanyServlet.getOrCreateGuestUser");

        User user = userDao.findByPortalUserId(GUESTUSER_PORTAL_ID);
        if (user == null) {
            user = createGuestUser();
            userDao.save(user);
        }

        return user;
    }

    protected User createGuestUser() {
        String baName = SAMPLE_COMPANY.toLowerCase();
        log.info("create new user for ba " + baName);

        User user;
        user = new User();
        user.fUserPortalId.setValue(GUESTUSER_PORTAL_ID);
        user.fFirstName.setValue("user");
        user.fLastName.setValue("guest");
        user.fEmail.setValue("user@mycompany.com");
        user.fCountryCode.setValue("GB");
        user.fBusinessAccountUri.setValue(baName);
        user.addRelationToBa(baName, UserRoleEnum.free);
        return user;
    }

    private String errorPageHtml() {
        return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" + "<html>\n" + "  <body>\n" + "    <h2>Authentication error</h2>" + "  </body>\n" + "</html>";
    }

    private String startUpHtml() {
        return "<!DOCTYPE HTML\">\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n"
                + "\n"
                + "    <meta name=\"gwt:property\" content=\"locale=en\">\n"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=8\">\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
                + "\t<link rel=\"stylesheet\" href=\"../../c/screen.css\" type=\"text/css\" media=\"screen\" title=\"Default Style\" charset=\"utf-8\" />\n"
                + "    <title>Net Numero - Business Bookkeeping</title>\n"
                + "    <script type=\"text/javascript\" language=\"javascript\" src=\"../../application/application.nocache.js\"></script>\n"
                + "    <script type=\"text/javascript\" language=\"javascript\" src=\"../../s/pdfobject_source.js\"></script>\n"
                + "  </head>\n"
                + "\n"
                + "  <body id=\"mainBody\"> <div id=\"beta-badge\"><img src=\"/i/beta.png\" /></div>\n"
                + "    <iframe src=\"javascript:''\" id=\"gwt-table-to-excel-target\" tabIndex='-2' style=\"position:absolute;width:0;height:0;border:0\"></iframe>"
                + "    <iframe src=\"javascript:''\" id=\"__gwt_historyFrame\" tabIndex='-1' style=\"position:absolute;width:0;height:0;border:0\"></iframe>\n"
                + "    \n"
                + "    <noscript>\n"
                + "      <div style=\"width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif\">\n"
                + "        Your web browser must have JavaScript enabled\n" + "        in order for this application to display correctly.\n" + "      </div>\n" + "    </noscript>\n" + "\n"
                + "    <div id=\"bgk-wrapper\"><div id=\"glasspanel_loading\" class=\"on\"><img src=\"../../i/common/ajax-loader.gif\" border=\"0\"/></div><div id=\"wrapper\"></div></div>\n" + "  </body>\n" + "</html>";
    }
}
