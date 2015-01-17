package com.numhero.client.model.datacargo.staff;

import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.shared.datacargo.GetSingleEntityResponse;

import java.util.List;

public class GetStaffResponse extends GetSingleEntityResponse<Staff> {
    private List<ExpenseReceipt> remboursableExpenses;

    public List<ExpenseReceipt> getRemboursableExpenses() {
        return remboursableExpenses;
    }

    public void setRemboursableExpenses(List<ExpenseReceipt> remboursableExpenses) {
        this.remboursableExpenses = remboursableExpenses;
    }
}
