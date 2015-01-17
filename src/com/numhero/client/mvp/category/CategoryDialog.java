package com.numhero.client.mvp.category;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class CategoryDialog extends DialogBox {

    private Category category;

    public CategoryDialog(final Service<SaveCategoryRequest, SaveSingleEntityResponse> categoriesaveService,
                          final CategoryPanel categoryPanel,
                          String categoryName) {
        setText(Application.getConstants().createNewCategory());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        category = new Category();
        category.fName.setValue(categoryName);

        categoryPanel.setPojo(category);

        categoryPanel.btSave.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (categoryPanel.saveValuesFromUi()) {
                    SaveCategoryRequest request = new SaveCategoryRequest();
					request.setEntity(category);
					Application.showGlasspanelLoading();
                    categoriesaveService.execute(request, new ServiceCallbackImpl<SaveSingleEntityResponse>() {
                        @Override
                        public void onSuccess(SaveSingleEntityResponse response) {
                            Application.toasterMessage(Application.getConstants().categorySaved());
                            category.setId(response.getEntityId());
                            CategoryDialog.this.hide();
                        }
                    });
                }
            }
        });
        categoryPanel.btCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CategoryDialog.this.hide();
            }
        });
        setWidget(categoryPanel);
    }

    public Category getCategory() {
        return category;
    }
}
