package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle_en_StaticClientBundleGenerator implements com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle {
  private static TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle_en_StaticClientBundleGenerator _instance0 = new TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle_en_StaticClientBundleGenerator();
  private void styleInitializer() {
    style = new com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return ("");
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
