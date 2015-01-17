// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PortalUtils.java

package com.dtmc.server.analytics.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.dtmc.server.analytics.util:
//            UtilHttp, FormatUtils

public class PortalUtils
{

    public PortalUtils()
    {
    }

    public static String getPath(HttpServletRequest request)
    {
        Map params = UtilHttp.getParameterMap(request);
        StringBuffer sb = new StringBuffer();
        if(params.get("app") != null)
            sb.append((String)params.get("app"));
        if(params.get("page") != null)
            sb.append((new StringBuilder()).append(".").append((String)params.get("page")).toString());
        if(params.get("portlet") != null)
            sb.append((new StringBuilder()).append(".").append((String)params.get("portlet")).toString());
        return sb.toString();
    }

    public static boolean isTop(HttpServletRequest request)
    {
        Map params = UtilHttp.getParameterMap(request);
        boolean b = false;
        if(params.get("app") == null && params.get("page") == null)
            b = true;
        return b;
    }

    public static boolean isApp(HttpServletRequest request)
    {
        Map params = UtilHttp.getParameterMap(request);
        boolean b = false;
        if(params.get("app") != null && params.get("page") == null)
            b = true;
        return b;
    }

    public static boolean isPage(HttpServletRequest request)
    {
        Map params = UtilHttp.getParameterMap(request);
        boolean b = false;
        if(params.get("app") != null && params.get("page") != null)
            b = true;
        return b;
    }

    public static void getBack(Writer out)
        throws IOException
    {
        out.write("<div id='toolbar'>\n");
        out.write("   <a href='javascript:history.go(-1)'>Ritorna ai Risultati</a>\n");
        out.write("</div>\n");
    }

    public static void row(HttpServletRequest request, String name, Writer out)
        throws IOException
    {
        row(request, name, "", out);
    }

    public static void row(HttpServletRequest request, String name, String value, Writer out)
        throws IOException
    {
        out.write("<tr> \n");
        out.write((new StringBuilder()).append(" <td valign='top'>").append(FormatUtils.getString(request, name)).append("   \n").toString());
        out.write("     <span class='red'>*</span> \n");
        out.write(" </td>  \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <img src='images/transparent.gif' name='").append(name).append("' width='18' height='18' align='top'>  \n").toString());
        out.write(" </td>   \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <input type='text' value='").append(value).append("' name='").append(name).append("' size='10' maxlength='30'>  \n").toString());
        out.write(" </td>   \n");
        out.write("</tr>   \n");
    }

    public static void checkrow(HttpServletRequest request, String name, Writer out)
        throws IOException
    {
        out.write("<tr> \n");
        out.write((new StringBuilder()).append(" <td valign='top'>").append(FormatUtils.getString(request, name)).append("   \n").toString());
        out.write("     <span class='red'>*</span> \n");
        out.write(" </td>  \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <img src='images/transparent.gif' name='").append(name).append("' width='18' height='18' align='top'>  \n").toString());
        out.write(" </td>   \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <input type='checkbox' value='ON' name='").append(name).append("' >  \n").toString());
        out.write(" </td>   \n");
        out.write("</tr>   \n");
    }

    public static void editor(HttpServletRequest request, String text, Writer out)
        throws IOException
    {
        out.write("<table border='0' cellspacing='0' cellpadding='2'>\n");
        out.write("<tr><td> \n");
        out.write((new StringBuilder()).append("<script type=\"text/javascript\" src=\"").append(request.getContextPath()).append("/htmlarea.js\"></script>\n").toString());
        out.write((new StringBuilder()).append("<script type=\"text/javascript\" src=\"").append(request.getContextPath()).append("/initeditor.js\"></script>\n").toString());
        out.write("<script type=\"text/javascript\">\n");
        out.write("initEditor();\n");
        out.write("</script> \n");
        out.write("<textarea id=\"ta\" name=\"ta\" rows=\"24\" cols=\"140\">\n");
        if(text != null)
            out.write(text);
        out.write("</textarea>\n");
        out.write("</td></tr> \n");
        out.write("</table>");
    }

    public static void rowoptional(HttpServletRequest request, String name, String value, Writer out)
        throws IOException
    {
        out.write("<tr> \n");
        out.write((new StringBuilder()).append(" <td valign='top'>").append(FormatUtils.getString(request, name)).append(" \n").toString());
        out.write(" </td>  \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <img src='images/transparent.gif' name='").append(name).append("' width='18' height='18' align='top'>  \n").toString());
        out.write(" </td>   \n");
        out.write(" <td valign='top'>    \n");
        out.write((new StringBuilder()).append("     <input type='text' value='").append(value).append("' name='").append(name).append("' size='10' maxlength='30'>  \n").toString());
        out.write(" </td>   \n");
        out.write("</tr>   \n");
    }

    public static void rowoptional(HttpServletRequest request, String name, Writer out)
        throws IOException
    {
        rowoptional(request, name, "", out);
    }

    public static void message(String message, Writer out)
        throws IOException
    {
        if(message != null)
        {
            out.write("<table>\n");
            out.write("<tr>\n");
            out.write("<td>\n");
            out.write("<img src='images/warning.gif'/>\n");
            out.write("</td>\n");
            out.write("<td> </td>\n");
            out.write("<td align='right'>\n");
            out.write(message);
            out.write("</td>\n");
            out.write("</tr>\n");
            out.write("</table>\n");
            out.flush();
        }
    }

    public static void buttons(String command, Writer out)
        throws IOException
    {
        out.write("<tr>\n");
        out.write("<td>\n");
        out.write("<span class='red'>* = obbligario</span>\n");
        out.write("</td>\n");
        out.write("<td> </td>");
        out.write("<td align='right'>\n");
        out.write(" <input type='reset' value='reset'>\n");
        out.write((new StringBuilder()).append("   <input type='submit' name='command' value='").append(command).append("'>\n").toString());
        out.write(" </td>\n");
        out.write("</tr>\n");
    }

    public static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/PortalUtils);

}
