package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public class ClientSuppliersTable extends AbstractTableForEntities<ClientSupplier> {

    public void setEntities(List<ClientSupplier> clientSuppliers) {
        removeAllRows();
        int row = 0;
        for (ClientSupplier cs : clientSuppliers) {
            row++;
            HTML hID = null;
            if (cs.fClient.getValue())
                hID = new HTML("<a href='#client/" + cs.getId() + "'>" + cs.fName.getValue() + "</a>");
            else
                hID = new HTML("<a href='#supplier/" + cs.getId() + "'>" + cs.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(cs.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, cs.fVat.getValue());
            setText(row, 3, cs.fCompanyEmail.getValue());
            setText(row, 4, cs.fCompanyPhone.getValue());
            setText(row, 5, cs.getCompleteAddress());
            setText(row, 6, cs.getContactDesc());
        }
        addEmptyStatus();
    }

    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().companyName(), HasHorizontalAlignment.ALIGN_LEFT, "120px");
        setHeader(2, Application.getConstants().vat(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().email(), HasHorizontalAlignment.ALIGN_LEFT, "120px");
        setHeader(4, Application.getConstants().phone(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().address(), HasHorizontalAlignment.ALIGN_LEFT, "200px");
        setHeader(6, Application.getConstants().contact(), HasHorizontalAlignment.ALIGN_LEFT, "240px");
    }
}
