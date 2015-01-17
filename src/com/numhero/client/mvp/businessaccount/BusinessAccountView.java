package com.numhero.client.mvp.businessaccount;

import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.TabbedEditPage;
import com.numhero.client.mvp.decorator.DashboardTabDecorator;

public class BusinessAccountView extends TabbedEditPage {

    public BusinessAccountView(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new DashboardTabDecorator());
    }

    public BusinessAccountPanel getBusinessAccountPanel() {
        return (BusinessAccountPanel) entityPanel;
    }
}
