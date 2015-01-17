package com.numhero.client.mvp.document;

import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.EditPageView;

import java.util.Map;

public interface InvoiceEditPageView extends EditPageView{

    void setTaxes(Map<Long,TaxInfo> taxes);

    void addSendAsEmailClickHandler(ClickHandler clickHandler);

    void addSendAsSnailClickHandler(ClickHandler clickHandler);

    void setViewMode();

    void setEditMode();

    void setViewPdfMode();

    void setDetailsLabel(String text);

}
