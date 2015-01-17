package com.numhero.server.service;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

import static com.numhero.server.utils.XmlUtils.serializeEntity;

class GetMultiEntitiesHelper extends RestHelper {

    private GetSingleEntityHelper r;


    @Override
    public String getReqName() {
        return getEntityClassName() + "ListRequest";
    }

    @Override
    public void enrichRequest(String entityXml, Long id) {
        CommandRequest req = getCmdRequest();
        ListCommandRequest ler = (ListCommandRequest) req;
        ler.setMaxResults(20);

    }

    @Override
    public String serializeResp(CommandResponse resp) {
        StringBuffer xml = new StringBuffer();
        ListCommandResponse ler = (ListCommandResponse) resp;

        Collection<SearchablePojo> le = ler.getEntityList();
        xml.append("<response>");
        for (SearchablePojo pojo : le) {
            xml.append("<entity>");
            serializeEntity(xml, pojo);
            xml.append("</entity>");
        }
        xml.append("</response>");
        return xml.toString();
    }


}
