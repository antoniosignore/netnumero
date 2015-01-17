package com.numhero.client.mvp.accounting;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class LegsPanel_LegsUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.accounting.LegsPanel>, com.numhero.client.mvp.accounting.LegsPanel.LegsUiBinder {
  static LegsPanelLegsUiBinderImplGenMessages messages = (LegsPanelLegsUiBinderImplGenMessages) GWT.create(LegsPanelLegsUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='2'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> </tr> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label' width='120px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td colspan='2'> <span id='{5}'></span> </td> </tr> <tr> <span id='{6}'></span> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.accounting.LegsPanel owner) {

    com.numhero.client.mvp.accounting.LegsPanel_LegsUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.accounting.LegsPanel_LegsUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.accounting.LegsPanel_LegsUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label tbBusinessTransactionEnum = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor tbReferenceDoc = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.accounting.LegsTable legsTable = (com.numhero.client.mvp.accounting.LegsTable) GWT.create(com.numhero.client.mvp.accounting.LegsTable.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, domId2, domId3, domId4, domId5, domId6).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0).asString());

    f_Label3.setText("" + messages.message2() + "");
    tbBusinessTransactionEnum.setWidth("100%");
    f_Label4.setText("" + messages.message3() + "");
    tbReferenceDoc.setWidth("100%");
    btCancel.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message4())).asString());
    btCancel.setTabIndex(1);
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId1Element);
    f_HTMLPanel2.addAndReplaceElement(tbBusinessTransactionEnum, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(tbReferenceDoc, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(legsTable, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(btCancel, domId6Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);


    owner.btCancel = btCancel;
    owner.legsTable = legsTable;
    owner.tbBusinessTransactionEnum = tbBusinessTransactionEnum;
    owner.tbReferenceDoc = tbReferenceDoc;

    return f_HTMLPanel1;
  }
}
