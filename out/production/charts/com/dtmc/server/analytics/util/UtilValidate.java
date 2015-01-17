// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UtilValidate.java

package com.dtmc.server.analytics.util;

import java.util.*;

// Referenced classes of package com.dtmc.server.analytics.util:
//            UtilDateTime

public class UtilValidate
{

    public UtilValidate()
    {
    }

    public static boolean areEqual(Object obj, Object obj2)
    {
        if(obj == null)
            return obj2 == null;
        else
            return obj.equals(obj2);
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isEmpty(Collection c)
    {
        return c == null || c.size() == 0;
    }

    public static boolean isNotEmpty(String s)
    {
        return s != null && s.length() > 0;
    }

    public static boolean isNotEmpty(Collection c)
    {
        return c != null && c.size() > 0;
    }

    public static boolean isWhitespace(String s)
    {
        if(isEmpty(s))
            return true;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(" \t\n\r".indexOf(c) == -1)
                return false;
        }

        return true;
    }

    public static String stripCharsInBag(String s, String bag)
    {
        String returnString = "";
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(bag.indexOf(c) == -1)
                returnString = (new StringBuilder()).append(returnString).append(c).toString();
        }

        return returnString;
    }

    public static String stripCharsNotInBag(String s, String bag)
    {
        String returnString = "";
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(bag.indexOf(c) != -1)
                returnString = (new StringBuilder()).append(returnString).append(c).toString();
        }

        return returnString;
    }

    public static String stripWhitespace(String s)
    {
        return stripCharsInBag(s, " \t\n\r");
    }

    public static boolean charInString(char c, String s)
    {
        return s.indexOf(c) != -1;
    }

    public static String stripInitialWhitespace(String s)
    {
        int i;
        for(i = 0; i < s.length() && charInString(s.charAt(i), " \t\n\r"); i++);
        return s.substring(i);
    }

    public static boolean isLetter(char c)
    {
        return Character.isLetter(c);
    }

    public static boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    public static boolean isLetterOrDigit(char c)
    {
        return Character.isLetterOrDigit(c);
    }

    public static boolean isInteger(String s)
    {
        if(isEmpty(s))
            return true;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(!isDigit(c))
                return false;
        }

        return true;
    }

    public static boolean isSignedInteger(String s)
    {
        if(isEmpty(s))
            return true;
        int temp = Integer.parseInt(s);
        return true;
        Exception e;
        e;
        return false;
    }

    public static boolean isSignedLong(String s)
    {
        if(isEmpty(s))
            return true;
        long temp = Long.parseLong(s);
        return true;
        Exception e;
        e;
        return false;
    }

    public static boolean isPositiveInteger(String s)
    {
        if(isEmpty(s))
            return true;
        long temp = Long.parseLong(s);
        if(temp > 0L)
            return true;
        return false;
        Exception e;
        e;
        return false;
    }

    public static boolean isNonnegativeInteger(String s)
    {
        if(isEmpty(s))
            return true;
        int temp = Integer.parseInt(s);
        if(temp >= 0)
            return true;
        return false;
        Exception e;
        e;
        return false;
    }

    public static boolean isNegativeInteger(String s)
    {
        if(isEmpty(s))
            return true;
        int temp = Integer.parseInt(s);
        if(temp < 0)
            return true;
        return false;
        Exception e;
        e;
        return false;
    }

    public static boolean isNonpositiveInteger(String s)
    {
        if(isEmpty(s))
            return true;
        int temp = Integer.parseInt(s);
        if(temp <= 0)
            return true;
        return false;
        Exception e;
        e;
        return false;
    }

    public static boolean isFloat(String s)
    {
        if(isEmpty(s))
            return true;
        boolean seenDecimalPoint = false;
        if(s.startsWith("."))
            return false;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ".".charAt(0))
            {
                if(!seenDecimalPoint)
                    seenDecimalPoint = true;
                else
                    return false;
                continue;
            }
            if(!isDigit(c))
                return false;
        }

        return true;
    }

    public static boolean isSignedFloat(String s)
    {
        if(isEmpty(s))
            return true;
        float temp = Float.parseFloat(s);
        if(temp <= 0.0F)
            return true;
        return false;
        Exception e;
        e;
        return false;
    }

    public static boolean isSignedDouble(String s)
    {
        if(isEmpty(s))
            return true;
        double temp = Double.parseDouble(s);
        return true;
        Exception e;
        e;
        return false;
    }

    public static boolean isAlphabetic(String s)
    {
        if(isEmpty(s))
            return true;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(!isLetter(c))
                return false;
        }

        return true;
    }

    public static boolean isAlphanumeric(String s)
    {
        if(isEmpty(s))
            return true;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(!isLetterOrDigit(c))
                return false;
        }

        return true;
    }

    public static boolean isSSN(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedSSN = stripCharsInBag(s, "- ");
            return isInteger(normalizedSSN) && normalizedSSN.length() == 9;
        }
    }

    public static boolean isUSPhoneNumber(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedPhone = stripCharsInBag(s, "()- ");
            return isInteger(normalizedPhone) && normalizedPhone.length() == 10;
        }
    }

    public static boolean isUSPhoneAreaCode(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedPhone = stripCharsInBag(s, "()- ");
            return isInteger(normalizedPhone) && normalizedPhone.length() == 3;
        }
    }

    public static boolean isUSPhoneMainNumber(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedPhone = stripCharsInBag(s, "()- ");
            return isInteger(normalizedPhone) && normalizedPhone.length() == 7;
        }
    }

    public static boolean isInternationalPhoneNumber(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedPhone = stripCharsInBag(s, "()- ");
            return isPositiveInteger(normalizedPhone);
        }
    }

    public static boolean isZipCode(String s)
    {
        if(isEmpty(s))
        {
            return true;
        } else
        {
            String normalizedZip = stripCharsInBag(s, "-");
            return isInteger(normalizedZip) && (normalizedZip.length() == 5 || normalizedZip.length() == 9);
        }
    }

    public static boolean isContiguousZipCode(String s)
    {
        boolean retval = false;
        if(isZipCode(s))
            if(isEmpty(s))
            {
                retval = true;
            } else
            {
                String normalizedZip = s.substring(0, 5);
                int iZip = Integer.parseInt(normalizedZip);
                if(iZip >= 0x179bd && iZip <= 0x17a82 || iZip >= 0x184ad && iZip <= 0x1866e)
                    retval = false;
                else
                    retval = true;
            }
        return retval;
    }

    public static boolean isStateCode(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return "AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|AE|AA|AE|AE|AP".indexOf(s) != -1 && s.indexOf("|") == -1;
    }

    public static boolean isContiguousStateCode(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return "AL|AZ|AR|CA|CO|CT|DE|DC|FL|GA|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY".indexOf(s) != -1 && s.indexOf("|") == -1;
    }

    public static boolean isEmail(String s)
    {
        if(isEmpty(s))
            return true;
        if(isWhitespace(s))
            return false;
        int i = 1;
        int sLength;
        for(sLength = s.length(); i < sLength && s.charAt(i) != '@'; i++);
        return i < sLength - 1 && s.charAt(i) == '@';
    }

    public static boolean isUrl(String s)
    {
        if(isEmpty(s))
            return true;
        return s.indexOf("://") != -1;
    }

    public static boolean isYear(String s)
    {
        if(isEmpty(s))
            return true;
        if(!isNonnegativeInteger(s))
            return false;
        else
            return s.length() == 2 || s.length() == 4;
    }

    public static boolean isIntegerInRange(String s, int a, int b)
    {
        if(isEmpty(s))
            return true;
        if(!isSignedInteger(s))
        {
            return false;
        } else
        {
            int num = Integer.parseInt(s);
            return num >= a && num <= b;
        }
    }

    public static boolean isMonth(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return isIntegerInRange(s, 1, 12);
    }

    public static boolean isDay(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return isIntegerInRange(s, 1, 31);
    }

    public static int daysInFebruary(int year)
    {
        return year % 4 != 0 || year % 100 == 0 && year % 400 != 0 ? 28 : 29;
    }

    public static boolean isHour(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return isIntegerInRange(s, 0, 23);
    }

    public static boolean isMinute(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return isIntegerInRange(s, 0, 59);
    }

    public static boolean isSecond(String s)
    {
        if(isEmpty(s))
            return true;
        else
            return isIntegerInRange(s, 0, 59);
    }

    public static boolean isDate(String year, String month, String day)
    {
        if(!isYear(year) || !isMonth(month) || !isDay(day))
            return false;
        int intYear = Integer.parseInt(year);
        int intMonth = Integer.parseInt(month);
        int intDay = Integer.parseInt(day);
        if(intDay > daysInMonth[intMonth - 1])
            return false;
        return intMonth != 2 || intDay <= daysInFebruary(intYear);
    }

    public static boolean isDate(String date)
    {
        if(isEmpty(date))
            return true;
        int dateSlash1 = date.indexOf("/");
        int dateSlash2 = date.lastIndexOf("/");
        if(dateSlash1 <= 0 || dateSlash1 == dateSlash2)
        {
            return false;
        } else
        {
            String month = date.substring(0, dateSlash1);
            String day = date.substring(dateSlash1 + 1, dateSlash2);
            String year = date.substring(dateSlash2 + 1);
            return isDate(year, month, day);
        }
    }

    public static boolean isDateAfterToday(String date)
    {
        if(isEmpty(date))
            return true;
        int dateSlash1 = date.indexOf("/");
        int dateSlash2 = date.lastIndexOf("/");
        if(dateSlash1 <= 0)
            return false;
        Date passed = null;
        if(dateSlash1 == dateSlash2)
        {
            String month = date.substring(0, dateSlash1);
            String day = "28";
            String year = date.substring(dateSlash1 + 1);
            if(!isDate(year, month, day))
                return false;
            try
            {
                int monthInt = Integer.parseInt(month);
                int yearInt = Integer.parseInt(year);
                Calendar calendar = Calendar.getInstance();
                calendar.set(yearInt, monthInt - 1, 0, 0, 0, 0);
                calendar.add(2, 1);
                passed = new Date(calendar.getTime().getTime());
            }
            catch(Exception e)
            {
                passed = null;
            }
        } else
        {
            String month = date.substring(0, dateSlash1);
            String day = date.substring(dateSlash1 + 1, dateSlash2);
            String year = date.substring(dateSlash2 + 1);
            if(!isDate(year, month, day))
                return false;
            passed = UtilDateTime.toDate(month, day, year, "0", "0", "0");
        }
        Date now = UtilDateTime.nowDate();
        if(passed != null)
            return passed.after(now);
        else
            return false;
    }

    public static boolean isTime(String hour, String minute, String second)
    {
        return isHour(hour) && isMinute(minute) && isSecond(second);
    }

    public static boolean isTime(String time)
    {
        if(isEmpty(time))
            return true;
        int timeColon1 = time.indexOf(":");
        int timeColon2 = time.lastIndexOf(":");
        if(timeColon1 <= 0)
            return false;
        String hour = time.substring(0, timeColon1);
        String minute;
        String second;
        if(timeColon1 == timeColon2)
        {
            minute = time.substring(timeColon1 + 1);
            second = "0";
        } else
        {
            minute = time.substring(timeColon1 + 1, timeColon2);
            second = time.substring(timeColon2 + 1);
        }
        return isTime(hour, minute, second);
    }

    public static boolean isValueLinkCard(String stPassed)
    {
        if(isEmpty(stPassed))
            return true;
        String st = stripCharsInBag(stPassed, " -");
        return st.length() == 16 && (st.startsWith("7") || st.startsWith("6"));
    }

    public static boolean isGiftCard(String stPassed)
    {
        return isValueLinkCard(stPassed);
    }

    public static int getLuhnSum(String stPassed)
    {
        stPassed = stPassed.replaceAll("\\D", "");
        int len = stPassed.length();
        int sum = 0;
        int mul = 1;
        for(int i = len - 1; i >= 0; i--)
        {
            int digit = Character.digit(stPassed.charAt(i), 10);
            digit *= mul != 1 ? mul-- : mul++;
            sum += digit < 10 ? digit : digit % 10 + 1;
        }

        return sum;
    }

    public static int getLuhnCheckDigit(String stPassed)
    {
        int sum = getLuhnSum(stPassed);
        int mod = ((sum / 10 + 1) * 10 - sum) % 10;
        return 10 - mod;
    }

    public static boolean sumIsMod10(int sum)
    {
        return sum % 10 == 0;
    }

    public static String appendCheckDigit(String stPassed)
    {
        String checkDigit = (new Integer(getLuhnCheckDigit(stPassed))).toString();
        return (new StringBuilder()).append(stPassed).append(checkDigit).toString();
    }

    public static boolean isCreditCard(String stPassed)
    {
        if(isEmpty(stPassed))
            return true;
        String st = stripCharsInBag(stPassed, " -");
        if(st.length() > 19)
            return false;
        else
            return sumIsMod10(getLuhnSum(st));
    }

    public static boolean isVisa(String cc)
    {
        if((cc.length() == 16 || cc.length() == 13) && cc.substring(0, 1).equals("4"))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isMasterCard(String cc)
    {
        int firstdig = Integer.parseInt(cc.substring(0, 1));
        int seconddig = Integer.parseInt(cc.substring(1, 2));
        if(cc.length() == 16 && firstdig == 5 && seconddig >= 1 && seconddig <= 5)
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isAmericanExpress(String cc)
    {
        int firstdig = Integer.parseInt(cc.substring(0, 1));
        int seconddig = Integer.parseInt(cc.substring(1, 2));
        if(cc.length() == 15 && firstdig == 3 && (seconddig == 4 || seconddig == 7))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isDinersClub(String cc)
    {
        int firstdig = Integer.parseInt(cc.substring(0, 1));
        int seconddig = Integer.parseInt(cc.substring(1, 2));
        if(cc.length() == 14 && firstdig == 3 && (seconddig == 0 || seconddig == 6 || seconddig == 8))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isCarteBlanche(String cc)
    {
        return isDinersClub(cc);
    }

    public static boolean isDiscover(String cc)
    {
        String first4digs = cc.substring(0, 4);
        if(cc.length() == 16 && first4digs.equals("6011"))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isEnRoute(String cc)
    {
        String first4digs = cc.substring(0, 4);
        if(cc.length() == 15 && (first4digs.equals("2014") || first4digs.equals("2149")))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isJCB(String cc)
    {
        String first4digs = cc.substring(0, 4);
        if(cc.length() == 16 && (first4digs.equals("3088") || first4digs.equals("3096") || first4digs.equals("3112") || first4digs.equals("3158") || first4digs.equals("3337") || first4digs.equals("3528")))
            return isCreditCard(cc);
        else
            return false;
    }

    public static boolean isAnyCard(String ccPassed)
    {
        if(isEmpty(ccPassed))
            return true;
        String cc = stripCharsInBag(ccPassed, " -");
        if(!isCreditCard(cc))
            return false;
        return isMasterCard(cc) || isVisa(cc) || isAmericanExpress(cc) || isDinersClub(cc) || isDiscover(cc) || isEnRoute(cc) || isJCB(cc);
    }

    public static String getCardType(String ccPassed)
    {
        if(isEmpty(ccPassed))
            return "Unknown";
        String cc = stripCharsInBag(ccPassed, " -");
        if(!isCreditCard(cc))
            return "Unknown";
        if(isMasterCard(cc))
            return "MasterCard";
        if(isVisa(cc))
            return "Visa";
        if(isAmericanExpress(cc))
            return "AmericanExpress";
        if(isDinersClub(cc))
            return "DinersClub";
        if(isDiscover(cc))
            return "Discover";
        if(isEnRoute(cc))
            return "EnRoute";
        if(isJCB(cc))
            return "JCB";
        else
            return "Unknown";
    }

    public static boolean isCardMatch(String cardType, String cardNumberPassed)
    {
        if(isEmpty(cardType))
            return true;
        if(isEmpty(cardNumberPassed))
            return true;
        String cardNumber = stripCharsInBag(cardNumberPassed, " -");
        if(cardType.equalsIgnoreCase("VISA") && isVisa(cardNumber))
            return true;
        if(cardType.equalsIgnoreCase("MASTERCARD") && isMasterCard(cardNumber))
            return true;
        if((cardType.equalsIgnoreCase("AMERICANEXPRESS") || cardType.equalsIgnoreCase("AMEX")) && isAmericanExpress(cardNumber))
            return true;
        if(cardType.equalsIgnoreCase("DISCOVER") && isDiscover(cardNumber))
            return true;
        if(cardType.equalsIgnoreCase("JCB") && isJCB(cardNumber))
            return true;
        if((cardType.equalsIgnoreCase("DINERSCLUB") || cardType.equalsIgnoreCase("DINERS")) && isDinersClub(cardNumber))
            return true;
        if(cardType.equalsIgnoreCase("CARTEBLANCHE") && isCarteBlanche(cardNumber))
            return true;
        return cardType.equalsIgnoreCase("ENROUTE") && isEnRoute(cardNumber);
    }

    public static boolean isNotPoBox(String s)
    {
        if(isEmpty(s))
            return true;
        String sl = s.toLowerCase();
        if(sl.indexOf("p.o. b") != -1)
            return false;
        if(sl.indexOf("p.o.b") != -1)
            return false;
        if(sl.indexOf("p.o b") != -1)
            return false;
        if(sl.indexOf("p o b") != -1)
            return false;
        if(sl.indexOf("po b") != -1)
            return false;
        if(sl.indexOf("pobox") != -1)
            return false;
        if(sl.indexOf("po#") != -1)
            return false;
        if(sl.indexOf("po #") != -1)
            return false;
        if(sl.indexOf("p.0. b") != -1)
            return false;
        if(sl.indexOf("p.0.b") != -1)
            return false;
        if(sl.indexOf("p.0 b") != -1)
            return false;
        if(sl.indexOf("p 0 b") != -1)
            return false;
        if(sl.indexOf("p0 b") != -1)
            return false;
        if(sl.indexOf("p0box") != -1)
            return false;
        if(sl.indexOf("p0#") != -1)
            return false;
        return sl.indexOf("p0 #") == -1;
    }

    public static final String module = com/dtmc/server/analytics/util/UtilValidate.getName();
    public static final boolean defaultEmptyOK = true;
    public static final String digits = "0123456789";
    public static final String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
    public static final String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String whitespace = " \t\n\r";
    public static final String decimalPointDelimiter = ".";
    public static final String phoneNumberDelimiters = "()- ";
    public static final String validUSPhoneChars = "0123456789()- ";
    public static final String validWorldPhoneChars = "0123456789()- +";
    public static final String SSNDelimiters = "- ";
    public static final String validSSNChars = "0123456789- ";
    public static final int digitsInSocialSecurityNumber = 9;
    public static final int digitsInUSPhoneNumber = 10;
    public static final int digitsInUSPhoneAreaCode = 3;
    public static final int digitsInUSPhoneMainNumber = 7;
    public static final String ZipCodeDelimiters = "-";
    public static final String ZipCodeDelimeter = "-";
    public static final String validZipCodeChars = "0123456789-";
    public static final int digitsInZipCode1 = 5;
    public static final int digitsInZipCode2 = 9;
    public static final String creditCardDelimiters = " -";
    public static final String isNotEmptyMsg = "This field cannot be empty, please enter a value.";
    public static final String isStateCodeMsg = "The State Code must be a valid two character U.S. state abbreviation(like CA for California).";
    public static final String isContiguousStateCodeMsg = "The State Code must be a valid two character U.S. state abbreviation for one of the 48 contiguous United States (like CA for California).";
    public static final String isZipCodeMsg = "The ZIP Code must be a 5 or 9 digit U.S. ZIP Code(like 94043).";
    public static final String isUSPhoneMsg = "The US Phone must be a 10 digit U.S. phone number(like 415-555-1212).";
    public static final String isUSPhoneAreaCodeMsg = "The Phone Number Area Code must be 3 digits.";
    public static final String isUSPhoneMainNumberMsg = "The Phone Number must be 7 digits.";
    public static final String isContiguousZipCodeMsg = "Zip Code is not a valid Zip Code for one of the 48 contiguous United States .";
    public static final String isInternationalPhoneNumberMsg = "The World Phone must be a valid international phone number.";
    public static final String isSSNMsg = "The SSN must be a 9 digit U.S. social security number(like 123-45-6789).";
    public static final String isEmailMsg = "The Email must be a valid email address(like john@email.com). Please re-enter it now.";
    public static final String isAnyCardMsg = "The credit card number is not a valid card number.";
    public static final String isCreditCardPrefixMsg = " is not a valid ";
    public static final String isCreditCardSuffixMsg = " credit card number.";
    public static final String isDayMsg = "The Day must be a day number between 1 and 31. ";
    public static final String isMonthMsg = "The Month must be a month number between 1 and 12. ";
    public static final String isYearMsg = "The Year must be a 2 or 4 digit year number. ";
    public static final String isDatePrefixMsg = "The Day, Month, and Year for ";
    public static final String isDateSuffixMsg = " do not form a valid date.  Please reenter them now.";
    public static final String isHourMsg = "The Hour must be a number between 0 and 23.";
    public static final String isMinuteMsg = "The Hour must be a number between 0 and 59.";
    public static final String isSecondMsg = "The Hour must be a number between 0 and 59.";
    public static final String isTimeMsg = "The Time must be a valid time formed like: HH:MM or HH:MM:SS.";
    public static final String isDateMsg = "The Date must be a valid date formed like: MM/YY, MM/YYYY, MM/DD/YY, or MM/DD/YYYY.";
    public static final String isDateAfterToday = "The Date must be a valid date after today, and formed like: MM/YY, MM/YYYY, MM/DD/YY, or MM/DD/YYYY.";
    public static final String isIntegerMsg = "The Number must be a valid unsigned whole decimal number.";
    public static final String isSignedIntegerMsg = "The Number must be a valid signed whole decimal number.";
    public static final String isLongMsg = "The Number must be a valid unsigned whole decimal number.";
    public static final String isSignedLongMsg = "The Number must be a valid signed whole decimal number.";
    public static final String isFloatMsg = "The Number must be a valid unsigned decimal number.";
    public static final String isSignedFloatMsg = "The Number must be a valid signed decimal number.";
    public static final String isSignedDoubleMsg = "The Number must be a valid signed decimal number.";
    public static final int daysInMonth[] = {
        31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 
        30, 31
    };
    public static final String USStateCodeDelimiter = "|";
    public static final String USStateCodes = "AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|AE|AA|AE|AE|AP";
    public static final String ContiguousUSStateCodes = "AL|AZ|AR|CA|CO|CT|DE|DC|FL|GA|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY";

}
