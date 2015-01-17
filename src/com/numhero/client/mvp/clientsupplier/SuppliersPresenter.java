package com.numhero.client.mvp.clientsupplier;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;

@Singleton
public class SuppliersPresenter extends AbstractClientsSuppliersPresenter {

    private Service<SupplierListRequest, ClientSupplierListResponse> clientSupplierListService;


    @Inject
    public SuppliersPresenter(PlaceManager eventManager,  GridPageView view,
                              Service<SupplierListRequest, ClientSupplierListResponse> clientSupplierListService,
                              Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteClientsSuppliersService,
                            ClientsConstants clientsConstants
    ) {

        super(eventManager, view, clientsConstants, deleteClientsSuppliersService);
        this.clientSupplierListService = clientSupplierListService;

        getView().setDetailTitlePanel(clientsConstants.manageSuppliers());

        setupBulkActionMenu();

    }



    protected void refreshFromServer() {
        SupplierListRequest request = new SupplierListRequest();

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
