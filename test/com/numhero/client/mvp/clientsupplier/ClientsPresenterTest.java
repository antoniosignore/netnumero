package com.numhero.client.mvp.clientsupplier;

import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

public class ClientsPresenterTest extends AbstractClientsSuppliersPresenterTest {


    private ClientsPresenter presenter;
    private Service<ClientListRequest, ClientSupplierListResponse> listService;
    private Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteService;


    @Before
    public void setUp() throws Exception {
        Mockito.when(constants.manageClients()).thenReturn(TITLE);
        Mockito.when(constants.deleteClients()).thenReturn(CMD_DELETE);
        Mockito.when(constants.raiseEstimates()).thenReturn(CMD_RAISE_ESTIMATES);
        Mockito.when(constants.raiseExpenses()).thenReturn(CMD_RAISE_EXPENSES);
        Mockito.when(constants.raiseInvoices()).thenReturn(CMD_RAISE_INVOICES);

        view = mockerForViewGrid.mockView();
        listService = mockerForViewGrid.mockListService(createListResponse());

        deleteService = mockerForViewGrid.mockDeleteService();

        presenter = new ClientsPresenter(placeMgr, view, listService, deleteService, constants);

    }

    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(deleteService);
        Mockito.verifyNoMoreInteractions(listService);
        Mockito.verifyNoMoreInteractions(placeMgr);
        Mockito.verifyNoMoreInteractions(constants);

    }

    @Override
    protected void verifyConstantsUse() {
        super.verifyConstantsUse();
        Mockito.verify(constants).manageClients();

    }


    @Override
    protected Service getDeleteService() {
        return deleteService;
    }

    @Override
    protected Service getListService() {
        return listService;
    }


    @Override
    protected ClientListRequest simpleRequest() {
        ClientListRequest request = new ClientListRequest();
        request.setMaxResults(10);
        request.setStartingKey(null);
        return request;
    }


    protected void activatePresenter() {
        presenter.doActivation(getUrl());
    }

}
