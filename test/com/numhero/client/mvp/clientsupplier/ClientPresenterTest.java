package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.event.dom.client.ClickEvent;
import com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.RestUrl;
import com.numhero.client.service.Service;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.testHelpers.MockerForViewEdit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ClientPresenterTest {
    public static final String SAVED = "saved";
    private ClientPresenter presenter;
    private PlaceManager placeManager = Mockito.mock(PlaceManager.class);
    private Service<GetClientSupplierRequest, GetSingleEntityResponse<ClientSupplier>> serviceGetClient;
    private Service<SaveClientSupplierRequest, SaveSingleEntityResponse> serviceSaveClient;
    private EditPageView view = Mockito.mock(EditPageView.class);
    private ClientSupplier entity;
    private ClientsConstants constants = Mockito.mock(ClientsConstants.class);
    private static final String EDIT = "editClient";
    private MockerForViewEdit<ClientSupplier> mocker;

    @Before
    public void setUp() throws Exception {

        entity = PojoTestUtils.createClientSupplier();

        mocker = new MockerForViewEdit<ClientSupplier>();

        serviceGetClient = mocker.mockGetEntityService(entity);
        serviceSaveClient = mocker.mockSaveEntityService(entity);
        view = mocker.mockEditPageView(entity);

        when(constants.clientSavedSuccessfully()).thenReturn(SAVED);
        when(constants.editClient()).thenReturn(EDIT);

        presenter = new ClientPresenter(placeManager, view, serviceGetClient, serviceSaveClient, constants);

    }


    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(serviceGetClient);
        Mockito.verifyNoMoreInteractions(serviceSaveClient);
        Mockito.verifyNoMoreInteractions(placeManager);
    }




    private GetClientSupplierRequest simpleGetRequest() {
        GetClientSupplierRequest request = new GetClientSupplierRequest();
        request.setEntityId(123L);
        return request;
    }

    private RestUrl createUrl() {
        return new RestUrl("pippo/123");
    }


    private SaveClientSupplierRequest simpleSaveRequest() {
        SaveClientSupplierRequest request = new SaveClientSupplierRequest();
		request.setEntity(entity);
		return request;
    }


    private void verifyViewInitializationCalls() {
        assertNotNull(mocker.getSaveHandler());
        Mockito.verify(view).addSaveClickHandler(mocker.getSaveHandler());
        Mockito.verify(view).addCanceltHref("#clients");
        Mockito.verify(view).setDetailTitlePanel(EDIT);
        Mockito.verify(view).replaceInWrapperDiv();

    }

    @Test
    public void testInitializeViewOnActivation() throws Exception {

        RestUrl url = new RestUrl("pippo/123");
        presenter.doActivation(url);
        verifyViewInitializationCalls();

        Mockito.verify(serviceGetClient).execute(simpleGetRequest(), mocker.getServiceGetCallback());
        Mockito.verify(view).setPojo(entity);
    }

    @Test
    public void testSaveThePojoFromTheView() throws Exception {
        presenter.doActivation(createUrl());

        verifyViewInitializationCalls();

        Mockito.verify(serviceGetClient).execute(simpleGetRequest(), mocker.getServiceGetCallback());
        Mockito.verify(view).setPojo(entity);

        mocker.getSaveHandler().onClick(new ClickEvent() {
        });

        Mockito.verify(view).saveValuesFromUi();
        Mockito.verify(view).getPojo();
        Mockito.verify(view).showGlassPanel();
        Mockito.verify(serviceSaveClient).execute(simpleSaveRequest(), mocker.getServiceSaveCallback());

        Mockito.verify(view).showToaster(SAVED);
        Mockito.verify(placeManager).moveToPlace("clients");


    }
}
