package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.NumheroUtils;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.StaffTypeEnum;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StaffDaoTest extends BaseDaoTest {

	private StaffDao staffDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		staffDao = NumheroUtils.injector.getInstance(StaffDao.class);
	}

	@Test
	public void testInjection() throws Exception {
		assertNotNull(staffDao);
	}

	@Test
	public void testSaveAndRetrieve() throws Exception {

		Staff staff = createStaff();

		staffDao.save(staff);
		pm.flush();
		pm.evictAll();

		Staff u2 = staffDao.get(staff.getId());

		assertEquals(staff.getId(), u2.getId());
	}

	private Staff createStaff() {
		Staff staff = new Staff();
		staff.setStaffType(StaffTypeEnum.Contractor);
		staff.fBusinessAccountUri.setValue("ba1");
		return staff;
	}

	@Test
	public void testSave() throws Exception {
		Staff staff = createStaff();

		staffDao.save(staff);
		assertNotNull("failed to create staff id", staff.getId());
		List<Staff> staffs = staffDao.findAll("ba1");
		assertEquals(1, staffs.size());
	}

	@Test
	public void testFindByUserId() throws Exception {

		Staff staff = createStaff();
		staff.fUserId.setValue(12354L);
		staffDao.save(staff);

		Staff s2 = staffDao.findByUserId(staff.fBusinessAccountUri.getValue(), 12354L);
		assertEquals(staff, s2);
	}


	@Test
	public void testPaginated() throws Exception {

		Staff staff = createStaff();
		staff.fUserId.setValue(12354L);
		staffDao.save(staff);

		PaginatedList<Staff> pr = staffDao.findAllPaginated(staff.fBusinessAccountUri.getValue(), 10, null, StaffTypeEnum.Contractor);
		assertEquals(1, pr.getList().size());
		assertEquals(true, pr.isFirstPage());
		assertEquals(true, pr.isLastPage());

	}
}
