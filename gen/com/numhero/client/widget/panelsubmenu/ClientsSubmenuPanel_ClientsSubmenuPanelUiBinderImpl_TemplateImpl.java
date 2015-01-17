package com.numhero.client.widget.panelsubmenu;

public class ClientsSubmenuPanel_ClientsSubmenuPanelUiBinderImpl_TemplateImpl implements com.numhero.client.widget.panelsubmenu.ClientsSubmenuPanel_ClientsSubmenuPanelUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,java.lang.String arg1,com.google.gwt.safehtml.shared.SafeHtml arg2,java.lang.String arg3) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<ul class='first-level'> <li class='menu-title'> ");
    sb.append(arg0.asString());
    sb.append(" <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> ");
    sb.append(arg2.asString());
    sb.append(" <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg3));
    sb.append("'></span> </div> </div> </li> </ul> </li> </ul>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
