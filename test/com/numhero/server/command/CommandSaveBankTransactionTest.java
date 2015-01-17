package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest;
import com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.model.pojoc.BankTransaction;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.model.daolite.BankTransactionDao;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.CategoryDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import org.junit.Before;
import org.junit.Test;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandSaveBankTransactionTest {
    BankAccountDao bankAccountDao;
    BankTransactionDao bankTransactionAccountDao;
    BusinessAccountDao baDao;
    CommandSaveBankTransaction commandSaveBankTransaction;
    private CategoryDao categoryDao;

    @Before
    public void setUp() throws Exception {
        commandSaveBankTransaction = new CommandSaveBankTransaction();
        BusinessAccount ba = createBusinessAccount();
        commandSaveBankTransaction.setBusinessAccount(ba);

        Injector injector = Guice.createInjector(new MockedGuiceModule());
        bankAccountDao = injector.getInstance(BankAccountDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);
        bankTransactionAccountDao = injector.getInstance(BankTransactionDao.class);
        categoryDao  = injector.getInstance(CategoryDao.class);

        injector.injectMembers(commandSaveBankTransaction);
    }

    @Test
    public void testSaveBankTransaction() throws Exception {
        SaveBankTransactionRequest request = new SaveBankTransactionRequest();
        BankTransaction businessTransaction = PojoTestUtils.createBankTransaction();

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        when(baDao.getByUri(businessTransaction.fBusinessAccountUri.getValue())).thenReturn(ba);

        BankAccount bankAccount = PojoTestUtils.createBankAccount();
        when(bankAccountDao.get(businessTransaction.fBankAccountId.getValue())).thenReturn(bankAccount);
        when(categoryDao.get(1L)).thenReturn(PojoTestUtils.createCategory());

        request.setBankTransaction(businessTransaction);
        request.setBusinessAccountId(businessTransaction.fBusinessAccountUri.getValue());
        SaveBankTransactionResponse response = commandSaveBankTransaction.execute(request);
        verify(bankTransactionAccountDao).save(businessTransaction);

        assertThat(businessTransaction.getId(), is(response.getEntityId()));
    }

}
