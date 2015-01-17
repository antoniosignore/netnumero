package com.numhero.client.mvp.project;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchProjectDialog extends SearchPojoDialog {

    public SearchProjectDialog(Service<ProjectListRequest, ProjectListResponse> getListService, String search) {
        super(Application.getConstants().searchProjects(), search, getListService, new SearchPanel(new SearchProjectTable()), new ProjectListRequest());
    }
}
