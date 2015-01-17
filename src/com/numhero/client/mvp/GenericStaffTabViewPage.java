package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.StaffTabDecorator;

public class GenericStaffTabViewPage extends GridTabbedPage {


    public GenericStaffTabViewPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new StaffTabDecorator());
    }
}
