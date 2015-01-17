package com.numhero.server.utils;

import junit.framework.TestCase;
import org.junit.Test;

import static com.numhero.server.utils.StringUtils.strToEnumDef;
import static com.numhero.server.utils.StringUtils.strToIntDef;


public class StringUtilsTest extends TestCase {
    enum TestEnum {
        a, b, abcd, c
    }

    @Test
    public void testStrToIntDef() throws Exception {
        assertEquals(1, strToIntDef("1", 2));
        assertEquals(-123, strToIntDef("-123", 2));
        assertEquals(2, strToIntDef("pippo", 2));
    }

    @Test
    public void testStrToEnumDef() throws Exception {


        assertEquals(TestEnum.a, strToEnumDef("a", TestEnum.b));
        assertEquals(TestEnum.abcd, strToEnumDef("abcd", TestEnum.b));
        assertEquals(TestEnum.b, strToEnumDef("pippo", TestEnum.b));
    }
}
