package com.numhero.client.mvp.staff;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.staff.DeleteStaffRequest;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericStaffTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.StaffTypeEnum;

import java.util.List;

@Singleton
public class ContractorsPresenter extends GridPresenter {

    private Service<StaffListRequest, StaffListResponse> staffListService;
    private Service<DeleteStaffRequest, BulkActionResponse> deleteStaffService;


    @Inject
    public ContractorsPresenter(
            PlaceManager eventManager,
            Service<StaffListRequest, StaffListResponse> staffListService,
            Service<DeleteStaffRequest, BulkActionResponse> deleteStaffService, final StaffConstants constants) {
        super(eventManager, new GenericStaffTabViewPage(new StaffTable()));
        this.staffListService = staffListService;
        this.deleteStaffService = deleteStaffService;


        getView().setDetailTitlePanel(constants.manageContractors());

        CommandWrapper deleteStaffCommand = new CommandWrapper(constants.deleteStaff(), new Command() {
            public void execute() {
                deleteStaff(getView().getSelectedIds());
            }
        });
        getView().addActionsCommands(deleteStaffCommand);
    }

    private void deleteStaff(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;

        DeleteStaffRequest request = new DeleteStaffRequest();
        request.setEntityIdList(ids);
        deleteStaffService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    Window.alert(Application.getConstants().errorDeleting());
                } else {
                    Application.toasterMessage(Application.getConstants().itemsDeleted());
                }
                refreshFromServer();
            }
        });
    }


    protected void refreshFromServer() {
        StaffListRequest request = new StaffListRequest();
        request.setStaffType(StaffTypeEnum.Contractor);

        setPagination(request);
        super.refreshFromServer();


        staffListService.execute(request, new ServiceCallbackImpl<StaffListResponse>() {
            @Override
            public void onSuccess(StaffListResponse response) {
//                ((StaffTable) getView().getContentPanel().getContentWidget()).setStaffs(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
