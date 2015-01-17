package com.numhero.client.model.datacargo.home;

import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.pojoc.field.DateField;
import com.numhero.shared.pojoc.field.DoubleField;

public class GetHomeRecapResponse implements CommandResponse {

    public DateField fLastUpdateRecaps;

    public DoubleField fYearCost;
    public DoubleField fYearProfit;
    public DoubleField fYearTurnover;

    public DoubleField fMonthCost;
    public DoubleField fMonthProfit;
    public DoubleField fMonthTurnover;

    public DateField getfLastUpdateRecaps() {
        return fLastUpdateRecaps;
    }

    public void setfLastUpdateRecaps(DateField fLastUpdateRecaps) {
        this.fLastUpdateRecaps = fLastUpdateRecaps;
    }

    public DoubleField getfYearCost() {
        return fYearCost;
    }

    public void setfYearCost(DoubleField fYearCost) {
        this.fYearCost = fYearCost;
    }

    public DoubleField getfYearProfit() {
        return fYearProfit;
    }

    public void setfYearProfit(DoubleField fYearProfit) {
        this.fYearProfit = fYearProfit;
    }

    public DoubleField getfYearTurnover() {
        return fYearTurnover;
    }

    public void setfYearTurnover(DoubleField fYearTurnover) {
        this.fYearTurnover = fYearTurnover;
    }

    public DoubleField getfMonthCost() {
        return fMonthCost;
    }

    public void setfMonthCost(DoubleField fMonthCost) {
        this.fMonthCost = fMonthCost;
    }

    public DoubleField getfMonthProfit() {
        return fMonthProfit;
    }

    public void setfMonthProfit(DoubleField fMonthProfit) {
        this.fMonthProfit = fMonthProfit;
    }

    public DoubleField getfMonthTurnover() {
        return fMonthTurnover;
    }

    public void setfMonthTurnover(DoubleField fMonthTurnover) {
        this.fMonthTurnover = fMonthTurnover;
    }
}
