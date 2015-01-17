package com.numhero.client.widget.panelsubmenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class StaffSubmenuPanel_StaffSubmenuPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel>, com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel.StaffSubmenuPanelUiBinder {
  static StaffSubmenuPanelStaffSubmenuPanelUiBinderImplGenMessages messages = (StaffSubmenuPanelStaffSubmenuPanelUiBinderImplGenMessages) GWT.create(StaffSubmenuPanelStaffSubmenuPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<ul class='first-level'> <li class='menu-title'> {0} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{1}'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> {2} <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='{3}'></span> </div> </div> </li> </ul> </li> </ul>")
    SafeHtml html1(SafeHtml arg0, String arg1, SafeHtml arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel owner) {

    com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel_StaffSubmenuPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel_StaffSubmenuPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel_StaffSubmenuPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.panelsubmenu.StaffSubmenuPanel_StaffSubmenuPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.InternalStaffSubmenu f_InternalStaffSubmenu2 = (com.numhero.client.widget.submenu.InternalStaffSubmenu) GWT.create(com.numhero.client.widget.submenu.InternalStaffSubmenu.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ContractorsSubmenu f_ContractorsSubmenu3 = (com.numhero.client.widget.submenu.ContractorsSubmenu) GWT.create(com.numhero.client.widget.submenu.ContractorsSubmenu.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId0, SafeHtmlUtils.fromSafeConstant(messages.message2()), domId1).asString());

    f_HTMLPanel1.setStyleName("panel-menu");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_InternalStaffSubmenu2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_ContractorsSubmenu3, domId1Element);


    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
