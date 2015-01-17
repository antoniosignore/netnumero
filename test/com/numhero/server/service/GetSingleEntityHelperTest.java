package com.numhero.server.service;

import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.service.RestCommandProcessorTest.createInvoiceC;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class GetSingleEntityHelperTest {
    private GetSingleEntityHelper r;

    @Before
    public void setUp() throws Exception {
        r = new GetSingleEntityHelper();
    }

    @Test
    public void testGetReqName() throws Exception {
        r.setEntityName("invoice");
        assertEquals(GetInvoiceRequest.class, r.getCmdRequest().getClass());

    }

    @Test
    public void testSerializeResp() throws Exception {
        r.setEntityName("invoice");
        GetSingleEntityResponse<Invoice> resp = new GetSingleEntityResponse<Invoice>();
        resp.setEntity(createInvoiceC());
        assertTrue(r.serializeResp(resp).startsWith("<response><entity type=\"Invoice\" >"));
    }

}
