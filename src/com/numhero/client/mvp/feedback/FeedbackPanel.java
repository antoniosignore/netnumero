package com.numhero.client.mvp.feedback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.NetNumeroButton;

public class FeedbackPanel extends Composite {

    private static MoneyinPanelUiBinder uiBinder = GWT.create(MoneyinPanelUiBinder.class);

    interface MoneyinPanelUiBinder extends UiBinder<Widget, FeedbackPanel> {
    }

    @UiField
    NetNumeroButton btSaveDraft;

    @UiField
    TextArea taNotes;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    Label message;

    public FeedbackPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public NetNumeroButton getBtSave() {
        return btSaveDraft;
    }

    public TextArea getTaNotes() {
        return taNotes;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public Label getMessage() {
        return message;
    }
}
