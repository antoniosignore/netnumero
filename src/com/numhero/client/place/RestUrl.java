package com.numhero.client.place;

import com.numhero.client.util.CoreUtils;

import java.util.ArrayList;
import java.util.List;

public class RestUrl {
    private static final String DEFAULT_PRESENTER = "invoices";

    private String presenterUrl;
    private List<String> params = new ArrayList<String>();

    public RestUrl(String url) {
        parseUrl(url);
    }

    @Override
    public String toString() {

        return presenterUrl + concatParams();
    }

    private String concatParams() {
        StringBuffer sb = new StringBuffer();

        for (String param : params) {
            sb.append("/");
            sb.append(param);
        }

        return sb.toString();
    }

    private void parseUrl(String url) {

//        String pageUrl = afterHash(url);
        String[] sl = url.split("/");
        int l = sl.length;
        if (l > 0) {
            presenterUrl = sl[0];
        } else {
            presenterUrl = DEFAULT_PRESENTER;
        }

        params.clear();
        if (l > 1) {
            for (int i = 1; i < l; i++) {
                params.add(sl[i]);
            }
        }

        CoreUtils.debug("parsed url:" + url + " presenterUrl:" + presenterUrl + " params:" + params);
    }

//    private String afterHash(String url) {
//        int hp = url.indexOf("#");
//        if (hp == -1) {
//            return "";
//        } else {
//            return url.substring(hp + 1);
//        }
//    }

    public String getPresenterUrl() {
        return presenterUrl;
    }

    public List<String> getParams() {
        return params;
    }

    public Long getId() {
        if (params.size() > 0) {
            if (params.get(0).length() == 0)
                return null;
            else
                return new Long(params.get(0));
        } else
            return null;
    }

    public String getParam1() {
        if (params.size() > 1)
            return params.get(1);
        else
            return null;
    }

    public String getParam2() {
        if (params.size() > 2)
            return params.get(2);
        else
            return null;
    }
}
