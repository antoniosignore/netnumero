package com.numhero.server.utils;

import com.numhero.server.model.daolite.BaseDao;
import com.numhero.shared.datacargo.BulkActionResponse;

import java.util.List;

public class BulkCommandUtils {


    public static void deleteIdList(BulkActionResponse resp, List<Long> ids, BaseDao dao) {
        for (Long s : ids) {
            try {
                dao.delete(s);
                resp.getSuccessIdList().add(s);
            } catch (Exception e) {
                resp.getFailureIdList().add(s);
            }
        }
        resp.setMessage("OK");
    }
}
