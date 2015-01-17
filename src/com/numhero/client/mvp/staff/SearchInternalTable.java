package com.numhero.client.mvp.staff;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.widget.search.AbstractSearchTable;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public class SearchInternalTable extends AbstractSearchTable {
    @Override
    public void setPojoCList(Collection<? extends SearchablePojo> pojoCList) {
        int row = 0;
        for (SearchablePojo p : pojoCList) {
            row++;
            final Staff pojoC = (Staff) p;

            Anchor l = new Anchor(pojoC.fName.getValue(), true);
            l.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    dialog.setPojo(pojoC);
                    dialog.hide();
                }
            });

            setWidget(row, 0, l);
            setText(row, 1, pojoC.getEmail());
            setText(row, 2, pojoC.getPhone());
            setText(row, 3, pojoC.getMobile());
            setText(row, 4, pojoC.getAddress());
            setText(row, 5, pojoC.getZipCode());
            setText(row, 6, pojoC.getCity());
        }
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(1, Application.getConstants().email(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(2, Application.getConstants().phone(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().mobile(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(4, Application.getConstants().address(), HasHorizontalAlignment.ALIGN_LEFT, "200px");
        setHeader(5, Application.getConstants().zip(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(6, Application.getConstants().city(), HasHorizontalAlignment.ALIGN_LEFT, "%");
    }
}
