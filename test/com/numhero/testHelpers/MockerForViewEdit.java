package com.numhero.testHelpers;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.document.InvoiceEditPageView;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.shared.datacargo.GetSingleEntityRequest;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.pojoc.SearchablePojo;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class MockerForViewEdit<T extends SearchablePojo> {

    private ServiceCallback<GetSingleEntityResponse<T>> serviceGetCallback;

    private ServiceCallback<SaveSingleEntityResponse> serviceSaveCallback;

    private ClickHandler saveHandler;

    public MockerForViewEdit() {
    }

    public ClickHandler getSaveHandler() {
        return saveHandler;
    }

    public ServiceCallback<GetSingleEntityResponse<T>> getServiceGetCallback() {
        return serviceGetCallback;
    }

    public ServiceCallback<SaveSingleEntityResponse> getServiceSaveCallback() {
        return serviceSaveCallback;
    }


    public <W extends GetSingleEntityRequest, Z extends GetSingleEntityResponse<T>> Service<W, Z> mockGetEntityService(final T entity) {

        Service<W, Z> service = Mockito.mock(Service.class);
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                W request = (W) invocationOnMock.getArguments()[0];
                serviceGetCallback = (ServiceCallback<GetSingleEntityResponse<T>>) invocationOnMock.getArguments()[1];
                assertEquals(new Long(123L), request.getEntityId());

                GetSingleEntityResponse<T> response = new GetSingleEntityResponse<T>();
                response.setEntity(entity);
                serviceGetCallback.onSuccess(response);
                return null;
            }
        }).when(service).execute(Matchers.<W>any(), any(ServiceCallback.class));

        return service;
    }


    public <W extends SaveSingleEntityRequest<T>> Service<W, SaveSingleEntityResponse> mockSaveEntityService(final T entity) {

        Service<W, SaveSingleEntityResponse> service = Mockito.mock(Service.class);

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                W request = (W) invocationOnMock.getArguments()[0];
                serviceSaveCallback = (ServiceCallback<SaveSingleEntityResponse>) invocationOnMock.getArguments()[1];
                assertSame(entity, request.getEntity());

                SaveSingleEntityResponse response = new SaveSingleEntityResponse();
                response.setEntityId(1L);
                serviceSaveCallback.onSuccess(response);
                return null;
            }
        }).when(service).execute(Matchers.<W>any(), any(ServiceCallback.class));


        return service;
    }

    public EditPageView mockEditPageView(T entity) {
        EditPageView view = Mockito.mock(EditPageView.class);

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                saveHandler = (ClickHandler) invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(view).addSaveClickHandler(any(ClickHandler.class));
        when(view.saveValuesFromUi()).thenReturn(true);
        when(view.getPojo()).thenReturn(entity);


        return view;
    }

    public InvoiceEditPageView mockInvoiceEditPageView(T entity) {
        InvoiceEditPageView view = Mockito.mock(InvoiceEditPageView.class);

        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                saveHandler = (ClickHandler) invocationOnMock.getArguments()[0];
                return null;
            }
        }).when(view).addSaveClickHandler(any(ClickHandler.class));
        when(view.saveValuesFromUi()).thenReturn(true);
        when(view.getPojo()).thenReturn(entity);


        return view;
    }
}
