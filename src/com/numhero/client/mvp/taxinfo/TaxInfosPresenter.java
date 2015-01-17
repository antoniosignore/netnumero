package com.numhero.client.mvp.taxinfo;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest;
import com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

@Singleton
public class TaxInfosPresenter extends GridPresenter {

    private Service<TaxInfoListRequest, TaxInfoListResponse> taxinfoListService;
    private Service<DeleteTaxInfosRequest, BulkActionResponse> deleteTaxInfosService;

    @Inject
    public TaxInfosPresenter(PlaceManager eventManager,
                             Service<TaxInfoListRequest, TaxInfoListResponse> taxinfoListService,
                             Service<DeleteTaxInfosRequest, BulkActionResponse> deleteTaxInfosService,
                             final TaxInfoConstants constants) {
        super(eventManager, new GenericMoneyinTabGridPage(new TaxInfosTable()));

        this.taxinfoListService = taxinfoListService;
        this.deleteTaxInfosService = deleteTaxInfosService;

        getView().setDetailTitlePanel(constants.manageTaxInfos());



        CommandWrapper deleteTaxInfoCommand = new CommandWrapper(constants.deleteTaxInfos(),new Command() {
            public void execute() {
                deleteTaxInfos(getView().getSelectedIds());
            }

        });
        getView().addActionsCommands(deleteTaxInfoCommand);

    }

    private void deleteTaxInfos(List<Long> ids) {
        if (ClientUtils.warnNotEmptyIds(ids, getView())) return;

        DeleteTaxInfosRequest request = new DeleteTaxInfosRequest();
        request.setEntityIdList(ids);
        deleteTaxInfosService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
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
        TaxInfoListRequest request = new TaxInfoListRequest();

        setPagination(request);
        super.refreshFromServer();

        taxinfoListService.execute(request, new ServiceCallbackImpl<TaxInfoListResponse>() {
            @Override
            public void onSuccess(TaxInfoListResponse response) {
//                ((TaxInfosTable) getView().getContentPanel().getContentWidget()).setTaxInfos(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
