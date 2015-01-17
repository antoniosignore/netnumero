package com.numhero.client.mvp.clientsupplier;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ClientsPresenter extends AbstractClientsSuppliersPresenter {

    private Service<ClientListRequest, ClientSupplierListResponse> clientSupplierListService;


    public ClientsPresenter(PlaceManager eventManager, GridPageView view,
                            Service<ClientListRequest, ClientSupplierListResponse> clientSupplierListService,
                            Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteClientsSuppliersService,
                            ClientsConstants clientsConstants
    ) {

        super(eventManager, view, clientsConstants, deleteClientsSuppliersService);

        this.clientSupplierListService = clientSupplierListService;

        getView().setDetailTitlePanel(consts.manageClients());

        setupBulkActionMenu();
    }

    @Override
    protected void refreshFromServer() {
        ClientListRequest request = new ClientListRequest();

        setPagination(request);
        super.refreshFromServer();

        clientSupplierListService.execute(request, new ServiceCallbackImpl<ClientSupplierListResponse>() {
            @Override
            public void onSuccess(ClientSupplierListResponse response) {
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
