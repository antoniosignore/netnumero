package com.numhero.server.model.daolite;

import com.numhero.shared.pojoc.EntityPojo;

public interface PojoSelector<T extends EntityPojo> {
    T invoke();
}
