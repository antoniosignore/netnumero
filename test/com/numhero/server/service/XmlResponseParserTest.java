package com.numhero.server.service;


import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.server.utils.XmlResponseParser;
import com.numhero.shared.enums.UserRoleEnum;
import junit.framework.TestCase;
import org.junit.Test;


public class XmlResponseParserTest extends TestCase {

    public static String xmlManyCompanies = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "\t<user>\n" +
            "\t\t<name>Uberto</name>\n" +
            "\t\t<surname>Barbini</surname>\n" +
            "\t\t<email>uberto@ubiland.net</email>\n" +
            "\t\t<version>1</version>\n" +
            "\t\t<roles>\n" +
            "\n" +
            "\t\t\t<role companyId='gamasoft'>plus</role> \n" +
            "\t\t\t<role companyId='pippopippo'>solo</role> \n" +
            "\t\t\t<role companyId='netnumero'>free</role> \n" +
            "\t\t</roles> \n" +
            "\t</user>";


    public static String xmlOneCompany = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "    \t \t<user>\n" +
            "\t\t\t\t<name>Uberto</name>\n" +
            "\t\t\t \t<surname>Barbini</surname>\n" +
            "\t\t\t \t<email>uberto@ubiland.net</email>\n" +
            "\t\t\t \t<country>DE</country>\n" +
            "\t\t\t\t<version>1</version>\n" +
            "\n" +
            "\t\t\t\t\t<roles>\n" +
            "\t\t\t\t\t\t<role companyId='gamasoft'>free</role> \n" +
            "\t\t\t\t\t</roles> \n" +
            "\t\t\t</user>";


    @Test
    public void testParser() {
        User u = new User();
        XmlResponseParser.parseGetUserData(NumheroUtils.convertStringInInputStream(xmlManyCompanies), u);
        assertEquals("Uberto", u.getFirstName());
        assertEquals("Barbini", u.getLastName());
        assertEquals("uberto@ubiland.net", u.fEmail.getValue());
        assertEquals("1", u.fVersion.getValue());
        assertEquals("netnumero", u.fBusinessAccountUri.getValue());
        assertEquals(UserRoleEnum.free, u.getRelationToBa("netnumero").fRole.getValue());
        assertEquals(UserRoleEnum.plus, u.getRelationToBa("gamasoft").fRole.getValue());
        assertEquals(UserRoleEnum.solo, u.getRelationToBa("pippopippo").fRole.getValue());
        assertEquals(3, u.fBusinessAccountRoles.size());
    }


    @Test
    public void testParserCountry() {
        User u = new User();
        XmlResponseParser.parseGetUserData(NumheroUtils.convertStringInInputStream(xmlOneCompany), u);
        assertEquals("Uberto", u.getFirstName());
        assertEquals("Barbini", u.getLastName());
        assertEquals("uberto@ubiland.net", u.fEmail.getValue());
        //   assertEquals(1, u.getVersion());
        assertEquals("gamasoft", u.fBusinessAccountUri.getValue());
        assertEquals("DE", u.fCountryCode.getValue());

        assertEquals(UserRoleEnum.free, u.getRelationToBa("gamasoft").fRole.getValue());
        assertTrue(u.hasRelationToBa("gamasoft"));
        assertEquals(1, u.fBusinessAccountRoles.size());

        assertEquals("Uberto Barbini", u.fName.getValue());

    }

}
