package com.numhero.server.service;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.Session;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.shared.util.SharedUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ExportServlet extends HttpServlet {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(ExportServlet.class.getName());

    private SessionDao sessionDao;
    private BusinessAccountDao businessAccountDao;

    public ExportServlet() {
        sessionDao = NumheroUtils.injector.getInstance(SessionDao.class);
        businessAccountDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String sessionIDFromClient = NumheroUtils.getSessionFromCookie(request);
        log.fine("sessionIDFromClient " + sessionIDFromClient);

        Session session = null;
        if (sessionIDFromClient != null) {
            session = sessionDao.findBySessionID(sessionIDFromClient);
        }
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        Invoice invoice = null;
        String uri = request.getRequestURI();
        if (uri.startsWith("/export/")) {
            String[] p = SharedUtils.splitUri(uri);
            if (p != null && p.length == 3) {
                try {
                    log.info("p[0] = " + p[0]);
                    log.info("p[1] = " + p[1]);
                    log.info("p[2] = " + p[2]);

                } catch (Exception ex) {
                    log.info("ExportServlet: Bad invoiceID request - " + p[2]);
                }
            }
        }


//        try {

        //      ByteArrayOutputStream bytes = new ExportService().expensesExcelReport();
        //
        //      // Initialize Http Response Headers
        //      response.setHeader("Content-disposition", "attachment; filename=exportUsers.xls");
        //      response.setContentType("application/vnd.ms-excel");
        //
        //      // Write data on response output stream
        //      if (bytes != null) {
        //        response.getOutputStream().write(bytes.toByteArray());
        //      }
//        } catch (WriteException e) {
//            response.setContentType("text/plain");
//            response.getWriter().print("An error as occured");
//        }
    }
}
