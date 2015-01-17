package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest;
import com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.model.daolite.TaxInfoDao;
import com.numhero.server.utils.DaoUtils;
import com.numhero.shared.exception.ClientWarningException;

import java.util.logging.Logger;

public class CommandSaveTaxInfo extends AbstractAuthenticatedCommand<SaveTaxInfoRequest, SaveTaxInfoResponse> {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(CommandSaveTaxInfo.class.getName());

    @Inject
    TaxInfoDao taxInfoDao;

    @Override
    public SaveTaxInfoResponse execute(SaveTaxInfoRequest request) {

        TaxInfo taxInfo = (TaxInfo) request.getEntity();
        DaoUtils.setData(request, taxInfo);

        validate(request.getBusinessAccountId(), taxInfo);
        taxInfoDao.save(taxInfo);

        // createAudit
        SaveTaxInfoResponse response = new SaveTaxInfoResponse();
        response.setEntityId(taxInfo.getId());
        return response;
    }

    private void validate(String ba, TaxInfo staff) {
        TaxInfo csWithSameName = taxInfoDao.findByName(ba, staff.fName.getValue());
        if (csWithSameName != null && !csWithSameName.fId.getValue().equals(staff.fId.getValue())) {
            throw new ClientWarningException("taxInfoExists");
        }
    }

}
