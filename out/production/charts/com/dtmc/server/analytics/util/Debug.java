// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Debug.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.*;
import org.apache.log4j.*;
import org.apache.log4j.spi.LoggerRepository;

// Referenced classes of package com.dtmc.server.analytics.util:
//            UtilURL, FlexibleProperties, UtilProperties

public final class Debug
{

    public Debug()
    {
    }

    public static PrintStream getPrintStream()
    {
        return printStream;
    }

    public static void setPrintStream(PrintStream printStream)
    {
        printStream = printStream;
        printWriter = new PrintWriter(printStream);
    }

    public static PrintWriter getPrintWriter()
    {
        return printWriter;
    }

    public static Logger getLogger(String module)
    {
        if(module != null && module.length() > 0)
            return Logger.getLogger(module);
        else
            return root;
    }

    public static Integer getLevelFromString(String levelName)
    {
        if(levelName == null)
            return null;
        else
            return (Integer)levelStringMap.get(levelName.toLowerCase());
    }

    public static int getLevelFromStringWithDefault(String levelName)
    {
        Integer levelInt = getLevelFromString(levelName);
        if(levelInt == null)
            return 3;
        else
            return levelInt.intValue();
    }

    public static void log(int level, Throwable t, String msg, String module)
    {
        log(level, t, msg, module, "org.ofbiz.base.util.Debug");
    }

    public static void log(int level, Throwable t, String msg, String module, String callingClass)
    {
        if(isOn(level))
        {
            Logger logger = getLogger(module);
            if(SYS_DEBUG != null)
                logger.setLevel(Level.DEBUG);
            logger.log(callingClass, levelObjs[level], msg, t);
        }
    }

    public static boolean isOn(int level)
    {
        return levelOnCache[level];
    }

    public static void log(String msg)
    {
        log(0, null, msg, "NoModule");
    }

    public static void log(Throwable t)
    {
        log(0, t, null, "NoModule");
    }

    public static void log(String msg, String module)
    {
        log(0, null, msg, module);
    }

    public static void log(Throwable t, String module)
    {
        log(0, t, null, module);
    }

    public static void log(Throwable t, String msg, String module)
    {
        log(0, t, msg, module);
    }

    public static boolean verboseOn()
    {
        return isOn(1);
    }

    public static void logVerbose(String msg, String module)
    {
        log(1, null, msg, module);
    }

    public static void logVerbose(Throwable t, String module)
    {
        log(1, t, null, module);
    }

    public static void logVerbose(Throwable t, String msg, String module)
    {
        log(1, t, msg, module);
    }

    public static boolean timingOn()
    {
        return isOn(2);
    }

    public static void logTiming(String msg, String module)
    {
        log(2, null, msg, module);
    }

    public static void logTiming(Throwable t, String module)
    {
        log(2, t, null, module);
    }

    public static void logTiming(Throwable t, String msg, String module)
    {
        log(2, t, msg, module);
    }

    public static boolean infoOn()
    {
        return isOn(3);
    }

    public static void logInfo(String msg, String module)
    {
        log(3, null, msg, module);
    }

    public static void logInfo(Throwable t, String module)
    {
        log(3, t, null, module);
    }

    public static void logInfo(Throwable t, String msg, String module)
    {
        log(3, t, msg, module);
    }

    public static boolean importantOn()
    {
        return isOn(4);
    }

    public static void logImportant(String msg, String module)
    {
        log(4, null, msg, module);
    }

    public static void logImportant(Throwable t, String module)
    {
        log(4, t, null, module);
    }

    public static void logImportant(Throwable t, String msg, String module)
    {
        log(4, t, msg, module);
    }

    public static boolean warningOn()
    {
        return isOn(5);
    }

    public static void logWarning(String msg, String module)
    {
        log(5, null, msg, module);
    }

    public static void logWarning(Throwable t, String module)
    {
        log(5, t, null, module);
    }

    public static void logWarning(Throwable t, String msg, String module)
    {
        log(5, t, msg, module);
    }

    public static boolean errorOn()
    {
        return isOn(6);
    }

    public static void logError(String msg, String module)
    {
        log(6, null, msg, module);
    }

    public static void logError(Throwable t, String module)
    {
        log(6, t, null, module);
    }

    public static void logError(Throwable t, String msg, String module)
    {
        log(6, t, msg, module);
    }

    public static boolean fatalOn()
    {
        return isOn(7);
    }

    public static void logFatal(String msg, String module)
    {
        log(7, null, msg, module);
    }

    public static void logFatal(Throwable t, String module)
    {
        log(7, t, null, module);
    }

    public static void logFatal(Throwable t, String msg, String module)
    {
        log(7, t, msg, module);
    }

    public static void set(int level, boolean on)
    {
        levelOnCache[level] = on;
    }

    public static final boolean useLog4J = true;
    public static final String noModuleModule = "NoModule";
    static DateFormat dateFormat = DateFormat.getDateTimeInstance(3, 2);
    public static final String SYS_DEBUG = System.getProperty("DEBUG");
    public static final int ALWAYS = 0;
    public static final int VERBOSE = 1;
    public static final int TIMING = 2;
    public static final int INFO = 3;
    public static final int IMPORTANT = 4;
    public static final int WARNING = 5;
    public static final int ERROR = 6;
    public static final int FATAL = 7;
    public static final String levels[] = {
        "Always", "Verbose", "Timing", "Info", "Important", "Warning", "Error", "Fatal"
    };
    public static final String levelProps[] = {
        "", "print.verbose", "print.timing", "print.info", "print.important", "print.warning", "print.error", "print.fatal"
    };
    public static final Level levelObjs[];
    protected static Map levelStringMap;
    protected static PrintStream printStream;
    protected static PrintWriter printWriter;
    protected static boolean levelOnCache[];
    protected static final boolean useLevelOnCache = true;
    protected static Logger root;

    static 
    {
        levelObjs = (new Level[] {
            Level.INFO, Level.DEBUG, Level.DEBUG, Level.INFO, Level.INFO, Level.WARN, Level.ERROR, Level.FATAL
        });
        levelStringMap = new HashMap();
        printStream = System.out;
        printWriter = new PrintWriter(printStream);
        levelOnCache = new boolean[8];
        root = Logger.getRootLogger();
        levelStringMap.put("verbose", new Integer(1));
        levelStringMap.put("timing", new Integer(2));
        levelStringMap.put("info", new Integer(3));
        levelStringMap.put("important", new Integer(4));
        levelStringMap.put("warning", new Integer(5));
        levelStringMap.put("error", new Integer(6));
        levelStringMap.put("fatal", new Integer(7));
        levelStringMap.put("always", new Integer(0));
        PropertyConfigurator.configure(FlexibleProperties.makeFlexibleProperties(UtilURL.fromResource("debug.properties")));
        for(int i = 0; i < 8; i++)
            levelOnCache[i] = i == 0 || UtilProperties.propertyValueEqualsIgnoreCase("debug.properties", levelProps[i], "true");

        if(SYS_DEBUG != null)
        {
            for(int x = 0; x < 8; x++)
                levelOnCache[x] = true;

            LoggerRepository repo = root.getLoggerRepository();
            Logger thisLogger;
            for(Enumeration enumeration = repo.getCurrentLoggers(); enumeration.hasMoreElements(); thisLogger.setLevel(Level.DEBUG))
                thisLogger = (Logger)enumeration.nextElement();

        }
    }
}
