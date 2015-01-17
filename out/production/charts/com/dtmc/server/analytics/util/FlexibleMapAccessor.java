// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FlexibleMapAccessor.java

package com.dtmc.server.analytics.util;

import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            LocalizedMap, UtilMisc

public class FlexibleMapAccessor
{
    public class SubMapAccessor
    {

        public Map getSubMap(Map base)
        {
            if(base == null)
                return null;
            if(subMapAccessor != null)
                base = subMapAccessor.getSubMap(base);
            if(isListReference)
            {
                List lst = (List)base.get(extName);
                if(lst == null)
                {
                    lst = new LinkedList();
                    base.put(extName, lst);
                }
                Map extMap = null;
                if(lst.size() > listIndex)
                    extMap = (Map)lst.get(listIndex);
                if(extMap == null)
                {
                    extMap = new HashMap();
                    lst.add(listIndex, extMap);
                }
                return extMap;
            }
            Map extMap = (Map)base.get(extName);
            if(extMap == null)
            {
                extMap = new HashMap();
                base.put(extName, extMap);
            }
            return extMap;
        }

        protected String extName;
        protected boolean isListReference;
        protected int listIndex;
        protected SubMapAccessor subMapAccessor;
        final FlexibleMapAccessor this$0;

        public SubMapAccessor(String name)
        {
            this$0 = FlexibleMapAccessor.this;
            super();
            isListReference = false;
            listIndex = -1;
            subMapAccessor = null;
            int dotIndex = name.lastIndexOf('.');
            if(dotIndex != -1)
            {
                extName = name.substring(dotIndex + 1);
                String subName = name.substring(0, dotIndex);
                subMapAccessor = new SubMapAccessor(subName);
            } else
            {
                extName = name;
            }
            int openBrace = extName.indexOf('[');
            int closeBrace = openBrace != -1 ? extName.indexOf(']', openBrace) : -1;
            if(openBrace != -1 && closeBrace != -1)
            {
                String liStr = extName.substring(openBrace + 1, closeBrace);
                listIndex = Integer.parseInt(liStr);
                extName = extName.substring(0, openBrace);
                isListReference = true;
            }
        }
    }


    public FlexibleMapAccessor(String name)
    {
        isListReference = false;
        isAddAtIndex = false;
        isAddAtEnd = false;
        listIndex = -1;
        subMapAccessor = null;
        original = name;
        int dotIndex = name.lastIndexOf('.');
        if(dotIndex != -1)
        {
            extName = name.substring(dotIndex + 1);
            String subName = name.substring(0, dotIndex);
            subMapAccessor = new SubMapAccessor(subName);
        } else
        {
            extName = name;
        }
        int openBrace = extName.indexOf('[');
        int closeBrace = openBrace != -1 ? extName.indexOf(']', openBrace) : -1;
        if(openBrace != -1 && closeBrace != -1)
        {
            String liStr = extName.substring(openBrace + 1, closeBrace);
            if(liStr.length() == 0)
                isAddAtEnd = true;
            else
            if(liStr.charAt(0) == '+')
            {
                liStr = liStr.substring(1);
                listIndex = Integer.parseInt(liStr);
                isAddAtIndex = true;
            } else
            {
                listIndex = Integer.parseInt(liStr);
            }
            extName = extName.substring(0, openBrace);
            isListReference = true;
        }
    }

    public String getOriginalName()
    {
        return original;
    }

    public boolean isEmpty()
    {
        return original == null || original.length() == 0;
    }

    public Object get(Map base)
    {
        return get(base, null);
    }

    public Object get(Map base, Locale locale)
    {
        if(base == null)
            return null;
        Map newBase = new HashMap(base);
        if(subMapAccessor != null)
            newBase = subMapAccessor.getSubMap(base);
        Object ret = null;
        if(isListReference)
        {
            List lst = (List)newBase.get(extName);
            ret = lst.get(listIndex);
        } else
        {
            ret = getByLocale(extName, base, newBase, locale);
        }
        if(ret == null)
            ret = getByLocale(original, base, base, locale);
        return ret;
    }

    protected Object getByLocale(String name, Map base, Map sub, Locale locale)
    {
        if(sub instanceof LocalizedMap)
        {
            LocalizedMap locMap = (LocalizedMap)sub;
            if(locale != null)
                return locMap.get(name, locale);
            if(base.containsKey("locale"))
                return locMap.get(name, UtilMisc.ensureLocale(base.get("locale")));
            else
                return locMap.get(name, Locale.getDefault());
        } else
        {
            return sub.get(name);
        }
    }

    public void put(Map base, Object value)
    {
        if(base == null)
            throw new IllegalArgumentException("Cannot put a value in a null base Map");
        if(subMapAccessor != null)
        {
            Map subBase = subMapAccessor.getSubMap(base);
            if(subBase == null)
                return;
            base = subBase;
        }
        if(isListReference)
        {
            List lst = (List)base.get(extName);
            if(isAddAtEnd)
                lst.add(value);
            else
            if(isAddAtIndex)
                lst.add(listIndex, value);
            else
                lst.set(listIndex, value);
        } else
        {
            base.put(extName, value);
        }
    }

    public Object remove(Map base)
    {
        if(subMapAccessor != null)
            base = subMapAccessor.getSubMap(base);
        if(isListReference)
        {
            List lst = (List)base.get(extName);
            return lst.remove(listIndex);
        } else
        {
            return base.remove(extName);
        }
    }

    public String toString()
    {
        return original;
    }

    protected String original;
    protected String extName;
    protected boolean isListReference;
    protected boolean isAddAtIndex;
    protected boolean isAddAtEnd;
    protected int listIndex;
    protected SubMapAccessor subMapAccessor;
}
