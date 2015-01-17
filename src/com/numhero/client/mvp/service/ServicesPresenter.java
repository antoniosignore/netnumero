package com.numhero.client.mvp.service;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.product.DeleteProductsRequest;
import com.numhero.client.model.datacargo.product.ProductListResponse;
import com.numhero.client.model.datacargo.product.ProductServicesListRequest;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GenericMoneyinTabGridPage;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.ProductTypeEnum;

import java.util.List;

@Singleton
public class ServicesPresenter extends GridPresenter {

    private Service<ProductServicesListRequest, ProductListResponse> listService;
    private Service<DeleteProductsRequest, BulkActionResponse> deleteProductsService;

    @Inject
    public ServicesPresenter(
            PlaceManager eventManager,
            Service<ProductServicesListRequest, ProductListResponse> listService,
            Service<DeleteProductsRequest, BulkActionResponse> deleteProductsService,
            final ServiceConstants constants) {
        super(eventManager, new GenericMoneyinTabGridPage(new ServicesTable()));

        this.listService = listService;
        this.deleteProductsService = deleteProductsService;

        getView().setDetailTitlePanel(constants.manageServices());

        CommandWrapper deleteServicesCommand = new CommandWrapper(constants.deleteServices(), new Command() {
            public void execute() {
                deleteServices(getView().getSelectedIds());
            }

        });

        getView().addActionsCommands(deleteServicesCommand);

    }

    private void deleteServices(List<Long> ids) {

        if (ClientUtils.warnNotEmptyIds(ids, getView())) {
            return;
        }

        DeleteProductsRequest request = new DeleteProductsRequest();
        request.setEntityIdList(ids);
        deleteProductsService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
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
        ProductServicesListRequest request = new ProductServicesListRequest(ProductTypeEnum.service);

        setPagination(request);
        super.refreshFromServer();

        listService.execute(request, new ServiceCallbackImpl<ProductListResponse>() {
            @Override
            public void onSuccess(ProductListResponse response) {
//                ((ServicesTable) getView().getContentPanel().getContentWidget()).setServices(response.getEntityList());
//                getTable().manageNavigationBar(response.getEntityList().isEmpty(), response.isFirstPage(), response.isLastPage());
                getView().putEntitiesInGrid(response);

            }
        });
    }
}
