package com.numhero.client.events;

import com.google.gwt.core.client.GWT;
import com.numhero.client.util.com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector;

public class com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment {
  public void memberInject_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$(com.numhero.client.events.EventManager injectee) {
    
  }
  
  private com.numhero.client.events.EventManager singleton_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$ = null;
  
  public com.numhero.client.events.EventManager get_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$() {
    
    if (singleton_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$ == null) {
    Object created = GWT.create(com.numhero.client.events.EventManager.class);
    assert created instanceof com.numhero.client.events.EventManager;
    com.numhero.client.events.EventManager result = (com.numhero.client.events.EventManager) created;
    
    memberInject_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$(result);
    
        singleton_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$ = result;
    }
    return singleton_Key$type$com$numhero$client$events$EventManager$_annotation$$none$$;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector;
  public com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector_fragment(com_numhero_client_util_ApplicationInjector_ApplicationInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
