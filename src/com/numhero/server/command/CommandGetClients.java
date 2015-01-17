package com.numhero.server.command;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.shared.enums.ClientSupplierEnum;

public class CommandGetClients extends AbstractCommandGetPartners<ClientListRequest> {

    @Override
    public ClientSupplierListResponse execute(ClientListRequest request) {

        type = ClientSupplierEnum.client;
        return super.execute(request);

    }
}
