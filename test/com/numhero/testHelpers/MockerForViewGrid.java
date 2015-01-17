package com.numhero.testHelpers;

import com.google.gwt.user.client.Command;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import org.junit.Assert;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;

public class MockerForViewGrid {

    private Map<String, Command> bulkCommands = new HashMap<String, Command>();

    public MockerForViewGrid() {
    }

    public GridPageView mockView() {
        GridPageView mockedView = Mockito.mock(GridPageView.class);
        addMockedCommand(mockedView);

        doAnswer(new Answer<List<Long>>() {

            @Override
            public List<Long> answer(InvocationOnMock invocationOnMock) throws Throwable {
                ArrayList<Long> list = new ArrayList<Long>();
                list.add(1L);
                list.add(2L);
                list.add(3L);
                return list;
            }
        }).when(mockedView).getSelectedIds();

        //preparegrid

        return mockedView;
    }

    private void addMockedCommand(GridPageView mockedView) {
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();

                for (Object arg : args) {
                    CommandWrapper cw = (CommandWrapper) arg;
                    Assert.assertNotNull("command wrapper", cw);
                    Assert.assertNotNull("command", cw.getCommand());
                    Assert.assertNotNull("commandName", cw.getName());
                    bulkCommands.put(cw.getName(), cw.getCommand());

                }
                return null;
            }
        }).when(mockedView).addActionsCommands(Matchers.<CommandWrapper>anyVararg());
    }

    public Command getCommand(String cmdName) {
        Command command = bulkCommands.get(cmdName);
        Assert.assertNotNull("bulk command " + cmdName + " not loaded", command);
        return command;
    }


    public <W extends ListCommandRequest, Z extends ListCommandResponse> Service<W, Z>  mockListService
                            (final Z listServiceResponse) {
        Service<W, Z> service = Mockito.mock(Service.class);

        doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
                ListCommandRequest request = (ListCommandRequest) invocationOnMock.getArguments()[0];

                ServiceCallback<ListCommandResponse> serviceListCallback = (ServiceCallback) invocationOnMock.getArguments()[1];
                assertEquals(null, request.getRefObjectId());
                assertEquals(ListCommandRequest.TYPE.DATA, request.getType());

                serviceListCallback.onSuccess(listServiceResponse);
                return null;
            }
        }).when(service).execute(Matchers.<W>any(), any(ServiceCallback.class));  //ListCommandRequest.class

        return service;
    }


    public Service mockDeleteService() {

        Service service = Mockito.mock(Service.class);

        return service;
    }
}
