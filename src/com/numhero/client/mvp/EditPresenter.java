package com.numhero.client.mvp;

import com.numhero.client.place.PlaceManager;


public abstract class EditPresenter extends BasePresenter {


    public EditPresenter(PlaceManager placeManager, EditPageView view) {
        super(placeManager, view);
    }

    protected abstract String getReturnUrl();

    protected void redirect() {

        getPlaceManager().moveToPlace(getReturnUrl());
    }
}
