package com.numhero.client.widget.submenu;

public class TrackTimeSubmenu_TrackTimeSubmenuUiBinderImpl_TemplateImpl implements com.numhero.client.widget.submenu.TrackTimeSubmenu_TrackTimeSubmenuUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,com.google.gwt.safehtml.shared.SafeHtml arg1) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<dl class='inh-menu'> <dt class='inh-menu'> <a class='inh-menu' href='#timeentry'> ");
    sb.append(arg0.asString());
    sb.append(" </a> </dt> <dt class='inh-menu-end'> <a class='inh-menu' href='#timeentries'> ");
    sb.append(arg1.asString());
    sb.append(" </a> </dt> </dl>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
