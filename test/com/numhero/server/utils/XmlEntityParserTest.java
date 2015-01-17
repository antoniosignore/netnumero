package com.numhero.server.utils;

import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.NumheroUtils;
import org.junit.Test;

import static com.numhero.server.utils.XmlEntityParser.parseEntityData;
import static junit.framework.Assert.assertEquals;


public class XmlEntityParserTest {
    @Test
    public void testParseEntityData() throws Exception {
        String xml = "<entity type=\"ClientSupplier\" ><address>via della Spiga</address><name>Camiceria Mariella s.n.c.</name><notes>notes</notes></entity>";

        ClientSupplier c = (ClientSupplier) parseEntityData(NumheroUtils.convertStringInInputStream(xml));

        assertEquals("via della Spiga", c.fAddress.getValue());
    }

}
