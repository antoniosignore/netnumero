package com.numhero.client.mvp.search;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.GlobalSearchListRequest;
import com.numhero.client.model.datacargo.GlobalSearchListResponse;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.pojoc.SearchReference;

@Singleton
public class SearchPresenter extends BasePresenter {
	private static final int DELAY = 500;

	private Service<GlobalSearchListRequest, GlobalSearchListResponse> searchService;
	private Timer requestTimer;

	@Inject
	public SearchPresenter(PlaceManager eventManager, Service<GlobalSearchListRequest, GlobalSearchListResponse> searchService, SearchView searchView) {
		super(eventManager, searchView);
		this.searchService = searchService;
		requestTimer = new Timer() {
			@Override
			public void run() {
				showSearchResults();
			}
		};
	}

	@Override
	public SearchView getView() {
		return (SearchView) super.getView();
	}

	@Override
	protected void onBind() {
		getView().getSearchPanel().getTbSearch().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				requestTimer.cancel();
				if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
					showSearchResults();
				} else if (KeyCodes.KEY_ESCAPE == event.getNativeEvent().getKeyCode()) {
	                clearSearchResults();
				} else if (!event.getNativeEvent().getAltKey() && !event.getNativeEvent().getCtrlKey()) {
					requestTimer.schedule(DELAY);
				}
			}
		});
	}

	@Override
	protected void onShow() {
		TextBox tbSearch = getView().getSearchPanel().getTbSearch();
        tbSearch.setFocus(true);
	}

	private void showSearchResults() {
		TextBox tbSearch = getView().getSearchPanel().getTbSearch();
		if (tbSearch.getText().isEmpty()) {
            clearSearchResults();
		} else {
			GlobalSearchListRequest gslr = new GlobalSearchListRequest();
			gslr.setStartingKey(tbSearch.getText());
			searchService.execute(gslr, new ServiceCallbackImpl<GlobalSearchListResponse>() {
	            @Override
	            public void onSuccess(GlobalSearchListResponse response) {
	            	String s = "<br/>";
	            	for (SearchReference sref : response.getEntityList()) {
	            		String restURL = Application.injector.getRestURLsMap().get(sref.getPojoKind());
	            		if (restURL == null) {
	            			s += sref.getName();
	            		} else {
							s += "<a href=\"#" + restURL + "/" + sref.getPojoId() + "\">" + sref.getName() + "</a>";
	            		}
	            		s += ": " + sref.getPojoName() + "<br/><br/>";
					}
	            	s += "<br/>";
	                getView().getSearchPanel().getDvSearchResults().setInnerHTML(s);
	            }
	        });
		}
	}

	private void clearSearchResults() {
		getView().getSearchPanel().getDvSearchResults().setInnerHTML("");
	}
}
