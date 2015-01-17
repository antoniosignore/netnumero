package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class TableFooterPanel_TableFooterPanelUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.TableFooterPanel>, com.numhero.client.widget.TableFooterPanel.TableFooterPanelUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.TableFooterPanel owner) {

    com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenBundle.class);
    com.numhero.client.widget.TableFooterPanel_TableFooterPanelUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuBar tableFooterActionsCombo = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.Image firstData = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Image prevData = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Image nextData = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.Image lastData = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel2 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HorizontalPanel footPanel = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId0).asString());

    tableFooterActionsCombo.setStyleName("table-footer-combo");
    footPanel.add(tableFooterActionsCombo);
    firstData.setUrl("../../i/common/first.jpg");
    f_HorizontalPanel2.add(firstData);
    f_HorizontalPanel2.setCellWidth(firstData, "100px");
    prevData.setUrl("../../i/common/prev.jpg");
    f_HorizontalPanel2.add(prevData);
    f_HorizontalPanel2.setCellWidth(prevData, "100px");
    nextData.setUrl("../../i/common/next.jpg");
    f_HorizontalPanel2.add(nextData);
    f_HorizontalPanel2.setCellWidth(nextData, "100px");
    lastData.setUrl("../../i/common/last.jpg");
    f_HorizontalPanel2.add(lastData);
    f_HorizontalPanel2.setCellWidth(lastData, "100px");
    f_HorizontalPanel2.setStyleName("tableFooterButtonsPanel");
    f_HorizontalPanel2.setWidth("500px");
    footPanel.add(f_HorizontalPanel2);
    f_HTMLPanel1.setStyleName("table-footer-panel");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(footPanel, domId0Element);


    owner.firstData = firstData;
    owner.footPanel = footPanel;
    owner.lastData = lastData;
    owner.nextData = nextData;
    owner.prevData = prevData;
    owner.tableFooterActionsCombo = tableFooterActionsCombo;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
