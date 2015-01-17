package com.numhero.client.mvp.report.recentTransactions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class RecentTransactionsPanel_RecentTransactionsUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel>, com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel.RecentTransactionsUiBinder {
  static RecentTransactionsPanelRecentTransactionsUiBinderImplGenMessages messages = (RecentTransactionsPanelRecentTransactionsUiBinderImplGenMessages) GWT.create(RecentTransactionsPanelRecentTransactionsUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> {0} </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td colspan='14'> <span id='{1}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html1(SafeHtml arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel owner) {

    com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel_RecentTransactionsUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel_RecentTransactionsUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.report.recentTransactions.RecentTransactionsPanel_RecentTransactionsUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.report.recentTransactions.RecentTransactionsTable recentTransactionsTable = (com.numhero.client.mvp.report.recentTransactions.RecentTransactionsTable) GWT.create(com.numhero.client.mvp.report.recentTransactions.RecentTransactionsTable.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());

    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(recentTransactionsTable, domId1Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);


    owner.recentTransactionsTable = recentTransactionsTable;

    return f_HTMLPanel1;
  }
}
