// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StringUtil.java

package com.dtmc.server.analytics.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class StringUtil
{

    public StringUtil()
    {
    }

    public static String cap(String name)
    {
        return (new StringBuilder()).append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
    }

    public static String decap(String name)
    {
        return (new StringBuilder()).append(name.substring(0, 1).toLowerCase()).append(name.substring(1)).toString();
    }

    public static String collapseSpaces(String argStr)
    {
        char last = argStr.charAt(0);
        StringBuffer argBuf = new StringBuffer();
        for(int cIdx = 0; cIdx < argStr.length(); cIdx++)
        {
            char ch = argStr.charAt(cIdx);
            if(ch != ' ' || last != ' ')
            {
                argBuf.append(ch);
                last = ch;
            }
        }

        return argBuf.toString();
    }

    public static boolean endsWith(StringBuffer buf, String pattern)
    {
        int len = pattern.length();
        String end = buf.substring(buf.length() - len);
        return pattern.equals(end);
        Exception exc;
        exc;
        return false;
    }

    public static int indexOfIgnoreCase(String pattern, int offset, String sourceString)
    {
        pattern = pattern.toUpperCase();
        sourceString = sourceString.toUpperCase();
        return sourceString.indexOf(pattern, offset);
    }

    public static int indexOfIgnoreCase(String pattern, String sourceString)
    {
        return indexOfIgnoreCase(pattern, 0, sourceString);
    }

    public static int findIndexOfPrecedingSpace(String piece, int startPoint)
    {
        int offset = 0;
        int index = startPoint;
        if(piece.indexOf("?") != -1)
            index = piece.indexOf("?", startPoint) - 1;
        if((new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") || (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase("="))
            for(; (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") || (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase("="); index--);
        for(; index > 0 && !(new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") && !(new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(","); index--);
        return index;
    }

    public static int findIndexOfSucceedingSpace(String piece, int startPoint)
    {
        int offset = 0;
        int index = startPoint;
        if(piece.indexOf("?") != -1)
            index = piece.indexOf("?", startPoint) - 1;
        if((new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") || (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase("="))
            for(; (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") || (new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase("="); index++);
        for(; index < piece.length() && !(new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(" ") && !(new StringBuilder()).append(piece.charAt(index)).append("").toString().equalsIgnoreCase(","); index++);
        return index;
    }

    public static String parseTableNameInSelect(String sql)
    {
        String upperSQL = sql.toUpperCase();
        if(upperSQL.indexOf(" WHERE") != -1)
        {
            sql = sql.substring(upperSQL.indexOf(" FROM") + 5, upperSQL.indexOf(" WHERE", upperSQL.indexOf(" FROM"))).trim();
            upperSQL = upperSQL.substring(upperSQL.indexOf(" FROM") + 5, upperSQL.indexOf(" WHERE", upperSQL.indexOf(" FROM"))).trim();
        } else
        {
            sql = sql.substring(upperSQL.indexOf(" FROM") + 4, upperSQL.length()).trim();
            upperSQL = upperSQL.substring(upperSQL.indexOf(" FROM") + 4, upperSQL.length()).trim();
        }
        if(upperSQL.indexOf(" GROUP BY") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" GROUP BY"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" BETWEEN") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" BETWEEN"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" ORDER BY") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" ORDER BY"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" IN ") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" IN "));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf("=") != -1)
            if(upperSQL.indexOf(" RIGHT") != -1 && upperSQL.indexOf(" JOIN") != -1)
            {
                upperSQL = upperSQL.substring(findIndexOfPrecedingSpace(upperSQL, upperSQL.indexOf("=")), upperSQL.indexOf("="));
                sql = sql.substring(findIndexOfPrecedingSpace(sql, sql.indexOf("=")), sql.indexOf("="));
            } else
            if(upperSQL.indexOf(" LEFT") != -1 && upperSQL.indexOf(" JOIN") != -1)
            {
                upperSQL = upperSQL.substring(upperSQL.indexOf("=") + 1, findIndexOfSucceedingSpace(upperSQL, upperSQL.indexOf("=")));
                sql = sql.substring(sql.indexOf("=") + 1, findIndexOfSucceedingSpace(sql, sql.indexOf("=")));
            }
        if(upperSQL.indexOf(".") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf("."));
            sql = sql.substring(0, upperSQL.length());
        }
        return sql.trim();
    }

    public static String parseTableInInsert(String insertStatement)
        throws IOException
    {
        String table = null;
        try
        {
            insertStatement = insertStatement.substring(11);
            StringTokenizer tokenizer = new StringTokenizer(insertStatement, "(");
            if(tokenizer.hasMoreTokens())
                table = tokenizer.nextToken();
        }
        catch(NoSuchElementException e)
        {
            throw new IOException((new StringBuilder()).append("error in parseTableInInsert: ").append(e.getMessage()).toString());
        }
        return table.trim();
    }

    public static String parseFieldName(String sql)
    {
        String upperSQL = sql.toUpperCase();
        if(upperSQL.indexOf(" WHERE") != -1)
        {
            sql = sql.substring(upperSQL.indexOf(" WHERE") + 6, upperSQL.length()).trim();
            upperSQL = upperSQL.substring(upperSQL.indexOf(" WHERE") + 6, upperSQL.length()).trim();
        }
        if(upperSQL.indexOf(" GROUP BY") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" GROUP BY"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" BETWEEN") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" BETWEEN"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" ORDER BY") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" ORDER BY"));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf(" IN ") != -1)
        {
            upperSQL = upperSQL.substring(0, upperSQL.indexOf(" IN "));
            sql = sql.substring(0, upperSQL.length());
        }
        if(upperSQL.indexOf("=") != -1)
            if(upperSQL.indexOf(" RIGHT") != -1 && upperSQL.indexOf(" JOIN") != -1)
            {
                upperSQL = upperSQL.substring(findIndexOfPrecedingSpace(upperSQL, upperSQL.indexOf("=")), upperSQL.indexOf("="));
                sql = sql.substring(findIndexOfPrecedingSpace(sql, sql.indexOf("=")), sql.indexOf("="));
            } else
            if(upperSQL.indexOf(" LEFT") != -1 && upperSQL.indexOf(" JOIN") != -1)
            {
                upperSQL = upperSQL.substring(upperSQL.indexOf("=") + 1, findIndexOfSucceedingSpace(upperSQL, upperSQL.indexOf("=")));
                sql = sql.substring(sql.indexOf("=") + 1, findIndexOfSucceedingSpace(sql, sql.indexOf("=")));
            } else
            {
                upperSQL = upperSQL.substring(findIndexOfPrecedingSpace(upperSQL, upperSQL.lastIndexOf("=")), upperSQL.lastIndexOf("="));
                sql = sql.substring(findIndexOfPrecedingSpace(sql, sql.lastIndexOf("=")), sql.lastIndexOf("="));
            }
        return sql.trim();
    }

    public static int findIndexOfEndOfFieldRef(String string, int startPoint)
    {
        int index = startPoint;
        for(int strlen = string.length(); index < strlen; index++)
        {
            char c = string.charAt(index);
            if(c == ' ' || c == ',')
                return index;
        }

        return index;
    }

    public static int findIndexOfPrecedingEquals(String piece, int startPoint)
    {
        int index = -1;
        int offset = 0;
        int j;
        for(j = startPoint; j > 0 && !(new StringBuilder()).append(piece.charAt(j)).append("").toString().equalsIgnoreCase("="); j--);
        index = j;
        return index;
    }

    public static final String findAndReplace(String text, String find, String replace)
    {
        if(text == null || find == null || replace == null)
            throw new NullPointerException("findAndReplace doesn't work on nulls.");
        int findLength = find.length();
        int replaceStart = text.indexOf(find);
        String toReturn = "";
        if(replaceStart != -1)
        {
            toReturn = (new StringBuilder()).append(toReturn).append(text.substring(0, replaceStart)).toString();
            int leng = toReturn.length();
            toReturn = (new StringBuilder()).append(toReturn).append(replace).toString();
            text = text.substring(leng + findLength);
            replaceStart = text.indexOf(find);
        }
        toReturn = (new StringBuilder()).append(toReturn).append(text).toString();
        return toReturn;
    }

    public static final String findAndReplaceAll(String text, String find, String replace)
    {
        if(text == null || find == null || replace == null)
            throw new NullPointerException("findAndReplaceAll doesn't work on nulls.");
        if(find.equals(""))
            return text;
        StringBuffer buf = new StringBuffer();
        int offset = 0;
        int index = 0;
        int flen = find.length();
        do
        {
            index = text.indexOf(find, offset);
            if(index == -1)
            {
                buf.append(text.substring(offset));
                break;
            }
            buf.append((new StringBuilder()).append(text.substring(offset, index)).append(replace).toString());
            offset = index + flen;
        } while(true);
        return buf.toString();
    }

    public static int countSubstrings(String targetString, String theSubstring)
    {
        int count = 0;
        int index = targetString.indexOf(theSubstring);
        int offset = theSubstring.length();
        for(; index != -1; index = targetString.indexOf(theSubstring, index + offset))
            count++;

        return count;
    }

    public static String findWithCharAndReplace(String text, String findChar, String replace)
    {
        if(text == null || replace == null || findChar == null)
            throw new NullPointerException("findWithCharAndReplace doesn't work on nulls.");
        int index = text.indexOf(findChar);
        if(index == -1)
        {
            return text;
        } else
        {
            int endIndex = findIndexOfSucceedingSpace(text, index);
            String word = text.substring(index, endIndex);
            return findAndReplace(text, word, replace);
        }
    }

    public static String findFirstWordStartingWithChar(String text, String character)
    {
        int index = text.indexOf(character);
        if(index == -1)
        {
            return "";
        } else
        {
            int endIndex = findIndexOfSucceedingSpace(text, index);
            return text.substring(index, endIndex);
        }
    }

    private static String convertFirstCharToUpper(String s)
    {
        char carattere[] = new char[1];
        s.getChars(0, 1, carattere, 0);
        String singleString = (new StringBuilder()).append("").append(carattere[0]).toString();
        singleString = singleString.toUpperCase();
        return singleString.concat(s.substring(1));
    }

    public static String parseEmail(String email, String separatore)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(email, "@");
        String uname = stringtokenizer.nextToken();
        stringtokenizer = new StringTokenizer(uname, ".");
        String name = stringtokenizer.nextToken();
        String lastname = stringtokenizer.nextToken();
        return (new StringBuilder()).append(convertFirstCharToUpper(name)).append(separatore).append(convertFirstCharToUpper(lastname)).toString();
    }

    public static long convertIP(String ip)
    {
        StringBuffer sb = new StringBuffer("");
        int intSplit = 0;
        StringTokenizer strTokIp = new StringTokenizer(ip, ".");
        for(int i = 0; strTokIp.hasMoreElements(); i++)
        {
            intSplit = Integer.parseInt(strTokIp.nextToken());
            if(intSplit < 10)
            {
                sb.append((new StringBuilder()).append("00").append(intSplit).toString());
                continue;
            }
            if(intSplit >= 10 && intSplit < 100)
            {
                sb.append((new StringBuilder()).append("0").append(intSplit).toString());
                continue;
            }
            if(intSplit >= 100)
                sb.append(intSplit);
        }

        return Long.parseLong(sb.toString());
        Exception ex;
        ex;
        ex.printStackTrace();
        return 0L;
    }

    public static String replaceString(String mainString, String oldString, String newString)
    {
        if(mainString == null)
            return null;
        if(oldString == null || oldString.length() == 0)
            return mainString;
        if(newString == null)
            newString = "";
        int i = mainString.lastIndexOf(oldString);
        if(i < 0)
            return mainString;
        StringBuffer mainSb = new StringBuffer(mainString);
        for(; i >= 0; i = mainString.lastIndexOf(oldString, i - 1))
            mainSb.replace(i, i + oldString.length(), newString);

        return mainSb.toString();
    }

    public static String join(List list, String delim)
    {
        if(list == null || list.size() < 1)
            return null;
        StringBuffer buf = new StringBuffer();
        Iterator i = list.iterator();
        do
        {
            if(!i.hasNext())
                break;
            buf.append((String)i.next());
            if(i.hasNext())
                buf.append(delim);
        } while(true);
        return buf.toString();
    }

    public static List split(String str, String delim)
    {
        List splitList = null;
        StringTokenizer st = null;
        if(str == null)
            return splitList;
        if(delim != null)
            st = new StringTokenizer(str, delim);
        else
            st = new StringTokenizer(str);
        if(st != null && st.hasMoreTokens())
        {
            splitList = new ArrayList();
            for(; st.hasMoreTokens(); splitList.add(st.nextToken()));
        }
        return splitList;
    }

    public static List quoteStrList(List list)
    {
        List tmpList = list;
        list = new ArrayList();
        String str;
        for(Iterator i = tmpList.iterator(); i.hasNext(); list.add(str))
        {
            str = (String)i.next();
            str = (new StringBuilder()).append("'").append(str).append("''").toString();
        }

        return list;
    }

    public static Map strToMap(String str, boolean trim)
    {
        if(str == null)
            return null;
        Map decodedMap = new HashMap();
        List elements = split(str, "|");
        Iterator i = elements.iterator();
        do
        {
            if(!i.hasNext())
                break;
            String s = (String)i.next();
            List e = split(s, "=");
            if(e.size() == 2)
            {
                String name = (String)e.get(0);
                String value = (String)e.get(1);
                if(trim)
                {
                    if(name != null)
                        name = name.trim();
                    if(value != null)
                        value = value.trim();
                }
                try
                {
                    decodedMap.put(URLDecoder.decode(name, "UTF-8"), URLDecoder.decode(value, "UTF-8"));
                }
                catch(UnsupportedEncodingException e1)
                {
                    e1.printStackTrace();
                }
            }
        } while(true);
        return decodedMap;
    }

    public static Map strToMap(String str)
    {
        return strToMap(str, false);
    }

    public static String mapToStr(Map map)
    {
        if(map == null)
            return null;
        StringBuffer buf = new StringBuffer();
        Set keySet = map.keySet();
        Iterator i = keySet.iterator();
        boolean first = true;
        do
        {
            if(!i.hasNext())
                break;
            Object key = i.next();
            Object value = map.get(key);
            if((key instanceof String) && (value instanceof String))
            {
                String encodedName = null;
                try
                {
                    encodedName = URLEncoder.encode((String)key, "UTF-8");
                }
                catch(UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
                String encodedValue = null;
                try
                {
                    encodedValue = URLEncoder.encode((String)value, "UTF-8");
                }
                catch(UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
                if(first)
                    first = false;
                else
                    buf.append("|");
                buf.append(encodedName);
                buf.append("=");
                buf.append(encodedValue);
            }
        } while(true);
        return buf.toString();
    }

    public static Map createMap(List keys, List values)
    {
        if(keys == null || values == null || keys.size() != values.size())
            throw new IllegalArgumentException("Keys and Values cannot be null and must be the same size");
        Map newMap = new HashMap();
        for(int i = 0; i < keys.size(); i++)
            newMap.put(keys.get(i), values.get(i));

        return newMap;
    }

    public static String cleanUpPathPrefix(String prefix)
    {
        if(prefix == null || prefix.length() == 0)
            return "";
        StringBuffer cppBuff = new StringBuffer(prefix.replace('\\', '/'));
        if(cppBuff.charAt(0) != '/')
            cppBuff.insert(0, '/');
        if(cppBuff.charAt(cppBuff.length() - 1) == '/')
            cppBuff.deleteCharAt(cppBuff.length() - 1);
        return cppBuff.toString();
    }

    public static String removeSpaces(String str)
    {
        StringBuffer newString = new StringBuffer();
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) != ' ')
                newString.append(str.charAt(i));

        return newString.toString();
    }

    public static String toHexString(byte bytes[])
    {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        for(int i = 0; i < bytes.length; i++)
        {
            buf.append(hexChar[(bytes[i] & 0xf0) >>> 4]);
            buf.append(hexChar[bytes[i] & 0xf]);
        }

        return buf.toString();
    }

    public static String cleanHexString(String str)
    {
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) != ' ' && str.charAt(i) != ':')
                buf.append(str.charAt(i));

        return buf.toString();
    }

    public static byte[] fromHexString(String str)
    {
        str = cleanHexString(str);
        int stringLength = str.length();
        if((stringLength & 1) != 0)
            throw new IllegalArgumentException("fromHexString\uFFFDrequires\uFFFDan\uFFFDeven\uFFFDnumber\uFFFDof\uFFFDhex\uFFFDcharacters");
        byte b[] = new byte[stringLength / 2];
        int i = 0;
        for(int j = 0; i < stringLength; j++)
        {
            int high = convertChar(str.charAt(i));
            int low = convertChar(str.charAt(i + 1));
            b[j] = (byte)(high << 4 | low);
            i += 2;
        }

        return b;
    }

    private static int convertChar(char c)
    {
        if('0' <= c && c <= '9')
            return c - 48;
        if('a' <= c && c <= 'f')
            return (c - 97) + 10;
        if('A' <= c && c <= 'F')
            return (c - 65) + 10;
        else
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid\uFFFDhex\uFFFDcharacter:\uFFFD").append(c).toString());
    }

    public static String capitalize(String s)
    {
        if(s == null || s.length() == 0)
            return s;
        else
            return (new StringBuilder()).append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).toString();
    }

    public static String convertToCapitalized(String str)
    {
        StringBuffer sb = new StringBuffer();
        List tokens = split(str, " ");
        for(int i = 0; i < tokens.size(); i++)
        {
            String s = (String)tokens.get(i);
            sb.append((new StringBuilder()).append(capitalize(s)).append(" ").toString());
        }

        return sb.toString().trim();
    }

    public static String getFormattedDate(Date selectedDate)
    {
        return (new StringBuilder()).append(getDobleDig(selectedDate.getMonth() + 1)).append("/").append(getDobleDig(selectedDate.getDate())).append("/").append(selectedDate.getYear() + 1900).append(" ").append(getDobleDig(selectedDate.getHours())).append(":").append(getDobleDig(selectedDate.getMinutes())).toString();
    }

    public static String getValueAsString(int value, int positions)
    {
        String ret = String.valueOf(value);
        if(ret.length() < positions)
        {
            int zerosAdd = positions - ret.length();
            for(int i = 0; i < zerosAdd; i++)
                ret = (new StringBuilder()).append("0").append(ret).toString();

        }
        return ret;
    }

    private static String getDobleDig(int value)
    {
        return getValueAsString(value, 2);
    }

    public static boolean isStringEmpty(String text)
    {
        return text == null || text.trim().equalsIgnoreCase("");
    }

    public static int sizeToPixel(String size)
    {
        if(size.endsWith("px"))
            return Integer.parseInt(size.substring(0, size.length() - 2));
        else
            return -1;
    }

    public static String pixelToSize(int pixel)
    {
        return (new StringBuilder()).append(pixel).append("px").toString();
    }

    public static int sizeToPercent(String size)
    {
        if(size.endsWith("%"))
            return Integer.parseInt(size.substring(0, size.length() - 1));
        else
            return -1;
    }

    public static String imgSrc(String path)
    {
        return (new StringBuilder()).append("<img src='").append(path).append("'>").toString();
    }

    public static String nullToEmpty(String text)
    {
        return text == null ? "" : text;
    }

    public static String htmlToText(String html)
    {
        if(html == null)
            return "";
        StringBuffer sbResult = new StringBuffer();
        StringBuffer sbTag = new StringBuffer();
        boolean inTag = false;
        for(int i = 0; i < html.length(); i++)
        {
            char ch = html.charAt(i);
            if(html.startsWith("&nbsp;", i))
            {
                sbResult.append(" ");
                i += 5;
                continue;
            }
            if(html.startsWith("&amp;", i))
            {
                sbResult.append("&");
                i += 4;
                continue;
            }
            if(html.startsWith("&gt;", i))
            {
                sbResult.append(">");
                i += 3;
                continue;
            }
            if(html.startsWith("&lt;", i))
            {
                sbResult.append("<");
                i += 3;
                continue;
            }
            if(html.startsWith("&#93;", i))
            {
                sbResult.append("]");
                i += 4;
                continue;
            }
            if(html.startsWith("&#91;"))
            {
                sbResult.append("[");
                i += 4;
                continue;
            }
            if(inTag)
            {
                if(ch == '>')
                {
                    inTag = false;
                    String tag = sbTag.toString().trim().toUpperCase();
                    if(tag.startsWith("BR"))
                        sbResult.append("\n");
                } else
                {
                    sbTag.append(ch);
                }
                continue;
            }
            if(ch == '<')
            {
                inTag = true;
                sbTag = new StringBuffer();
            } else
            {
                sbResult.append(ch);
            }
        }

        return sbResult.toString();
    }

    public static String textToHtml(String text)
    {
        if(text == null)
            return "";
        StringBuffer sbResult = new StringBuffer();
        for(int i = 0; i < text.length(); i++)
        {
            char ch = text.charAt(i);
            if(ch == '&')
            {
                sbResult.append("&amp;");
                continue;
            }
            if(ch == '>')
            {
                sbResult.append("&gt;");
                continue;
            }
            if(ch == '<')
            {
                sbResult.append("&lt;");
                continue;
            }
            if(ch == ' ')
            {
                sbResult.append("&nbsp;");
                continue;
            }
            if(ch == ']')
            {
                sbResult.append("&#93;");
                continue;
            }
            if(ch == '[')
            {
                sbResult.append("&#91;");
                continue;
            }
            if(ch == '\n')
                sbResult.append("<BR>");
            else
                sbResult.append(ch);
        }

        return sbResult.toString();
    }

    public static boolean isStringsEquals(String s1, String s2)
    {
        return s1 != null ? s1.equalsIgnoreCase(s2) : s1 == s2;
    }

    public static boolean isStringsEqualsIgnoreNulls(String s1, String s2)
    {
        boolean equals;
        if(isStringEmpty(s1))
            equals = isStringEmpty(s2);
        else
            equals = s1.trim().equalsIgnoreCase(nullToEmpty(s2).trim());
        return equals;
    }

    public static String removeImagesSrc(String text)
    {
        StringBuffer res = new StringBuffer();
        int i;
        for(i = 0; i < text.length() - 4; i++)
            if(Character.toUpperCase(text.charAt(i)) == '<' && Character.toUpperCase(text.charAt(i + 1)) == 'I' && Character.toUpperCase(text.charAt(i + 2)) == 'M' && Character.toUpperCase(text.charAt(i + 3)) == 'G')
            {
                res.append("<img ");
                int start = i + 5;
                int end = text.indexOf('>', i + 3);
                res.append(updateTag(text.substring(start, end + 1)));
                i = end;
            } else
            {
                res.append(text.charAt(i));
            }

        if(i + 4 == text.length())
            res.append(text.substring(text.length() - 4));
        return res.toString();
    }

    public static String updateTag(String text)
    {
        StringBuffer res = new StringBuffer();
        int index = text.indexOf("<--");
        if(index == -1)
        {
            return text;
        } else
        {
            res.append(text.substring(index + 3));
            return res.toString();
        }
    }

    public static final String module = com/dtmc/server/analytics/util/StringUtil.getName();
    private static char hexChar[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };

}
