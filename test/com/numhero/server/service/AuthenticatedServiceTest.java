package com.numhero.server.service;

import com.numhero.client.util.ClientUtils;
import junit.framework.TestCase;
import org.junit.Test;

public class AuthenticatedServiceTest extends TestCase {

	@Test
	public void testUri() {
		String url = "/company/pippo#invoice/123";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals("pippo", baName);
	}

	@Test
	public void testPath() {
		String url = "/company/mycompany";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals("mycompany", baName);
	}

	@Test
	public void testUri2() {
		String url = "/application/data";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals(null, baName);
	}

	@Test
	public void testWrongUri() {
		String url = "/company/speedy/gonzales";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals(null, baName);
	}

	@Test
	public void testUri3() {
		String url = "/company/speedy#sdsds?mumu=12";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals("speedy", baName);
	}


    	@Test
	public void testUserAssociation() {
		String url = "/company/speedy#sdsds?mumu=12";
		String baName = ClientUtils.getCompanyNameFromUri(url);
		assertEquals("speedy", baName);
	}
}
