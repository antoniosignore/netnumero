package com.numhero.client.mvp;

import com.numhero.client.place.PlaceManager;

public abstract class InfoPresenter extends BasePresenter {

    public InfoPresenter(PlaceManager eventManager, BaseView view) {
        super(eventManager, view);
    }
}
