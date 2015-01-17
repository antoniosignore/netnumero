package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.AccountsDecorator;

public class GenericAccountsTabViewPage extends GridTabbedPage {

    //todo mikado: these views should go away
    public GenericAccountsTabViewPage(AbstractTableForEntities table) {
        super(table, new AccountsDecorator());

    }


}
