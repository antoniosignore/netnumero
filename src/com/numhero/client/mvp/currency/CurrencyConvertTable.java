package com.numhero.client.mvp.currency;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.client.widget.textbox.NumberTextBox;

import java.util.List;

public class CurrencyConvertTable extends FlexTableWithHeader {

	public CurrencyConvertTable() {
        showLoading();
		setHeader();
        setStyleName("entity-details-table");
	}

	private void setHeader() {
        setHeader(0, Application.getConstants().fromAmount(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
        setHeader(1, Application.getConstants().exchange(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
        setHeader(2, "", HasHorizontalAlignment.ALIGN_CENTER, "25px");
        setHeader(3, Application.getConstants().toAmount(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
    }

	public void setData(List<CurrencyConvertBean> toConvert) {
        removeAllRows();
        for (int row = 0; row < toConvert.size(); row++) {
        	CurrencyConvertBean ccb = toConvert.get(row);

        	final NumberTextBox fromAmount = new NumberTextBox(ccb.getFromCurrency());
        	fromAmount.setAmount(ccb.getFromAmount());
        	fromAmount.setReadOnly(true);
        	setWidget(row, 0, fromAmount);

        	final NumberTextBox exchangeRate = new NumberTextBox();
        	exchangeRate.setPrecision(4);
        	exchangeRate.setAmount(ccb.getExchangeRate());
        	setWidget(row, 1, exchangeRate);

        	final NumberTextBox toAmount = new NumberTextBox(ccb.getToCurrency());
        	toAmount.setAmount(ccb.getToAmount());
        	setWidget(row, 3, toAmount);

        	NetNumeroButton btConvert = new NetNumeroButton("");
        	btConvert.setHTML("&nbsp;");
        	btConvert.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
	            	toAmount.setAmount(fromAmount.getAmount() * exchangeRate.getAmount());
				}
			});
        	setWidget(row, 2, btConvert);

        	for (int i = 0; i <= 3; i++) {
                getCellFormatter().setStyleName(row, i, NETNUMERO_ROW);
            }
        }
	}
}
