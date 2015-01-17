package com.numhero.server.service;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.auth.MD5EncryptionServiceImpl;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.model.daolite.*;
import com.numhero.server.utils.PojoTestUtils;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MockedGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
//        bind(ICommandProcessor.class).to(CommandProcessor.class);
        bind(OneWayEncryptionService.class).to(MD5EncryptionServiceImpl.class);
    }

    @Provides
    @Singleton
    InvoiceDao getInvoiceDao() {
        return mock(InvoiceDao.class);
    }

    @Provides
    @Singleton
    BusinessAccountDao getBADao() {
        BusinessAccountDao businessAccountDao = mock(BusinessAccountDao.class);
        doAnswer(new Answer<BusinessAccount>() {
            @Override
            public BusinessAccount answer(InvocationOnMock invocation) throws Throwable {
                BusinessAccount ba = (BusinessAccount) invocation.getArguments()[0];
                ba.setId(123L);
                return ba;
            }
        }).when(businessAccountDao).save(any(BusinessAccount.class));
        doAnswer(new Answer<BusinessAccount>() {
            @Override
            public BusinessAccount answer(InvocationOnMock invocation) throws Throwable {
                return PojoTestUtils.createBusinessAccount();
            }
        }).when(businessAccountDao).get(anyLong());

        return businessAccountDao;
    }

    @Provides
    @Singleton
    BankAccountDao getBankAccountDao() {
        BankAccountDao dao = mock(BankAccountDao.class);
        doAnswer(new Answer<BankAccount>() {
            @Override
            public BankAccount answer(InvocationOnMock invocation) throws Throwable {
                Long id = (Long) invocation.getArguments()[0];
                BankAccount ba = new BankAccount();
                ba.setId(id);

                return ba;
            }
        }).when(dao).get(anyLong());


        return dao;
    }


    @Provides
    @Singleton
    ClientSupplierDao getClientSupplierDao() {
        ClientSupplierDao dao = mock(ClientSupplierDao.class);
        doAnswer(new Answer<ClientSupplier>() {
            @Override
            public ClientSupplier answer(InvocationOnMock invocation) throws Throwable {
                Long id = (Long) invocation.getArguments()[0];
                ClientSupplier clientSupplier = PojoTestUtils.createClientSupplier();
                clientSupplier.setId(id);
                return clientSupplier;
            }
        }).when(dao).get(21L);
        doAnswer(new Answer<ClientSupplier>() {
            @Override
            public ClientSupplier answer(InvocationOnMock invocation) throws Throwable {
                Long id = (Long) invocation.getArguments()[0];
                ClientSupplier clientSupplier = PojoTestUtils.createSupplier();
                clientSupplier.setId(id);
                return clientSupplier;
            }
        }).when(dao).get(22L);
        return dao;
    }


    @Provides
    @Singleton
    ExpenseReceiptDao getExpenseDao() {
        return mock(ExpenseReceiptDao.class);
    }


    @Provides
    @Singleton
    BankTransactionDao getBankTransactionDao() {
        return mock(BankTransactionDao.class);
    }


    @Provides
    @Singleton
    CategoryDao getCategoryDao() {
        CategoryDao dao = mock(CategoryDao.class);

        return dao;
    }

    @Provides
    @Singleton
    TaskDao getTaskDao() {
        return mock(TaskDao.class);
    }

    @Provides
    @Singleton
    StaffDao getStaffDao() {
        return mock(StaffDao.class);
    }

    @Provides
    @Singleton
    UserDao getUserDao() {
        return mock(UserDao.class);
    }

    @Provides
    @Singleton
    SessionDao getSessionDao() {
        return mock(SessionDao.class);
    }


    @Provides
    @Singleton
    FXDao getFXDao() {
        FXDao fxDao = mock(FXDao.class);
        when(fxDao.isPresent(anyString())).thenReturn(true);
        when(fxDao.get(anyString())).thenReturn(1.0);
        return fxDao;
    }


    @Provides
    @Singleton
    NominalLedgerAccountDao getLedgerAccountDao() {
        NominalLedgerAccountDao dao = mock(NominalLedgerAccountDao.class);

        doAnswer(new Answer<NominalLedgerAccount>() {
            @Override
            public NominalLedgerAccount answer(InvocationOnMock invocation) throws Throwable {
                String ba = (String) invocation.getArguments()[0];
                String name = (String) invocation.getArguments()[1];
                NominalLedgerAccount la = new NominalLedgerAccount();
                la.fBusinessAccountUri.setValue(ba);
                la.fName.setValue(name);

                return la;
            }
        }).when(dao).loadAccountsByCode(anyString(), anyString());
        return dao;
    }


    @Provides
    @Singleton
    BusinessTransactionDao getBusinessTransactionDao() {
        return mock(BusinessTransactionDao.class);
    }

    @Provides
    @Singleton
    TaxInfoDao getTaxInfoDao() {
        TaxInfoDao taxDao = mock(TaxInfoDao.class);
        doCallRealMethod().when(taxDao).findAllFromInvoice(any(Invoice.class));
        return taxDao;
    }

    @Provides
    @Singleton
    EmailDao getEmailDao() {
        EmailDao dao = mock(EmailDao.class);
        return dao;
    }

}
