package com.numhero.client.mvp.project;

import com.google.gwt.user.client.Command;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.project.DeleteProjectsRequest;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericTimeTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;


@Singleton
public class ProjectsPresenter extends GridPresenter {
    private Service<ProjectListRequest, ProjectListResponse> projectListService;
    private Service<DeleteProjectsRequest, BulkActionResponse> deleteProjectsService;
    private ProjectConstants constants;

    @Inject
    public ProjectsPresenter(PlaceManager eventManager,
                             Service<ProjectListRequest, ProjectListResponse> projectListService,
                             Service<DeleteProjectsRequest, BulkActionResponse> deleteProjectsService,
                             ProjectConstants constants) {
        super(eventManager, new GenericTimeTabViewPage(new ProjectsTable()));
        this.projectListService = projectListService;
        this.deleteProjectsService = deleteProjectsService;
        this.constants = constants;
    }

    @Override
    protected void onBind() {
        super.onBind();

        CommandWrapper deleteCommand = new CommandWrapper(constants.deleteProjects(), new Command() {
            public void execute() {
                deleteEntities(new DeleteProjectsRequest(), deleteProjectsService);
            }
        });

        getView().addActionsCommands(deleteCommand);
    }


    protected void refreshFromServer() {
        ProjectListRequest request = new ProjectListRequest();

        setPagination(request);
        super.refreshFromServer();

        projectListService.execute(request, new ServiceCallbackImpl<ProjectListResponse>() {
            @Override
            public void onSuccess(ProjectListResponse response) {

                getView().putEntitiesInGrid(response);

            }
        });
    }

}
