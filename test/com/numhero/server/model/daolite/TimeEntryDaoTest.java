package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.widget.filter.BAPojoFilter;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TimeEntryDaoTest extends BaseDaoTest {

    private TimeEntryDao timeEntryDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        timeEntryDao = NumheroUtils.injector.getInstance(TimeEntryDao.class);
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(timeEntryDao);
    }

    @Test
    public void testSaveAndRetrieve() throws Exception {

        TimeEntry timeEntry = createTimeEntry();

        timeEntryDao.save(timeEntry);
        pm.flush();
        pm.evictAll();

        TimeEntry u2 = timeEntryDao.get(timeEntry.getId());

        assertEquals(timeEntry.getId(), u2.getId());
    }

    private TimeEntry createTimeEntry() {
        TimeEntry u = new TimeEntry();

        Date date = new Date();
//        u.setDayOfYear(DateUtils.getDayOfYear(date));
//        u.setWeekOfYear(DateUtils.getWeekOfYear(date));
//        u.setMonthOfYear(DateUtils.getMonthOfYear(date));
//        u.setYear(DateUtils.getYear(date));

        u.setCreated(date);
		u.fStaffId.setValue(123L);
		u.fStaffName.setValue("Pamela");

        u.setDescription("a time entry");
        u.fNotes.setValue("notes of the time entry");
        u.fHours.setValue(0.5);

        u.fBusinessAccountUri.setValue("ba1");
        return u;
    }

    @Test
    public void testSave() throws Exception {
        TimeEntry u = createTimeEntry();

        timeEntryDao.save(u);
        assertNotNull("failed to create timeEntry id", u.getId());

        List<TimeEntry> timeEntryList = timeEntryDao.findAll("ba1");

        for (int i = 0; i < timeEntryList.size(); i++) {
            TimeEntry user = timeEntryList.get(i);
            System.out.println("timeEntry.getId() = " + user.getId());
        }
    }

    @Test
    public void testFindByDate() {

        TimeEntry u = createTimeEntry();

        timeEntryDao.save(u);
        assertNotNull("failed to create user id", u.getId());

        List<TimeEntry> entries = timeEntryDao.findAll("ba1");

		BAPojoFilter filter = new BAPojoFilter();
		Date now = new Date();
		filter.setFrom(new Date(now.getTime() - 1000));
		filter.setTo(new Date(now.getTime() + 1000));
		List<TimeEntry> dayEntries = timeEntryDao.findTimeEntries("ba1", filter);
        assertNotNull(dayEntries);
        assertEquals(1, dayEntries.size());



    }

	    @Test
    public void testFindAllPaginated() {

        TimeEntry u = createTimeEntry();

        timeEntryDao.save(u);

			BAPojoFilter filter = new BAPojoFilter();
			filter.setStaff(PojoTestUtils.createStaff());
			PaginatedList<TimeEntry> entries = timeEntryDao.findAllPaginated("ba1", 10, null, filter);

			assertEquals(1, entries.getList().size());
			assertEquals(true, entries.isFirstPage());
			assertEquals(true, entries.isLastPage());


    }

}
