package com.numhero.client.mvp.report.profitloss;

import java.util.HashMap;
import java.util.Map;

public class MonthlyMap {

    private Map<Integer, Double> monthlyExpenses = new HashMap<Integer, Double>();

    public MonthlyMap() {
        monthlyExpenses.put(0, 0D);
        monthlyExpenses.put(1, 0D);
        monthlyExpenses.put(2, 0D);
        monthlyExpenses.put(3, 0D);
        monthlyExpenses.put(4, 0D);
        monthlyExpenses.put(5, 0D);
        monthlyExpenses.put(6, 0D);
        monthlyExpenses.put(7, 0D);
        monthlyExpenses.put(8, 0D);
        monthlyExpenses.put(9, 0D);
        monthlyExpenses.put(10, 0D);
        monthlyExpenses.put(11, 0D);
    }

    public void addAmount(Integer month, Double amount) {
        monthlyExpenses.put(month, monthlyExpenses.get(month) + amount);
    }

    public Double getAmount(Integer month) {
        return monthlyExpenses.get(month);
    }

}
