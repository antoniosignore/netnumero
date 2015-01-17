package com.numhero.client.mvp.document;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ExpensePanel_InvoiceUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.document.ExpensePanel>, com.numhero.client.mvp.document.ExpensePanel.InvoiceUiBinder {
  static ExpensePanelInvoiceUiBinderImplGenMessages messages = (ExpensePanelInvoiceUiBinderImplGenMessages) GWT.create(ExpensePanelInvoiceUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' id='{0}' width='100%'> <thead> <tr> <td colspan='4'> <span id='{1}'></span> </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{2}'></span> </td> <td class='formItem'> <span id='{3}'></span> </td> <td class='form-item-label' width='120px'> <span id='{4}'></span> </td> <td class='formItem'> <span id='{5}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{6}'></span> </td> <td class='formItem'> <span id='{7}'></span> </td> <td class='form-item-label'> <span id='{8}'></span> </td> <td class='formItem'> <span id='{9}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{10}'></span> </td> <td class='formItem'> <span id='{11}'></span> </td> <td class='form-item-label'> <span id='{12}'></span> </td> <td class='formItem'> <span id='{13}'></span> </td> </tr> <tr> <td class='formItem' colspan='4'> <span id='{14}'></span> </td> </tr> <tr> <td colspan='4' style='height:54px;'> <span id='{15}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{16}'></span> </td> <td class='formItem' colspan='3'> <span id='{17}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html4(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.document.ExpensePanel owner) {

    com.numhero.client.mvp.document.ExpensePanel_InvoiceUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.document.ExpensePanel_InvoiceUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.document.ExpensePanel_InvoiceUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("Errors");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.TableElement teMain = null;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.DropDownBox sbPartner = owner.sbPartner;
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.category.CategorySelect sbCategory = owner.sbCategory;
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbInvoiceID = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CurrencySelect cbCurrency = (com.numhero.client.widget.combobox.CurrencySelect) GWT.create(com.numhero.client.widget.combobox.CurrencySelect.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox dateRaised = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox dateDue = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FocusPanel invoiceDetailsPanel = owner.invoiceDetailsPanel;
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btAddInvoiceDetail = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taNotes = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15, domId16, domId17, domId18, domId19).asString());
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel11 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId0, domId1, domId20).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message1() + "");
    f_Label4.setText("" + messages.message2() + "");
    sbPartner.setTabIndex(1);
    sbPartner.setWidth("338px");
    f_Label5.setText("" + messages.message3() + "");
    f_Label6.setText("" + messages.message4() + "");
    tbInvoiceID.setTabIndex(3);
    tbInvoiceID.setWidth("338px");
    f_Label7.setText("" + messages.message5() + "");
    cbCurrency.setTabIndex(4);
    f_Label8.setText("" + messages.message6() + "");
    dateRaised.setTabIndex(5);
    f_Label9.setText("" + messages.message7() + "");
    dateDue.setTabIndex(6);
    invoiceDetailsPanel.setTabIndex(7);
    btAddInvoiceDetail.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message8())).asString());
    btAddInvoiceDetail.setTabIndex(8);
    btAddInvoiceDetail.setHref("javascript:;");
    f_Label10.setText("" + messages.message9() + "");
    taNotes.setTabIndex(10);
    taNotes.setWidth("100%");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HorizontalPanel11.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    btSave.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message10())).asString());
    btSave.setTabIndex(10);
    btSave.setHref("javascript:;");
    f_HorizontalPanel11.add(btSave);
    btCancel.setHTML(template.html4(SafeHtmlUtils.fromSafeConstant(messages.message11())).asString());
    btCancel.setTabIndex(12);
    f_HorizontalPanel11.add(btCancel);
    f_HorizontalPanel11.setStyleName("buttonsPanel");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    teMain = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    teMain.removeAttribute("id");
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
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
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(sbPartner, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(sbCategory, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(tbInvoiceID, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(cbCurrency, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label8, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(dateRaised, domId13Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label9, domId14Element);
    f_HTMLPanel2.addAndReplaceElement(dateDue, domId15Element);
    f_HTMLPanel2.addAndReplaceElement(invoiceDetailsPanel, domId16Element);
    f_HTMLPanel2.addAndReplaceElement(btAddInvoiceDetail, domId17Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label10, domId18Element);
    f_HTMLPanel2.addAndReplaceElement(taNotes, domId19Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel11, domId20Element);


    owner.btAddInvoiceDetail = btAddInvoiceDetail;
    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.cbCurrency = cbCurrency;
    owner.dateDue = dateDue;
    owner.dateRaised = dateRaised;
    owner.errorsPanel = errorsPanel;
    owner.taNotes = taNotes;
    owner.tbInvoiceID = tbInvoiceID;
    owner.teMain = teMain;

    return f_HTMLPanel1;
  }
}
