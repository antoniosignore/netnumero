package com.numhero.client.model.datacargo.expense;

import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.shared.datacargo.SaveSingleEntityRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class SaveReceiptRequest extends SaveSingleEntityRequest {

    public SaveReceiptRequest() {
        setCommand(ApplicationCommandEnum.CommandSaveReceipt);
    }

    public ExpenseReceipt getExpense() {
        return (ExpenseReceipt) getEntity();
    }

    public void setExpense(ExpenseReceipt expenseReceiptC) {
        setEntity(expenseReceiptC);
    }
}
