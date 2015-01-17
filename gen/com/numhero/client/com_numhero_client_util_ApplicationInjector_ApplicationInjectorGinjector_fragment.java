package com.numhero.client;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  public native void com$numhero$client$ClientCache_service_fieldInjection(com.numhero.client.ClientCache injectee, com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> value) /*-{
    injectee.@com.numhero.client.ClientCache::service = value;
  }-*/;
  
  public void memberInject_Key$type$com$numhero$client$ClientCache$_annotation$$none$$(com.numhero.client.ClientCache injectee) {
    com$numhero$client$ClientCache_service_fieldInjection(injectee, injector.getFragment_com_numhero_client_service().get_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$());
    
    
  }
  
  private com.numhero.client.ClientCache singleton_Key$type$com$numhero$client$ClientCache$_annotation$$none$$ = null;
  
  public com.numhero.client.ClientCache get_Key$type$com$numhero$client$ClientCache$_annotation$$none$$() {
    
    if (singleton_Key$type$com$numhero$client$ClientCache$_annotation$$none$$ == null) {
    Object created = GWT.create(com.numhero.client.ClientCache.class);
    assert created instanceof com.numhero.client.ClientCache;
    com.numhero.client.ClientCache result = (com.numhero.client.ClientCache) created;
    
    memberInject_Key$type$com$numhero$client$ClientCache$_annotation$$none$$(result);
    
        singleton_Key$type$com$numhero$client$ClientCache$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$numhero$client$ClientCache$_annotation$$none$$;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
