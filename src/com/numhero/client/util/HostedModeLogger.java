package com.numhero.client.util;

import com.google.gwt.core.client.GWT;


public class HostedModeLogger implements Logger {

    public void debug(String message) {

        log(toMessageWithLineInformation("DEBUG", message));

    }

    public void log(String message) {
        GWT.log(message, null);
        System.out.println(message); //for unit test
    }

    private String toMessageWithLineInformation(String logLevel, String message) {

        StackTraceElement line = new Throwable().getStackTrace()[4];

        return (logLevel + " " + toLine(line) + " " + message);

    }

    private String toLine(StackTraceElement line) {

        return line.getClassName() + " ("
                + line.getLineNumber() + ")";

    }
}
