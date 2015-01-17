package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AccountsSubmenuPanel extends Composite {

	private static AccountsSubmenuPanelUiBinder uiBinder = GWT
			.create(AccountsSubmenuPanelUiBinder.class);

	interface AccountsSubmenuPanelUiBinder extends
			UiBinder<Widget, AccountsSubmenuPanel> {
	}

	public AccountsSubmenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
