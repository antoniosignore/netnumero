package com.numhero.client.mvp.proxy;

import com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.staff.ReimbursableStaffPresenter;

public class ReimbursableStaffPresenterProxy extends PresenterProxy<ReimbursableStaffPresenter> {
    @Override
    protected ReimbursableStaffPresenter createPresenter() {

        return new ReimbursableStaffPresenter(getEventManager(),
                PresenterProxy.<ReimbursableStaffListRequest, StaffListResponse>createNewService(),
                getConstants());
    }
}
