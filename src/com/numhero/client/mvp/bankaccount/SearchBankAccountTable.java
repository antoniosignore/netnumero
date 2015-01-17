package com.numhero.client.mvp.bankaccount;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.BankAccount;
import com.numhero.client.widget.search.AbstractSearchTable;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public class SearchBankAccountTable extends AbstractSearchTable {
    @Override
    public void setPojoCList(Collection<? extends SearchablePojo> pojoCList) {
        int row = 0;
        for (SearchablePojo p : pojoCList) {
            row++;
            final BankAccount pojoC = (BankAccount) p;

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
            else
                setText(row, 2, "");
        }
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().created(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
