// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Ordinable.java

package com.dtmc.server.analytics.util;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public interface Ordinable
{

    public abstract Document toXML()
        throws ParserConfigurationException, SAXException, IOException;

    public abstract int compareTo(Object obj);
}
