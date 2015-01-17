package com.numhero.client.util;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  
  /**
   * Binding for com.numhero.client.service.DataServiceAsync declared at:
   *   com.numhero.client.service.DataServiceAsync com.numhero.client.util.ApplicationModule.getDataService()
   */
  public com.numhero.client.service.DataServiceAsync get_Key$type$com$numhero$client$service$DataServiceAsync$_annotation$$none$$() {
    com.numhero.client.service.DataServiceAsync result = com$numhero$client$util$ApplicationModule_getDataService_methodInjection(new com.numhero.client.util.ApplicationModule());
    return result;
    
  }
  
  public com.numhero.client.service.DataServiceAsync com$numhero$client$util$ApplicationModule_getDataService_methodInjection(com.numhero.client.util.ApplicationModule invokee) {
    return invokee.getDataService();
  }
  
  
  /**
   * Binding for java.util.Map<java.lang.String, java.lang.String> declared at:
   *   java.util.Map com.numhero.client.util.ApplicationModule.getRestURLsMap()
   */
  public java.util.Map<java.lang.String, java.lang.String> get_Key$type$java$util$Map$java$lang$String$_java$lang$String$$_annotation$$none$$() {
    java.util.Map<java.lang.String, java.lang.String> result = com$numhero$client$util$ApplicationModule_getRestURLsMap_methodInjection(new com.numhero.client.util.ApplicationModule());
    return result;
    
  }
  
  public java.util.Map<java.lang.String, java.lang.String> com$numhero$client$util$ApplicationModule_getRestURLsMap_methodInjection(com.numhero.client.util.ApplicationModule invokee) {
    return invokee.getRestURLsMap();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
