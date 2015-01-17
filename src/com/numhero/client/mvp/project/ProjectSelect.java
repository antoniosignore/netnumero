package com.numhero.client.mvp.project;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.model.datacargo.project.ProjectListRequest;
import com.numhero.client.model.datacargo.project.ProjectListResponse;
import com.numhero.client.model.datacargo.project.SaveProjectRequest;
import com.numhero.client.model.datacargo.project.SaveProjectResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.enums.BillingMethodEnum;

import java.util.Date;

public class ProjectSelect extends DropDownBox<ProjectListRequest, ProjectListResponse> {
    private Service<SaveProjectRequest, SaveProjectResponse> saveService;
    private Project project;
    private ProjectPanel projectPanel;

    public ProjectSelect(
            DropDownBox.DropDownBoxHandler handler,
            Service<ProjectListRequest, ProjectListResponse> getListService,
            Service<SaveProjectRequest, SaveProjectResponse> saveService,
            ProjectPanel projectPanel) {
        super(getListService, new ProjectListRequest());
        setHandler(handler);

        this.saveService = saveService;
        this.projectPanel = projectPanel;

        initPojo();
    }

    public void setProject(Long id, String name) {
        project.setId(id);
        project.fName.setValue(name);
        suggestBox.setValue(name, false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof Project) {
            this.project = (Project) pojo;
        }
    }

    @Override
    public Project getPojo() {
        return project;
    }

    @Override
    protected void initPojo() {
        project = new Project();
        project.fBillingMethod.setValue(BillingMethodEnum.FLAT_AMOUNT);
        project.setCreated(new Date());
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.addKey)) {
            showAddNewDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<ProjectListRequest, ProjectListResponse> so) {
        so.addAddNewItem();
        so.addMoreItem();
    }

    private void showAddNewDialog() {
        final ProjectDialog dlg = new ProjectDialog(saveService, projectPanel, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getProject() != null && dlg.getProject().getId() != null) {
                    project.setId(dlg.getProject().getId());
                    project.fName.setValue(dlg.getProject().fName.getValue());
                    suggestBox.setValue(dlg.getProject().getReplacementString());
                    handler.itemSelected(dlg.getProject());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchProjectDialog dlg = new SearchProjectDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    project.setId(dlg.getPojo().getId());
                    project.fName.setValue(dlg.getPojo().fName.getValue());
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
