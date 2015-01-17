package com.numhero.client.widget.table;

import com.google.gwt.event.shared.GwtEvent;

public class MouseEvent extends GwtEvent<MouseHandler> {
    public static final Type<MouseHandler> TYPE = new Type<MouseHandler>();

    public enum EventType {
        Over, Out
    }

    private EventType type;
    private int row, column;

    public MouseEvent(EventType type) {
        this.type = type;
        row = column = -1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    protected void dispatch(MouseHandler handler) {
        if (type == EventType.Over) {
            handler.onMouseOver(this);
        } else {
            handler.onMouseOut(this);
        }
    }

    @Override
    public Type<MouseHandler> getAssociatedType() {
        return TYPE;
    }
}
