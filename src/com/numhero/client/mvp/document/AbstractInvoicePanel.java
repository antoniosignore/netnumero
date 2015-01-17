package com.numhero.client.mvp.document;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.document.InvoiceDetailsTable.InvoiceDetailsHandler;
import com.numhero.client.util.ApplicationValidationMessages;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.EntityPojo;
import com.numhero.shared.util.SharedUtils;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

import java.util.Map;

public abstract class AbstractInvoicePanel extends AbstractEditEntityPanel implements DropDownBoxHandler, InvoiceDetailsHandler {
    interface InvoiceUiBinder extends UiBinder<Widget, AbstractInvoicePanel> {
    }

    private static InvoiceUiBinder uiBinder = GWT.create(InvoiceUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    Label lbDetails;

    @UiField
    TableElement teMain;

    @UiField(provided = true)
    DropDownBox<?, ?> sbPartner;

    @UiField
    Label lbInvoiceID;

    @UiField
    CustomFormatDateBox dateRaised;

    @UiField
    CustomFormatDateBox dateDue;

    @UiField
    CurrencySelect cbCurrency;

    @UiField(provided = true)
    FocusPanel invoiceDetailsPanel;

    InvoiceDetailsTable invoiceDetailsTable;

    @UiField
    NetNumeroButton btAddInvoiceDetail;

    @UiField(provided = true)
    NumberTextBox tbDiscount;

    @UiField
    TextArea taTermsConditions;

    @UiField
    TextArea taNotes;

    @UiField
    NetNumeroButton btSaveDraft;

    @UiField
    NetNumeroButton btSendSnailMail;

    @UiField
    NetNumeroButton btSendAsEmail;

    @UiField
    NetNumeroButton btCancel;

    @UiField
    DivElement pdfDivElement;

    @UiField
    HTML PDF;

    @UiField
    HTMLPanel editor;

    public AbstractInvoicePanel(DropDownBox<?, ?> sbPartner, final InvoiceDetailsTable invoiceDetailsTable) {
        this.sbPartner = sbPartner;
        this.invoiceDetailsTable = invoiceDetailsTable;
        this.sbPartner.setHandler(this);

//        invoiceDetailsTable = Application.injector.getInvoiceDetailsTable();
        invoiceDetailsTable.setHandler(this);
        invoiceDetailsPanel = new InvoiceDetailsPanel(invoiceDetailsTable, 6);

        tbDiscount = new NumberTextBox() {
            public void stopEdit() {
                super.stopEdit();
                getInvoice().setDiscount(getAmount());
                totalChanged();
            }
        };

        initWidget(uiBinder.createAndBindUi(this));

        createValidator(errorsPanel);
        invoiceDetailsTable.setValidator(validator);

        cbCurrency.setHandler(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                CurrencyEnum currency = (CurrencyEnum) pojo;
                if (currency != getInvoice().getCurrency()) {
                    invoiceDetailsTable.setCurrency(currency);
                    getInvoice().setCurrency(currency);
                    totalChanged();
                }
            }
        });

        btAddInvoiceDetail.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                InvoiceDetail idc1 = new InvoiceDetail();
                getInvoice().getDetails().add(idc1);
                invoiceDetailsTable.addLine(idc1);
                invoiceDetailsTable.setValues();
            }
        });
    }

    @Override
    public void setPojo(EntityPojo pojo) {
        super.setPojo(pojo);

        Invoice invoice = (Invoice) pojo;
        invoiceDetailsTable.setInvoice(invoice);

        ClientSupplier cs = (ClientSupplier) sbPartner.getPojo();
        cs.setId(invoice.getClientSupplierID());
        cs.fClient.setValue(true);
        cs.fName.setValue(invoice.getClientSupplierName());
        sbPartner.getSuggestBox().setValue(invoice.getClientSupplierName());

        lbInvoiceID.setText(invoice.fName.getValue());
        dateRaised.setValue(invoice.getDateRaised());
        dateDue.setValue(invoice.getDateDue());
        cbCurrency.setPojo(invoice.getCurrency());
        tbDiscount.setAmount(invoice.getDiscount());
        taTermsConditions.setValue(invoice.getTermsConditions());
        taNotes.setValue(invoice.getNotes());

        totalChanged();

        sbPartner.setFocus(true);
    }

    public Invoice getInvoice() {
        return (Invoice) pojo;
    }

    @Override
    public NetNumeroButton getBtSave() {
        return btSaveDraft;
    }

    public NetNumeroButton getBtSendSnail() {
        return btSendSnailMail;
    }

    public NetNumeroButton getBtSendAsEmail() {
        return btSendAsEmail;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
    }

    public DivElement getPdfDivElement() {
        return pdfDivElement;
    }

    public HTML getPDF() {
        return PDF;
    }

    public HTMLPanel getEditor() {
        return editor;
    }

    public boolean saveValuesFromUi() {
        Invoice invoice = getInvoice();
        if (invoice.getClientSupplierID() == null) {
            Window.alert(Application.getConstants().selectExistingPartner());
            return false;
        }
        invoiceDetailsTable.removeEmptyLines();
        boolean ret = validator.validate();
        if (ret) {
            invoice.fName.setValue(lbInvoiceID.getText());
            invoice.setDateRaised(dateRaised.getValue());
            invoice.setDateDue(dateDue.getValue());
            invoice.setTermsConditions(taTermsConditions.getText());
            invoice.setNotes(taNotes.getText());
            invoiceDetailsTable.saveValuesFromUi();
            invoice.setPrice(invoiceDetailsTable.getTotal() * (100 - getInvoice().getDiscount()) / 100);
        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        ClientSupplier clientSupplierC = (ClientSupplier) pojo;
        getInvoice().setClientSupplierID(clientSupplierC.getId());
        getInvoice().setClientSupplierName(clientSupplierC.fName.getValue());
    }

    @Override
    public void totalChanged() {
        invoiceDetailsTable.saveValuesFromUi();

        // remove taxes & total rows
        while (teMain.getRows().getLength() > 8) {
            teMain.deleteRow(8);
        }

        Map<String, Double> calculatedTaxes = getInvoice().calculateTaxes(invoiceDetailsTable.getTaxes());
        for (String taxName : calculatedTaxes.keySet()) {
            insertTotalRow(taxName, calculatedTaxes.get(taxName));
        }

        getInvoice().setPrice(invoiceDetailsTable.getTotal() * (100 - getInvoice().getDiscount()) / 100);
        insertTotalRow("Total Price", getInvoice().getPrice());
    }

    private void insertTotalRow(String name, double value) {
        TableRowElement tr = teMain.insertRow(-1);

        TableCellElement tdEmpty = tr.insertCell(-1);
        tdEmpty.setClassName("form-item-subtotal");
        tdEmpty.setColSpan(2);

        TableCellElement tdLabel = tr.insertCell(-1);
        tdLabel.setClassName("form-item-subtotal");
        tdLabel.setInnerHTML(name);

        TableCellElement tdValue = tr.insertCell(-1);
        tdValue.setClassName("form-item-subtotal");
        tdValue.setAttribute("style", "text-align: right");
        tdValue.setInnerText(SharedUtils.currencyToStr(value, 2, cbCurrency.getPojo()));
    }

    @Override
    protected ValidationMessages createValidationMessages() {
        return new ApplicationValidationMessages() {
            @Override
            public String getPropertyName(String propertyName) {
                if (propertyName.startsWith("Description")) {
                    return Application.getConstants().description();
                } else {
                    return propertyName;
                }
            }
        };
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected void addValidators() {
        addValidators(Application.getConstants().client(), new NotEmptyValidator(sbPartner.getSuggestBox().getTextBox(), true, "required"));
        addValidators(Application.getConstants().dateRaised(), new NotEmptyValidator(dateRaised.getTextBox(), true, "required"));
    }


}
