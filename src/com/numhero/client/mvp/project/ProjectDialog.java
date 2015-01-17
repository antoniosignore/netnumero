package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.project.SaveProjectRequest;
import com.numhero.client.model.datacargo.project.SaveProjectResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.BillingMethodEnum;

import java.util.Date;

public class ProjectDialog extends DialogBox {

    private Project project;

    public ProjectDialog(final Service<SaveProjectRequest,
            SaveProjectResponse> projectSaveService,
                         final ProjectPanel projectPanel,
                         String projectName) {

        project = new Project();
        project.fBillingMethod.setValue(BillingMethodEnum.FLAT_AMOUNT);
        project.fCreated.setValue(new Date());
        project.fName.setValue(projectName);

        setText(Application.getConstants().newProject());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        projectPanel.setPojo(project);

        projectPanel.getTaskGroup().setVisible(false);
        projectPanel.getStaffGroup().setVisible(false);
        projectPanel.getHoursGroup().setVisible(false);
        projectPanel.getExpensesGroup().setVisible(false);

        projectPanel.getBtConvert().setVisible(false);
        projectPanel.getBtGenerateEstimate().setVisible(false);
        projectPanel.getBtGenerateInvoice().setVisible(false);


        projectPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (projectPanel.saveValuesFromUi()) {
                    SaveProjectRequest request = new SaveProjectRequest();
                    request.setProject(project);

                    Application.showGlasspanelLoading();
                    projectSaveService.execute(request, new ServiceCallbackImpl<SaveProjectResponse>() {
                        @Override
                        public void onSuccess(SaveProjectResponse response) {

                            project.setId(response.getEntityId());
                            Application.toasterMessage(Application.getConstants().projectSaved());
                            ProjectDialog.this.hide();
                        }
                    });
                }
            }
        });
        projectPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ProjectDialog.this.hide();
            }
        });
        setWidget(projectPanel);
        projectPanel.paint();
    }

    public Project getProject() {
        return project;
    }
}
