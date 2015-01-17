package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ClientsSubmenuPanel extends Composite {

	private static ClientsSubmenuPanelUiBinder uiBinder = GWT
			.create(ClientsSubmenuPanelUiBinder.class);

	interface ClientsSubmenuPanelUiBinder extends
			UiBinder<Widget, ClientsSubmenuPanel> {
	}

	public ClientsSubmenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
