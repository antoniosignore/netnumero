package com.numhero.client.mvp.category;

import com.google.gwt.event.dom.client.ClickEvent;
import com.numhero.client.model.datacargo.category.GetCategoryRequest;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.mvp.EditPageView;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.place.RestUrl;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallback;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.GetSingleEntityResponse;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.testHelpers.MockerForViewEdit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
public class CategoryPresenterTest {
    public static final String SAVED = "saved";
    private CategoryPresenter presenter;

    private PlaceManager placeManager = Mockito.mock(PlaceManager.class);
    private EditPageView view;


    private Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService;
    private Service<GetCategoryRequest, GetSingleEntityResponse<Category>> categoryGetService;
    private Category category;
    private CategoryConstants constants = Mockito.mock(CategoryConstants.class);
    private static final String EDIT = "editCategory";
    private MockerForViewEdit<Category> mocker;
    private ServiceCallback<SaveSingleEntityResponse> serviceSaveCallback;

    @Before
    public void setUp() throws Exception {
        category = PojoTestUtils.createCategory();

        mocker = new MockerForViewEdit<Category>();



        categoryGetService = mocker.mockGetEntityService(category);
        categorySaveService = mocker.mockSaveEntityService(category);
        view = mocker.mockEditPageView(category);

        when(constants.categorySaved()).thenReturn(SAVED);
        when(constants.editCategory()).thenReturn(EDIT);


        presenter = new CategoryPresenter(placeManager, view, categoryGetService, categorySaveService, constants);
    }


    @After
    public void tearDown() throws Exception {
        Mockito.verifyNoMoreInteractions(view);
        Mockito.verifyNoMoreInteractions(categoryGetService);
        Mockito.verifyNoMoreInteractions(categorySaveService);
        Mockito.verifyNoMoreInteractions(placeManager);
    }

    @Test
    public void testGetThePojoAndPutInTheView() throws Exception {
        presenter.doActivation(createUrl());

        verifyViewInitializationCalls();

        Mockito.verify(categoryGetService).execute(simpleGetRequest(), mocker.getServiceGetCallback());
        Mockito.verify(view).setPojo(category);
    }

    @Test
    public void testSaveThePojoFromTheView() throws Exception {
        presenter.doActivation(createUrl());

        verifyViewInitializationCalls();

        Mockito.verify(categoryGetService).execute(simpleGetRequest(), mocker.getServiceGetCallback());
        Mockito.verify(view).setPojo(category);

        mocker.getSaveHandler().onClick(clickEvent());

        Mockito.verify(view).saveValuesFromUi();
        Mockito.verify(view).getPojo();
        Mockito.verify(view).showGlassPanel();
        Mockito.verify(categorySaveService).execute(simpleSaveRequest(), mocker.getServiceSaveCallback());

        Mockito.verify(view).showToaster(SAVED);
        Mockito.verify(placeManager).moveToPlace("categories");

    }

    private ClickEvent clickEvent() {
        return new ClickEvent() {
        };
    }

    private RestUrl createUrl() {
        return new RestUrl("category/123");
    }

    private void verifyViewInitializationCalls() {
        Mockito.verify(view).addSaveClickHandler(mocker.getSaveHandler());
        Mockito.verify(view).addCanceltHref("#categories");
        Mockito.verify(view).setDetailTitlePanel(EDIT);
        Mockito.verify(view).replaceInWrapperDiv();
    }

    private GetCategoryRequest simpleGetRequest() {
        GetCategoryRequest request = new GetCategoryRequest();
        request.setEntityId(123L);
        return request;
    }

    private SaveCategoryRequest simpleSaveRequest() {
        SaveCategoryRequest request = new SaveCategoryRequest();
        request.setEntity(category);
        return request;
    }

}
