package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest;
import com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest;
import com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse;
import com.numhero.client.model.pojoc.BalanceSheetRow;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.InvoiceDao;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.server.service.MockedGuiceModule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandGetProfitLossTest {
    InvoiceDao invDao;
    BusinessAccountDao baDao;
    ExpenseReceiptDao expenseReceiptDao;

    CommandGetProfitLoss commandGetProfitLoss;
    BusinessAccount ba;

    private MockedGuiceModule mockedDaoGuiceModule = new MockedGuiceModule();
    public NominalLedgerAccountDao nominalLedgerAccountDao;
    public CommandGetTrialBalance commandGetTrialBalance;
    public BusinessAccountDao businessAccountDao;


    @Before
    public void setUp() throws Exception {

        Injector injector = Guice.createInjector(mockedDaoGuiceModule);

        ba = createBusinessAccount();

        nominalLedgerAccountDao = injector.getInstance(NominalLedgerAccountDao.class);

        commandGetTrialBalance = mock(CommandGetTrialBalance.class);
        TrialBalanceResponse response = new TrialBalanceResponse();
        response.setTrialRows(new ArrayList<BalanceSheetRow>());
        when(commandGetTrialBalance.execute(any(TrialBalanceRequest.class))).thenReturn(response);

        businessAccountDao = injector.getInstance(BusinessAccountDao.class);

        commandGetProfitLoss = injector.getInstance(CommandGetProfitLoss.class);

        invDao = injector.getInstance(InvoiceDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        expenseReceiptDao = injector.getInstance(ExpenseReceiptDao.class);

        injector.injectMembers(commandGetProfitLoss);
        commandGetProfitLoss.commandGetTrialBalance = commandGetTrialBalance;
        commandGetProfitLoss.setBusinessAccount(ba);
    }

    @Test
    public void testGetProfitAndLoss() throws Exception {

        GetProfitLossRequest request = new GetProfitLossRequest();
        GetProfitLossResponse response = commandGetProfitLoss.execute(request);
        assertNotNull(response);

        assertThat(response.getSales(), is(0.0));
        assertThat(response.getGrossProfit(), is(0.0));
        assertThat(response.getSheetRows().size(), is(0));
        assertThat(response.getTotalExpenses(), is(0.0));
        assertThat(response.getCostOfSales(),  is(0.0));



    }

}
