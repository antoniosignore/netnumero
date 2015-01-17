package com.numhero.client.widget;

public class HeaderLine_HeaderLineUiBinderImpl_TemplateImpl implements com.numhero.client.widget.HeaderLine_HeaderLineUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html2(java.lang.String arg0,java.lang.String arg1,com.google.gwt.safehtml.shared.SafeHtml arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<span class='currentDate' id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> | <a class='logoutButton' href='http://www.netnumero.com/customer/account/logout' id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'> ");
    sb.append(arg2.asString());
    sb.append(" </a>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html1(java.lang.String arg0,com.google.gwt.safehtml.shared.SafeHtml arg1,java.lang.String arg2,com.google.gwt.safehtml.shared.SafeHtml arg3,java.lang.String arg4,com.google.gwt.safehtml.shared.SafeHtml arg5) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("<ul> <li> <a href='https://www.netnumero.com/customer/account/' id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
sb.append("'> ");
sb.append(arg1.asString());
sb.append(" </a> </li> <li> <a href='#businessaccount' id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
sb.append("'> ");
sb.append(arg3.asString());
sb.append(" </a> </li>  <li> <a href='https://www.netnumero.com/support' id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg4));
sb.append("' target='_blank'> ");
sb.append(arg5.asString());
sb.append(" </a> </li> </ul>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
