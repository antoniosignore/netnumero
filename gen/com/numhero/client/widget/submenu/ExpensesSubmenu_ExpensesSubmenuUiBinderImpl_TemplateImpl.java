package com.numhero.client.widget.submenu;

public class ExpensesSubmenu_ExpensesSubmenuUiBinderImpl_TemplateImpl implements com.numhero.client.widget.submenu.ExpensesSubmenu_ExpensesSubmenuUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,com.google.gwt.safehtml.shared.SafeHtml arg1,com.google.gwt.safehtml.shared.SafeHtml arg2,com.google.gwt.safehtml.shared.SafeHtml arg3) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#expense'> ");
    sb.append(arg0.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#expenses'> ");
    sb.append(arg1.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#pettyexpense'> ");
    sb.append(arg2.asString());
    sb.append(" </a> </dt> <dt class='inh-menu-end'> <a class='inh-menu' href='#reimburse-staff'> ");
    sb.append(arg3.asString());
    sb.append(" </a> </dt>       </dl>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
