package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TabBar_HeaderUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.TabBar>, com.numhero.client.widget.TabBar.HeaderUiBinder {
  static TabBarHeaderUiBinderImplGenMessages messages = (TabBarHeaderUiBinderImplGenMessages) GWT.create(TabBarHeaderUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html2(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html4(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html5(SafeHtml arg0);
     
    @Template("{0}")
    SafeHtml html6(SafeHtml arg0);
     
    @Template("<ul class='first-level'> <li id='{0}'> <a class='inh-tab' href='#dashboard'> <span> {1} </span> </a> </li> <li id='{2}'> <a class='inh-tab' href='#moneyin'> <span> {3} </span> </a> <ul class='second-level moneyin-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {4} </h1> <p> {5} </p> <span id='{6}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {7} </h3> <span id='{8}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {9} </h3> <span id='{10}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {11} </h3> <span id='{12}'></span> </div> </div> </li> </ul> </li> <li id='{13}'> <a class='inh-tab' href='#moneyout'> <span> {14} </span> </a> <ul class='second-level moneyout-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {15} </h1> <p> {16} </p> <span id='{17}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {18} </h3> <span id='{19}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {20} </h3> <span id='{21}'></span> </div> </div> </li> </ul> </li> <li id='{22}'> <a class='inh-tab' href='#clients'> <span> {23} </span> </a> <ul class='second-level clients-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {24} </h1> <p> {25} </p> <span id='{26}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {27} </h3> <span id='{28}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {29} </h3> <span id='{30}'></span> </div> </div> </li> </ul> </li> <li id='{31}'> <a class='inh-tab' href='#staff'> <span> {32} </span> </a> <ul class='second-level staff-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {33} </h1> <p> {34} </p> <span id='{35}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {36} </h3> <span id='{37}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {38} </h3> <span id='{39}'></span> </div> </div> </li> </ul> </li> <li id='{40}'> <a class='inh-tab' href='#projects'> <span> {41} </span> </a> <ul class='second-level time-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {42} </h1> <p> {43} </p> <span id='{44}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {45} </h3> <span id='{46}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {47} </h3> <span id='{48}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {49} </h3> <span id='{50}'></span> </div> </div> </li> </ul> </li> <li id='{51}'> <a class='inh-tab' href='#nominalLedgerAccounts'> <span> {52} </span> </a> <ul class='second-level nominalLedgerAccounts-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {53} </h1> <p> {54} </p> <span id='{55}'></span> </div> </div> <div class='cell'> <h3 class='inh-menu'> {56} </h3> <span id='{57}'></span> </div> </div> </li> </ul> </li> <li id='{58}'> <a class='inh-tab' href='#reports'> <span> {59} </span> </a> <ul class='second-level reports-menu'> <li> <div class='menu-sub'> <div class='cell'> <div class='border-panel'> <h1 class='inh-menu'> {60} </h1> <p> {61} </p>  </div> </div> <div class='cell'> <h3 class='inh-menu'> {62} </h3> <span id='{63}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {64} </h3> <span id='{65}'></span> </div> <div class='cell'> <h3 class='inh-menu'> {66} </h3> <span id='{67}'></span> </div> </div> </li> </ul> </li> <li id='{68}'> <a class='inh-tab' href='#search'> <span> {69} </span> </a> </li> </ul>")
    SafeHtml html7(String arg0, SafeHtml arg1, String arg2, SafeHtml arg3, SafeHtml arg4, SafeHtml arg5, String arg6, SafeHtml arg7, String arg8, SafeHtml arg9, String arg10, SafeHtml arg11, String arg12, String arg13, SafeHtml arg14, SafeHtml arg15, SafeHtml arg16, String arg17, SafeHtml arg18, String arg19, SafeHtml arg20, String arg21, String arg22, SafeHtml arg23, SafeHtml arg24, SafeHtml arg25, String arg26, SafeHtml arg27, String arg28, SafeHtml arg29, String arg30, String arg31, SafeHtml arg32, SafeHtml arg33, SafeHtml arg34, String arg35, SafeHtml arg36, String arg37, SafeHtml arg38, String arg39, String arg40, SafeHtml arg41, SafeHtml arg42, SafeHtml arg43, String arg44, SafeHtml arg45, String arg46, SafeHtml arg47, String arg48, SafeHtml arg49, String arg50, String arg51, SafeHtml arg52, SafeHtml arg53, SafeHtml arg54, String arg55, SafeHtml arg56, String arg57, String arg58, SafeHtml arg59, SafeHtml arg60, SafeHtml arg61, SafeHtml arg62, String arg63, SafeHtml arg64, String arg65, SafeHtml arg66, String arg67, String arg68, SafeHtml arg69);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.TabBar owner) {

    com.numhero.client.widget.TabBar_HeaderUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.TabBar_HeaderUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.TabBar_HeaderUiBinderImpl_GenBundle.class);
    com.google.gwt.dom.client.LIElement dashboard = null;
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.dom.client.LIElement moneyin = null;
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton2 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.InvoicesSubmenu f_InvoicesSubmenu3 = (com.numhero.client.widget.submenu.InvoicesSubmenu) GWT.create(com.numhero.client.widget.submenu.InvoicesSubmenu.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.EstimatesSubmenu f_EstimatesSubmenu4 = (com.numhero.client.widget.submenu.EstimatesSubmenu) GWT.create(com.numhero.client.widget.submenu.EstimatesSubmenu.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ItemsSubmenu f_ItemsSubmenu5 = (com.numhero.client.widget.submenu.ItemsSubmenu) GWT.create(com.numhero.client.widget.submenu.ItemsSubmenu.class);
    com.google.gwt.dom.client.LIElement moneyout = null;
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton6 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ExpensesSubmenu f_ExpensesSubmenu7 = (com.numhero.client.widget.submenu.ExpensesSubmenu) GWT.create(com.numhero.client.widget.submenu.ExpensesSubmenu.class);
    java.lang.String domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.TaxesSubmenu f_TaxesSubmenu8 = (com.numhero.client.widget.submenu.TaxesSubmenu) GWT.create(com.numhero.client.widget.submenu.TaxesSubmenu.class);
    com.google.gwt.dom.client.LIElement clients = null;
    java.lang.String domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton9 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ClientsSubmenu f_ClientsSubmenu10 = (com.numhero.client.widget.submenu.ClientsSubmenu) GWT.create(com.numhero.client.widget.submenu.ClientsSubmenu.class);
    java.lang.String domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.SuppliersSubmenu f_SuppliersSubmenu11 = (com.numhero.client.widget.submenu.SuppliersSubmenu) GWT.create(com.numhero.client.widget.submenu.SuppliersSubmenu.class);
    com.google.gwt.dom.client.LIElement staff = null;
    java.lang.String domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton12 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.InternalStaffSubmenu f_InternalStaffSubmenu13 = (com.numhero.client.widget.submenu.InternalStaffSubmenu) GWT.create(com.numhero.client.widget.submenu.InternalStaffSubmenu.class);
    java.lang.String domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ContractorsSubmenu f_ContractorsSubmenu14 = (com.numhero.client.widget.submenu.ContractorsSubmenu) GWT.create(com.numhero.client.widget.submenu.ContractorsSubmenu.class);
    com.google.gwt.dom.client.LIElement time = null;
    java.lang.String domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton15 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.TrackTimeSubmenu f_TrackTimeSubmenu16 = (com.numhero.client.widget.submenu.TrackTimeSubmenu) GWT.create(com.numhero.client.widget.submenu.TrackTimeSubmenu.class);
    java.lang.String domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.ProjectsSubmenu f_ProjectsSubmenu17 = (com.numhero.client.widget.submenu.ProjectsSubmenu) GWT.create(com.numhero.client.widget.submenu.ProjectsSubmenu.class);
    java.lang.String domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.TasksSubmenu f_TasksSubmenu18 = (com.numhero.client.widget.submenu.TasksSubmenu) GWT.create(com.numhero.client.widget.submenu.TasksSubmenu.class);
    com.google.gwt.dom.client.LIElement accounts = null;
    java.lang.String domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton f_NetNumeroButton19 = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    java.lang.String domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.GeneralAccountsSubmenu f_GeneralAccountsSubmenu20 = (com.numhero.client.widget.submenu.GeneralAccountsSubmenu) GWT.create(com.numhero.client.widget.submenu.GeneralAccountsSubmenu.class);
    com.google.gwt.dom.client.LIElement reports = null;
    java.lang.String domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.GeneralReportsSubmenu f_GeneralReportsSubmenu21 = (com.numhero.client.widget.submenu.GeneralReportsSubmenu) GWT.create(com.numhero.client.widget.submenu.GeneralReportsSubmenu.class);
    java.lang.String domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.MoneyinReportsSubmenu f_MoneyinReportsSubmenu22 = (com.numhero.client.widget.submenu.MoneyinReportsSubmenu) GWT.create(com.numhero.client.widget.submenu.MoneyinReportsSubmenu.class);
    java.lang.String domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.submenu.MoneyoutReportsSubmenu f_MoneyoutReportsSubmenu23 = (com.numhero.client.widget.submenu.MoneyoutReportsSubmenu) GWT.create(com.numhero.client.widget.submenu.MoneyoutReportsSubmenu.class);
    com.google.gwt.dom.client.LIElement search = null;
    java.lang.String domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html7(domId0, SafeHtmlUtils.fromSafeConstant(messages.message1()), domId1, SafeHtmlUtils.fromSafeConstant(messages.message2()), SafeHtmlUtils.fromSafeConstant(messages.message3()), SafeHtmlUtils.fromSafeConstant(messages.message4()), domId2, SafeHtmlUtils.fromSafeConstant(messages.message6()), domId3, SafeHtmlUtils.fromSafeConstant(messages.message7()), domId4, SafeHtmlUtils.fromSafeConstant(messages.message8()), domId5, domId6, SafeHtmlUtils.fromSafeConstant(messages.message9()), SafeHtmlUtils.fromSafeConstant(messages.message10()), SafeHtmlUtils.fromSafeConstant(messages.message11()), domId7, SafeHtmlUtils.fromSafeConstant(messages.message13()), domId8, SafeHtmlUtils.fromSafeConstant(messages.message14()), domId9, domId10, SafeHtmlUtils.fromSafeConstant(messages.message15()), SafeHtmlUtils.fromSafeConstant(messages.message16()), SafeHtmlUtils.fromSafeConstant(messages.message17()), domId11, SafeHtmlUtils.fromSafeConstant(messages.message19()), domId12, SafeHtmlUtils.fromSafeConstant(messages.message20()), domId13, domId14, SafeHtmlUtils.fromSafeConstant(messages.message21()), SafeHtmlUtils.fromSafeConstant(messages.message22()), SafeHtmlUtils.fromSafeConstant(messages.message23()), domId15, SafeHtmlUtils.fromSafeConstant(messages.message25()), domId16, SafeHtmlUtils.fromSafeConstant(messages.message26()), domId17, domId18, SafeHtmlUtils.fromSafeConstant(messages.message27()), SafeHtmlUtils.fromSafeConstant(messages.message28()), SafeHtmlUtils.fromSafeConstant(messages.message29()), domId19, SafeHtmlUtils.fromSafeConstant(messages.message31()), domId20, SafeHtmlUtils.fromSafeConstant(messages.message32()), domId21, SafeHtmlUtils.fromSafeConstant(messages.message33()), domId22, domId23, SafeHtmlUtils.fromSafeConstant(messages.message34()), SafeHtmlUtils.fromSafeConstant(messages.message35()), SafeHtmlUtils.fromSafeConstant(messages.message36()), domId24, SafeHtmlUtils.fromSafeConstant(messages.message38()), domId25, domId26, SafeHtmlUtils.fromSafeConstant(messages.message39()), SafeHtmlUtils.fromSafeConstant(messages.message40()), SafeHtmlUtils.fromSafeConstant(messages.message41()), SafeHtmlUtils.fromSafeConstant(messages.message42()), domId27, SafeHtmlUtils.fromSafeConstant(messages.message43()), domId28, SafeHtmlUtils.fromSafeConstant(messages.message44()), domId29, domId30, SafeHtmlUtils.fromSafeConstant(messages.message45())).asString());

    f_NetNumeroButton2.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message5())).asString());
    f_NetNumeroButton2.setHref("#invoice");
    f_NetNumeroButton6.setHTML(template.html2(SafeHtmlUtils.fromSafeConstant(messages.message12())).asString());
    f_NetNumeroButton6.setHref("#expense");
    f_NetNumeroButton9.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message18())).asString());
    f_NetNumeroButton9.setHref("#client");
    f_NetNumeroButton12.setHTML(template.html4(SafeHtmlUtils.fromSafeConstant(messages.message24())).asString());
    f_NetNumeroButton12.setHref("#internal");
    f_NetNumeroButton15.setHTML(template.html5(SafeHtmlUtils.fromSafeConstant(messages.message30())).asString());
    f_NetNumeroButton15.setHref("#project");
    f_NetNumeroButton19.setHTML(template.html6(SafeHtmlUtils.fromSafeConstant(messages.message37())).asString());
    f_NetNumeroButton19.setHref("#bankaccount");
    f_HTMLPanel1.setStyleName("main-menu");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    dashboard = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    dashboard.removeAttribute("id");
    moneyin = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    moneyin.removeAttribute("id");
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    moneyout = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    moneyout.removeAttribute("id");
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    com.google.gwt.user.client.Element domId8Element = com.google.gwt.dom.client.Document.get().getElementById(domId8).cast();
    com.google.gwt.user.client.Element domId9Element = com.google.gwt.dom.client.Document.get().getElementById(domId9).cast();
    clients = com.google.gwt.dom.client.Document.get().getElementById(domId10).cast();
    clients.removeAttribute("id");
    com.google.gwt.user.client.Element domId11Element = com.google.gwt.dom.client.Document.get().getElementById(domId11).cast();
    com.google.gwt.user.client.Element domId12Element = com.google.gwt.dom.client.Document.get().getElementById(domId12).cast();
    com.google.gwt.user.client.Element domId13Element = com.google.gwt.dom.client.Document.get().getElementById(domId13).cast();
    staff = com.google.gwt.dom.client.Document.get().getElementById(domId14).cast();
    staff.removeAttribute("id");
    com.google.gwt.user.client.Element domId15Element = com.google.gwt.dom.client.Document.get().getElementById(domId15).cast();
    com.google.gwt.user.client.Element domId16Element = com.google.gwt.dom.client.Document.get().getElementById(domId16).cast();
    com.google.gwt.user.client.Element domId17Element = com.google.gwt.dom.client.Document.get().getElementById(domId17).cast();
    time = com.google.gwt.dom.client.Document.get().getElementById(domId18).cast();
    time.removeAttribute("id");
    com.google.gwt.user.client.Element domId19Element = com.google.gwt.dom.client.Document.get().getElementById(domId19).cast();
    com.google.gwt.user.client.Element domId20Element = com.google.gwt.dom.client.Document.get().getElementById(domId20).cast();
    com.google.gwt.user.client.Element domId21Element = com.google.gwt.dom.client.Document.get().getElementById(domId21).cast();
    com.google.gwt.user.client.Element domId22Element = com.google.gwt.dom.client.Document.get().getElementById(domId22).cast();
    accounts = com.google.gwt.dom.client.Document.get().getElementById(domId23).cast();
    accounts.removeAttribute("id");
    com.google.gwt.user.client.Element domId24Element = com.google.gwt.dom.client.Document.get().getElementById(domId24).cast();
    com.google.gwt.user.client.Element domId25Element = com.google.gwt.dom.client.Document.get().getElementById(domId25).cast();
    reports = com.google.gwt.dom.client.Document.get().getElementById(domId26).cast();
    reports.removeAttribute("id");
    com.google.gwt.user.client.Element domId27Element = com.google.gwt.dom.client.Document.get().getElementById(domId27).cast();
    com.google.gwt.user.client.Element domId28Element = com.google.gwt.dom.client.Document.get().getElementById(domId28).cast();
    com.google.gwt.user.client.Element domId29Element = com.google.gwt.dom.client.Document.get().getElementById(domId29).cast();
    search = com.google.gwt.dom.client.Document.get().getElementById(domId30).cast();
    search.removeAttribute("id");
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton2, domId2Element);
    f_HTMLPanel1.addAndReplaceElement(f_InvoicesSubmenu3, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(f_EstimatesSubmenu4, domId4Element);
    f_HTMLPanel1.addAndReplaceElement(f_ItemsSubmenu5, domId5Element);
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton6, domId7Element);
    f_HTMLPanel1.addAndReplaceElement(f_ExpensesSubmenu7, domId8Element);
    f_HTMLPanel1.addAndReplaceElement(f_TaxesSubmenu8, domId9Element);
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton9, domId11Element);
    f_HTMLPanel1.addAndReplaceElement(f_ClientsSubmenu10, domId12Element);
    f_HTMLPanel1.addAndReplaceElement(f_SuppliersSubmenu11, domId13Element);
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton12, domId15Element);
    f_HTMLPanel1.addAndReplaceElement(f_InternalStaffSubmenu13, domId16Element);
    f_HTMLPanel1.addAndReplaceElement(f_ContractorsSubmenu14, domId17Element);
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton15, domId19Element);
    f_HTMLPanel1.addAndReplaceElement(f_TrackTimeSubmenu16, domId20Element);
    f_HTMLPanel1.addAndReplaceElement(f_ProjectsSubmenu17, domId21Element);
    f_HTMLPanel1.addAndReplaceElement(f_TasksSubmenu18, domId22Element);
    f_HTMLPanel1.addAndReplaceElement(f_NetNumeroButton19, domId24Element);
    f_HTMLPanel1.addAndReplaceElement(f_GeneralAccountsSubmenu20, domId25Element);
    f_HTMLPanel1.addAndReplaceElement(f_GeneralReportsSubmenu21, domId27Element);
    f_HTMLPanel1.addAndReplaceElement(f_MoneyinReportsSubmenu22, domId28Element);
    f_HTMLPanel1.addAndReplaceElement(f_MoneyoutReportsSubmenu23, domId29Element);


    owner.accounts = accounts;
    owner.clients = clients;
    owner.dashboard = dashboard;
    owner.moneyin = moneyin;
    owner.moneyout = moneyout;
    owner.reports = reports;
    owner.search = search;
    owner.staff = staff;
    owner.time = time;

    return f_HTMLPanel1;
  }
}
