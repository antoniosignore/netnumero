package com.numhero.client.mvp.feedback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class FeedbackPanel_MoneyinPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.feedback.FeedbackPanel>, com.numhero.client.mvp.feedback.FeedbackPanel.MoneyinPanelUiBinder {
  static FeedbackPanelMoneyinPanelUiBinderImplGenMessages messages = (FeedbackPanelMoneyinPanelUiBinderImplGenMessages) GWT.create(FeedbackPanelMoneyinPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <br> <table cellpadding='0' cellspacing='0' class='formContainer'> <tr> <td colspan='2' style='padding: 10px 10px 10px 10px' width='100%'> <span id='{1}'></span> </td> </tr> </table> <span id='{2}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.feedback.FeedbackPanel owner) {

    com.numhero.client.mvp.feedback.FeedbackPanel_MoneyinPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.feedback.FeedbackPanel_MoneyinPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.feedback.FeedbackPanel_MoneyinPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.feedback.FeedbackPanel_MoneyinPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label message = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taNotes = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSaveDraft = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0, domId1, domId2).asString());

    message.setWidth("400px");
    taNotes.setHeight("300px");
    taNotes.setWidth("400px");
    btSaveDraft.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    btSaveDraft.setTabIndex(13);
    btSaveDraft.setHref("javascript:;");
    f_HorizontalPanel2.add(btSaveDraft);
    btCancel.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());
    btCancel.setTabIndex(14);
    f_HorizontalPanel2.add(btCancel);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(message, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(taNotes, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel2, domId2Element);


    owner.btCancel = btCancel;
    owner.btSaveDraft = btSaveDraft;
    owner.message = message;
    owner.taNotes = taNotes;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
