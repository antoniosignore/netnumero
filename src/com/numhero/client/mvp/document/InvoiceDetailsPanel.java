package com.numhero.client.mvp.document;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.client.widget.textbox.NumberTextBox;

public class InvoiceDetailsPanel extends FocusPanel implements FocusHandler, BlurHandler {
    private boolean isFocused;

    protected FlexTableWithHeader table;
    protected int highlightedRow;
    protected int highlightedCol;
    private int maximumCol;

    public InvoiceDetailsPanel(FlexTableWithHeader table, int maximumCol) {
        super(table);
        this.table = table;
        this.maximumCol = maximumCol;
        sinkEvents(Event.ONMOUSEDOWN | Event.ONMOUSEOVER | Event.ONMOUSEOUT | Event.ONKEYDOWN);
        addFocusHandler(this);
        addBlurHandler(this);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);

        rowInRange();
        colInRange();
        int hRow = highlightedRow;
        int hCol = highlightedCol;

        switch (DOM.eventGetType(event)) {
            case Event.ONMOUSEDOWN:
                int[] coordinates = table.getCoordinates(event);
                highlightedRow = coordinates[0];
                highlightedCol = coordinates[1];
                break;
            case Event.ONKEYDOWN:
                if (!isFocused) {
                    if (event.getKeyCode() == KeyCodes.KEY_ENTER || event.getKeyCode() == KeyCodes.KEY_ESCAPE) {
                        setFocus(true);
                    } else if (event.getKeyCode() == KeyCodes.KEY_TAB) {
                        setFocus(true);
                        if (!event.getShiftKey()) {
                            highlightedCol++;
                        } else {
                            highlightedCol--;
                        }
                    }
                } else {
                    if (event.getKeyCode() == KeyCodes.KEY_HOME) {
                        highlightedCol = 0;
                    } else if (event.getKeyCode() == KeyCodes.KEY_END) {
                        highlightedCol = maximumCol;
                    } else if (event.getKeyCode() == KeyCodes.KEY_DOWN) {
                        highlightedRow++;
                    } else if (event.getKeyCode() == KeyCodes.KEY_UP) {
                        highlightedRow--;
                    } else if (event.getKeyCode() == KeyCodes.KEY_LEFT) {
                        highlightedCol--;
                    } else if (event.getKeyCode() == KeyCodes.KEY_RIGHT) {
                        highlightedCol++;
                    } else if (event.getKeyCode() == KeyCodes.KEY_TAB) {
                        // do not focus the child
                    } else if (!event.getAltKey() && !event.getCtrlKey()) {
                        Widget w = table.getWidget(highlightedRow, highlightedCol);
                        ((Focusable) w).setFocus(true);
                        if (w instanceof DropDownBox<?, ?>) {
                            ((DropDownBox<?, ?>) w).getSuggestBox().getTextBox().selectAll();
                        } else if (w instanceof NumberTextBox) {
                            ((NumberTextBox) w).getAmountBox().selectAll();
                        } else if (w instanceof TextBoxBase) {
                            ((TextBoxBase) w).selectAll();
                        }
                    }
                    break;
                }
        }

        rowInRange();
        colInRange();
        if (hRow != highlightedRow || hCol != highlightedCol) {
            event.stopPropagation();
            showNormal(hRow, hCol);
            showHighlighted();
        }
    }

    @Override
    public void onFocus(FocusEvent event) {
        isFocused = true;
        showHighlighted();
    }

    @Override
    public void onBlur(BlurEvent event) {
        isFocused = false;
        showNormal(highlightedRow, highlightedCol);
    }

    // private methods -------------------------------
    protected void showHighlighted() {
        if (highlightedRow >= 0 && highlightedCol >= 0)
            table.getCellFormatter().setStylePrimaryName(highlightedRow, highlightedCol, "netnumero-highlighted-row");
    }

    protected void showNormal(int row, int col) {
        if (row >= 0 && col >= 0)
            table.getCellFormatter().setStylePrimaryName(row, col, "netnumero-row");
    }

    private void rowInRange() {
        if (highlightedRow < 0) {
            highlightedRow = table.getRowCount() - 1;
        } else if (highlightedRow > table.getRowCount() - 1) {
            highlightedRow = 0;
        }
    }

    private void colInRange() {
        if (highlightedCol < 0) {
            highlightedCol = maximumCol;
        } else if (highlightedCol > 6) {
            highlightedCol = 0;
        }
    }
}
