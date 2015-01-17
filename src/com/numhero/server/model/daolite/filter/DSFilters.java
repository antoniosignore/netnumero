package com.numhero.server.model.daolite.filter;

public class DSFilters {

    public static DSFilter ge(String fieldName, Object value) {
        return new DSFilter(fieldName).greaterThanOrEqualTo(value);
    }

    public static DSFilter lt(String fieldName, Object value) {
        return new DSFilter(fieldName).lessThan(value);
    }

    public static DSFilter gt(String fieldName, Object value) {
        return new DSFilter(fieldName).greaterThan(value);
    }

    public static DSFilter eq(String fieldName, Enum<?> value) {
        String s = value != null ? value.name() : null;
        return new DSFilter(fieldName).equalsTo(s);
    }

    public static DSFilter eq(String fieldName, Object value) {
        return new DSFilter(fieldName).equalsTo(value);
    }

    public static DSFilter le(String fieldName, Object value) {
        return new DSFilter(fieldName).lessThanOrEqualTo(value);
    }

    public static DSFilter ne(String fieldName, Object value) {
        return new DSFilter(fieldName).notEqualTo(value);
    }

    public static DSFilter[] createArray(DSFilter[] f1, DSFilter... f2) {
        DSFilter[] ret = new DSFilter[f1.length + f2.length];
        System.arraycopy(f1, 0, ret, 0, f1.length);
        System.arraycopy(f2, 0, ret, f1.length, f2.length);
        return ret;
    }

    public static DSFilter nullFilter() {
        return new NullDSFilter();
    }
}
