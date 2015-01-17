package com.numhero.server.model.daolite;

import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.numhero.shared.enums.CurrencyEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

public class FXDaoTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalMemcacheServiceTestConfig());

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void testFindBySessionID() throws Exception {
        FXDao dao = new FXDao();
        String s1 = "EURUSD";

        assertFalse(dao.isPresent(s1));

        dao.save(s1, 1.5);

        assertTrue(dao.isPresent(s1));

        Double s2 = dao.get(s1);
        assertEquals(1.5, s2);
        assertTrue(dao.isPresent(s1));
    }

    @Test
    public void testDelete() throws Exception {
        FXDao dao = new FXDao();
        String s1 = "EURUSD";
        dao.save(s1, 1.5);
        assertTrue(dao.isPresent(s1));
        dao.delete(s1);

        assertFalse(dao.isPresent(s1));
    }

    @Test
    public void testGetExchange() throws Exception {
        FXDao dao = mock(FXDao.class);
        when(dao.isPresent("EURUSD")).thenReturn(true);
        when(dao.get("EURUSD")).thenReturn(1.32);
        when(dao.convertToOtherCurrency(anyDouble(), any(CurrencyEnum.class), any(CurrencyEnum.class))).thenCallRealMethod();
        when(dao.getExchangeRate(any(CurrencyEnum.class), any(CurrencyEnum.class))).thenCallRealMethod();

        Double tot = dao.convertToOtherCurrency(1000.0, CurrencyEnum.EUR, CurrencyEnum.USD);

        verify(dao, times(1)).get("EURUSD");
        verify(dao, times(1)).isPresent("EURUSD");
        assertThat(tot, is(1320.0));
    }
}
