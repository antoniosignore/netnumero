package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.timeentry.SaveTimeEntryRequest;
import com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.ProjectTaskDetail;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.server.model.daolite.ProjectDao;
import com.numhero.server.model.daolite.TimeEntryDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.enums.TaskStatusEnum;
import com.numhero.shared.pojoc.field.OwnedListField;

import java.util.logging.Logger;

public class CommandSaveTimeEntry extends AbstractAuthenticatedCommand<SaveTimeEntryRequest, SaveTimeEntryResponse> {
    private static final Logger log = Logger.getLogger(CommandSaveTimeEntry.class.getName());

    @Inject
    TimeEntryDao timeEntryDao;

    @Inject
    ProjectDao projectDao;

    @Override
    public SaveTimeEntryResponse execute(SaveTimeEntryRequest request) {

        TimeEntry timeEntry = (TimeEntry) request.getEntity();
        Long projectId = timeEntry.fProjectId.getValue();
        log.info("projectId = " + projectId);

        log.info("timeEntry = " + timeEntry.fDate.getValue());

        DaoUtils.setData(request, timeEntry);
        timeEntryDao.save(timeEntry);

        Project project = projectDao.get(projectId);
        OwnedListField<ProjectTaskDetail> fProjectTaskDetails = project.fProjectTaskDetails;
        for (int i = 0; i < fProjectTaskDetails.size(); i++) {
            ProjectTaskDetail projectTaskDetail = fProjectTaskDetails.get(i);
            if (projectTaskDetail.getId().longValue() == (timeEntry.fTaskId.getValue().longValue()))
                projectTaskDetail.fStatus.setValue(TaskStatusEnum.working);
        }

        projectDao.save(project);

        // createAudit
        SaveTimeEntryResponse response = new SaveTimeEntryResponse();
        response.setEntityId(timeEntry.getId());
        return response;
    }
}
