package com.numhero.client.place;

import com.google.gwt.event.shared.EventHandler;

public interface PlaceChangedHandler extends EventHandler {
	void onPlaceChange(PlaceChangedEvent event);
}
