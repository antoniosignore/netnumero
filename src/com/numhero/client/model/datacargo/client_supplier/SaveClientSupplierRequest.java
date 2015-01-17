package com.numhero.client.model.datacargo.client_supplier;

import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveClientSupplierRequest extends SaveSingleEntityRequest<ClientSupplier> {

    public SaveClientSupplierRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveClientSupplier);
    }

	@Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new ClientListRequest(), new SupplierListRequest() };
    }
}
