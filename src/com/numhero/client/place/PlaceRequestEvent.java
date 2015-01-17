package com.numhero.client.place;

import com.google.gwt.event.shared.GwtEvent;

public class PlaceRequestEvent extends GwtEvent<PlaceRequestHandler> {

	public static Type<PlaceRequestHandler>	TYPE	= new Type<PlaceRequestHandler>();

	private final RestUrl					url;

	private final boolean					fromHistory;

	public PlaceRequestEvent(RestUrl request) {
		this(request, false);
	}

	PlaceRequestEvent(RestUrl url, boolean fromHistory) {
		this.url = url;
		this.fromHistory = fromHistory;
	}

	@Override
	protected void dispatch(PlaceRequestHandler handler) {
		handler.onPlaceRequest(this);
	}

	@Override
	public Type<PlaceRequestHandler> getAssociatedType() {
		return TYPE;
	}

	public RestUrl getUrl() {
		return url;
	}

	boolean isFromHistory() {
		return fromHistory;
	}
}
