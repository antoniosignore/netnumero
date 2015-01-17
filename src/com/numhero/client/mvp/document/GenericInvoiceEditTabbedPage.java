package com.numhero.client.mvp.document;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickHandler;
import com.numhero.client.Application;
import com.numhero.client.LocalizableConstants;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.GenericMoneyinTabEditPage;
import com.numhero.client.util.ClientUtils;
import com.numhero.client.util.CoreUtils;

import java.util.Map;

import static com.numhero.client.Application.getConstants;

public class GenericInvoiceEditTabbedPage extends GenericMoneyinTabEditPage implements InvoiceEditPageView {

    private AbstractInvoicePanel editPanel;

    public GenericInvoiceEditTabbedPage(AbstractInvoicePanel panel) {
        super(panel);
        editPanel = panel;
    }

    @Override
    public void setTaxes(Map<Long, TaxInfo> taxes) {
        editPanel.invoiceDetailsTable.setTaxes(taxes);

    }

    @Override
    public void addSendAsEmailClickHandler(ClickHandler clickHandler) {

    }

    @Override
    public void addSendAsSnailClickHandler(ClickHandler clickHandler) {

    }

    @Override
    public void setViewMode() {
        editPanel.getPDF().setVisible(false);
        editPanel.getEditor().setVisible(true);
    }

    @Override
    public void setEditMode() {
        getInvoiceEditPanel().getPDF().setVisible(false);
        getInvoiceEditPanel().getEditor().setVisible(true);

    }

    private AbstractInvoicePanel getInvoiceEditPanel() {
        return editPanel;  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void setViewPdfMode() {
        getInvoiceEditPanel().getPDF().setVisible(true);
        getInvoiceEditPanel().getEditor().setVisible(false);
        final Element div = getInvoiceEditPanel().getPdfDivElement(); //it must be called before getVie()... todo Mikado remove it

        Invoice invoice = (Invoice) editPanel.getPojo();
        String pdfName = "/pdf/" + invoice.getId();
        CoreUtils.debug("pdfName = " + pdfName);
        LocalizableConstants constants = getConstants();
        if (!ClientUtils.embedPdf(pdfName, div)) {
            div.setInnerHTML(constants.invoicePdfCannotBeEmbedded());
        }

    }

    @Override
    public void setDetailsLabel(String text) {
        editPanel.lbDetails.setText(Application.getConstants().invoiceDetails());

    }

}
