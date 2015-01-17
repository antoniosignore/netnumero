package com.numhero.server.command;

import com.google.inject.Inject;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.server.model.daolite.TaxInfoDao;
import com.numhero.shared.datacargo.ListCommandRequest.TYPE;
import com.numhero.shared.datacargo.PaginatedList;

public class CommandGetTaxInfos extends AbstractGetPaginatedCommand<TaxInfoListRequest, TaxInfoListResponse> {

    @Inject
    TaxInfoDao taxInfoDao;

    @Override
    public TaxInfoListResponse execute(TaxInfoListRequest request) {
        TaxInfoListResponse response = new TaxInfoListResponse();


        if (request.getType() == TYPE.SUGGEST) {
            if (request.getStartingKey().equals("*")) {
                response.setEntityList(taxInfoDao.findAll(request.getBusinessAccountId()));
                return response;
            } else {
                response.setEntityList(taxInfoDao.searchForStartsWith(request.getStartingKey(), request.getMaxResults(), request.getBusinessAccountId()));
                return response;
            }
        } else {
            return getPaginatedResults(request);
        }


    }

    private PaginatedList<TaxInfo> getPaginated(TaxInfoListRequest request) {

        return taxInfoDao.findAllPaginated(request.getBusinessAccountId(), request.getMaxResults(), request.getRefObjectId());
    }

    @Override
    protected TaxInfoListResponse getPaginatedResults(TaxInfoListRequest request) {
        TaxInfoListResponse response = new TaxInfoListResponse();
        response.setPaginatedList(getPaginated(request));
        return response;
    }
}
