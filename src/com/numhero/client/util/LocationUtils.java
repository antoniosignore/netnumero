package com.numhero.client.util;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;

public final class LocationUtils {

	public static final String CUSTOMER_ACCOUNT_LOGIN_URL = "https://www.netnumero.com/customer/account/login/";
	public static final String GET_USER_DATA_URL = "https://www.netnumero.com/catalog/category/getUserData";	
//
//	public static native void setNeedToConfirmExit(boolean needToConfirmExit) /*-{
//		$wnd.needToConfirmExit = needToConfirmExit;
//	}-*/;

    public static void redirect(String url) {
        Window.Location.assign(URL.encode(url));
    }


}
