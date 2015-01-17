package com.numhero.client.mvp.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class HomePanel_HomePanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.home.HomePanel>, com.numhero.client.mvp.home.HomePanel.HomePanelUiBinder {
  static HomePanelHomePanelUiBinderImplGenMessages messages = (HomePanelHomePanelUiBinderImplGenMessages) GWT.create(HomePanelHomePanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <p> {1} </p>")
    SafeHtml html2(String arg0, SafeHtml arg1);
     
    @Template("")
    SafeHtml html3();
     
    @Template("I would like to...")
    SafeHtml html4();
     
    @Template("{0}")
    SafeHtml html5(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html6(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html7(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html8(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html9(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html10(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html11(String arg0, String arg1, String arg2);
     
    @Template("{0}")
    SafeHtml html12(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html13(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html14(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html15(String arg0, String arg1, String arg2);
     
    @Template("{0}")
    SafeHtml html16(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html17(SafeHtml arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.home.HomePanel owner) {

    com.numhero.client.mvp.home.HomePanel_HomePanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.home.HomePanel_HomePanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.home.HomePanel_HomePanelUiBinderImpl_GenBundle.class);
    com.numhero.client.mvp.home.HomePanel_HomePanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelOne f_TitleLevelOne6 = (com.numhero.client.widget.TitleLevelOne) GWT.create(com.numhero.client.widget.TitleLevelOne.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0, SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel4 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template.html3().asString());
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel7 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.TitleLevelTwo f_TitleLevelTwo11 = (com.numhero.client.widget.TitleLevelTwo) GWT.create(com.numhero.client.widget.TitleLevelTwo.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.NetNumeroButton btNewInvoice = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btNewEstimate = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel12 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.NetNumeroButton btTimeTrack = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.numhero.client.widget.NetNumeroButton btNewReport = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel13 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel9 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.DividerLine f_DividerLine15 = (com.numhero.client.widget.DividerLine) GWT.create(com.numhero.client.widget.DividerLine.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel14 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelOne f_TitleLevelOne20 = (com.numhero.client.widget.TitleLevelOne) GWT.create(com.numhero.client.widget.TitleLevelOne.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree21 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label22 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template.html11(domId1, domId2, domId3).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel18 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree24 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    com.numhero.client.mvp.home.InvoicesRecapTable invoicesRecapPanel = (com.numhero.client.mvp.home.InvoicesRecapTable) GWT.create(com.numhero.client.mvp.home.InvoicesRecapTable.class);
    com.numhero.client.widget.DividerLine f_DividerLine26 = (com.numhero.client.widget.DividerLine) GWT.create(com.numhero.client.widget.DividerLine.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel25 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel23 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelOne f_TitleLevelOne29 = (com.numhero.client.widget.TitleLevelOne) GWT.create(com.numhero.client.widget.TitleLevelOne.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree30 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label31 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel28 = new com.google.gwt.user.client.ui.HTMLPanel(template.html15(domId4, domId5, domId6).asString());
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel27 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.TitleLevelThree f_TitleLevelThree33 = (com.numhero.client.widget.TitleLevelThree) GWT.create(com.numhero.client.widget.TitleLevelThree.class);
    com.numhero.client.mvp.home.ExpensesRecapTable expensesRecapPanel = (com.numhero.client.mvp.home.ExpensesRecapTable) GWT.create(com.numhero.client.mvp.home.ExpensesRecapTable.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel32 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel17 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.numhero.client.widget.TitleLevelOne f_TitleLevelOne35 = (com.numhero.client.widget.TitleLevelOne) GWT.create(com.numhero.client.widget.TitleLevelOne.class);
    com.numhero.client.mvp.home.HomeRecentTransactionsTable homeRecentTransactionsTable = (com.numhero.client.mvp.home.HomeRecentTransactionsTable) GWT.create(com.numhero.client.mvp.home.HomeRecentTransactionsTable.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel34 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel16 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.numhero.client.widget.DividerLine f_DividerLine37 = (com.numhero.client.widget.DividerLine) GWT.create(com.numhero.client.widget.DividerLine.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel36 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_TitleLevelOne6.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message1())).asString());
    f_VerticalPanel4.add(f_HTMLPanel5);
    f_VerticalPanel4.setWidth("100%");
    f_HorizontalPanel3.add(f_VerticalPanel4);
    f_VerticalPanel7.add(f_HTMLPanel8);
    f_VerticalPanel7.setWidth("100%");
    f_HorizontalPanel3.add(f_VerticalPanel7);
    f_HorizontalPanel3.setStyleName("dashboard-title-box");
    f_HorizontalPanel3.setWidth("100%");
    f_HorizontalPanel2.add(f_HorizontalPanel3);
    f_TitleLevelTwo11.setHTML(template.html4().asString());
    f_HorizontalPanel10.add(f_TitleLevelTwo11);
    f_HorizontalPanel10.setStyleName("dashboard-buttons-title");
    f_VerticalPanel9.add(f_HorizontalPanel10);
    btNewInvoice.setHTML(template.html5(SafeHtmlUtils.fromSafeConstant(messages.message3())).asString());
    btNewInvoice.setHref("#invoice");
    f_HorizontalPanel12.add(btNewInvoice);
    f_HorizontalPanel12.setCellWidth(btNewInvoice, "190px");
    btNewEstimate.setHTML(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message4())).asString());
    btNewEstimate.setHref("#estimate");
    f_HorizontalPanel12.add(btNewEstimate);
    f_HorizontalPanel12.setCellWidth(btNewEstimate, "190px");
    f_HorizontalPanel12.setStyleName("home-buttons-container");
    f_VerticalPanel9.add(f_HorizontalPanel12);
    btTimeTrack.setHTML(template.html7(SafeHtmlUtils.fromSafeConstant(messages.message5())).asString());
    btTimeTrack.setHref("#projects");
    f_HorizontalPanel13.add(btTimeTrack);
    f_HorizontalPanel13.setCellWidth(btTimeTrack, "190px");
    btNewReport.setHTML(template.html8(SafeHtmlUtils.fromSafeConstant(messages.message6())).asString());
    btNewReport.setHref("#report");
    f_HorizontalPanel13.add(btNewReport);
    f_HorizontalPanel13.setCellWidth(btNewReport, "190px");
    f_HorizontalPanel13.setStyleName("home-buttons-container");
    f_VerticalPanel9.add(f_HorizontalPanel13);
    f_VerticalPanel9.setStyleName("dashboard-buttons");
    f_VerticalPanel9.setWidth("400px");
    f_HorizontalPanel2.add(f_VerticalPanel9);
    f_HorizontalPanel2.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel2);
    f_HorizontalPanel14.add(f_DividerLine15);
    f_HorizontalPanel14.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel14);
    f_TitleLevelOne20.setHTML(template.html9(SafeHtmlUtils.fromSafeConstant(messages.message7())).asString());
    f_TitleLevelThree21.setHTML(template.html10(SafeHtmlUtils.fromSafeConstant(messages.message8())).asString());
    f_Label22.setText("" + messages.message9() + "");
    f_Label22.setStyleName("text-label");
    f_HorizontalPanel18.add(f_HTMLPanel19);
    f_VerticalPanel17.add(f_HorizontalPanel18);
    f_TitleLevelThree24.setHTML(template.html12(SafeHtmlUtils.fromSafeConstant(messages.message10())).asString());
    f_VerticalPanel23.add(f_TitleLevelThree24);
    f_VerticalPanel23.add(invoicesRecapPanel);
    f_HorizontalPanel25.add(f_DividerLine26);
    f_HorizontalPanel25.setWidth("100%");
    f_VerticalPanel23.add(f_HorizontalPanel25);
    f_VerticalPanel23.setStyleName("dashboard-moneyin-table");
    f_VerticalPanel23.setHeight("100%");
    f_VerticalPanel23.setWidth("100%");
    f_VerticalPanel17.add(f_VerticalPanel23);
    f_TitleLevelOne29.setHTML(template.html13(SafeHtmlUtils.fromSafeConstant(messages.message11())).asString());
    f_TitleLevelThree30.setHTML(template.html14(SafeHtmlUtils.fromSafeConstant(messages.message12())).asString());
    f_Label31.setText("" + messages.message13() + "");
    f_Label31.setStyleName("text-label");
    f_HorizontalPanel27.add(f_HTMLPanel28);
    f_VerticalPanel17.add(f_HorizontalPanel27);
    f_TitleLevelThree33.setHTML(template.html16(SafeHtmlUtils.fromSafeConstant(messages.message14())).asString());
    f_VerticalPanel32.add(f_TitleLevelThree33);
    f_VerticalPanel32.add(expensesRecapPanel);
    f_VerticalPanel32.setStyleName("dashboard-moneyout-table");
    f_VerticalPanel32.setWidth("100%");
    f_VerticalPanel17.add(f_VerticalPanel32);
    f_VerticalPanel17.setStyleName("dashboard-tables");
    f_VerticalPanel17.setWidth("100%");
    f_HorizontalPanel16.add(f_VerticalPanel17);
    f_TitleLevelOne35.setHTML(template.html17(SafeHtmlUtils.fromSafeConstant(messages.message15())).asString());
    f_VerticalPanel34.add(f_TitleLevelOne35);
    f_VerticalPanel34.add(homeRecentTransactionsTable);
    f_VerticalPanel34.setStyleName("dashboard-recent-activity");
    f_VerticalPanel34.setHeight("100%");
    f_VerticalPanel34.setWidth("100%");
    f_HorizontalPanel16.add(f_VerticalPanel34);
    f_HorizontalPanel16.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel16);
    f_HorizontalPanel36.add(f_DividerLine37);
    f_HorizontalPanel36.setWidth("100%");
    f_VerticalPanel1.add(f_HorizontalPanel36);

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel5.addAndReplaceElement(f_TitleLevelOne6, domId0Element);
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    attachRecord1.detach();
    f_HTMLPanel19.addAndReplaceElement(f_TitleLevelOne20, domId1Element);
    f_HTMLPanel19.addAndReplaceElement(f_TitleLevelThree21, domId2Element);
    f_HTMLPanel19.addAndReplaceElement(f_Label22, domId3Element);
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel28.getElement());
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    attachRecord2.detach();
    f_HTMLPanel28.addAndReplaceElement(f_TitleLevelOne29, domId4Element);
    f_HTMLPanel28.addAndReplaceElement(f_TitleLevelThree30, domId5Element);
    f_HTMLPanel28.addAndReplaceElement(f_Label31, domId6Element);


    owner.btNewEstimate = btNewEstimate;
    owner.btNewInvoice = btNewInvoice;
    owner.btNewReport = btNewReport;
    owner.btTimeTrack = btTimeTrack;
    owner.expensesRecapPanel = expensesRecapPanel;
    owner.homeRecentTransactionsTable = homeRecentTransactionsTable;
    owner.invoicesRecapPanel = invoicesRecapPanel;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
