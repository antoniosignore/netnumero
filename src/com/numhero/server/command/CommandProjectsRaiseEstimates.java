package com.numhero.server.command;

import com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest;
import com.numhero.shared.datacargo.BulkActionResponse;

public class CommandProjectsRaiseEstimates extends AbstractAuthenticatedCommand<ProjectGenerateInvoiceRequest, BulkActionResponse> {
    @Override
    public BulkActionResponse execute(ProjectGenerateInvoiceRequest projectGenerateInvoiceRequest) throws Exception {

        // todo
        BulkActionResponse resp = new BulkActionResponse();
        resp.setMessage("OK");
        return resp;
    }
}