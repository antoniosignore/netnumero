package com.numhero.client.mvp.document;

import com.google.gwt.core.client.GWT;
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
import com.numhero.client.model.datacargo.category.CategoryListRequest;
import com.numhero.client.model.datacargo.category.CategoryListResponse;
import com.numhero.client.model.datacargo.category.SaveCategoryRequest;
import com.numhero.client.model.pojoc.Category;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.mvp.AbstractEditEntityPanel;
import com.numhero.client.mvp.category.CategoryPanel;
import com.numhero.client.mvp.category.CategorySelect;
import com.numhero.client.mvp.document.InvoiceDetailsTable.InvoiceDetailsHandler;
import com.numhero.client.service.Service;
import com.numhero.client.util.ApplicationValidationMessages;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.EntityPojo;
import com.numhero.shared.util.SharedUtils;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

import java.util.Map;

public class ExpensePanel extends AbstractEditEntityPanel implements DropDownBoxHandler, InvoiceDetailsHandler {
    interface InvoiceUiBinder extends UiBinder<Widget, ExpensePanel> {
    }

    private static InvoiceUiBinder uiBinder = GWT.create(InvoiceUiBinder.class);

    @UiField
    DisclosurePanel errorsPanel;

    @UiField
    TableElement teMain;

    @UiField(provided = true)
    DropDownBox<?, ?> sbPartner;

    @UiField(provided = true)
    CategorySelect sbCategory;

    @UiField
    TextBox tbInvoiceID;

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

    @UiField
    TextArea taNotes;

    @UiField
    NetNumeroButton btSave;

    @UiField
    NetNumeroButton btCancel;

    public ExpensePanel(DropDownBox<?, ?> sbPartner,
                        Service<CategoryListRequest, CategoryListResponse> categoriesService,
                        Service<SaveCategoryRequest, SaveSingleEntityResponse> categorySaveService,
                        CategoryPanel panel,
                        final InvoiceDetailsTable invoiceDetailsTable) {
        this.sbPartner = sbPartner;
        this.invoiceDetailsTable = invoiceDetailsTable;
        this.sbPartner.setHandler(this);

        sbCategory = new CategorySelect(this, categoriesService, categorySaveService, panel);

//        invoiceDetailsTable = Application.injector.getInvoiceDetailsTable();
        invoiceDetailsTable.setHandler(this);
        invoiceDetailsPanel = new InvoiceDetailsPanel(invoiceDetailsTable, 6);

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
        cs.fSupplier.setValue(true);
        cs.fName.setValue(invoice.getClientSupplierName());
        sbPartner.getSuggestBox().setValue(invoice.getClientSupplierName());

        Category cat = (Category) sbCategory.getPojo();
        cat.setId(invoice.getAccountID());
        cat.fName.setValue(invoice.getAccountName());
        sbCategory.getSuggestBox().setValue(invoice.getAccountName());

        tbInvoiceID.setValue(invoice.fName.getValue());
        dateRaised.setValue(invoice.getDateRaised());
        dateDue.setValue(invoice.getDateDue());
        cbCurrency.setPojo(invoice.getCurrency());
        taNotes.setValue(invoice.getNotes());

        totalChanged();

        sbPartner.setFocus(true);
    }

    public Invoice getInvoice() {
        return (Invoice) pojo;
    }

    public NetNumeroButton getBtSave() {
        return btSave;
    }

    public NetNumeroButton getBtCancel() {
        return btCancel;
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
            invoice.fName.setValue(tbInvoiceID.getText());
            invoice.setDateRaised(dateRaised.getValue());
            invoice.setDateDue(dateDue.getValue());
            invoice.setNotes(taNotes.getText());
            invoiceDetailsTable.saveValuesFromUi();
            invoice.setPrice(invoiceDetailsTable.getTotal());

        } else {
            errorsPanel.setVisible(true);
        }
        return ret;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        if (pojo instanceof ClientSupplier) {
            ClientSupplier clientSupplier = (ClientSupplier) pojo;
            getInvoice().setClientSupplierID(clientSupplier.getId());
            getInvoice().setClientSupplierName(clientSupplier.fName.getValue());
        } else if (pojo instanceof Category) {
            Category category = (Category) pojo;
            getInvoice().setAccountID(category.getId());
            getInvoice().setAccountName(category.fName.getValue());
        }
    }

    @Override
    public void totalChanged() {
        invoiceDetailsTable.saveValuesFromUi();

        // remove taxes & total rows
        while (teMain.getRows().getLength() > 6) {
            teMain.deleteRow(6);
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
        addValidators(Application.getConstants().supplier(), new NotEmptyValidator(sbPartner.getSuggestBox().getTextBox(), true, "required"));
        addValidators(Application.getConstants().category(), new NotEmptyValidator(sbCategory.getSuggestBox().getTextBox(), true, "required"));
        addValidators(Application.getConstants().id(), new NotEmptyValidator(tbInvoiceID, true, "required"));
        addValidators(Application.getConstants().dateRaised(), new NotEmptyValidator(dateRaised.getTextBox(), true, "required"));
    }


}
