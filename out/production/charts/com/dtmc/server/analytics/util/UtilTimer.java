// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilTimer.java

package com.dtmc.server.analytics.util;


public class UtilTimer
{

    public UtilTimer()
    {
        lastMessage = null;
        log = false;
        lastMessageTime = realStartTime = startTime = System.currentTimeMillis();
        lastMessage = "Begin";
    }

    public String timerString(String message)
    {
        return timerString(message, getClass().getName());
    }

    public String timerString(String message, String module)
    {
        long tsStart = System.currentTimeMillis();
        String retString = (new StringBuilder()).append("[[").append(message).append("- total:").append(secondsSinceStart()).append(",since last(").append(lastMessage.length() <= 20 ? lastMessage : (new StringBuilder()).append(lastMessage.substring(0, 17)).append("...").toString()).append("):").append(secondsSinceLast()).append("]]").toString();
        lastMessage = message;
        lastMessageTime = System.currentTimeMillis();
        startTime += lastMessageTime - tsStart;
        return retString;
    }

    public double secondsSinceStart()
    {
        return (double)timeSinceStart() / 1000D;
    }

    public double secondsSinceLast()
    {
        return (double)timeSinceLast() / 1000D;
    }

    public long timeSinceStart()
    {
        long currentTime = System.currentTimeMillis();
        return currentTime - startTime;
    }

    public long timeSinceLast()
    {
        long currentTime = System.currentTimeMillis();
        return currentTime - lastMessageTime;
    }

    public void setLog(boolean log)
    {
        this.log = log;
    }

    public boolean getLog()
    {
        return log;
    }

    public String timerString(int level, String message)
    {
        StringBuffer retStringBuf = new StringBuffer();
        for(int i = 0; i < level; i++)
            retStringBuf.append("| ");

        retStringBuf.append("(");
        String timeSinceStartStr = String.valueOf(timeSinceStart());
        retStringBuf.append((new StringBuilder()).append(timeSinceStartStr).append(",").toString());
        String timeSinceLastStr = String.valueOf(timeSinceLast());
        retStringBuf.append(timeSinceLastStr);
        retStringBuf.append(")");
        int spacecount = (12 + 2 * level) - retStringBuf.length();
        for(int i = 0; i < spacecount; i++)
            retStringBuf.append(' ');

        retStringBuf.append(message);
        lastMessageTime = System.currentTimeMillis();
        String retString = retStringBuf.toString();
        return retString;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilTimer.getName();
    long realStartTime;
    long startTime;
    long lastMessageTime;
    String lastMessage;
    boolean log;

}
