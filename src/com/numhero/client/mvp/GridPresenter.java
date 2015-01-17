package com.numhero.client.mvp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.BulkActionRequest;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.datacargo.ListCommandRequest;

import java.util.List;

public abstract class GridPresenter extends BasePresenter {

    private static final int STANDARD_PAGE_SIZE = 10;
    public String fCurrentStartingKey = null;
    public int fCurrentPageSize = STANDARD_PAGE_SIZE;

    protected GridPresenter(PlaceManager eventManager, GridPageView view) {
        super(eventManager, view);
    }

    @Override
    public GridPageView getView() {
        return (GridPageView) super.getView();
    }

    @Override
    protected void onBind() {

        getView().prepareTable(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getLastPageFromServer();
            }
        }, new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getFirstPageFromServer();
            }
        }, new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getPreviousPageFromServer();
            }
        }, new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getNextPageFromServer();
            }
        });


    }

    @Override
    public void onShow() {
        refreshFromServer();
    }

    protected void refreshFromServer() {
        getView().showLoading();
    }


    protected void setPagination(ListCommandRequest request) {
        request.setStartingKey(fCurrentStartingKey);
        request.setMaxResults(fCurrentPageSize);
    }

    protected void getNextPageFromServer() {
        fCurrentStartingKey = getView().getLastRowKey();
        fCurrentPageSize = STANDARD_PAGE_SIZE;
        refreshFromServer();
    }

    protected void getPreviousPageFromServer() {
        fCurrentStartingKey = getView().getFirstRowKey();
        fCurrentPageSize = -STANDARD_PAGE_SIZE;
        refreshFromServer();
    }

    protected void getFirstPageFromServer() {
        fCurrentStartingKey = null;
        fCurrentPageSize = STANDARD_PAGE_SIZE;
        refreshFromServer();
    }

    protected void getLastPageFromServer() {
        fCurrentStartingKey = null;
        fCurrentPageSize = -STANDARD_PAGE_SIZE;
        refreshFromServer();
    }


    //todo mikado: fix the generics

    protected void deleteEntities(BulkActionRequest request,
                                  Service responseService) { //<? extends BulkActionRequest, BulkActionResponse>
        List<Long> ids = getView().getSelectedIds();

        if (ids.isEmpty()) {
            getView().ShowNoneSelectedError();
            return;
        }
        request.setEntityIdList(ids);
        responseService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    getView().showErrorDeleting();
                } else {
                    getView().showDeletedEntitiesToaster();
                }
                refreshFromServer();
            }
        });
    }

    protected boolean warnNotEmptyIds(List<Long> ids) {
        if (ids.isEmpty()) {
            getView().showOneRowError();
            return true;
        }
        return false;
    }

    protected void redirectToEntity(final long id, final String entityName) {
        String place = entityName + '/' + id;
        getPlaceManager().moveToPlace(place);
    }


}
