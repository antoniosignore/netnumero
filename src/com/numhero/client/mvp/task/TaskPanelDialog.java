package com.numhero.client.mvp.task;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

public class TaskPanelDialog extends DialogBox {

    @Inject
    public TaskPanelDialog(final Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
                           final TaskPanel taskPanel,
                           final Task task) {
        setText(Application.getConstants().createNewTask());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        taskPanel.setPojo(task);

        taskPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (taskPanel.saveValuesFromUi()) {
                    SaveTaskRequest request = new SaveTaskRequest();
                    request.setTask(task);
                    Application.showGlasspanelLoading();
                    taskSaveService.execute(request, new ServiceCallbackImpl<SaveTaskResponse>() {
                        @Override
                        public void onSuccess(SaveTaskResponse response) {
                            Application.toasterMessage(Application.getConstants().taskSaved());
                            task.setId(response.getEntityId());
                            TaskPanelDialog.this.hide();
                        }
                    });
                }
            }
        });
        taskPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TaskPanelDialog.this.hide();
            }
        });
        setWidget(taskPanel);
    }

}
