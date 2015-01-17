package com.numhero.client.mvp.category;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.DeleteCategoriesRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.CommandWrapper;
import com.numhero.client.mvp.GridPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.RestUrl;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.testHelpers.MockerForViewGrid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;

public class CategoriesPresenterTest {
    public static final String TITLE = "title";
    public static final String CMD_DELETE = "delete";
    private CategoriesPresenter presenter;
    private Service<DeleteCategoriesRequest, BulkActionResponse> deleteService;
    private PlaceManager eventMgr = Mockito.mock(PlaceManager.class);
    private Service<CategoryListRequest, CategoryListResponse> listService;
    private GridPageView view = Mockito.mock(GridPageView.class);
    private CategoryConstants constants = Mockito.mock(CategoryConstants.class);
    private MockerForViewGrid mockerForViewGrid = new MockerForViewGrid();

    @Before
    public void setUp() throws Exception {

        Mockito.when(constants.manageCategories()).thenReturn(TITLE);
        Mockito.when(constants.deleteCategories()).thenReturn(CMD_DELETE);

        view = mockerForViewGrid.mockView();
        listService = mockerForViewGrid.mockListService(createListResponse());

        deleteService = mockerForViewGrid.mockDeleteService();

        presenter = new CategoriesPresenter(eventMgr, view, listService, deleteService, constants);

    }

    public CategoryListResponse createListResponse() {
        final CategoryListResponse response = new CategoryListResponse();
        List<Category> list = new ArrayList<Category>();
        list.add(PojoTestUtils.createCategory());
        list.add(PojoTestUtils.createCategoryTaxi());
        response.setEntityList(list);

        return response;
    }


    @After
    public void tearDown() throws Exception {

        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(deleteService);
        Mockito.verifyNoMoreInteractions(listService);
        Mockito.verifyNoMoreInteractions(eventMgr);
        Mockito.verifyNoMoreInteractions(constants);
    }

    private void verifyViewInit() {
        Mockito.verify(view).prepareTable(any(ClickHandler.class), any(ClickHandler.class), any(ClickHandler.class), any(ClickHandler.class));
        Mockito.verify(view).setDetailTitlePanel(TITLE);

        Mockito.verify(view).addActionsCommands(any(CommandWrapper.class));
        Mockito.verify(view).replaceInWrapperDiv();
        Mockito.verify(view).showLoading();
    }

    private void verifyConstantsUse() {
        Mockito.verify(constants).manageCategories();
        Mockito.verify(constants).deleteCategories();
    }


    private CategoryListRequest simpleRequest() {
        CategoryListRequest request = new CategoryListRequest();
        request.setMaxResults(10);
        request.setStartingKey(null);
        return request;
    }


    private RestUrl getUrl() {
        return new RestUrl("entities");
    }



    private void verifyViewFirstLoad() {
        CategoryListRequest request = simpleRequest();
        Mockito.verify(listService).execute(Mockito.eq(request), any(ServiceCallback.class));

        Mockito.verify(view).putEntitiesInGrid(createListResponse());
    }

    @Test
    public void testInitializeViewAndAskListOnActivation() throws Exception {

        presenter.doActivation(getUrl());

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();

    }


    @Test
    public void testDeleteItemFromList() throws Exception {

        presenter.doActivation(getUrl());

        verifyViewInit();
        verifyConstantsUse();

        verifyViewFirstLoad();


        mockerForViewGrid.getCommand(CMD_DELETE).execute();
        Mockito.verify(view).getSelectedIds();

        Mockito.verify(deleteService).execute(any(DeleteCategoriesRequest.class), any(ServiceCallback.class));
    }


}
