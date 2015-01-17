package com.numhero.server.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.enums.UserStatusEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CompanyServletTest {
    private CompanyServlet servlet;
    private HttpServletRequest httpReq;
    private HttpServletResponse httpRes;
    private Injector oldInjector;
    private UserDao userDao;
    private BusinessAccountDao baDao;

    @Before
    public void setUp(){
        Injector injector = Guice.createInjector(new MockedGuiceModule());
        userDao = injector.getInstance(UserDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);

        httpReq = mock(HttpServletRequest.class);
        httpRes = mock(HttpServletResponse.class);


        oldInjector = NumheroUtils.injector;
        NumheroUtils.injector = injector;

        servlet = new CompanyServlet();

    }

    @After
    public void CleanUp() {
        NumheroUtils.injector = oldInjector;
    }

    @Test
    public void testCreateGuestUser() throws IOException, ServletException {
        User u = servlet.createGuestUser();

        assertThat(u.fCountryCode.getValue(), is("GB"));
        assertThat(u.fEmail.getValue(), is("user@mycompany.com"));
        assertNull(u.fLastLogin.getValue());
        assertThat(u.fUserStatus.getValue(), is(UserStatusEnum.ACTIVE));
        assertThat(u.fVersion.getValue(), is(""));
        assertThat(u.fFirstName.getValue(), is("user"));
        assertThat(u.fLastName.getValue(), is("guest"));
    }

    @Test
    public void testGetMyCompany() throws IOException, ServletException {

        when(httpReq.getMethod()).thenReturn("GET");
        when(httpReq.getRequestURI()).thenReturn("/company/mycompany#dashboard");
        User u = servlet.createGuestUser();

        when(userDao.findByPortalUserId(CompanyServlet.GUESTUSER_PORTAL_ID)).thenReturn(u);
        BusinessAccount ba = PojoTestUtils.createBusinessAccount();
        ba.fBusinessAccountUri.setValue(CompanyServlet.SAMPLE_COMPANY);
        when(baDao.getByUri(CompanyServlet.SAMPLE_COMPANY)).thenReturn(ba);


        servlet.doGet(httpReq, httpRes);

        verify(userDao, times(0)).save(any(User.class));
        verify(userDao, times(1)).findByPortalUserId(CompanyServlet.GUESTUSER_PORTAL_ID);
        verify(baDao, times(1)).getByUri(CompanyServlet.SAMPLE_COMPANY);

    }

}
