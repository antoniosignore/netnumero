// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplementsToElement.java

package com.dtmc.server.analytics.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ImplementsToElement
{

    public abstract Element toElement(Document document);
}
