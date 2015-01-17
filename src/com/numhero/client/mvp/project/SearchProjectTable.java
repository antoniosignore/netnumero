package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.widget.search.AbstractSearchTable;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public class SearchProjectTable extends AbstractSearchTable {
    @Override
    public void setPojoCList(Collection<? extends SearchablePojo> pojoCList) {
        int row = 0;
        for (SearchablePojo p : pojoCList) {
            row++;
            final Project pojoC = (Project) p;

            Anchor l = new Anchor(pojoC.fName.getValue(), false);
            l.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    dialog.setPojo(pojoC);
                    dialog.hide();
                }
            });

            setWidget(row, 0, l);
            setText(row, 1, pojoC.getDescription());
            if (pojoC.getCreated() != null)
                setText(row, 2, DateTimeFormat.getShortDateFormat().format(pojoC.getCreated()));
            if (pojoC.fLastBilled.getValue() != null)
                setText(row, 3, DateTimeFormat.getShortDateFormat().format(pojoC.fLastBilled.getValue()));
            if (pojoC.fState.getValue() != null)
                setText(row, 4, pojoC.fState.getValue().name());
            if (pojoC.fBillableTime.getValue() != null)
                setText(row, 5, pojoC.fBillableTime.getValueAsString());
            if (pojoC.fTotalBilledTime.getValue() != null)
                setText(row, 6, pojoC.fTotalBilledTime.getValueAsString());
        }
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().created(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().lastBilled(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().state(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().notBilledHours(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(6, Application.getConstants().totalHours(), HasHorizontalAlignment.ALIGN_LEFT, "80px");

    }
}
