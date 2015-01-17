package com.numhero.client.widget.search;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.pojoc.SearchablePojo;

@SuppressWarnings({"unchecked", "rawtypes"})
public class SearchPojoDialog extends DialogBox {
	protected Service getListService;
    protected SearchPanel searchPanel;
    protected ListCommandRequest request;
    protected SearchablePojo pojo;

    public SearchablePojo getPojo() {
        return pojo;
    }

    public void setPojo(SearchablePojo pojo) {
        this.pojo = pojo;
    }

    public SearchPojoDialog(String title, String search, Service getListService, SearchPanel searchPanel, ListCommandRequest request) {
        setText(title);
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        this.getListService = getListService;
        this.searchPanel = searchPanel;
        this.request = request;
        searchPanel.getSearchTable().setDialog(this);

        searchPanel.getTbSearch().addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    refreshFromServer();
                }
            }
        });
        searchPanel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                hide();
            }
        });
        searchPanel.getBtSearch().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                refreshFromServer();
            }
        });

        if (search != null) {
            searchPanel.getTbSearch().setValue(search);
            refreshFromServer();
        }

        setWidget(searchPanel);
    }

    private void refreshFromServer() {
    	searchPanel.getSearchTable().showLoading();
        request.setType(TYPE.SEARCH);
        request.setStartingKey(searchPanel.getTbSearch().getValue());
        getListService.execute(request, new ServiceCallbackImpl<ListCommandResponse>() {
            @Override
            public void onSuccess(ListCommandResponse response) {
                searchPanel.getSearchTable().setPojoCList(response.getEntityList());
            }
        });
    }
}
