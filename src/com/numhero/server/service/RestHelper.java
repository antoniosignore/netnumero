package com.numhero.server.service;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

import static com.numhero.shared.util.SharedUtils.initialUppercaseAndCamel;

public abstract class RestHelper {
    protected String entity;

    protected CommandRequest cmdRequest;

    void setEntityName(String entity) {
        this.entity = entity;
        createCommandRequest();
    }

    public abstract String getReqName();

    protected String getEntityClassName() {
        return initialUppercaseAndCamel(entity);
    }

    public CommandRequest getCmdRequest() {
        return cmdRequest;
    }


    private void createCommandRequest() {
        //TODO we need a better way to create the request
        String longName = "com.numhero.client.model.datacargo." + entity + '.' + getReqName();
        //System.err.println("longname " + longName);

        try {
            Class<CommandRequest> reqClazz = (Class<CommandRequest>) Class.forName(longName);
            cmdRequest = reqClazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("request not found " + longName, e);
        } catch (InstantiationException e) {
            throw new RuntimeException("newInstance error for " + getReqName(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("newInstance illegal error for" + getReqName(), e);
        }
    }

    public abstract void enrichRequest(String entityXml, Long id);

    public abstract String serializeResp(CommandResponse resp);


}
