package com.numhero.client;

import com.google.gwt.junit.client.GWTTestCase;

public abstract class GwtTestBase extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.numhero.Application";
	}
}
