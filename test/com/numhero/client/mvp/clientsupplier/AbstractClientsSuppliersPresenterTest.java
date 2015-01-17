package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.RestUrl;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.testHelpers.MockerForViewGrid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;

public abstract class AbstractClientsSuppliersPresenterTest {
    private static final String ENTITIES_URL = "entities";
    protected static final String CMD_RAISE_ESTIMATES = "raiseEstimates";
    protected static final String CMD_RAISE_EXPENSES = "raiseExpenses";
    protected static final String CMD_DELETE = "delete";
    protected static final String CMD_RAISE_INVOICES = "raiseInvoices";
    protected static final String TITLE = "title";
    protected GridPageView view;
    protected PlaceManager placeMgr = Mockito.mock(PlaceManager.class);
    protected ClientsConstants constants = Mockito.mock(ClientsConstants.class);
    protected final MockerForViewGrid mockerForViewGrid = new MockerForViewGrid();

    @Before
    public abstract void setUp() throws Exception;

    @After
    public abstract void tearDown() throws Exception;

    protected RestUrl getUrl() {
        return new RestUrl(ENTITIES_URL);
    }

    public ClientSupplierListResponse createListResponse() {
        final ClientSupplierListResponse response = new ClientSupplierListResponse();
        List<ClientSupplier> list = new ArrayList<ClientSupplier>();
        list.add(PojoTestUtils.createClientSupplier());
        list.add(PojoTestUtils.createClientSupplier());
        list.add(PojoTestUtils.createClientSupplier());
        response.setEntityList(list);

        return response;
    }

    protected void verifyConstantsUse() {
        Mockito.verify(constants).deleteClients();
        Mockito.verify(constants).raiseEstimates();
        Mockito.verify(constants).raiseExpenses();
        Mockito.verify(constants).raiseInvoices();
    }

    protected void verifyViewInit() {
        Mockito.verify(view).prepareTable(any(ClickHandler.class), any(ClickHandler.class),
                                          any(ClickHandler.class), any(ClickHandler.class));
        Mockito.verify(view).setDetailTitlePanel(TITLE);

        Mockito.verify(view).addActionsCommands(any(CommandWrapper.class), any(CommandWrapper.class),
                                                any(CommandWrapper.class), any(CommandWrapper.class));
        Mockito.verify(view).replaceInWrapperDiv();
        Mockito.verify(view).showLoading();
    }

    protected void verifyViewFirstLoad() {
        ListCommandRequest request = simpleRequest();
        Mockito.verify(getListService()).execute(Mockito.eq(request), any(ServiceCallback.class));

        Mockito.verify(view).putEntitiesInGrid(createListResponse());
    }

    protected abstract Service getDeleteService();

    protected abstract Service getListService();

    protected abstract ListCommandRequest simpleRequest();

    protected abstract void activatePresenter();



    @Test
    public void testInitializeViewAndAskListOnActivation() throws Exception {

        activatePresenter();

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();

    }



    @Test
    public void testDeleteItemFromList() throws Exception {

        activatePresenter();

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();



        mockerForViewGrid.getCommand(CMD_DELETE).execute();
        Mockito.verify(view).getSelectedIds();

        Mockito.verify(getDeleteService()).execute(any(DeleteClientsSuppliersRequest.class), any(ServiceCallback.class));
    }

    @Test
    public void testRaiseExpensesFromList() throws Exception {

        activatePresenter();

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();



        mockerForViewGrid.getCommand(CMD_RAISE_EXPENSES).execute();
        Mockito.verify(view).getSelectedIds();
        Mockito.verify(placeMgr).moveToPlace("expense/1");
    }


    @Test
    public void testRaiseEstimatesFromList() throws Exception {

        activatePresenter();

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();


        mockerForViewGrid.getCommand(CMD_RAISE_ESTIMATES).execute();
        Mockito.verify(view).getSelectedIds();
        Mockito.verify(placeMgr).moveToPlace("estimate/1");
    }

    @Test
    public void testRaiseInvoicesFromList() throws Exception {

        activatePresenter();

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();


        mockerForViewGrid.getCommand(CMD_RAISE_INVOICES).execute();
        Mockito.verify(view).getSelectedIds();
        Mockito.verify(placeMgr).moveToPlace("invoice/1");
    }


}
