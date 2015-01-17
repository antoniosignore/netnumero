package com.numhero.server.model.daolite;

import com.numhero.shared.pojoc.DetailBasePojo;

public abstract class DetailsDao<T extends DetailBasePojo> extends BaseDao<T>{

    @Override
    protected abstract String getEntityName();
}
