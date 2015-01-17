package com.numhero.client.model.datacargo.moneyin;

import com.numhero.client.model.pojoc.MoneyInOutRecapRow;
import com.numhero.shared.datacargo.CommandResponse;

import java.util.ArrayList;
import java.util.List;

public class MoneyInRecapResponse implements CommandResponse {

    List<MoneyInOutRecapRow> rows = new ArrayList<MoneyInOutRecapRow>();

    public List<MoneyInOutRecapRow> getRows() {
        return rows;
    }
}
