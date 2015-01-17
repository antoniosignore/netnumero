package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TasksSubmenu extends Composite {

    private static TasksSubmenuUiBinder uiBinder = GWT.create(TasksSubmenuUiBinder.class);

    interface TasksSubmenuUiBinder extends UiBinder<Widget, TasksSubmenu> {
    }

    public TasksSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
