package com.numhero.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

import java.util.Iterator;

public class CompositeFormItem extends Composite implements ClickHandler {
    private HorizontalPanel hp;
    private Label lbTitle;
    private Widget wFocusable;

    private HandlerRegistration clickReg;
    private HorizontalAlignmentConstant titleAlign;
    private int titleWidth;

    public CompositeFormItem() {
        hp = new HorizontalPanel();
        hp.setStyleName("formItem noBorders");
        hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        titleAlign = HasHorizontalAlignment.ALIGN_LEFT;
        titleWidth = 100;
        initWidget(hp);
    }

    public void setTitleWidth(int titleWidth) {
        this.titleWidth = titleWidth;
    }

    public void setTitleAlign(HorizontalAlignmentConstant titleAlign) {
        this.titleAlign = titleAlign;
    }

    @Override
    protected void onLoad() {
        for (Iterator<Widget> itW = hp.iterator(); itW.hasNext();) {
            Widget w = itW.next();
            if (w instanceof Label) {
                lbTitle = (Label) w;
            } else if (w instanceof Focusable) {
                wFocusable = w;
            }
        }
        if (lbTitle != null && wFocusable != null) {
            lbTitle.setStylePrimaryName("formItemLabel");
            clickReg = lbTitle.addClickHandler(this);
            hp.setCellWidth(lbTitle, titleWidth + "px");
            hp.setCellHorizontalAlignment(lbTitle, titleAlign);
            hp.setCellHorizontalAlignment(wFocusable, HasHorizontalAlignment.ALIGN_LEFT);
        }
    }

    @Override
    protected void onUnload() {
        if (clickReg != null) {
            clickReg.removeHandler();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        ((Focusable) wFocusable).setFocus(true);
    }
}
