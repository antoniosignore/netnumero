package com.numhero.client.widget.search;

import com.numhero.client.widget.table.AbstractTableWithHeaderAndFooter;
import com.numhero.shared.pojoc.SearchablePojo;

import java.util.Collection;

public abstract class AbstractSearchTable extends AbstractTableWithHeaderAndFooter {

    protected SearchPojoDialog dialog;

    public abstract void setPojoCList(Collection<? extends SearchablePojo> pojoCList);

    public void setDialog(SearchPojoDialog dialog) {
        this.dialog = dialog;
    }

//    @Override
//    protected void setEntities(List<SearchablePojo> entities) {
//        setPojoCList(entities); //TODO simplify and remove doubles
//
//    }
}
