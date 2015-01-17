package com.numhero.client.mvp.document;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AbstractInvoicePanel_InvoiceUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.document.AbstractInvoicePanel>, com.numhero.client.mvp.document.AbstractInvoicePanel.InvoiceUiBinder {
  static AbstractInvoicePanelInvoiceUiBinderImplGenMessages messages = (AbstractInvoicePanelInvoiceUiBinderImplGenMessages) GWT.create(AbstractInvoicePanelInvoiceUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<div id='{0}'></div>")
    SafeHtml html1(String arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' id='{0}' width='100%'> <thead> <tr> <td colspan='4'> <span id='{1}'></span> </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{2}'></span> </td> <td class='formItem'> <span id='{3}'></span> </td> <td class='formItem' colspan='2' width='50%'></td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{4}'></span> </td> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='form-item-label' width='120px'> <span id='{6}'></span> </td> <td class='formItem'> <span id='{7}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{8}'></span> </td> <td class='formItem'> <span id='{9}'></span> </td> <td class='form-item-label' width='120px'> <span id='{10}'></span> </td> <td class='formItem'> <span id='{11}'></span> </td> </tr> <tr> <td class='formItem' colspan='4'> <span id='{12}'></span> </td> </tr> <tr> <td colspan='4' style='height:54px;'> <span id='{13}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{14}'></span> </td> <td class='formItem'> <span id='{15}'></span> </td> <td class='formItem' colspan='2' width='50%'></td> </tr> <tr> <td colspan='4'> <table cellpadding='0' cellspacing='0' width='100%'> <tr> <td class='form-item-label' style='text-align: left' width='50%'> <span id='{16}'></span> </td> <td class='form-item-label' style='text-align: left' width='50%'> <span id='{17}'></span> </td> </tr> <tr> <td style='padding: 0px 5px 5px 5px' width='50%'> <span id='{18}'></span> </td> <td style='padding: 0px 5px 5px 5px' width='50%'> <span id='{19}'></span> </td> </tr> </table> </td> </tr> </tbody> </table>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19);
     
    @Template("{0}")
    SafeHtml html4(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html5(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html6(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html7(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.document.AbstractInvoicePanel owner) {

    com.numhero.client.mvp.document.AbstractInvoicePanel_InvoiceUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.document.AbstractInvoicePanel_InvoiceUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.document.AbstractInvoicePanel_InvoiceUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("Errors");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.DivElement pdfDivElement = null;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTML PDF = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.TableElement teMain = null;
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lbDetails = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.DropDownBox sbPartner = owner.sbPartner;
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lbInvoiceID = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CurrencySelect cbCurrency = (com.numhero.client.widget.combobox.CurrencySelect) GWT.create(com.numhero.client.widget.combobox.CurrencySelect.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox dateRaised = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox dateDue = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FocusPanel invoiceDetailsPanel = owner.invoiceDetailsPanel;
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btAddInvoiceDetail = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox tbDiscount = owner.tbDiscount;
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taTermsConditions = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taNotes = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    com.google.gwt.user.client.ui.HTMLPanel editor = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15, domId16, domId17, domId18, domId19, domId20, domId21, domId22, domId23).asString());
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSendAsEmail = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btSendSnailMail = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel11 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.numhero.client.widget.NetNumeroButton btSaveDraft = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html8(domId0, domId1, domId3, domId24).asString());

    errorsPanel.setStyleName("validation-advice");
    PDF.setHTML(template.html1(domId2).asString());
    f_Label2.setText("" + messages.message1() + "");
    sbPartner.setTabIndex(1);
    f_Label3.setText("" + messages.message2() + "");
    f_Label4.setText("" + messages.message3() + "");
    cbCurrency.setTabIndex(2);
    f_Label5.setText("" + messages.message4() + "");
    dateRaised.setTabIndex(3);
    f_Label6.setText("" + messages.message5() + "");
    dateDue.setTabIndex(4);
    invoiceDetailsPanel.setTabIndex(5);
    btAddInvoiceDetail.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message6())).asString());
    btAddInvoiceDetail.setTabIndex(6);
    btAddInvoiceDetail.setHref("javascript:;");
    f_Label7.setText("" + messages.message7() + "");
    tbDiscount.setTabIndex(7);
    f_Label8.setText("" + messages.message8() + "");
    f_Label9.setText("" + messages.message9() + "");
    taTermsConditions.setTabIndex(9);
    taTermsConditions.setWidth("100%");
    taNotes.setTabIndex(10);
    taNotes.setWidth("100%");
    editor.setStyleName("form-with-shadow");
    btSendAsEmail.setHTML(template.html4(SafeHtmlUtils.fromSafeConstant(messages.message10())).asString());
    btSendAsEmail.setTabIndex(11);
    btSendAsEmail.setHref("javascript:;");
    f_HorizontalPanel10.add(btSendAsEmail);
    btSendSnailMail.setHTML(template.html5(SafeHtmlUtils.fromSafeConstant(messages.message11())).asString());
    btSendSnailMail.setTabIndex(12);
    btSendSnailMail.setHref("javascript:;");
    f_HorizontalPanel10.add(btSendSnailMail);
    f_VerticalPanel11.setWidth("50px");
    f_HorizontalPanel10.add(f_VerticalPanel11);
    btSaveDraft.setHTML(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message12())).asString());
    btSaveDraft.setTabIndex(13);
    btSaveDraft.setHref("javascript:;");
    f_HorizontalPanel10.add(btSaveDraft);
    btCancel.setHTML(template.html7(SafeHtmlUtils.fromSafeConstant(messages.message13())).asString());
    btCancel.setTabIndex(14);
    f_HorizontalPanel10.add(btCancel);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(PDF.getElement());
    pdfDivElement = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    pdfDivElement.removeAttribute("id");
    attachRecord1.detach();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(editor.getElement());
    teMain = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    teMain.removeAttribute("id");
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    com.google.gwt.user.client.Element domId10Element = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    com.google.gwt.user.client.Element domId13Element = com.google.gwt.dom.client.Document.get().getElementById(domId13).cast();
    com.google.gwt.user.client.Element domId14Element = com.google.gwt.dom.client.Document.get().getElementById(domId14).cast();
    com.google.gwt.user.client.Element domId15Element = com.google.gwt.dom.client.Document.get().getElementById(domId15).cast();
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    com.google.gwt.user.client.Element domId18Element = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    attachRecord2.detach();
    editor.addAndReplaceElement(lbDetails, domId5Element);
    editor.addAndReplaceElement(f_Label2, domId6Element);
    editor.addAndReplaceElement(sbPartner, domId7Element);
    editor.addAndReplaceElement(f_Label3, domId8Element);
    editor.addAndReplaceElement(lbInvoiceID, domId9Element);
    editor.addAndReplaceElement(f_Label4, domId10Element);
    editor.addAndReplaceElement(cbCurrency, domId11Element);
    editor.addAndReplaceElement(f_Label5, domId12Element);
    editor.addAndReplaceElement(dateRaised, domId13Element);
    editor.addAndReplaceElement(f_Label6, domId14Element);
    editor.addAndReplaceElement(dateDue, domId15Element);
    editor.addAndReplaceElement(invoiceDetailsPanel, domId16Element);
    editor.addAndReplaceElement(btAddInvoiceDetail, domId17Element);
    editor.addAndReplaceElement(f_Label7, domId18Element);
    editor.addAndReplaceElement(tbDiscount, domId19Element);
    editor.addAndReplaceElement(f_Label8, domId20Element);
    editor.addAndReplaceElement(f_Label9, domId21Element);
    editor.addAndReplaceElement(taTermsConditions, domId22Element);
    editor.addAndReplaceElement(taNotes, domId23Element);
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(PDF, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(editor, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel10, domId24Element);


    owner.PDF = PDF;
    owner.btAddInvoiceDetail = btAddInvoiceDetail;
    owner.btCancel = btCancel;
    owner.btSaveDraft = btSaveDraft;
    owner.btSendAsEmail = btSendAsEmail;
    owner.btSendSnailMail = btSendSnailMail;
    owner.cbCurrency = cbCurrency;
    owner.dateDue = dateDue;
    owner.dateRaised = dateRaised;
    owner.editor = editor;
    owner.errorsPanel = errorsPanel;
    owner.lbDetails = lbDetails;
    owner.lbInvoiceID = lbInvoiceID;
    owner.pdfDivElement = pdfDivElement;
    owner.taNotes = taNotes;
    owner.taTermsConditions = taTermsConditions;
    owner.teMain = teMain;

    return f_HTMLPanel1;
  }
}
