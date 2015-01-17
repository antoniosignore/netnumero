package com.numhero.client.util;

import com.google.gwt.core.client.GWT;


public class Log {


    private static final Logger logger = GWT.isScript() ? new FireBugLogger() : new HostedModeLogger();

    public static void debug(String message) {
        logger.debug(message);
    }

//    protected static void log(Level level, String message) {
//
//        if (enabled && level.getWeight() <= getMaxLevel().getWeight()) {
//
//            switch (level) {
//
//                case ERROR:
//                    logger.error(message);
//                    break;
//
//                case WARN:
//                    logger.warn(message);
//                    break;
//
//                case INFO:
//                    logger.info(message);
//                    break;
//
//                case DEBUG:
//                    logger.debug(message);
//                    break;
//            }
//        }
//    }

}
