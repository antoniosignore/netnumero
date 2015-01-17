package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

public class ProjectExpensesTable extends AbstractTableForEntities<ExpenseReceipt> {

    private List<ExpenseReceipt> expenseReceipts;
    private PlaceManager eventManager;
    private Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService;
    private Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService;


         //todo Mikado remove one of the two constructors  UiFactory or UiConstructor
    public ProjectExpensesTable() {
        this(Application.injector.getPlaceManager(),
             new Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>>(Application.injector.getAsyncService()),
             new Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse>(Application.injector.getAsyncService()));
    }

    public ProjectExpensesTable(PlaceManager eventManager,
                                Service<ListCommandRequest, ListCommandResponse<CurrencyEnum>> getCurrenciesService,
                                Service<SaveBusinessAccountRequest, SaveBusinessAccountResponse> businessAccountSaveService) {
        this.eventManager = eventManager;
        this.getCurrenciesService = getCurrenciesService;
        this.businessAccountSaveService = businessAccountSaveService;
    }

    @Override
    public void setEntities(List<ExpenseReceipt> expenseReceipts) {
        this.expenseReceipts = expenseReceipts; //TODO remove it and put logic in the controller
        removeAllRows();
        if (expenseReceipts != null) {
            for (int row = 0; row < expenseReceipts.size(); row++) {
                final ExpenseReceipt entry = expenseReceipts.get(row);
                HTML hID = new HTML("<a href='#pettyexpense/" + entry.getId() + "'>" + DateTimeFormat.getShortDateFormat().format(entry.fDate.getValue()) + "</a>");
                setWidget(row, 0, getCheckbox(entry.getId()));
                setWidget(row, 1, hID);
                setText(row, 2, entry.fStaffName.getValue());
                setText(row, 3, entry.fClientSupplierName.getValue());

                final NumberTextBox amount = new NumberTextBox(entry.fCurrency.getValue()) {
                    public void stopEdit() {
                        super.stopEdit();
                        eventManager.fireEvent(new ProjectValuationChangedEvent("expense amount change"));
                    }
                };
                amount.setAmount(entry.fValue.getValue());

                final CurrencySelect currency = new CurrencySelect(getCurrenciesService, businessAccountSaveService);
                currency.setPojo(entry.fCurrency.getValue());
                currency.setWidth("60px");
                currency.setHandler(createDropDownHandler(amount));

                setWidget(row, 4, currency);
                setWidget(row, 5, amount);
                setText(row, 6, entry.fCategoryName.getValueAsString());
                setText(row, 7, entry.fInvoiceStatus.getValueAsString());
            }
        }
        addEmptyStatus();

    }


    private DropDownBoxHandler createDropDownHandler(final NumberTextBox amount) {
        return new DropDownBoxHandler() {
            @Override
            public void itemSelected(Suggestion pojo) {
                CurrencyEnum currency = (CurrencyEnum) pojo;
                amount.setCurrency(currency);
                eventManager.fireEvent(new ProjectValuationChangedEvent("expense currency change"));
            }
        };
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
    }

    public List<ExpenseReceipt> getExpenses() {
        return expenseReceipts;
    }

    public List<ExpenseReceipt> getCheckedExpenses() {
        List<ExpenseReceipt> checkedEntries = new ArrayList<ExpenseReceipt>();
        if (this.expenseReceipts != null) {
            for (int row = 0; row < expenseReceipts.size(); row++) {
                ExpenseReceipt entry = expenseReceipts.get(row);
                CheckBox box = (CheckBox) getWidget(row, 0);
                if (box.getValue()) {
                    checkedEntries.add(entry);
                }
            }
        }
        return checkedEntries;
    }

    public void setHandler(ClickHandler handler) {
        if (this.expenseReceipts != null) {
            for (int row = 0; row < expenseReceipts.size(); row++) {
                ((CheckBox) getWidget(row, 0)).addClickHandler(handler);
            }
        }
    }

    public int getRowCount() {
        return table.getRowCount();
    }
}
