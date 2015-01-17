package com.numhero.server.service;

import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.XmlEntityParser;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.pojoc.SearchablePojo;

class SaveSingleEntityHelper extends RestHelper {
    @Override
    public String getReqName() {
        return "Save" + getEntityClassName() + "Request";
    }

    @Override
    public void enrichRequest(String entityXml, Long id) {
        CommandRequest req = getCmdRequest();
        SaveSingleEntityRequest ser = (SaveSingleEntityRequest) req;
        SearchablePojo e;
        e = XmlEntityParser.parseEntityData(NumheroUtils.convertStringInInputStream(entityXml));
        ser.setEntity(e);


    }

    @Override
    public String serializeResp(CommandResponse resp) {
        StringBuffer xml = new StringBuffer();
        SaveSingleEntityResponse ser = (SaveSingleEntityResponse) resp;
        xml.append("<id>");
        xml.append(ser.getEntityId());
        xml.append("</id>");

        return xml.toString();
    }
}
