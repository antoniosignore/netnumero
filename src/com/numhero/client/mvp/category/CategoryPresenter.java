package com.numhero.client.mvp.category;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.model.datacargo.category.GetCategoryRequest;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.mvp.EditPresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class CategoryPresenter extends EditPresenter {
    private Service<GetCategoryRequest, GetSingleEntityResponse<Category>> categoryGetService;
    private Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService;
    private CategoryConstants constants;
    private ServiceCallbackImpl<GetSingleEntityResponse<Category>> getServiceCallback;
    private ServiceCallbackImpl<SaveSingleEntityResponse> saveServiceCallback;
    private ClickHandler saveHandler;

    public CategoryPresenter(PlaceManager eventManager,
                             EditPageView view,
                             Service<GetCategoryRequest, GetSingleEntityResponse<Category>> categoryGetService,
                             Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService,
                             CategoryConstants constants) {
        super(eventManager, view);
        this.categoryGetService = categoryGetService;
        this.categorySaveService = categorySaveService;
        this.constants = constants;
        createGetServiceCallback();
        createSaveServiceCallback();
    }

    @Override
    public EditPageView getView() {
        return (EditPageView) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getView().setPojo(new Category());
            getView().setDetailTitlePanel(constants.createNewCategory());
        } else {
            getView().setDetailTitlePanel(constants.editCategory());
            GetCategoryRequest request = new GetCategoryRequest();
            request.setEntityId(getUrl().getId());

            categoryGetService.execute(request, getServiceCallback);
        }
    }

    @Override
    protected void onBind() {
        super.onBind();
        getView().addSaveClickHandler(saveCategoryHandler());
        getView().addCanceltHref("#categories");
    }

    @Override
    protected void onUnbind() {
        super.onUnbind();
    }

    @Override
    protected String getReturnUrl() {
        return "categories";
    }

    private void createGetServiceCallback() {
        this.getServiceCallback = new ServiceCallbackImpl<GetSingleEntityResponse<Category>>() {
            @Override
            public void onSuccess(GetSingleEntityResponse<Category> response) {
                getView().setPojo(response.getEntity());
            }
        };
    }

    private void createSaveServiceCallback() {
        this.saveServiceCallback = new ServiceCallbackImpl<SaveSingleEntityResponse>() {
            @Override
            public void onSuccess(SaveSingleEntityResponse response) {
                getView().showToaster(constants.categorySaved());
                redirect();
            }
        };
    }

    private ClickHandler saveCategoryHandler() {
        if (saveHandler == null) {
            saveHandler = createBtSaveHandler();
        }
        return saveHandler;
    }

    private ClickHandler createBtSaveHandler() {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (getView().saveValuesFromUi()) {
                    SaveCategoryRequest request = new SaveCategoryRequest();
                    Category category = (Category) getView().getPojo();
                    request.setEntity(category);
                    getView().showGlassPanel();
                    categorySaveService.execute(request, saveServiceCallback);
                }
            }
        };
    }
}
