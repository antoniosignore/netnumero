package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.decorator.MoneyInDecorator;

public class GenericMoneyinTabViewPage extends AbstractTabbedPage {


    public GenericMoneyinTabViewPage(Widget  widget) {
        super(widget, new MoneyInDecorator());
    }

}
