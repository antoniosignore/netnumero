package com.numhero.client.model.datacargo.taxinfo;

import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveTaxInfoRequest extends SaveSingleEntityRequest {

    public SaveTaxInfoRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveTaxInfo);
    }

    public TaxInfo getTaxInfo() {
        return (TaxInfo) getEntity();
    }

    public void setTaxInfo(TaxInfo taxInfoC) {
        setEntity(taxInfoC);
    }

    @Override
    public CommandRequest[] getRemoveFromCacheOnSuccess() {
    	return new CommandRequest[] { new TaxInfoListRequest() };
    }
}
