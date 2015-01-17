package com.numhero.client.mvp.project;

import com.google.gwt.event.shared.GwtEvent;

public class ProjectValuationChangedEvent extends GwtEvent<ProjectValuationChangedHandler> {

    public static Type<ProjectValuationChangedHandler> TYPE = new Type<ProjectValuationChangedHandler>();
    private String caller;

    public ProjectValuationChangedEvent(String caller) {
        this.caller = caller;
    }

    @Override
    protected void dispatch(ProjectValuationChangedHandler handlerProject) {
        handlerProject.onValuationChanged(this);
    }

    @Override
    public Type<ProjectValuationChangedHandler> getAssociatedType() {
        return TYPE;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }
}
