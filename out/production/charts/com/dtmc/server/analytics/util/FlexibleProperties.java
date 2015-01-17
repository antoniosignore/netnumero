// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FlexibleProperties.java

package com.dtmc.server.analytics.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            Debug

public class FlexibleProperties extends Properties
{

    public FlexibleProperties()
    {
        url = null;
        doPropertyExpansion = true;
        truncateIfMissing = false;
    }

    public FlexibleProperties(Properties properties)
    {
        super(properties);
        url = null;
        doPropertyExpansion = true;
        truncateIfMissing = false;
    }

    public FlexibleProperties(URL url)
    {
        this.url = null;
        doPropertyExpansion = true;
        truncateIfMissing = false;
        this.url = url;
        init();
    }

    public FlexibleProperties(URL url, Properties properties)
    {
        super(properties);
        this.url = null;
        doPropertyExpansion = true;
        truncateIfMissing = false;
        this.url = url;
        init();
    }

    public static FlexibleProperties makeFlexibleProperties(Properties properties)
    {
        return new FlexibleProperties(properties);
    }

    public static FlexibleProperties makeFlexibleProperties(URL url)
    {
        return new FlexibleProperties(url);
    }

    public static FlexibleProperties makeFlexibleProperties(URL url, Properties properties)
    {
        return new FlexibleProperties(url, properties);
    }

    public static FlexibleProperties makeFlexibleProperties(String keysAndValues[])
    {
        if(keysAndValues.length % 2 != 0)
            throw new IllegalArgumentException("FlexibleProperties(String[] keysAndValues) cannot accept an odd number of elements!");
        Properties newProperties = new Properties();
        for(int i = 0; i < keysAndValues.length; i += 2)
            newProperties.setProperty(keysAndValues[i], keysAndValues[i + 1]);

        return new FlexibleProperties(newProperties);
    }

    private void init()
    {
        try
        {
            load();
        }
        catch(IOException e)
        {
            Debug.log(e, module);
        }
    }

    public boolean getDoPropertyExpansion()
    {
        return doPropertyExpansion;
    }

    public void setDoPropertyExpansion(boolean doPropertyExpansion)
    {
        this.doPropertyExpansion = doPropertyExpansion;
    }

    public boolean getTruncateIfMissing()
    {
        return truncateIfMissing;
    }

    public void setTruncateIfMissing(boolean truncateIfMissing)
    {
        this.truncateIfMissing = truncateIfMissing;
    }

    public URL getURL()
    {
        return url;
    }

    public void setURL(URL url)
    {
        this.url = url;
        init();
    }

    public Properties getDefaultProperties()
    {
        return defaults;
    }

    public void setDefaultProperties(Properties defaults)
    {
        this.defaults = new FlexibleProperties(defaults);
    }

    protected synchronized void load()
        throws IOException
    {
        if(url == null)
            return;
        InputStream in = null;
        try
        {
            in = url.openStream();
        }
        catch(Exception urlex)
        {
            Debug.log(urlex, (new StringBuilder()).append("[FlexibleProperties.load]: Couldn't find the URL: ").append(url).toString(), module);
        }
        if(in == null)
            throw new IOException((new StringBuilder()).append("Could not open resource URL ").append(url).toString());
        super.load(in);
        in.close();
        if(defaults instanceof FlexibleProperties)
            ((FlexibleProperties)defaults).reload();
        if(getDoPropertyExpansion())
            interpolateProperties();
    }

    public synchronized void store(String header)
        throws IOException
    {
        super.store(url.openConnection().getOutputStream(), header);
    }

    public synchronized void reload()
        throws IOException
    {
        Debug.log((new StringBuilder()).append("Reloading the resource: ").append(url).toString(), module);
        load();
    }

    public void interpolateProperties()
    {
        if(defaults != null && (defaults instanceof FlexibleProperties))
            ((FlexibleProperties)defaults).interpolateProperties();
        interpolateProperties(((Properties) (this)), getTruncateIfMissing());
    }

    public static void interpolateProperties(Properties props)
    {
        interpolateProperties(props, false);
    }

    public static void interpolateProperties(Properties props, boolean truncateIfMissing)
    {
        String key;
        String value;
        for(Enumeration keys = props.keys(); keys.hasMoreElements(); props.setProperty(key, interpolate(value, props, truncateIfMissing)))
        {
            key = keys.nextElement().toString();
            value = props.getProperty(key);
            key = interpolate(key, props, truncateIfMissing);
        }

    }

    public static String interpolate(String value, Properties props)
    {
        return interpolate(value, props, false);
    }

    public static String interpolate(String value, Properties props, boolean truncateIfMissing)
    {
        return interpolate(value, props, truncateIfMissing, null);
    }

    public static String interpolate(String value, Properties props, boolean truncateIfMissing, ArrayList beenThere)
    {
        if(props == null || value == null)
            return value;
        if(beenThere == null)
            beenThere = new ArrayList();
        int end;
        for(int start = value.indexOf("${"); start > -1; start = value.indexOf("${", end))
        {
            end = value.indexOf("}", start + 2);
            if(end > start + 2)
            {
                String keyToExpand = value.substring(start + 2, end);
                for(int nestedStart = keyToExpand.indexOf("${"); nestedStart > -1;)
                {
                    end = value.indexOf("}", end + 1);
                    if(end > -1)
                    {
                        keyToExpand = value.substring(start + 2, end);
                        nestedStart = keyToExpand.indexOf("${", nestedStart + 2);
                    } else
                    {
                        Debug.log((new StringBuilder()).append("[FlexibleProperties.interpolate] Malformed value: [").append(value).append("] ").append("contained unbalanced start \"${\" and end \"}\" characters").toString(), module);
                        return value;
                    }
                }

                if(keyToExpand.indexOf("${") > -1)
                {
                    ArrayList tempBeenThere = new ArrayList(beenThere);
                    beenThere.add(keyToExpand);
                    keyToExpand = interpolate(keyToExpand, props, truncateIfMissing, beenThere);
                    beenThere = tempBeenThere;
                }
                if(beenThere.contains(keyToExpand))
                {
                    beenThere.add(keyToExpand);
                    Debug.log((new StringBuilder()).append("[FlexibleProperties.interpolate] Recursion loop detected:  Property:[").append(beenThere.get(0)).append("] ").append("included property: [").append(keyToExpand).append("]").toString(), module);
                    Debug.log((new StringBuilder()).append("[FlexibleProperties.interpolate] Recursion loop path:").append(beenThere).toString(), module);
                    return value;
                }
                String expandValue = null;
                if(keyToExpand.startsWith("env."))
                {
                    String envValue = System.getProperty(keyToExpand.substring(4));
                    if(envValue == null)
                        Debug.log((new StringBuilder()).append("[FlexibleProperties.interpolate] ERROR: Could not find environment variable named: ").append(keyToExpand.substring(4)).toString(), module);
                    else
                        expandValue = envValue;
                } else
                {
                    expandValue = props.getProperty(keyToExpand);
                }
                if(expandValue != null)
                {
                    if(expandValue.indexOf("${") > -1)
                    {
                        ArrayList tempBeenThere = new ArrayList(beenThere);
                        beenThere.add(keyToExpand);
                        expandValue = interpolate(expandValue, props, truncateIfMissing, beenThere);
                        beenThere = tempBeenThere;
                    }
                    value = (new StringBuilder()).append(value.substring(0, start)).append(expandValue).append(value.substring(end + 1)).toString();
                    end = start + expandValue.length();
                    continue;
                }
                if(truncateIfMissing)
                    value = (new StringBuilder()).append(value.substring(0, start)).append(value.substring(end + 1)).toString();
            } else
            {
                Debug.log((new StringBuilder()).append("[FlexibleProperties.interpolate] Value [").append(value).append("] starts but does end variable").toString(), module);
                return value;
            }
        }

        return value;
    }

    public Object clone()
    {
        FlexibleProperties c = (FlexibleProperties)super.clone();
        if(defaults != null && !equals(defaults))
            c.defaults = (FlexibleProperties)getDefaultProperties().clone();
        return c;
    }

    public String toString()
    {
        StringBuffer retVal = new StringBuffer();
        Set keySet = keySet();
        for(Iterator keys = keySet.iterator(); keys.hasNext(); retVal.append("\n"))
        {
            String key = keys.next().toString();
            String value = getProperty(key);
            retVal.append(key);
            retVal.append("=");
            retVal.append(value);
        }

        return retVal.toString();
    }

    public static final String module = com/dtmc/server/analytics/util/FlexibleProperties.getName();
    private static final boolean truncateIfMissingDefault = false;
    private static final boolean doPropertyExpansionDefault = true;
    private URL url;
    private boolean doPropertyExpansion;
    private boolean truncateIfMissing;

}
