package com.numhero.server.service;

import com.google.inject.Inject;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.command.ICommandProcessor;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.util.SharedUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class RestCommandPreProcessor {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RestCommandPreProcessor.class.getName());

    @Inject
    private ICommandProcessor cmdProcessor;

    public RestCommandPreProcessor() {
        // cmdProcessor = NumheroUtils.injector.getInstance(ICommandProcessor.class);
    }

    public boolean isUriOk(String uri) {
        String[] p = SharedUtils.splitUri(uri);
        if (p != null && p.length == 5)
            return true;
        else
            return false;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        String method = request.getMethod();


//        Enumeration pn = request.getParameterNames();
//        while (pn.hasMoreElements()){
//            String p = (String) pn.nextElement();
//            log.fine(" p " + p + " = " + request.getParameter(p));
//        }


        try {
            RestHelper rh = prepareHelper(uri, method, "" + request.getParameter("entity"));

            //todo get them correctly
            BusinessAccount ba = null;
            User u = null;
            CommandResponse resp = cmdProcessor.process(u, ba, rh.getCmdRequest());

            if (resp == null) {
                response.sendError(404, "Entity not present");
            } else {

                serializeResponse(response, rh.serializeResp(resp));
            }
        } catch (Throwable t) {
            t.printStackTrace();
            response.sendError(500, "Error " + t.getMessage());
        }

    }

    private void serializeResponse(HttpServletResponse response, String xml) throws IOException {

        PrintWriter out = response.getWriter();
        out.println(xml);
        out.close();
    }

    protected RestHelper prepareHelper(String uri, String method, String entityXml) {
        String[] p = SharedUtils.splitUri(uri);
        String entityName = p[3];
        String baId = p[2];
        Long id;
        if (p.length == 4) {
//            System.err.println("    p[0]:" + p[0] + " p[1]:" + p[1] + " p[2]:" + p[2] + " p[3]:" + p[3]);
            id = null;
        } else {
//            System.err.println("    p[0]:" + p[0] + " p[1]:" + p[1] + " p[2]:" + p[2] + " p[3]:" + p[3] + " p[4]:" + p[4]);
            id = new Long(p[4]);
        }
        RestHelper rh = createHelper(method, entityName, id);

        rh.enrichRequest(entityXml, id);
        CommandRequest req = rh.getCmdRequest();
        req.setBusinessAccountId(baId);
//        req.setSessionID("777");

        return rh;
    }


    protected RestHelper createHelper(String method, String entity, Long id) {
        RestHelper reqKind;
        if ("GET".equals(method)) {

            if (id == null) {
                reqKind = new GetMultiEntitiesHelper();
            } else {
                reqKind = new GetSingleEntityHelper();
            }
        } else if ("POST".equals(method)) {
            reqKind = new SaveSingleEntityHelper();
        } else {
            throw new RuntimeException("Not supported method " + method);
        }

        reqKind.setEntityName(entity);
        return reqKind;
    }


}
