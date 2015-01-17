// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Dom4JXmlUtils.java

package com.dtmc.server.analytics.util;

import java.io.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.*;

public class Dom4JXmlUtils
{

    public Dom4JXmlUtils()
    {
    }

    public static Document generateDocFromXml(String xml)
    {
        SAXReader reader = new SAXReader();
        Document document2;
        try
        {
            document2 = reader.read(stringToInputStream(xml));
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error on generateDocFromXml", e);
        }
        return document2;
    }

    private static ByteArrayInputStream stringToInputStream(String xml)
        throws UnsupportedEncodingException
    {
        return new ByteArrayInputStream(xml.getBytes("UTF-8"));
    }

    public static Document generateDocFromXmlFile(File xml)
    {
        SAXReader saxReader = new SAXReader();
        Document document2;
        try
        {
            document2 = saxReader.read(xml);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error on generateDocFromXml", e);
        }
        return document2;
    }

    public static String generateXmlFromDoc(Document document)
    {
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("UTF-8");
        of.setTrimText(true);
        of.setIndent(true);
        of.setOmitEncoding(false);
        return generateXmlFromDocWithFormat(document, of);
    }

    public static String generateXmlFromDoc(Element document)
    {
        OutputFormat of = OutputFormat.createPrettyPrint();
        of.setEncoding("UTF-8");
        of.setTrimText(true);
        of.setIndent(true);
        of.setOmitEncoding(false);
        return generateXmlFromDocWithFormat(document, of);
    }

    public static String generateXmlFromDocWithFormat(Element document, OutputFormat of)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String xml;
        try
        {
            XMLWriter writer = new XMLWriter(out, of);
            writer.write(document);
            writer.close();
            xml = out.toString("UTF-8");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error on generateXmlFromDoc", e);
        }
        return xml;
    }

    public static String generateXmlFromDocWithFormat(Document document, OutputFormat of)
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String xml;
        try
        {
            XMLWriter writer = new XMLWriter(out, of);
            writer.write(document);
            writer.close();
            xml = out.toString("UTF-8");
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error on generateXmlFromDoc", e);
        }
        return xml;
    }

    public static Document validate(String xml, String schemaurl)
    {
        SAXReader reader = new SAXReader(true);
        try
        {
            reader.setFeature("http://apache.org/xml/features/validation/schema", true);
            reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
            if(schemaurl != null)
                reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", schemaurl);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Problem during doc validation ", e);
        }
        Document doc = null;
        try
        {
            doc = reader.read(stringToInputStream(xml));
        }
        catch(Throwable e)
        {
            doc = generateDocFromXml(xml);
        }
        return doc;
    }
}
