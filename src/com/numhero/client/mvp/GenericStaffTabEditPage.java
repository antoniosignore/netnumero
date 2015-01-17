package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.StaffTabDecorator;

public class GenericStaffTabEditPage extends TabbedEditPage {


    public GenericStaffTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new StaffTabDecorator());
    }
}
