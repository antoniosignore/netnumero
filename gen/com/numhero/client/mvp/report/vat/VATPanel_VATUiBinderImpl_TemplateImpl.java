package com.numhero.client.mvp.report.vat;

public class VATPanel_VATUiBinderImpl_TemplateImpl implements com.numhero.client.mvp.report.vat.VATPanel_VATUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html2(com.google.gwt.safehtml.shared.SafeHtml arg0,java.lang.String arg1,java.lang.String arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='14'> ");
    sb.append(arg0.asString());
    sb.append(" </td> </tr> </thead> <tbody> <tr cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <td colspan='14'> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> </td> </tr> <tr> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'></span> </tr> </tbody> </table>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html3(java.lang.String arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("<span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
sb.append("'></span>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append(arg0.asString());
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
