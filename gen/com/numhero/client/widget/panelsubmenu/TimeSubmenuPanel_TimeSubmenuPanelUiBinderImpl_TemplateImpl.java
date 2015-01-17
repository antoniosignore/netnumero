package com.numhero.client.widget.panelsubmenu;

public class TimeSubmenuPanel_TimeSubmenuPanelUiBinderImpl_TemplateImpl implements com.numhero.client.widget.panelsubmenu.TimeSubmenuPanel_TimeSubmenuPanelUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,java.lang.String arg1,com.google.gwt.safehtml.shared.SafeHtml arg2,java.lang.String arg3,com.google.gwt.safehtml.shared.SafeHtml arg4,java.lang.String arg5) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<ul class='first-level'> <li class='menu-title'> ");
    sb.append(arg0.asString());
    sb.append(" <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> ");
    sb.append(arg2.asString());
    sb.append(" <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg3));
    sb.append("'></span> </div> </div> </li> </ul> </li> <li class='menu-title'> ");
    sb.append(arg4.asString());
    sb.append(" <ul class='second-level'> <li> <div id='menu-sub'> <div class='cell'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg5));
    sb.append("'></span> </div> </div> </li> </ul> </li> </ul>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
