package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AccountsSubmenuPanel_AccountsSubmenuPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel>, com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel.AccountsSubmenuPanelUiBinder {
  static AccountsSubmenuPanelAccountsSubmenuPanelUiBinderImplGenMessages messages = (AccountsSubmenuPanelAccountsSubmenuPanelUiBinderImplGenMessages) GWT.create(AccountsSubmenuPanelAccountsSubmenuPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<ul class='first-level'> <li class='menu-title'> {0} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{1}'></span> </div> </div> </li> </ul> </li> </ul>")
    SafeHtml html1(SafeHtml arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel owner) {

    com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel_AccountsSubmenuPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel_AccountsSubmenuPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel_AccountsSubmenuPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.panelsubmenu.AccountsSubmenuPanel_AccountsSubmenuPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.GeneralAccountsSubmenu f_GeneralAccountsSubmenu2 = (com.numhero.client.widget.submenu.GeneralAccountsSubmenu) GWT.create(com.numhero.client.widget.submenu.GeneralAccountsSubmenu.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId0).asString());

    f_HTMLPanel1.setStyleName("panel-menu");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_GeneralAccountsSubmenu2, domId0Element);


    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
