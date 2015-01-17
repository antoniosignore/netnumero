package com.numhero.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.numhero.client.Application;
import com.numhero.client.mvp.decorator.TabbedPageDecorator;
import com.numhero.shared.datacargo.ListCommandResponse;

import java.util.List;

public class GridTabbedPage extends AbstractTabbedPage implements GridPageView {
    private AbstractTableForEntities tableForEntities;

    public GridTabbedPage(AbstractTableForEntities tableForEntities, TabbedPageDecorator decorator) {
        super(tableForEntities, decorator);
        this.tableForEntities = tableForEntities;
    }

    @Override
    public void showLoading() {
        tableForEntities.showLoading();
    }

    //todo mikado should we make the view generic too?
    @Override
    public void putEntitiesInGrid(ListCommandResponse<?> response) {
        tableForEntities.putEntitiesInGrid(response);

    }

    @Override
    public List<Long> getSelectedIds() {
        return tableForEntities.getSelectedIds();
    }

    @Override
    public void prepareTable(ClickHandler lastPageClickHandler, ClickHandler firstPageClickHandler, ClickHandler prevPageClickHandler, ClickHandler nextPageClickHandler) {
        getTable().getFirstDataAnchor().setVisible(false);
        getTable().getLastDataAnchor().setVisible(false);
        getTable().getNextAnchor().setVisible(false);
        getTable().getPrevDataAnchor().setVisible(false);

        getTable().getNextAnchor().addClickHandler(nextPageClickHandler);
        getTable().getPrevDataAnchor().addClickHandler(prevPageClickHandler);
        getTable().getFirstDataAnchor().addClickHandler(firstPageClickHandler);
        getTable().getLastDataAnchor().addClickHandler(lastPageClickHandler);
    }

    private AbstractTableForEntities getTable() {
        return tableForEntities;
    }


    @Override
    public String getFirstRowKey() {
        return tableForEntities.getFirstRowKey();
    }

    @Override
    public String getLastRowKey() {
        return tableForEntities.getLastRowKey();
    }

    @Override
    public void setDetailTitlePanel(String titlePanel) {
        getContentPanel().setDetailTitlePanel(titlePanel);

    }

    @Override
    public void showDeletedEntitiesToaster() {
        showToaster(Application.getConstants().itemsDeleted());

    }

    @Override
    public void showToaster(String message) {
        Application.toasterMessage(message);
    }

    @Override
    public void showErrorDeleting() {
        showError(Application.getConstants().errorDeleting());

    }
    @Override
    public void ShowNoneSelectedError() {
        showError(Application.getConstants().oneRow());

    }

    @Override
    public void showError(String message) {
        Window.alert(message);

    }

    @Override
    public void addActionsCommands(CommandWrapper... commands) {
        MenuBar bulkActions = new MenuBar(true);
        for (CommandWrapper command : commands) {
            String name = command.getName();
            MenuItem menuItem = new MenuItem(name, command.getCommand());
            bulkActions.addItem(menuItem);
        }
        MenuItem mainItem = new MenuItem(Application.getConstants().bulkAction(), bulkActions);
        tableForEntities.getFooter().getTableFooterActionsCombo().setAnimationEnabled(true);
        tableForEntities.getFooter().getTableFooterActionsCombo().setAutoOpen(true);
        tableForEntities.getFooter().getTableFooterActionsCombo().addItem(mainItem);
    }

    @Override
    public void showOneRowError() {
        showError(Application.getConstants().oneRow());
    }
}
