package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MoneyinSubmenuPanel extends Composite {

	private static MoneyinSubmenuPanelUiBinder uiBinder = GWT
			.create(MoneyinSubmenuPanelUiBinder.class);

	interface MoneyinSubmenuPanelUiBinder extends
			UiBinder<Widget, MoneyinSubmenuPanel> {
	}


	public MoneyinSubmenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
