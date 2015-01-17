package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.project.DeleteProjectsRequest;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.mvp.project.ProjectsPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ProjectsPresenterProxy extends PresenterProxy<ProjectsPresenter> {
    @Override
    protected ProjectsPresenter createPresenter() {

        return new ProjectsPresenter(getEventManager(),
                PresenterProxy.<ProjectListRequest, ProjectListResponse>createNewService(),
                PresenterProxy.<DeleteProjectsRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
