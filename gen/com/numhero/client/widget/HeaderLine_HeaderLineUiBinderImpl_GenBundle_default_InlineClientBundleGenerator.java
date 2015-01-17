package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class HeaderLine_HeaderLineUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenBundle {
  private static HeaderLine_HeaderLineUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new HeaderLine_HeaderLineUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GINHCA5DJI{margin:" + ("0")  + ";text-align:" + ("left")  + ";padding:" + ("5px"+ " " +"0")  + ";margin-right:" + ("0")  + ";font-size:" + ("12px")  + ";}.GINHCA5DJI li{list-style:" + ("none")  + ";margin:" + ("0")  + ";display:" + ("inline")  + ";}.GINHCA5DJI li a.GINHCA5DII{color:" + ("#000")  + ";background:" + ("#fff")  + ";border-bottom:") + (("1px"+ " " +"solid"+ " " +"#fff")  + ";}")) : ((".GINHCA5DJI{margin:" + ("0")  + ";text-align:" + ("right")  + ";padding:" + ("5px"+ " " +"0")  + ";margin-left:" + ("0")  + ";font-size:" + ("12px")  + ";}.GINHCA5DJI li{list-style:" + ("none")  + ";margin:" + ("0")  + ";display:" + ("inline")  + ";}.GINHCA5DJI li a.GINHCA5DII{color:" + ("#000")  + ";background:" + ("#fff")  + ";border-bottom:") + (("1px"+ " " +"solid"+ " " +"#fff")  + ";}"));
      }
      public java.lang.String current(){
        return "GINHCA5DII";
      }
      public java.lang.String topline(){
        return "GINHCA5DJI";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
