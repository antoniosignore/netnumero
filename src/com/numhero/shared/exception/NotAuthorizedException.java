package com.numhero.shared.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

public class NotAuthorizedException extends ClientWarningException implements IsSerializable {

    public NotAuthorizedException(String msg) {
        super(msg);

    }

    public NotAuthorizedException() {
        super();

    }

}
