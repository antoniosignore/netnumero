package com.numhero.client.mvp.moneyout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoneyOutPanel_MoneyoutPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.moneyout.MoneyOutPanel>, com.numhero.client.mvp.moneyout.MoneyOutPanel.MoneyoutPanelUiBinder {
  static MoneyOutPanelMoneyoutPanelUiBinderImplGenMessages messages = (MoneyOutPanelMoneyoutPanelUiBinderImplGenMessages) GWT.create(MoneyOutPanelMoneyoutPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("<div class='sub-container'> <div class='left-panel'> <span id='{0}'></span> <span id='{1}'></span> <hr> </div> <div class='right-panel'> <span id='{2}'></span> <p class='inh-standard'>Monthly summary</p> <span id='{3}'></span> </div> </div>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.moneyout.MoneyOutPanel owner) {

    com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.moneyout.MoneyOutPanel_MoneyoutPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelTwo f_TitleLevelTwo2 = (com.numhero.client.widget.TitleLevelTwo) GWT.create(com.numhero.client.widget.TitleLevelTwo.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.home.ExpensesRecapTable invoicesTable = (com.numhero.client.mvp.home.ExpensesRecapTable) GWT.create(com.numhero.client.mvp.home.ExpensesRecapTable.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree3 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.mvp.moneyout.MoneyOutSummaryTable moneyOutSummaryTable = (com.numhero.client.mvp.moneyout.MoneyOutSummaryTable) GWT.create(com.numhero.client.mvp.moneyout.MoneyOutSummaryTable.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3(domId0, domId1, domId2, domId3).asString());

    f_TitleLevelTwo2.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    f_TitleLevelThree3.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_TitleLevelTwo2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(invoicesTable, domId1Element);
    f_HTMLPanel1.addAndReplaceElement(f_TitleLevelThree3, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(moneyOutSummaryTable, domId3Element);


    owner.invoicesTable = invoicesTable;
    owner.moneyOutSummaryTable = moneyOutSummaryTable;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
