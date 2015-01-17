package com.numhero.client.mvp.product;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.widget.search.AbstractSearchTable;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public class SearchProductTable extends AbstractSearchTable {
    @Override
    public void setPojoCList(Collection<? extends SearchablePojo> entityBasePojos) {
        int row = 0;
        for (SearchablePojo p : entityBasePojos) {
            row++;
            final ProductService productService = (ProductService) p;

            Anchor l = new Anchor(productService.fName.getValue(), false);
            l.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    dialog.setPojo(productService);
                    dialog.hide();
                }
            });

            setWidget(row, 1, l);
            setText(row, 2, productService.getDescription());
            NumberTextBox nbPrice = new NumberTextBox(productService.getCurrency(), productService.getUnitPrice(), true, 2);
            setWidget(row, 3, nbPrice);
        }
    }

    protected void setHeader() {
        setHeader(0, Application.getConstants().type(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "%");
        setHeader(3, Application.getConstants().price(), HasHorizontalAlignment.ALIGN_RIGHT, "80px");
    }
}
