package com.numhero.client.widget.filter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class FilterPanel_ExpenseUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.widget.filter.FilterPanel>, com.numhero.client.widget.filter.FilterPanel.ExpenseUiBinder {
  static FilterPanelExpenseUiBinderImplGenMessages messages = (FilterPanelExpenseUiBinderImplGenMessages) GWT.create(FilterPanelExpenseUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label'> <span id='{1}'></span> </td> <td class='formItem'> <span id='{2}'></span> </td> <td class='form-item-label'> <span id='{3}'></span> </td> <td class='formItem'> <span id='{4}'></span> </td> <td class='form-item-label'> <span id='{5}'></span> </td> <td class='formItem'> <span id='{6}'></span> </td> <td></td> <td align='RIGHT' class='formItem'> <span id='{7}'></span> </td> </tr> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td class='form-item-label'> <span id='{8}'></span> </td> <td class='formItem'> <span id='{9}'></span> </td> <td class='form-item-label'> <span id='{10}'></span> </td> <td class='formItem'> <span id='{11}'></span> </td> <td class='form-item-label'> <span id='{12}'></span> </td> <td class='formItem'> <span id='{13}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(SafeHtml arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.widget.filter.FilterPanel owner) {

    com.numhero.client.widget.filter.FilterPanel_ExpenseUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.filter.FilterPanel_ExpenseUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.filter.FilterPanel_ExpenseUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox from = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.CustomFormatDateBox to = (com.numhero.client.widget.CustomFormatDateBox) GWT.create(com.numhero.client.widget.CustomFormatDateBox.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label clientLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.clientsupplier.ClientSelect sbClient = owner.sbClient;
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btFilter = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label staffLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.staff.StaffSelect sbStaff = owner.sbStaff;
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label projectLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.project.ProjectSelect sbProject = owner.sbProject;
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label taskLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.task.TaskSelect sbTask = owner.sbTask;
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId0, domId1, domId2, domId3, domId4, domId5, domId6, domId7, domId8, domId9, domId10, domId11, domId12).asString());

    f_Label2.setText("" + messages.message2() + "");
    f_Label3.setText("" + messages.message3() + "");
    clientLabel.setText("" + messages.message4() + "");
    btFilter.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message5())).asString());
    staffLabel.setText("" + messages.message6() + "");
    projectLabel.setText("" + messages.message7() + "");
    taskLabel.setText("" + messages.message8() + "");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
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
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_Label2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(from, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_Label3, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(to, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(clientLabel, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(sbClient, domId5Element);
    f_HTMLPanel1.addAndReplaceElement(btFilter, domId6Element);
    f_HTMLPanel1.addAndReplaceElement(staffLabel, domId7Element);
    f_HTMLPanel1.addAndReplaceElement(sbStaff, domId8Element);
    f_HTMLPanel1.addAndReplaceElement(projectLabel, domId9Element);
    f_HTMLPanel1.addAndReplaceElement(sbProject, domId10Element);
    f_HTMLPanel1.addAndReplaceElement(taskLabel, domId11Element);
    f_HTMLPanel1.addAndReplaceElement(sbTask, domId12Element);


    owner.btFilter = btFilter;
    owner.clientLabel = clientLabel;
    owner.from = from;
    owner.projectLabel = projectLabel;
    owner.staffLabel = staffLabel;
    owner.taskLabel = taskLabel;
    owner.to = to;

    return f_HTMLPanel1;
  }
}
