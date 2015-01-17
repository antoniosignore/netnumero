package com.numhero.shared.datacargo;

import com.numhero.shared.pojoc.BAPojo;


public class GetSingleEntityResponse<T extends BAPojo> implements CommandResponse {
    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
