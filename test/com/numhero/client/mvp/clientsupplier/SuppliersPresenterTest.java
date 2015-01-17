package com.numhero.client.mvp.clientsupplier;

import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.model.datacargo.client_supplier.SupplierListRequest;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;

public class SuppliersPresenterTest extends AbstractClientsSuppliersPresenterTest {
    private SuppliersPresenter presenter;

    private Service<SupplierListRequest, ClientSupplierListResponse> listService;
    private Service<DeleteClientsSuppliersRequest, BulkActionResponse> deleteService;


    @Before
    public void setUp() throws Exception {
        Mockito.when(constants.manageSuppliers()).thenReturn(TITLE);
        Mockito.when(constants.deleteClients()).thenReturn(CMD_DELETE);
        Mockito.when(constants.raiseEstimates()).thenReturn(CMD_RAISE_ESTIMATES);
        Mockito.when(constants.raiseExpenses()).thenReturn(CMD_RAISE_EXPENSES);
        Mockito.when(constants.raiseInvoices()).thenReturn(CMD_RAISE_INVOICES);

        view = mockerForViewGrid.mockView();
        listService = mockerForViewGrid.mockListService(createListResponse());

        deleteService = mockerForViewGrid.mockDeleteService();

        presenter = new SuppliersPresenter(placeMgr, view, listService, deleteService, constants);

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
        Mockito.verify(constants).manageSuppliers();

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
    protected SupplierListRequest simpleRequest() {
        SupplierListRequest request = new SupplierListRequest();
        request.setMaxResults(10);
        request.setStartingKey(null);
        return request;

    }

    @Override
    protected void activatePresenter() {
        presenter.doActivation(getUrl());

    }

//        private RestUrl getUrl() {
//            return new RestUrl(ENTITIES_URL);
//        }
//
//        public ClientSupplierListResponse createListResponse() {
//            final ClientSupplierListResponse response = new ClientSupplierListResponse();
//            List<ClientSupplier> list = new ArrayList<ClientSupplier>();
//            list.add(PojoTestUtils.createClientSupplier());
//            list.add(PojoTestUtils.createClientSupplier());
//            list.add(PojoTestUtils.createClientSupplier());
//            response.setEntityList(list);
//
//            return response;
//        }
//
//        private void verifyConstantsUse() {
//            Mockito.verify(constants).manageSuppliers();
//            Mockito.verify(constants).deleteClients();
//            Mockito.verify(constants).raiseEstimates();
//            Mockito.verify(constants).raiseExpenses();
//            Mockito.verify(constants).raiseInvoices();
//        }
//
//        private void verifyViewInit() {
//            Mockito.verify(view).prepareTable(any(ClickHandler.class), any(ClickHandler.class),
//                                              any(ClickHandler.class), any(ClickHandler.class));
//            Mockito.verify(view).setDetailTitlePanel(TITLE);
//
//            Mockito.verify(view).addActionsCommands(any(CommandWrapper.class), any(CommandWrapper.class),
//                                                    any(CommandWrapper.class), any(CommandWrapper.class));
//            Mockito.verify(view).replaceInWrapperDiv();
//            Mockito.verify(view).showLoading();
//        }
//
//        private void verifyViewFirstLoad() {
//            SupplierListRequest request = simpleRequest();
//            Mockito.verify(listService).execute(Mockito.eq(request), any(ServiceCallback.class));
//
//            Mockito.verify(view).putEntitiesInGrid(createListResponse());
//        }
//
//
//        private SupplierListRequest simpleRequest() {
//            SupplierListRequest request = new SupplierListRequest();
//            request.setMaxResults(10);
//            request.setStartingKey(null);
//            return request;
//
//        }
//
//
//
//        @Test
//        public void testInitializeViewAndAskListOnActivation() throws Exception {
//
//            presenter.doActivation(getUrl());
//
//            verifyViewInit();
//            verifyConstantsUse();
//
//            verifyViewFirstLoad();
//
//        }
//
//
//
//        @Test
//        public void testDeleteItemFromList() throws Exception {
//
//            presenter.doActivation(getUrl());
//
//            verifyViewInit();
//            verifyConstantsUse();
//
//            verifyViewFirstLoad();
//
//
//
//            mockerForViewGrid.getCommand(CMD_DELETE).execute();
//            Mockito.verify(view).getSelectedIds();
//
//            Mockito.verify(deleteService).execute(any(DeleteClientsSuppliersRequest.class), any(ServiceCallback.class));
//        }
//
//        @Test
//        public void testRaiseExpensesFromList() throws Exception {
//
//            presenter.doActivation(getUrl());
//
//            verifyViewInit();
//            verifyConstantsUse();
//
//            verifyViewFirstLoad();
//
//
//
//            mockerForViewGrid.getCommand(CMD_RAISE_EXPENSES).execute();
//            Mockito.verify(view).getSelectedIds();
//            Mockito.verify(placeMgr).moveToPlace("expense/1");
//        }
//
//
//        @Test
//        public void testRaiseEstimatesFromList() throws Exception {
//
//            presenter.doActivation(getUrl());
//
//            verifyViewInit();
//            verifyConstantsUse();
//
//            verifyViewFirstLoad();
//
//
//            mockerForViewGrid.getCommand(CMD_RAISE_ESTIMATES).execute();
//            Mockito.verify(view).getSelectedIds();
//            Mockito.verify(placeMgr).moveToPlace("estimate/1");
//        }
//
//        @Test
//        public void testRaiseInvoicesFromList() throws Exception {
//
//            presenter.doActivation(getUrl());
//
//            verifyViewInit();
//            verifyConstantsUse();
//
//            verifyViewFirstLoad();
//
//
//            mockerForViewGrid.getCommand(CMD_RAISE_INVOICES).execute();
//            Mockito.verify(view).getSelectedIds();
//            Mockito.verify(placeMgr).moveToPlace("invoice/1");
//        }

}
