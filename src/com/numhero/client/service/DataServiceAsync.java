package com.numhero.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;

public interface DataServiceAsync {

    public <REQUEST extends CommandRequest, RESPONSE extends CommandResponse> void execute(REQUEST request, AsyncCallback<RESPONSE> callback);
}
