package com.numhero.client.widget.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SearchPanel_SearchPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.search.SearchPanel>, com.numhero.client.widget.search.SearchPanel.SearchPanelUiBinder {
  static SearchPanelSearchPanelUiBinderImplGenMessages messages = (SearchPanelSearchPanelUiBinderImplGenMessages) GWT.create(SearchPanelSearchPanelUiBinderImplGenMessages.class);

  interface Template extends SafeHtmlTemplates {
    @Template("{0}")
    SafeHtml html1(SafeHtml arg0);
     
    @Template("<table cellpadding='0' cellspacing='0' class='formContainer'> <tbody> @UiField CustomFormatDateBox from; @UiField CustomFormatDateBox to; @UiField NetNumeroButton btRefresh; <tr> <td class='formItem'> <strong> <span id='{0}'></span> </strong> </td> <td class='formItem'> <span id='{1}'></span> </td> </tr> </tbody> </table>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("{0}")
    SafeHtml html3(SafeHtml arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.search.SearchPanel owner) {

    com.numhero.client.widget.search.SearchPanel_SearchPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.search.SearchPanel_SearchPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.search.SearchPanel_SearchPanelUiBinderImpl_GenBundle.class);
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.TextBox tbSearch = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
    com.numhero.client.widget.FormItem f_FormItem3 = (com.numhero.client.widget.FormItem) GWT.create(com.numhero.client.widget.FormItem.class);
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btSearch = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template.html2(domId1, domId2).asString());
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.search.AbstractSearchTable searchTable = owner.searchTable;
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.numhero.client.widget.NetNumeroButton btCancel = (com.numhero.client.widget.NetNumeroButton) GWT.create(com.numhero.client.widget.NetNumeroButton.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId0, domId3, domId4).asString());

    f_Label4.setText("" + messages.message1() + "");
    f_FormItem3.add(f_Label4);
    f_FormItem3.add(tbSearch);
    f_FormItem3.setTitleWidth(200);
    btSearch.setHTML(template.html1(SafeHtmlUtils.fromSafeConstant(messages.message2())).asString());
    searchTable.setStyleName("invoiceDetails inh-standard");
    btCancel.setHTML(template.html3(SafeHtmlUtils.fromSafeConstant(messages.message3())).asString());
    btCancel.setHref("javascript:;");
    f_HorizontalPanel5.add(btCancel);
    f_HTMLPanel1.setStyleName("formContainer");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord1.detach();
    f_HTMLPanel2.addAndReplaceElement(f_FormItem3, domId1Element);
    f_HTMLPanel2.addAndReplaceElement(btSearch, domId2Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_HTMLPanel2, domId0Element);
    f_HTMLPanel1.addAndReplaceElement(searchTable, domId3Element);
    f_HTMLPanel1.addAndReplaceElement(f_HorizontalPanel5, domId4Element);


    owner.btCancel = btCancel;
    owner.btSearch = btSearch;
    owner.tbSearch = tbSearch;

    return f_HTMLPanel1;
  }
}
