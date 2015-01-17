package com.numhero.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class NetNumeroButton_NetNumeroButtonUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.numhero.client.widget.NetNumeroButton>, com.numhero.client.widget.NetNumeroButton.NetNumeroButtonUiBinder {

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.numhero.client.widget.NetNumeroButton owner) {

    com.numhero.client.widget.NetNumeroButton_NetNumeroButtonUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.numhero.client.widget.NetNumeroButton_NetNumeroButtonUiBinderImpl_GenBundle) GWT.create(com.numhero.client.widget.NetNumeroButton_NetNumeroButtonUiBinderImpl_GenBundle.class);
    com.google.gwt.user.client.ui.Anchor anchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel1 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);

    anchor.setStyleName("netnumero-button");
    anchor.setHref("javascript:;");
    f_HorizontalPanel1.add(anchor);



    owner.anchor = anchor;

    return f_HorizontalPanel1;
  }
}
