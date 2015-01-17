package com.numhero.client.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public final class CoreUtils {


    /**
     * This method shows or hides the element identified by elementId from the browser's DOM
     */
    public static void setDOMElementVisible(String elementId, boolean visible) {
        RootPanel element = RootPanel.get(elementId);
        if (element != null) {
            element.setVisible(visible);
        }
    }

    // logging --------------------------

    public static void debug(String msg) {
        //debug(msg, null);
        Log.debug(msg);
    }

    public static void debug(String msg, Throwable e) {
        GWT.log(msg, e);
        if (GWT.isScript()) {
            Log.debug(msg);
        } else {
            //!GWT.isScript() == hosted mode
            System.out.println("GWT LOG: " + msg);
            if (e != null) {
                e.printStackTrace();
            }
        }
    }
//
//    private static native void log(String message) /*-{
//
//        console.debug(message);
//    }-*/;

    // createImgTag -----------------------

    public static String createImgTag(String imageUrl) {
        return createImgTag(imageUrl, "");
    }

    public static String createImgTag(String imageSrc, String alt) {
        return "<img border=\"0\" align=\"absmidle\" alt=\"" + alt
                + "\" title=\"" + alt + "\" src='" + imageSrc.toLowerCase()
                + "'>";
    }
}
