package com.numhero.client.place;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  public void memberInject_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$(com.numhero.client.place.PlaceManager injectee) {
    
  }
  
  private com.numhero.client.place.PlaceManager singleton_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$ = null;
  
  public com.numhero.client.place.PlaceManager get_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$() {
    
    if (singleton_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$ == null) {
    com.numhero.client.place.PlaceManager result = com$numhero$client$place$PlaceManager_com$numhero$client$place$PlaceManager_methodInjection(injector.getFragment_com_numhero_client_events().get_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$());
    memberInject_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$(result);
    
        singleton_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$numhero$client$place$PlaceManager$_annotation$$none$$;
    
  }
  
  public com.numhero.client.place.PlaceManager com$numhero$client$place$PlaceManager_com$numhero$client$place$PlaceManager_methodInjection(com.numhero.client.events.EventManager _0) {
    return new com.numhero.client.place.PlaceManager(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
