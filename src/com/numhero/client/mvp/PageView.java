package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Widget;

public interface PageView  extends BaseView {

    PageContentPanel getContentPanel();//TODO: !!! mikado remove it

    void setDetailTitlePanel(String detailTitle);

    void setSubmenu(Widget submenu);


}
