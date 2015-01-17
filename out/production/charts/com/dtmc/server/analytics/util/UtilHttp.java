// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilHttp.java

package com.dtmc.server.analytics.util;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.http.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            OrderedMap, UtilMisc, UtilValidate

public class UtilHttp
{

    public UtilHttp()
    {
    }

    public static boolean is(Map map, String name)
    {
        return map.get("command") != null && map.get("command").equals(name);
    }

    public static Map getParameterMap(HttpServletRequest request)
    {
        Map paramMap = new OrderedMap();
        String pathInfoStr = request.getPathInfo();
        if(pathInfoStr != null && pathInfoStr.length() > 0)
        {
            if(!pathInfoStr.endsWith("/"))
                pathInfoStr = (new StringBuilder()).append(pathInfoStr).append("/").toString();
            int current = pathInfoStr.indexOf('/');
            int last = current;
            do
            {
                if((current = pathInfoStr.indexOf('/', last + 1)) == -1)
                    break;
                String element = pathInfoStr.substring(last + 1, current);
                last = current;
                if(element.indexOf('=') > -1)
                {
                    String name = element.substring(0, element.indexOf('='));
                    String value = element.substring(element.indexOf('=') + 1);
                    paramMap.put(name, value);
                }
            } while(true);
        }
        String name;
        for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); paramMap.put(name, request.getParameter(name)))
            name = (String)e.nextElement();

        return paramMap;
    }

    public String toURL(HttpServletRequest request)
    {
        return urlEncodeArgs(getParameterMap(request));
    }

    public static Map makeParamMapWithPrefix(HttpServletRequest request, String prefix, String suffix)
    {
        Map paramMap = new HashMap();
        Enumeration parameterNames = request.getParameterNames();
        do
        {
            if(!parameterNames.hasMoreElements())
                break;
            String parameterName = (String)parameterNames.nextElement();
            if(parameterName.startsWith(prefix))
                if(suffix != null && suffix.length() > 0)
                {
                    if(parameterName.endsWith(suffix))
                    {
                        String key = parameterName.substring(prefix.length(), parameterName.length() - (suffix.length() - 1));
                        String value = request.getParameter(parameterName);
                        paramMap.put(key, value);
                    }
                } else
                {
                    String key = parameterName.substring(prefix.length());
                    String value = request.getParameter(parameterName);
                    paramMap.put(key, value);
                }
        } while(true);
        return paramMap;
    }

    public static List makeParamListWithSuffix(HttpServletRequest request, String suffix, String prefix)
    {
        List paramList = new ArrayList();
        Enumeration parameterNames = request.getParameterNames();
        do
        {
            if(!parameterNames.hasMoreElements())
                break;
            String parameterName = (String)parameterNames.nextElement();
            if(parameterName.endsWith(suffix))
                if(prefix != null && prefix.length() > 0)
                {
                    if(parameterName.startsWith(prefix))
                    {
                        String value = request.getParameter(parameterName);
                        paramList.add(value);
                    }
                } else
                {
                    String value = request.getParameter(parameterName);
                    paramList.add(value);
                }
        } while(true);
        return paramList;
    }

    public static String getApplicationName(HttpServletRequest request)
    {
        String appName = "root";
        if(request.getContextPath().length() > 1)
            appName = request.getContextPath().substring(1);
        return appName;
    }

    public static void parametersToAttributes(HttpServletRequest request)
    {
        String name;
        for(Enumeration e = request.getParameterNames(); e.hasMoreElements(); request.setAttribute(name, request.getParameter(name)))
            name = (String)e.nextElement();

    }

    public static StringBuffer getServerRootUrl(HttpServletRequest request)
    {
        StringBuffer requestUrl = new StringBuffer();
        requestUrl.append(request.getScheme());
        requestUrl.append((new StringBuilder()).append("://").append(request.getServerName()).toString());
        if(request.getServerPort() != 80 && request.getServerPort() != 443)
            requestUrl.append((new StringBuilder()).append(":").append(request.getServerPort()).toString());
        return requestUrl;
    }

    public static StringBuffer getFullRequestUrl(HttpServletRequest request)
    {
        StringBuffer requestUrl = getServerRootUrl(request);
        requestUrl.append(request.getRequestURI());
        if(request.getQueryString() != null)
            requestUrl.append((new StringBuilder()).append("?").append(request.getQueryString()).toString());
        return requestUrl;
    }

    private static Locale getLocale(HttpServletRequest request, HttpSession session)
    {
        Object localeObject = session == null ? null : session.getAttribute("locale");
        if(localeObject == null)
            localeObject = request == null ? null : ((Object) (request.getLocale()));
        return UtilMisc.ensureLocale(localeObject);
    }

    public static Locale getLocale(HttpServletRequest request)
    {
        if(request == null)
            return Locale.getDefault();
        else
            return getLocale(request, request.getSession());
    }

    public static Locale getLocale(HttpSession session)
    {
        if(session == null)
            return Locale.getDefault();
        else
            return getLocale(null, session);
    }

    public static void setLocale(HttpServletRequest request, String localeString)
    {
        setLocale(request, UtilMisc.parseLocale(localeString));
    }

    public static void setLocale(HttpServletRequest request, Locale locale)
    {
        request.getSession().setAttribute("locale", locale);
    }

    public static String setSessionLocale(HttpServletRequest request, HttpServletResponse response)
    {
        String localeString = request.getParameter("locale");
        if(UtilValidate.isNotEmpty(localeString))
            setLocale(request, localeString);
        return "view";
    }

    public static String getCurrencyUom(HttpSession session)
    {
        String iso = (String)session.getAttribute("currencyUom");
        if(iso == null)
        {
            Currency cur = Currency.getInstance(Locale.getDefault());
            iso = cur.getCurrencyCode();
        }
        return iso;
    }

    public static String getCurrencyUom(HttpServletRequest request)
    {
        return getCurrencyUom(request.getSession());
    }

    public static void setCurrencyUom(HttpServletRequest request, String currencyUom)
    {
        request.getSession().setAttribute("currencyUom", currencyUom);
    }

    public static String setSessionCurrencyUom(HttpServletRequest request, HttpServletResponse response)
    {
        String currencyUom = request.getParameter("currencyUom");
        if(UtilValidate.isNotEmpty(currencyUom))
            setCurrencyUom(request, currencyUom);
        return "view";
    }

    public static String urlEncodeArgs(Map args)
    {
        StringBuffer buf = new StringBuffer();
        if(args != null)
        {
            Iterator i = args.entrySet().iterator();
            do
            {
                if(!i.hasNext())
                    break;
                java.util.Map.Entry entry = (java.util.Map.Entry)i.next();
                String name = (String)entry.getKey();
                Object value = entry.getValue();
                String valueStr = null;
                if(name != null && value != null)
                {
                    if(value instanceof String)
                        valueStr = (String)value;
                    else
                        valueStr = value.toString();
                    if(valueStr != null && valueStr.length() > 0)
                    {
                        if(buf.length() > 0)
                            buf.append('&');
                        try
                        {
                            buf.append(URLEncoder.encode(name, "UTF-8"));
                        }
                        catch(UnsupportedEncodingException e)
                        {
                            e.printStackTrace();
                        }
                        buf.append('=');
                        try
                        {
                            buf.append(URLEncoder.encode(valueStr, "UTF-8"));
                        }
                        catch(UnsupportedEncodingException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            } while(true);
        }
        return buf.toString();
    }

    public static String setResponseBrowserProxyNoCache(HttpServletRequest request, HttpServletResponse response)
    {
        setResponseBrowserProxyNoCache(response);
        return "view";
    }

    public static void setResponseBrowserProxyNoCache(HttpServletResponse response)
    {
        long nowMillis = System.currentTimeMillis();
        response.setDateHeader("Expires", nowMillis);
        response.setDateHeader("Last-Modified", nowMillis);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0, false");
        response.setHeader("Pragma", "no-cache");
    }

    public static String getContentTypeByFileName(String fileName)
    {
        FileNameMap mime = URLConnection.getFileNameMap();
        return mime.getContentTypeFor(fileName);
    }

    public static void streamContentToBrowser(HttpServletResponse response, byte bytes[], String contentType)
        throws IOException
    {
        setResponseBrowserProxyNoCache(response);
        response.setContentLength(bytes.length);
        if(contentType != null)
            response.setContentType(contentType);
        OutputStream out = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(bytes);
        try
        {
            streamContent(out, in, bytes.length);
        }
        catch(IOException e)
        {
            in.close();
            out.close();
            throw e;
        }
        in.close();
        out.flush();
        out.close();
    }

    public static void streamContentToBrowser(HttpServletResponse response, InputStream in, int length, String contentType)
        throws IOException
    {
        setResponseBrowserProxyNoCache(response);
        response.setContentLength(length);
        if(contentType != null)
            response.setContentType(contentType);
        OutputStream out = response.getOutputStream();
        try
        {
            streamContent(out, in, length);
        }
        catch(IOException e)
        {
            out.close();
            throw e;
        }
        out.flush();
        out.close();
    }

    public static void streamContent(OutputStream out, InputStream in, int length)
        throws IOException
    {
        BufferedOutputStream bos;
        BufferedInputStream bis;
        Exception exception;
        int bufferSize = 512;
        bos = new BufferedOutputStream(out, bufferSize);
        bis = new BufferedInputStream(in, bufferSize);
        byte buffer[] = new byte[length];
        int read = 0;
        try
        {
            while(-1 != (read = bis.read(buffer, 0, buffer.length))) 
                bos.write(buffer, 0, read);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            bis.close();
            bos.close();
            throw e;
        }
        finally
        {
            if(bis == null) goto _L0; else goto _L0
        }
        if(bis != null)
            bis.close();
        if(bos != null)
        {
            bos.flush();
            bos.close();
        }
        break MISSING_BLOCK_LABEL_143;
        bis.close();
        if(bos != null)
        {
            bos.flush();
            bos.close();
        }
        throw exception;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilHttp.getName();

}
