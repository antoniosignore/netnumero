package com.numhero.client.widget.table;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.util.TableToExcelClient;
import com.numhero.client.widget.TableFooterPanel;
import com.numhero.client.widget.filter.FilterPanel;

public abstract class AbstractTableWithHeaderAndFooter extends VerticalPanel {


    protected FilterPanel filter;
    protected FlexTableWithHeader table;
    protected TableFooterPanel footer;

    protected boolean showCheckboxes = true;

    public AbstractTableWithHeaderAndFooter(FilterPanel filter) {
        this.filter = filter;
        init();
    }

    public AbstractTableWithHeaderAndFooter() {
        init();
    }

    public void showLoading() {
        table.showLoading();
    }

    public void addEmptyStatus() {
        table.addEmptyStatus();
    }

    public void setHeader(int column, String text, HorizontalAlignmentConstant alignment, String width) {
        table.setHeader(column, text, alignment, width, null);
    }

    public void setWidget(int row, int column, Widget widget) {
        table.hideLoading();
        table.setWidget(row, column, widget);
    }

    public Widget getWidget(int row, int column) {
        return table.getWidget(row, column);
    }

    public void setText(int row, int column, String text) {
        table.hideLoading();
        table.setText(row, column, text);
    }

    public void removeAllRows() {
        table.removeAllRows();
    }

    public Image getLastDataAnchor() {
        return footer.getLastData();
    }

    public Image getFirstDataAnchor() {
        return footer.getFirstData();
    }

    public Image getNextAnchor() {
        return footer.getNextData();
    }

    public Image getPrevDataAnchor() {
        return footer.getPrevData();
    }

    public TableFooterPanel getFooter() {
        return footer;
    }

    public FilterPanel getFilter() {
        return filter;
    }


    // private methods ---------------------------------
    protected void init() {
        setWidth("100%");
        addFilter();
        addTable();
        addFooter();
    }

    protected void addFilter() {
        if (filter != null) {
            add(filter);
        }
    }

    protected void addTable() {
        table = new FlexTableWithHeader();
        table.setWidth("100%");
        table.setStyleName("inh-standard");
        setHeader();
        add(table);

    }

    protected void addFooter() {
        footer = new TableFooterPanel();
        add(footer);
        footer.getFootPanel().add(new TableToExcelClient(table, new Image("../../i/common/16/excel.png"), "excel").build());
    }


    protected abstract void setHeader();

    public void hideNavigationButtons() {

        getFirstDataAnchor().setVisible(false);
        getLastDataAnchor().setVisible(false);
        getNextAnchor().setVisible(false);
        getPrevDataAnchor().setVisible(false);
    }

}
