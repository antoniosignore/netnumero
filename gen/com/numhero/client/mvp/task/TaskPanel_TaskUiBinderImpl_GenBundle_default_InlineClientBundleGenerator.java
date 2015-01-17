package com.numhero.client.mvp.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TaskPanel_TaskUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.numhero.client.mvp.task.TaskPanel_TaskUiBinderImpl_GenBundle {
  private static TaskPanel_TaskUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new TaskPanel_TaskUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
    }
    return null;
  }-*/;
}
