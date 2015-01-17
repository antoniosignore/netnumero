package com.numhero.client.widget.search;

public class SearchPanel_SearchPanelUiBinderImpl_TemplateImpl implements com.numhero.client.widget.search.SearchPanel_SearchPanelUiBinderImpl.Template {
  
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

public com.google.gwt.safehtml.shared.SafeHtml html2(java.lang.String arg0,java.lang.String arg1) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("<table cellpadding='0' cellspacing='0' class='formContainer'> <tbody> @UiField CustomFormatDateBox from; @UiField CustomFormatDateBox to; @UiField NetNumeroButton btRefresh; <tr> <td class='formItem'> <strong> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
sb.append("'></span> </strong> </td> <td class='formItem'> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
sb.append("'></span> </td> </tr> </tbody> </table>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html1(com.google.gwt.safehtml.shared.SafeHtml arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append(arg0.asString());
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html3(com.google.gwt.safehtml.shared.SafeHtml arg0) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append(arg0.asString());
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
