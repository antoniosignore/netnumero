package com.numhero.server.service;


import com.numhero.server.NumheroUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RestServlet extends HttpServlet {
    private static final long serialVersionUID = -4115549168287633545L;

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RestServlet.class.getName());

    private RestCreateNewSession restCreateNewSession;
    private RestCommandPreProcessor restCommandPreProcessor;


    public RestServlet() {
        restCommandPreProcessor = NumheroUtils.injector.getInstance(RestCommandPreProcessor.class);
        restCreateNewSession = NumheroUtils.injector.getInstance(RestCreateNewSession.class);

    }

    //     localhost:8088/rest/createNewSession?userId=5&userVersion=1&requestId=1326964&hash=247a67a4489fb17a4fcf68c60db6b6d0
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // userId=xxx, userVersion=zzz and a security hash=yyy
        // (MD5 of userid, userversion and saltphrase)

        // createNewSession

        String uri = request.getRequestURI();

        if (uri.startsWith("/rest/createNewSession")) {
            restCreateNewSession.process(request, response);
        } else if (restCommandPreProcessor.isUriOk(uri)) {
            restCommandPreProcessor.process(request, response);
        } else {
            log.info("bad request " + uri);
            response.sendError(400);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
