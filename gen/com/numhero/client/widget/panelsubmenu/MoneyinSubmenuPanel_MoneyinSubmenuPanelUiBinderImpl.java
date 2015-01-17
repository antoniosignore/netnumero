package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoneyinSubmenuPanel_MoneyinSubmenuPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel>, com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel.MoneyinSubmenuPanelUiBinder {
  static MoneyinSubmenuPanelMoneyinSubmenuPanelUiBinderImplGenMessages messages = (MoneyinSubmenuPanelMoneyinSubmenuPanelUiBinderImplGenMessages) GWT.create(MoneyinSubmenuPanelMoneyinSubmenuPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<ul class='first-level'> <li class='menu-title'> {0} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{1}'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> {2} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{3}'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> {4} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{5}'></span> </div> </div> </li> </ul> </li> </ul>")
    SafeHtml html1(SafeHtml arg0, String arg1, SafeHtml arg2, String arg3, SafeHtml arg4, String arg5);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel owner) {

    com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel_MoneyinSubmenuPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel_MoneyinSubmenuPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel_MoneyinSubmenuPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.panelsubmenu.MoneyinSubmenuPanel_MoneyinSubmenuPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.InvoicesSubmenu f_InvoicesSubmenu2 = (com.numhero.client.widget.submenu.InvoicesSubmenu) GWT.create(com.numhero.client.widget.submenu.InvoicesSubmenu.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.EstimatesSubmenu f_EstimatesSubmenu3 = (com.numhero.client.widget.submenu.EstimatesSubmenu) GWT.create(com.numhero.client.widget.submenu.EstimatesSubmenu.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ItemsSubmenu f_ItemsSubmenu4 = (com.numhero.client.widget.submenu.ItemsSubmenu) GWT.create(com.numhero.client.widget.submenu.ItemsSubmenu.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId0, SafeHtmlUtils.fromSafeConstant(messages.message2()), domId1, SafeHtmlUtils.fromSafeConstant(messages.message3()), domId2).asString());

    f_HTMLPanel1.setStyleName("panel-menu");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_InvoicesSubmenu2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_EstimatesSubmenu3, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_ItemsSubmenu4, domId2Element);


    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
