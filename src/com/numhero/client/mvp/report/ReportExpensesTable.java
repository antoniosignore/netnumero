package com.numhero.client.mvp.report;

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.client.util.CoreUtils;

import java.util.List;

public class ReportExpensesTable extends AbstractTableForEntities<ExpenseReceipt> {

    @Override
    public void setEntities(List<ExpenseReceipt> expenseReceipts) {
        removeAllRows();
        if (expenseReceipts != null)
            CoreUtils.debug("expenseReceipts.size() = " + expenseReceipts.size());
        for (int row = 0; row < expenseReceipts.size(); row++) {
            ExpenseReceipt entry = expenseReceipts.get(row);
            setText(row, 0, entry.fDate.getValueAsString());
            setText(row, 1, entry.fStaffName.getValue());
            setText(row, 2, entry.fClientSupplierName.getValue());
            setText(row, 3, entry.fValue.getValueAsString());
            setText(row, 4, ClientCache.getCurrentBA().fCurrency.getValueAsString());
            setText(row, 5, entry.fCategoryName.getValueAsString());
            setText(row, 6, entry.fReceiptStatus.getValue().toString());
            setText(row, 7, entry.fInvoiceStatus.getValueAsString());
        }
        addEmptyStatus();

    }


	protected void setHeader() {
        setHeader(0, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(1, Application.getConstants().staff(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().client(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().amount(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
        setHeader(5, Application.getConstants().category(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(6, Application.getConstants().staffStatus(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
        setHeader(7, Application.getConstants().status(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
    }
}
