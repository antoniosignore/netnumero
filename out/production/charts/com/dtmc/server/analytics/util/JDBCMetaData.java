// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JDBCMetaData.java

package com.dtmc.server.analytics.util;

import java.io.PrintStream;
import java.sql.*;

public class JDBCMetaData
{

    public JDBCMetaData()
    {
    }

    public static void main(String args[])
    {
        try
        {
            String table = args[0];
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433/prova", "sa", "nicholas");
            for(SQLWarning warn = conn.getWarnings(); warn != null; warn = warn.getNextWarning())
            {
                System.out.println("SQL Warning:");
                System.out.println((new StringBuilder()).append("State  : ").append(warn.getSQLState()).toString());
                System.out.println((new StringBuilder()).append("Message: ").append(warn.getMessage()).toString());
                System.out.println((new StringBuilder()).append("Error  : ").append(warn.getErrorCode()).toString());
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery((new StringBuilder()).append("SELECT * FROM ").append(table).toString());
            ResultSetMetaData md = rs.getMetaData();
            System.out.print("\n<?xml version=\"1.0\"?>\n");
            System.out.print("<!DOCTYPE hibernate-mapping PUBLIC\n");
            System.out.print("    \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\" \n");
            System.out.print("    \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\"> \n");
            System.out.print("<hibernate-mapping>\n");
            System.out.print((new StringBuilder()).append("<class name=\"xxx\" table=\"").append(table).append("\">\n").toString());
            for(int i = 1; i <= md.getColumnCount(); i++)
                System.out.print((new StringBuilder()).append("<property name=\"").append(md.getColumnLabel(i).toLowerCase()).append("\"/>\n").toString());

            System.out.print("</class>\n</hibernate-mapping>\n\n");
            for(int i = 1; i <= md.getColumnCount(); i++)
            {
                System.out.print((new StringBuilder()).append("<field name=\"").append(md.getColumnLabel(i).toLowerCase()).append("\" type=\"").toString());
                String sqltype = null;
                String jtype = null;
                switch(md.getColumnType(i))
                {
                case 5: // '\005'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case -6: 
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 12: // '\f'
                    sqltype = "varchar";
                    jtype = "string";
                    break;

                case 1: // '\001'
                    sqltype = "char";
                    jtype = "string";
                    break;

                case 2: // '\002'
                    sqltype = "decimal";
                    jtype = "big-decimal";
                    break;

                case 3: // '\003'
                    sqltype = "decimal";
                    jtype = "big-decimal";
                    break;

                case 8: // '\b'
                    sqltype = "decimal";
                    jtype = "double";
                    break;

                case 4: // '\004'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 91: // '['
                    sqltype = "date";
                    jtype = "date";
                    break;

                case 93: // ']'
                    sqltype = "timestamp";
                    jtype = "date";
                    break;

                default:
                    sqltype = (new StringBuilder()).append("").append(md.getColumnType(i)).toString();
                    jtype = "WTF?";
                    break;
                }
                System.out.println((new StringBuilder()).append(jtype).append("\">").toString());
                System.out.println((new StringBuilder()).append("<sql name=\"").append(md.getColumnLabel(i)).append("\" ").append("type=\"").append(sqltype).append("\"").append(" dirty=\"check\"/>").toString());
                System.out.println("</field>");
            }

            for(int i = 1; i <= md.getColumnCount(); i++)
            {
                String sqltype = null;
                String jtype = null;
                switch(md.getColumnType(i))
                {
                case 5: // '\005'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case -6: 
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 12: // '\f'
                    sqltype = "varchar";
                    jtype = "string";
                    break;

                case 1: // '\001'
                    sqltype = "char";
                    jtype = "string";
                    break;

                case 2: // '\002'
                    sqltype = "numeric";
                    jtype = "BigDecimal";
                    break;

                case 8: // '\b'
                    sqltype = "decimal";
                    jtype = "double";
                    break;

                case 4: // '\004'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 91: // '['
                    sqltype = "date";
                    jtype = "Date";
                    break;

                case 93: // ']'
                    sqltype = "timestamp";
                    jtype = "Date";
                    break;

                case 3: // '\003'
                    sqltype = "decimal";
                    jtype = "BigDecimal";
                    break;

                default:
                    sqltype = (new StringBuilder()).append("").append(md.getColumnType(i)).toString();
                    jtype = "wtf";
                    break;
                }
                System.out.println((new StringBuilder()).append(jtype.substring(0, 1).toUpperCase()).append(jtype.substring(1)).append(" ").append(md.getColumnLabel(i).toLowerCase()).append(" = null;").toString());
            }

            System.out.println("public void doView(HttpServletRequest request, HttpServletResponse response, Writer out) throws Throwable");
            System.out.println("{");
            System.out.println("HTMLTable table = new HTMLTable();");
            for(int i = 1; i <= md.getColumnCount(); i++)
            {
                String jtype = null;
                String sqltype = null;
                switch(md.getColumnType(i))
                {
                case 5: // '\005'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case -6: 
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 12: // '\f'
                    sqltype = "varchar";
                    jtype = "string";
                    break;

                case 1: // '\001'
                    sqltype = "char";
                    jtype = "string";
                    break;

                case 2: // '\002'
                    sqltype = "numeric";
                    jtype = "integer";
                    break;

                case 4: // '\004'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                case 91: // '['
                    sqltype = "date";
                    jtype = "java.util.Date";
                    break;

                case 93: // ']'
                    sqltype = "timestamp";
                    jtype = "java.util.Date";
                    break;

                case 3: // '\003'
                    sqltype = "integer";
                    jtype = "integer";
                    break;

                default:
                    sqltype = (new StringBuilder()).append("").append(md.getColumnType(i)).toString();
                    jtype = "wtf";
                    break;
                }
                System.out.println((new StringBuilder()).append("if (").append(md.getColumnLabel(i).toLowerCase()).append(" !=null) table.addLine(FormatUtils.getString(request, \"").append(md.getColumnLabel(i).toLowerCase()).append("\"),").append(md.getColumnLabel(i).toLowerCase()).append(");").toString());
            }

            System.out.println("table.doView(request, response, out);");
            System.out.println("}");
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
            System.out.println("SQL Exception:");
            for(; se != null; se = se.getNextException())
            {
                System.out.println((new StringBuilder()).append("State  : ").append(se.getSQLState()).toString());
                System.out.println((new StringBuilder()).append("Message: ").append(se.getMessage()).toString());
                System.out.println((new StringBuilder()).append("Error  : ").append(se.getErrorCode()).toString());
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
