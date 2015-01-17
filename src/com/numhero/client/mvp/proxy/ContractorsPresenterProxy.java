package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.staff.DeleteStaffRequest;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.staff.ContractorsPresenter;
import com.numhero.shared.datacargo.BulkActionResponse;

public class ContractorsPresenterProxy extends PresenterProxy<ContractorsPresenter> {
    @Override
    protected ContractorsPresenter createPresenter() {

        return new ContractorsPresenter(getEventManager(),
                PresenterProxy.<StaffListRequest, StaffListResponse>createNewService(),
                PresenterProxy.<DeleteStaffRequest, BulkActionResponse>createNewService(),
                getConstants());
    }
}
