package com.numhero.server.service;

import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.service.DataService;
import com.numhero.server.NumheroUtils;
import com.numhero.server.command.ICommandProcessor;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.exception.ClientWarningException;
import com.numhero.shared.exception.NotAuthorizedException;

import java.util.logging.Logger;

public class DataServiceImpl extends AuthenticatedService implements DataService {
    private static final long serialVersionUID = 1698618107320369423L;
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(DataServiceImpl.class.getName());
    private ICommandProcessor cprocessor;

    public DataServiceImpl() {
        cprocessor = NumheroUtils.injector.getInstance(ICommandProcessor.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <REQUEST extends CommandRequest, RESPONSE extends CommandResponse> RESPONSE execute(REQUEST request) throws ClientWarningException {

        User user = authenticateUser();

        BusinessAccount ba = getBusinessAccountFromRequest(request);


        if (!user.hasRelationToBa(ba.fBusinessAccountUri.getValue())) {
            throw new NotAuthorizedException("user not related with ba:"+ba.fBusinessAccountUri.getValue());
        }

        long startTime = System.currentTimeMillis();

        log.info("Processing request " + request.getClass().getSimpleName());

        RESPONSE response = null;

        response = (RESPONSE) cprocessor.process(user, ba, request);

        long endTime = System.currentTimeMillis();
        log.info("Request " + request.getClass().getSimpleName() + " successfully processed in " + (endTime - startTime) + " ms");

        return response;
    }



}
