package com.numhero.client.service;

import com.numhero.client.Application;
import com.numhero.client.util.ClientDialogUtils;
import com.numhero.client.util.CoreUtils;
import com.numhero.client.util.LocationUtils;
import com.numhero.shared.datacargo.CommandResponse;
import com.numhero.shared.exception.ClientWarningException;
import com.numhero.shared.exception.NotAuthorizedException;

public abstract class ServiceCallbackImpl<RESPONSE extends CommandResponse> implements ServiceCallback<RESPONSE> {

	@Override
    public final void onFailure(Throwable th) {
        try {
            throw th;
		} catch (NotAuthorizedException nae) {
			ClientDialogUtils.showErrorMessage("Not Authorized!");
			LocationUtils.redirect(LocationUtils.CUSTOMER_ACCOUNT_LOGIN_URL);
        } catch (ClientWarningException ce) {
        	String message = Application.getConstants().errorMessages().get(ce.getMessage());
        	if (message == null) {
                CoreUtils.debug("no error message for key " + ce.getMessage());
        		message = ce.getMessage() + "\n" + Application.getConstants().generalUntranslatedErrorMessage();
        	} else {
        	    ClientDialogUtils.showErrorMessage(message);
            }
        } catch (Throwable t) {
            ClientDialogUtils.showErrorMessage(Application.getConstants().generalUnexpectedErrorMessage());
            CoreUtils.debug("onFailure", th);
            th.printStackTrace();
            //alert("ERROR " + th.toString());
        }
    }
}
