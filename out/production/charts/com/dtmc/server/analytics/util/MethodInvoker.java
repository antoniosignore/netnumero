// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MethodInvoker.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            Type

public class MethodInvoker
{

    public MethodInvoker()
    {
    }

    public static Object invokeMethod(Object instance, Method method, String values[])
        throws Exception
    {
        Class pt[] = method.getParameterTypes();
        if(values.length != pt.length)
            throw new IllegalArgumentException("the values array must have the length equal to the method args number");
        Object args[] = new Object[pt.length];
        for(int i = 0; i < pt.length; i++)
        {
            if(pt[i].isArray())
            {
                try
                {
                    Object a = initArray(pt[i].getComponentType(), values[i]);
                    args[i] = a;
                    continue;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            args[i] = validate(pt[i], values[i]);
        }

        return method.invoke(instance, args);
    }

    public static Object validate(Class cls, String value)
        throws NumberFormatException, NullPointerException
    {
        if(value == null)
            throw new NullPointerException("");
        if(cls.equals(Double.TYPE))
            return new Double(value);
        if(cls.equals(Integer.TYPE))
            return new Integer(value);
        if(cls.equals(Boolean.TYPE))
        {
            if(value.equals("true"))
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        } else
        {
            return null;
        }
    }

    public static Object initArray(Class cls, String s)
        throws Exception
    {
        if(s.charAt(-1 + s.length()) != '}' || s.charAt(0) != '{')
        {
            System.out.println(s);
            throw new Exception();
        }
        String xlessString = s.substring(1, s.length() - 1);
        if(-1 == xlessString.indexOf('{') && -1 == xlessString.indexOf('}'))
            if(0 != xlessString.length())
                return initSimpleArray(cls, s);
            else
                return Array.newInstance(cls, 0);
        if(xlessString.charAt(0) != '{' || xlessString.charAt(xlessString.length() - 1) != '}')
        {
            System.out.println(xlessString);
            throw new Exception();
        }
        Vector v = new Vector();
        int len = xlessString.length();
        int ocd = 0;
        for(int i = 0; i < len;)
        {
            char ch = xlessString.charAt(i);
            if(ch == '{')
            {
                ocd++;
                if(i < len - 1)
                {
                    int nch = xlessString.charAt(i + 1);
                    if(nch == 44)
                        throw new Exception();
                }
                i++;
            } else
            if(ch == '}')
            {
                ocd--;
                if(i < len - 1)
                {
                    char nch = xlessString.charAt(i + 1);
                    if(nch != '}' && nch != ',')
                        throw new Exception();
                    if(nch == ',' && '{' != xlessString.charAt(i + 2) && ' ' != xlessString.charAt(i + 2))
                        throw new Exception();
                }
                i++;
            } else
            {
                i++;
            }
        }

        if(ocd != 0)
            throw new Exception();
        do
        {
            int fp = xlessString.indexOf('{');
            int lp = fp;
            ocd = 0;
            do
            {
                char ch = xlessString.charAt(lp);
                if(ch == '{')
                    ocd++;
                else
                if(ch == '}')
                    ocd--;
                lp++;
            } while(ocd != 0);
            v.add(xlessString.substring(fp, lp));
            if(lp + 1 >= xlessString.length())
                break;
            xlessString = xlessString.substring(lp + 1, xlessString.length());
        } while(true);
        len = v.size();
        Object a = Array.newInstance(cls, len);
        for(int i = 0; i < len; i++)
            Array.set(a, i, initArray(cls.getComponentType(), (String)v.get(i)));

        return a;
    }

    public static Object initSimpleArray(Class cls, String s)
        throws Exception
    {
        if(s.charAt(-1 + s.length()) != '}' && s.charAt(0) != '{')
            throw new Exception();
        String xlessString = s.substring(1, s.length() - 1);
        int len = xlessString.length();
        if(xlessString.charAt(-1 + xlessString.length()) == ',' || xlessString.charAt(0) == ',')
            throw new Exception();
        Vector v = new Vector();
        for(StringTokenizer st = new StringTokenizer(xlessString, ","); st.hasMoreTokens(); v.add(validate(cls, st.nextToken())));
        Object a = Array.newInstance(cls, v.size());
        for(int i = 0; i < v.size(); i++)
            Array.set(a, i, v.get(i));

        return a;
    }

    public static String arrayToString(Object a, String delim)
    {
        if(!a.getClass().isArray())
            return trunc(a);
        StringBuffer sb = new StringBuffer();
        sb.append('{');
        int len = Array.getLength(a);
        for(int i = 0; i < len; i++)
        {
            sb.append(arrayToString(Array.get(a, i), delim));
            if(i < len - 1)
                sb.append(delim);
        }

        sb.append('}');
        return sb.toString();
    }

    public static String arrayToString(Object a, String delim, String language)
    {
        if(!a.getClass().isArray())
            return trunc(a);
        StringBuffer sb = new StringBuffer();
        if("java".equals(language))
        {
            Class cls = getArrayClass(a);
            sb.append((new StringBuilder()).append("new ").append(cls.getName()).toString());
            int i = 0;
            for(int dim = getArrayDimension(a); i < dim; i++)
                sb.append("[]");

            sb.append(" {");
            int len = Array.getLength(a);
            for(i = 0; i < len; i++)
            {
                sb.append(arrayToString(Array.get(a, i), delim));
                if(i < len - 1)
                    sb.append(delim);
            }

            sb.append("}");
        } else
        if("cs".equals(language))
        {
            Class cls = getArrayClass(a);
            sb.append((new StringBuilder()).append("new ").append(getLanguageSpecificTypeName(cls.getName(), "cs")).toString());
            int i = 0;
            for(int dim = getArrayDimension(a); i < dim; i++)
                sb.append("[]");

            sb.append(" {");
            int len = Array.getLength(a);
            for(i = 0; i < len; i++)
            {
                sb.append(arrayToString(Array.get(a, i), delim, language));
                if(i < len - 1)
                    sb.append(delim);
            }

            sb.append('}');
        } else
        if("vb".equals(language))
        {
            Class cls = getArrayClass(a);
            String clsN = getLanguageSpecificTypeName(cls.getName(), "vb");
            sb.append((new StringBuilder()).append("New ").append(Character.toUpperCase(clsN.charAt(0))).append(clsN.substring(1)).toString());
            int i = 0;
            for(int dim = getArrayDimension(a); i < dim; i++)
                sb.append("()");

            sb.append(" {");
            int len = Array.getLength(a);
            for(i = 0; i < len; i++)
            {
                sb.append(arrayToString(Array.get(a, i), delim, language));
                if(i < len - 1)
                    sb.append(delim);
            }

            sb.append('}');
        } else
        if("delphi".equals(language))
        {
            sb.append("(");
            int len = Array.getLength(a);
            for(int i = 0; i < len; i++)
            {
                sb.append(arrayToString(Array.get(a, i), delim, language));
                if(i < len - 1)
                    sb.append(delim);
            }

            sb.append(')');
        }
        return sb.toString();
    }

    public static String methodString(String methodName, Type clss[], String names[])
    {
        StringBuffer sb = new StringBuffer();
        sb.append(methodName);
        sb.append("( ");
        for(int i = 0; i < clss.length; i++)
        {
            sb.append(clss[i].name);
            for(int j = 0; j < clss[i].dim; j++)
                sb.append("[]");

            sb.append((new StringBuilder()).append(" ").append(names[i]).toString());
            if(i != -1 + clss.length)
                sb.append(", ");
        }

        sb.append(" )");
        return sb.toString();
    }

    public static String methodString(String methodName, Class clss[], String names[], String language)
    {
        if(!"java".equals(language) && !"cs".equals(language) && !"vb".equals(language) && !"delphi".equals(language))
            throw new IllegalArgumentException("unknown language identifier");
        StringBuffer sb = new StringBuffer();
        if("java".equals(language))
        {
            sb.append(methodName);
            sb.append("( ");
            for(int i = 0; i < clss.length; i++)
            {
                String clsN = clss[i].getName();
                int firstOccurrence = clsN.indexOf('[');
                int lastOccurrence = clsN.lastIndexOf('[');
                if(-1 != firstOccurrence)
                {
                    char pt = clsN.charAt(1 + lastOccurrence);
                    switch(pt)
                    {
                    case 73: // 'I'
                        sb.append("int");
                        break;

                    case 74: // 'J'
                        sb.append("long");
                        break;

                    case 83: // 'S'
                        sb.append("short");
                        break;

                    case 70: // 'F'
                        sb.append("float");
                        break;

                    case 68: // 'D'
                        sb.append("double");
                        break;

                    case 67: // 'C'
                        sb.append("char");
                        break;

                    case 66: // 'B'
                        sb.append("byte");
                        break;

                    case 90: // 'Z'
                        sb.append("boolean");
                        break;

                    case 76: // 'L'
                        sb.append(clsN.substring(1 + lastOccurrence));
                        break;
                    }
                    for(int j = 0; j < (lastOccurrence - firstOccurrence) + 1; j++)
                        sb.append("[]");

                } else
                {
                    sb.append(clss[i].getName());
                }
                sb.append((new StringBuilder()).append(" ").append(names[i]).toString());
                if(i != -1 + clss.length)
                    sb.append(", ");
            }

            sb.append(" )");
        } else
        if("cs".equals(language))
        {
            sb.append((new StringBuilder()).append("").append(Character.toUpperCase(methodName.charAt(0))).append(methodName.substring(1)).toString());
            sb.append("( ");
            for(int i = 0; i < clss.length; i++)
            {
                String clsN = clss[i].getName();
                int firstOccurrence = clsN.indexOf('[');
                int lastOccurrence = clsN.lastIndexOf('[');
                if(-1 != firstOccurrence)
                {
                    char pt = clsN.charAt(1 + lastOccurrence);
                    switch(pt)
                    {
                    case 73: // 'I'
                        sb.append(getLanguageSpecificTypeName("int", language));
                        break;

                    case 74: // 'J'
                        sb.append(getLanguageSpecificTypeName("long", language));
                        break;

                    case 83: // 'S'
                        sb.append(getLanguageSpecificTypeName("short", language));
                        break;

                    case 70: // 'F'
                        sb.append(getLanguageSpecificTypeName("float", language));
                        break;

                    case 68: // 'D'
                        sb.append(getLanguageSpecificTypeName("double", language));
                        break;

                    case 67: // 'C'
                        sb.append(getLanguageSpecificTypeName("char", language));
                        break;

                    case 66: // 'B'
                        sb.append(getLanguageSpecificTypeName("byte", language));
                        break;

                    case 90: // 'Z'
                        sb.append(getLanguageSpecificTypeName("boolean", language));
                        break;

                    case 76: // 'L'
                        sb.append(clsN.substring(1 + lastOccurrence));
                        break;
                    }
                    for(int j = 0; j < (lastOccurrence - firstOccurrence) + 1; j++)
                        sb.append("[]");

                } else
                {
                    sb.append(getLanguageSpecificTypeName(clsN, language));
                }
                sb.append((new StringBuilder()).append(" ").append(names[i]).toString());
                if(i != -1 + clss.length)
                    sb.append(", ");
            }

            sb.append(" )");
        } else
        if("vb".equals(language))
        {
            sb.append((new StringBuilder()).append("").append(Character.toUpperCase(methodName.charAt(0))).append(methodName.substring(1)).toString());
            sb.append("( ");
            for(int i = 0; i < clss.length; i++)
            {
                sb.append((new StringBuilder()).append(names[i]).append(" As ").toString());
                String clsN = clss[i].getName();
                int firstOccurrence = clsN.indexOf('[');
                int lastOccurrence = clsN.lastIndexOf('[');
                if(-1 != firstOccurrence)
                {
                    char pt = clsN.charAt(1 + lastOccurrence);
                    switch(pt)
                    {
                    case 73: // 'I'
                        sb.append(getLanguageSpecificTypeName("int", language));
                        break;

                    case 74: // 'J'
                        sb.append(getLanguageSpecificTypeName("long", language));
                        break;

                    case 83: // 'S'
                        sb.append(getLanguageSpecificTypeName("short", language));
                        break;

                    case 70: // 'F'
                        sb.append(getLanguageSpecificTypeName("float", language));
                        break;

                    case 68: // 'D'
                        sb.append(getLanguageSpecificTypeName("double", language));
                        break;

                    case 67: // 'C'
                        sb.append(getLanguageSpecificTypeName("char", language));
                        break;

                    case 66: // 'B'
                        sb.append(getLanguageSpecificTypeName("byte", language));
                        break;

                    case 90: // 'Z'
                        sb.append(getLanguageSpecificTypeName("boolean", language));
                        break;

                    case 76: // 'L'
                        sb.append(clsN.substring(1 + lastOccurrence));
                        break;
                    }
                    for(int j = 0; j < (lastOccurrence - firstOccurrence) + 1; j++)
                        sb.append("()");

                } else
                {
                    sb.append(getLanguageSpecificTypeName(clsN, language));
                }
                if(i != -1 + clss.length)
                    sb.append(", ");
            }

            sb.append(" )");
        } else
        if("delphi".equals(language))
        {
            sb.append((new StringBuilder()).append("").append(Character.toUpperCase(methodName.charAt(0))).append(methodName.substring(1)).toString());
            sb.append("( ");
            for(int i = 0; i < clss.length; i++)
            {
                sb.append((new StringBuilder()).append(names[i]).append(" : ").toString());
                String clsN = clss[i].getName();
                int firstOccurrence = clsN.indexOf('[');
                int lastOccurrence = clsN.lastIndexOf('[');
                if(-1 != firstOccurrence)
                {
                    for(int j = 0; j < (lastOccurrence - firstOccurrence) + 1; j++)
                        sb.append("Array of ");

                    char pt = clsN.charAt(1 + lastOccurrence);
                    switch(pt)
                    {
                    case 73: // 'I'
                        sb.append(getLanguageSpecificTypeName("int", language));
                        break;

                    case 74: // 'J'
                        sb.append(getLanguageSpecificTypeName("long", language));
                        break;

                    case 83: // 'S'
                        sb.append(getLanguageSpecificTypeName("short", language));
                        break;

                    case 70: // 'F'
                        sb.append(getLanguageSpecificTypeName("float", language));
                        break;

                    case 68: // 'D'
                        sb.append(getLanguageSpecificTypeName("double", language));
                        break;

                    case 67: // 'C'
                        sb.append(getLanguageSpecificTypeName("char", language));
                        break;

                    case 66: // 'B'
                        sb.append(getLanguageSpecificTypeName("byte", language));
                        break;

                    case 90: // 'Z'
                        sb.append(getLanguageSpecificTypeName("boolean", language));
                        break;

                    case 76: // 'L'
                        sb.append(clsN.substring(1 + lastOccurrence));
                        break;
                    }
                } else
                {
                    sb.append(getLanguageSpecificTypeName(clsN, language));
                }
                if(i != -1 + clss.length)
                    sb.append("; ");
            }

            sb.append(" )");
        }
        return sb.toString();
    }

    public static String getTypeString(Class cls)
    {
        StringBuffer sb = new StringBuffer();
        String clsN = cls.getName();
        int firstOccurrence = clsN.indexOf('[');
        int lastOccurrence = clsN.lastIndexOf('[');
        if(-1 != firstOccurrence)
        {
            char pt = clsN.charAt(1 + lastOccurrence);
            switch(pt)
            {
            case 73: // 'I'
                sb.append("int");
                break;

            case 74: // 'J'
                sb.append("long");
                break;

            case 83: // 'S'
                sb.append("short");
                break;

            case 70: // 'F'
                sb.append("float");
                break;

            case 68: // 'D'
                sb.append("double");
                break;

            case 67: // 'C'
                sb.append("char");
                break;

            case 66: // 'B'
                sb.append("byte");
                break;

            case 90: // 'Z'
                sb.append("boolean");
                break;

            case 76: // 'L'
                sb.append(clsN.substring(1 + lastOccurrence));
                break;
            }
            for(int j = 0; j < (lastOccurrence - firstOccurrence) + 1; j++)
                sb.append("[]");

        } else
        {
            sb.append(clsN);
        }
        return sb.toString();
    }

    public static String getLanguageSpecificTypeName(String type, String language)
    {
        if(!"cs".equals(language) && !"vb".equals(language) && !"delphi".equals(language) && !"c".equals(language))
            throw new IllegalArgumentException("unknown language identifier");
        String s[] = (String[])(String[])(String[])languageSpecificTypeName.get(type);
        if(null != s)
        {
            if("cs".equals(language) || "c".equals(language))
                return s[0];
            if("vb".equals(language))
                return s[1];
            if("delphi".equals(language))
                return s[2];
        }
        return type;
    }

    public static String getLanguageSpecificTypeName(Class c, String language)
    {
        if(!c.isArray())
            return getLanguageSpecificTypeName(getTypeString(c), language);
        String s = getLanguageSpecificTypeName(getTypeString(getArrayClassFromClass(c)), language);
        int dim = getArrayDimensionFromClass(c);
        if("java".equals(language) || "cs".equals(language))
        {
            for(int i = 0; i < dim; i++)
                s = (new StringBuilder()).append(s).append("[]").toString();

        }
        if("vb".equals(language))
        {
            for(int i = 0; i < dim; i++)
                s = (new StringBuilder()).append(s).append("()").toString();

        }
        if("delphi".equals(language))
        {
            String ss = "";
            for(int i = 0; i < dim; i++)
                ss = (new StringBuilder()).append(ss).append("Array of ").toString();

            s = (new StringBuilder()).append(ss).append(s).toString();
        }
        if("c".equals(language))
        {
            for(int i = 0; i < dim; i++)
                s = (new StringBuilder()).append(s).append("*").toString();

        }
        return s;
    }

    public static int[] getArrayDimensions(Object a)
    {
        if(null == a)
            throw new IllegalArgumentException("cannot accept null arrays");
        if(!a.getClass().isArray())
            throw new IllegalArgumentException("only arrays are accepted as argument");
        if(0 == Array.getLength(a))
            return new int[0];
        int dims[] = new int[getArrayDimension(a)];
        int dim = 0;
        Object a0 = a;
        for(Class c = a.getClass(); c.isArray(); c = c.getComponentType())
        {
            dims[dim] = Array.getLength(a0);
            a0 = Array.get(a0, 0);
            dim++;
        }

        return dims;
    }

    public static int getArrayDimension(Object a)
    {
        if(null == a)
            throw new IllegalArgumentException("cannot accept null arrays");
        if(!a.getClass().isArray())
            throw new IllegalArgumentException("only arrays are accepted as argument");
        int dim = 0;
        for(Class c = a.getClass(); c.isArray(); c = c.getComponentType())
            dim++;

        return dim;
    }

    public static int getArrayDimensionFromClass(Class a)
    {
        if(null == a)
            throw new IllegalArgumentException("cannot accept null arrays");
        if(!a.isArray())
            throw new IllegalArgumentException("only arrays are accepted as argument");
        int dim = 0;
        for(Class c = a; c.isArray(); c = c.getComponentType())
            dim++;

        return dim;
    }

    public static Class getArrayClass(Object a)
    {
        if(null == a)
            throw new IllegalArgumentException("cannot accept null arrays");
        if(!a.getClass().isArray())
            throw new IllegalArgumentException("only arrays are accepted as argument");
        Class c = null;
        for(c = a.getClass(); c.isArray(); c = c.getComponentType());
        return c;
    }

    public static Class getArrayClassFromClass(Class a)
    {
        if(null == a)
            throw new IllegalArgumentException("cannot accept null arrays");
        if(!a.isArray())
            throw new IllegalArgumentException("only array classes are accepted as argument");
        Class c = null;
        for(c = a; c.isArray(); c = c.getComponentType());
        return c;
    }

    public static String arrayInitString(Object a, String language)
    {
        if(!"java".equals(language) && !"cs".equals(language) && !"vb".equals(language) && !"delphi".equals(language))
            throw new IllegalArgumentException("unknown language identifier");
        if(!a.getClass().isArray())
        {
            throw new IllegalArgumentException("an array is expected");
        } else
        {
            Class cls = getArrayClass(a);
            StringBuffer sb = new StringBuffer();
            sb.append(arrayToString(a, ", ", language));
            return sb.toString();
        }
    }

    public static String trunc(Object o)
    {
        if(o.getClass().equals(java/lang/Double))
        {
            double d = ((Double)o).doubleValue();
            return (new StringBuilder()).append("").append((double)(int)(10000D * d) / 10000D).toString();
        }
        if(o.getClass().equals(java/lang/Float))
        {
            float f = ((Float)o).floatValue();
            return (new StringBuilder()).append("").append((double)(int)(10000F * f) / 10000D).toString();
        } else
        {
            return o.toString();
        }
    }

    private static Hashtable languageSpecificTypeName;

    static 
    {
        languageSpecificTypeName = new Hashtable();
        languageSpecificTypeName.put("int", new String[] {
            "int", "Integer", "Integer"
        });
        languageSpecificTypeName.put("long", new String[] {
            "long", "Long", "Int64"
        });
        languageSpecificTypeName.put("short", new String[] {
            "short", "Short", "Integer"
        });
        languageSpecificTypeName.put("float", new String[] {
            "float", "Single", "Real"
        });
        languageSpecificTypeName.put("double", new String[] {
            "double", "Double", "Double"
        });
        languageSpecificTypeName.put("char", new String[] {
            "char", "Char", "Char"
        });
        languageSpecificTypeName.put("byte", new String[] {
            "byte", "Byte", "Byte"
        });
        languageSpecificTypeName.put("boolean", new String[] {
            "bool", "Boolean", "Boolean"
        });
    }
}
