package com.numhero.client.mvp.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.numhero.client.Application;

public class UsersPanel extends Composite {
    interface UsersUiBinder extends UiBinder<VerticalPanel, UsersPanel> {
    }

    private static UsersUiBinder uiBinder = GWT.create(UsersUiBinder.class);

    @UiField
    HTML hdTitle;

    @UiField
    UsersTable usersTable;

    public UsersPanel() {
        initWidget(uiBinder.createAndBindUi(this));
        hdTitle.setHTML(Application.getConstants().users());
    }

    public UsersTable getUsersTable() {
        return usersTable;
    }
}