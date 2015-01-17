package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.MoneyOutDecorator;

public class GenericMoneyoutTabEditPage extends TabbedEditPage {


    public GenericMoneyoutTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new MoneyOutDecorator());
    }
}
