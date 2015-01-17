package com.numhero.client.mvp.document;

import com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListRequest;
import com.numhero.client.model.datacargo.invoice.InvoiceListResponse;
import com.numhero.client.mvp.GridTabbedPage;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

public class RecentInvoicesPresenterTest {
        private RecentInvoicesPresenter presenter;
    private Service<DeleteDocumentsRequest, BulkActionResponse> deleteService;
    private PlaceManager placeMgr = Mockito.mock(PlaceManager.class);
    private Service<InvoiceListRequest, InvoiceListResponse> listService;
    private GridTabbedPage view = Mockito.mock(GridTabbedPage.class);
    private InvoiceConstants constants = Mockito.mock(InvoiceConstants.class);
    private Service changeStatusService;
//    private MockerForViewGrid mockerForViewGrid = new MockerForViewGrid();


        @Before
    public void setUp() throws Exception {
//        Mockito.when(constants.manageClients()).thenReturn(TITLE);
//        Mockito.when(constants.deleteClients()).thenReturn(CMD_DELETE);
//        Mockito.when(constants.raiseEstimates()).thenReturn(CMD_RAISE_ESTIMATES);
//        Mockito.when(constants.raiseExpenses()).thenReturn(CMD_RAISE_EXPENSES);
//        Mockito.when(constants.raiseInvoices()).thenReturn(CMD_RAISE_INVOICES);
//
//        view = mockerForViewGrid.mockView();
//        listService = (Service<ClientListRequest, ClientSupplierListResponse>) mockerForViewGrid.mockListService(createListResponse());
//
//        deleteService = mockerForViewGrid.mockDeleteService();

        presenter = new RecentInvoicesPresenter(placeMgr, listService, deleteService, changeStatusService, constants, view);

    }

    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(deleteService);
        Mockito.verifyNoMoreInteractions(listService);
        Mockito.verifyNoMoreInteractions(placeMgr);
        Mockito.verifyNoMoreInteractions(constants);

    }
}
