package com.numhero.server.pojoc;

import com.numhero.shared.pojoc.SearchReference;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchPojoTest {
    @Test
    public void testGetKeyName() throws Exception {
        SearchReference p = new SearchReference();
        p.fName.setValue("abc");
        p.setPojoKind("pojokind");
        p.setPojoId(123L);
        assertThat(p.fName.getValue(), is("pojokind-123"));
    }
}
