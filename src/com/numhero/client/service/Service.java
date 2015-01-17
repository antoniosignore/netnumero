package com.numhero.client.service;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

//import com.numhero.client.Application;

@Singleton
public class Service<REQUEST extends CommandRequest, RESPONSE extends CommandResponse> {
	private final static int TIMEOUT_IN_SECS = 3;

	private Timer slowResponseTimer;
	private boolean isSlowResponse;
	private DataServiceAsync asyncService;

	@Inject
	public Service(DataServiceAsync asyncService) {
		this.asyncService = asyncService;
	}

	public void execute(REQUEST request, final ServiceCallback<RESPONSE> serviceCallback) {
		String baId = ClientUtils.getCompanyNameFromUri(Window.Location.getPath());
		request.setBusinessAccountId(baId);

		AsyncCallback<RESPONSE> callback = createCallback(request, serviceCallback);

		isSlowResponse = true;
		slowResponseTimer = new Timer() {
			@Override
			public void run() {
				if (isSlowResponse) {
					Application.showGlasspanelLoading();
				}
				slowResponseTimer = null;
			}
		};
		slowResponseTimer.schedule(TIMEOUT_IN_SECS * 1000);
		asyncService.execute(request, callback);
	}

	private AsyncCallback<RESPONSE> createCallback(final CommandRequest request, final ServiceCallback<RESPONSE> serviceCallback) {
		AsyncCallback<RESPONSE> callback = new AsyncCallback<RESPONSE>() {
			@Override
			public void onFailure(Throwable th) {
				stopTimer();
				Application.hideGlasspanelLoading();
				serviceCallback.onFailure(th);
			}

			@Override
			public void onSuccess(RESPONSE response) {
				stopTimer();
				Application.hideGlasspanelLoading();
				serviceCallback.onSuccess(response);

                //mika mikado
//				if (request.getRemoveFromCacheOnSuccess() != null) {
//					for (CommandRequest rFromCache : request.getRemoveFromCacheOnSuccess()) {
//						Application.injector.getClientCache().removeFromCache(rFromCache);
//					}
//				}
			}
		};
		return callback;
	}

	private void stopTimer() {
		isSlowResponse = false;
		if (slowResponseTimer != null) {
			slowResponseTimer.cancel();
			slowResponseTimer = null;
		}
	}
}
