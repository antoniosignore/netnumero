package com.numhero.server.service;

import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.service.RestCommandProcessorTest.createInvoiceC;

public class GetMultiEntitiesHelperTest extends TestCase {

    private GetMultiEntitiesHelper r;

    @Before
    public void setUp() throws Exception {
        r = new GetMultiEntitiesHelper();
    }

    @Test
    public void testGetReqName() throws Exception {
        r.setEntityName("invoice");
        assertEquals(InvoiceListRequest.class, r.getCmdRequest().getClass());
    }

    @Test
    public void testSerializeResp() throws Exception {
        r.setEntityName("invoice");
        InvoiceListResponse resp = new InvoiceListResponse();
        resp.getEntityList().add(createInvoiceC());
        assertTrue(r.serializeResp(resp).contains("<entity type=\"Invoice\" >"));
    }

}
