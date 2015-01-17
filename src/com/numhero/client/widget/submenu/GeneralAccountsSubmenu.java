package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GeneralAccountsSubmenu extends Composite {

	private static GeneralAccountsSubmenuUiBinder uiBinder = GWT
			.create(GeneralAccountsSubmenuUiBinder.class);

	interface GeneralAccountsSubmenuUiBinder extends
			UiBinder<Widget, GeneralAccountsSubmenu> {
	}


	public GeneralAccountsSubmenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
