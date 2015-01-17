package com.numhero.client.mvp.users;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.user.*;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

@Singleton
public class UsersPresenter extends BasePresenter {

    private Service<UserListRequest, UserListResponse> userListService;
    private Service<DeleteUsersRequest, BulkActionResponse> deleteUsersService;
    private Service<SuspendUsersRequest, BulkActionResponse> suspendUsersService;
    private Service<ReactivateUsersRequest, BulkActionResponse> reactivateUserService;


    @Inject
    public UsersPresenter(PlaceManager eventManager,
                          Service<UserListRequest, UserListResponse> userListService,
                          UsersView recentUsersView,
                          Service<DeleteUsersRequest, BulkActionResponse> deleteUsersService,
                          Service<SuspendUsersRequest, BulkActionResponse> suspendUsersService,
                          Service<ReactivateUsersRequest, BulkActionResponse> reactivateUserService) {
        super(eventManager, recentUsersView);
        this.userListService = userListService;
        this.deleteUsersService = deleteUsersService;
        this.suspendUsersService = suspendUsersService;
        this.reactivateUserService = reactivateUserService;

        final UsersTable table = ((UsersPanel) getView().getContent()).getUsersTable();
        Command suspendUsersCommand = new Command() {
            public void execute() {
                suspendUsers(table.getSelectedIds());
            }
        };
        Command unsuspendCommand = new Command() {
            public void execute() {
                unsuspendUsers(table.getSelectedIds());
            }
        };
        Command deleteUsersCommand = new Command() {
            public void execute() {
                deleteUsers(table.getSelectedIds());
            }
        };
        table.getFooter().getTableFooterActionsCombo().setAnimationEnabled(true);
        table.getFooter().getTableFooterActionsCombo().setAutoOpen(true);
        MenuBar bulkActions = new MenuBar(true);
        bulkActions.addItem(new MenuItem(Application.getConstants().suspendUsers(), suspendUsersCommand));
        bulkActions.addItem(new MenuItem(Application.getConstants().unsuspendUsers(), unsuspendCommand));
        bulkActions.addItem(new MenuItem(Application.getConstants().deleteUsers(), deleteUsersCommand));
        table.getFooter().getTableFooterActionsCombo().addItem(new MenuItem(Application.getConstants().bulkAction(), bulkActions));
    }

    private void suspendUsers(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;
        SuspendUsersRequest request = new SuspendUsersRequest();
        request.setEntityIdList(ids);
        suspendUsersService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) Window.alert("Errors suspending users");
                refreshFromServer();
            }
        });
    }

    private void unsuspendUsers(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;
        ReactivateUsersRequest request = new ReactivateUsersRequest();
        request.setEntityIdList(ids);
        reactivateUserService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) Window.alert("Errors reactivating users");
                refreshFromServer();
            }
        });
    }

    private void deleteUsers(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;

        DeleteUsersRequest request = new DeleteUsersRequest();
        request.setEntityIdList(ids);
        deleteUsersService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
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


    @Override
    public UsersView getView() {
        return (UsersView) super.getView();
    }

    protected void refreshFromServer() {
        getView().getUsersPanel().getUsersTable().showLoading();
        UserListRequest request = new UserListRequest();

        // todo add pagination
//        setPagination(request);
//        super.refreshFromServer();

        userListService.execute(request, new ServiceCallbackImpl<UserListResponse>() {
            @Override
            public void onSuccess(UserListResponse response) {
                getView().getUsersPanel().getUsersTable().setEntities(response.getEntityList());
            }
        });
    }
}
