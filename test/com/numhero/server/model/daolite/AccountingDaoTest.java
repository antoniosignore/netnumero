package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.AccountingLeg;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class AccountingDaoTest extends BaseDaoTest {

    BusinessTransactionDao businessTransactionDao;
    AccountingLegDao accountingLegDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        businessTransactionDao = NumheroUtils.injector.getInstance(BusinessTransactionDao.class);
        accountingLegDao = NumheroUtils.injector.getInstance(AccountingLegDao.class);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(businessTransactionDao);
    }


    @Test
    public void testSave() {
        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();

        businessTransactionDao.save(accountingentry);
        BusinessTransaction i2 = businessTransactionDao.get(accountingentry.getId());
        assertNotNull(i2);
        assertEquals(2, i2.getAccountingLegs().size());

    }

    @Test
    public void testDelete() {
        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();
        businessTransactionDao.save(accountingentry);
        Long id = accountingentry.getId();
        assertNotNull(businessTransactionDao.get(id));
        businessTransactionDao.delete(accountingentry);
        assertNull(businessTransactionDao.get(id));
    }

    // todo - Uberto : come faccio a configurare questo pojo per la search ?
//    @Test
//    public void testSearch() {
//        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();
//        accountingentry.fName.setValue("2010/1");
//        accountingentryDao.save(accountingentry);
//
//        List<BusinessTransaction> searchRet;
//
//        searchRet = accountingentryDao.search("2010/1", "ba1");
//        assertEquals(1, searchRet.size());
//    }
//    @Test
//    public void testMultiSearch() {
//        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();
//        accountingentryDao.save(accountingentry);
//
//        List<BusinessTransaction> searchRet;
//
//        searchRet = accountingentryDao.search("shipment pippo", "ba1");
//        assertEquals(1, searchRet.size());
//
//        searchRet = accountingentryDao.search("ship pluto pippo", "ba1");
//        assertEquals(0, searchRet.size());
//    }
//
//    @Test
//    public void testDateSearch() {
//        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();
//        accountingentryDao.save(accountingentry);
//
//        String date = accountingentry.fDate.getValueAsString();
//
//        System.err.println("--" + date);
//        List<BusinessTransaction> searchRet = accountingentryDao.search(date, "ba1");
//        assertEquals(1, searchRet.size());
//
//        searchRet = accountingentryDao.search(accountingentry.fDate.getValueAsString(), "ba1");
//        assertEquals(1, searchRet.size());
//    }


    @Test
    public void testFindAll() {
        BusinessTransaction entry = PojoTestUtils.createAccountingEntry();
        entry.fName.setValue("2010/1");
        businessTransactionDao.save(entry);

        entry = PojoTestUtils.createAccountingEntry();
        entry.fName.setValue("2010/2");
        businessTransactionDao.save(entry);

        entry = PojoTestUtils.createAccountingEntry();
        entry.fName.setValue("2010/3");
        businessTransactionDao.save(entry);

        entry = PojoTestUtils.createAccountingEntry();
        entry.fName.setValue("2010/4");
        businessTransactionDao.save(entry);

        List<BusinessTransaction> searchRet = businessTransactionDao.findAll("ba1");
        assertEquals(4, searchRet.size());
        assertEquals("2010/1", searchRet.get(0).fName.getValue());
        assertEquals("2010/4", searchRet.get(3).fName.getValue());

        searchRet = businessTransactionDao.findAll("ba2");
        assertEquals(0, searchRet.size());
    }

    @Test
    public void testManyDetails() {
        BusinessTransaction accountingentry = PojoTestUtils.createAccountingEntry();
        accountingentry.getAccountingLegs().clear();
        for (int i = 0; i < 50; i++) {
            AccountingLeg id = PojoTestUtils.createAccountingLeg(accountingentry);
            id.fValue.setValue(i * 100.0);
            accountingentry.addAccountingLeg(id);
        }

        long t = System.currentTimeMillis();
        businessTransactionDao.save(accountingentry);
//        System.out.println("0." + (System.currentTimeMillis() - t));

        log.info("accountingentry.fBusinessAccountUri.getValue() = " + accountingentry.fBusinessAccountUri.getValue());
        List<AccountingLeg> legs = accountingLegDao.findAll(accountingentry.fBusinessAccountUri.getValue(), 100);
        assertEquals(50, legs.size());

        System.out.println("1." + (System.currentTimeMillis() - t));

        Long id = accountingentry.getId();
        BusinessTransaction i2 = businessTransactionDao.get(id);
        assertEquals(id, i2.getId());

        assertEquals(50, i2.getAccountingLegs().size());

        List<BusinessTransaction> searchRet = businessTransactionDao.findAll("ba1");
        for (int i = 0; i < searchRet.size(); i++) {
            BusinessTransaction businessTransaction = searchRet.get(i);
            assertEquals(0, businessTransaction.getAccountingLegs().size());
        }

        System.out.println("2." + (System.currentTimeMillis() - t));

        assertNotNull(i2.fId.getValue());
        System.out.println("3." + (System.currentTimeMillis() - t));

        assertEquals(50, i2.getAccountingLegs().size());
        System.out.println("4." + (System.currentTimeMillis() - t));

        assertEquals(200, i2.getAccountingLegs().get(2).fValue.getValue(),  0.01);
        System.out.println("5." + (System.currentTimeMillis() - t));
    }
}
