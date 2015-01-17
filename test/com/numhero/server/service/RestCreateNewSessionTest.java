package com.numhero.server.service;

import com.numhero.client.model.pojoc.*;
import com.numhero.server.NumheroUtils;
import com.numhero.server.auth.OneWayEncryptionService;
import com.numhero.server.model.daolite.*;
import com.numhero.server.utils.PojoTestUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.mockito.Mockito.*;

public class RestCreateNewSessionTest {
    private RestCreateNewSession r;

    @Before
    public void setUp() throws Exception {
        r = new RestCreateNewSession();
        r.companyBuilder = new CompanyBuilder();
        r.oneWayEncryption = NumheroUtils.injector.getInstance(OneWayEncryptionService.class);
    }

    @Test
    public void testProcess() throws Exception {
        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/createNewSession");
        when(httpReq.getMethod()).thenReturn("POST");

        r.process(httpReq, httpResp);
        verify(httpResp).sendError(400); //missing parameters
    }

    @Test
    public void testProcessNewUserForExistingBA() throws Exception {
        r.companyBuilder = null; //to test with existing company

        UrlConnectionClient url = mock(UrlConnectionClient.class);
        r.urlConnectionClient = url;
        HttpURLConnection conn = mock(HttpURLConnection.class);
        InputStream is = new ByteArrayInputStream(XmlResponseParserTest.xmlOneCompany.getBytes());
        when(conn.getInputStream()).thenReturn(is);
        when(conn.getResponseCode()).thenReturn(200);
        String purl = "https://www.netnumero.com/catalog/category/getUserData?userId=3&requestId=1";
        when(url.getConnection(purl)).thenReturn(conn);


        r.userDao = mock(UserDao.class);
        r.baDao = mock(BusinessAccountDao.class);

        when(r.baDao.getByUri("gamasoft")).thenReturn(PojoTestUtils.createBusinessAccount());

        r.sessionDao = mock(SessionDao.class);


        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/createNewSession");
        when(httpReq.getParameter("userId")).thenReturn("3");
        String timestamp = "10-10-2010";
        when(httpReq.getParameter("userVersion")).thenReturn(timestamp);
        when(httpReq.getParameter("requestId")).thenReturn("1");
        when(httpReq.getParameter("hash")).thenReturn("c41c0cc4a9d1f7f987e0ea121f485460");

        when(httpReq.getMethod()).thenReturn("POST");

        r.process(httpReq, httpResp);
        verify(r.baDao).getByUri("gamasoft");
        verify(r.sessionDao).save(any(Session.class));
        verify(r.userDao).save(correctUser(timestamp, "3", "DE"));

        verify(httpResp).setContentType("text/xml");
        verify(httpResp, times(0)).sendError(anyInt());

    }

    private User correctUser(final String timestamp, final String upid,final String ucc) {
        return argThat(new BaseMatcher<User>(){
            public User u;

            @SuppressWarnings({"CallToStringEquals"})
            @Override
            public boolean matches(Object o) {
                u = (User) o;

                if (!timestamp.equals(u.fVersion.getValue())) return false;

                if (!upid.equals(u.fUserPortalId.getValue())) return false;

                if (!ucc.equals(u.fCountryCode.getValue())) return false;

                return true;
            }

            @Override
            public void describeTo(Description description) {
               description.appendValueList(timestamp, upid, ucc);
            }
        });
    }


    @Test
    public void testProcessNewCompany() throws Exception {
        UrlConnectionClient url = mock(UrlConnectionClient.class);
        r.urlConnectionClient = url;
        HttpURLConnection conn = mock(HttpURLConnection.class);
        InputStream is = new ByteArrayInputStream(XmlResponseParserTest.xmlOneCompany.getBytes());
        when(conn.getInputStream()).thenReturn(is);
        when(conn.getResponseCode()).thenReturn(200);
        String purl = "https://www.netnumero.com/catalog/category/getUserData?userId=3&requestId=1";
        when(url.getConnection(purl)).thenReturn(conn);


        r.userDao = mock(UserDao.class);
        doAnswer(new Answer<User>() {

            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                User u = (User) invocationOnMock.getArguments()[0];
                u.setId(123L);
                return u;
            }
        }).when(r.userDao).save(any(User.class));

//        User u = PojoTestUtils.createUser();
//        u.setId(11L);
//        u.fBusinessAccountUri.setValue("gamasoft");
        when(r.userDao.findByPortalUserId("3")).thenReturn(null);
        r.companyBuilder.staffDao = mock(StaffDao.class);
        when(r.companyBuilder.staffDao.findByUserId("ba1", 11L)).thenReturn(null);

        r.baDao = mock(BusinessAccountDao.class);
        r.companyBuilder.baDao = r.baDao;

        when(r.baDao.getByUri("gamasoft")).thenReturn(null);
        r.sessionDao = mock(SessionDao.class);

        r.companyBuilder.categoryDao = mock(CategoryDao.class);
        r.companyBuilder.taskDao = mock(TaskDao.class);
        r.companyBuilder.nominalLedgerAccountDao = mock(NominalLedgerAccountDao.class);
        r.companyBuilder.taxDao = mock(TaxInfoDao.class);
        r.companyBuilder.staffDao = mock(StaffDao.class);
        r.companyBuilder.bankAccountDao = mock(BankAccountDao.class);


        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/createNewSession");
        when(httpReq.getParameter("userId")).thenReturn("3");
        when(httpReq.getParameter("userVersion")).thenReturn("1");
        when(httpReq.getParameter("requestId")).thenReturn("1");
        when(httpReq.getParameter("hash")).thenReturn("c41c0cc4a9d1f7f987e0ea121f485460");

        when(httpReq.getMethod()).thenReturn("POST");

        r.process(httpReq, httpResp);
        verify(httpResp).setContentType("text/xml");
        verify(httpResp, times(0)).sendError(403, "Provided hash is not valid. This request is traced.");
        verify(r.baDao).getByUri("gamasoft");
        verify(r.sessionDao).save(any(Session.class));
        verify(r.userDao, times(1)).save(any(User.class));
        verify(r.companyBuilder.staffDao).findByUserId("gamasoft", 123L);
        verify(r.companyBuilder.categoryDao, times(11)).save(any(Category.class)); 
        verify(r.companyBuilder.taskDao, times(6)).save(any(Task.class));
        verify(r.companyBuilder.taxDao, times(3)).save(any(TaxInfo.class));
        verify(r.companyBuilder.bankAccountDao, times(1)).save(any(BankAccount.class));
		verify(r.companyBuilder.nominalLedgerAccountDao, times(25)).save(any(NominalLedgerAccount.class));
    }


    @Test
    public void testProcessWrongHash() throws Exception {
        r.companyBuilder = null; //to test with existing company

        UrlConnectionClient url = mock(UrlConnectionClient.class);
        r.urlConnectionClient = url;
        HttpURLConnection conn = mock(HttpURLConnection.class);
        InputStream is = new ByteArrayInputStream(XmlResponseParserTest.xmlOneCompany.getBytes());
        when(conn.getInputStream()).thenReturn(is);
        when(conn.getResponseCode()).thenReturn(200);
        String purl = "https://www.netnumero.com/catalog/category/getUserData?userId=3&requestId=1";
        when(url.getConnection(purl)).thenReturn(conn);


        r.userDao = mock(UserDao.class);
        r.baDao = mock(BusinessAccountDao.class);

        when(r.baDao.getByUri("gamasoft")).thenReturn(PojoTestUtils.createBusinessAccount());


        HttpServletResponse httpResp = mock(HttpServletResponse.class);
        HttpServletRequest httpReq = mock(HttpServletRequest.class);
        when(httpReq.getRequestURI()).thenReturn("/rest/createNewSession");
        when(httpReq.getParameter("userId")).thenReturn("3");
        when(httpReq.getParameter("userVersion")).thenReturn("1");
        when(httpReq.getParameter("requestId")).thenReturn("1");
        when(httpReq.getParameter("hash")).thenReturn("12345");

        when(httpReq.getMethod()).thenReturn("POST");

        r.process(httpReq, httpResp);
        verify(httpResp).setContentType("text/xml");
        verify(httpResp).sendError(403, "Provided hash is not valid. This request is traced.");
        verify(r.baDao).getByUri("gamasoft");
    }


}
