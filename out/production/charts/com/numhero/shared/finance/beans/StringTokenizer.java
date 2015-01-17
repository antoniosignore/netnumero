// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringTokenizer.java

package com.numhero.shared.finance.beans;

import java.util.ArrayList;

public class StringTokenizer
{

    public StringTokenizer(String text, char delimiter)
    {
        tokens = new ArrayList();
        char chars[] = text.toCharArray();
        int sindex = 0;
        int i;
        for(i = 0; i < chars.length; i++)
            if(chars[i] == delimiter)
            {
                tokens.add(text.substring(sindex, i));
                sindex = i + 1;
            }

        if(sindex < i)
            tokens.add(text.substring(sindex));
    }

    public int countTokens()
    {
        return tokens.size();
    }

    public String tokenAt(int index)
    {
        return (String)tokens.get(index);
    }

    ArrayList tokens;
}
