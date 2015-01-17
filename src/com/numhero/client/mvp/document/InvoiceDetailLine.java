package com.numhero.client.mvp.document;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.model.pojoc.ProductService;
import com.numhero.client.model.pojoc.TaxInfo;
import com.numhero.client.mvp.currency.CurrencyConvertBean;
import com.numhero.client.mvp.currency.CurrencyConvertDialog;
import com.numhero.client.mvp.product.ProductServiceSelect;
import com.numhero.client.mvp.taxinfo.TaxInfoSelect;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.table.TableDetailToolbar;
import com.numhero.client.widget.textbox.NumberTextBox;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailLine {
    InvoiceDetailsTable parent;
    InvoiceDetail invoiceDetail;
    ProductServiceSelect sbProductService;
    TextBox txDescription;
    NumberTextBox txUnitPrice;
    NumberTextBox txQuantity;
    TaxInfoSelect sbTax1;
    TaxInfoSelect sbTax2;
    NumberTextBox txTotalPrice;
    TableDetailToolbar toolbar;
    private Service<GetCurrencyConversionRequest,GetCurrencyConversionResponse> conversionService;

    public InvoiceDetailLine(InvoiceDetailsTable idt, InvoiceDetail idc, Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService) {
        parent = idt;
        invoiceDetail = idc;
        this.conversionService = conversionService;
        sbProductService = new ProductServiceSelect(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojoC) {
                ProductService productService = (ProductService) pojoC;
                invoiceDetail.fProductID.setValue(productService.getId());
                invoiceDetail.fName.setValue(productService.fName.getValue());
                invoiceDetail.setDescription(productService.getDescription());
                invoiceDetail.setPrice(productService.getUnitPrice());
                txDescription.setText(productService.getDescription());
                txUnitPrice.setAmount(productService.getUnitPrice());
                if (productService.getCurrency() != parent.getInvoice().getCurrency()) {
                    List<CurrencyConvertBean> toConvert = new ArrayList<CurrencyConvertBean>(1);
                    final CurrencyConvertBean ccb = new CurrencyConvertBean();
                    ccb.setFromAmount(productService.getUnitPrice());
                    ccb.setFromCurrency(productService.getCurrency());
                    ccb.setToAmount(0);
                    ccb.setToCurrency(parent.getInvoice().getCurrency());
                    toConvert.add(ccb);

                    CurrencyConvertDialog dlg = new CurrencyConvertDialog(toConvert, InvoiceDetailLine.this.conversionService);
                    dlg.center();
                    dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
                        @Override
                        public void onClose(CloseEvent<PopupPanel> event) {
                            txUnitPrice.setAmount(ccb.getToAmount());
                            invoiceDetail.setPrice(ccb.getToAmount());
                            valuesChanged();
                        }
                    });
                } else {
                    valuesChanged();
                }
            }
        }, parent.getProductListService(), parent.getProductSaveService());
        sbProductService.setTabIndex(-1);
        sbProductService.setProduct(invoiceDetail.fProductID.getValue(), invoiceDetail.fName.getValue(), invoiceDetail.getDescription(), invoiceDetail.getPrice());

        txDescription = new TextBox();
        txDescription.setTabIndex(-1);
        txDescription.setText(invoiceDetail.getDescription());

        txUnitPrice = new NumberTextBox(parent.getInvoice().getCurrency()) {
            public void stopEdit() {
                super.stopEdit();
                invoiceDetail.setPrice(getAmount());
                valuesChanged();
            }
        };
        txUnitPrice.setTabIndex(-1);

        txQuantity = new NumberTextBox() {
            public void stopEdit() {
                super.stopEdit();
                invoiceDetail.setQuantity(getAmount());
                valuesChanged();
            }
        };
        txQuantity.setTabIndex(-1);

        sbTax1 = new TaxInfoSelect(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                TaxInfo tax = (TaxInfo) pojo;
                if (!parent.getTaxes().containsKey(tax.getId())) {
                    parent.getTaxes().put(tax.getId(), tax);
                }
                invoiceDetail.fTax1ID.setValue(tax.getId());
                valuesChanged();
            }
        }, parent.getTaxListService(), parent.getTaxSaveService());
        sbTax1.setTabIndex(-1);

        sbTax2 = new TaxInfoSelect(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                TaxInfo tax = (TaxInfo) pojo;
                if (!parent.getTaxes().containsKey(tax.getId())) {
                    parent.getTaxes().put(tax.getId(), tax);
                }
                invoiceDetail.fTax2ID.setValue(tax.getId());
                valuesChanged();
            }
        }, parent.getTaxListService(), parent.getTaxSaveService());
        sbTax2.setTabIndex(-1);

        txTotalPrice = new NumberTextBox(parent.getInvoice().getCurrency());
        txTotalPrice.setTabIndex(-1);
        txTotalPrice.setReadOnly(true);
        toolbar = new TableDetailToolbar();
        toolbar.setVisible(true);
        toolbar.setWidth("100%");
        toolbar.getBtDelete().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                parent.removeLine(InvoiceDetailLine.this);
                parent.callHandler();
            }
        });
        toolbar.getBtMoveUp().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                parent.moveUp(InvoiceDetailLine.this);
            }
        });
        toolbar.getBtMoveDown().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                parent.moveDown(InvoiceDetailLine.this);
            }
        });
        addValidators();
        setLineValues();
    }

    public void saveValuesFromUi() {
        invoiceDetail.setDescription(txDescription.getText());
    }

    public void removeValidators() {
        parent.getValidator().removeValidators("Description" + this);
    }

    public void setLineValues() {
        txUnitPrice.setAmount(invoiceDetail.getPrice());
        txQuantity.setAmount(invoiceDetail.getQuantity());
        double totalPrice = invoiceDetail.getPrice().doubleValue() * invoiceDetail.getQuantity().doubleValue();
        if (invoiceDetail.fTax1ID.getValue() != null) {
            TaxInfo tax = parent.getTaxes().get(invoiceDetail.fTax1ID.getValue());
            if (tax != null) {
                sbTax1.setPojo(tax);
                totalPrice += invoiceDetail.getTaxValue(tax);
            }
        }
        if (invoiceDetail.fTax2ID.getValue() != null) {
            TaxInfo tax = parent.getTaxes().get(invoiceDetail.fTax2ID.getValue());
            if (tax != null) {
                sbTax2.setPojo(tax);
                totalPrice += invoiceDetail.getTaxValue(tax);
            }
        }
        txTotalPrice.setAmount(totalPrice);
    }

    public boolean isEmpty() {
        return
                invoiceDetail.fProductID.getValue() == null &&
                        txDescription.getText().isEmpty();
    }

    // private methods --------------------
    private void valuesChanged() {
        setLineValues();
        parent.callHandler();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void addValidators() {
        FocusAction focusAction = new FocusAction();
        parent.getValidator().addValidators("Description" + this,
                new NotEmptyValidator(txDescription, true, "required")
                        .addActionForFailure(focusAction)
                        .addActionForFailure(new StyleAction("validation-failed")));
    }
}
