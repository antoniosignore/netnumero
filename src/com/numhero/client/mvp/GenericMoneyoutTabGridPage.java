package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.MoneyOutDecorator;

public class GenericMoneyoutTabGridPage extends GridTabbedPage {


    public GenericMoneyoutTabGridPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new MoneyOutDecorator());

    }

}
