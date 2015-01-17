package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.AccountingLeg;
import com.numhero.client.model.pojoc.BusinessTransaction;
import com.numhero.server.NumheroUtils;
import com.numhero.server.service.CompanyBuilder;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Test;

import java.util.List;

import static com.numhero.server.utils.DateUtils.fromYYYYMMDD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountingLegDaoTest extends BaseDaoTest{
    private BusinessTransactionDao btDao;
    private AccountingLegDao alDao;


    @Override
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.

        btDao = NumheroUtils.injector.getInstance(BusinessTransactionDao.class);
        alDao = NumheroUtils.injector.getInstance(AccountingLegDao.class);
    }

    @Test
    public void testFindAllLegsByNominalCode() throws Exception {
        BusinessTransaction e1 = PojoTestUtils.createAccountingEntry();
        e1.fDate.setValue(fromYYYYMMDD("20100105"));

        BusinessTransaction e2 = PojoTestUtils.createAccountingEntry();
        e2.fDate.setValue(fromYYYYMMDD("20101210"));

        BusinessTransaction e3 = PojoTestUtils.createAccountingEntry();
        e3.fDate.setValue(fromYYYYMMDD("20090101"));

        btDao.save(e1);
        btDao.save(e2);
        btDao.save(e3);

        List<AccountingLeg> l = alDao.findAllLegsByNominalCode("ba1", CompanyBuilder.SALES, fromYYYYMMDD("20100101"), fromYYYYMMDD("20101231"));

        assertThat(l.size(), is(2));

        List<AccountingLeg> l2 = alDao.findAllLegsByNominalCode("ba1", CompanyBuilder.VAT, fromYYYYMMDD("20100101"), fromYYYYMMDD("20101231"));

        assertThat(l2.size(), is(0));

        List<AccountingLeg> l3 = alDao.findAllLegsByNominalCode("ba1", CompanyBuilder.ACCOUNTS_RECEIVABLE, fromYYYYMMDD("20090101"), fromYYYYMMDD("20101231"));

        assertThat(l3.size(), is(3));

    }
}
