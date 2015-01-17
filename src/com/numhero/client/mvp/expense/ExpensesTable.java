package com.numhero.client.mvp.expense;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.client.util.CoreUtils;

import java.util.ArrayList;
import java.util.List;

public class ExpensesTable extends AbstractTableForEntities<ExpenseReceipt> {


    @Override
    public void setEntities(List<ExpenseReceipt> expenseReceipts) {
        removeAllRows();
        if (expenseReceipts != null) {
            for (int row = 0; row < expenseReceipts.size(); row++) {
                ExpenseReceipt entry = expenseReceipts.get(row);
                HTML hID = new HTML("<a href='#pettyexpense/" + entry.getId() + "'>" + DateTimeFormat.getShortDateFormat().format(entry.fDate.getValue()) + "</a>");
                setWidget(row, 0, getCheckbox(entry.getId()));
                setWidget(row, 1, hID);
                setText(row, 2, entry.fStaffName.getValue());
                setText(row, 3, entry.fClientSupplierName.getValue());
                setText(row, 4, entry.fValue.getValueAsString());
                setText(row, 5, entry.fCurrency.getValueAsString());
                setText(row, 6, entry.fCategoryName.getValueAsString());
                setText(row, 7, entry.fInvoiceStatus.getValueAsString());
                setText(row, 8, entry.fReceiptStatus.getValueAsString());
            }
        }
        addEmptyStatus();
    }


	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().staff(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().client(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().amount(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(6, Application.getConstants().category(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(7, Application.getConstants().billed(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
        setHeader(8, Application.getConstants().teamStatus(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
    }

//    public List<ExpenseReceipt> getExpenses() {
//        return expenseReceipts;
//    }
//
//    public List<ExpenseReceipt> getCheckedExpenses() {
//        List<ExpenseReceipt> checkedEntries = new ArrayList<ExpenseReceipt>();
//        if (this.expenseReceipts != null)
//            for (int row = 0; row < expenseReceipts.size(); row++) {
//                ExpenseReceipt entry = expenseReceipts.get(row);
//                CheckBox box = (CheckBox) getWidget(row, 0);
//                if (box.getValue()) {
//                    checkedEntries.add(entry);

    //                }
//            }
//        return checkedEntries;
//    }
//
//    public void setHandler(ClickHandler handler) {
//        if (this.expenseReceipts != null)
//            for (int row = 0; row < expenseReceipts.size(); row++) {
//                ((CheckBox) getWidget(row, 0)).addClickHandler(handler);
//            }
//    }
//
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

}
