package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.decorator.MoneyOutDecorator;

public class GenericMoneyoutTabViewPage extends AbstractTabbedPage {


    public GenericMoneyoutTabViewPage(Widget widget) {
        super(widget, new MoneyOutDecorator());

    }

}
