package com.numhero.server.utils;

import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.User;
import com.numhero.server.NumheroUtils;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static com.numhero.server.utils.XmlUtils.serializeEntity;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class XmlUtilsTest {


	private User createTestUserC() {
		User u = new User();
		u.setId(12L);
		u.setFirstName("Uberto");
		u.setLastName("Barbini");
		u.fBusinessAccountUri.setValue("gama");
		return u;
	}


    @Test
    public void testParseEntityData() throws Exception {
        String xml = "<entity type='Invoice'><id>111</id><clientSupplierID>123</clientSupplierID><currency>EUR</currency><dateDue>Wed Jun 30 14:20:51 CEST 2010</dateDue><dateRaised>Wed Jun 16 14:20:51 CEST 2010</dateRaised><discount>0.0</discount><value>0.0</value></entity>";
        SearchablePojo p = XmlEntityParser.parseEntityData(NumheroUtils.convertStringInInputStream(xml));

		assertEquals(Invoice.class, p.getClass());
		assertEquals("123", p.getAttributeAsString("clientSupplierID"));
		assertEquals(111L, p.getId().longValue());
	}

	@Test
	public void testSerializeEntity() throws Exception {
		User u = createTestUserC();

		StringBuffer xml = new StringBuffer();
		serializeEntity(xml, u);

		assertThat(xml.toString(), containsString("<entity type=\"User\" >"));
		assertThat(xml.toString(), containsString("<firstName>Uberto</firstName>"));
		assertThat(xml.toString(), containsString("<id>12</id>"));
		assertThat(xml.toString(), containsString("<dbVersion>1</dbVersion>"));


	}

	@Test
	public void testCountryCodes() {

		String[] codes = java.util.Locale.getISOCountries();
		for (String isoCode : codes) {
			Locale locale = new Locale(Locale.ENGLISH.getLanguage(), isoCode);
			Currency cur = Currency.getInstance(locale);

			if (cur != null) {
				System.out.println(isoCode.toUpperCase() + "(\"" + locale.getDisplayCountry() + "\", CurrencyEnum." + cur.getCurrencyCode() + " ),");
			}
		}
	}


    @Test
    public void testCurrenciesCodes() {
        CountryEnum en = CountryEnum.getByDisplayValue("Italy");
        assertEquals(en.getCurrency(), CurrencyEnum.EUR);

        CurrencyEnum cen = CountryEnum.getCurrByCountryCode("IT");
        assertEquals(cen.name(), CurrencyEnum.EUR.toString());
    }	

}
