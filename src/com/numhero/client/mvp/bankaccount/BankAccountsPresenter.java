package com.numhero.client.mvp.bankaccount;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest;
import com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse;
import com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericAccountsTabViewPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

@Singleton
public class BankAccountsPresenter extends GridPresenter {

    private Service<DeleteBankAccountsRequest, BulkActionResponse> deleteBankAccountsService;
    private Service<BankAccountListRequest, BankAccountListResponse> bankAccountListService;

    @Inject
    public BankAccountsPresenter(PlaceManager eventManager,
                                 Service<BankAccountListRequest, BankAccountListResponse> bankAccountListService,
                                 Service<DeleteBankAccountsRequest, BulkActionResponse> deleteBankAccountsService,
                                 final BankAccountConstants constants) {
        super(eventManager, new GenericAccountsTabViewPage(new BankAccountsTable()));

        this.bankAccountListService = bankAccountListService;
        this.deleteBankAccountsService = deleteBankAccountsService;

        getView().setDetailTitlePanel(constants.manageBankAccounts());

        getView().addActionsCommands(new CommandWrapper(constants.deleteBankAccounts(), new Command() {
            @Override
			public void execute() {
				deleteBankAccounts(getView().getSelectedIds());
			}

        }));

    }

    private void deleteBankAccounts(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) {
            return;
        }
        DeleteBankAccountsRequest request = new DeleteBankAccountsRequest();
        request.setEntityIdList(ids);
        deleteBankAccountsService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
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
        BankAccountListRequest request = new BankAccountListRequest();
        setPagination(request);

        super.refreshFromServer();
        bankAccountListService.execute(request, new ServiceCallbackImpl<BankAccountListResponse>() {
            @Override
            public void onSuccess(BankAccountListResponse response) {
//                ((BankAccountsTable) getView().getContentPanel().getContentWidget()).setBankAccounts(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
