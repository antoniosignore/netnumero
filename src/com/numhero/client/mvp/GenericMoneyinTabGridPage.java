package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.MoneyInDecorator;

public class GenericMoneyinTabGridPage extends GridTabbedPage {


    public GenericMoneyinTabGridPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new MoneyInDecorator());
    }

}
