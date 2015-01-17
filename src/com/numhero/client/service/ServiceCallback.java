package com.numhero.client.service;

import com.numhero.shared.datacargo.CommandResponse;

public interface ServiceCallback<RESPONSE extends CommandResponse> {

    public void onFailure(Throwable th);

    public void onSuccess(RESPONSE response);
}
