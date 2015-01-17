package com.numhero.client.widget.combobox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DropDownBox_DropDownBoxUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.combobox.DropDownBox>, com.numhero.client.widget.combobox.DropDownBox.DropDownBoxUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.combobox.DropDownBox owner) {

    com.numhero.client.widget.combobox.DropDownBox_DropDownBoxUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.combobox.DropDownBox_DropDownBoxUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.combobox.DropDownBox_DropDownBoxUiBinderImpl_GenBundle.class);
    com.google.gwt.user.client.ui.NetNumeroSuggestBox suggestBox = owner.suggestBox;
    com.google.gwt.user.client.ui.Anchor btDropDown = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    suggestBox.setWidth("100%");
    f_HorizontalPanel1.add(suggestBox);
    f_HorizontalPanel1.setCellWidth(suggestBox, "100%");
    btDropDown.setStyleName("arrow-button");
    btDropDown.setTabIndex(-1);
    btDropDown.setHref("javascript:;");
    f_HorizontalPanel1.add(btDropDown);
    f_HorizontalPanel1.setCellWidth(btDropDown, "20px");
    f_HorizontalPanel1.setStyleName("netnumero-dropdown");
    f_HorizontalPanel1.setWidth("100%");



    owner.btDropDown = btDropDown;

    return f_HorizontalPanel1;
  }
}
