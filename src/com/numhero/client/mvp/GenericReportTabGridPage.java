package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.ReportTabDecorator;

public class GenericReportTabGridPage extends GridTabbedPage {

    public GenericReportTabGridPage(AbstractTableForEntities tableForEntities) {
        super(tableForEntities, new ReportTabDecorator());
    }

}
