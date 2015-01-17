package com.numhero.client.util;

public class com_numhero_client_util_ApplicationInjectorImpl implements com.numhero.client.util.ApplicationInjector {
  
  /**
   * Top-level injector instance for injector interface com.numhero.client.util.ApplicationInjector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector = new com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector(this);
  public com_numhero_client_util_ApplicationInjectorImpl() {
    
  }
  
  public com.numhero.client.mvp.ApplicationController getApplicationController() {
    return fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector.getFragment_com_numhero_client_mvp().get_Key$type$com$numhero$client$mvp$ApplicationController$_annotation$$none$$();
  }
  
  public com.numhero.client.service.DataServiceAsync getAsyncService() {
    return fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector.getFragment_com_numhero_client_util().get_Key$type$com$numhero$client$service$DataServiceAsync$_annotation$$none$$();
  }
  
  public com.numhero.client.ClientCache getClientCache() {
    return fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector.getFragment_com_numhero_client().get_Key$type$com$numhero$client$ClientCache$_annotation$$none$$();
  }
  
  public com.numhero.client.place.PlaceManager getPlaceManager() {
    return fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector.getFragment_com_numhero_client_place().get_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$();
  }
  
  public java.util.Map<java.lang.String, java.lang.String> getRestURLsMap() {
    return fieldcom_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector.getFragment_com_numhero_client_util().get_Key$type$java$util$Map$java$lang$String$_java$lang$String$$_annotation$$none$$();
  }
  
}
