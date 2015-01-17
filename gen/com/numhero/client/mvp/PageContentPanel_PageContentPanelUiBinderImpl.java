package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PageContentPanel_PageContentPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.PageContentPanel>, com.numhero.client.mvp.PageContentPanel.PageContentPanelUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.PageContentPanel owner) {

    com.numhero.client.mvp.PageContentPanel_PageContentPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.PageContentPanel_PageContentPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.PageContentPanel_PageContentPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.PageContentPanel_PageContentPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.numhero.client.widget.MainTitlePanel titlePanel = (com.numhero.client.widget.MainTitlePanel) GWT.create(com.numhero.client.widget.MainTitlePanel.class);
    com.numhero.client.widget.DetailTitlePanel detailTitlePanel = (com.numhero.client.widget.DetailTitlePanel) GWT.create(com.numhero.client.widget.DetailTitlePanel.class);
    com.google.gwt.user.client.ui.VerticalPanel tableContainer = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_VerticalPanel1.add(titlePanel);
    f_VerticalPanel1.add(detailTitlePanel);
    tableContainer.setWidth("100%");
    f_VerticalPanel1.add(tableContainer);
    f_VerticalPanel1.setWidth("100%");



    owner.detailTitlePanel = detailTitlePanel;
    owner.tableContainer = tableContainer;
    owner.titlePanel = titlePanel;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
