package com.numhero.client.widget.submenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TaxesSubmenu_TaxesSubmenuUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.submenu.TaxesSubmenu>, com.numhero.client.widget.submenu.TaxesSubmenu.TaxesSubmenuUiBinder {
  static TaxesSubmenuTaxesSubmenuUiBinderImplGenMessages messages = (TaxesSubmenuTaxesSubmenuUiBinderImplGenMessages) GWT.create(TaxesSubmenuTaxesSubmenuUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#taxinfo'> {0} </a> </dt> <dt class='inh-menu-end'> <a class='inh-menu' href='#taxinfos'> {1} </a> </dt>       </dl>")
    SafeHtml html1(SafeHtml arg0, SafeHtml arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.submenu.TaxesSubmenu owner) {

    com.numhero.client.widget.submenu.TaxesSubmenu_TaxesSubmenuUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.submenu.TaxesSubmenu_TaxesSubmenuUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.submenu.TaxesSubmenu_TaxesSubmenuUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.submenu.TaxesSubmenu_TaxesSubmenuUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());




    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
