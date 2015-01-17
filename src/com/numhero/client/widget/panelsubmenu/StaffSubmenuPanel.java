package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class StaffSubmenuPanel extends Composite {

	private static StaffSubmenuPanelUiBinder uiBinder = GWT
			.create(StaffSubmenuPanelUiBinder.class);

	interface StaffSubmenuPanelUiBinder extends
			UiBinder<Widget, StaffSubmenuPanel> {
	}

	public StaffSubmenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
