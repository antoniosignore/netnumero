package com.numhero.server.utils;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.pojoc.BAPojo;

public class DaoUtils {

    public static void setData(CommandRequest request, BAPojo pojo) {
        pojo.fBusinessAccountUri.setValue(request.getBusinessAccountId());
    }
}
