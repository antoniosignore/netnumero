package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.server.model.daolite.ClientSupplierDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.exception.ClientWarningException;

public class CommandSaveClientSupplier extends AbstractAuthenticatedCommand<SaveClientSupplierRequest, SaveSingleEntityResponse> {
    @Inject
    ClientSupplierDao clientSupplierDao;

    @Override
    public SaveSingleEntityResponse execute(SaveClientSupplierRequest request) {
		ClientSupplier cs = (ClientSupplier) request.getEntity();

        validate(request.getBusinessAccountId(), cs);

        DaoUtils.setData(request, cs);
        clientSupplierDao.save(cs);

        // createAudit
        SaveSingleEntityResponse response = new SaveSingleEntityResponse();
		response.setEntityId(((ClientSupplier) request.getEntity()).getId());
        return response;
    }

	private void validate(String ba, ClientSupplier cs) {
		ClientSupplier csWithSameName = clientSupplierDao.findByName(ba, cs.fName.getValue());
        if (csWithSameName != null && !csWithSameName.fId.getValue().equals(cs.fId.getValue())) {
        	throw new ClientWarningException("clientSupplierExists");
        }
        ClientSupplier csWithSameVat = clientSupplierDao.findByVat(ba, cs.fVat.getValue());
        if (csWithSameVat != null && !csWithSameVat.fId.getValue().equals(cs.fId.getValue())) {
        	throw new ClientWarningException("clientSupplierExists");
        }
	}
}
