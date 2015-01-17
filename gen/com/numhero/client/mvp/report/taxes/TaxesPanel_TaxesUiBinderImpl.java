package com.numhero.client.mvp.report.taxes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class TaxesPanel_TaxesUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.report.taxes.TaxesPanel>, com.numhero.client.mvp.report.taxes.TaxesPanel.TaxesUiBinder {
  static TaxesPanelTaxesUiBinderImplGenMessages messages = (TaxesPanelTaxesUiBinderImplGenMessages) GWT.create(TaxesPanelTaxesUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td colspan='14'> <span id='{1}'></span> </td> </tr> <tr> <span id='{2}'></span> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.report.taxes.TaxesPanel owner) {

    com.numhero.client.mvp.report.taxes.TaxesPanel_TaxesUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.report.taxes.TaxesPanel_TaxesUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.report.taxes.TaxesPanel_TaxesUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.report.taxes.TaxesTable taxesTable = (com.numhero.client.mvp.report.taxes.TaxesTable) GWT.create(com.numhero.client.mvp.report.taxes.TaxesTable.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, domId2).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0).asString());

    btCancel.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());
    btCancel.setTabIndex(12);
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(taxesTable, domId1Element);
    f_HTMLPanel2.addAndReplaceElement(btCancel, domId2Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);


    owner.btCancel = btCancel;
    owner.taxesTable = taxesTable;

    return f_HTMLPanel1;
  }
}
