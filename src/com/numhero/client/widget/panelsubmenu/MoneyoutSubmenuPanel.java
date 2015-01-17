package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MoneyoutSubmenuPanel extends Composite {

	private static MoneyoutSubmenuPanelUiBinder uiBinder = GWT
			.create(MoneyoutSubmenuPanelUiBinder.class);

	interface MoneyoutSubmenuPanelUiBinder extends
			UiBinder<Widget, MoneyoutSubmenuPanel> {
	}

	public MoneyoutSubmenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
