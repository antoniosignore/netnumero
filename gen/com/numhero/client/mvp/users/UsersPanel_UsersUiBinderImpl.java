package com.numhero.client.mvp.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UsersPanel_UsersUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.VerticalPanel, com.numhero.client.mvp.users.UsersPanel>, com.numhero.client.mvp.users.UsersPanel.UsersUiBinder {
  static UsersPanelUsersUiBinderImplGenMessages messages = (UsersPanelUsersUiBinderImplGenMessages) GWT.create(UsersPanelUsersUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.VerticalPanel createAndBindUi(final com.numhero.client.mvp.users.UsersPanel owner) {

    com.numhero.client.mvp.users.UsersPanel_UsersUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.users.UsersPanel_UsersUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.users.UsersPanel_UsersUiBinderImpl_GenBundle.class);
    com.google.gwt.user.client.ui.HTML hdTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Anchor f_Anchor3 = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.mvp.users.UsersTable usersTable = (com.numhero.client.mvp.users.UsersTable) GWT.create(com.numhero.client.mvp.users.UsersTable.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HorizontalPanel2.add(hdTitle);
    f_HorizontalPanel2.setCellVerticalAlignment(hdTitle, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel2.setCellWidth(hdTitle, "50%");
    f_Anchor3.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    f_Anchor3.setStyleName("inh-button");
    f_Anchor3.setHref("#user");
    f_HorizontalPanel2.add(f_Anchor3);
    f_HorizontalPanel2.setCellHorizontalAlignment(f_Anchor3, com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    f_HorizontalPanel2.setCellVerticalAlignment(f_Anchor3, com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
    f_HorizontalPanel2.setCellWidth(f_Anchor3, "50%");
    f_HorizontalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel2);
    usersTable.setStyleName("productsDetails inh-standard");
    f_VerticalPanel1.add(usersTable);
    f_VerticalPanel1.setWidth("100%");



    owner.hdTitle = hdTitle;
    owner.usersTable = usersTable;

    return f_VerticalPanel1;
  }
}
