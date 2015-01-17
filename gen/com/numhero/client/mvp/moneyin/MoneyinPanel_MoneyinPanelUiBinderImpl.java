package com.numhero.client.mvp.moneyin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoneyinPanel_MoneyinPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.moneyin.MoneyinPanel>, com.numhero.client.mvp.moneyin.MoneyinPanel.MoneyinPanelUiBinder {
  static MoneyinPanelMoneyinPanelUiBinderImplGenMessages messages = (MoneyinPanelMoneyinPanelUiBinderImplGenMessages) GWT.create(MoneyinPanelMoneyinPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("<div class='sub-container'> <div class='left-panel'> <span id='{0}'></span> <span id='{1}'></span> <hr> <span id='{2}'></span> <span id='{3}'></span> </div> <div class='right-panel'> <span id='{4}'></span> <p class='inh-standard'>Monthly summary</p> <span id='{5}'></span> </div> </div>")
    SafeHtml html4(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.moneyin.MoneyinPanel owner) {

    com.numhero.client.mvp.moneyin.MoneyinPanel_MoneyinPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.moneyin.MoneyinPanel_MoneyinPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.moneyin.MoneyinPanel_MoneyinPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.moneyin.MoneyinPanel_MoneyinPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelTwo f_TitleLevelTwo2 = (com.numhero.client.widget.TitleLevelTwo) GWT.create(com.numhero.client.widget.TitleLevelTwo.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.home.InvoicesRecapTable invoicesTable = (com.numhero.client.mvp.home.InvoicesRecapTable) GWT.create(com.numhero.client.mvp.home.InvoicesRecapTable.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelTwo f_TitleLevelTwo3 = (com.numhero.client.widget.TitleLevelTwo) GWT.create(com.numhero.client.widget.TitleLevelTwo.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.home.InvoicesRecapTable estimatesTable = (com.numhero.client.mvp.home.InvoicesRecapTable) GWT.create(com.numhero.client.mvp.home.InvoicesRecapTable.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree4 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.moneyin.MoneyInSummaryTable moneyInSummaryTable = (com.numhero.client.mvp.moneyin.MoneyInSummaryTable) GWT.create(com.numhero.client.mvp.moneyin.MoneyInSummaryTable.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0, domId1, domId2, domId3, domId4, domId5).asString());

    f_TitleLevelTwo2.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    f_TitleLevelTwo3.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());
    f_TitleLevelThree4.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message3())).asString());

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_TitleLevelTwo2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(invoicesTable, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_TitleLevelTwo3, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(estimatesTable, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(f_TitleLevelThree4, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(moneyInSummaryTable, domId5Element);


    owner.estimatesTable = estimatesTable;
    owner.invoicesTable = invoicesTable;
    owner.moneyInSummaryTable = moneyInSummaryTable;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
