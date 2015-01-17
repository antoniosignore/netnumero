package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TitleLevelOne extends Composite implements HasHTML {

    private static TitleLevelOneUiBinder uiBinder = GWT.create(TitleLevelOneUiBinder.class);

    interface TitleLevelOneUiBinder extends UiBinder<Widget, TitleLevelOne> {
    }

    @UiField
    Label title;

    public void setText(String title) {
        this.title.setText(title);
    }

    @Override
    public String getHTML() {
        return this.title.getText();
    }

    @Override
    public void setHTML(String title) {
        this.title.setText(title);
    }

    @Override
    public String getText() {
        return this.title.getText();
    }

    public TitleLevelOne() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
