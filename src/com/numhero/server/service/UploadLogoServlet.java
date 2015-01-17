package com.numhero.server.service;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.Session;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.server.pdf.ImageService;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadLogoServlet extends HttpServlet {
    private static final long serialVersionUID = 217903650215085532L;

    private static final Logger log = Logger.getLogger(UploadLogoServlet.class.getName());

    private SessionDao sessionDao;
    private BusinessAccountDao businessAccountDao;

    public UploadLogoServlet() {
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

        ServletFileUpload upload = new ServletFileUpload();
        Long businessAccountId = null;
        byte[] logo = null;
        try {
            FileItemIterator iter = upload.getItemIterator(request);

            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                InputStream stream = item.openStream();
                if (item.isFormField()) {
                    if ("businessAccountId".equals(item.getFieldName())) {
                        businessAccountId = Long.parseLong(new String(NumheroUtils.readFromStream(stream)));
                    }
                } else {
                    logo = NumheroUtils.readFromStream(stream);
                }
            }
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Error while parsing request to upload logo", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (businessAccountId == null || logo == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        BusinessAccount ba = businessAccountDao.get(businessAccountId);
        if (ba == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        byte[] thumbnail = ImageService.resizeImage(logo, 280, 180);
        if (thumbnail == null || thumbnail.length == 0) {
            log.severe("The thumbnail was null, ignoring the uploaded file.");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        ba.fCompanyLogo.setValue(logo);
        ba.fCompanyLogoThumb.setValue(thumbnail);
        businessAccountDao.save(ba);

        log.fine("Uploaded a new logo with size " + logo.length);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
