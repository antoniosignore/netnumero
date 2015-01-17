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

public class TaskDialog extends DialogBox {

    private Task task;

    @Inject
    public TaskDialog(final Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
                      final TaskPanel taskPanel,
                      String taskName) {
        setText(Application.getConstants().createNewTask());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        task = new Task();
        task.fName.setValue(taskName);

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
                            TaskDialog.this.hide();
                        }
                    });
                }
            }
        });
        taskPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TaskDialog.this.hide();
            }
        });
        setWidget(taskPanel);
    }

    public Task getTask() {
        return task;
    }
}
