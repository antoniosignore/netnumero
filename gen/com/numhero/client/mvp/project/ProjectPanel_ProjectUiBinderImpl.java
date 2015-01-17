package com.numhero.client.mvp.project;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProjectPanel_ProjectUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.project.ProjectPanel>, com.numhero.client.mvp.project.ProjectPanel.ProjectUiBinder {
  static ProjectPanelProjectUiBinderImplGenMessages messages = (ProjectPanelProjectUiBinderImplGenMessages) GWT.create(ProjectPanelProjectUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='8'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem' colspan='5' width='100%'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> <td class='form-item-label'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> <td class='form-item-label'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> <td class='form-item-label'> <span id='{11}'></span> </td> <td class='formItem'> <span id='{12}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{13}'></span> </td> <td class='formItem'> <span id='{14}'></span> </td> <td class='form-item-label'> <span id='{15}'></span> </td> <td class='formItem'> <span id='{16}'></span> </td> <td class='form-item-label'> <span id='{17}'></span> </td> <td class='formItem'> <span id='{18}'></span> </td> <td class='form-item-label'> <span id='{19}'></span> </td> <td class='formItem'> <span id='{20}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} <span id='{1}'></span> </td> </tr> </thead> <tbody> <tr id='{2}'> <td class='form-item-label' colspan='5'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr id='{5}'> <td class='form-item-label'> <span id='{6}'></span> </td> <td class='formItem'> <span id='{7}'></span> </td> <td class='form-item-label'> <span id='{8}'></span> </td> <td class='formItem' colspan='3'> <span id='{9}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='formItem'> <span id='{0}'></span> </td> </tr> <tr> <td style='height:54px;'> <span id='{1}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("{0}")
    SafeHtml html6(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='formItem' colspan='2'> <span id='{0}'></span> </td> </tr> <tr> <td colspan='2' style='height:54px;'> <span id='{1}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='form-item-label'> <span id='{0}'></span> </td> <td class='formItem'> <span id='{1}'></span> </td> <td class='form-item-label'> <span id='{2}'></span> </td> <td class='formItem'> <span id='{3}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='formItem' colspan='4'> <span id='{0}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html10(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='formItem' colspan='4'> <span id='{0}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html12(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html13(String arg0);
     
    @Template("{0}")
    SafeHtml html14(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html15(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html16(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html17(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html18(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>      <span id='{5}'></span> <br> <span id='{6}'></span>      <span id='{7}'></span> <span id='{8}'></span>")
    SafeHtml html19(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.project.ProjectPanel owner) {

    com.numhero.client.mvp.project.ProjectPanel_ProjectUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.project.ProjectPanel_ProjectUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.project.ProjectPanel_ProjectUiBinderImpl_GenBundle.class);
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
    com.numhero.client.widget.combobox.DropDownBox sbClient = owner.sbClient;
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.ProjectStateEnumComboBox cbState = (com.numhero.client.widget.combobox.ProjectStateEnumComboBox) GWT.create(com.numhero.client.widget.combobox.ProjectStateEnumComboBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label lastBilled = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label created = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.CurrencySelect cbCurrency = (com.numhero.client.widget.combobox.CurrencySelect) GWT.create(com.numhero.client.widget.combobox.CurrencySelect.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label10 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label valuationLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label totalTime = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label billableTime = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13, domId14, domId15, domId16, domId17, domId18, domId19, domId20, domId21).asString());
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.BillingMethodComboBox billingMethod = (com.numhero.client.widget.combobox.BillingMethodComboBox) GWT.create(com.numhero.client.widget.combobox.BillingMethodComboBox.class);
    com.google.gwt.dom.client.TableRowElement billingFlatRateRow = null;
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox billingFlatRate = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    com.google.gwt.dom.client.TableRowElement billingRateRow = null;
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label15 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox billingRate = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label16 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.TimeUnitComboBox timeUnit = (com.numhero.client.widget.combobox.TimeUnitComboBox) GWT.create(com.numhero.client.widget.combobox.TimeUnitComboBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message12()), domId23, domId24, domId25, domId26, domId27, domId28, domId29, domId30, domId31).asString());
    java.lang.String domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.project.ProjectTasksDetailsTable projectTasksDetailsTable = owner.projectTasksDetailsTable;
    java.lang.String domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btAddTask = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel18 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId34, domId35).asString());
    com.google.gwt.user.client.ui.DisclosurePanel taskGroup = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message17() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId33).asString());
    java.lang.String domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.project.ProjectStaffDetailsTable projectStaffDetailsTable = owner.projectStaffDetailsTable;
    java.lang.String domId39 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btAddStaff = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel20 = new com.google.gwt.user.client.ui.HTMLPanel(template.html7(domId38, domId39).asString());
    com.google.gwt.user.client.ui.DisclosurePanel staffGroup = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message19() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template.html8(domId37).asString());
    java.lang.String domId40 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId41 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId42 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox from = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId43 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label23 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId44 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox to = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel21 = new com.google.gwt.user.client.ui.HTMLPanel(template.html9(domId41, domId42, domId43, domId44).asString());
    java.lang.String domId45 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId46 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId47 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.timeentry.TimeEntriesTable timeEntriesTable = new com.numhero.client.mvp.timeentry.TimeEntriesTable();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel25 = new com.google.gwt.user.client.ui.HTMLPanel(template.html10(domId47).asString());
    com.google.gwt.user.client.ui.DisclosurePanel hoursGroup = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message22() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel24 = new com.google.gwt.user.client.ui.HTMLPanel(template.html11(domId46).asString());
    java.lang.String domId48 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId49 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId50 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.project.ProjectExpensesTable expensesTable = (com.numhero.client.mvp.project.ProjectExpensesTable) GWT.create(com.numhero.client.mvp.project.ProjectExpensesTable.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel27 = new com.google.gwt.user.client.ui.HTMLPanel(template.html12(domId50).asString());
    com.google.gwt.user.client.ui.DisclosurePanel expensesGroup = new com.google.gwt.user.client.ui.DisclosurePanel("" + messages.message23() + "");
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel26 = new com.google.gwt.user.client.ui.HTMLPanel(template.html13(domId49).asString());
    java.lang.String domId51 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btGenerateInvoice = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btGenerateEstimate = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btConvert = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel28 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html19(domId0, domId1, domId22, domId32, domId36, domId40, domId45, domId48, domId51).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message2() + "");
    name.setWidth("238px");
    f_Label4.setText("" + messages.message3() + "");
    description.setWidth("100%");
    f_Label5.setText("" + messages.message4() + "");
    sbClient.setTabIndex(1);
    f_Label6.setText("" + messages.message5() + "");
    f_Label7.setText("" + messages.message6() + "");
    f_Label8.setText("" + messages.message7() + "");
    f_Label9.setText("" + messages.message8() + "");
    f_Label10.setText("" + messages.message9() + "");
    f_Label11.setText("" + messages.message10() + "");
    f_Label12.setText("" + messages.message11() + "");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_Label14.setText("" + messages.message13() + "");
    f_Label15.setText("" + messages.message14() + "");
    f_Label16.setText("" + messages.message15() + "");
    f_HTMLPanel13.setStyleName("form-with-shadow");
    projectTasksDetailsTable.setCellSpacing(0);
    projectTasksDetailsTable.setCellPadding(0);
    btAddTask.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message16())).asString());
    taskGroup.add(f_HTMLPanel18);
    taskGroup.setOpen(true);
    taskGroup.setWidth("100%");
    f_HTMLPanel17.setStyleName("form-with-shadow");
    projectStaffDetailsTable.setCellSpacing(0);
    projectStaffDetailsTable.setCellPadding(0);
    btAddStaff.setHTML(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message18())).asString());
    staffGroup.add(f_HTMLPanel20);
    staffGroup.setOpen(true);
    staffGroup.setWidth("100%");
    f_HTMLPanel19.setStyleName("form-with-shadow");
    f_Label22.setText("" + messages.message20() + "");
    f_Label23.setText("" + messages.message21() + "");
    hoursGroup.add(f_HTMLPanel25);
    hoursGroup.setOpen(true);
    hoursGroup.setWidth("100%");
    f_HTMLPanel24.setStyleName("form-with-shadow");
    expensesGroup.add(f_HTMLPanel27);
    expensesGroup.setOpen(true);
    expensesGroup.setWidth("100%");
    f_HTMLPanel26.setStyleName("form-with-shadow");
    btSave.setHTML(template.html14(SafeHtmlUtils.fromSafeConstant(messages.message24())).asString());
    f_HorizontalPanel28.add(btSave);
    btGenerateInvoice.setHTML(template.html15(SafeHtmlUtils.fromSafeConstant(messages.message25())).asString());
    f_HorizontalPanel28.add(btGenerateInvoice);
    btGenerateEstimate.setHTML(template.html16(SafeHtmlUtils.fromSafeConstant(messages.message26())).asString());
    f_HorizontalPanel28.add(btGenerateEstimate);
    btConvert.setHTML(template.html17(SafeHtmlUtils.fromSafeConstant(messages.message27())).asString());
    f_HorizontalPanel28.add(btConvert);
    btCancel.setHTML(template.html18(SafeHtmlUtils.fromSafeConstant(messages.message28())).asString());
    f_HorizontalPanel28.add(btCancel);
    f_HorizontalPanel28.setStyleName("buttonsPanel");
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
    f_HTMLPanel2.addAndReplaceElement(sbClient, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(cbState, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(lastBilled, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label8, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(created, domId13Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label9, domId14Element);
    f_HTMLPanel2.addAndReplaceElement(cbCurrency, domId15Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label10, domId16Element);
    f_HTMLPanel2.addAndReplaceElement(valuationLabel, domId17Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label11, domId18Element);
    f_HTMLPanel2.addAndReplaceElement(totalTime, domId19Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label12, domId20Element);
    f_HTMLPanel2.addAndReplaceElement(billableTime, domId21Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
    com.google.gwt.user.client.Element domId23Element = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    billingFlatRateRow = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    billingFlatRateRow.removeAttribute("id");
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    com.google.gwt.user.client.Element domId26Element = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    billingRateRow = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    billingRateRow.removeAttribute("id");
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    com.google.gwt.user.client.Element domId30Element = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    com.google.gwt.user.client.Element domId31Element = com.google.gwt.dom.client.Document.get().getElementById(domId31).cast();
    attachRecord2.detach();
    f_HTMLPanel13.addAndReplaceElement(billingMethod, domId23Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label14, domId25Element);
    f_HTMLPanel13.addAndReplaceElement(billingFlatRate, domId26Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label15, domId28Element);
    f_HTMLPanel13.addAndReplaceElement(billingRate, domId29Element);
    f_HTMLPanel13.addAndReplaceElement(f_Label16, domId30Element);
    f_HTMLPanel13.addAndReplaceElement(timeUnit, domId31Element);
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_HTMLPanel17.getElement());
    UiBinderUtil.TempAttachment attachRecord4 = UiBinderUtil.attachToDom(f_HTMLPanel18.getElement());
    com.google.gwt.user.client.Element domId34Element = com.google.gwt.dom.client.Document.get().getElementById(domId34).cast();
    com.google.gwt.user.client.Element domId35Element = com.google.gwt.dom.client.Document.get().getElementById(domId35).cast();
    attachRecord4.detach();
    f_HTMLPanel18.addAndReplaceElement(projectTasksDetailsTable, domId34Element);
    f_HTMLPanel18.addAndReplaceElement(btAddTask, domId35Element);
    com.google.gwt.user.client.Element domId33Element = com.google.gwt.dom.client.Document.get().getElementById(domId33).cast();
    attachRecord3.detach();
    f_HTMLPanel17.addAndReplaceElement(taskGroup, domId33Element);
    com.google.gwt.user.client.Element domId32Element = com.google.gwt.dom.client.Document.get().getElementById(domId32).cast();
    UiBinderUtil.TempAttachment attachRecord5 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
    UiBinderUtil.TempAttachment attachRecord6 = UiBinderUtil.attachToDom(f_HTMLPanel20.getElement());
    com.google.gwt.user.client.Element domId38Element = com.google.gwt.dom.client.Document.get().getElementById(domId38).cast();
    com.google.gwt.user.client.Element domId39Element = com.google.gwt.dom.client.Document.get().getElementById(domId39).cast();
    attachRecord6.detach();
    f_HTMLPanel20.addAndReplaceElement(projectStaffDetailsTable, domId38Element);
    f_HTMLPanel20.addAndReplaceElement(btAddStaff, domId39Element);
    com.google.gwt.user.client.Element domId37Element = com.google.gwt.dom.client.Document.get().getElementById(domId37).cast();
    attachRecord5.detach();
    f_HTMLPanel19.addAndReplaceElement(staffGroup, domId37Element);
    com.google.gwt.user.client.Element domId36Element = com.google.gwt.dom.client.Document.get().getElementById(domId36).cast();
    UiBinderUtil.TempAttachment attachRecord7 = UiBinderUtil.attachToDom(f_HTMLPanel21.getElement());
    com.google.gwt.user.client.Element domId41Element = com.google.gwt.dom.client.Document.get().getElementById(domId41).cast();
    com.google.gwt.user.client.Element domId42Element = com.google.gwt.dom.client.Document.get().getElementById(domId42).cast();
    com.google.gwt.user.client.Element domId43Element = com.google.gwt.dom.client.Document.get().getElementById(domId43).cast();
    com.google.gwt.user.client.Element domId44Element = com.google.gwt.dom.client.Document.get().getElementById(domId44).cast();
    attachRecord7.detach();
    f_HTMLPanel21.addAndReplaceElement(f_Label22, domId41Element);
    f_HTMLPanel21.addAndReplaceElement(from, domId42Element);
    f_HTMLPanel21.addAndReplaceElement(f_Label23, domId43Element);
    f_HTMLPanel21.addAndReplaceElement(to, domId44Element);
    com.google.gwt.user.client.Element domId40Element = com.google.gwt.dom.client.Document.get().getElementById(domId40).cast();
    UiBinderUtil.TempAttachment attachRecord8 = UiBinderUtil.attachToDom(f_HTMLPanel24.getElement());
    UiBinderUtil.TempAttachment attachRecord9 = UiBinderUtil.attachToDom(f_HTMLPanel25.getElement());
    com.google.gwt.user.client.Element domId47Element = com.google.gwt.dom.client.Document.get().getElementById(domId47).cast();
    attachRecord9.detach();
    f_HTMLPanel25.addAndReplaceElement(timeEntriesTable, domId47Element);
    com.google.gwt.user.client.Element domId46Element = com.google.gwt.dom.client.Document.get().getElementById(domId46).cast();
    attachRecord8.detach();
    f_HTMLPanel24.addAndReplaceElement(hoursGroup, domId46Element);
    com.google.gwt.user.client.Element domId45Element = com.google.gwt.dom.client.Document.get().getElementById(domId45).cast();
    UiBinderUtil.TempAttachment attachRecord10 = UiBinderUtil.attachToDom(f_HTMLPanel26.getElement());
    UiBinderUtil.TempAttachment attachRecord11 = UiBinderUtil.attachToDom(f_HTMLPanel27.getElement());
    com.google.gwt.user.client.Element domId50Element = com.google.gwt.dom.client.Document.get().getElementById(domId50).cast();
    attachRecord11.detach();
    f_HTMLPanel27.addAndReplaceElement(expensesTable, domId50Element);
    com.google.gwt.user.client.Element domId49Element = com.google.gwt.dom.client.Document.get().getElementById(domId49).cast();
    attachRecord10.detach();
    f_HTMLPanel26.addAndReplaceElement(expensesGroup, domId49Element);
    com.google.gwt.user.client.Element domId48Element = com.google.gwt.dom.client.Document.get().getElementById(domId48).cast();
    com.google.gwt.user.client.Element domId51Element = com.google.gwt.dom.client.Document.get().getElementById(domId51).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel13, domId22Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel17, domId32Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel19, domId36Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel21, domId40Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel24, domId45Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel26, domId48Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel28, domId51Element);


    owner.billableTime = billableTime;
    owner.billingFlatRate = billingFlatRate;
    owner.billingFlatRateRow = billingFlatRateRow;
    owner.billingMethod = billingMethod;
    owner.billingRate = billingRate;
    owner.billingRateRow = billingRateRow;
    owner.btAddStaff = btAddStaff;
    owner.btAddTask = btAddTask;
    owner.btCancel = btCancel;
    owner.btConvert = btConvert;
    owner.btGenerateEstimate = btGenerateEstimate;
    owner.btGenerateInvoice = btGenerateInvoice;
    owner.btSave = btSave;
    owner.cbCurrency = cbCurrency;
    owner.cbState = cbState;
    owner.created = created;
    owner.description = description;
    owner.errorsPanel = errorsPanel;
    owner.expensesGroup = expensesGroup;
    owner.expensesTable = expensesTable;
    owner.from = from;
    owner.hoursGroup = hoursGroup;
    owner.lastBilled = lastBilled;
    owner.name = name;
    owner.staffGroup = staffGroup;
    owner.taskGroup = taskGroup;
    owner.timeEntriesTable = timeEntriesTable;
    owner.timeUnit = timeUnit;
    owner.to = to;
    owner.totalTime = totalTime;
    owner.valuationLabel = valuationLabel;

    return f_HTMLPanel1;
  }
}
