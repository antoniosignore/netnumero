package com.numhero.client.widget.table;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.numhero.client.Application;

public class FlexTableWithHeader extends FlexTable {
    public static final String NETNUMERO_ROW = "netnumero-row";
    private Element headElement;
    private Element headerTr;
    private Element highlightedRowElem;

    protected Image loadingImage;
    private boolean loadingShowing;

    public FlexTableWithHeader() {
        getColumnFormatter().getStyleName(0); // dummy call to be sure <colgroup> is created before the <thead>
        headElement = DOM.createTHead();
        headerTr = DOM.createTR();
        loadingImage = new Image("../../i/common/ajax-loader.gif");
        DOM.insertChild(this.getElement(), headElement, 1);
        DOM.insertChild(headElement, headerTr, 0);
        sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT);
    }

    public void removeHeaderRow() {
        int columnCount = DOM.getChildCount(headerTr);
        for (int column = 0; column < columnCount; ++column) {
            DOM.removeChild(headerTr, DOM.getChild(headerTr, 0));
        }
    }

    public int getColumnCount() {
    	return DOM.getChildCount(headerTr);
    }

    public void showLoading() {
        if (!loadingShowing) {
        	super.removeAllRows();
            int numberOfColumns = getColumnCount();
            setWidget(0, 0, loadingImage);
            getFlexCellFormatter().setColSpan(0, 0, numberOfColumns);
            getFlexCellFormatter().setAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
            loadingShowing = true;
        }
    }

    @Override
    public void removeAllRows() {
    	super.removeAllRows();
        loadingShowing = false;
    }

    public void hideLoading() {
        if (loadingShowing) {
//            remove(loadingImage);
            loadingShowing = false;
        }
    }

    public void addEmptyStatus() {
        if (getRowCount() == 0) {
            int numberOfColumns = getColumnCount();
            setText(0, 0, Application.getConstants().noEntriesToDisplay());
            getFlexCellFormatter().setColSpan(0, 0, numberOfColumns);
            getFlexCellFormatter().setAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
        }
    }

    public void setHeader(int column, String text, HorizontalAlignmentConstant alignment, String width, String className) {
        prepareHeader(column, alignment, width, className);
        if (text != null) {
            DOM.setInnerText(DOM.getChild(headerTr, column), text);
        }
    }

    public void setHeader(int column, String text, HorizontalAlignmentConstant alignment, String width) {
        setHeader(column, text, alignment, width, NETNUMERO_ROW);
    }

    public void setHeader(int column, String text, HorizontalAlignmentConstant alignment) {
        setHeader(column, text, alignment, "120px", NETNUMERO_ROW);
    }

    public HandlerRegistration addMouseHandler(MouseHandler handler) {
        return addHandler(handler, MouseEvent.TYPE);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (DOM.eventGetType(event)) {
            case Event.ONMOUSEOVER:
                fireEvent(createMouseOverEvent(event));
                break;
            case Event.ONMOUSEOUT:
                Element toElem = DOM.eventGetToElement(event);
                if (highlightedRowElem != null && (toElem == null || !highlightedRowElem.isOrHasChild(toElem))) {
                    // Check that the coordinates are not directly over the cell
                    int clientX = event.getClientX() + Window.getScrollLeft();
                    int clientY = event.getClientY() + Window.getScrollTop();
                    int rowLeft = highlightedRowElem.getAbsoluteLeft();
                    int rowTop = highlightedRowElem.getAbsoluteTop();
                    int rowWidth = highlightedRowElem.getOffsetWidth();
                    int rowHeight = highlightedRowElem.getOffsetHeight();
                    int rowBottom = rowTop + rowHeight;
                    int rowRight = rowLeft + rowWidth;
                    if (clientX > rowLeft && clientX < rowRight && clientY > rowTop && clientY < rowBottom) {
                        return;
                    }
                    fireEvent(createMouseOutEvent());
                }
                break;
        }
    }

    // private methods --------------------------
    protected void prepareHeader(int column, HorizontalAlignmentConstant alignment, String width, String className) {
        if (column < 0) {
            throw new IndexOutOfBoundsException("Cannot create a column with a negative index: " + column);
        }
        int cellCount = DOM.getChildCount(headerTr);
        int required = column + 1 - cellCount;
        if (required > 0) {
            addCells(headElement, 0, required, alignment, width, className);
        }
        getColumnFormatter().setWidth(column, width);
    }

    protected native void addCells(Element table, int row, int num, HorizontalAlignmentConstant allignment, String width, String className) /*-{
		var rowElem = table.rows[row]; 
		for (var i = 0; i < num; i++) { 
			var cell = $doc.createElement("td");
			if (className) cell.className = className;
			cell.style.width = width;
			cell.style.textAlign = allignment.@com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant::getTextAlignString()();
		}
		rowElem.appendChild(cell);
	}-*/;

    public int[] getCoordinates(Event event) {
        int column = -1, row = -1;
        Element td = null;
        if (event != null) {
            td = getEventTargetCell(event);
        }
        if (td != null) {
            Element tr = DOM.getParent(td);
            column = DOM.getChildIndex(tr, td);
            Element body = DOM.getParent(tr);
            row = DOM.getChildIndex(body, tr);
            highlightedRowElem = tr;
        }
        int[] ret = new int[2];
        ret[0] = row;
        ret[1] = column;
        return ret;
    }

    private MouseEvent createMouseOverEvent(Event event) {
        int[] coordinates = getCoordinates(event);
        MouseEvent ret = new MouseEvent(MouseEvent.EventType.Over);
        ret.setRow(coordinates[0]);
        ret.setColumn(coordinates[1]);
        return ret;
    }

    private MouseEvent createMouseOutEvent() {
        return new MouseEvent(MouseEvent.EventType.Out);
    }
}
