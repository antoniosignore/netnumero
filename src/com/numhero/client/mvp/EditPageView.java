package com.numhero.client.mvp;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.shared.pojoc.EntityPojo;

public interface EditPageView extends PageView {

    void setPojo(EntityPojo pojo);

    void addSaveClickHandler(ClickHandler clickHandler);

    void addCanceltHref(String href);

    boolean saveValuesFromUi();

    EntityPojo getPojo();

    void showToaster(String message);


}
