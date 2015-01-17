package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.mvp.feedback.FeedbackDialog;
import com.numhero.client.mvp.reportbug.ReportBugDialog;

public class Footer extends Composite {

    private static FooterUiBinder uiBinder = GWT.create(FooterUiBinder.class);

    @UiField
    Anchor reportBug;

    @UiField
    Anchor contactUs;

    interface FooterUiBinder extends UiBinder<Widget, Footer> {
    }

    public Footer() {
        initWidget(uiBinder.createAndBindUi(this));

        reportBug.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final ReportBugDialog dialog = new ReportBugDialog();
                dialog.center();
            }
        });

        contactUs.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final FeedbackDialog dialog = new FeedbackDialog();
                dialog.center();
            }
        });


    }
}
