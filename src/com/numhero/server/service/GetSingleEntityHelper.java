package com.numhero.server.service;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

import static com.numhero.server.utils.XmlUtils.serializeEntity;

class GetSingleEntityHelper extends RestHelper {
    @Override
    public String getReqName() {
        return "Get" + getEntityClassName() + "Request";
    }

    @Override
    public void enrichRequest(String entityXml, Long id) {
        CommandRequest req = getCmdRequest();
        GetSingleEntityRequest ser = (GetSingleEntityRequest) req;
        ser.setEntityId(id);

    }

    @Override
    public String serializeResp(CommandResponse resp) {
        StringBuffer xml = new StringBuffer();
        GetSingleEntityResponse ser = (GetSingleEntityResponse) resp;
        xml.append("<response>");
        serializeEntity(xml, ser.getEntity());
        xml.append("</response>");
        return xml.toString();
    }
}
