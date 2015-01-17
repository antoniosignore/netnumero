package com.numhero.shared.enums;

public enum BusinessTransactionEnum {

    SaleToClient("Sale to client"),
    ClientPayment("Payment from client"),
    DirectPayment("Direct payment of expense"),
//    BankToCash("Withdraw of cash from bank"),
    SupplierExpense("Expense received from supplier"),
    SupplierPayment("Expense paid to supplier"),
    ReimbursementsPayment("Reimbursement to staff");

    private String value;

    BusinessTransactionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return value;
    }

    public static BusinessTransactionEnum getByValue(String value) {
        BusinessTransactionEnum[] a = BusinessTransactionEnum.values();
        for (int i = 0; i < a.length; i++) {
            BusinessTransactionEnum e = a[i];
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        return null;
    }
}
