package com.numhero.client.mvp.category;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class CategorySelect extends DropDownBox<CategoryListRequest, CategoryListResponse> {
    private Service<SaveCategoryRequest, SaveSingleEntityResponse> saveService;
    private Category category;
    private CategoryPanel panel;

    public CategorySelect(DropDownBoxHandler handler,
                          Service<CategoryListRequest, CategoryListResponse> getListService,
                          Service<SaveCategoryRequest, SaveSingleEntityResponse> saveService,
                          CategoryPanel panel) {
        super(getListService, new CategoryListRequest());
        setHandler(handler);
        this.saveService = saveService;

        this.panel = panel;
        initPojo();
    }

    public void setCategory(Long CategoryId, String name) {
        category.setId(CategoryId);
        category.fName.setValue(name);
        suggestBox.setValue(name, false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof Category) {
            this.category = (Category) pojo;
        }
    }

    @Override
    public Category getPojo() {
        return category;
    }

    @Override
    protected void initPojo() {
        this.category = new Category();
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.addKey)) {
            showAddNewDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<CategoryListRequest, CategoryListResponse> so) {
        so.addAddNewItem();
        so.addMoreItem();
    }

    private void showAddNewDialog() {
        final CategoryDialog dlg = new CategoryDialog(saveService, panel, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getCategory() != null && dlg.getCategory().getId() != null) {
                    suggestBox.setValue(dlg.getCategory().getReplacementString());
                    handler.itemSelected(dlg.getCategory());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchCategoryDialog dlg = new SearchCategoryDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
