package com.numhero.client.mvp.banktransaction;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements com.numhero.client.mvp.banktransaction.BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle {
  private static BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
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
