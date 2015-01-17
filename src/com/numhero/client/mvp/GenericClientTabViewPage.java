package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.ClientTabDecorator;

public class GenericClientTabViewPage extends GridTabbedPage {


    public GenericClientTabViewPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new ClientTabDecorator());
    }

}
