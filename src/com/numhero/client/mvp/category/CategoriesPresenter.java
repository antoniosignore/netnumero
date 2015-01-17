package com.numhero.client.mvp.category;

import com.google.gwt.user.client.Command;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.DeleteCategoriesRequest;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.mvp.GridPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionResponse;

public class CategoriesPresenter extends GridPresenter {

    private Service<CategoryListRequest, CategoryListResponse> categoryListService;
    private Service<DeleteCategoriesRequest, BulkActionResponse> deleteCategoriesService;
    private ServiceCallbackImpl<CategoryListResponse> listServiceCallback;

    public CategoriesPresenter(PlaceManager eventManager, GridPageView view,
                               Service<CategoryListRequest, CategoryListResponse> categoryListService,
                               final Service<DeleteCategoriesRequest, BulkActionResponse> deleteCategoriesService,
                               final CategoryConstants constants) {
        super(eventManager, view);

        this.categoryListService = categoryListService;
        this.deleteCategoriesService = deleteCategoriesService;

        getView().setDetailTitlePanel(constants.manageCategories());

        CommandWrapper deleteCommand = new CommandWrapper(constants.deleteCategories(), new Command() {
            public void execute() {
                deleteEntities(new DeleteCategoriesRequest(), deleteCategoriesService);
            }

        });

        getView().addActionsCommands(deleteCommand);

        listServiceCallback = new ServiceCallbackImpl<CategoryListResponse>() {
            @Override
            public void onSuccess(CategoryListResponse response) {
                getView().putEntitiesInGrid(response);

            }
        };
    }


    protected void refreshFromServer() {
        CategoryListRequest request = new CategoryListRequest();

        setPagination(request);
        super.refreshFromServer();

        categoryListService.execute(request, listServiceCallback);
    }

}
