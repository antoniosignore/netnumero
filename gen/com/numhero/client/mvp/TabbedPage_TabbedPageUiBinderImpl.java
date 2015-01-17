package com.numhero.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TabbedPage_TabbedPageUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.TabbedPage>, com.numhero.client.mvp.TabbedPage.TabbedPageUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html1(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.TabbedPage owner) {

    com.numhero.client.mvp.TabbedPage_TabbedPageUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.TabbedPage_TabbedPageUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.TabbedPage_TabbedPageUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.TabbedPage_TabbedPageUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.HeaderPanel headerPanel = (com.numhero.client.widget.HeaderPanel) GWT.create(com.numhero.client.widget.HeaderPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.AbsolutePanel contentPanel = (com.google.gwt.user.client.ui.AbsolutePanel) GWT.create(com.google.gwt.user.client.ui.AbsolutePanel.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.Footer footerPanel = (com.numhero.client.widget.Footer) GWT.create(com.numhero.client.widget.Footer.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0, domId1, domId2).asString());

    contentPanel.setStyleName("mainContentPanel");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(headerPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(contentPanel, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(footerPanel, domId2Element);


    owner.contentPanel = contentPanel;
    owner.footerPanel = footerPanel;
    owner.headerPanel = headerPanel;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
