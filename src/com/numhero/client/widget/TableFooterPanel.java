package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class TableFooterPanel extends Composite {

    private static TableFooterPanelUiBinder uiBinder = GWT.create(TableFooterPanelUiBinder.class);

    @UiField
    MenuBar tableFooterActionsCombo;

    @UiField
    Image nextData;

    @UiField
    Image prevData;

    @UiField
    Image firstData;

    @UiField
    Image lastData;

    @UiField
    HorizontalPanel footPanel;

    public MenuBar getTableFooterActionsCombo() {
        return tableFooterActionsCombo;
    }

    interface TableFooterPanelUiBinder extends
            UiBinder<Widget, TableFooterPanel> {
    }

    public TableFooterPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public Image getNextData() {
        return nextData;
    }

    public Image getPrevData() {
        return prevData;
    }

    public Image getFirstData() {
        return firstData;
    }

    public Image getLastData() {
        return lastData;
    }

    public HorizontalPanel getFootPanel() {
        return footPanel;
    }

    public void setFootPanel(HorizontalPanel footPanel) {
        this.footPanel = footPanel;
    }
}
