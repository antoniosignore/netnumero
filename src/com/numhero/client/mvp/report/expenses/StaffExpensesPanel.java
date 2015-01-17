package com.numhero.client.mvp.report.expenses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.inject.Inject;
import com.numhero.client.model.datacargo.client_supplier.ClientListRequest;
import com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse;
import com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest;
import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.mvp.clientsupplier.ClientSelect;
import com.numhero.client.mvp.report.ReportExpensesTable;
import com.numhero.client.service.Service;
import com.numhero.client.widget.CustomFormatDateBox;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ReceiptClientStatusComboBox;
import com.numhero.client.widget.combobox.ReceiptStaffStatusComboBox;
import com.numhero.shared.datacargo.SaveSingleEntityResponse;

public class StaffExpensesPanel extends Composite implements DropDownBox.DropDownBoxHandler {

    interface ExpenseUiBinder extends UiBinder<HTMLPanel, StaffExpensesPanel> {
    }

    private static ExpenseUiBinder uiBinder = GWT.create(ExpenseUiBinder.class);

    @UiField
    CustomFormatDateBox from;

    @UiField
    CustomFormatDateBox to;

    @UiField
    NetNumeroButton btRefresh;

    @UiField
    ReportExpensesTable unbilledExpensesTable;

    @UiField(provided = true)
    ClientSelect sbClient;

    @UiField
    ReceiptStaffStatusComboBox receiptStaffStatusComboBox;

    @UiField
    ReceiptClientStatusComboBox receiptClientStatusComboBox;

    private ClientSupplier client;

    @Inject
    public StaffExpensesPanel(final Service<ClientListRequest, ClientSupplierListResponse> clientSuppliersService,
                              final Service<SaveClientSupplierRequest, SaveSingleEntityResponse> clientSupplierSaveService
    ) {
        sbClient = new ClientSelect(this, clientSuppliersService, clientSupplierSaveService);
        initWidget(uiBinder.createAndBindUi(this));

        unbilledExpensesTable.hideNavigationButtons();

    }

    public CustomFormatDateBox getFrom() {
        return from;
    }

    public void setFrom(CustomFormatDateBox from) {
        this.from = from;
    }

    public CustomFormatDateBox getTo() {
        return to;
    }

    public void setTo(CustomFormatDateBox to) {
        this.to = to;
    }

    public ReportExpensesTable getUnbilledExpensesTable() {
        return unbilledExpensesTable;
    }

    public NetNumeroButton getBtRefresh() {
        return btRefresh;
    }

    @Override
    public void itemSelected(Suggestion pojo) {
        client = (ClientSupplier) pojo;
    }

    public ClientSupplier getClient() {
        return client;
    }

    public ReceiptStaffStatusComboBox getReceiptStatusComboBox() {
        return receiptStaffStatusComboBox;
    }

    public ReceiptStaffStatusComboBox getReceiptStaffStatusComboBox() {
        return receiptStaffStatusComboBox;
    }

    public ReceiptClientStatusComboBox getReceiptClientStatusComboBox() {
        return receiptClientStatusComboBox;
    }
}
