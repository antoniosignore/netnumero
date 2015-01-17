// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FlexibleStringExpander.java

package com.dtmc.server.analytics.util;

import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            Debug, FlexibleMapAccessor

public class FlexibleStringExpander
{
    public static class OnTheFlyHandler
        implements ParseElementHandler
    {

        public void handleConstant(String original, int start)
        {
            targetBuffer.append(original.substring(start));
        }

        public void handleConstant(String original, int start, int end)
        {
            targetBuffer.append(original.substring(start, end));
        }

        public void handleVariable(String original, int start, int end)
        {
            String envName = original.substring(start, end);
            FlexibleMapAccessor fma = new FlexibleMapAccessor(envName);
            Object envVal = fma.get(context, locale);
            if(envVal != null)
                targetBuffer.append(envVal.toString());
            else
                Debug.logWarning((new StringBuilder()).append("Could not find value in environment for the name [").append(envName).append("], inserting nothing.").toString(), FlexibleStringExpander.module);
        }

        protected StringBuffer targetBuffer;
        protected Map context;
        protected Locale locale;

        public OnTheFlyHandler(StringBuffer targetBuffer, Map context, Locale locale)
        {
            this.targetBuffer = targetBuffer;
            this.context = context;
            this.locale = locale;
        }
    }

    public static class PreParseHandler
        implements ParseElementHandler
    {

        public void handleConstant(String original, int start)
        {
            stringElements.add(new ConstantElement(original.substring(start)));
        }

        public void handleConstant(String original, int start, int end)
        {
            stringElements.add(new ConstantElement(original.substring(start, end)));
        }

        public void handleVariable(String original, int start, int end)
        {
            stringElements.add(new VariableElement(original.substring(start, end)));
        }

        protected List stringElements;

        public PreParseHandler(List stringElements)
        {
            this.stringElements = stringElements;
        }
    }

    public static interface ParseElementHandler
    {

        public abstract void handleConstant(String s, int i);

        public abstract void handleConstant(String s, int i, int j);

        public abstract void handleVariable(String s, int i, int j);
    }

    public static class VariableElement
        implements StringElement
    {

        public void appendElement(StringBuffer buffer, Map context, Locale locale)
        {
            Object retVal = fma.get(context, locale);
            if(retVal != null)
                buffer.append(retVal.toString());
        }

        protected FlexibleMapAccessor fma;

        public VariableElement(String valueName)
        {
            fma = new FlexibleMapAccessor(valueName);
        }
    }

    public static class ConstantElement
        implements StringElement
    {

        public void appendElement(StringBuffer buffer, Map context, Locale locale)
        {
            buffer.append(value);
        }

        protected String value;

        public ConstantElement(String value)
        {
            this.value = value;
        }
    }

    public static interface StringElement
    {

        public abstract void appendElement(StringBuffer stringbuffer, Map map, Locale locale);
    }


    public FlexibleStringExpander(String original)
    {
        stringElements = new LinkedList();
        this.original = original;
        ParseElementHandler handler = new PreParseHandler(stringElements);
        parseString(original, handler);
    }

    public boolean isEmpty()
    {
        return original == null || original.length() == 0;
    }

    public String getOriginal()
    {
        return original;
    }

    public String expandString(Map context)
    {
        return expandString(context, ((Locale) (null)));
    }

    public String expandString(Map context, Locale locale)
    {
        StringBuffer expanded = new StringBuffer();
        StringElement element;
        for(Iterator stringElementIter = stringElements.iterator(); stringElementIter.hasNext(); element.appendElement(expanded, context, locale))
            element = (StringElement)stringElementIter.next();

        return expandString(expanded.toString(), context);
    }

    public static String expandString(String original, Map context)
    {
        return expandString(original, context, null);
    }

    public static String expandString(String original, Map context, Locale locale)
    {
        if(original == null || original.length() < 3)
            return original;
        int start = original.indexOf("${");
        if(start == -1)
            return original;
        if(original.indexOf("}", start) == -1)
        {
            Debug.logWarning((new StringBuilder()).append("Found a ${ without a closing } (curly-brace) in the String: ").append(original).toString(), module);
            return original;
        } else
        {
            StringBuffer expanded = new StringBuffer();
            ParseElementHandler handler = new OnTheFlyHandler(expanded, context, locale);
            parseString(original, handler);
            return expandString(expanded.toString(), context);
        }
    }

    public static void parseString(String original, ParseElementHandler handler)
    {
        if(original == null || original.length() == 0)
            return;
        int start = original.indexOf("${");
        if(start == -1)
        {
            handler.handleConstant(original, 0);
            return;
        }
        int currentInd = 0;
        int end = -1;
        for(; start != -1; start = original.indexOf("${", currentInd))
        {
            end = original.indexOf("}", start);
            if(end == -1)
            {
                Debug.logWarning((new StringBuilder()).append("Found a ${ without a closing } (curly-brace) in the String: ").append(original).toString(), module);
                break;
            }
            int possibleNestedStart = original.lastIndexOf("${", end);
            if(start != possibleNestedStart)
                start = possibleNestedStart;
            handler.handleConstant(original, currentInd, start);
            handler.handleVariable(original, start + 2, end);
            currentInd = end + 1;
        }

        if(currentInd < original.length())
            handler.handleConstant(original, currentInd);
    }

    public static final String module = com/dtmc/server/analytics/util/FlexibleStringExpander.getName();
    protected String original;
    protected List stringElements;

}
