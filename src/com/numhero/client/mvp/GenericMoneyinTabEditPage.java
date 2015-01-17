package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.MoneyInDecorator;

public class GenericMoneyinTabEditPage extends TabbedEditPage {

    public GenericMoneyinTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new MoneyInDecorator());
    }

}
