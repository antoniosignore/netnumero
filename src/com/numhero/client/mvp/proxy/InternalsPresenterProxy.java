package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.staff.DeleteStaffRequest;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.staff.InternalsPresenter;
import com.numhero.client.service.Service;
import com.numhero.shared.datacargo.BulkActionResponse;

public class InternalsPresenterProxy extends PresenterProxy<InternalsPresenter> {
    @Override
    protected InternalsPresenter createPresenter() {

        Service<StaffListRequest,StaffListResponse> listService = createNewService();
        Service<DeleteStaffRequest,BulkActionResponse> deleteService = createNewService();
        return new InternalsPresenter(getEventManager(),
                listService, deleteService,
                getConstants());
    }
}
