package com.numhero.client.mvp.moneyout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle {
  private static MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenCss_style() {
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
        return (".GINHCA5DFI{font-weight:" + ("bold")  + ";}");
      }
      public java.lang.String important(){
        return "GINHCA5DFI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
