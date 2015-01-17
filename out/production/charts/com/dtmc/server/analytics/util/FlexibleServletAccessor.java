// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FlexibleServletAccessor.java

package com.dtmc.server.analytics.util;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

// Referenced classes of package com.dtmc.server.analytics.util:
//            FlexibleMapAccessor, FlexibleStringExpander

public class FlexibleServletAccessor
{
    protected static class AttributeAccessor
    {

        public Object get(ServletRequest request)
        {
            Object theValue = null;
            if(isListReference)
            {
                List lst = (List)request.getAttribute(attributeName);
                theValue = lst.get(listIndex);
            } else
            {
                theValue = request.getAttribute(attributeName);
            }
            if(fma != null)
                return fma.get((Map)theValue);
            else
                return theValue;
        }

        public Object get(HttpSession session)
        {
            Object theValue = null;
            if(isListReference)
            {
                List lst = (List)session.getAttribute(attributeName);
                theValue = lst.get(listIndex);
            } else
            {
                theValue = session.getAttribute(attributeName);
            }
            if(fma != null)
                return fma.get((Map)theValue);
            else
                return theValue;
        }

        protected void putInList(List lst, Object value)
        {
            if(isAddAtEnd)
                lst.add(value);
            else
            if(isAddAtIndex)
                lst.add(listIndex, value);
            else
                lst.set(listIndex, value);
        }

        public void put(ServletRequest request, Object value)
        {
            if(fma == null)
            {
                if(isListReference)
                {
                    List lst = (List)request.getAttribute(attributeName);
                    putInList(lst, value);
                } else
                {
                    request.setAttribute(attributeName, value);
                }
            } else
            {
                Object theObj = request.getAttribute(attributeName);
                if(isListReference)
                {
                    List lst = (List)theObj;
                    fma.put((Map)lst.get(listIndex), value);
                } else
                {
                    fma.put((Map)theObj, value);
                }
            }
        }

        public void put(HttpSession session, Object value)
        {
            if(fma == null)
            {
                if(isListReference)
                {
                    List lst = (List)session.getAttribute(attributeName);
                    putInList(lst, value);
                } else
                {
                    session.setAttribute(attributeName, value);
                }
            } else
            {
                Object theObj = session.getAttribute(attributeName);
                if(isListReference)
                {
                    List lst = (List)theObj;
                    fma.put((Map)lst.get(listIndex), value);
                } else
                {
                    fma.put((Map)theObj, value);
                }
            }
        }

        public Object remove(ServletRequest request)
        {
            if(fma != null)
            {
                Object theObj = request.getAttribute(attributeName);
                if(isListReference)
                {
                    List lst = (List)theObj;
                    return fma.remove((Map)lst.get(listIndex));
                } else
                {
                    return fma.remove((Map)theObj);
                }
            }
            if(isListReference)
            {
                List lst = (List)request.getAttribute(attributeName);
                return lst.remove(listIndex);
            } else
            {
                Object theValue = request.getAttribute(attributeName);
                request.removeAttribute(attributeName);
                return theValue;
            }
        }

        public Object remove(HttpSession session)
        {
            if(fma != null)
            {
                Object theObj = session.getAttribute(attributeName);
                if(isListReference)
                {
                    List lst = (List)theObj;
                    return fma.remove((Map)lst.get(listIndex));
                } else
                {
                    return fma.remove((Map)theObj);
                }
            }
            if(isListReference)
            {
                List lst = (List)session.getAttribute(attributeName);
                return lst.remove(listIndex);
            } else
            {
                Object theValue = session.getAttribute(attributeName);
                session.removeAttribute(attributeName);
                return theValue;
            }
        }

        protected Map expandContext;
        protected String attributeName;
        protected FlexibleMapAccessor fma;
        protected boolean isListReference;
        protected boolean isAddAtIndex;
        protected boolean isAddAtEnd;
        protected int listIndex;
        protected int openBrace;
        protected int closeBrace;

        public AttributeAccessor(String origName, Map expandContext, String defAttributeName, FlexibleMapAccessor defFma, boolean needsExpand)
        {
            attributeName = defAttributeName;
            fma = defFma;
            if(needsExpand)
            {
                String name = FlexibleStringExpander.expandString(origName, expandContext);
                int dotIndex = name.indexOf('.');
                if(dotIndex != -1)
                {
                    attributeName = name.substring(0, dotIndex);
                    fma = new FlexibleMapAccessor(name.substring(dotIndex + 1));
                } else
                {
                    attributeName = name;
                    fma = null;
                }
            }
            isListReference = false;
            isAddAtIndex = false;
            isAddAtEnd = false;
            listIndex = -1;
            openBrace = attributeName.indexOf('[');
            closeBrace = openBrace != -1 ? attributeName.indexOf(']', openBrace) : -1;
            if(openBrace != -1 && closeBrace != -1)
            {
                String liStr = attributeName.substring(openBrace + 1, closeBrace);
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
                attributeName = attributeName.substring(0, openBrace);
                isListReference = true;
            }
        }
    }


    public FlexibleServletAccessor(String name)
    {
        init(name);
    }

    public FlexibleServletAccessor(String name, String defaultName)
    {
        if(name == null || name.length() == 0)
            init(defaultName);
        else
            init(name);
    }

    protected void init(String name)
    {
        this.name = name;
        if(name == null || name.length() == 0)
        {
            empty = true;
            needsExpand = false;
            fma = new FlexibleMapAccessor(name);
            attributeName = name;
        } else
        {
            empty = false;
            int openPos = name.indexOf("${");
            if(openPos != -1 && name.indexOf("}", openPos) != -1)
            {
                fma = null;
                attributeName = null;
                needsExpand = true;
            } else
            {
                int dotIndex = name.indexOf('.');
                if(dotIndex != -1)
                {
                    attributeName = name.substring(0, dotIndex);
                    fma = new FlexibleMapAccessor(name.substring(dotIndex + 1));
                } else
                {
                    attributeName = name;
                    fma = null;
                }
                needsExpand = false;
            }
        }
    }

    public boolean isEmpty()
    {
        return empty;
    }

    public Object get(ServletRequest request, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        return aa.get(request);
    }

    public Object get(HttpSession session, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        return aa.get(session);
    }

    public void put(ServletRequest request, Object value, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        aa.put(request, value);
    }

    public void put(HttpSession session, Object value, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        aa.put(session, value);
    }

    public Object remove(ServletRequest request, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        return aa.remove(request);
    }

    public Object remove(HttpSession session, Map expandContext)
    {
        AttributeAccessor aa = new AttributeAccessor(name, expandContext, attributeName, fma, needsExpand);
        return aa.remove(session);
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof FlexibleServletAccessor)
        {
            FlexibleServletAccessor flexibleServletAccessor = (FlexibleServletAccessor)obj;
            if(name == null)
                return flexibleServletAccessor.name == null;
            else
                return name.equals(flexibleServletAccessor.name);
        }
        String str = (String)obj;
        if(name == null)
            return str == null;
        else
            return name.equals(str);
    }

    public String toString()
    {
        return name;
    }

    protected String name;
    protected String attributeName;
    protected FlexibleMapAccessor fma;
    protected boolean needsExpand;
    protected boolean empty;
}
