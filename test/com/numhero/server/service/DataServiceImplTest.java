package com.numhero.server.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Session;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.model.daolite.BusinessAccountDao;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.model.daolite.SessionDao;
import com.numhero.server.model.daolite.UserDao;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.util.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataServiceImplTest {
    private DataServiceImpl ds;
    private HttpServletRequest httpReq;
    private SessionDao sessDao;
    private UserDao userDao;
    private Injector injector;
    private BusinessAccountDao baDao;

    private ClientSupplierDao clientDao;
    private Injector oldInjector;

    @Before
    public void setUp() throws Exception {
        //  super.setUp();

        httpReq = mock(HttpServletRequest.class);


        injector = Guice.createInjector(new MockedGuiceModule());


        userDao = injector.getInstance(UserDao.class);
        sessDao = injector.getInstance(SessionDao.class);
        baDao = injector.getInstance(BusinessAccountDao.class);

        ds = new TestableDataServiceImpl();

        clientDao = injector.getInstance(ClientSupplierDao.class);

        User u = PojoTestUtils.createUser();
        u.setId(null);

        BusinessAccount ba = PojoTestUtils.createBusinessAccount();

        HttpServletResponse httpResp = mock(HttpServletResponse.class);

        when(httpReq.getRequestURI()).thenReturn("/company/mycompany");
        when(httpReq.getMethod()).thenReturn("GET");

        String sessId = "12345";

        Cookie[] cookie = new Cookie[1];
        cookie[0] = new Cookie(Constants.SESSION_COOKIE_NAME, sessId);
        when(httpReq.getCookies()).thenReturn(cookie);

        Session session = new Session(u.getId(), sessId);
        when(sessDao.findBySessionID(sessId)).thenReturn(session);
        when(userDao.get(u.getId())).thenReturn(u);
        when(baDao.getByUri(u.fBusinessAccountUri.getValue())).thenReturn(ba);

        oldInjector = NumheroUtils.injector;
        NumheroUtils.injector = injector;


    }

    @After
    public void CleanUp() {
        NumheroUtils.injector = oldInjector;
    }


//To test:

//         User user = authenticateUser();
//        BusinessAccount ba = getBusinessAccountFromRequest(request);
//
//        if (!user.hasRelationToBa(ba.fBusinessAccountUri.getValue())) {
//            throw new NotAuthorizedException();
//        }

    //we should try with a not auth command or we need to put the cookie in the threadlocal
    @Test
    public void testExecute() throws Exception {
        ClientSupplier client = PojoTestUtils.createClientSupplier();
        when(clientDao.get(client.getId())).thenReturn(client);

        GetClientSupplierRequest req = new GetClientSupplierRequest();


        req.setEntityId(client.getId());
        req.setBusinessAccountId("ba1");


        GetSingleEntityResponse<ClientSupplier> resp = ds.execute(req);


        //assertEquals(resp.getClientSupplier(), client);


    }


    @Test
    public void testCreate() throws Exception {
        assertNotNull(ds);
    }

    private class TestableDataServiceImpl extends DataServiceImpl {

        private TestableDataServiceImpl() {
            sessionDao = injector.getInstance(SessionDao.class);
            userDao = injector.getInstance(UserDao.class);
            baDao = injector.getInstance(BusinessAccountDao.class);


        }

        @Override
        protected HttpServletRequest getHttpRequest() {
            return httpReq;
        }
    }
}
