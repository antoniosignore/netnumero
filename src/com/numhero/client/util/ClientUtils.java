package com.numhero.client.util;

import com.google.gwt.dom.client.Element;
import com.numhero.client.Application;
import com.numhero.client.mvp.BaseView;

import java.util.Collection;
import java.util.List;

import static com.numhero.shared.util.SharedUtils.splitUri;

public class ClientUtils {

    public static String getCompanyNameFromUri(String uri) {
        String[] p = splitUri(uri);

        if (p.length != 3) {
            Log.debug("Error in uri. Wrong number of elements should be 3 but it's " + p.length);
            return null;
        } else if (!p[1].equals("company")) {
            Log.debug("Wrong uri. This should be 'company' " + p[1]);
            return null;
        } else {
            return p[2].toLowerCase();
        }
    }


    public static native boolean embedPdf(String pdfUrl, Element containerDiv) /*-{
        return $wnd.embedPdf(pdfUrl, containerDiv);
	}-*/;

    public static native void openPdf(String pdfUrl) /*-{
		return $wnd.openPdf(pdfUrl);
	}-*/;

    //todo mikado: remove it. Use the one in gridView
    public static boolean warnNotEmptyIds(List<Long> ids, BaseView view) {
        if (ids.isEmpty()) {
            view.showError(Application.getConstants().oneRow());
            return true;
        }
        return false;
    }


    public static double calculateSumOfDoubles(Collection<Double> taxes) {
        double totalTax = 0.0;
        for (Double aTax : taxes) {
            totalTax += aTax;
        }
        return totalTax;
    }

}
