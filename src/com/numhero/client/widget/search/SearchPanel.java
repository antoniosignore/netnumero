package com.numhero.client.widget.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.numhero.client.widget.NetNumeroButton;

public class SearchPanel extends Composite {
	interface SearchPanelUiBinder extends UiBinder<Widget, SearchPanel> {
	}

	private static SearchPanelUiBinder	uiBinder	= GWT.create(SearchPanelUiBinder.class);

	@UiField
	TextBox								tbSearch;

	@UiField(provided = true)
	AbstractSearchTable					searchTable;

	@UiField
	NetNumeroButton						btSearch;

	@UiField
	NetNumeroButton						btCancel;

	public SearchPanel(AbstractSearchTable searchTable) {
		this.searchTable = searchTable;
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TextBox getTbSearch() {
		return tbSearch;
	}

	public AbstractSearchTable getSearchTable() {
		return searchTable;
	}

	public NetNumeroButton getBtSearch() {
		return btSearch;
	}

	public NetNumeroButton getBtCancel() {
		return btCancel;
	}
}
