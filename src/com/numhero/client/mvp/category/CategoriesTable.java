package com.numhero.client.mvp.category;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public class CategoriesTable extends AbstractTableForEntities<Category> {

    @Override
    public void setEntities(List<Category> categories) {
        removeAllRows();
        int row = 0;
        for (Category category : categories) {
            row++;
            HTML hID = new HTML("<a href='#category/" + category.getId() + "'>" + category.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(category.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, category.getDescription());
//            setText(row, 3, category.fTaxPercent.getValueAsString() + "%");

        }
        
        addEmptyStatus();

    }


	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "2%");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_CENTER, "18%");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "80%");
//        setHeader(3, Application.getConstants().taxPercent(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }



}
