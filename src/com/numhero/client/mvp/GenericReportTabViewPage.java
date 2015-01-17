package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.decorator.ReportTabDecorator;

public class GenericReportTabViewPage extends AbstractTabbedPage {


    public GenericReportTabViewPage(Widget widget) {
        super(widget, new ReportTabDecorator());
    }

}
