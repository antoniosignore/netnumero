package com.numhero.server.service;

import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaveSingleEntityHelperTest {
    private SaveSingleEntityHelper r;

    @Before
    public void setUp() throws Exception {
        r = new SaveSingleEntityHelper();
    }

    @Test
    public void testGetReqName() throws Exception {
        r.setEntityName("invoice");
        assertEquals(SaveInvoiceRequest.class, r.getCmdRequest().getClass());
    }


    @Test
    public void testSerializeResp() throws Exception {
        r.setEntityName("invoice");
        SaveSingleEntityResponse resp = new SaveSingleEntityResponse();
        resp.setEntityId(12L);
        String xml = r.serializeResp(resp);
        assertEquals("<id>12</id>", xml);
    }
 
}
