package com.numhero.client.place;

import com.google.gwt.event.shared.GwtEvent;

public class PlaceChangedEvent extends GwtEvent<PlaceChangedHandler> {

    public static Type<PlaceChangedHandler> TYPE = new Type<PlaceChangedHandler>();

    private final RestUrl url;

    public PlaceChangedEvent(RestUrl requestUrl) {
        this.url = requestUrl;
    }

    @Override
    protected void dispatch(PlaceChangedHandler handler) {
        handler.onPlaceChange(this);
    }

    @Override
    public Type<PlaceChangedHandler> getAssociatedType() {
        return TYPE;
    }

    public RestUrl getUrl() {
        return url;
    }

    public static Type<PlaceChangedHandler> getTYPE() {
        return TYPE;
    }

    public static void setTYPE(Type<PlaceChangedHandler> TYPE) {
        PlaceChangedEvent.TYPE = TYPE;
    }

}
