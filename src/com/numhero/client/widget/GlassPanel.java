package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * Semi-transparent panel which can be attached to any AbsolutePanel, although
 * typically a RootPanel via
 * {@link AbsolutePanel#add(com.google.gwt.user.client.ui.Widget, int, int) parent.add(glassPanel, 0, 0)}.
 * Note that <a
 * href="http://code.google.com/p/google-web-toolkit/issues/detail?id=1813">GWT
 * issue 1813</a> needs to be considered in order to properly use
 * <code>RootPanel.get(id)</code> as the parent panel in the general case.
 * <p/>
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.gwt-GlassPanel { }</li>
 * </ul>
 * <p/>
 * <p>
 * <h3>Example</h3>
 * {@example com.google.gwt.examples.GlassPanelExample}
 * </p>
 */
public class GlassPanel extends Composite {
    private HandlerRegistration handlerRegistration;


    /**
     * A FocusPanel which automatically focuses itself when
     * attached (in order to blur any currently focused widget)
     * and then removes itself.
     */
    private static class FocusPanelImpl extends FocusPanel {
        public FocusPanelImpl() {
            addFocusHandler(new FocusHandler() {
                @Override
                public void onFocus(FocusEvent focusEvent) {
                   FocusPanelImpl.this.removeFromParent();
                }
            });


        }

        @Override
        protected void onLoad() {
            super.onLoad();
            /**
             * Removed DeferredCommand if/when GWT issue 1849 is implemented
             * http://code.google.com/p/google-web-toolkit/issues/detail?id=1849
             */
            DeferredCommand.addCommand(new Command() {
                public void execute() {
                    setFocus(true);
                }
            });
        }
    }

    private static final GlassPanelImpl impl = new GlassPanelImpl();
    private final SimplePanel mySimplePanel;

    private ResizeHandler resizeHandler;

    private final Timer timer = new Timer() {
        @Override
        public void run() {
            impl.matchDocumentSize(GlassPanel.this);
        }
    };

    public GlassPanel() {
        mySimplePanel = new SimplePanel();
        initWidget(mySimplePanel);
        Style style = getElement().getStyle();
        style.setProperty("backgroundColor", "#000");
        style.setProperty("filter", "alpha(opacity=50)");
        style.setProperty("opacity", "0.5");
        setStyleName("gwt-GlassPanel");
    }



    @Override
    protected void onAttach() {
        super.onAttach();
        AbsolutePanel parent;
        try {
            parent = (AbsolutePanel) getParent();
        } catch (RuntimeException e) {
            throw new IllegalStateException("Parent widget must be an instance of AbsolutePanel");
        }

        if (parent == RootPanel.get()) {
            impl.matchDocumentSize(this);
            timer.scheduleRepeating(100);
            resizeHandler = new ResizeHandler() {


                @Override
                public void onResize(ResizeEvent resizeEvent) {
                    impl.matchDocumentSize(GlassPanel.this);
                }
            };
            handlerRegistration = Window.addResizeHandler(resizeHandler);
        } else {
            impl.matchParentSize(this, parent);
        }


        RootPanel.get().add(new FocusPanelImpl(), Window.getScrollLeft(), Window.getScrollTop());
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        timer.cancel();
        if (resizeHandler != null) {
            handlerRegistration.removeHandler();
            resizeHandler = null;
        }

    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if (!GWT.isScript()) {
            // In Webkit quirks mode table cells refuse to take on
            // 'display: block', using 'display: table-cell' instead.
            if (!impl.isCSS1Compat()) {
                String nodeName = getParent().getElement().getNodeName();
                if (nodeName.matches("^(TD|TH)$")) {
                    String msg = "SORRY: GlassPanel cannot properly cover a " + nodeName
                            + " element in quirks mode due to CSS restrictions in certain browsers."
                            + " Please consider using standards mode or try using a different type of element.";
                    GWT.log(msg, new UnsupportedOperationException());
                    Window.alert(msg);
                    assert false : msg;
                }
            }
        }
    }
}
