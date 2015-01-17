package com.numhero.client.mvp.task;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanel_TaskUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.task.TaskPanel>, com.numhero.client.mvp.task.TaskPanel.TaskUiBinder {
  static TaskPanelTaskUiBinderImplGenMessages messages = (TaskPanelTaskUiBinderImplGenMessages) GWT.create(TaskPanelTaskUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> {0} </td> </tr> </thead> <tbody> <tr> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{7}'></span> </td> <td class='formItem'> <span id='{8}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{9}'></span> </td> <td class='formItem'> <span id='{10}'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='{11}'></span> </td> <td class='formItem'> <span id='{12}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.task.TaskPanel owner) {

    com.numhero.client.mvp.task.TaskPanel_TaskUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.task.TaskPanel_TaskUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.task.TaskPanel_TaskUiBinderImpl_GenBundle.class);
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
    com.numhero.client.widget.combobox.CurrencySelect cbCurrency = (com.numhero.client.widget.combobox.CurrencySelect) GWT.create(com.numhero.client.widget.combobox.CurrencySelect.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.combobox.TimeUnitComboBox timeUnit = (com.numhero.client.widget.combobox.TimeUnitComboBox) GWT.create(com.numhero.client.widget.combobox.TimeUnitComboBox.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.textbox.NumberTextBox billingRate = (com.numhero.client.widget.textbox.NumberTextBox) GWT.create(com.numhero.client.widget.textbox.NumberTextBox.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.CheckBox billable = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12, domId13).asString());
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSave = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel9 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0, domId1, domId14).asString());

    errorsPanel.setStyleName("validation-advice");
    f_Label3.setText("" + messages.message2() + "");
    f_Label4.setText("" + messages.message3() + "");
    f_Label5.setText("" + messages.message4() + "");
    f_Label6.setText("" + messages.message5() + "");
    f_Label7.setText("" + messages.message6() + "");
    f_Label8.setText("" + messages.message7() + "");
    f_HTMLPanel2.setStyleName("form-with-shadow");
    btSave.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message8())).asString());
    f_HorizontalPanel9.add(btSave);
    btCancel.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message9())).asString());
    f_HorizontalPanel9.add(btCancel);
    f_HorizontalPanel9.setStyleName("buttonsPanel");
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
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_Label3, domId2Element);
    f_HTMLPanel2.addAndReplaceElement(name, domId3Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label4, domId4Element);
    f_HTMLPanel2.addAndReplaceElement(description, domId5Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label5, domId6Element);
    f_HTMLPanel2.addAndReplaceElement(cbCurrency, domId7Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label6, domId8Element);
    f_HTMLPanel2.addAndReplaceElement(timeUnit, domId9Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label7, domId10Element);
    f_HTMLPanel2.addAndReplaceElement(billingRate, domId11Element);
    f_HTMLPanel2.addAndReplaceElement(f_Label8, domId12Element);
    f_HTMLPanel2.addAndReplaceElement(billable, domId13Element);
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId14Element = com.google.gwt.dom.client.Document.get().getElementById(domId14).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(errorsPanel, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel9, domId14Element);


    owner.billable = billable;
    owner.billingRate = billingRate;
    owner.btCancel = btCancel;
    owner.btSave = btSave;
    owner.cbCurrency = cbCurrency;
    owner.description = description;
    owner.errorsPanel = errorsPanel;
    owner.name = name;
    owner.timeUnit = timeUnit;

    return f_HTMLPanel1;
  }
}
