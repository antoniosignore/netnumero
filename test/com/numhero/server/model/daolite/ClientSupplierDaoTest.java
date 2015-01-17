package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ClientSupplierEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class ClientSupplierDaoTest extends BaseDaoTest {
    public static final String BA1 = "ba1";
    private ClientSupplierDao dao;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        dao = NumheroUtils.injector.getInstance(ClientSupplierDao.class);
    }

    @Test
    public void testGet() throws Exception {
        ClientSupplier c = dao.get(123L);
        assertNull(c);
    }

    @Test
    public void testSave() throws Exception {
        ClientSupplier c = newClient("Non solo moda");
        dao.save(c);
        Long id = c.getId();
//        System.err.println("id " + id);
        assertNotNull(id);
        assertNotNull(c.getCreated());
        assertThat(c.fCreated.getValueAsString(), equalTo(c.fLastUpdated.getValueAsString()));
        assertEquals(1, c.fDbVersion.intValue());

        ClientSupplier c2 = dao.get(id);
        assertNotNull(c2);
        assertEquals(c, c2);

    }

    @Test
    public void testUpdate() throws Exception {
        ClientSupplier c = newClient("Non solo moda");
        dao.save(c);
        Long id = c.getId();
//        System.err.println("id " + id);
        assertNotNull(id);
        c.fAddress.setValue("new address");
        dao.save(c);
        Long id2 = c.getId();
//        System.err.println("id " + id);
        assertEquals(id, id2);


    }

    @Test
    public void testDelete() throws Exception {
        ClientSupplier c = newClient("Non solo moda");
        dao.save(c);
        Long id = c.getId();
        assertNotNull(id);
        ClientSupplier c2 = dao.get(id);
        assertEquals("Non solo moda", c2.fName.getValue());

        dao.delete(id);
        ClientSupplier c3 = dao.get(id);
        assertNull(c3);
    }

    @Test
    public void testFindAll() throws Exception {
        create3clients();


        List<ClientSupplier> l = new ArrayList<ClientSupplier>();
        dao.findAll(l, "Il tuo Meccanico", 10);
        assertEquals(1, l.size());
        assertEquals("Fiat", l.get(0).fName.getValue());

        l.clear();
        dao.findAll(l, BA1, 10);
        assertEquals(3, l.size());

        List<ClientSupplier> clientSuppliers = dao.findByType("Il tuo Meccanico", 1, ClientSupplierEnum.client);
        assertEquals(1, clientSuppliers.size());
    }

    @Test
    public void testStartWith() throws Exception {
        dao.save(newClient("La trattoria"));
        dao.save(newClient("Lavapiatti"));
        List<ClientSupplier> cl = dao.searchForStartsWith("la", 20, BA1);
        assertEquals(2, cl.size());

        cl = dao.searchForStartsWith("la tra", 20, BA1);
        assertEquals(1, cl.size());


    }


    private ClientSupplier newClient(String name) {
        ClientSupplier ret = new ClientSupplier();
        ret.fClient.setValue(true);
        ret.fSupplier.setValue(false);
        ret.fAddress.setValue("via della Spiga, 32");
        ret.fCity.setValue("Milano");
        ret.fCompanyFax.setValue("12345");
        ret.fName.setValue(name);
        ret.fCompanyPhone.setValue("2345");
        ret.fBusinessAccountUri.setValue(BA1);

        return ret;
    }


    @Test
    public void testFindAllPaginated() throws Exception {
        create3clients();

        PaginatedList<ClientSupplier> pl = dao.findAllPaginated(BA1, 1, null, ClientSupplierEnum.client);
        assertEquals(1, pl.getList().size());
        assertEquals(true, pl.isFirstPage());
        assertEquals(false, pl.isLastPage());
    }


    @Test
    public void testPaginationTypeStatus() {
        dao.save(PojoTestUtils.createClientSupplier());
        dao.save(PojoTestUtils.createSupplier());
        create3clients();


        PaginatedList<ClientSupplier> searchRet = dao.findAllPaginated("ba1", 2, null, ClientSupplierEnum.client);
        List<ClientSupplier> list1 = searchRet.getList();
        assertEquals(2, list1.size());
        assertEquals("Da Franca", list1.get(0).fName.getValue());
        assertEquals("Il paradiso del calzino", list1.get(1).fName.getValue());
        assertTrue(searchRet.isFirstPage());
        assertFalse(searchRet.isLastPage());

        PaginatedList<ClientSupplier> paginated = dao.findAllPaginated("ba1", 2, list1.get(1).getId(), ClientSupplierEnum.client);
        List<ClientSupplier> list2 = paginated.getList();
        assertEquals(2, list2.size());
        assertEquals("Jim Walls & Co", list2.get(0).fName.getValue());
        assertEquals("Non solo moda", list2.get(1).fName.getValue());
        assertFalse(paginated.isFirstPage());
        assertTrue(paginated.isLastPage());


        PaginatedList<ClientSupplier> paginated2 = dao.findAllPaginated("ba1", -2, null, ClientSupplierEnum.client);
        assertEquals(2, paginated2.getList().size());
        assertFalse(paginated2.isFirstPage());
        assertTrue(paginated2.isLastPage());


        PaginatedList<ClientSupplier> paginated3 = dao.findAllPaginated("ba1", 2, null, ClientSupplierEnum.supplier);
        assertEquals(2, paginated3.getList().size());
        assertTrue(paginated3.isFirstPage());
        assertTrue(paginated3.isLastPage());

    }




    private void create3clients() {
        ClientSupplier c = newClient("Non solo moda");
        dao.save(c);
        ClientSupplier c1 = newClient("Da Franca");
        dao.save(c1);
        ClientSupplier c2 = newClient("Il paradiso del calzino");
        dao.save(c2);
        ClientSupplier c3 = newClient("Fiat");
        c3.fBusinessAccountUri.setValue("Il tuo Meccanico");
        dao.save(c3);
    }

}
