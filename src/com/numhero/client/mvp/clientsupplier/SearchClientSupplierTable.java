package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.widget.search.AbstractSearchTable;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public class SearchClientSupplierTable extends AbstractSearchTable {
    @Override
    public void setPojoCList(Collection<? extends SearchablePojo> pojoCList) {
        int row = 0;
        for (SearchablePojo p : pojoCList) {
            final ClientSupplier pojoC = (ClientSupplier) p;
            row++;
            Anchor l = new Anchor(pojoC.fName.getValue(), false);
            l.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    dialog.setPojo(pojoC);
                    dialog.hide();
                }
            });
            setWidget(row, 0, l);
            setText(row, 1, pojoC.fVat.getValue());
            setText(row, 2, pojoC.fCompanyEmail.getValue());
            setText(row, 3, pojoC.fCompanyPhone.getValue());
            setText(row, 4, pojoC.getCompleteAddress());
            setText(row, 5, pojoC.getContactDesc());
        }
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().companyName(), HasHorizontalAlignment.ALIGN_LEFT, "120px");
        setHeader(1, Application.getConstants().vat(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().email(), HasHorizontalAlignment.ALIGN_LEFT, "120px");
        setHeader(3, Application.getConstants().phone(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().address(), HasHorizontalAlignment.ALIGN_LEFT, "200px");
        setHeader(5, Application.getConstants().contact(), HasHorizontalAlignment.ALIGN_LEFT, "240px");
    }
}
