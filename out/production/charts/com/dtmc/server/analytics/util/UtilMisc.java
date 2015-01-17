// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilMisc.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            MapComparator

public class UtilMisc
{
    protected static class SimpleMap
        implements Map, Serializable
    {

        protected void makeRealMap()
        {
            realMapIfNeeded = new HashMap();
            for(int i = 0; i < names.length; i++)
                realMapIfNeeded.put(names[i], values[i]);

            names = null;
            values = null;
        }

        public void clear()
        {
            if(realMapIfNeeded != null)
            {
                realMapIfNeeded.clear();
            } else
            {
                realMapIfNeeded = new HashMap();
                names = null;
                values = null;
            }
        }

        public boolean containsKey(Object obj)
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.containsKey(obj);
            for(int i = 0; i < names.length; i++)
            {
                if(obj == null && names[i] == null)
                    return true;
                if(names[i] != null && names[i].equals(obj))
                    return true;
            }

            return false;
        }

        public boolean containsValue(Object obj)
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.containsValue(obj);
            for(int i = 0; i < names.length; i++)
            {
                if(obj == null && values[i] == null)
                    return true;
                if(values[i] != null && values[i].equals(obj))
                    return true;
            }

            return false;
        }

        public Set entrySet()
        {
            if(realMapIfNeeded != null)
            {
                return realMapIfNeeded.entrySet();
            } else
            {
                makeRealMap();
                return realMapIfNeeded.entrySet();
            }
        }

        public Object get(Object obj)
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.get(obj);
            for(int i = 0; i < names.length; i++)
            {
                if(obj == null && names[i] == null)
                    return values[i];
                if(names[i] != null && names[i].equals(obj))
                    return values[i];
            }

            return null;
        }

        public boolean isEmpty()
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.isEmpty();
            return names.length == 0;
        }

        public Set keySet()
        {
            if(realMapIfNeeded != null)
            {
                return realMapIfNeeded.keySet();
            } else
            {
                makeRealMap();
                return realMapIfNeeded.keySet();
            }
        }

        public Object put(Object obj, Object obj1)
        {
            if(realMapIfNeeded != null)
            {
                return realMapIfNeeded.put(obj, obj1);
            } else
            {
                makeRealMap();
                return realMapIfNeeded.put(obj, obj1);
            }
        }

        public void putAll(Map map)
        {
            if(realMapIfNeeded != null)
            {
                realMapIfNeeded.putAll(map);
            } else
            {
                makeRealMap();
                realMapIfNeeded.putAll(map);
            }
        }

        public Object remove(Object obj)
        {
            if(realMapIfNeeded != null)
            {
                return realMapIfNeeded.remove(obj);
            } else
            {
                makeRealMap();
                return realMapIfNeeded.remove(obj);
            }
        }

        public int size()
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.size();
            else
                return names.length;
        }

        public Collection values()
        {
            if(realMapIfNeeded != null)
            {
                return realMapIfNeeded.values();
            } else
            {
                makeRealMap();
                return realMapIfNeeded.values();
            }
        }

        public String toString()
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.toString();
            StringBuffer outString = new StringBuffer("{");
            for(int i = 0; i < names.length; i++)
            {
                if(i > 0)
                    outString.append(',');
                outString.append('{');
                outString.append(names[i]);
                outString.append(',');
                outString.append(values[i]);
                outString.append('}');
            }

            outString.append('}');
            return outString.toString();
        }

        public int hashCode()
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.hashCode();
            int hashCode = 0;
            for(int i = 0; i < names.length; i++)
            {
                int tempNum = (names[i] != null ? names[i].hashCode() : 0) ^ (values[i] != null ? values[i].hashCode() : 0);
                hashCode += tempNum;
            }

            return hashCode;
        }

        public boolean equals(Object obj)
        {
            if(realMapIfNeeded != null)
                return realMapIfNeeded.equals(obj);
            Map mapObj = (Map)obj;
            if(mapObj.size() != names.length)
                return false;
            for(int i = 0; i < names.length; i++)
            {
                if(!mapObj.containsKey(names[i]))
                    return false;
                Object mapValue = mapObj.get(names[i]);
                if(mapValue == null)
                {
                    if(values[i] != null)
                        return false;
                    continue;
                }
                if(!mapValue.equals(values[i]))
                    return false;
            }

            return true;
        }

        protected Map realMapIfNeeded;
        String names[];
        Object values[];

        public SimpleMap()
        {
            realMapIfNeeded = null;
            names = new String[0];
            values = new Object[0];
        }

        public SimpleMap(String name1, Object value1)
        {
            realMapIfNeeded = null;
            names = new String[1];
            values = new Object[1];
            names[0] = name1;
            values[0] = value1;
        }

        public SimpleMap(String name1, Object value1, String name2, Object value2)
        {
            realMapIfNeeded = null;
            names = new String[2];
            values = new Object[2];
            names[0] = name1;
            values[0] = value1;
            names[1] = name2;
            values[1] = value2;
        }

        public SimpleMap(String name1, Object value1, String name2, Object value2, String name3, Object value3)
        {
            realMapIfNeeded = null;
            names = new String[3];
            values = new Object[3];
            names[0] = name1;
            values[0] = value1;
            names[1] = name2;
            values[1] = value2;
            names[2] = name3;
            values[2] = value3;
        }

        public SimpleMap(String name1, Object value1, String name2, Object value2, String name3, Object value3, String name4, 
                Object value4)
        {
            realMapIfNeeded = null;
            names = new String[4];
            values = new Object[4];
            names[0] = name1;
            values[0] = value1;
            names[1] = name2;
            values[1] = value2;
            names[2] = name3;
            values[2] = value3;
            names[3] = name4;
            values[3] = value4;
        }
    }


    public UtilMisc()
    {
    }

    public static Iterator toIterator(Collection col)
    {
        if(col == null)
            return null;
        else
            return col.iterator();
    }

    public static Map toMap(String name1, Object value1)
    {
        return new SimpleMap(name1, value1);
    }

    public static Map toMap(String name1, Object value1, String name2, Object value2)
    {
        return new SimpleMap(name1, value1, name2, value2);
    }

    public static Map toMap(String name1, Object value1, String name2, Object value2, String name3, Object value3)
    {
        return new SimpleMap(name1, value1, name2, value2, name3, value3);
    }

    public static Map toMap(String name1, Object value1, String name2, Object value2, String name3, Object value3, String name4, Object value4)
    {
        return new SimpleMap(name1, value1, name2, value2, name3, value3, name4, value4);
    }

    public static Map toMap(String name1, Object value1, String name2, Object value2, String name3, Object value3, String name4, Object value4, 
            String name5, Object value5)
    {
        Map fields = new HashMap();
        fields.put(name1, value1);
        fields.put(name2, value2);
        fields.put(name3, value3);
        fields.put(name4, value4);
        fields.put(name5, value5);
        return fields;
    }

    public static Map toMap(String name1, Object value1, String name2, Object value2, String name3, Object value3, String name4, Object value4, 
            String name5, Object value5, String name6, Object value6)
    {
        Map fields = new HashMap();
        fields.put(name1, value1);
        fields.put(name2, value2);
        fields.put(name3, value3);
        fields.put(name4, value4);
        fields.put(name5, value5);
        fields.put(name6, value6);
        return fields;
    }

    public static Map toMap(Object data[])
    {
        if(data == null)
            return null;
        if(data.length % 2 == 1)
            throw new IllegalArgumentException("You must pass an even sized array to the toMap method");
        Map map = new HashMap();
        for(int i = 0; i < data.length;)
            map.put(data[i++], data[i++]);

        return map;
    }

    public static List sortMaps(List listOfMaps, List sortKeys)
    {
        if(listOfMaps == null || sortKeys == null)
            return null;
        List toSort = new LinkedList(listOfMaps);
        try
        {
            MapComparator mc = new MapComparator(sortKeys);
            Collections.sort(toSort, mc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return toSort;
    }

    public static List toList(Object obj1)
    {
        List list = new ArrayList(1);
        list.add(obj1);
        return list;
    }

    public static List toList(Object obj1, Object obj2)
    {
        List list = new ArrayList(2);
        list.add(obj1);
        list.add(obj2);
        return list;
    }

    public static List toList(Object obj1, Object obj2, Object obj3)
    {
        List list = new ArrayList(3);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        return list;
    }

    public static List toList(Object obj1, Object obj2, Object obj3, Object obj4)
    {
        List list = new ArrayList(4);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        return list;
    }

    public static List toList(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        List list = new ArrayList(5);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);
        return list;
    }

    public static List toList(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6)
    {
        List list = new ArrayList(6);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        list.add(obj5);
        list.add(obj6);
        return list;
    }

    public static List toList(Collection collection)
    {
        if(collection == null)
            return null;
        if(collection instanceof List)
            return (List)collection;
        else
            return new ArrayList(collection);
    }

    public static List toListArray(Object data[])
    {
        if(data == null)
            return null;
        List list = new ArrayList(data.length);
        for(int i = 0; i < data.length; i++)
            list.add(data[i]);

        return list;
    }

    public static Locale parseLocale(String localeString)
    {
        if(localeString == null || localeString.length() == 0)
            return null;
        Locale locale = null;
        if(localeString.length() == 2)
            locale = new Locale(localeString);
        else
        if(localeString.length() == 5)
        {
            String language = localeString.substring(0, 2);
            String country = localeString.substring(3, 5);
            locale = new Locale(language, country);
        } else
        if(localeString.length() > 6)
        {
            String language = localeString.substring(0, 2);
            String country = localeString.substring(3, 5);
            String extension = localeString.substring(6);
            locale = new Locale(language, country, extension);
        } else
        {
            System.out.println((new StringBuilder()).append("Do not know what to do with the localeString [").append(localeString).append("], should be length 2, 5, or greater than 6, returning null").toString());
        }
        return locale;
    }

    public static Locale ensureLocale(Object localeObject)
    {
        if(localeObject != null && (localeObject instanceof String))
            localeObject = parseLocale((String)localeObject);
        if(localeObject != null && (localeObject instanceof Locale))
            return (Locale)localeObject;
        else
            return Locale.getDefault();
    }

    public static List availableLocales()
    {
        if(availableLocaleList == null)
            synchronized(com/dtmc/server/analytics/util/UtilMisc)
            {
                if(availableLocaleList == null)
                {
                    TreeMap localeMap = new TreeMap();
                    Locale locales[] = Locale.getAvailableLocales();
                    for(int i = 0; i < locales.length; i++)
                        localeMap.put(locales[i].getDisplayName(), locales[i]);

                    availableLocaleList = new LinkedList(localeMap.values());
                }
            }
        return availableLocaleList;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilMisc.getName();
    public static List availableLocaleList = null;

}
