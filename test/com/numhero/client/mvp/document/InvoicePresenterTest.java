package com.numhero.client.mvp.document;

import com.numhero.client.model.datacargo.invoice.GetInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest;
import com.numhero.client.model.datacargo.invoice.SendInvoiceRequest;
import com.numhero.client.model.pojoc.Invoice;
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

public class InvoicePresenterTest {
    private InvoicePresenter presenter;

    private PlaceManager placeManager = Mockito.mock(PlaceManager.class);
    private Invoice entity;
    private InvoiceConstants constants = Mockito.mock(InvoiceConstants.class);
    private Service serviceClientsList;
    private Service serviceClientSave;
    private InvoiceEditPageView view = Mockito.mock(InvoiceEditPageView.class);
    private MockerForViewEdit<Invoice> mocker;

    private Service<GetInvoiceRequest, GetSingleEntityResponse<Invoice>> serviceGetEntity;
    private Service<SaveInvoiceRequest, SaveSingleEntityResponse> serviceSaveEntity;
    private Service<SendInvoiceRequest, SaveSingleEntityResponse> invoiceSendService;
    private static final String EDIT = "edit";


    @Before
    public void setUp() throws Exception {

        entity = PojoTestUtils.createInvoice();


        mocker = new MockerForViewEdit<Invoice>();

        serviceGetEntity = mocker.mockGetEntityService(entity);
        serviceSaveEntity = mocker.mockSaveEntityService(entity);
        view = mocker.mockInvoiceEditPageView(entity);

//        when(constants.()).thenReturn(SAVED);
//        when(constants.editClient()).thenReturn(EDIT);


        presenter = new InvoicePresenter(placeManager, serviceGetEntity, serviceSaveEntity,
                invoiceSendService, constants, view);

    }


    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(serviceGetEntity);
        Mockito.verifyNoMoreInteractions(serviceSaveEntity);
        Mockito.verifyNoMoreInteractions(placeManager);
    }


    private void verifyViewInitializationCalls() {
        assertNotNull("SaveHandler", mocker.getSaveHandler());
        Mockito.verify(view).addSaveClickHandler(mocker.getSaveHandler());
        Mockito.verify(view).addCanceltHref("#clients");
        Mockito.verify(view).setDetailTitlePanel(EDIT);
        Mockito.verify(view).replaceInWrapperDiv();

    }

    private static GetInvoiceRequest simpleGetRequest() {
        return new GetInvoiceRequest(123L);

    }

    @Test
    public void testInitializeViewOnActivation() throws Exception {

        RestUrl url = new RestUrl("pippo/123");
        presenter.doActivation(url);
        verifyViewInitializationCalls();

        Mockito.verify(serviceGetEntity).execute(simpleGetRequest(), mocker.getServiceGetCallback());
        Mockito.verify(view).setPojo(entity);
    }


}
