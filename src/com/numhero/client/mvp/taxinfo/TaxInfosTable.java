package com.numhero.client.mvp.taxinfo;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public class TaxInfosTable extends AbstractTableForEntities<TaxInfo> {

    @Override
    public void setEntities(List<TaxInfo> taxInfos) {
        removeAllRows();
        int row = 0;
        for (TaxInfo tax : taxInfos) {
            row++;
            HTML hID = new HTML("<a href='#taxinfo/" + tax.getId() + "'>" + tax.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(tax.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, tax.getDescription());
            if (tax.fPercent != null && tax.fPercent.getValue() != null) {
                setText(row, 3, tax.fPercent.getValue() + "%");
            }
        }
        addEmptyStatus();
    }



	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_CENTER, "10px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().percent(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
