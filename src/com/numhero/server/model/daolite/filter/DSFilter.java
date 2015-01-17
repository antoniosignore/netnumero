package com.numhero.server.model.daolite.filter;

import com.google.appengine.api.datastore.Query;

import java.util.List;

public class DSFilter {
    private String fieldName;
    private Query.FilterOperator operator;
    private Object value;

    public DSFilter(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Query.FilterOperator getOperator() {
        return operator;
    }


    public Object getValue() {
        return value;
    }

    public DSFilter equalsTo(Object value) {
        this.operator = Query.FilterOperator.EQUAL;
        return returnValue(value);
    }

    public DSFilter greaterThan(Object value) {
        this.operator = Query.FilterOperator.GREATER_THAN;
        return returnValue(value);
    }


    public DSFilter greaterThanOrEqualTo(Object value) {
        this.operator = Query.FilterOperator.GREATER_THAN_OR_EQUAL;
        return returnValue(value);
    }

    public DSFilter lessThan(Object value) {
        this.operator = Query.FilterOperator.LESS_THAN;
        return returnValue(value);
    }

    public DSFilter lessThanOrEqualTo(Object value) {
        this.operator = Query.FilterOperator.LESS_THAN_OR_EQUAL;
        return returnValue(value);
    }

    public DSFilter notEqualTo(Object value) {
        this.operator = Query.FilterOperator.NOT_EQUAL;
        return returnValue(value);
    }

    private DSFilter returnValue(Object value) {
        if (value == null) {
            return DSFilters.nullFilter();
        }
        this.value = value;
        return this;
    }


    public DSFilter in(List<String> value) {
        this.operator = Query.FilterOperator.IN;
        return returnValue(value);
    }


    public void addFilter(Query q) {
        q.addFilter(getFieldName(), getOperator(), getValue());
    }

    @Override
    public String toString() {
        return "DSFilter{" +
                "fieldName='" + fieldName + '\'' +
                ", operator='" + operator + '\'' +
                ", value=" + value +
                '}';
    }
}
