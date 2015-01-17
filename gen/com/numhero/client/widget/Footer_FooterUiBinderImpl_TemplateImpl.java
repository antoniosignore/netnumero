package com.numhero.client.widget;

public class Footer_FooterUiBinderImpl_TemplateImpl implements com.numhero.client.widget.Footer_FooterUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html3(java.lang.String arg0,com.google.gwt.safehtml.shared.SafeHtml arg1,java.lang.String arg2,com.google.gwt.safehtml.shared.SafeHtml arg3,com.google.gwt.safehtml.shared.SafeHtml arg4,com.google.gwt.safehtml.shared.SafeHtml arg5) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<div id='footer-content'> <div class='link-bar'> <ul> <li class='bar'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> </li> <li class='bar'> <a class='inh-standard' href='http://www.netnumero.com/terms/'> ");
    sb.append(arg1.asString());
    sb.append(" </a> </li> <li class='bar'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'></span> </li>      </ul> </div> <div class='info'> <strong class='logo'> <a href='/index.html'></a> </strong> <p> ");
    sb.append(arg3.asString());
    sb.append(" <a class='inh-standard' href='http://www.netnumero.com'> ");
    sb.append(arg4.asString());
    sb.append(" </a> ");
    sb.append(arg5.asString());
    sb.append(" </p> </div> </div>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html1() {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("Report a Bug");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html2() {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("Contact Us");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
