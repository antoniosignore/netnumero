package com.numhero.client.mvp.currency;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class CurrencyConvertPanel_CurrencyUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.currency.CurrencyConvertPanel>, com.numhero.client.mvp.currency.CurrencyConvertPanel.CurrencyUiBinder {
  static CurrencyConvertPanelCurrencyUiBinderImplGenMessages messages = (CurrencyConvertPanelCurrencyUiBinderImplGenMessages) GWT.create(CurrencyConvertPanelCurrencyUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.currency.CurrencyConvertPanel owner) {

    com.numhero.client.mvp.currency.CurrencyConvertPanel_CurrencyUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.currency.CurrencyConvertPanel_CurrencyUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.currency.CurrencyConvertPanel_CurrencyUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.currency.CurrencyConvertTable cct = (com.numhero.client.mvp.currency.CurrencyConvertTable) GWT.create(com.numhero.client.mvp.currency.CurrencyConvertTable.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btClose = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0, domId1).asString());

    btClose.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    f_HorizontalPanel2.add(btClose);
    f_HTMLPanel1.setStyleName("form-with-shadow");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(cct, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel2, domId1Element);


    owner.btClose = btClose;
    owner.cct = cct;

    return f_HTMLPanel1;
  }
}
