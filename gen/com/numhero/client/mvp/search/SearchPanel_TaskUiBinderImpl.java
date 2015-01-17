package com.numhero.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SearchPanel_TaskUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.mvp.search.SearchPanel>, com.numhero.client.mvp.search.SearchPanel.TaskUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer' width='100%'> <tbody> <tr> <td class='formItem'> <span id='{0}'></span> <br> <div class='search-results' id='{1}'></div> </td> </tr> </tbody> </table>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.mvp.search.SearchPanel owner) {

    com.numhero.client.mvp.search.SearchPanel_TaskUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.mvp.search.SearchPanel_TaskUiBinderImpl_GenBundle) GWT.create(com.numhero.client.mvp.search.SearchPanel_TaskUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.TextBox tbSearch = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.google.gwt.dom.client.DivElement dvSearchResults = null;
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId1, domId2).asString());
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId0).asString());

    f_HTMLPanel2.setStyleName("form-with-shadow");
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    dvSearchResults = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    dvSearchResults.removeAttribute("id");
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(tbSearch, domId1Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);


    owner.dvSearchResults = dvSearchResults;
    owner.tbSearch = tbSearch;

    return f_HTMLPanel1;
  }
}
