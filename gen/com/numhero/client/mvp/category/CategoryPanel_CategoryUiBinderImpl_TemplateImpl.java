package com.numhero.client.mvp.category;

public class CategoryPanel_CategoryUiBinderImpl_TemplateImpl implements com.numhero.client.mvp.category.CategoryPanel_CategoryUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html4(java.lang.String arg0,java.lang.String arg1,java.lang.String arg2) {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("<span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
    sb.append("'></span> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
    sb.append("'></span> <span id='");
    sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
    sb.append("'></span>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html2(com.google.gwt.safehtml.shared.SafeHtml arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append(arg0.asString());
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html3(com.google.gwt.safehtml.shared.SafeHtml arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append(arg0.asString());
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0,java.lang.String arg1,java.lang.String arg2,java.lang.String arg3,java.lang.String arg4) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <thead> <tr> <td colspan='6'> ");
sb.append(arg0.asString());
sb.append(" </td> </tr> </thead> <tbody> <tr> <td class='form-item-label'> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
sb.append("'></span> </td> <td class='formItem'> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg2));
sb.append("'></span> </td> </tr> <tr> <td class='form-item-label'> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg3));
sb.append("'></span> </td> <td class='formItem'> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg4));
sb.append("'></span> </td> </tr>           </tbody> </table>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
