package com.numhero.server.utils;

import org.junit.Test;

import static com.numhero.shared.util.SharedUtils.*;
import static junit.framework.Assert.assertEquals;

public class SharedUtilsTest {



    @Test
    public void testSplitUri() throws Exception {
        assertEquals(4, splitUri("/pippo/cammina/dritto#123?1234").length);
        assertEquals(3, splitUri("pippo/cammina/dritto#123?1234").length);
        assertEquals(4, splitUri("/pippo/cammina/dritto").length);
    }

    @Test
    public void testInitialUppercase() throws Exception {
        assertEquals("Allù", initialUppercase("aLlÙ"));
    }

     @Test
    public void testInitialUppercaseAndCamel() throws Exception {
        assertEquals("MioCane", initialUppercaseAndCamel("mio_cane"));
        assertEquals("Miocane", initialUppercaseAndCamel("miocane"));
		assertEquals("Miocane", initialUppercaseAndCamel("_miocane"));
	 }

	@Test
   public void testStrToDate() throws Exception {
	   assertEquals("MioCane", initialUppercaseAndCamel("mio_cane"));
	   assertEquals("Miocane", initialUppercaseAndCamel("miocane"));
	   assertEquals("Miocane", initialUppercaseAndCamel("_miocane"));
	}

}
