package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoneyinReportsSubmenu_MoneyinReportsSubmenuUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.submenu.MoneyinReportsSubmenu>, com.numhero.client.widget.submenu.MoneyinReportsSubmenu.MoneyinReportsSubmenuUiBinder {
  static MoneyinReportsSubmenuMoneyinReportsSubmenuUiBinderImplGenMessages messages = (MoneyinReportsSubmenuMoneyinReportsSubmenuUiBinderImplGenMessages) GWT.create(MoneyinReportsSubmenuMoneyinReportsSubmenuUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#receivables'> {0} </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#deposits'> {1} </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#sales-tax'> {2} </a> </dt> <dt class='inh-menu-end'> <a class='inh-menu' href='#sales-vat'> {3} </a> </dt> </dl>")
    SafeHtml html1(SafeHtml arg0, SafeHtml arg1, SafeHtml arg2, SafeHtml arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.submenu.MoneyinReportsSubmenu owner) {

    com.numhero.client.widget.submenu.MoneyinReportsSubmenu_MoneyinReportsSubmenuUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.submenu.MoneyinReportsSubmenu_MoneyinReportsSubmenuUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.submenu.MoneyinReportsSubmenu_MoneyinReportsSubmenuUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.submenu.MoneyinReportsSubmenu_MoneyinReportsSubmenuUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), SafeHtmlUtils.fromSafeConstant(messages.message2()), SafeHtmlUtils.fromSafeConstant(messages.message3()), SafeHtmlUtils.fromSafeConstant(messages.message4())).asString());




    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
