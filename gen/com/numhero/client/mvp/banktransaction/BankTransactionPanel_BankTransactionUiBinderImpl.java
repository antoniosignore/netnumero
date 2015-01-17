package com.numhero.client.mvp.banktransaction;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class BankTransactionPanel_BankTransactionUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.banktransaction.BankTransactionPanel>, com.numhero.client.mvp.banktransaction.BankTransactionPanel.BankTransactionUiBinder {
  static BankTransactionPanelBankTransactionUiBinderImplGenMessages messages = (BankTransactionPanelBankTransactionUiBinderImplGenMessages) GWT.create(BankTransactionPanelBankTransactionUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='10'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label' width='120px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> </tr> <tr> <td class='formItem'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label'> <span id='{9}'></span> </td> <td class='formItem' colspan='2'> <span id='{10}'></span> </td> <td class='formItem'> <span id='{11}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{12}'></span> </td> <td class='formItem' colspan='9'> <span id='{13}'></span> </td> </tr> <tr> <td colspan='10'> <span id='{14}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html3(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.banktransaction.BankTransactionPanel owner) {

    com.numhero.client.mvp.banktransaction.BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.banktransaction.BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.banktransaction.BankTransactionPanel_BankTransactionUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("Errors");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.bankaccount.BankAccountSelect sbBankAccount = owner.sbBankAccount;
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.category.CategorySelect sbCategory = owner.sbCategory;
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox selectedDate = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.RadioButton isDeposit = new com.google.gwt.user.client.ui.RadioButton("radios");
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.RadioButton isWithdraw = new com.google.gwt.user.client.ui.RadioButton("radios");
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox amount = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label currency = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea notes = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel8 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0, domId1).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message2() + "");
    f_Label4.setText("" + messages.message3() + "");
    f_Label5.setText("" + messages.message4() + "");
    isDeposit.setText(messages.message5());
    isDeposit.setChecked(true);
    isWithdraw.setText(messages.message6());
    f_Label6.setText("" + messages.message7() + "");
    amount.setReadOnly(false);
    f_Label7.setText("" + messages.message8() + "");
    notes.setWidth("100%");
    btSave.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message9())).asString());
    f_HorizontalPanel8.add(btSave);
    btCancel.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message10())).asString());
    btCancel.setHref("#time");
    f_HorizontalPanel8.add(btCancel);
    f_HorizontalPanel8.setStyleName("buttonsPanel");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
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
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(sbBankAccount, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(sbCategory, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(selectedDate, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(isDeposit, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(isWithdraw, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(amount, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(currency, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId13Element);
    f_HTMLPanel2.addAndReplaceElement(notes, domId14Element);
    f_HTMLPanel2.addAndReplaceElement(f_HorizontalPanel8, domId15Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);


    owner.amount = amount;
    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.currency = currency;
    owner.errorsPanel = errorsPanel;
    owner.isDeposit = isDeposit;
    owner.isWithdraw = isWithdraw;
    owner.notes = notes;
    owner.selectedDate = selectedDate;

    return f_HTMLPanel1;
  }
}
