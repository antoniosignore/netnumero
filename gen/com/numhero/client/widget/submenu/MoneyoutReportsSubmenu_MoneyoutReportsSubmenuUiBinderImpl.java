package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoneyoutReportsSubmenu_MoneyoutReportsSubmenuUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.submenu.MoneyoutReportsSubmenu>, com.numhero.client.widget.submenu.MoneyoutReportsSubmenu.MoneyoutReportsSubmenuUiBinder {
  static MoneyoutReportsSubmenuMoneyoutReportsSubmenuUiBinderImplGenMessages messages = (MoneyoutReportsSubmenuMoneyoutReportsSubmenuUiBinderImplGenMessages) GWT.create(MoneyoutReportsSubmenuMoneyoutReportsSubmenuUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#staff-receipts'> {0} </a> </dt> </dl>")
    SafeHtml html1(SafeHtml arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.submenu.MoneyoutReportsSubmenu owner) {

    com.numhero.client.widget.submenu.MoneyoutReportsSubmenu_MoneyoutReportsSubmenuUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.submenu.MoneyoutReportsSubmenu_MoneyoutReportsSubmenuUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.submenu.MoneyoutReportsSubmenu_MoneyoutReportsSubmenuUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.submenu.MoneyoutReportsSubmenu_MoneyoutReportsSubmenuUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());




    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
