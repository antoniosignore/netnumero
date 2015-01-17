package com.numhero.client.widget.submenu;

public class GeneralReportsSubmenu_GeneralReportsSubmenuUiBinderImpl_TemplateImpl implements com.numhero.client.widget.submenu.GeneralReportsSubmenu_GeneralReportsSubmenuUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,com.google.gwt.safehtml.shared.SafeHtml arg1,com.google.gwt.safehtml.shared.SafeHtml arg2,com.google.gwt.safehtml.shared.SafeHtml arg3) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#recent-transactions'> ");
    sb.append(arg0.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#chart-accounts'> ");
    sb.append(arg1.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#trial-balance'> ");
    sb.append(arg2.asString());
    sb.append(" </a> </dt> <dt class='inh-menu_end'> <a class='inh-menu' href='#profit-loss'> ");
    sb.append(arg3.asString());
    sb.append(" </a> </dt> </dl>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
