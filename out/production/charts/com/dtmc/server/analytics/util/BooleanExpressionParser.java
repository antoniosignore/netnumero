// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BooleanExpressionParser.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.util.ArrayList;

public class BooleanExpressionParser
{
    private class Tree
    {

        private boolean isLeaf()
        {
            boolean isLeaf = false;
            if(left == null && right == null)
                isLeaf = true;
            return isLeaf;
        }

        private boolean isNotWithLeaf()
        {
            boolean isNotWithLeaf = false;
            if(value.equals("NOT") && left.isLeaf())
                isNotWithLeaf = true;
            return isNotWithLeaf;
        }

        public boolean evaluate()
        {
            if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
                return Boolean.parseBoolean(value);
            if(value.equalsIgnoreCase("NOT"))
                return !left.evaluate();
            if(value.equalsIgnoreCase("AND"))
                return left.evaluate() && right.evaluate();
            if(value.equalsIgnoreCase("OR"))
                return left.evaluate() || right.evaluate();
            else
                throw new RuntimeException("unknown operator");
        }

        private String value;
        private Tree left;
        private Tree right;
        final BooleanExpressionParser this$0;

        private Tree(String value, Tree left, Tree right)
        {
            this$0 = BooleanExpressionParser.this;
            super();
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }


    public BooleanExpressionParser(String booleanExpression)
        throws RuntimeException
    {
        debug = false;
        if(booleanExpression == null || booleanExpression.trim().equals(""))
        {
            this.booleanExpression = null;
            tree = null;
        } else
        {
            position = 0;
            this.booleanExpression = booleanExpression.trim();
            tokens = new ArrayList();
            setTokens();
            tree = parseExpression();
        }
    }

    public boolean evaluate()
    {
        return tree.evaluate();
    }

    private void setTokens()
        throws RuntimeException
    {
        boolean lastTokenIsRightEnd = false;
        for(int i = 0; i < booleanExpression.length(); i++)
        {
            char ch = booleanExpression.charAt(i);
            if(Character.isSpaceChar(ch))
                continue;
            if(ch == '(')
            {
                if(lastTokenIsRightEnd)
                    tokens.add("AND");
                tokens.add("(");
                lastTokenIsRightEnd = false;
                continue;
            }
            if(ch == ')')
            {
                tokens.add((new StringBuilder()).append("").append(ch).toString());
                lastTokenIsRightEnd = true;
                continue;
            }
            StringBuffer token;
            if(ch == '"')
            {
                token = new StringBuffer();
                token.append(ch);
                for(i++; i < booleanExpression.length() && booleanExpression.charAt(i) != '"'; i++)
                    token.append(booleanExpression.charAt(i));

                if(booleanExpression.charAt(i) != '"')
                    throw new RuntimeException("unterminated quotes");
                if(token.toString().trim().equals(""))
                    throw new RuntimeException("illegal blank quoted string");
                token.append('"');
                if(lastTokenIsRightEnd)
                    tokens.add("AND");
                tokens.add(token.toString());
                lastTokenIsRightEnd = true;
                continue;
            }
            token = new StringBuffer();
            for(; i < booleanExpression.length() && !Character.isSpaceChar(booleanExpression.charAt(i)) && booleanExpression.charAt(i) != '"' && booleanExpression.charAt(i) != '(' && booleanExpression.charAt(i) != ')'; i++)
                token.append(booleanExpression.charAt(i));

            if(i != booleanExpression.length())
                i--;
            if(token.toString().equalsIgnoreCase("AND") || token.toString().equalsIgnoreCase("OR") || token.toString().equalsIgnoreCase("NOT"))
            {
                if(lastTokenIsRightEnd && token.toString().equalsIgnoreCase("NOT"))
                    tokens.add("AND");
                tokens.add(token.toString().toUpperCase());
                lastTokenIsRightEnd = false;
                continue;
            }
            if(lastTokenIsRightEnd)
                tokens.add("AND");
            tokens.add(token.toString());
            lastTokenIsRightEnd = true;
        }

    }

    private String getToken()
    {
        String token;
        if(position == tokens.size())
        {
            token = null;
        } else
        {
            token = (String)tokens.get(position);
            position++;
        }
        return token;
    }

    private String currentToken()
    {
        String token;
        if(position == tokens.size())
            token = null;
        else
            token = (String)tokens.get(position);
        return token;
    }

    private Tree parseExpression()
        throws RuntimeException
    {
        Tree result;
        for(result = parseSubexpression(); currentToken() != null && currentToken().equals("OR"); result = new Tree("OR", result, parseSubexpression()))
            getToken();

        return result;
    }

    private Tree parseSubexpression()
        throws RuntimeException
    {
        Tree result;
        for(result = parseFactor(); currentToken() != null && currentToken().equals("AND"); result = new Tree("AND", result, parseFactor()))
            getToken();

        return result;
    }

    private Tree parseFactor()
        throws RuntimeException
    {
        Tree result;
        if(currentToken().equals("NOT"))
        {
            getToken();
            result = new Tree("NOT", parseTerm(), null);
        } else
        {
            result = parseTerm();
        }
        return result;
    }

    private Tree parseTerm()
        throws RuntimeException
    {
        if(currentToken() == null || currentToken().equals("AND") || currentToken().equals("OR") || currentToken().equals("NOT"))
            throw new RuntimeException("malformed query");
        Tree result;
        if(currentToken().equals("("))
        {
            getToken();
            result = parseExpression();
            String token = getToken();
            if(!token.equals(")"))
                throw new RuntimeException("mismatched parentheses");
        } else
        {
            result = new Tree(getToken(), null, null);
        }
        return result;
    }

    public static void main(String args[])
    {
        String testExpressions[] = {
            "true", "NOT true", "NOT false", "NOT(true)", "NOT(false)", "true OR false", "false OR true", "false AND true", "true AND true", "true AND false", 
            "NOT (true AND true)"
        };
        for(int i = 0; i < testExpressions.length; i++)
        {
            BooleanExpressionParser parser = new BooleanExpressionParser(testExpressions[i]);
            boolean b = parser.evaluate();
            System.out.println((new StringBuilder()).append("expression [").append(testExpressions[i]).append("] : ").append(b).toString());
        }

    }

    private int position;
    private String booleanExpression;
    private ArrayList tokens;
    private Tree tree;
    private boolean debug;
}
