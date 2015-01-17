package com.numhero.client.mvp.product;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.shared.util.SharedUtils;

import java.util.List;

public class ProductsTable extends AbstractTableForEntities<ProductService> {

    @Override
    public void setEntities(List<ProductService> products) {
    	removeAllRows();
        int row = 0;
        for (ProductService product : products) {
            row++;
            HTML hID = new HTML("<a href='#product/" + product.getId() + "'>" + product.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(product.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, product.getDescription());
            setText(row, 3, SharedUtils.currencyToStr(product.getUnitPrice(), 2, product.getCurrency()));
//            setText(row, 4, SharedUtils.doubleToStr(product.getQuantity(), 2));
        }
       	addEmptyStatus();
    }



	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(3, Application.getConstants().price(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
//        setHeader(4, Application.getConstants().quantity(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
    }
}
