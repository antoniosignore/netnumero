package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BusinessAccountDaoTest extends BaseDaoTest {
    private BusinessAccountDao businessAccountDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        businessAccountDao = NumheroUtils.injector.getInstance(BusinessAccountDao.class);
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(businessAccountDao);
    }

    @Test
    public void testSaveAndRetrieve() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        businessAccountDao.save(ba);
        BusinessAccount u2 = businessAccountDao.get(ba.getId());
        assertEquals(ba.getId(), u2.getId());
    }

    @Test
    public void testSaveAndGetByName() throws Exception {
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        businessAccountDao.save(ba);
        BusinessAccount u2 = businessAccountDao.getByUri(ba.fBusinessAccountUri.getValue());
        assertEquals(ba.getId(), u2.getId());
    }



}
