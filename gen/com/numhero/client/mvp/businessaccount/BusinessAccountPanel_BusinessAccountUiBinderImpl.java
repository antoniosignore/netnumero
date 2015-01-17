package com.numhero.client.mvp.businessaccount;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class BusinessAccountPanel_BusinessAccountUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.businessaccount.BusinessAccountPanel>, com.numhero.client.mvp.businessaccount.BusinessAccountPanel.BusinessAccountUiBinder {
  static BusinessAccountPanelBusinessAccountUiBinderImplGenMessages messages = (BusinessAccountPanelBusinessAccountUiBinderImplGenMessages) GWT.create(BusinessAccountPanelBusinessAccountUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='4'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label' width='80px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr>                     </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='form-item-label' colspan='4'> <table> <tr> <td style='padding-right: 20px; text-align: center'> <span id='{0}'></span> <br> <br> <span id='{1}'></span> <br> <span id='{2}'></span> </td> <td class='logo'> <span id='{3}'></span> </td> </tr> </table> </td> </tr> </tbody> </table>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='4'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> <td class='form-item-label'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html5(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem' colspan='3'> <span id='{2}'></span> </td> <td class='form-item-label' width='80px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> <td class='form-item-label' width='80px'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label' width='80px'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html6(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label' width='120px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> <td class='form-item-label' width='120px'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label' width='120px'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> <td class='form-item-label' width='120px'> <span id='{11}'></span> </td> <td class='formItem'> <span id='{12}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{13}'></span> </td> <td class='formItem' colspan='5'> <span id='{14}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html7(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
    @Template("{0}")
    SafeHtml html8(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html9(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html10(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html11(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.businessaccount.BusinessAccountPanel owner) {

    com.numhero.client.mvp.businessaccount.BusinessAccountPanel_BusinessAccountUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.businessaccount.BusinessAccountPanel_BusinessAccountUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.businessaccount.BusinessAccountPanel_BusinessAccountUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("Errors");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbVat = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId2, domId3, domId4, domId5).asString());
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.FileUpload fuLogo = (com.google.gwt.user.client.ui.FileUpload) GWT.create(com.google.gwt.user.client.ui.FileUpload.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Hidden hBusinessAccountId = (com.google.gwt.user.client.ui.Hidden) GWT.create(com.google.gwt.user.client.ui.Hidden.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId11, domId12).asString());
    com.google.gwt.user.client.ui.FormPanel fpUploadLogo = (com.google.gwt.user.client.ui.FormPanel) GWT.create(com.google.gwt.user.client.ui.FormPanel.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.image.Image imgLogo = (com.numhero.client.widget.image.Image) GWT.create(com.numhero.client.widget.image.Image.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId8, domId9, domId10, domId13).asString());
    com.google.gwt.user.client.ui.DisclosurePanel f_DisclosurePanel6 = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message6() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId7).asString());
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbEmail = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbWeb = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbPhone = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbFax = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(SafeHtmlUtils.fromSafeConstant(messages.message7()), domId15, domId16, domId17, domId18, domId19, domId20, domId21, domId22).asString());
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label17 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbAddress = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label18 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbZipCode = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label19 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCity = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label20 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbRegion = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label21 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CountryComboBox tbCountry = (com.numhero.client.widget.combobox.CountryComboBox) GWT.create(com.numhero.client.widget.combobox.CountryComboBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel16 = new com.google.gwt.user.client.ui.HTMLPanel(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message12()), domId24, domId25, domId26, domId27, domId28, domId29, domId30, domId31, domId32, domId33).asString());
    java.lang.String domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label23 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbInvoiceIDPrefix = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label24 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox tbLastInvoiceID = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId39 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label25 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId40 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox tbLastEstimateID = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId41 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label26 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId42 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label cbCurrency = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId43 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label27 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId44 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox tbDefaultDaysDue = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId45 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label28 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId46 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.ColorComboBox cbColorScheme = (com.numhero.client.widget.combobox.ColorComboBox) GWT.create(com.numhero.client.widget.combobox.ColorComboBox.class);
    java.lang.String domId47 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label29 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId48 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taTermsConditions = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel22 = new com.google.gwt.user.client.ui.HTMLPanel(template.html7(SafeHtmlUtils.fromSafeConstant(messages.message18()), domId35, domId36, domId37, domId38, domId39, domId40, domId41, domId42, domId43, domId44, domId45, domId46, domId47, domId48).asString());
    java.lang.String domId49 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btSkip = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel30 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html11(domId0, domId1, domId6, domId14, domId23, domId34, domId49).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message2() + "");
    tbName.setWidth("100%");
    f_Label4.setText("" + messages.message3() + "");
    tbVat.setWidth("100%");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_Label8.setText("" + messages.message4() + "");
    f_Label8.setStyleName("logoTitle");
    f_Label9.setText("" + messages.message5() + "");
    f_Label9.setStyleName("logoSubTitle");
    fuLogo.setName("logo");
    fuLogo.setWidth("100%");
    hBusinessAccountId.setName("businessAccountId");
    fpUploadLogo.add(f_HTMLPanel10);
    fpUploadLogo.setAction("/uploadLogo");
    fpUploadLogo.setEncoding("multipart/form-data");
    fpUploadLogo.setMethod("post");
    f_DisclosurePanel6.add(f_HTMLPanel7);
    f_DisclosurePanel6.setOpen(false);
    f_DisclosurePanel6.setWidth("100%");
    f_HTMLPanel5.setStyleName("form-with-shadow");
    f_Label12.setText("" + messages.message8() + "");
    tbEmail.setWidth("100%");
    f_Label13.setText("" + messages.message9() + "");
    tbWeb.setWidth("100%");
    f_Label14.setText("" + messages.message10() + "");
    tbPhone.setWidth("100%");
    f_Label15.setText("" + messages.message11() + "");
    tbFax.setWidth("100%");
    f_HTMLPanel11.setStyleName("form-with-shadow");
    f_Label17.setText("" + messages.message13() + "");
    tbAddress.setWidth("100%");
    f_Label18.setText("" + messages.message14() + "");
    tbZipCode.setWidth("100%");
    f_Label19.setText("" + messages.message15() + "");
    tbCity.setWidth("100%");
    f_Label20.setText("" + messages.message16() + "");
    tbRegion.setWidth("100%");
    f_Label21.setText("" + messages.message17() + "");
    tbCountry.setWidth("100%");
    f_HTMLPanel16.setStyleName("form-with-shadow");
    f_Label23.setText("" + messages.message19() + "");
    f_Label24.setText("" + messages.message20() + "");
    tbLastInvoiceID.setPrecision(0);
    f_Label25.setText("" + messages.message21() + "");
    tbLastEstimateID.setPrecision(0);
    f_Label26.setText("" + messages.message22() + "");
    f_Label27.setText("" + messages.message23() + "");
    tbDefaultDaysDue.setPrecision(0);
    f_Label28.setText("" + messages.message24() + "");
    cbColorScheme.setWidth("100%");
    f_Label29.setText("" + messages.message25() + "");
    taTermsConditions.setWidth("100%");
    f_HTMLPanel22.setStyleName("form-with-shadow");
    f_HorizontalPanel30.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_RIGHT);
    btSave.setHTML(template.html8(SafeHtmlUtils.fromSafeConstant(messages.message26())).asString());
    btSave.setHref("javascript:;");
    f_HorizontalPanel30.add(btSave);
    btCancel.setHTML(template.html9(SafeHtmlUtils.fromSafeConstant(messages.message27())).asString());
    btCancel.setHref("javascript:;");
    f_HorizontalPanel30.add(btCancel);
    btSkip.setHTML(template.html10(SafeHtmlUtils.fromSafeConstant(messages.message28())).asString());
    btSkip.setHref("javascript:;");
    f_HorizontalPanel30.add(btSkip);
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(tbName, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(tbVat, domId5Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
    UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    UiBinderUtil.TempAttachment attachRecord4 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    attachRecord4.detach();
    f_HTMLPanel10.addAndReplaceElement(fuLogo, domId11Element);
    f_HTMLPanel10.addAndReplaceElement(hBusinessAccountId, domId12Element);
    com.google.gwt.user.client.Element domId10Element = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    com.google.gwt.user.client.Element domId13Element = com.google.gwt.dom.client.Document.get().getElementById(domId13).cast();
    attachRecord3.detach();
    f_HTMLPanel7.addAndReplaceElement(f_Label8, domId8Element);
    f_HTMLPanel7.addAndReplaceElement(f_Label9, domId9Element);
    f_HTMLPanel7.addAndReplaceElement(fpUploadLogo, domId10Element);
    f_HTMLPanel7.addAndReplaceElement(imgLogo, domId13Element);
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    attachRecord2.detach();
    f_HTMLPanel5.addAndReplaceElement(f_DisclosurePanel6, domId7Element);
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    UiBinderUtil.TempAttachment attachRecord5 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
    com.google.gwt.user.client.Element domId15Element = com.google.gwt.dom.client.Document.get().getElementById(domId15).cast();
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    com.google.gwt.user.client.Element domId18Element = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    attachRecord5.detach();
    f_HTMLPanel11.addAndReplaceElement(f_Label12, domId15Element);
    f_HTMLPanel11.addAndReplaceElement(tbEmail, domId16Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label13, domId17Element);
    f_HTMLPanel11.addAndReplaceElement(tbWeb, domId18Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label14, domId19Element);
    f_HTMLPanel11.addAndReplaceElement(tbPhone, domId20Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label15, domId21Element);
    f_HTMLPanel11.addAndReplaceElement(tbFax, domId22Element);
    com.google.gwt.user.client.Element domId14Element = com.google.gwt.dom.client.Document.get().getElementById(domId14).cast();
    UiBinderUtil.TempAttachment attachRecord6 = UiBinderUtil.attachToDom(f_HTMLPanel16.getElement());
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    com.google.gwt.user.client.Element domId26Element = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    com.google.gwt.user.client.Element domId27Element = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    com.google.gwt.user.client.Element domId30Element = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    com.google.gwt.user.client.Element domId31Element = com.google.gwt.dom.client.Document.get().getElementById(domId31).cast();
    com.google.gwt.user.client.Element domId32Element = com.google.gwt.dom.client.Document.get().getElementById(domId32).cast();
    com.google.gwt.user.client.Element domId33Element = com.google.gwt.dom.client.Document.get().getElementById(domId33).cast();
    attachRecord6.detach();
    f_HTMLPanel16.addAndReplaceElement(f_Label17, domId24Element);
    f_HTMLPanel16.addAndReplaceElement(tbAddress, domId25Element);
    f_HTMLPanel16.addAndReplaceElement(f_Label18, domId26Element);
    f_HTMLPanel16.addAndReplaceElement(tbZipCode, domId27Element);
    f_HTMLPanel16.addAndReplaceElement(f_Label19, domId28Element);
    f_HTMLPanel16.addAndReplaceElement(tbCity, domId29Element);
    f_HTMLPanel16.addAndReplaceElement(f_Label20, domId30Element);
    f_HTMLPanel16.addAndReplaceElement(tbRegion, domId31Element);
    f_HTMLPanel16.addAndReplaceElement(f_Label21, domId32Element);
    f_HTMLPanel16.addAndReplaceElement(tbCountry, domId33Element);
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    UiBinderUtil.TempAttachment attachRecord7 = UiBinderUtil.attachToDom(f_HTMLPanel22.getElement());
    com.google.gwt.user.client.Element domId35Element = com.google.gwt.dom.client.Document.get().getElementById(domId35).cast();
    com.google.gwt.user.client.Element domId36Element = com.google.gwt.dom.client.Document.get().getElementById(domId36).cast();
    com.google.gwt.user.client.Element domId37Element = com.google.gwt.dom.client.Document.get().getElementById(domId37).cast();
    com.google.gwt.user.client.Element domId38Element = com.google.gwt.dom.client.Document.get().getElementById(domId38).cast();
    com.google.gwt.user.client.Element domId39Element = com.google.gwt.dom.client.Document.get().getElementById(domId39).cast();
    com.google.gwt.user.client.Element domId40Element = com.google.gwt.dom.client.Document.get().getElementById(domId40).cast();
    com.google.gwt.user.client.Element domId41Element = com.google.gwt.dom.client.Document.get().getElementById(domId41).cast();
    com.google.gwt.user.client.Element domId42Element = com.google.gwt.dom.client.Document.get().getElementById(domId42).cast();
    com.google.gwt.user.client.Element domId43Element = com.google.gwt.dom.client.Document.get().getElementById(domId43).cast();
    com.google.gwt.user.client.Element domId44Element = com.google.gwt.dom.client.Document.get().getElementById(domId44).cast();
    com.google.gwt.user.client.Element domId45Element = com.google.gwt.dom.client.Document.get().getElementById(domId45).cast();
    com.google.gwt.user.client.Element domId46Element = com.google.gwt.dom.client.Document.get().getElementById(domId46).cast();
    com.google.gwt.user.client.Element domId47Element = com.google.gwt.dom.client.Document.get().getElementById(domId47).cast();
    com.google.gwt.user.client.Element domId48Element = com.google.gwt.dom.client.Document.get().getElementById(domId48).cast();
    attachRecord7.detach();
    f_HTMLPanel22.addAndReplaceElement(f_Label23, domId35Element);
    f_HTMLPanel22.addAndReplaceElement(tbInvoiceIDPrefix, domId36Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label24, domId37Element);
    f_HTMLPanel22.addAndReplaceElement(tbLastInvoiceID, domId38Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label25, domId39Element);
    f_HTMLPanel22.addAndReplaceElement(tbLastEstimateID, domId40Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label26, domId41Element);
    f_HTMLPanel22.addAndReplaceElement(cbCurrency, domId42Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label27, domId43Element);
    f_HTMLPanel22.addAndReplaceElement(tbDefaultDaysDue, domId44Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label28, domId45Element);
    f_HTMLPanel22.addAndReplaceElement(cbColorScheme, domId46Element);
    f_HTMLPanel22.addAndReplaceElement(f_Label29, domId47Element);
    f_HTMLPanel22.addAndReplaceElement(taTermsConditions, domId48Element);
    com.google.gwt.user.client.Element domId34Element = com.google.gwt.dom.client.Document.get().getElementById(domId34).cast();
    com.google.gwt.user.client.Element domId49Element = com.google.gwt.dom.client.Document.get().getElementById(domId49).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel5, domId6Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel11, domId14Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel16, domId23Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel22, domId34Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel30, domId49Element);


    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.btSkip = btSkip;
    owner.cbColorScheme = cbColorScheme;
    owner.cbCurrency = cbCurrency;
    owner.errorsPanel = errorsPanel;
    owner.fpUploadLogo = fpUploadLogo;
    owner.fuLogo = fuLogo;
    owner.hBusinessAccountId = hBusinessAccountId;
    owner.imgLogo = imgLogo;
    owner.taTermsConditions = taTermsConditions;
    owner.tbAddress = tbAddress;
    owner.tbCity = tbCity;
    owner.tbCountry = tbCountry;
    owner.tbDefaultDaysDue = tbDefaultDaysDue;
    owner.tbEmail = tbEmail;
    owner.tbFax = tbFax;
    owner.tbInvoiceIDPrefix = tbInvoiceIDPrefix;
    owner.tbLastEstimateID = tbLastEstimateID;
    owner.tbLastInvoiceID = tbLastInvoiceID;
    owner.tbName = tbName;
    owner.tbPhone = tbPhone;
    owner.tbRegion = tbRegion;
    owner.tbVat = tbVat;
    owner.tbWeb = tbWeb;
    owner.tbZipCode = tbZipCode;

    return f_HTMLPanel1;
  }
}
