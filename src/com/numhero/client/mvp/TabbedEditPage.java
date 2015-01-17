package com.numhero.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.Application;
import com.numhero.client.mvp.decorator.TabbedPageDecorator;
import com.numhero.shared.pojoc.EntityPojo;

public abstract class TabbedEditPage extends AbstractTabbedPage implements EditPageView {

    protected AbstractEditEntityPanel entityPanel;

    public TabbedEditPage(AbstractEditEntityPanel entityPanel, TabbedPageDecorator decorator) {
        super(entityPanel, decorator);
        this.entityPanel = entityPanel;

    }


    @Override
    public void addCanceltHref(String href) {
        entityPanel.getBtCancel().setHref(href);
    }

    @Override
    public void addSaveClickHandler(ClickHandler clickHandler) {
        entityPanel.getBtSave().addClickHandler(clickHandler);
    }

    @Override
    public EntityPojo getPojo() {
        return entityPanel.getPojo();
    }

    @Override
    public boolean saveValuesFromUi() {
        return entityPanel.saveValuesFromUi();
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        entityPanel.setPojo(pojo);
    }

    @Override
    public void showToaster(String message) {
        Application.toasterMessage(message);

    }

}
