package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class HeaderLine_HeaderLineUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.HeaderLine>, com.numhero.client.widget.HeaderLine.HeaderLineUiBinder {
  static HeaderLineHeaderLineUiBinderImplGenMessages messages = (HeaderLineHeaderLineUiBinderImplGenMessages) GWT.create(HeaderLineHeaderLineUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<ul> <li> <a href='https://www.netnumero.com/customer/account/' id='{0}'> {1} </a> </li> <li> <a href='#businessaccount' id='{2}'> {3} </a> </li>  <li> <a href='https://www.netnumero.com/support' id='{4}' target='_blank'> {5} </a> </li> </ul>")
    SafeHtml html1(String arg0, SafeHtml arg1, String arg2, SafeHtml arg3, String arg4, SafeHtml arg5);
     
    @Template("<span class='currentDate' id='{0}'></span> | <a class='logoutButton' href='http://www.netnumero.com/customer/account/logout' id='{1}'> {2} </a>")
    SafeHtml html2(String arg0, String arg1, SafeHtml arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.HeaderLine owner) {

    com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.dom.client.AnchorElement myAccount = null;
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.AnchorElement settings = null;
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.AnchorElement help = null;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, SafeHtmlUtils.fromSafeConstant(messages.message2()), domId2, SafeHtmlUtils.fromSafeConstant(messages.message3())).asString());
    com.google.gwt.dom.client.SpanElement currentDate = null;
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.AnchorElement logout = null;
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId3, domId4, SafeHtmlUtils.fromSafeConstant(messages.message4())).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    f_HTMLPanel2.setStyleName("header-line-left");
    f_HTMLPanel2.setWidth("100%");
    f_HorizontalPanel1.add(f_HTMLPanel2);
    f_HTMLPanel3.setStyleName("header-line-right");
    f_HTMLPanel3.setWidth("100%");
    f_HorizontalPanel1.add(f_HTMLPanel3);
    f_HorizontalPanel1.setStyleName("header-line");
    f_HorizontalPanel1.setWidth("100%");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    myAccount = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    myAccount.removeAttribute("id");
    settings = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    settings.removeAttribute("id");
    help = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    help.removeAttribute("id");
    attachRecord0.detach();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    currentDate = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    currentDate.removeAttribute("id");
    logout = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    logout.removeAttribute("id");
    attachRecord1.detach();


    owner.currentDate = currentDate;
    owner.help = help;
    owner.logout = logout;
    owner.myAccount = myAccount;
    owner.settings = settings;
    owner.style = style;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HorizontalPanel1;
  }
}
