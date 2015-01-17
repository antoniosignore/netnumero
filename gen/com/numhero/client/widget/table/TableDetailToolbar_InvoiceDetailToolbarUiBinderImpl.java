package com.numhero.client.widget.table;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TableDetailToolbar_InvoiceDetailToolbarUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.table.TableDetailToolbar>, com.numhero.client.widget.table.TableDetailToolbar.InvoiceDetailToolbarUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<img alt='Delete' border='0' src='../../i/common/16/delete2.png'>")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.table.TableDetailToolbar owner) {

    com.numhero.client.widget.table.TableDetailToolbar_InvoiceDetailToolbarUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.table.TableDetailToolbar_InvoiceDetailToolbarUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.table.TableDetailToolbar_InvoiceDetailToolbarUiBinderImpl_GenBundle.class);
    com.google.gwt.user.client.ui.Anchor btDelete = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor btMoveUp = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.Anchor btMoveDown = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    btDelete.setHTML(template.html1().asString());
    btDelete.setTabIndex(-1);
    btDelete.setHref("javascript:;");
    f_HorizontalPanel1.add(btDelete);
    f_HorizontalPanel1.setCellVerticalAlignment(btDelete, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    btMoveUp.setStyleName("move-up-button");
    btMoveUp.setTabIndex(-1);
    btMoveUp.setHref("javascript:;");
    f_VerticalPanel2.add(btMoveUp);
    f_VerticalPanel2.setCellVerticalAlignment(btMoveUp, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    btMoveDown.setStyleName("move-down-button");
    btMoveDown.setTabIndex(-1);
    btMoveDown.setHref("javascript:;");
    f_VerticalPanel2.add(btMoveDown);
    f_VerticalPanel2.setCellVerticalAlignment(btMoveDown, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_VerticalPanel2.setHeight("100%");
    f_HorizontalPanel1.add(f_VerticalPanel2);
    f_HorizontalPanel1.setStyleName("entity-detail-toolbar");



    owner.btDelete = btDelete;
    owner.btMoveDown = btMoveDown;
    owner.btMoveUp = btMoveUp;

    return f_HorizontalPanel1;
  }
}
