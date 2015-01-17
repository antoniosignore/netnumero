package com.numhero.client.mvp.bankaccount;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class BankAccountPanel_BankAccountUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.bankaccount.BankAccountPanel>, com.numhero.client.mvp.bankaccount.BankAccountPanel.BankAccountUiBinder {
  static BankAccountPanelBankAccountUiBinderImplGenMessages messages = (BankAccountPanelBankAccountUiBinderImplGenMessages) GWT.create(BankAccountPanelBankAccountUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem' colspan='5'> <span id='{2}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem' colspan='5'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem' colspan='5'> <span id='{6}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{7}'></span> </td> <td class='formItem' colspan='3'> <span id='{8}'></span> </td> <td class='form-item-label'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{11}'></span> </td> <td class='formItem' colspan='3'> <span id='{12}'></span> </td> <td class='form-item-label'> <span id='{13}'></span> </td> <td class='formItem'> <span id='{14}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{15}'></span> </td> <td class='formItem'> <span id='{16}'></span> </td> <td class='form-item-label'> <span id='{17}'></span> </td> <td class='formItem'> <span id='{18}'></span> </td> <td class='form-item-label'> <span id='{19}'></span> </td> <td class='formItem'> <span id='{20}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem' colspan='3'> <span id='{2}'></span> </td> <td class='form-item-label' width='80px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> <td class='form-item-label' width='80px'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label' width='80px'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html4(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.bankaccount.BankAccountPanel owner) {

    com.numhero.client.mvp.bankaccount.BankAccountPanel_BankAccountUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.bankaccount.BankAccountPanel_BankAccountUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.bankaccount.BankAccountPanel_BankAccountUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("Errors");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox name = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox description = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox bank = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox account = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CurrencySelect cbCurrency = (com.numhero.client.widget.combobox.CurrencySelect) GWT.create(com.numhero.client.widget.combobox.CurrencySelect.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox swift = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox iban = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox openingBalance = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label currentBalance = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label isMainTradingAccount = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15, domId16, domId17, domId18, domId19, domId20, domId21).asString());
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbAddress = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbZipCode = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCity = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label17 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbRegion = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label18 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CountryComboBox tbCountry = (com.numhero.client.widget.combobox.CountryComboBox) GWT.create(com.numhero.client.widget.combobox.CountryComboBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message12()), domId23, domId24, domId25, domId26, domId27, domId28, domId29, domId30, domId31, domId32).asString());
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel19 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId0, domId1, domId22, domId33).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message2() + "");
    name.setWidth("100%");
    f_Label4.setText("" + messages.message3() + "");
    description.setWidth("100%");
    f_Label5.setText("" + messages.message4() + "");
    bank.setWidth("100%");
    f_Label6.setText("" + messages.message5() + "");
    f_Label7.setText("" + messages.message6() + "");
    f_Label8.setText("" + messages.message7() + "");
    f_Label9.setText("" + messages.message8() + "");
    f_Label10.setText("" + messages.message9() + "");
    f_Label11.setText("" + messages.message10() + "");
    f_Label12.setText("" + messages.message11() + "");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_Label14.setText("" + messages.message13() + "");
    tbAddress.setWidth("100%");
    f_Label15.setText("" + messages.message14() + "");
    tbZipCode.setWidth("100%");
    f_Label16.setText("" + messages.message15() + "");
    tbCity.setWidth("100%");
    f_Label17.setText("" + messages.message16() + "");
    tbRegion.setWidth("100%");
    f_Label18.setText("" + messages.message17() + "");
    tbCountry.setWidth("100%");
    f_HTMLPanel13.setStyleName("form-with-shadow");
    btSave.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message18())).asString());
    f_HorizontalPanel19.add(btSave);
    btCancel.setHTML(template.html4(SafeHtmlUtils.fromSafeConstant(messages.message19())).asString());
    f_HorizontalPanel19.add(btCancel);
    f_HorizontalPanel19.setStyleName("buttonsPanel");
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
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    com.google.gwt.user.client.Element domId18Element = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(name, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(description, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(bank, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(account, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(cbCurrency, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label8, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(swift, domId13Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label9, domId14Element);
    f_HTMLPanel2.addAndReplaceElement(iban, domId15Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label10, domId16Element);
    f_HTMLPanel2.addAndReplaceElement(openingBalance, domId17Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label11, domId18Element);
    f_HTMLPanel2.addAndReplaceElement(currentBalance, domId19Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label12, domId20Element);
    f_HTMLPanel2.addAndReplaceElement(isMainTradingAccount, domId21Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    com.google.gwt.user.client.Element domId26Element = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    com.google.gwt.user.client.Element domId27Element = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    com.google.gwt.user.client.Element domId30Element = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    com.google.gwt.user.client.Element domId31Element = com.google.gwt.dom.client.Document.get().getElementById(domId31).cast();
    com.google.gwt.user.client.Element domId32Element = com.google.gwt.dom.client.Document.get().getElementById(domId32).cast();
    attachRecord2.detach();
    f_HTMLPanel13.addAndReplaceElement(f_Label14, domId23Element);
    f_HTMLPanel13.addAndReplaceElement(tbAddress, domId24Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label15, domId25Element);
    f_HTMLPanel13.addAndReplaceElement(tbZipCode, domId26Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label16, domId27Element);
    f_HTMLPanel13.addAndReplaceElement(tbCity, domId28Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label17, domId29Element);
    f_HTMLPanel13.addAndReplaceElement(tbRegion, domId30Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label18, domId31Element);
    f_HTMLPanel13.addAndReplaceElement(tbCountry, domId32Element);
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    com.google.gwt.user.client.Element domId33Element = com.google.gwt.dom.client.Document.get().getElementById(domId33).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel13, domId22Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel19, domId33Element);


    owner.account = account;
    owner.bank = bank;
    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.cbCurrency = cbCurrency;
    owner.currentBalance = currentBalance;
    owner.description = description;
    owner.errorsPanel = errorsPanel;
    owner.iban = iban;
    owner.isMainTradingAccount = isMainTradingAccount;
    owner.name = name;
    owner.openingBalance = openingBalance;
    owner.swift = swift;
    owner.tbAddress = tbAddress;
    owner.tbCity = tbCity;
    owner.tbCountry = tbCountry;
    owner.tbRegion = tbRegion;
    owner.tbZipCode = tbZipCode;

    return f_HTMLPanel1;
  }
}
