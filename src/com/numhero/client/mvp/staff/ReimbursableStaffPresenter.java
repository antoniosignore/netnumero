package com.numhero.client.mvp.staff;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.GenericStaffTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

@Singleton
public class ReimbursableStaffPresenter extends GridPresenter {

    private Service<ReimbursableStaffListRequest, StaffListResponse> staffListService;

    @Inject
    public ReimbursableStaffPresenter(
            PlaceManager eventManager,
            Service<ReimbursableStaffListRequest, StaffListResponse> staffListService,
            StaffConstants constants) {
        super(eventManager, new GenericStaffTabViewPage(new StaffTable()));
        this.staffListService = staffListService;

        getView().setDetailTitlePanel(constants.reimburseStaff());

    }


    protected void refreshFromServer() {
        ReimbursableStaffListRequest request = new ReimbursableStaffListRequest();

        setPagination(request);
        super.refreshFromServer();

        staffListService.execute(request, new ServiceCallbackImpl<StaffListResponse>() {
            @Override
            public void onSuccess(StaffListResponse response) {

                getView().putEntitiesInGrid(response);

            }
        });
    }
}
