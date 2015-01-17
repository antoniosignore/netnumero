package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.ProjectStaffDetail;
import com.numhero.client.model.pojoc.ProjectTaskDetail;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedList;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ProjectDaoTest extends BaseDaoTest {

    private ProjectDao projectDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        projectDao = NumheroUtils.injector.getInstance(ProjectDao.class);
    }

    @Test
    public void testInjection() throws Exception {
        assertNotNull(projectDao);
    }

    @Test
    public void testSaveAndRetrieve() throws Exception {

        Project project = PojoTestUtils.createProject();

        projectDao.save(project);
        pm.flush();
        pm.evictAll();

        Project u2 = projectDao.get(project.getId());

        assertEquals(project.getId(), u2.getId());

        Long pk = project.getId();
        projectDao.delete(project);

        Project u3 = projectDao.get(pk);
        assertNull(u3);

    }


    @Test
    public void testSave() throws Exception {
        Project project = PojoTestUtils.createProject();

        ProjectTaskDetail task = PojoTestUtils.createProjectTaskDetail();
        project.fProjectTaskDetails.add(task);

        projectDao.save(project);
        assertNotNull("failed to create project id", project.getId());

        pm.flush();
        pm.evictAll();

        Project project2 = projectDao.get(project.getId());

        assertEquals(project.getId(), project2.getId());
        assertEquals(1, project2.fProjectTaskDetails.size());

    }

    @Test
    public void testDetails() throws Exception {
        Project project = PojoTestUtils.createProject();
        project.fProjectTaskDetails.add(PojoTestUtils.createProjectTaskDetail());
        project.fProjectTaskDetails.addDetail(PojoTestUtils.createProjectTaskDetail());
        project.fProjectTaskDetails.addDetail(PojoTestUtils.createProjectTaskDetail());
        assertEquals(3, project.fProjectTaskDetails.size());

        project.fProjectStaffDetails.add(createStaff());
        project.fProjectStaffDetails.addDetail(createStaff());
        project.fProjectStaffDetails.add(createStaff());
        assertEquals(3, project.fProjectStaffDetails.size());

    }


    @Test
    public void testOrphans() throws Exception {
        Project project = PojoTestUtils.createProject();

        ProjectTaskDetail task = PojoTestUtils.createProjectTaskDetail();
        project.fProjectTaskDetails.add(task);

        projectDao.save(project);
        assertNotNull("failed to create project id", project.getId());

        pm.flush();
        pm.evictAll();

        Project project2 = projectDao.get(project.getId());

        assertEquals(project.getId(), project2.getId());
        assertEquals(1, project2.fProjectTaskDetails.size());

        ProjectTaskDetail task2 = PojoTestUtils.createProjectTaskDetail();
        task2.fName.setValue("task2");
        project2.fProjectTaskDetails.add(task2);
        assertEquals(2, project2.fProjectTaskDetails.size());

        projectDao.save(project2);
        assertEquals(2, project2.fProjectTaskDetails.size());

        Project project22 = projectDao.get(project2.getId());
        assertEquals(2, project22.fProjectTaskDetails.size());

        project2.fProjectTaskDetails.clear();
        projectDao.save(project2);
        assertEquals(0, project2.fProjectTaskDetails.size());

        pm.flush();
        pm.evictAll();

        Project project3 = projectDao.get(project.getId());
        assertEquals(0, project3.fProjectTaskDetails.size());

    }

	@Test
	public void testFindAllPaginated() {
		projectDao.save(PojoTestUtils.createProject());

		PaginatedList<Project> ul = projectDao.findAllPaginated("ba1", 10, null);
		assertThat(ul.getList().size(), is(equalTo(1)));
		assertThat(ul.isFirstPage(), is(equalTo(Boolean.TRUE)));
		assertThat(ul.isLastPage(), is(equalTo(Boolean.TRUE)));

	}


    private ProjectStaffDetail createStaff() {

        return new ProjectStaffDetail();
    }
}
