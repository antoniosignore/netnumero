package com.numhero.client.mvp.proxy;

import com.numhero.client.Application;
import com.numhero.client.LocalizableConstants;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.DataServiceAsync;
import com.numhero.client.service.Service;
import com.numhero.client.util.Log;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

public abstract class PresenterProxy<T extends BasePresenter> {

	private T presenter;

    public PresenterProxy() {
    }

	public T getPresenter() {
		if (presenter == null) {
            Log.debug("creating presenter " + getClass());
            presenter = createPresenter();
            if (presenter == null)
                throw new RuntimeException("problem instantiating " + getClass());
		}
		return presenter;
	}

    protected abstract T createPresenter();

    private static DataServiceAsync getService() {
        return Application.injector.getAsyncService();
    }

    protected static PlaceManager getEventManager() {
        return Application.injector.getPlaceManager();
    }

    protected static LocalizableConstants getConstants() {
        return Application.getConstants();
    }

    protected static <K extends CommandRequest, V extends CommandResponse> Service<K, V> createNewService() {
        return new Service<K, V>(getService());
    }

}
