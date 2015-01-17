package com.numhero.client.widget;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;

/**
 * Deferred binding implementation of {@link GlassPanel}.
 */
public class GlassPanelImpl {

    // TODO remove once GWT issue 1981 is fixed
    // http://code.google.com/p/google-web-toolkit/issues/detail?id=1981

    public native boolean isCSS1Compat()
        /*-{
          return $doc.compatMode == 'CSS1Compat';
        }-*/;

//    public abstract void matchDocumentSize(GlassPanel glassPanel, boolean dueToResize);


    public void matchDocumentSize(GlassPanel glassPanel) {
        int clientWidth = Window.getClientWidth();
        int clientHeight = Window.getClientHeight();

        Window.enableScrolling(false);


        glassPanel.setPixelSize(clientWidth - 1, clientHeight - 1);
    }

    public void matchParentSize(GlassPanel glassPanel, AbsolutePanel parent) {
        glassPanel.getElement().getStyle().setProperty("bottom", "0px");
        glassPanel.getElement().getStyle().setProperty("right", "0px");
    }
}

