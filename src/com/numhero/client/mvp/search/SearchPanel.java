package com.numhero.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SearchPanel extends Composite {
    interface TaskUiBinder extends UiBinder<Widget, SearchPanel> {
    }

    private static TaskUiBinder uiBinder = GWT.create(TaskUiBinder.class);

    @UiField
    TextBox tbSearch;

    @UiField
    DivElement dvSearchResults;

    @Inject
    public SearchPanel() {
        initWidget(uiBinder.createAndBindUi(this));

        tbSearch.setFocus(true);
    }

    public TextBox getTbSearch() {
		return tbSearch;
	}

    public DivElement getDvSearchResults() {
		return dvSearchResults;
	}
}
