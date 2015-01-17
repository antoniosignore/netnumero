package com.numhero.client.model.datacargo.project;

import com.numhero.client.model.pojoc.Project;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveProjectRequest extends SaveSingleEntityRequest {

    public SaveProjectRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveProject);
    }

    public Project getProject() {
        return (Project) getEntity();
    }

    public void setProject(Project project) {
        setEntity(project);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new ProjectListRequest() };
    }
}
