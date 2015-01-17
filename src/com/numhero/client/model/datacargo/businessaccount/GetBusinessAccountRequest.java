package com.numhero.client.model.datacargo.businessaccount;

import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetBusinessAccountRequest extends GetSingleEntityRequest {

    public GetBusinessAccountRequest() {
        setCommand(ApplicationCommandEnum.CommandGetBusinessAccount);
    }

    @Override
	public int getCacheExpireInSec() {
		return NO_EXPIRE;
	}
}
