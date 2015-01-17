package com.numhero.client.mvp.staff;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest;
import com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.client.mvp.currency.CurrencyConvertBean;
import com.numhero.client.mvp.currency.CurrencyConvertDialog;
import com.numhero.client.service.Service;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

public class ReimbursableExpensesTable extends AbstractTableForEntities<ExpenseReceipt> {
    private Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService;
    private Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService;

        //todo Mikado remove one of the two constructors
    public ReimbursableExpensesTable() {
        this(new Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>>(Application.injector.getAsyncService()),
             new Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse>(Application.injector.getAsyncService()));
    }

    public ReimbursableExpensesTable(
                                Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService,
                                Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        this.getCurrenciesService = getCurrenciesService;
        this.businessAccountSaveService = businessAccountSaveService;
    }

    public List<Long> getSelectedIds() {
        int rowCount = table.getRowCount();
        List<Long> ids = new ArrayList<Long>();
        for (int i = 0; i < rowCount; i++) {
            CheckBox box = (CheckBox) table.getWidget(i, 0);
            if (box != null && box.getValue()) {
                ids.add(Long.parseLong(box.getFormValue()));
            }
        }
        CoreUtils.debug("ids = " + ids);
        return ids;
    }

    @Override
    public void setEntities(List<ExpenseReceipt> expenseReceipts) {
        removeAllRows();
        for (int row = 0; row < expenseReceipts.size(); row++) {
            ExpenseReceipt entry = expenseReceipts.get(row);
            setWidget(row, 0, getCheckbox(entry.getId()));
            setText(row, 1, entry.fDate.getValueAsString());
            setText(row, 2, entry.fStaffName.getValue());
            setText(row, 3, entry.fClientSupplierName.getValue());

            setCurrencyAmount(row, entry);

            setText(row, 6, entry.fCategoryName.getValueAsString());
            setText(row, 7, entry.fInvoiceStatus.getValueAsString());
            setText(row, 8, entry.fReceiptStatus.getValueAsString());
        }
        addEmptyStatus();
        setCheckedExpensesPrice();
    }


	private void setCurrencyAmount(int row, final ExpenseReceipt entry) {
        final CurrencySelect currencyComboBox = new CurrencySelect(getCurrenciesService, businessAccountSaveService);
        currencyComboBox.setPojo(entry.fCurrency.getValue());
        currencyComboBox.setWidth("60px");

        final NumberTextBox amount = new NumberTextBox(entry.fCurrency.getValue()) {
            public void stopEdit() {
                super.stopEdit();
                setCheckedExpensesPrice();
            }
        };
        amount.setWidth("100px");
        amount.setAmount(entry.fValue.getValue());

        currencyComboBox.setHandler(new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                CurrencyEnum currency = (CurrencyEnum) pojo;
                setCheckedExpensesPrice();
                amount.setCurrency(currency);
            }
        });

        setWidget(row, 4, currencyComboBox);
        setWidget(row, 5, amount);
    }

    private void setCheckedExpensesPrice() {
        int rowCount = table.getRowCount();
        CoreUtils.debug("rowCount = " + rowCount);
        for (int i = 0; i < rowCount; i++) {
        	if (table.getCellCount(i) > 4) {
                CurrencySelect currency = (CurrencySelect) table.getWidget(i, 4);
                if (currency.getPojo() != ClientCache.getCurrentBA().fCurrency.getValue()) {
                    table.getWidget(i, 4).setStyleName("error-cell");
                } else {
                    table.getWidget(i, 4).setStyleName("gwt-ListBox");
                }
        	}
        }
    }

    protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().staff(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().client(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().amount(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(6, Application.getConstants().category(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(7, Application.getConstants().billed(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
        setHeader(8, Application.getConstants().reimbursed(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
    }

    public void convertCurrencies(Service<GetCurrencyConversionRequest, GetCurrencyConversionResponse> conversionService) {
        CoreUtils.debug("ReimbursableExpensesTable.convertCurrencies");

        final List<CurrencyConvertBean> toConvert = new ArrayList<CurrencyConvertBean>();
        for (int i = 0; i < table.getRowCount(); i++) {
        	if (table.getCellCount(i) > 5) {
                CurrencySelect cbCurrency = (CurrencySelect) table.getWidget(i, 4);
                NumberTextBox txAmount = (NumberTextBox) table.getWidget(i, 5);
                if (cbCurrency.getPojo() != ClientCache.getCurrentBA().fCurrency.getValue()) {
                    CurrencyConvertBean ccb = new CurrencyConvertBean();
                    ccb.setFromAmount(txAmount.getAmount());
                    ccb.setFromCurrency(cbCurrency.getPojo());
                    ccb.setToAmount(0);
                    ccb.setToCurrency(ClientCache.getCurrentBA().fCurrency.getValue());
                    toConvert.add(ccb);
                }
        	}
        }

        CurrencyConvertDialog dlg = new CurrencyConvertDialog(toConvert, conversionService);
        dlg.center();
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                for (int i = 0, toConvertIndex = 0; i < table.getRowCount(); i++) {
                    CurrencySelect cbCurrency = (CurrencySelect) table.getWidget(i, 4);
                    NumberTextBox txAmount = (NumberTextBox) table.getWidget(i, 5);
                    if (cbCurrency.getPojo() != ClientCache.getCurrentBA().fCurrency.getValue()) {
                        CurrencyConvertBean ccb = toConvert.get(toConvertIndex);
                        cbCurrency.setPojo(ccb.getToCurrency());
                        txAmount.setCurrency(ccb.getToCurrency());
                        txAmount.setAmount(ccb.getToAmount());
                        toConvertIndex++;
                    }
                }
            }
        });
    }
}
