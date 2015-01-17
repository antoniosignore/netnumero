package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class Footer_FooterUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.Footer>, com.numhero.client.widget.Footer.FooterUiBinder {
  static FooterFooterUiBinderImplGenMessages messages = (FooterFooterUiBinderImplGenMessages) GWT.create(FooterFooterUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("Report a Bug")
    SafeHtml html1();
     
    @Template("Contact Us")
    SafeHtml html2();
     
    @Template("<div id='footer-content'> <div class='link-bar'> <ul> <li class='bar'> <span id='{0}'></span> </li> <li class='bar'> <a class='inh-standard' href='http://www.netnumero.com/terms/'> {1} </a> </li> <li class='bar'> <span id='{2}'></span> </li>      </ul> </div> <div class='info'> <strong class='logo'> <a href='/index.html'></a> </strong> <p> {3} <a class='inh-standard' href='http://www.netnumero.com'> {4} </a> {5} </p> </div> </div>")
    SafeHtml html3(String arg0, SafeHtml arg1, String arg2, SafeHtml arg3, SafeHtml arg4, SafeHtml arg5);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.Footer owner) {

    com.numhero.client.widget.Footer_FooterUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.Footer_FooterUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.Footer_FooterUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.Footer_FooterUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor reportBug = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor contactUs = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0, SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, SafeHtmlUtils.fromSafeConstant(messages.message2()), SafeHtmlUtils.fromSafeConstant(messages.message3()), SafeHtmlUtils.fromSafeConstant(messages.message4())).asString());

    reportBug.setHTML(template.html1().asString());
    reportBug.setStyleName("inh-standard");
    reportBug.setHref("javascript:;");
    contactUs.setHTML(template.html2().asString());
    contactUs.setStyleName("inh-standard");
    contactUs.setHref("javascript:;");
    f_HTMLPanel1.setStyleName("footer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(reportBug, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(contactUs, domId1Element);


    owner.contactUs = contactUs;
    owner.reportBug = reportBug;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
