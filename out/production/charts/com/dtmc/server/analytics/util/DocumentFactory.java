// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DocumentFactory.java

package com.dtmc.server.analytics.util;

import java.io.CharArrayReader;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.dtmc.server.analytics.util:
//            ImplementsToElement

public class DocumentFactory
{

    public DocumentFactory()
    {
    }

    public static Document getDocument()
        throws ParserConfigurationException
    {
        DocumentBuilder db = getDocumentBuilder();
        Document doc = db.newDocument();
        return doc;
    }

    public static Document getDocument(String xml)
        throws IOException, SAXException, ParserConfigurationException
    {
        DocumentBuilder builder = getDocumentBuilder();
        InputSource source = getInputSource(xml);
        return builder.parse(source);
    }

    public static DocumentBuilder getDocumentBuilder()
        throws ParserConfigurationException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder();
    }

    public static InputSource getInputSource(String xml)
    {
        CharArrayReader reader = new CharArrayReader(xml.toCharArray());
        return new InputSource(reader);
    }

    public static final Document getDocument(ImplementsToElement obj)
        throws ParserConfigurationException
    {
        Document doc = getDocument();
        org.w3c.dom.Element node = obj.toElement(doc);
        doc.appendChild(node);
        return doc;
    }
}
