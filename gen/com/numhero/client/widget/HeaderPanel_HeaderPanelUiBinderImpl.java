package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.dom.client.Element;

public class HeaderPanel_HeaderPanelUiBinderImpl implements UiBinder<com.google.gwt.dom.client.Element, com.numhero.client.widget.HeaderPanel>, com.numhero.client.widget.HeaderPanel.HeaderPanelUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='header'></div>")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.dom.client.Element createAndBindUi(final com.numhero.client.widget.HeaderPanel owner) {

    com.numhero.client.widget.HeaderPanel_HeaderPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.HeaderPanel_HeaderPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.HeaderPanel_HeaderPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.HeaderPanel_HeaderPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.dom.client.DivElement mainDivContainer = (com.google.gwt.dom.client.DivElement) UiBinderUtil.fromHtml(template.html1().asString());




    owner.mainDivContainer = mainDivContainer;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return mainDivContainer;
  }
}
