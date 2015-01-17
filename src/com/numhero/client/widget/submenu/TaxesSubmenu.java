package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TaxesSubmenu extends Composite {

	private static TaxesSubmenuUiBinder uiBinder = GWT
			.create(TaxesSubmenuUiBinder.class);

	interface TaxesSubmenuUiBinder extends UiBinder<Widget, TaxesSubmenu> {
	}

	public TaxesSubmenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
