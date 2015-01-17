package com.numhero.client.mvp.task;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.model.datacargo.task.SaveTaskRequest;
import com.numhero.client.model.datacargo.task.SaveTaskResponse;
import com.numhero.client.model.datacargo.task.TaskListRequest;
import com.numhero.client.model.datacargo.task.TaskListResponse;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;

public class TaskSelect extends DropDownBox<TaskListRequest, TaskListResponse> {
    private Service<SaveTaskRequest, SaveTaskResponse> saveService;
    private Task task;
    private TaskPanel panel;

    public TaskSelect(DropDownBoxHandler handler,
                      Service<TaskListRequest, TaskListResponse> getListService,
                      Service<SaveTaskRequest, SaveTaskResponse> saveService,
                      TaskPanel panel) {
        super(getListService, new TaskListRequest());
        setHandler(handler);
        this.saveService = saveService;

        this.panel = panel;
        initPojo();
    }

    public void setTask(Long TaskId, String name) {
        task.setId(TaskId);
        task.fName.setValue(name);
        suggestBox.setValue(name, false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof Task) {
            this.task = (Task) pojo;
        }
    }

    @Override
    public Task getPojo() {
        return task;
    }

    @Override
    protected void initPojo() {
        this.task = new Task();
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

    protected void addCommandItems(ServerSuggestOracle<TaskListRequest, TaskListResponse> so) {
        so.addAddNewItem();
        so.addMoreItem();
    }

    private void showAddNewDialog() {
        final TaskDialog dlg = new TaskDialog(saveService, panel, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getTask() != null && dlg.getTask().getId() != null) {
                    suggestBox.setValue(dlg.getTask().getReplacementString());
                    handler.itemSelected(dlg.getTask());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchTaskDialog dlg = new SearchTaskDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
