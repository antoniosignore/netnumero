package com.numhero.server.service;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Session;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.shared.util.SharedUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class ServeLogoServlet extends HttpServlet {
    private static final long serialVersionUID = 217903650215085532L;

    private static final Logger log = Logger.getLogger(ServeLogoServlet.class.getName());
    public static final String LOGO_PLACEHOLDER_PNG = "logo_placeholder.png";

    private SessionDao sessionDao;
    private BusinessAccountDao businessAccountDao;

    public ServeLogoServlet() {
        sessionDao = NumheroUtils.injector.getInstance(SessionDao.class);
        businessAccountDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // authenticate
        String sessionIDFromClient = NumheroUtils.getSessionFromCookie(request);
        log.fine("sessionIDFromClient " + sessionIDFromClient);

        Session session = null;
        if (sessionIDFromClient != null) {
            session = sessionDao.findBySessionID(sessionIDFromClient);
        }
        if (session == null) {
            log.fine("sessionIDFromClient null: SC_UNAUTHORIZED");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String uri = request.getRequestURI();
        if (uri.startsWith("/serveLogo/")) {
            String[] p = SharedUtils.splitUri(uri);
            if (p != null) {
                try {
                    long businessAccountId = Long.parseLong(p[2]);

                    BusinessAccount ba = businessAccountDao.get(businessAccountId);
                    if (ba == null) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }

                    if (ba.fCompanyLogoThumb.getValue() == null || ba.fCompanyLogoThumb.getValue().length == 0) {
                		InputStream logoPlaceholderStream = ServeLogoServlet.class.getResourceAsStream(LOGO_PLACEHOLDER_PNG);
                        byte[] logoPlaceholder = new byte[0];
                        if (logoPlaceholderStream == null)
                            log.severe("Impossible to load " + LOGO_PLACEHOLDER_PNG);
                        else
                            logoPlaceholder = NumheroUtils.readFromStream(logoPlaceholderStream);


                        writeResponse(response, logoPlaceholder);
                    } else {
                        writeResponse(response, ba.fCompanyLogoThumb.getValue());
                    }
                } catch (Exception ex) {
                    log.info("ServeLogoServlet: Bad BusinessAccountID request - " + p[2]);
                    ex.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void writeResponse(HttpServletResponse response, byte[] logo) throws IOException {
        log.info("ServeLogoServlet.writeResponse of size " + logo.length);

        // no cache headers
        response.setHeader("Cache-Control", "no-cache, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "Thu, 01 Dec 1994 16:00:00 GMT");
        response.setDateHeader("Expires", 0);
        // img headers
        response.setContentType("image/png");
        response.setContentLength(logo.length);
        ServletOutputStream sos = response.getOutputStream();
        sos.write(logo);
        sos.flush();
    }

}
