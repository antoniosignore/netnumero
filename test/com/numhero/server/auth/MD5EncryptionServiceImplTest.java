package com.numhero.server.auth;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MD5EncryptionServiceImplTest {
    @Test
    public void testHexMD5() throws Exception {

        MD5EncryptionServiceImpl a = new MD5EncryptionServiceImpl();

        assertEquals("cb9b6bee58dc306779801b2b34dba7ee", a.hexMD5("numhero"));
		assertEquals("ad998f42e485ccec2778440b6cfe1690", a.hexMD5("11nvarma@live.comNetNumeroIsBeautifullySimple"));

    }



}



