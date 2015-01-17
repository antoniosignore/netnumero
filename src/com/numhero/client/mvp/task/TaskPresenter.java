package com.numhero.client.mvp.task;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.task.GetTaskRequest;
import com.numhero.client.model.datacargo.task.GetTaskResponse;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.mvp.GenericTimeTabEditPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class TaskPresenter extends EditPresenter {

    Service<GetTaskRequest, GetTaskResponse> taskGetService;
    Service<SaveTaskRequest, SaveTaskResponse> taskSaveService;
    private TaskConstants constants;

    @Inject
    public TaskPresenter(PlaceManager eventManager,
                         Service<GetTaskRequest, GetTaskResponse> taskGetService,
                         Service<SaveTaskRequest, SaveTaskResponse> taskSaveService,
                         TaskPanel taskPanel,
                         TaskConstants constants) {
        super(eventManager, new GenericTimeTabEditPage(taskPanel));
        this.taskGetService = taskGetService;
        this.taskSaveService = taskSaveService;
        this.constants = constants;
    }

    private TaskPanel getTaskPanel() {
        return ((TaskPanel) getView().getContentPanel().getContentWidget());
    }

    @Override
    public GenericTimeTabEditPage getView() {
        return (GenericTimeTabEditPage) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getTaskPanel().setPojo(new Task());
            String constantsNewEntity = constants.createNewTask();
            getView().setDetailTitlePanel(constantsNewEntity);
        } else {
            String constantsEditEntity = constants.editTask();
            getView().setDetailTitlePanel(constantsEditEntity);
            GetTaskRequest request = new GetTaskRequest();
            request.setEntityId(getUrl().getId());

            taskGetService.execute(request, new ServiceCallbackImpl<GetTaskResponse>() {
                @Override
                public void onSuccess(GetTaskResponse response) {
                    getTaskPanel().setPojo(response.getEntity());
                }

            });
        }
    }

    private ClickHandler saveTaskHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getTaskPanel().saveValuesFromUi()) {
                    SaveTaskRequest request = new SaveTaskRequest();
                    request.setTask(getTaskPanel().getTask());
                    Application.showGlasspanelLoading();
                    taskSaveService.execute(request, new ServiceCallbackImpl<SaveTaskResponse>() {
                        @Override
                        public void onSuccess(SaveTaskResponse response) {
                            Application.toasterMessage(Application.getConstants().taskSaved());
                            redirect();
                        }
                    });
                }
            }
        };
        return ret;
    }

    @Override
    protected void onBind() {
        super.onBind();
        TaskPanel panel = getTaskPanel();

        panel.getBtSearch().addClickHandler(saveTaskHandler());
        panel.getBtCancel().setHref("#tasks");
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    @Override
    protected String getReturnUrl() {
        return "tasks";
    }
}
