package com.numhero.server.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.utils.LocalesUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.enums.CountryEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.util.ResourceBundle;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CompanyBuilderTest {

    private CompanyBuilder cb;

    private MockedGuiceModule mockedDaoGuiceModule = new MockedGuiceModule();

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(mockedDaoGuiceModule);

        cb = new CompanyBuilder();
        injector.injectMembers(cb);

    }

    @Test
    public void testBuild() throws Exception {
        User u = PojoTestUtils.createUser();
        u.setId(11L);

        cb.build("gamasoft", "GB", u);

        verify(cb.baDao, times(1)).save(argThat(new ArgumentMatcher<BusinessAccount>() {
            @Override
            public boolean matches(Object o) {
                BusinessAccount tmpBa = (BusinessAccount) o;
                return tmpBa.fName.getValue().equals("gamasoft") && tmpBa.fCountry.getValue().equals(CountryEnum.GB);
            }
        }));
        verify(cb.staffDao, times(1)).save(argThat(new ArgumentMatcher<Staff>() {
            @Override
            public boolean matches(Object o) {
                Staff tmp = (Staff) o;
                return tmp.fName.getValue().equals("Admin") && tmp.fBusinessAccountUri.getValue().equals("gamasoft");
            }
        }));
        verify(cb.categoryDao, times(11)).save(any(Category.class));
        verify(cb.taskDao, times(6)).save(any(Task.class));

        verify(cb.nominalLedgerAccountDao, times(25)).save(argThat(new ArgumentMatcher<NominalLedgerAccount>() {
            @Override
            public boolean matches(Object o) {
                NominalLedgerAccount tmp = (NominalLedgerAccount) o;

                String c = tmp.fCode.getValue();
                String d = tmp.fName.getValue();
                ResourceBundle bundle = LocalesUtils.getBundle(CountryEnum.valueOf("GB"));
                return  d.equals(bundle.getString(c));
            }
        }));

        verify(cb.taxDao, times(3)).save(any(TaxInfo.class));

    }

}
