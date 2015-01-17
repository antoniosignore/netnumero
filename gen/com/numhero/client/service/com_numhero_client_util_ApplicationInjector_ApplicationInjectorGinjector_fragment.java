package com.numhero.client.service;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  public void memberInject_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$(com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> injectee) {
    
  }
  
  private com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> singleton_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$ = null;
  
  public com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> get_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$() {
    
    if (singleton_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$ == null) {
    com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> result = com$numhero$client$service$Service_com$numhero$client$service$Service_methodInjection(injector.getFragment_com_numhero_client_util().get_Key$type$com$numhero$client$service$DataServiceAsync$_annotation$$none$$());
    memberInject_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$(result);
    
        singleton_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$numhero$client$service$Service$com$numhero$shared$datacargo$CommandRequest$_com$numhero$shared$datacargo$CommandResponse$$_annotation$$none$$;
    
  }
  
  public com.numhero.client.service.Service<com.numhero.shared.datacargo.CommandRequest, com.numhero.shared.datacargo.CommandResponse> com$numhero$client$service$Service_com$numhero$client$service$Service_methodInjection(com.numhero.client.service.DataServiceAsync _0) {
    return new com.numhero.client.service.Service(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
