package com.numhero.client.widget.table;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TableDetailToolbar extends Composite {
    interface InvoiceDetailToolbarUiBinder extends UiBinder<Widget, TableDetailToolbar> {
    }

    private static InvoiceDetailToolbarUiBinder uiBinder = GWT.create(InvoiceDetailToolbarUiBinder.class);

//    @UiField
//    Anchor btDetail;

    @UiField
    Anchor btDelete;

    @UiField
    Anchor btMoveUp;

    @UiField
    Anchor btMoveDown;

    public TableDetailToolbar() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Anchor getBtDelete() {
        return btDelete;
    }

    public Anchor getBtMoveUp() {
        return btMoveUp;
    }

    public Anchor getBtMoveDown() {
        return btMoveDown;
    }

//    public Anchor getBtDetail() {
//        return btDetail;
//    }
}
