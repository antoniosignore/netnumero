package com.numhero.client.widget.image;

public class Image extends com.google.gwt.user.client.ui.Image {
    private static final String REFRESH_PARAMETER = "refreshTime";

    public void refresh() {
        String url = getUrl();
        url = removeRefreshParameter(url);
        if (url.indexOf('?') == -1) {
            url += "?";
        } else {
            if (!url.endsWith("?")) {
                url += "&";
            }
        }
        url += REFRESH_PARAMETER + "=" + System.currentTimeMillis();
        setUrl(url);
    }

    private String removeRefreshParameter(String url) {
        int refreshParameterIndex = url.indexOf(REFRESH_PARAMETER);

        if (refreshParameterIndex == -1)
            return url;

        int separatorIndex = url.indexOf('&', refreshParameterIndex);
        String newUrl = url.substring(0, refreshParameterIndex);

        if (separatorIndex != -1) {
            newUrl += url.substring(separatorIndex + 1);
        }

        return newUrl;
    }
}
