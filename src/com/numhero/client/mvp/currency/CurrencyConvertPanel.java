package com.numhero.client.mvp.currency;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.numhero.client.widget.NetNumeroButton;

import java.util.List;

public class CurrencyConvertPanel extends Composite {

    interface CurrencyUiBinder extends UiBinder<HTMLPanel, CurrencyConvertPanel> {
    }

    private static CurrencyUiBinder uiBinder = GWT.create(CurrencyUiBinder.class);

    @UiField
    CurrencyConvertTable cct;

    @UiField
    NetNumeroButton btClose;

    public CurrencyConvertPanel(List<CurrencyConvertBean> toConvert) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public CurrencyConvertTable getCct() {
		return cct;
	}

    public NetNumeroButton getBtClose() {
		return btClose;
	}
}
