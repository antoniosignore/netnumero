package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.server.model.daolite.BankAccountDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class CommandSaveBankAccountTest extends TestCase {

    BankAccountDao dao;
    public CommandSaveBankAccount commandSaveBankAccount;

    public void setUp() throws Exception {
        super.setUp();

        Injector injector = Guice.createInjector(new MockedGuiceModule());
        dao = injector.getInstance(BankAccountDao.class);
        commandSaveBankAccount = new CommandSaveBankAccount();
        injector.injectMembers(commandSaveBankAccount);
    }

    @Test
    public void testSaveBusinessAccountC() throws Exception {
        SaveBankAccountRequest request = new SaveBankAccountRequest();
        BankAccount ba = PojoTestUtils.createBankAccount();

        request.setBankAccount(ba);

        commandSaveBankAccount.execute(request);

        verify(dao).save(ba);
    }

}
