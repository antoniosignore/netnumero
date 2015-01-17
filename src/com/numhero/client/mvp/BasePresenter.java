package com.numhero.client.mvp;

import com.google.gwt.event.shared.HandlerRegistration;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.RestUrl;

public abstract class BasePresenter {

    private BaseView view;

    private RestUrl url;

    private PlaceManager placeManager;

    public BasePresenter(PlaceManager placeManager, BaseView view) {
        this.placeManager = placeManager;
        this.view = view;
        doBind();
    }


    protected void doBind() {
        onBind();
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }


    public RestUrl getUrl() {
        return url;
    }

    //todo mikado: should be private
    public BaseView getView() {
        return view;
    }

    public void doActivation(RestUrl newUrl) {
        url = newUrl;

        view.replaceInWrapperDiv();

        onShow();
    }



    protected void onShow() {
    }


    /**
     * This method is called when binding the presenter. Any additional bindings
     * should be done here.
     */
    protected void onBind() {
    }

    /**
     * This method is called when unbinding the presenter. Any handler
     * registrations recorded with {@link #registerHandler(HandlerRegistration)}
     * will have already been removed at this point.
     */
    protected void onUnbind() {
    }


}
