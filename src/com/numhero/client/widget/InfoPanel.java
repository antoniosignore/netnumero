package com.numhero.client.widget;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

import java.util.ArrayList;
import java.util.List;

public class InfoPanel extends DecoratedPopupPanel implements HasText {


    public enum InfoPanelType {
        HUMANIZED_MESSAGE, TRAY_NOTIFICATION
    }

    /**
     * The default style name.
     */
    private static final String DEFAULT_STYLENAME = "mosaic-InfoPanel";

    public static final int DEFAULT_DELAY = 3333; // microseconds
    public static final int WIDTH = 224;

    public static final int HEIGHT = 72;

    private static final List<InfoPanel> SLOTS = new ArrayList<InfoPanel>();

    private static int firstAvail() {
        int size = SLOTS.size();
        for (int i = 0; i < size; i++) {
            if (SLOTS.get(i) == null) {
                return i;
            }
        }
        return size;
    }

    private static void show(final InfoPanel infoPanel, final int delayMsec,
                             final int level) {
        final int cw = Window.getClientWidth();
        final int ch = Window.getClientHeight();

        final int left = (cw - WIDTH - 20);
        final int top = ch - HEIGHT - 20 - (level * (HEIGHT + 20));

        if (top < 0) {
            new DelayedRunnable() {
                public void run() {
                    InfoPanel.SLOTS.set(level, null);
                    InfoPanel.show(infoPanel.caption.getText(),
                            infoPanel.description.getText());
                }
            };
        } else {
            infoPanel.setPopupPosition(left, top);
            infoPanel.show();
            infoPanel.hideTimer.scheduleRepeating(delayMsec);
        }
    }

    public static void show(InfoPanelType type, String caption, String text,
                            String... values) {
        if (type == InfoPanelType.TRAY_NOTIFICATION) {
            show(caption, text, values);
        } else {
            // if (text != null && values != null) text = Format.substitute(text,
            // values);

            final InfoPanel infoPanel = new InfoPanel(caption, text, true);
            if (infoPanel.glassPanel == null) {
                infoPanel.glassPanel = new GlassPanel();
                infoPanel.glassPanel.addStyleName("mosaic-GlassPanel-default");
                DOM.setStyleAttribute(infoPanel.glassPanel.getElement(), "zIndex",
                        DOM.getStyleAttribute(infoPanel.getElement(), "zIndex"));
            }
            RootPanel.get().add(infoPanel.glassPanel, 0, 0);
            infoPanel.center();
            infoPanel.addCloseHandler(new CloseHandler<PopupPanel>() {
                @Override
                public void onClose(CloseEvent<PopupPanel> popupPanelCloseEvent) {
                    infoPanel.glassPanel.removeFromParent();
                }
            });
        }
    }

    private GlassPanel glassPanel;

    public static void show(String caption, String text, String... values) {
        final int avail = firstAvail();
        // if (text != null && values != null) text = Format.substitute(text,
        // values);

        InfoPanel infoPanel = new InfoPanel(caption, text);
        infoPanel.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> popupPanelCloseEvent) {
               SLOTS.set(avail, null);
            }
        });
        SLOTS.add(avail, infoPanel);

        show(infoPanel, DEFAULT_DELAY, avail);
    }

    private Label caption, description;

    private final Timer hideTimer = new Timer() {
        public void run() {
            InfoPanel.this.hide();
        }
    };

    public InfoPanel() {
        this(null);
    }

    protected InfoPanel(String caption) {
        this(caption, null);
    }

    protected InfoPanel(String caption, String description) {
        this(caption, description, false);
    }

    protected InfoPanel(String caption, String description, final boolean autoHide) {
        super(autoHide, false); // modal=false
        ensureDebugId("mosaicInfoPanel-simplePopup");

        setAnimationEnabled(true);

        this.caption = new Label(caption);
        this.caption.setStyleName(DEFAULT_STYLENAME + "-caption");

        this.description = new Label(description);
        this.description.setStyleName(DEFAULT_STYLENAME + "-description");

        final FlowPanel panel = new FlowPanel();
        panel.setStyleName(DEFAULT_STYLENAME + "-panel");
        if (autoHide) {
            final int width = Window.getClientWidth();
            panel.setPixelSize(Math.max(width / 3, WIDTH), HEIGHT);
            Window.addResizeHandler(new ResizeHandler() {
                @Override
                public void onResize(ResizeEvent resizeEvent) {
                    new DelayedRunnable() {
                        public void run() {
                            final int width = Window.getClientWidth();
                            getWidget().setPixelSize(Math.max(width / 3, WIDTH), HEIGHT);
                            center();
                        }
                    };
                }
            });
        } else {
            panel.setPixelSize(WIDTH, HEIGHT);
        }
        DOM.setStyleAttribute(panel.getElement(), "overflow", "hidden");

        SimplePanel div1 = new SimplePanel();
        div1.add(this.caption);

        SimplePanel div2 = new SimplePanel();
        div2.add(this.description);

        panel.add(div1);
        panel.add(div2);

        setWidget(panel);

        addStyleName(DEFAULT_STYLENAME);
        DOM.setIntStyleAttribute(getElement(), "zIndex", Integer.MAX_VALUE);
    }

    public String getCaption() {
        return caption.getText();
    }

    public String getText() {
        return description.getText();
    }

    public void setCaption(String caption) {
        this.caption.setText(caption);
    }

    public void setText(String text) {
        this.description.setText(text);
    }



}
