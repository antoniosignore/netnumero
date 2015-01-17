package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.client.widget.filter.FilterPanel;
import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.datacargo.ListCommandResponse;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTableForEntities<T extends SuggestOracle.Suggestion> extends AbstractTableWithHeaderAndFooter{

    private static final String ALL = "__ALL__";

    protected AbstractTableForEntities() {
    }

    protected AbstractTableForEntities(FilterPanel filter) {
        super(filter);
    }

    public List<Long> getSelectedIds() {
        List<Long> ret = new ArrayList<Long>();
        if (showCheckboxes) {
            int rowCount = table.getRowCount();
            for (int i = 1; i < rowCount; i++) {
                CheckBox box = (CheckBox) table.getWidget(i, 0);
                if (box != null && box.getValue()) {
                    ret.add(Long.parseLong(box.getFormValue()));
                }
            }
        }
        return ret;
    }

    protected CheckBox getCheckbox(Long id) {
        return getCheckbox(id.toString());

    }

    protected CheckBox getCheckbox(String id) {
        CheckBox box = new CheckBox();
        box.setFormValue(id);
        return box;
    }

    protected CheckBox getAllCheckbox() {
        CheckBox box = new CheckBox();
        box.setFormValue(ALL);
        return box;
    }

    public String getFirstRowKey() {
        if (table.getRowCount() > 1) {
            CheckBox box = (CheckBox) table.getWidget(1, 0);
            if (box != null) {
                return box.getFormValue();
            }
        }
        return null;
    }

    public String getLastRowKey() {
        if (table.getRowCount() > 1) {
            CheckBox box = (CheckBox) table.getWidget(table.getRowCount() - 1, 0);
            if (box != null) {
                return box.getFormValue();
            }
        }
        return null;
    }



    public void manageNavigationBar(boolean empty, boolean firstPage, boolean lastPage) {

        if (empty) {
            hideNavigationButtons();
            return;
        }

        if (firstPage) {
            getFirstDataAnchor().setVisible(false);
            getPrevDataAnchor().setVisible(false);
        } else {
            getFirstDataAnchor().setVisible(true);
            getPrevDataAnchor().setVisible(true);
        }

        if (lastPage) {
            getLastDataAnchor().setVisible(false);
            getNextAnchor().setVisible(false);
        } else {
            getLastDataAnchor().setVisible(true);
            getNextAnchor().setVisible(true);
        }

    }

    protected abstract void setEntities(List<T> entities);

    public void putEntitiesInGrid(ListCommandResponse<T> response) {
        setEntities(response.getEntityList());
        manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
    }

}
