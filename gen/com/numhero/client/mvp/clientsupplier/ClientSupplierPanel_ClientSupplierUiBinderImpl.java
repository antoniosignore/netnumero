package com.numhero.client.mvp.clientsupplier;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ClientSupplierPanel_ClientSupplierUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.clientsupplier.ClientSupplierPanel>, com.numhero.client.mvp.clientsupplier.ClientSupplierPanel.ClientSupplierUiBinder {
  static ClientSupplierPanelClientSupplierUiBinderImplGenMessages messages = (ClientSupplierPanelClientSupplierUiBinderImplGenMessages) GWT.create(ClientSupplierPanelClientSupplierUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{1}'></span> </td> <td class='formItem' colspan='3'> <span id='{2}'></span> </td> <td class='form-item-label' width='80px'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem' colspan='5'> <span id='{6}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label' width='80px'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> <td class='form-item-label' width='80px'> <span id='{11}'></span> </td> <td class='formItem'> <span id='{12}'></span> </td> </tr> <tr> <td class='form-item-label-top'> <span id='{13}'></span> </td> <td class='formItem' colspan='5'> <span id='{14}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{0}'></span> </td> <td class='formItem' colspan='3'> <span id='{1}'></span> </td> <td class='form-item-label' width='80px'> <span id='{2}'></span> </td> <td class='formItem'> <span id='{3}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{4}'></span> </td> <td class='formItem'> <span id='{5}'></span> </td> <td class='form-item-label' width='80px'> <span id='{6}'></span> </td> <td class='formItem'> <span id='{7}'></span> </td> <td class='form-item-label' width='80px'> <span id='{8}'></span> </td> <td class='formItem'> <span id='{9}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='form-item-label' width='120px'> <span id='{0}'></span> </td> <td class='formItem' colspan='5'> <span id='{1}'></span> </td> </tr> <tr> <td class='form-item-label' width='120px'> <span id='{2}'></span> </td> <td class='formItem'> <span id='{3}'></span> </td> <td class='form-item-label' width='80px'> <span id='{4}'></span> </td> <td class='formItem'> <span id='{5}'></span> </td> <td class='form-item-label' width='80px'> <span id='{6}'></span> </td> <td class='formItem'> <span id='{7}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html4(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("{0}")
    SafeHtml html6(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html7(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.clientsupplier.ClientSupplierPanel owner) {

    com.numhero.client.mvp.clientsupplier.ClientSupplierPanel_ClientSupplierUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.clientsupplier.ClientSupplierPanel_ClientSupplierUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.clientsupplier.ClientSupplierPanel_ClientSupplierUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.DisclosurePanel errorsPanel = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message1() + "");
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCompanyName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbVAT = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox cbPartnerType = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lbPartnerType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCompanyEmail = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCompanyPhone = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCompanyFax = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextArea taNotes = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message2()), domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15).asString());
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbAddress = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label13 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbZipCode = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbCity = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbRegion = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CountryComboBox tbCountry = (com.numhero.client.widget.combobox.CountryComboBox) GWT.create(com.numhero.client.widget.combobox.CountryComboBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId18, domId19, domId20, domId21, domId22, domId23, domId24, domId25, domId26, domId27).asString());
    com.google.gwt.user.client.ui.DisclosurePanel f_DisclosurePanel10 = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message14() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId17).asString());
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label20 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label21 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbEmail = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbPhone = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    java.lang.String domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label23 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbMobile = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId30, domId31, domId32, domId33, domId34, domId35, domId36, domId37).asString());
    com.google.gwt.user.client.ui.DisclosurePanel f_DisclosurePanel18 = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message19() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId29).asString());
    java.lang.String domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel24 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html8(domId0, domId1, domId16, domId28, domId38).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message3() + "");
    tbCompanyName.setName("company.name");
    tbCompanyName.setWidth("100%");
    f_Label4.setText("" + messages.message4() + "");
    tbVAT.setName("company.vat");
    tbVAT.setWidth("100%");
    f_Label5.setText("" + messages.message5() + "");
    tbCompanyEmail.setName("company.email");
    tbCompanyEmail.setWidth("100%");
    f_Label6.setText("" + messages.message6() + "");
    tbCompanyPhone.setName("company.phone");
    tbCompanyPhone.setWidth("100%");
    f_Label7.setText("" + messages.message7() + "");
    tbCompanyFax.setName("company.fax");
    tbCompanyFax.setWidth("100%");
    f_Label8.setText("" + messages.message8() + "");
    taNotes.setName("company.notes");
    taNotes.setWidth("100%");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_Label12.setText("" + messages.message9() + "");
    tbAddress.setName("company.address.address");
    tbAddress.setWidth("100%");
    f_Label13.setText("" + messages.message10() + "");
    tbZipCode.setName("company.address.zipcode");
    tbZipCode.setWidth("100%");
    f_Label14.setText("" + messages.message11() + "");
    tbCity.setName("company.address.city");
    tbCity.setWidth("100%");
    f_Label15.setText("" + messages.message12() + "");
    tbRegion.setName("company.address.region");
    tbRegion.setWidth("100%");
    f_Label16.setText("" + messages.message13() + "");
    tbCountry.setName("company.address.country");
    tbCountry.setWidth("100%");
    f_DisclosurePanel10.add(f_HTMLPanel11);
    f_DisclosurePanel10.setOpen(false);
    f_DisclosurePanel10.setWidth("100%");
    f_HTMLPanel9.setStyleName("form-with-shadow");
    f_Label20.setText("" + messages.message15() + "");
    tbName.setName("company.contact.name");
    tbName.setWidth("100%");
    f_Label21.setText("" + messages.message16() + "");
    tbEmail.setName("company.contact.email");
    tbEmail.setWidth("100%");
    f_Label22.setText("" + messages.message17() + "");
    tbPhone.setName("company.contact.phone");
    tbPhone.setWidth("100%");
    f_Label23.setText("" + messages.message18() + "");
    tbMobile.setName("company.contact.mobile");
    tbMobile.setWidth("100%");
    f_DisclosurePanel18.add(f_HTMLPanel19);
    f_DisclosurePanel18.setOpen(false);
    f_DisclosurePanel18.setWidth("100%");
    f_HTMLPanel17.setStyleName("form-with-shadow");
    btSave.setHTML(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message20())).asString());
    btSave.setHref("javascript:;");
    f_HorizontalPanel24.add(btSave);
    btCancel.setHTML(template.html7(SafeHtmlUtils.fromSafeConstant(messages.message21())).asString());
    btCancel.setHref("javascript:;");
    f_HorizontalPanel24.add(btCancel);
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
    f_HTMLPanel2.addAndReplaceElement(tbCompanyName, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(tbVAT, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(cbPartnerType, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(lbPartnerType, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(tbCompanyEmail, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(tbCompanyPhone, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(tbCompanyFax, domId13Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label8, domId14Element);
    f_HTMLPanel2.addAndReplaceElement(taNotes, domId15Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
    UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
    com.google.gwt.user.client.Element domId18Element = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    com.google.gwt.user.client.Element domId26Element = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    com.google.gwt.user.client.Element domId27Element = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    attachRecord3.detach();
    f_HTMLPanel11.addAndReplaceElement(f_Label12, domId18Element);
    f_HTMLPanel11.addAndReplaceElement(tbAddress, domId19Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label13, domId20Element);
    f_HTMLPanel11.addAndReplaceElement(tbZipCode, domId21Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label14, domId22Element);
    f_HTMLPanel11.addAndReplaceElement(tbCity, domId23Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label15, domId24Element);
    f_HTMLPanel11.addAndReplaceElement(tbRegion, domId25Element);
    f_HTMLPanel11.addAndReplaceElement(f_Label16, domId26Element);
    f_HTMLPanel11.addAndReplaceElement(tbCountry, domId27Element);
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    attachRecord2.detach();
    f_HTMLPanel9.addAndReplaceElement(f_DisclosurePanel10, domId17Element);
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    UiBinderUtil.TempAttachment attachRecord4 = UiBinderUtil.attachToDom(f_HTMLPanel17.getElement());
    UiBinderUtil.TempAttachment attachRecord5 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
    com.google.gwt.user.client.Element domId30Element = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    com.google.gwt.user.client.Element domId31Element = com.google.gwt.dom.client.Document.get().getElementById(domId31).cast();
    com.google.gwt.user.client.Element domId32Element = com.google.gwt.dom.client.Document.get().getElementById(domId32).cast();
    com.google.gwt.user.client.Element domId33Element = com.google.gwt.dom.client.Document.get().getElementById(domId33).cast();
    com.google.gwt.user.client.Element domId34Element = com.google.gwt.dom.client.Document.get().getElementById(domId34).cast();
    com.google.gwt.user.client.Element domId35Element = com.google.gwt.dom.client.Document.get().getElementById(domId35).cast();
    com.google.gwt.user.client.Element domId36Element = com.google.gwt.dom.client.Document.get().getElementById(domId36).cast();
    com.google.gwt.user.client.Element domId37Element = com.google.gwt.dom.client.Document.get().getElementById(domId37).cast();
    attachRecord5.detach();
    f_HTMLPanel19.addAndReplaceElement(f_Label20, domId30Element);
    f_HTMLPanel19.addAndReplaceElement(tbName, domId31Element);
    f_HTMLPanel19.addAndReplaceElement(f_Label21, domId32Element);
    f_HTMLPanel19.addAndReplaceElement(tbEmail, domId33Element);
    f_HTMLPanel19.addAndReplaceElement(f_Label22, domId34Element);
    f_HTMLPanel19.addAndReplaceElement(tbPhone, domId35Element);
    f_HTMLPanel19.addAndReplaceElement(f_Label23, domId36Element);
    f_HTMLPanel19.addAndReplaceElement(tbMobile, domId37Element);
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    attachRecord4.detach();
    f_HTMLPanel17.addAndReplaceElement(f_DisclosurePanel18, domId29Element);
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId38Element = com.google.gwt.dom.client.Document.get().getElementById(domId38).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel9, domId16Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel17, domId28Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel24, domId38Element);


    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.cbPartnerType = cbPartnerType;
    owner.errorsPanel = errorsPanel;
    owner.lbPartnerType = lbPartnerType;
    owner.taNotes = taNotes;
    owner.tbAddress = tbAddress;
    owner.tbCity = tbCity;
    owner.tbCompanyEmail = tbCompanyEmail;
    owner.tbCompanyFax = tbCompanyFax;
    owner.tbCompanyName = tbCompanyName;
    owner.tbCompanyPhone = tbCompanyPhone;
    owner.tbCountry = tbCountry;
    owner.tbEmail = tbEmail;
    owner.tbMobile = tbMobile;
    owner.tbName = tbName;
    owner.tbPhone = tbPhone;
    owner.tbRegion = tbRegion;
    owner.tbVAT = tbVAT;
    owner.tbZipCode = tbZipCode;

    return f_HTMLPanel1;
  }
}
