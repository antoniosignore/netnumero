package com.numhero.client.util;


public class FireBugLogger implements Logger {


    private boolean fireBugInstalled = false;

    protected FireBugLogger() {

        //    checkIfFireBugInstalled();

    }
//
//        protected native void checkIfFireBugInstalled() /*-{
//
//              this::fireBugInstalled = ( typeof console != 'undefined' );
//
//              }-*/;

    public native void debug(String message) /*-{

              if (typeof console != 'undefined') console.debug(message) ;

               }-*/;
}
