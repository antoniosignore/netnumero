package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProjectsSubmenu extends Composite {

    private static ProjectsSubmenuUiBinder uiBinder = GWT
            .create(ProjectsSubmenuUiBinder.class);

    interface ProjectsSubmenuUiBinder extends UiBinder<Widget, ProjectsSubmenu> {
    }

    public ProjectsSubmenu() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
