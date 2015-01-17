package com.numhero.client.mvp.service;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class ServicesTable extends AbstractTableForEntities<ProductService> {

    public void setEntities(List<ProductService> serviceCs) {
        removeAllRows();
        int row = 0;
        for (ProductService serviceC : serviceCs) {
            row++;
            HTML hID = new HTML("<a href='#service/" + serviceC.getId() + "'>" + serviceC.fName.getValue() + "</a>");

            setWidget(row, 0, getCheckbox(serviceC.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, serviceC.getDescription());
            setText(row, 3, SharedUtils.currencyToStr(serviceC.getUnitPrice(), 2, serviceC.getCurrency()));
            setText(row, 4, serviceC.getServiceUnit().name());
        }
        addEmptyStatus();
    }


	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(3, Application.getConstants().price(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
        setHeader(4, Application.getConstants().serviceUnit(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
    }
}
