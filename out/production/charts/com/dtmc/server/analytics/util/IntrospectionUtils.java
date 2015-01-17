// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IntrospectionUtils.java

package com.dtmc.server.analytics.util;

import java.beans.*;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.HashMap;
import org.w3c.dom.Document;

// Referenced classes of package com.dtmc.server.analytics.util:
//            TestSubclass, XML

public class IntrospectionUtils
{

    public IntrospectionUtils()
    {
    }

    public static Object getValue(Object obj, String method)
    {
        if(obj == null)
            throw new IllegalArgumentException("obj cannot be null");
        if(method == null)
            throw new IllegalArgumentException("method cannot be null");
        Method m;
        Class c = obj.getClass();
        m = null;
        m = c.getMethod(method, (Class[])null);
        return m.invoke(obj, (Class[])null);
        Exception e;
        e;
        return null;
    }

    public static String getClasse(Object obj)
    {
        if(obj == null)
        {
            throw new IllegalArgumentException("obj cannot be null");
        } else
        {
            String cl = obj.getClass().toString();
            String c = cl.substring(cl.indexOf(" "));
            return c.trim();
        }
    }

    public static Object createObject(String className)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if(className == null)
        {
            throw new IllegalArgumentException("className cannot be null");
        } else
        {
            Object object = null;
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
            return object;
        }
    }

    public static Object createObject(Constructor constructor, Object arguments[])
        throws InstantiationException, IllegalAccessException, InvocationTargetException
    {
        if(constructor == null)
            throw new IllegalArgumentException("constructor cannot be null");
        if(arguments == null)
        {
            throw new IllegalArgumentException("arguments cannot be null");
        } else
        {
            Object object = null;
            object = constructor.newInstance(arguments);
            return object;
        }
    }

    public static Document toXMLString(Object obj)
        throws Exception
    {
        if(obj == null)
            throw new IllegalArgumentException("obj cannot be null");
        HashMap methodsmap = new HashMap();
        Class c = obj.getClass();
        Method methods[] = c.getMethods();
        for(int m = 0; m < methods.length; m++)
        {
            Method method = methods[m];
            viewMethod(methodsmap, method);
        }

        Field fields[] = c.getFields();
        StringBuffer xml = new StringBuffer();
        xml.append((new StringBuilder()).append("<").append(c.getName()).append(">").toString());
        for(int f = 0; f < fields.length; f++)
        {
            Field field = fields[f];
            String modifier = Modifier.toString(field.getModifiers());
            if(modifier != null && modifier.equalsIgnoreCase("transient"))
                continue;
            String type = field.getType().getName();
            xml.append((new StringBuilder()).append("<").append(field.getName()).append(">").toString());
            String getter = (new StringBuilder()).append("get").append(field.getName().substring(0, 1).toUpperCase()).append(field.getName().substring(1)).toString();
            Method gettermethod = (Method)methodsmap.get(getter);
            if(gettermethod != null)
            {
                xml.append(gettermethod.invoke(obj, null));
                xml.append((new StringBuilder()).append("</").append(field.getName()).append(">").toString());
            }
        }

        xml.append((new StringBuilder()).append("</").append(c.getName()).append(">").toString());
        return XML.stringToDocument(xml.toString());
    }

    public static void viewMethod(HashMap methodsmap, Method m)
    {
        methodsmap.put(m.getName(), m);
    }

    public static void print(Object pojo)
        throws IntrospectionException
    {
        BeanInfo beans = Introspector.getBeanInfo(pojo.getClass());
        PropertyDescriptor properties[] = beans.getPropertyDescriptors();
        for(int i = 0; i < properties.length; i++)
        {
            PropertyDescriptor property = properties[i];
            Class c = property.getPropertyType();
            String type = c.getName();
            if(isScalar(type))
            {
                System.out.println(" is scalar");
                continue;
            }
            if(isGroupable(type))
            {
                System.out.println(" is groupable");
                continue;
            }
            if(type.equalsIgnoreCase("[C") || type.equalsIgnoreCase("java.lang.Class") || type.contains("java.io.") || type.equalsIgnoreCase("[Ljava.lang.String;"))
                System.out.println(" is NOT groupable");
        }

    }

    public static boolean isScalar(String type)
    {
        return type.equalsIgnoreCase("java.math.BigDecimal") || type.equalsIgnoreCase("java.lang.Double") || type.equalsIgnoreCase("java.lang.Float") || type.equalsIgnoreCase("java.lang.Integer") || type.equalsIgnoreCase("java.lang.Long") || type.equalsIgnoreCase("java.lang.Short") || type.equalsIgnoreCase("int") || type.equalsIgnoreCase("double") || type.equalsIgnoreCase("float") || type.equalsIgnoreCase("long") || type.equalsIgnoreCase("short");
    }

    private static boolean isGroupable(String type)
    {
        return type.equalsIgnoreCase("java.lang.Boolean") || type.equalsIgnoreCase("java.lang.Byte") || type.equalsIgnoreCase("java.lang.Character") || type.equalsIgnoreCase("java.sql.Clob") || type.equalsIgnoreCase("java.util.Date") || type.equalsIgnoreCase("java.util.Locale") || type.equalsIgnoreCase("java.lang.String") || type.equalsIgnoreCase("boolean") || type.equalsIgnoreCase("char") || type.equalsIgnoreCase("byte");
    }

    public static boolean isComposite(String type)
    {
        return !isScalar(type) && !isGroupable(type);
    }

    public static void main(String args[])
        throws IntrospectionException
    {
        TestSubclass test = new TestSubclass();
        print(test);
    }
}
