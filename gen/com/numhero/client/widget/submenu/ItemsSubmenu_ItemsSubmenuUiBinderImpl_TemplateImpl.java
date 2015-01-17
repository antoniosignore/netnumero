package com.numhero.client.widget.submenu;

public class ItemsSubmenu_ItemsSubmenuUiBinderImpl_TemplateImpl implements com.numhero.client.widget.submenu.ItemsSubmenu_ItemsSubmenuUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,com.google.gwt.safehtml.shared.SafeHtml arg1,com.google.gwt.safehtml.shared.SafeHtml arg2,com.google.gwt.safehtml.shared.SafeHtml arg3) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#product'> ");
    sb.append(arg0.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#products'> ");
    sb.append(arg1.asString());
    sb.append(" </a> </dt> <dt class='inh-menu'> <a class='inh-menu' href='#service'> ");
    sb.append(arg2.asString());
    sb.append(" </a> </dt> <dt class='inh-menu-end'> <a class='inh-menu' href='#services'> ");
    sb.append(arg3.asString());
    sb.append(" </a> </dt> </dl>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
