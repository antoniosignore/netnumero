// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilProperties.java

package com.dtmc.server.analytics.util;

import java.net.URL;
import java.text.MessageFormat;
import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            FlexibleProperties, UtilCache, UtilURL, Debug, 
//            FlexibleStringExpander

public class UtilProperties
{

    public UtilProperties()
    {
    }

    public static boolean propertyValueEquals(String resource, String name, String compareString)
    {
        String value = getPropertyValue(resource, name);
        if(value == null)
            return false;
        else
            return value.trim().equals(compareString);
    }

    public static boolean propertyValueEqualsIgnoreCase(String resource, String name, String compareString)
    {
        String value = getPropertyValue(resource, name);
        if(value == null)
            return false;
        else
            return value.trim().equalsIgnoreCase(compareString);
    }

    public static String getPropertyValue(String resource, String name, String defaultValue)
    {
        String value = getPropertyValue(resource, name);
        if(value == null || value.length() == 0)
            return defaultValue;
        else
            return value;
    }

    public static double getPropertyNumber(String resource, String name)
    {
        String str = getPropertyValue(resource, name);
        double strValue = 0.0D;
        try
        {
            strValue = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) { }
        return strValue;
    }

    public static String getPropertyValue(String resource, String name)
    {
        FlexibleProperties properties;
        if(resource == null || resource.length() <= 0)
            return "";
        if(name == null || name.length() <= 0)
            return "";
        properties = (FlexibleProperties)resourceCache.get(resource);
        if(properties != null)
            break MISSING_BLOCK_LABEL_82;
        URL url = UtilURL.fromResource(resource);
        if(url == null)
            return "";
        try
        {
            properties = FlexibleProperties.makeFlexibleProperties(url);
            resourceCache.put(resource, properties);
        }
        catch(MissingResourceException e)
        {
            Debug.log(e.getMessage(), module);
        }
        if(properties == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getPropertyValue] could not find resource: ").append(resource).toString(), module);
            return "";
        }
        String value = null;
        try
        {
            value = properties.getProperty(name);
        }
        catch(Exception e)
        {
            Debug.log(e.getMessage(), module);
        }
        return value != null ? value.trim() : "";
    }

    public static Properties getProperties(String resource)
    {
        Properties properties;
        if(resource == null || resource.length() <= 0)
            return null;
        properties = (FlexibleProperties)resourceCache.get(resource);
        if(properties != null)
            break MISSING_BLOCK_LABEL_66;
        URL url = UtilURL.fromResource(resource);
        if(url == null)
            return null;
        try
        {
            properties = FlexibleProperties.makeFlexibleProperties(url);
            resourceCache.put(resource, properties);
        }
        catch(MissingResourceException e)
        {
            Debug.log(e.getMessage(), module);
        }
        if(properties == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getProperties] could not find resource: ").append(resource).toString(), module);
            return null;
        } else
        {
            return properties;
        }
    }

    public static Properties getProperties(URL url)
    {
        if(url == null)
            return null;
        Properties properties = (FlexibleProperties)resourceCache.get(url);
        if(properties == null)
            try
            {
                properties = FlexibleProperties.makeFlexibleProperties(url);
                resourceCache.put(url, properties);
            }
            catch(MissingResourceException e)
            {
                Debug.log(e.getMessage(), module);
            }
        if(properties == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getProperties] could not find resource: ").append(url).toString(), module);
            return null;
        } else
        {
            return properties;
        }
    }

    public static boolean propertyValueEquals(URL url, String name, String compareString)
    {
        String value = getPropertyValue(url, name);
        if(value == null)
            return false;
        else
            return value.trim().equals(compareString);
    }

    public static boolean propertyValueEqualsIgnoreCase(URL url, String name, String compareString)
    {
        String value = getPropertyValue(url, name);
        if(value == null)
            return false;
        else
            return value.trim().equalsIgnoreCase(compareString);
    }

    public static String getPropertyValue(URL url, String name, String defaultValue)
    {
        String value = getPropertyValue(url, name);
        if(value == null || value.length() <= 0)
            return defaultValue;
        else
            return value;
    }

    public static double getPropertyNumber(URL url, String name)
    {
        String str = getPropertyValue(url, name);
        double strValue = 0.0D;
        try
        {
            strValue = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) { }
        return strValue;
    }

    public static String getPropertyValue(URL url, String name)
    {
        if(url == null)
            return "";
        if(name == null || name.length() <= 0)
            return "";
        FlexibleProperties properties = (FlexibleProperties)urlCache.get(url);
        if(properties == null)
            try
            {
                properties = FlexibleProperties.makeFlexibleProperties(url);
                urlCache.put(url, properties);
            }
            catch(MissingResourceException e)
            {
                Debug.log(e.getMessage(), module);
            }
        if(properties == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getPropertyValue] could not find resource: ").append(url).toString(), module);
            return null;
        }
        String value = null;
        try
        {
            value = properties.getProperty(name);
        }
        catch(Exception e)
        {
            Debug.log(e.getMessage(), module);
        }
        return value != null ? value.trim() : "";
    }

    public static String getSplitPropertyValue(URL url, String name)
    {
        if(url == null)
            return "";
        if(name == null || name.length() <= 0)
            return "";
        FlexibleProperties properties = (FlexibleProperties)urlCache.get(url);
        if(properties == null)
            try
            {
                properties = FlexibleProperties.makeFlexibleProperties(url);
                urlCache.put(url, properties);
            }
            catch(MissingResourceException e)
            {
                Debug.log(e.getMessage(), module);
            }
        if(properties == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getPropertyValue] could not find resource: ").append(url).toString(), module);
            return null;
        }
        String value = null;
        try
        {
            int curIdx = 1;
            String curName = null;
            do
            {
                if((curName = properties.getProperty((new StringBuilder()).append("name.").append(curIdx).toString())) == null)
                    break;
                if(name.equals(curName))
                {
                    value = properties.getProperty((new StringBuilder()).append("value.").append(curIdx).toString());
                    break;
                }
                curIdx++;
            } while(true);
        }
        catch(Exception e)
        {
            Debug.log(e.getMessage(), module);
        }
        return value != null ? value.trim() : "";
    }

    public static String getMessage(String resource, String name, Locale locale)
    {
        if(resource == null || resource.length() <= 0)
            return "";
        if(name == null || name.length() <= 0)
            return "";
        ResourceBundle bundle = getResourceBundle(resource, locale);
        if(bundle == null)
            return "";
        String value = null;
        try
        {
            value = bundle.getString(name);
        }
        catch(Exception e)
        {
            Debug.log(e.getMessage(), module);
        }
        return value != null ? value.trim() : "";
    }

    public static String getMessage(String resource, String name, Object arguments[], Locale locale)
    {
        String value = getMessage(resource, name, locale);
        if(value == null || value.length() == 0)
            return "";
        if(arguments != null && arguments.length > 0)
            value = MessageFormat.format(value, arguments);
        return value;
    }

    public static String getMessage(String resource, String name, List arguments, Locale locale)
    {
        String value = getMessage(resource, name, locale);
        if(value == null || value.length() == 0)
            return "";
        if(arguments != null && arguments.size() > 0)
            value = MessageFormat.format(value, arguments.toArray());
        return value;
    }

    public static String getMessage(String resource, String name, Map context, Locale locale)
    {
        String value = getMessage(resource, name, locale);
        if(value == null || value.length() == 0)
            return "";
        if(context != null && context.size() > 0)
            value = FlexibleStringExpander.expandString(value, context);
        return value;
    }

    public static ResourceBundle getResourceBundle(String resource, Locale locale)
    {
        Map bundleMap = getResourceBundleMap(resource, locale);
        if(bundleMap == null)
            return null;
        else
            return (ResourceBundle)bundleMap.get("_RESOURCE_BUNDLE_");
    }

    public static Map getResourceBundleMap(String resource, Locale locale)
    {
        if(locale == null)
            throw new IllegalArgumentException("Locale cannot be null");
        String resourceCacheKey = (new StringBuilder()).append(resource).append("_").append(locale.toString()).toString();
        Map bundleMap = (Map)bundleLocaleCache.get(resourceCacheKey);
        if(bundleMap == null)
        {
            ResourceBundle bundle = getBaseResourceBundle(resource, locale);
            bundleMap = resourceBundleToMap(bundle);
            if(bundleMap != null)
                bundleLocaleCache.put(resourceCacheKey, bundleMap);
        }
        return bundleMap;
    }

    protected static ResourceBundle getBaseResourceBundle(String resource, Locale locale)
    {
        if(resource == null || resource.length() <= 0)
            return null;
        if(locale == null)
            locale = Locale.getDefault();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ResourceBundle bundle = null;
        try
        {
            bundle = ResourceBundle.getBundle(resource, locale, loader);
        }
        catch(MissingResourceException e)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getPropertyValue] could not find resource: ").append(resource).append(" for locale ").append(locale.toString()).append(": ").append(e.toString()).toString(), module);
            return null;
        }
        if(bundle == null)
        {
            Debug.log((new StringBuilder()).append("[UtilProperties.getPropertyValue] could not find resource: ").append(resource).append(" for locale ").append(locale.toString()).toString(), module);
            return null;
        } else
        {
            return bundle;
        }
    }

    protected static Map resourceBundleToMap(ResourceBundle bundle)
    {
        if(bundle == null)
            return new HashMap();
        Enumeration keyNum = bundle.getKeys();
        Map resourceBundleMap = new HashMap();
        String key;
        Object value;
        for(; keyNum.hasMoreElements(); resourceBundleMap.put(key, value))
        {
            key = (String)keyNum.nextElement();
            value = bundle.getObject(key);
        }

        resourceBundleMap.put("_RESOURCE_BUNDLE_", bundle);
        return resourceBundleMap;
    }

    public static Properties getProperties(String resource, Locale locale)
    {
        if(resource == null || resource.length() <= 0)
            return null;
        if(locale == null)
            locale = Locale.getDefault();
        String localeString = locale.toString();
        String resourceLocale = (new StringBuilder()).append(resource).append("_").append(localeString).toString();
        Properties properties = (FlexibleProperties)resourceCache.get(resourceLocale);
        if(properties == null)
        {
            try
            {
                URL url = UtilURL.fromResource(resourceLocale);
                if(url == null)
                    properties = getProperties(resource);
                else
                    properties = FlexibleProperties.makeFlexibleProperties(url);
            }
            catch(MissingResourceException e)
            {
                Debug.log(e.getMessage(), module);
            }
            resourceCache.put(resourceLocale, properties);
        }
        if(properties == null)
            Debug.logInfo((new StringBuilder()).append("[UtilProperties.getProperties] could not find resource: ").append(resource).append(", locale: ").append(locale).toString(), module);
        return properties;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilProperties.getName();
    public static UtilCache resourceCache = new UtilCache("properties.UtilPropertiesResourceCache");
    public static UtilCache urlCache = new UtilCache("properties.UtilPropertiesUrlCache");
    public static UtilCache bundleLocaleCache = new UtilCache("properties.UtilPropertiesBundleLocaleCache");

}
