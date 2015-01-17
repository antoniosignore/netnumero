package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.ClientTabDecorator;

public class GenericClientTabEditPage extends TabbedEditPage {


    public GenericClientTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new ClientTabDecorator());
    }


}
