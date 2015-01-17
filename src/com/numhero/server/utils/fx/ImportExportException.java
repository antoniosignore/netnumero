package com.numhero.server.utils.fx;

public class ImportExportException extends Throwable {
    private static final long serialVersionUID = 5569968258408626902L;

    public ImportExportException(String message) {
        super(message);
    }

    public ImportExportException(String message, Throwable cause) {
        super(message, cause);
    }
}
