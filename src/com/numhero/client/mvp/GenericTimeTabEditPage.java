package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.TimeTabDecorator;

public class GenericTimeTabEditPage extends TabbedEditPage {


    public GenericTimeTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new TimeTabDecorator());
    }
}
