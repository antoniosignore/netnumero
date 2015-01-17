package com.numhero.server.pojoc;

import com.numhero.client.model.pojoc.User;
import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.field.StringField;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NewPojoCTest {
    @Test
    public void testSetAttributeAsString() throws Exception {

        User u = new User();
        u.setAttributeAsString("firstName", "ubi");

        assertEquals("ubi", u.getField("firstName").getValue());
        assertEquals("ubi", u.fFirstName.getValue());

    }

    @Test
    public void testFields() throws Exception {

        User u = new User();

        assertEquals(15, u.getFields().size());
        assertEquals(u.fFirstName, u.getField("firstName"));
        assertEquals(u.getFields().size(), u.getFieldNames().size());

    }


    @Test
    public void testCollidingFieldNames() throws Exception {
        try {
            Fake u = new Fake();
            fail("no expected exception");
        } catch (Exception e) {


        }


    }

    private class Fake extends BAPojo {
        public StringField fba = stringField(FIELD_NAME, 30);
    }
}
