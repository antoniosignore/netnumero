package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;

public class DetailTitlePanel extends Composite implements HasHTML {

    private static DetailTitlePanelUiBinder uiBinder = GWT
            .create(DetailTitlePanelUiBinder.class);

    interface DetailTitlePanelUiBinder extends
            UiBinder<Widget, DetailTitlePanel> {
    }

    @UiField
    TitleLevelTwo title;

    public DetailTitlePanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public String getHTML() {
        return title.getHTML();
    }

    @Override
    public void setHTML(String html) {
        title.setHTML(html);
    }

    @Override
    public String getText() {
        return title.getText();
    }

    @Override
    public void setText(String text) {
        title.setText(text);
    }

}
