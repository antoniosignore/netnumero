package com.numhero.client.mvp;

import com.numhero.client.mvp.decorator.ReportTabDecorator;

public class GenericReportTabEditPage extends TabbedEditPage {


    public GenericReportTabEditPage(AbstractEditEntityPanel entityPanel) {
        super(entityPanel, new ReportTabDecorator());
    }
}
