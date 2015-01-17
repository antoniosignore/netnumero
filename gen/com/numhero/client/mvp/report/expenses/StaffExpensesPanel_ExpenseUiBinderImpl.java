package com.numhero.client.mvp.report.expenses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class StaffExpensesPanel_ExpenseUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.report.expenses.StaffExpensesPanel>, com.numhero.client.mvp.report.expenses.StaffExpensesPanel.ExpenseUiBinder {
  static StaffExpensesPanelExpenseUiBinderImplGenMessages messages = (StaffExpensesPanelExpenseUiBinderImplGenMessages) GWT.create(StaffExpensesPanelExpenseUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> </tr> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='formItem'> <span id='{7}'></span> </td> <td class='form-item-label'> <span id='{8}'></span> </td> <td class='formItem'> <span id='{9}'></span> </td> <td class='form-item-label'> <span id='{10}'></span> </td> <td class='formItem' colspan='6'> <span id='{11}'></span> </td> </tr> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td colspan='14'> <span id='{12}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.report.expenses.StaffExpensesPanel owner) {

    com.numhero.client.mvp.report.expenses.StaffExpensesPanel_ExpenseUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.report.expenses.StaffExpensesPanel_ExpenseUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.report.expenses.StaffExpensesPanel_ExpenseUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.clientsupplier.ClientSelect sbClient = owner.sbClient;
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox from = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox to = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.ReceiptStaffStatusComboBox receiptStaffStatusComboBox = (com.numhero.client.widget.combobox.ReceiptStaffStatusComboBox) GWT.create(com.numhero.client.widget.combobox.ReceiptStaffStatusComboBox.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.ReceiptClientStatusComboBox receiptClientStatusComboBox = (com.numhero.client.widget.combobox.ReceiptClientStatusComboBox) GWT.create(com.numhero.client.widget.combobox.ReceiptClientStatusComboBox.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btRefresh = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.report.ReportExpensesTable unbilledExpensesTable = (com.numhero.client.mvp.report.ReportExpensesTable) GWT.create(com.numhero.client.mvp.report.ReportExpensesTable.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0).asString());

    f_Label3.setText("" + messages.message2() + "");
    f_Label4.setText("" + messages.message3() + "");
    f_Label5.setText("" + messages.message4() + "");
    f_Label6.setText("" + messages.message5() + "");
    f_Label7.setText("" + messages.message6() + "");
    btRefresh.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message7())).asString());
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
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    com.google.gwt.user.client.Element domId10Element = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId1Element);
    f_HTMLPanel2.addAndReplaceElement(sbClient, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(from, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(to, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(receiptStaffStatusComboBox, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(receiptClientStatusComboBox, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(btRefresh, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(unbilledExpensesTable, domId12Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);


    owner.btRefresh = btRefresh;
    owner.from = from;
    owner.receiptClientStatusComboBox = receiptClientStatusComboBox;
    owner.receiptStaffStatusComboBox = receiptStaffStatusComboBox;
    owner.to = to;
    owner.unbilledExpensesTable = unbilledExpensesTable;

    return f_HTMLPanel1;
  }
}
