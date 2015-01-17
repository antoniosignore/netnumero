package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  public void memberInject_Key$type$com$numhero$client$mvp$ApplicationController$_annotation$$none$$(com.numhero.client.mvp.ApplicationController injectee) {
    
  }
  
  
  /**
   * Binding for com.numhero.client.mvp.ApplicationController declared at:
   *   Implicit GWT.create binding for com.numhero.client.mvp.ApplicationController
   */
  public com.numhero.client.mvp.ApplicationController get_Key$type$com$numhero$client$mvp$ApplicationController$_annotation$$none$$() {
    Object created = GWT.create(com.numhero.client.mvp.ApplicationController.class);
    assert created instanceof com.numhero.client.mvp.ApplicationController;
    com.numhero.client.mvp.ApplicationController result = (com.numhero.client.mvp.ApplicationController) created;
    
    memberInject_Key$type$com$numhero$client$mvp$ApplicationController$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
