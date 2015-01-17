package com.numhero.client.mvp.project;

import com.google.gwt.event.shared.EventHandler;

public interface ProjectValuationChangedHandler extends EventHandler {
    void onValuationChanged(ProjectValuationChangedEvent eventProject);
}