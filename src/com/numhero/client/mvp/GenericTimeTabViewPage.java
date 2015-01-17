package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.TimeTabDecorator;

public class GenericTimeTabViewPage extends GridTabbedPage{


    public GenericTimeTabViewPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new TimeTabDecorator());
    }
}
