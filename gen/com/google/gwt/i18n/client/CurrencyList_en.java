package com.google.gwt.i18n.client;

import com.google.gwt.i18n.client.impl.CurrencyDataImpl;
import com.google.gwt.core.client.JavaScriptObject;
import java.util.HashMap;

public class CurrencyList_en extends com.google.gwt.i18n.client.CurrencyList_ {
  
  @Override
  protected CurrencyData getDefaultJava() {
    return new CurrencyDataImpl("USD", "$", 2, "US$");
  }
  
  @Override
  protected native CurrencyData getDefaultNative() /*-{
    return [ "USD", "$", 2, "US$"];
  }-*/;
  
  @Override
  protected HashMap<String, CurrencyData> loadCurrencyMapJava() {
    HashMap<String, CurrencyData> result = super.loadCurrencyMapJava();
    // Andorran Peseta
    result.put("ADP", new CurrencyDataImpl("ADP", "ADP", 128));
    // United Arab Emirates Dirham
    result.put("AED", new CurrencyDataImpl("AED", "DH", 2, "DH"));
    // Afghan Afghani (1927-2002)
    result.put("AFA", new CurrencyDataImpl("AFA", "AFA", 130));
    // Afghan Afghani
    result.put("AFN", new CurrencyDataImpl("AFN", "Af", 0));
    // Albanian Lek
    result.put("ALL", new CurrencyDataImpl("ALL", "ALL", 0));
    // Armenian Dram
    result.put("AMD", new CurrencyDataImpl("AMD", "AMD", 0));
    // Netherlands Antillean Guilder
    result.put("ANG", new CurrencyDataImpl("ANG", "NAf.", 2));
    // Angolan Kwanza
    result.put("AOA", new CurrencyDataImpl("AOA", "Kz", 2));
    // Angolan Kwanza (1977-1990)
    result.put("AOK", new CurrencyDataImpl("AOK", "AOK", 130));
    // Angolan New Kwanza (1990-2000)
    result.put("AON", new CurrencyDataImpl("AON", "AON", 130));
    // Angolan Kwanza Reajustado (1995-1999)
    result.put("AOR", new CurrencyDataImpl("AOR", "AOR", 130));
    // Argentine Austral
    result.put("ARA", new CurrencyDataImpl("ARA", "₳", 130));
    // Argentine Peso Ley
    result.put("ARL", new CurrencyDataImpl("ARL", "$L", 130));
    // Argentine Peso Moneda Nacional
    result.put("ARM", new CurrencyDataImpl("ARM", "m$n", 130));
    // Argentine Peso (1983-1985)
    result.put("ARP", new CurrencyDataImpl("ARP", "ARP", 130));
    // Argentine Peso
    result.put("ARS", new CurrencyDataImpl("ARS", "AR$", 2, "AR$"));
    // Austrian Schilling
    result.put("ATS", new CurrencyDataImpl("ATS", "ATS", 130));
    // Australian Dollar
    result.put("AUD", new CurrencyDataImpl("AUD", "AU$", 2, "AU$"));
    // Aruban Florin
    result.put("AWG", new CurrencyDataImpl("AWG", "Afl.", 2));
    // Azerbaijani Manat (1993-2006)
    result.put("AZM", new CurrencyDataImpl("AZM", "AZM", 130));
    // Azerbaijani Manat
    result.put("AZN", new CurrencyDataImpl("AZN", "man.", 2));
    // Bosnia-Herzegovina Dinar
    result.put("BAD", new CurrencyDataImpl("BAD", "BAD", 130));
    // Bosnia-Herzegovina Convertible Mark
    result.put("BAM", new CurrencyDataImpl("BAM", "KM", 2));
    // Bosnia-Herzegovina New Dinar
    result.put("BAN", new CurrencyDataImpl("BAN", "BAN", 130));
    // Barbadian Dollar
    result.put("BBD", new CurrencyDataImpl("BBD", "Bds$", 2));
    // Bangladeshi Taka
    result.put("BDT", new CurrencyDataImpl("BDT", "Tk", 2, "Tk"));
    // Belgian Franc (convertible)
    result.put("BEC", new CurrencyDataImpl("BEC", "BEC", 2));
    // Belgian Franc
    result.put("BEF", new CurrencyDataImpl("BEF", "BF", 130));
    // Belgian Franc (financial)
    result.put("BEL", new CurrencyDataImpl("BEL", "BEL", 2));
    // Bulgarian Hard Lev
    result.put("BGL", new CurrencyDataImpl("BGL", "BGL", 130));
    // Bulgarian Socialist Lev
    result.put("BGM", new CurrencyDataImpl("BGM", "BGM", 130));
    // Bulgarian Lev
    result.put("BGN", new CurrencyDataImpl("BGN", "BGN", 2));
    // Old Bulgarian Lev
    result.put("BGO", new CurrencyDataImpl("BGO", "BGO", 130));
    // Bahraini Dinar
    result.put("BHD", new CurrencyDataImpl("BHD", "BD", 3));
    // Burundian Franc
    result.put("BIF", new CurrencyDataImpl("BIF", "FBu", 0));
    // Bermudan Dollar
    result.put("BMD", new CurrencyDataImpl("BMD", "BD$", 2));
    // Brunei Dollar
    result.put("BND", new CurrencyDataImpl("BND", "BN$", 2));
    // Bolivian Boliviano
    result.put("BOB", new CurrencyDataImpl("BOB", "Bs", 2));
    // Old Bolivian Boliviano
    result.put("BOL", new CurrencyDataImpl("BOL", "BOL", 130));
    // Bolivian Peso
    result.put("BOP", new CurrencyDataImpl("BOP", "$b.", 130));
    // Bolivian Mvdol
    result.put("BOV", new CurrencyDataImpl("BOV", "BOV", 2));
    // Brazilian Cruzeiro Novo (1967-1986)
    result.put("BRB", new CurrencyDataImpl("BRB", "BRB", 130));
    // Brazilian Cruzado
    result.put("BRC", new CurrencyDataImpl("BRC", "BRC", 130));
    // Brazilian Cruzeiro (1990-1993)
    result.put("BRE", new CurrencyDataImpl("BRE", "BRE", 130));
    // Brazilian Real
    result.put("BRL", new CurrencyDataImpl("BRL", "R$", 2, "R$"));
    // Brazilian Cruzado Novo
    result.put("BRN", new CurrencyDataImpl("BRN", "BRN", 130));
    // Brazilian Cruzeiro
    result.put("BRR", new CurrencyDataImpl("BRR", "BRR", 130));
    // Old Brazilian Cruzeiro
    result.put("BRZ", new CurrencyDataImpl("BRZ", "BRZ", 130));
    // Bahamian Dollar
    result.put("BSD", new CurrencyDataImpl("BSD", "BS$", 2));
    // Bhutanese Ngultrum
    result.put("BTN", new CurrencyDataImpl("BTN", "Nu.", 2));
    // Burmese Kyat
    result.put("BUK", new CurrencyDataImpl("BUK", "BUK", 130));
    // Botswanan Pula
    result.put("BWP", new CurrencyDataImpl("BWP", "BWP", 2));
    // Belarusian New Ruble (1994-1999)
    result.put("BYB", new CurrencyDataImpl("BYB", "BYB", 130));
    // Belarusian Ruble
    result.put("BYR", new CurrencyDataImpl("BYR", "BYR", 0));
    // Belize Dollar
    result.put("BZD", new CurrencyDataImpl("BZD", "BZ$", 2));
    // Canadian Dollar
    result.put("CAD", new CurrencyDataImpl("CAD", "CA$", 2, "C$"));
    // Congolese Franc
    result.put("CDF", new CurrencyDataImpl("CDF", "CDF", 2));
    // WIR Euro
    result.put("CHE", new CurrencyDataImpl("CHE", "CHE", 2));
    // Swiss Franc
    result.put("CHF", new CurrencyDataImpl("CHF", "Fr.", 2, "CHF"));
    // WIR Franc
    result.put("CHW", new CurrencyDataImpl("CHW", "CHW", 2));
    // Chilean Escudo
    result.put("CLE", new CurrencyDataImpl("CLE", "Eº", 130));
    // Chilean Unidades de Fomento
    result.put("CLF", new CurrencyDataImpl("CLF", "CLF", 0));
    // Chilean Peso
    result.put("CLP", new CurrencyDataImpl("CLP", "CL$", 0, "CL$"));
    // Chinese Yuan Renminbi
    result.put("CNY", new CurrencyDataImpl("CNY", "CN¥", 2, "RMB¥"));
    // Colombian Peso
    result.put("COP", new CurrencyDataImpl("COP", "CO$", 0, "COL$"));
    // Unidad de Valor Real
    result.put("COU", new CurrencyDataImpl("COU", "COU", 2));
    // Costa Rican Colón
    result.put("CRC", new CurrencyDataImpl("CRC", "₡", 0, "CR₡"));
    // Old Serbian Dinar
    result.put("CSD", new CurrencyDataImpl("CSD", "CSD", 130));
    // Czechoslovak Hard Koruna
    result.put("CSK", new CurrencyDataImpl("CSK", "CSK", 130));
    // Cuban Convertible Peso
    result.put("CUC", new CurrencyDataImpl("CUC", "CUC$", 2));
    // Cuban Peso
    result.put("CUP", new CurrencyDataImpl("CUP", "CU$", 2, "$MN"));
    // Cape Verdean Escudo
    result.put("CVE", new CurrencyDataImpl("CVE", "CV$", 2));
    // Cypriot Pound
    result.put("CYP", new CurrencyDataImpl("CYP", "CY£", 130));
    // Czech Republic Koruna
    result.put("CZK", new CurrencyDataImpl("CZK", "Kč", 2, "Kč"));
    // East German Mark
    result.put("DDM", new CurrencyDataImpl("DDM", "DDM", 130));
    // German Mark
    result.put("DEM", new CurrencyDataImpl("DEM", "DM", 130));
    // Djiboutian Franc
    result.put("DJF", new CurrencyDataImpl("DJF", "Fdj", 0));
    // Danish Krone
    result.put("DKK", new CurrencyDataImpl("DKK", "Dkr", 2, "kr"));
    // Dominican Peso
    result.put("DOP", new CurrencyDataImpl("DOP", "RD$", 2, "RD$"));
    // Algerian Dinar
    result.put("DZD", new CurrencyDataImpl("DZD", "DA", 2));
    // Ecuadorian Sucre
    result.put("ECS", new CurrencyDataImpl("ECS", "ECS", 130));
    // Ecuadorian Unidad de Valor Constante (UVC)
    result.put("ECV", new CurrencyDataImpl("ECV", "ECV", 2));
    // Estonian Kroon
    result.put("EEK", new CurrencyDataImpl("EEK", "Ekr", 2));
    // Egyptian Pound
    result.put("EGP", new CurrencyDataImpl("EGP", "EG£", 2, "LE"));
    // EQE
    result.put("EQE", new CurrencyDataImpl("EQE", "EQE", 130));
    // Eritrean Nakfa
    result.put("ERN", new CurrencyDataImpl("ERN", "Nfk", 2));
    // Spanish Peseta (A account)
    result.put("ESA", new CurrencyDataImpl("ESA", "ESA", 2));
    // Spanish Peseta (convertible account)
    result.put("ESB", new CurrencyDataImpl("ESB", "ESB", 2));
    // Spanish Peseta
    result.put("ESP", new CurrencyDataImpl("ESP", "Pts", 128));
    // Ethiopian Birr
    result.put("ETB", new CurrencyDataImpl("ETB", "Br", 2));
    // Euro
    result.put("EUR", new CurrencyDataImpl("EUR", "€", 2, "€"));
    // Finnish Markka
    result.put("FIM", new CurrencyDataImpl("FIM", "mk", 130));
    // Fijian Dollar
    result.put("FJD", new CurrencyDataImpl("FJD", "FJ$", 2));
    // Falkland Islands Pound
    result.put("FKP", new CurrencyDataImpl("FKP", "FK£", 2));
    // French Franc
    result.put("FRF", new CurrencyDataImpl("FRF", "₣", 130));
    // British Pound Sterling
    result.put("GBP", new CurrencyDataImpl("GBP", "£", 2, "GB£"));
    // Georgian Kupon Larit
    result.put("GEK", new CurrencyDataImpl("GEK", "GEK", 130));
    // Georgian Lari
    result.put("GEL", new CurrencyDataImpl("GEL", "GEL", 2));
    // Ghanaian Cedi (1979-2007)
    result.put("GHC", new CurrencyDataImpl("GHC", "₵", 130));
    // Ghanaian Cedi
    result.put("GHS", new CurrencyDataImpl("GHS", "GH₵", 2));
    // Gibraltar Pound
    result.put("GIP", new CurrencyDataImpl("GIP", "GI£", 2));
    // Gambian Dalasi
    result.put("GMD", new CurrencyDataImpl("GMD", "GMD", 2));
    // Guinean Franc
    result.put("GNF", new CurrencyDataImpl("GNF", "FG", 0));
    // Guinean Syli
    result.put("GNS", new CurrencyDataImpl("GNS", "GNS", 130));
    // Equatorial Guinean Ekwele
    result.put("GQE", new CurrencyDataImpl("GQE", "GQE", 130));
    // Greek Drachma
    result.put("GRD", new CurrencyDataImpl("GRD", "₯", 130));
    // Guatemalan Quetzal
    result.put("GTQ", new CurrencyDataImpl("GTQ", "GTQ", 2));
    // Portuguese Guinea Escudo
    result.put("GWE", new CurrencyDataImpl("GWE", "GWE", 130));
    // Guinea-Bissau Peso
    result.put("GWP", new CurrencyDataImpl("GWP", "GWP", 2));
    // Guyanaese Dollar
    result.put("GYD", new CurrencyDataImpl("GYD", "GY$", 0));
    // Hong Kong Dollar
    result.put("HKD", new CurrencyDataImpl("HKD", "HK$", 2, "HK$"));
    // Honduran Lempira
    result.put("HNL", new CurrencyDataImpl("HNL", "HNL", 2));
    // Croatian Dinar
    result.put("HRD", new CurrencyDataImpl("HRD", "HRD", 130));
    // Croatian Kuna
    result.put("HRK", new CurrencyDataImpl("HRK", "kn", 2));
    // Haitian Gourde
    result.put("HTG", new CurrencyDataImpl("HTG", "HTG", 2));
    // Hungarian Forint
    result.put("HUF", new CurrencyDataImpl("HUF", "Ft", 0));
    // Indonesian Rupiah
    result.put("IDR", new CurrencyDataImpl("IDR", "Rp", 0));
    // Irish Pound
    result.put("IEP", new CurrencyDataImpl("IEP", "IR£", 130));
    // Israeli Pound
    result.put("ILP", new CurrencyDataImpl("ILP", "I£", 130));
    // Old Israeli Sheqel
    result.put("ILR", new CurrencyDataImpl("ILR", "ILR", 130));
    // Israeli New Sheqel
    result.put("ILS", new CurrencyDataImpl("ILS", "₪", 2, "IL₪"));
    // Indian Rupee
    result.put("INR", new CurrencyDataImpl("INR", "Rs", 2, "Rs"));
    // Iraqi Dinar
    result.put("IQD", new CurrencyDataImpl("IQD", "IQD", 0));
    // Iranian Rial
    result.put("IRR", new CurrencyDataImpl("IRR", "IRR", 0));
    // Old Icelandic Króna
    result.put("ISJ", new CurrencyDataImpl("ISJ", "ISJ", 130));
    // Icelandic Króna
    result.put("ISK", new CurrencyDataImpl("ISK", "Ikr", 0, "kr"));
    // Italian Lira
    result.put("ITL", new CurrencyDataImpl("ITL", "IT₤", 128));
    // Jamaican Dollar
    result.put("JMD", new CurrencyDataImpl("JMD", "J$", 2, "JA$"));
    // Jordanian Dinar
    result.put("JOD", new CurrencyDataImpl("JOD", "JD", 3));
    // Japanese Yen
    result.put("JPY", new CurrencyDataImpl("JPY", "¥", 0, "JP¥"));
    // Kenyan Shilling
    result.put("KES", new CurrencyDataImpl("KES", "Ksh", 2));
    // Kyrgystani Som
    result.put("KGS", new CurrencyDataImpl("KGS", "KGS", 2));
    // Cambodian Riel
    result.put("KHR", new CurrencyDataImpl("KHR", "KHR", 2));
    // Comorian Franc
    result.put("KMF", new CurrencyDataImpl("KMF", "CF", 0));
    // North Korean Won
    result.put("KPW", new CurrencyDataImpl("KPW", "KPW", 0));
    // South Korean Hwan
    result.put("KRH", new CurrencyDataImpl("KRH", "KRH", 130));
    // Old South Korean Won
    result.put("KRO", new CurrencyDataImpl("KRO", "KRO", 130));
    // South Korean Won
    result.put("KRW", new CurrencyDataImpl("KRW", "₩", 0, "KR₩"));
    // Kuwaiti Dinar
    result.put("KWD", new CurrencyDataImpl("KWD", "KD", 3));
    // Cayman Islands Dollar
    result.put("KYD", new CurrencyDataImpl("KYD", "KY$", 2));
    // Kazakhstan Tenge
    result.put("KZT", new CurrencyDataImpl("KZT", "KZT", 2));
    // Laotian Kip
    result.put("LAK", new CurrencyDataImpl("LAK", "₭", 0));
    // Lebanese Pound
    result.put("LBP", new CurrencyDataImpl("LBP", "LB£", 0));
    // Sri Lanka Rupee
    result.put("LKR", new CurrencyDataImpl("LKR", "SLRs", 2, "SLRs"));
    // Liberian Dollar
    result.put("LRD", new CurrencyDataImpl("LRD", "L$", 2));
    // Lesotho Loti
    result.put("LSL", new CurrencyDataImpl("LSL", "LSL", 2));
    // LSM
    result.put("LSM", new CurrencyDataImpl("LSM", "LSM", 130));
    // Lithuanian Litas
    result.put("LTL", new CurrencyDataImpl("LTL", "Lt", 2));
    // Lithuanian Talonas
    result.put("LTT", new CurrencyDataImpl("LTT", "LTT", 130));
    // Luxembourgian Convertible Franc
    result.put("LUC", new CurrencyDataImpl("LUC", "LUC", 2));
    // Luxembourgian Franc
    result.put("LUF", new CurrencyDataImpl("LUF", "LUF", 128));
    // Luxembourg Financial Franc
    result.put("LUL", new CurrencyDataImpl("LUL", "LUL", 2));
    // Latvian Lats
    result.put("LVL", new CurrencyDataImpl("LVL", "Ls", 2));
    // Latvian Ruble
    result.put("LVR", new CurrencyDataImpl("LVR", "LVR", 130));
    // Libyan Dinar
    result.put("LYD", new CurrencyDataImpl("LYD", "LD", 3));
    // Moroccan Dirham
    result.put("MAD", new CurrencyDataImpl("MAD", "MAD", 2));
    // Moroccan Franc
    result.put("MAF", new CurrencyDataImpl("MAF", "MAF", 130));
    // Monegasque Franc
    result.put("MCF", new CurrencyDataImpl("MCF", "MCF", 130));
    // Moldovan Cupon
    result.put("MDC", new CurrencyDataImpl("MDC", "MDC", 130));
    // Moldovan Leu
    result.put("MDL", new CurrencyDataImpl("MDL", "MDL", 2));
    // Malagasy Ariary
    result.put("MGA", new CurrencyDataImpl("MGA", "MGA", 0));
    // Malagasy Franc
    result.put("MGF", new CurrencyDataImpl("MGF", "MGF", 128));
    // Macedonian Denar
    result.put("MKD", new CurrencyDataImpl("MKD", "MKD", 2));
    // Old Macedonian Denar
    result.put("MKN", new CurrencyDataImpl("MKN", "MKN", 130));
    // Malian Franc
    result.put("MLF", new CurrencyDataImpl("MLF", "MLF", 130));
    // Myanma Kyat
    result.put("MMK", new CurrencyDataImpl("MMK", "MMK", 0));
    // Mongolian Tugrik
    result.put("MNT", new CurrencyDataImpl("MNT", "₮", 0, "MN₮"));
    // Macanese Pataca
    result.put("MOP", new CurrencyDataImpl("MOP", "MOP$", 2));
    // Mauritanian Ouguiya
    result.put("MRO", new CurrencyDataImpl("MRO", "UM", 0));
    // Maltese Lira
    result.put("MTL", new CurrencyDataImpl("MTL", "Lm", 130));
    // Maltese Pound
    result.put("MTP", new CurrencyDataImpl("MTP", "MT£", 130));
    // Mauritian Rupee
    result.put("MUR", new CurrencyDataImpl("MUR", "MURs", 0));
    // Maldivian Rupee
    result.put("MVP", new CurrencyDataImpl("MVP", "MVP", 130));
    // Maldivian Rufiyaa
    result.put("MVR", new CurrencyDataImpl("MVR", "MVR", 2));
    // Malawian Kwacha
    result.put("MWK", new CurrencyDataImpl("MWK", "MWK", 2));
    // Mexican Peso
    result.put("MXN", new CurrencyDataImpl("MXN", "Mex$", 2, "Mex$"));
    // Mexican Silver Peso (1861-1992)
    result.put("MXP", new CurrencyDataImpl("MXP", "MX$", 130));
    // Mexican Unidad de Inversion (UDI)
    result.put("MXV", new CurrencyDataImpl("MXV", "MXV", 2));
    // Malaysian Ringgit
    result.put("MYR", new CurrencyDataImpl("MYR", "RM", 2, "RM"));
    // Mozambican Escudo
    result.put("MZE", new CurrencyDataImpl("MZE", "MZE", 130));
    // Old Mozambican Metical
    result.put("MZM", new CurrencyDataImpl("MZM", "Mt", 130));
    // Mozambican Metical
    result.put("MZN", new CurrencyDataImpl("MZN", "MTn", 2));
    // Namibian Dollar
    result.put("NAD", new CurrencyDataImpl("NAD", "N$", 2));
    // Nigerian Naira
    result.put("NGN", new CurrencyDataImpl("NGN", "₦", 2));
    // Nicaraguan Cordoba
    result.put("NIC", new CurrencyDataImpl("NIC", "NIC", 130));
    // Nicaraguan Cordoba Oro
    result.put("NIO", new CurrencyDataImpl("NIO", "C$", 2));
    // Dutch Guilder
    result.put("NLG", new CurrencyDataImpl("NLG", "fl", 130));
    // Norwegian Krone
    result.put("NOK", new CurrencyDataImpl("NOK", "Nkr", 2, "NOkr"));
    // Nepalese Rupee
    result.put("NPR", new CurrencyDataImpl("NPR", "NPRs", 2));
    // New Zealand Dollar
    result.put("NZD", new CurrencyDataImpl("NZD", "NZ$", 2));
    // Omani Rial
    result.put("OMR", new CurrencyDataImpl("OMR", "OMR", 3));
    // Panamanian Balboa
    result.put("PAB", new CurrencyDataImpl("PAB", "B/.", 2, "B/."));
    // Peruvian Inti
    result.put("PEI", new CurrencyDataImpl("PEI", "I/.", 130));
    // Peruvian Nuevo Sol
    result.put("PEN", new CurrencyDataImpl("PEN", "S/.", 2, "S/."));
    // Peruvian Sol
    result.put("PES", new CurrencyDataImpl("PES", "PES", 130));
    // Papua New Guinean Kina
    result.put("PGK", new CurrencyDataImpl("PGK", "PGK", 2));
    // Philippine Peso
    result.put("PHP", new CurrencyDataImpl("PHP", "₱", 2, "PHP"));
    // Pakistani Rupee
    result.put("PKR", new CurrencyDataImpl("PKR", "PKRs", 0, "PKRs."));
    // Polish Zloty
    result.put("PLN", new CurrencyDataImpl("PLN", "zł", 2));
    // Polish Zloty (1950-1995)
    result.put("PLZ", new CurrencyDataImpl("PLZ", "PLZ", 130));
    // Portuguese Escudo
    result.put("PTE", new CurrencyDataImpl("PTE", "Esc", 130));
    // Paraguayan Guarani
    result.put("PYG", new CurrencyDataImpl("PYG", "₲", 0));
    // Qatari Rial
    result.put("QAR", new CurrencyDataImpl("QAR", "QR", 2));
    // Rhodesian Dollar
    result.put("RHD", new CurrencyDataImpl("RHD", "RH$", 130));
    // Old Romanian Leu
    result.put("ROL", new CurrencyDataImpl("ROL", "ROL", 130));
    // Romanian Leu
    result.put("RON", new CurrencyDataImpl("RON", "RON", 2));
    // Serbian Dinar
    result.put("RSD", new CurrencyDataImpl("RSD", "din.", 0));
    // Russian Ruble
    result.put("RUB", new CurrencyDataImpl("RUB", "руб", 2, "руб"));
    // Russian Ruble (1991-1998)
    result.put("RUR", new CurrencyDataImpl("RUR", "RUR", 130));
    // Rwandan Franc
    result.put("RWF", new CurrencyDataImpl("RWF", "RWF", 0));
    // Saudi Riyal
    result.put("SAR", new CurrencyDataImpl("SAR", "SR", 2, "SR"));
    // Solomon Islands Dollar
    result.put("SBD", new CurrencyDataImpl("SBD", "SI$", 2));
    // Seychellois Rupee
    result.put("SCR", new CurrencyDataImpl("SCR", "SRe", 2));
    // Old Sudanese Dinar
    result.put("SDD", new CurrencyDataImpl("SDD", "LSd", 130));
    // Sudanese Pound
    result.put("SDG", new CurrencyDataImpl("SDG", "SDG", 2));
    // Old Sudanese Pound
    result.put("SDP", new CurrencyDataImpl("SDP", "SDP", 130));
    // Swedish Krona
    result.put("SEK", new CurrencyDataImpl("SEK", "Skr", 2, "kr"));
    // Singapore Dollar
    result.put("SGD", new CurrencyDataImpl("SGD", "S$", 2, "S$"));
    // Saint Helena Pound
    result.put("SHP", new CurrencyDataImpl("SHP", "SH£", 2));
    // Slovenian Tolar
    result.put("SIT", new CurrencyDataImpl("SIT", "SIT", 130));
    // Slovak Koruna
    result.put("SKK", new CurrencyDataImpl("SKK", "Sk", 130));
    // Sierra Leonean Leone
    result.put("SLL", new CurrencyDataImpl("SLL", "Le", 0));
    // Somali Shilling
    result.put("SOS", new CurrencyDataImpl("SOS", "Ssh", 0));
    // Surinamese Dollar
    result.put("SRD", new CurrencyDataImpl("SRD", "SR$", 2));
    // Suriname Guilder
    result.put("SRG", new CurrencyDataImpl("SRG", "Sf", 130));
    // São Tomé and Príncipe Dobra
    result.put("STD", new CurrencyDataImpl("STD", "Db", 0));
    // Soviet Rouble
    result.put("SUR", new CurrencyDataImpl("SUR", "SUR", 130));
    // Salvadoran Colón
    result.put("SVC", new CurrencyDataImpl("SVC", "SV₡", 130));
    // Syrian Pound
    result.put("SYP", new CurrencyDataImpl("SYP", "SY£", 0));
    // Swazi Lilangeni
    result.put("SZL", new CurrencyDataImpl("SZL", "SZL", 2));
    // Thai Baht
    result.put("THB", new CurrencyDataImpl("THB", "฿", 2, "THB"));
    // Tajikistani Ruble
    result.put("TJR", new CurrencyDataImpl("TJR", "TJR", 130));
    // Tajikistani Somoni
    result.put("TJS", new CurrencyDataImpl("TJS", "TJS", 2));
    // Turkmenistani Manat
    result.put("TMM", new CurrencyDataImpl("TMM", "TMM", 128));
    // Turkmenistani New Manat
    result.put("TMT", new CurrencyDataImpl("TMT", "TMT", 2));
    // Tunisian Dinar
    result.put("TND", new CurrencyDataImpl("TND", "DT", 3));
    // Tongan Paʻanga
    result.put("TOP", new CurrencyDataImpl("TOP", "T$", 2));
    // Timorese Escudo
    result.put("TPE", new CurrencyDataImpl("TPE", "TPE", 130));
    // Old Turkish Lira
    result.put("TRL", new CurrencyDataImpl("TRL", "TRL", 128));
    // Turkish Lira
    result.put("TRY", new CurrencyDataImpl("TRY", "TL", 2, "YTL"));
    // Trinidad and Tobago Dollar
    result.put("TTD", new CurrencyDataImpl("TTD", "TT$", 2));
    // New Taiwan Dollar
    result.put("TWD", new CurrencyDataImpl("TWD", "NT$", 2, "NT$"));
    // Tanzanian Shilling
    result.put("TZS", new CurrencyDataImpl("TZS", "TSh", 0));
    // Ukrainian Hryvnia
    result.put("UAH", new CurrencyDataImpl("UAH", "₴", 2));
    // Ukrainian Karbovanets
    result.put("UAK", new CurrencyDataImpl("UAK", "UAK", 130));
    // Ugandan Shilling (1966-1987)
    result.put("UGS", new CurrencyDataImpl("UGS", "UGS", 130));
    // Ugandan Shilling
    result.put("UGX", new CurrencyDataImpl("UGX", "USh", 0));
    // US Dollar
    result.put("USD", new CurrencyDataImpl("USD", "$", 2, "US$"));
    // US Dollar (Next day)
    result.put("USN", new CurrencyDataImpl("USN", "USN", 2));
    // US Dollar (Same day)
    result.put("USS", new CurrencyDataImpl("USS", "USS", 2));
    // Uruguayan Peso en Unidades Indexadas
    result.put("UYI", new CurrencyDataImpl("UYI", "UYI", 2));
    // Uruguayan Peso (1975-1993)
    result.put("UYP", new CurrencyDataImpl("UYP", "UYP", 130));
    // Uruguayan Peso
    result.put("UYU", new CurrencyDataImpl("UYU", "$U", 2, "UY$"));
    // Uzbekistan Som
    result.put("UZS", new CurrencyDataImpl("UZS", "UZS", 0));
    // Venezuelan Bolívar
    result.put("VEB", new CurrencyDataImpl("VEB", "VEB", 130));
    // Venezuelan Bolívar Fuerte
    result.put("VEF", new CurrencyDataImpl("VEF", "Bs.F.", 2));
    // Vietnamese Dong
    result.put("VND", new CurrencyDataImpl("VND", "₫", 24, "₫"));
    // Old Vietnamese Dong
    result.put("VNN", new CurrencyDataImpl("VNN", "VNN", 130));
    // Vanuatu Vatu
    result.put("VUV", new CurrencyDataImpl("VUV", "VT", 0));
    // Samoan Tala
    result.put("WST", new CurrencyDataImpl("WST", "WS$", 2));
    // CFA Franc BEAC
    result.put("XAF", new CurrencyDataImpl("XAF", "FCFA", 0));
    // Silver
    result.put("XAG", new CurrencyDataImpl("XAG", "XAG", 2));
    // Gold
    result.put("XAU", new CurrencyDataImpl("XAU", "XAU", 2));
    // European Composite Unit
    result.put("XBA", new CurrencyDataImpl("XBA", "XBA", 2));
    // European Monetary Unit
    result.put("XBB", new CurrencyDataImpl("XBB", "XBB", 2));
    // European Unit of Account (XBC)
    result.put("XBC", new CurrencyDataImpl("XBC", "XBC", 2));
    // European Unit of Account (XBD)
    result.put("XBD", new CurrencyDataImpl("XBD", "XBD", 2));
    // East Caribbean Dollar
    result.put("XCD", new CurrencyDataImpl("XCD", "EC$", 2));
    // Special Drawing Rights
    result.put("XDR", new CurrencyDataImpl("XDR", "XDR", 2));
    // European Currency Unit
    result.put("XEU", new CurrencyDataImpl("XEU", "XEU", 2));
    // French Gold Franc
    result.put("XFO", new CurrencyDataImpl("XFO", "XFO", 2));
    // French UIC-Franc
    result.put("XFU", new CurrencyDataImpl("XFU", "XFU", 2));
    // CFA Franc BCEAO
    result.put("XOF", new CurrencyDataImpl("XOF", "CFA", 0));
    // Palladium
    result.put("XPD", new CurrencyDataImpl("XPD", "XPD", 2));
    // CFP Franc
    result.put("XPF", new CurrencyDataImpl("XPF", "CFPF", 0));
    // Platinum
    result.put("XPT", new CurrencyDataImpl("XPT", "XPT", 2));
    // RINET Funds
    result.put("XRE", new CurrencyDataImpl("XRE", "XRE", 2));
    // Testing Currency Code
    result.put("XTS", new CurrencyDataImpl("XTS", "XTS", 2));
    // Unknown or Invalid Currency
    result.put("XXX", new CurrencyDataImpl("XXX", "XXX", 2));
    // Yemeni Dinar
    result.put("YDD", new CurrencyDataImpl("YDD", "YDD", 130));
    // Yemeni Rial
    result.put("YER", new CurrencyDataImpl("YER", "YR", 0, "YER"));
    // Yugoslavian Hard Dinar
    result.put("YUD", new CurrencyDataImpl("YUD", "YUD", 130));
    // Yugoslavian Noviy Dinar
    result.put("YUM", new CurrencyDataImpl("YUM", "YUM", 130));
    // Yugoslavian Convertible Dinar
    result.put("YUN", new CurrencyDataImpl("YUN", "YUN", 130));
    // Yugoslavian Reformed Dinar
    result.put("YUR", new CurrencyDataImpl("YUR", "YUR", 130));
    // South African Rand (financial)
    result.put("ZAL", new CurrencyDataImpl("ZAL", "ZAL", 2));
    // South African Rand
    result.put("ZAR", new CurrencyDataImpl("ZAR", "R", 2, "ZAR"));
    // Zambian Kwacha
    result.put("ZMK", new CurrencyDataImpl("ZMK", "ZK", 0));
    // Zairean New Zaire
    result.put("ZRN", new CurrencyDataImpl("ZRN", "NZ", 130));
    // Zairean Zaire
    result.put("ZRZ", new CurrencyDataImpl("ZRZ", "ZRZ", 130));
    // Zimbabwean Dollar
    result.put("ZWD", new CurrencyDataImpl("ZWD", "Z$", 128));
    // Zimbabwean Dollar (2009)
    result.put("ZWL", new CurrencyDataImpl("ZWL", "ZWL", 2));
    // Zimbabwean Dollar (2008)
    result.put("ZWR", new CurrencyDataImpl("ZWR", "ZWR", 130));
    return result;
  }
  
  @Override
  protected JavaScriptObject loadCurrencyMapNative() {
    return overrideMap(super.loadCurrencyMapNative(), loadMyCurrencyMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyCurrencyMapOverridesNative() /*-{
    return {
      // Andorran Peseta
      "ADP": [ "ADP", "ADP", 128],
      // United Arab Emirates Dirham
      "AED": [ "AED", "DH", 2, "DH"],
      // Afghan Afghani (1927-2002)
      "AFA": [ "AFA", "AFA", 130],
      // Afghan Afghani
      "AFN": [ "AFN", "Af", 0],
      // Albanian Lek
      "ALL": [ "ALL", "ALL", 0],
      // Armenian Dram
      "AMD": [ "AMD", "AMD", 0],
      // Netherlands Antillean Guilder
      "ANG": [ "ANG", "NAf.", 2],
      // Angolan Kwanza
      "AOA": [ "AOA", "Kz", 2],
      // Angolan Kwanza (1977-1990)
      "AOK": [ "AOK", "AOK", 130],
      // Angolan New Kwanza (1990-2000)
      "AON": [ "AON", "AON", 130],
      // Angolan Kwanza Reajustado (1995-1999)
      "AOR": [ "AOR", "AOR", 130],
      // Argentine Austral
      "ARA": [ "ARA", "₳", 130],
      // Argentine Peso Ley
      "ARL": [ "ARL", "$L", 130],
      // Argentine Peso Moneda Nacional
      "ARM": [ "ARM", "m$n", 130],
      // Argentine Peso (1983-1985)
      "ARP": [ "ARP", "ARP", 130],
      // Argentine Peso
      "ARS": [ "ARS", "AR$", 2, "AR$"],
      // Austrian Schilling
      "ATS": [ "ATS", "ATS", 130],
      // Australian Dollar
      "AUD": [ "AUD", "AU$", 2, "AU$"],
      // Aruban Florin
      "AWG": [ "AWG", "Afl.", 2],
      // Azerbaijani Manat (1993-2006)
      "AZM": [ "AZM", "AZM", 130],
      // Azerbaijani Manat
      "AZN": [ "AZN", "man.", 2],
      // Bosnia-Herzegovina Dinar
      "BAD": [ "BAD", "BAD", 130],
      // Bosnia-Herzegovina Convertible Mark
      "BAM": [ "BAM", "KM", 2],
      // Bosnia-Herzegovina New Dinar
      "BAN": [ "BAN", "BAN", 130],
      // Barbadian Dollar
      "BBD": [ "BBD", "Bds$", 2],
      // Bangladeshi Taka
      "BDT": [ "BDT", "Tk", 2, "Tk"],
      // Belgian Franc (convertible)
      "BEC": [ "BEC", "BEC", 2],
      // Belgian Franc
      "BEF": [ "BEF", "BF", 130],
      // Belgian Franc (financial)
      "BEL": [ "BEL", "BEL", 2],
      // Bulgarian Hard Lev
      "BGL": [ "BGL", "BGL", 130],
      // Bulgarian Socialist Lev
      "BGM": [ "BGM", "BGM", 130],
      // Bulgarian Lev
      "BGN": [ "BGN", "BGN", 2],
      // Old Bulgarian Lev
      "BGO": [ "BGO", "BGO", 130],
      // Bahraini Dinar
      "BHD": [ "BHD", "BD", 3],
      // Burundian Franc
      "BIF": [ "BIF", "FBu", 0],
      // Bermudan Dollar
      "BMD": [ "BMD", "BD$", 2],
      // Brunei Dollar
      "BND": [ "BND", "BN$", 2],
      // Bolivian Boliviano
      "BOB": [ "BOB", "Bs", 2],
      // Old Bolivian Boliviano
      "BOL": [ "BOL", "BOL", 130],
      // Bolivian Peso
      "BOP": [ "BOP", "$b.", 130],
      // Bolivian Mvdol
      "BOV": [ "BOV", "BOV", 2],
      // Brazilian Cruzeiro Novo (1967-1986)
      "BRB": [ "BRB", "BRB", 130],
      // Brazilian Cruzado
      "BRC": [ "BRC", "BRC", 130],
      // Brazilian Cruzeiro (1990-1993)
      "BRE": [ "BRE", "BRE", 130],
      // Brazilian Real
      "BRL": [ "BRL", "R$", 2, "R$"],
      // Brazilian Cruzado Novo
      "BRN": [ "BRN", "BRN", 130],
      // Brazilian Cruzeiro
      "BRR": [ "BRR", "BRR", 130],
      // Old Brazilian Cruzeiro
      "BRZ": [ "BRZ", "BRZ", 130],
      // Bahamian Dollar
      "BSD": [ "BSD", "BS$", 2],
      // Bhutanese Ngultrum
      "BTN": [ "BTN", "Nu.", 2],
      // Burmese Kyat
      "BUK": [ "BUK", "BUK", 130],
      // Botswanan Pula
      "BWP": [ "BWP", "BWP", 2],
      // Belarusian New Ruble (1994-1999)
      "BYB": [ "BYB", "BYB", 130],
      // Belarusian Ruble
      "BYR": [ "BYR", "BYR", 0],
      // Belize Dollar
      "BZD": [ "BZD", "BZ$", 2],
      // Canadian Dollar
      "CAD": [ "CAD", "CA$", 2, "C$"],
      // Congolese Franc
      "CDF": [ "CDF", "CDF", 2],
      // WIR Euro
      "CHE": [ "CHE", "CHE", 2],
      // Swiss Franc
      "CHF": [ "CHF", "Fr.", 2, "CHF"],
      // WIR Franc
      "CHW": [ "CHW", "CHW", 2],
      // Chilean Escudo
      "CLE": [ "CLE", "Eº", 130],
      // Chilean Unidades de Fomento
      "CLF": [ "CLF", "CLF", 0],
      // Chilean Peso
      "CLP": [ "CLP", "CL$", 0, "CL$"],
      // Chinese Yuan Renminbi
      "CNY": [ "CNY", "CN¥", 2, "RMB¥"],
      // Colombian Peso
      "COP": [ "COP", "CO$", 0, "COL$"],
      // Unidad de Valor Real
      "COU": [ "COU", "COU", 2],
      // Costa Rican Colón
      "CRC": [ "CRC", "₡", 0, "CR₡"],
      // Old Serbian Dinar
      "CSD": [ "CSD", "CSD", 130],
      // Czechoslovak Hard Koruna
      "CSK": [ "CSK", "CSK", 130],
      // Cuban Convertible Peso
      "CUC": [ "CUC", "CUC$", 2],
      // Cuban Peso
      "CUP": [ "CUP", "CU$", 2, "$MN"],
      // Cape Verdean Escudo
      "CVE": [ "CVE", "CV$", 2],
      // Cypriot Pound
      "CYP": [ "CYP", "CY£", 130],
      // Czech Republic Koruna
      "CZK": [ "CZK", "Kč", 2, "Kč"],
      // East German Mark
      "DDM": [ "DDM", "DDM", 130],
      // German Mark
      "DEM": [ "DEM", "DM", 130],
      // Djiboutian Franc
      "DJF": [ "DJF", "Fdj", 0],
      // Danish Krone
      "DKK": [ "DKK", "Dkr", 2, "kr"],
      // Dominican Peso
      "DOP": [ "DOP", "RD$", 2, "RD$"],
      // Algerian Dinar
      "DZD": [ "DZD", "DA", 2],
      // Ecuadorian Sucre
      "ECS": [ "ECS", "ECS", 130],
      // Ecuadorian Unidad de Valor Constante (UVC)
      "ECV": [ "ECV", "ECV", 2],
      // Estonian Kroon
      "EEK": [ "EEK", "Ekr", 2],
      // Egyptian Pound
      "EGP": [ "EGP", "EG£", 2, "LE"],
      // EQE
      "EQE": [ "EQE", "EQE", 130],
      // Eritrean Nakfa
      "ERN": [ "ERN", "Nfk", 2],
      // Spanish Peseta (A account)
      "ESA": [ "ESA", "ESA", 2],
      // Spanish Peseta (convertible account)
      "ESB": [ "ESB", "ESB", 2],
      // Spanish Peseta
      "ESP": [ "ESP", "Pts", 128],
      // Ethiopian Birr
      "ETB": [ "ETB", "Br", 2],
      // Euro
      "EUR": [ "EUR", "€", 2, "€"],
      // Finnish Markka
      "FIM": [ "FIM", "mk", 130],
      // Fijian Dollar
      "FJD": [ "FJD", "FJ$", 2],
      // Falkland Islands Pound
      "FKP": [ "FKP", "FK£", 2],
      // French Franc
      "FRF": [ "FRF", "₣", 130],
      // British Pound Sterling
      "GBP": [ "GBP", "£", 2, "GB£"],
      // Georgian Kupon Larit
      "GEK": [ "GEK", "GEK", 130],
      // Georgian Lari
      "GEL": [ "GEL", "GEL", 2],
      // Ghanaian Cedi (1979-2007)
      "GHC": [ "GHC", "₵", 130],
      // Ghanaian Cedi
      "GHS": [ "GHS", "GH₵", 2],
      // Gibraltar Pound
      "GIP": [ "GIP", "GI£", 2],
      // Gambian Dalasi
      "GMD": [ "GMD", "GMD", 2],
      // Guinean Franc
      "GNF": [ "GNF", "FG", 0],
      // Guinean Syli
      "GNS": [ "GNS", "GNS", 130],
      // Equatorial Guinean Ekwele
      "GQE": [ "GQE", "GQE", 130],
      // Greek Drachma
      "GRD": [ "GRD", "₯", 130],
      // Guatemalan Quetzal
      "GTQ": [ "GTQ", "GTQ", 2],
      // Portuguese Guinea Escudo
      "GWE": [ "GWE", "GWE", 130],
      // Guinea-Bissau Peso
      "GWP": [ "GWP", "GWP", 2],
      // Guyanaese Dollar
      "GYD": [ "GYD", "GY$", 0],
      // Hong Kong Dollar
      "HKD": [ "HKD", "HK$", 2, "HK$"],
      // Honduran Lempira
      "HNL": [ "HNL", "HNL", 2],
      // Croatian Dinar
      "HRD": [ "HRD", "HRD", 130],
      // Croatian Kuna
      "HRK": [ "HRK", "kn", 2],
      // Haitian Gourde
      "HTG": [ "HTG", "HTG", 2],
      // Hungarian Forint
      "HUF": [ "HUF", "Ft", 0],
      // Indonesian Rupiah
      "IDR": [ "IDR", "Rp", 0],
      // Irish Pound
      "IEP": [ "IEP", "IR£", 130],
      // Israeli Pound
      "ILP": [ "ILP", "I£", 130],
      // Old Israeli Sheqel
      "ILR": [ "ILR", "ILR", 130],
      // Israeli New Sheqel
      "ILS": [ "ILS", "₪", 2, "IL₪"],
      // Indian Rupee
      "INR": [ "INR", "Rs", 2, "Rs"],
      // Iraqi Dinar
      "IQD": [ "IQD", "IQD", 0],
      // Iranian Rial
      "IRR": [ "IRR", "IRR", 0],
      // Old Icelandic Króna
      "ISJ": [ "ISJ", "ISJ", 130],
      // Icelandic Króna
      "ISK": [ "ISK", "Ikr", 0, "kr"],
      // Italian Lira
      "ITL": [ "ITL", "IT₤", 128],
      // Jamaican Dollar
      "JMD": [ "JMD", "J$", 2, "JA$"],
      // Jordanian Dinar
      "JOD": [ "JOD", "JD", 3],
      // Japanese Yen
      "JPY": [ "JPY", "¥", 0, "JP¥"],
      // Kenyan Shilling
      "KES": [ "KES", "Ksh", 2],
      // Kyrgystani Som
      "KGS": [ "KGS", "KGS", 2],
      // Cambodian Riel
      "KHR": [ "KHR", "KHR", 2],
      // Comorian Franc
      "KMF": [ "KMF", "CF", 0],
      // North Korean Won
      "KPW": [ "KPW", "KPW", 0],
      // South Korean Hwan
      "KRH": [ "KRH", "KRH", 130],
      // Old South Korean Won
      "KRO": [ "KRO", "KRO", 130],
      // South Korean Won
      "KRW": [ "KRW", "₩", 0, "KR₩"],
      // Kuwaiti Dinar
      "KWD": [ "KWD", "KD", 3],
      // Cayman Islands Dollar
      "KYD": [ "KYD", "KY$", 2],
      // Kazakhstan Tenge
      "KZT": [ "KZT", "KZT", 2],
      // Laotian Kip
      "LAK": [ "LAK", "₭", 0],
      // Lebanese Pound
      "LBP": [ "LBP", "LB£", 0],
      // Sri Lanka Rupee
      "LKR": [ "LKR", "SLRs", 2, "SLRs"],
      // Liberian Dollar
      "LRD": [ "LRD", "L$", 2],
      // Lesotho Loti
      "LSL": [ "LSL", "LSL", 2],
      // LSM
      "LSM": [ "LSM", "LSM", 130],
      // Lithuanian Litas
      "LTL": [ "LTL", "Lt", 2],
      // Lithuanian Talonas
      "LTT": [ "LTT", "LTT", 130],
      // Luxembourgian Convertible Franc
      "LUC": [ "LUC", "LUC", 2],
      // Luxembourgian Franc
      "LUF": [ "LUF", "LUF", 128],
      // Luxembourg Financial Franc
      "LUL": [ "LUL", "LUL", 2],
      // Latvian Lats
      "LVL": [ "LVL", "Ls", 2],
      // Latvian Ruble
      "LVR": [ "LVR", "LVR", 130],
      // Libyan Dinar
      "LYD": [ "LYD", "LD", 3],
      // Moroccan Dirham
      "MAD": [ "MAD", "MAD", 2],
      // Moroccan Franc
      "MAF": [ "MAF", "MAF", 130],
      // Monegasque Franc
      "MCF": [ "MCF", "MCF", 130],
      // Moldovan Cupon
      "MDC": [ "MDC", "MDC", 130],
      // Moldovan Leu
      "MDL": [ "MDL", "MDL", 2],
      // Malagasy Ariary
      "MGA": [ "MGA", "MGA", 0],
      // Malagasy Franc
      "MGF": [ "MGF", "MGF", 128],
      // Macedonian Denar
      "MKD": [ "MKD", "MKD", 2],
      // Old Macedonian Denar
      "MKN": [ "MKN", "MKN", 130],
      // Malian Franc
      "MLF": [ "MLF", "MLF", 130],
      // Myanma Kyat
      "MMK": [ "MMK", "MMK", 0],
      // Mongolian Tugrik
      "MNT": [ "MNT", "₮", 0, "MN₮"],
      // Macanese Pataca
      "MOP": [ "MOP", "MOP$", 2],
      // Mauritanian Ouguiya
      "MRO": [ "MRO", "UM", 0],
      // Maltese Lira
      "MTL": [ "MTL", "Lm", 130],
      // Maltese Pound
      "MTP": [ "MTP", "MT£", 130],
      // Mauritian Rupee
      "MUR": [ "MUR", "MURs", 0],
      // Maldivian Rupee
      "MVP": [ "MVP", "MVP", 130],
      // Maldivian Rufiyaa
      "MVR": [ "MVR", "MVR", 2],
      // Malawian Kwacha
      "MWK": [ "MWK", "MWK", 2],
      // Mexican Peso
      "MXN": [ "MXN", "Mex$", 2, "Mex$"],
      // Mexican Silver Peso (1861-1992)
      "MXP": [ "MXP", "MX$", 130],
      // Mexican Unidad de Inversion (UDI)
      "MXV": [ "MXV", "MXV", 2],
      // Malaysian Ringgit
      "MYR": [ "MYR", "RM", 2, "RM"],
      // Mozambican Escudo
      "MZE": [ "MZE", "MZE", 130],
      // Old Mozambican Metical
      "MZM": [ "MZM", "Mt", 130],
      // Mozambican Metical
      "MZN": [ "MZN", "MTn", 2],
      // Namibian Dollar
      "NAD": [ "NAD", "N$", 2],
      // Nigerian Naira
      "NGN": [ "NGN", "₦", 2],
      // Nicaraguan Cordoba
      "NIC": [ "NIC", "NIC", 130],
      // Nicaraguan Cordoba Oro
      "NIO": [ "NIO", "C$", 2],
      // Dutch Guilder
      "NLG": [ "NLG", "fl", 130],
      // Norwegian Krone
      "NOK": [ "NOK", "Nkr", 2, "NOkr"],
      // Nepalese Rupee
      "NPR": [ "NPR", "NPRs", 2],
      // New Zealand Dollar
      "NZD": [ "NZD", "NZ$", 2],
      // Omani Rial
      "OMR": [ "OMR", "OMR", 3],
      // Panamanian Balboa
      "PAB": [ "PAB", "B/.", 2, "B/."],
      // Peruvian Inti
      "PEI": [ "PEI", "I/.", 130],
      // Peruvian Nuevo Sol
      "PEN": [ "PEN", "S/.", 2, "S/."],
      // Peruvian Sol
      "PES": [ "PES", "PES", 130],
      // Papua New Guinean Kina
      "PGK": [ "PGK", "PGK", 2],
      // Philippine Peso
      "PHP": [ "PHP", "₱", 2, "PHP"],
      // Pakistani Rupee
      "PKR": [ "PKR", "PKRs", 0, "PKRs."],
      // Polish Zloty
      "PLN": [ "PLN", "zł", 2],
      // Polish Zloty (1950-1995)
      "PLZ": [ "PLZ", "PLZ", 130],
      // Portuguese Escudo
      "PTE": [ "PTE", "Esc", 130],
      // Paraguayan Guarani
      "PYG": [ "PYG", "₲", 0],
      // Qatari Rial
      "QAR": [ "QAR", "QR", 2],
      // Rhodesian Dollar
      "RHD": [ "RHD", "RH$", 130],
      // Old Romanian Leu
      "ROL": [ "ROL", "ROL", 130],
      // Romanian Leu
      "RON": [ "RON", "RON", 2],
      // Serbian Dinar
      "RSD": [ "RSD", "din.", 0],
      // Russian Ruble
      "RUB": [ "RUB", "руб", 2, "руб"],
      // Russian Ruble (1991-1998)
      "RUR": [ "RUR", "RUR", 130],
      // Rwandan Franc
      "RWF": [ "RWF", "RWF", 0],
      // Saudi Riyal
      "SAR": [ "SAR", "SR", 2, "SR"],
      // Solomon Islands Dollar
      "SBD": [ "SBD", "SI$", 2],
      // Seychellois Rupee
      "SCR": [ "SCR", "SRe", 2],
      // Old Sudanese Dinar
      "SDD": [ "SDD", "LSd", 130],
      // Sudanese Pound
      "SDG": [ "SDG", "SDG", 2],
      // Old Sudanese Pound
      "SDP": [ "SDP", "SDP", 130],
      // Swedish Krona
      "SEK": [ "SEK", "Skr", 2, "kr"],
      // Singapore Dollar
      "SGD": [ "SGD", "S$", 2, "S$"],
      // Saint Helena Pound
      "SHP": [ "SHP", "SH£", 2],
      // Slovenian Tolar
      "SIT": [ "SIT", "SIT", 130],
      // Slovak Koruna
      "SKK": [ "SKK", "Sk", 130],
      // Sierra Leonean Leone
      "SLL": [ "SLL", "Le", 0],
      // Somali Shilling
      "SOS": [ "SOS", "Ssh", 0],
      // Surinamese Dollar
      "SRD": [ "SRD", "SR$", 2],
      // Suriname Guilder
      "SRG": [ "SRG", "Sf", 130],
      // São Tomé and Príncipe Dobra
      "STD": [ "STD", "Db", 0],
      // Soviet Rouble
      "SUR": [ "SUR", "SUR", 130],
      // Salvadoran Colón
      "SVC": [ "SVC", "SV₡", 130],
      // Syrian Pound
      "SYP": [ "SYP", "SY£", 0],
      // Swazi Lilangeni
      "SZL": [ "SZL", "SZL", 2],
      // Thai Baht
      "THB": [ "THB", "฿", 2, "THB"],
      // Tajikistani Ruble
      "TJR": [ "TJR", "TJR", 130],
      // Tajikistani Somoni
      "TJS": [ "TJS", "TJS", 2],
      // Turkmenistani Manat
      "TMM": [ "TMM", "TMM", 128],
      // Turkmenistani New Manat
      "TMT": [ "TMT", "TMT", 2],
      // Tunisian Dinar
      "TND": [ "TND", "DT", 3],
      // Tongan Paʻanga
      "TOP": [ "TOP", "T$", 2],
      // Timorese Escudo
      "TPE": [ "TPE", "TPE", 130],
      // Old Turkish Lira
      "TRL": [ "TRL", "TRL", 128],
      // Turkish Lira
      "TRY": [ "TRY", "TL", 2, "YTL"],
      // Trinidad and Tobago Dollar
      "TTD": [ "TTD", "TT$", 2],
      // New Taiwan Dollar
      "TWD": [ "TWD", "NT$", 2, "NT$"],
      // Tanzanian Shilling
      "TZS": [ "TZS", "TSh", 0],
      // Ukrainian Hryvnia
      "UAH": [ "UAH", "₴", 2],
      // Ukrainian Karbovanets
      "UAK": [ "UAK", "UAK", 130],
      // Ugandan Shilling (1966-1987)
      "UGS": [ "UGS", "UGS", 130],
      // Ugandan Shilling
      "UGX": [ "UGX", "USh", 0],
      // US Dollar
      "USD": [ "USD", "$", 2, "US$"],
      // US Dollar (Next day)
      "USN": [ "USN", "USN", 2],
      // US Dollar (Same day)
      "USS": [ "USS", "USS", 2],
      // Uruguayan Peso en Unidades Indexadas
      "UYI": [ "UYI", "UYI", 2],
      // Uruguayan Peso (1975-1993)
      "UYP": [ "UYP", "UYP", 130],
      // Uruguayan Peso
      "UYU": [ "UYU", "$U", 2, "UY$"],
      // Uzbekistan Som
      "UZS": [ "UZS", "UZS", 0],
      // Venezuelan Bolívar
      "VEB": [ "VEB", "VEB", 130],
      // Venezuelan Bolívar Fuerte
      "VEF": [ "VEF", "Bs.F.", 2],
      // Vietnamese Dong
      "VND": [ "VND", "₫", 24, "₫"],
      // Old Vietnamese Dong
      "VNN": [ "VNN", "VNN", 130],
      // Vanuatu Vatu
      "VUV": [ "VUV", "VT", 0],
      // Samoan Tala
      "WST": [ "WST", "WS$", 2],
      // CFA Franc BEAC
      "XAF": [ "XAF", "FCFA", 0],
      // Silver
      "XAG": [ "XAG", "XAG", 2],
      // Gold
      "XAU": [ "XAU", "XAU", 2],
      // European Composite Unit
      "XBA": [ "XBA", "XBA", 2],
      // European Monetary Unit
      "XBB": [ "XBB", "XBB", 2],
      // European Unit of Account (XBC)
      "XBC": [ "XBC", "XBC", 2],
      // European Unit of Account (XBD)
      "XBD": [ "XBD", "XBD", 2],
      // East Caribbean Dollar
      "XCD": [ "XCD", "EC$", 2],
      // Special Drawing Rights
      "XDR": [ "XDR", "XDR", 2],
      // European Currency Unit
      "XEU": [ "XEU", "XEU", 2],
      // French Gold Franc
      "XFO": [ "XFO", "XFO", 2],
      // French UIC-Franc
      "XFU": [ "XFU", "XFU", 2],
      // CFA Franc BCEAO
      "XOF": [ "XOF", "CFA", 0],
      // Palladium
      "XPD": [ "XPD", "XPD", 2],
      // CFP Franc
      "XPF": [ "XPF", "CFPF", 0],
      // Platinum
      "XPT": [ "XPT", "XPT", 2],
      // RINET Funds
      "XRE": [ "XRE", "XRE", 2],
      // Testing Currency Code
      "XTS": [ "XTS", "XTS", 2],
      // Unknown or Invalid Currency
      "XXX": [ "XXX", "XXX", 2],
      // Yemeni Dinar
      "YDD": [ "YDD", "YDD", 130],
      // Yemeni Rial
      "YER": [ "YER", "YR", 0, "YER"],
      // Yugoslavian Hard Dinar
      "YUD": [ "YUD", "YUD", 130],
      // Yugoslavian Noviy Dinar
      "YUM": [ "YUM", "YUM", 130],
      // Yugoslavian Convertible Dinar
      "YUN": [ "YUN", "YUN", 130],
      // Yugoslavian Reformed Dinar
      "YUR": [ "YUR", "YUR", 130],
      // South African Rand (financial)
      "ZAL": [ "ZAL", "ZAL", 2],
      // South African Rand
      "ZAR": [ "ZAR", "R", 2, "ZAR"],
      // Zambian Kwacha
      "ZMK": [ "ZMK", "ZK", 0],
      // Zairean New Zaire
      "ZRN": [ "ZRN", "NZ", 130],
      // Zairean Zaire
      "ZRZ": [ "ZRZ", "ZRZ", 130],
      // Zimbabwean Dollar
      "ZWD": [ "ZWD", "Z$", 128],
      // Zimbabwean Dollar (2009)
      "ZWL": [ "ZWL", "ZWL", 2],
      // Zimbabwean Dollar (2008)
      "ZWR": [ "ZWR", "ZWR", 130],
    };
  }-*/;
  
  @Override
  protected HashMap<String, String> loadNamesMapJava() {
    HashMap<String, String> result = super.loadNamesMapJava();
    result.put("ADP", "Andorran Peseta");
    result.put("AED", "United Arab Emirates Dirham");
    result.put("AFA", "Afghan Afghani (1927-2002)");
    result.put("AFN", "Afghan Afghani");
    result.put("ALL", "Albanian Lek");
    result.put("AMD", "Armenian Dram");
    result.put("ANG", "Netherlands Antillean Guilder");
    result.put("AOA", "Angolan Kwanza");
    result.put("AOK", "Angolan Kwanza (1977-1990)");
    result.put("AON", "Angolan New Kwanza (1990-2000)");
    result.put("AOR", "Angolan Kwanza Reajustado (1995-1999)");
    result.put("ARA", "Argentine Austral");
    result.put("ARL", "Argentine Peso Ley");
    result.put("ARM", "Argentine Peso Moneda Nacional");
    result.put("ARP", "Argentine Peso (1983-1985)");
    result.put("ARS", "Argentine Peso");
    result.put("ATS", "Austrian Schilling");
    result.put("AUD", "Australian Dollar");
    result.put("AWG", "Aruban Florin");
    result.put("AZM", "Azerbaijani Manat (1993-2006)");
    result.put("AZN", "Azerbaijani Manat");
    result.put("BAD", "Bosnia-Herzegovina Dinar");
    result.put("BAM", "Bosnia-Herzegovina Convertible Mark");
    result.put("BAN", "Bosnia-Herzegovina New Dinar");
    result.put("BBD", "Barbadian Dollar");
    result.put("BDT", "Bangladeshi Taka");
    result.put("BEC", "Belgian Franc (convertible)");
    result.put("BEF", "Belgian Franc");
    result.put("BEL", "Belgian Franc (financial)");
    result.put("BGL", "Bulgarian Hard Lev");
    result.put("BGM", "Bulgarian Socialist Lev");
    result.put("BGN", "Bulgarian Lev");
    result.put("BGO", "Old Bulgarian Lev");
    result.put("BHD", "Bahraini Dinar");
    result.put("BIF", "Burundian Franc");
    result.put("BMD", "Bermudan Dollar");
    result.put("BND", "Brunei Dollar");
    result.put("BOB", "Bolivian Boliviano");
    result.put("BOL", "Old Bolivian Boliviano");
    result.put("BOP", "Bolivian Peso");
    result.put("BOV", "Bolivian Mvdol");
    result.put("BRB", "Brazilian Cruzeiro Novo (1967-1986)");
    result.put("BRC", "Brazilian Cruzado");
    result.put("BRE", "Brazilian Cruzeiro (1990-1993)");
    result.put("BRL", "Brazilian Real");
    result.put("BRN", "Brazilian Cruzado Novo");
    result.put("BRR", "Brazilian Cruzeiro");
    result.put("BRZ", "Old Brazilian Cruzeiro");
    result.put("BSD", "Bahamian Dollar");
    result.put("BTN", "Bhutanese Ngultrum");
    result.put("BUK", "Burmese Kyat");
    result.put("BWP", "Botswanan Pula");
    result.put("BYB", "Belarusian New Ruble (1994-1999)");
    result.put("BYR", "Belarusian Ruble");
    result.put("BZD", "Belize Dollar");
    result.put("CAD", "Canadian Dollar");
    result.put("CDF", "Congolese Franc");
    result.put("CHE", "WIR Euro");
    result.put("CHF", "Swiss Franc");
    result.put("CHW", "WIR Franc");
    result.put("CLE", "Chilean Escudo");
    result.put("CLF", "Chilean Unidades de Fomento");
    result.put("CLP", "Chilean Peso");
    result.put("CNY", "Chinese Yuan Renminbi");
    result.put("COP", "Colombian Peso");
    result.put("COU", "Unidad de Valor Real");
    result.put("CRC", "Costa Rican Colón");
    result.put("CSD", "Old Serbian Dinar");
    result.put("CSK", "Czechoslovak Hard Koruna");
    result.put("CUC", "Cuban Convertible Peso");
    result.put("CUP", "Cuban Peso");
    result.put("CVE", "Cape Verdean Escudo");
    result.put("CYP", "Cypriot Pound");
    result.put("CZK", "Czech Republic Koruna");
    result.put("DDM", "East German Mark");
    result.put("DEM", "German Mark");
    result.put("DJF", "Djiboutian Franc");
    result.put("DKK", "Danish Krone");
    result.put("DOP", "Dominican Peso");
    result.put("DZD", "Algerian Dinar");
    result.put("ECS", "Ecuadorian Sucre");
    result.put("ECV", "Ecuadorian Unidad de Valor Constante (UVC)");
    result.put("EEK", "Estonian Kroon");
    result.put("EGP", "Egyptian Pound");
    result.put("ERN", "Eritrean Nakfa");
    result.put("ESA", "Spanish Peseta (A account)");
    result.put("ESB", "Spanish Peseta (convertible account)");
    result.put("ESP", "Spanish Peseta");
    result.put("ETB", "Ethiopian Birr");
    result.put("EUR", "Euro");
    result.put("FIM", "Finnish Markka");
    result.put("FJD", "Fijian Dollar");
    result.put("FKP", "Falkland Islands Pound");
    result.put("FRF", "French Franc");
    result.put("GBP", "British Pound Sterling");
    result.put("GEK", "Georgian Kupon Larit");
    result.put("GEL", "Georgian Lari");
    result.put("GHC", "Ghanaian Cedi (1979-2007)");
    result.put("GHS", "Ghanaian Cedi");
    result.put("GIP", "Gibraltar Pound");
    result.put("GMD", "Gambian Dalasi");
    result.put("GNF", "Guinean Franc");
    result.put("GNS", "Guinean Syli");
    result.put("GQE", "Equatorial Guinean Ekwele");
    result.put("GRD", "Greek Drachma");
    result.put("GTQ", "Guatemalan Quetzal");
    result.put("GWE", "Portuguese Guinea Escudo");
    result.put("GWP", "Guinea-Bissau Peso");
    result.put("GYD", "Guyanaese Dollar");
    result.put("HKD", "Hong Kong Dollar");
    result.put("HNL", "Honduran Lempira");
    result.put("HRD", "Croatian Dinar");
    result.put("HRK", "Croatian Kuna");
    result.put("HTG", "Haitian Gourde");
    result.put("HUF", "Hungarian Forint");
    result.put("IDR", "Indonesian Rupiah");
    result.put("IEP", "Irish Pound");
    result.put("ILP", "Israeli Pound");
    result.put("ILR", "Old Israeli Sheqel");
    result.put("ILS", "Israeli New Sheqel");
    result.put("INR", "Indian Rupee");
    result.put("IQD", "Iraqi Dinar");
    result.put("IRR", "Iranian Rial");
    result.put("ISJ", "Old Icelandic Króna");
    result.put("ISK", "Icelandic Króna");
    result.put("ITL", "Italian Lira");
    result.put("JMD", "Jamaican Dollar");
    result.put("JOD", "Jordanian Dinar");
    result.put("JPY", "Japanese Yen");
    result.put("KES", "Kenyan Shilling");
    result.put("KGS", "Kyrgystani Som");
    result.put("KHR", "Cambodian Riel");
    result.put("KMF", "Comorian Franc");
    result.put("KPW", "North Korean Won");
    result.put("KRH", "South Korean Hwan");
    result.put("KRO", "Old South Korean Won");
    result.put("KRW", "South Korean Won");
    result.put("KWD", "Kuwaiti Dinar");
    result.put("KYD", "Cayman Islands Dollar");
    result.put("KZT", "Kazakhstan Tenge");
    result.put("LAK", "Laotian Kip");
    result.put("LBP", "Lebanese Pound");
    result.put("LKR", "Sri Lanka Rupee");
    result.put("LRD", "Liberian Dollar");
    result.put("LSL", "Lesotho Loti");
    result.put("LTL", "Lithuanian Litas");
    result.put("LTT", "Lithuanian Talonas");
    result.put("LUC", "Luxembourgian Convertible Franc");
    result.put("LUF", "Luxembourgian Franc");
    result.put("LUL", "Luxembourg Financial Franc");
    result.put("LVL", "Latvian Lats");
    result.put("LVR", "Latvian Ruble");
    result.put("LYD", "Libyan Dinar");
    result.put("MAD", "Moroccan Dirham");
    result.put("MAF", "Moroccan Franc");
    result.put("MCF", "Monegasque Franc");
    result.put("MDC", "Moldovan Cupon");
    result.put("MDL", "Moldovan Leu");
    result.put("MGA", "Malagasy Ariary");
    result.put("MGF", "Malagasy Franc");
    result.put("MKD", "Macedonian Denar");
    result.put("MKN", "Old Macedonian Denar");
    result.put("MLF", "Malian Franc");
    result.put("MMK", "Myanma Kyat");
    result.put("MNT", "Mongolian Tugrik");
    result.put("MOP", "Macanese Pataca");
    result.put("MRO", "Mauritanian Ouguiya");
    result.put("MTL", "Maltese Lira");
    result.put("MTP", "Maltese Pound");
    result.put("MUR", "Mauritian Rupee");
    result.put("MVP", "Maldivian Rupee");
    result.put("MVR", "Maldivian Rufiyaa");
    result.put("MWK", "Malawian Kwacha");
    result.put("MXN", "Mexican Peso");
    result.put("MXP", "Mexican Silver Peso (1861-1992)");
    result.put("MXV", "Mexican Unidad de Inversion (UDI)");
    result.put("MYR", "Malaysian Ringgit");
    result.put("MZE", "Mozambican Escudo");
    result.put("MZM", "Old Mozambican Metical");
    result.put("MZN", "Mozambican Metical");
    result.put("NAD", "Namibian Dollar");
    result.put("NGN", "Nigerian Naira");
    result.put("NIC", "Nicaraguan Cordoba");
    result.put("NIO", "Nicaraguan Cordoba Oro");
    result.put("NLG", "Dutch Guilder");
    result.put("NOK", "Norwegian Krone");
    result.put("NPR", "Nepalese Rupee");
    result.put("NZD", "New Zealand Dollar");
    result.put("OMR", "Omani Rial");
    result.put("PAB", "Panamanian Balboa");
    result.put("PEI", "Peruvian Inti");
    result.put("PEN", "Peruvian Nuevo Sol");
    result.put("PES", "Peruvian Sol");
    result.put("PGK", "Papua New Guinean Kina");
    result.put("PHP", "Philippine Peso");
    result.put("PKR", "Pakistani Rupee");
    result.put("PLN", "Polish Zloty");
    result.put("PLZ", "Polish Zloty (1950-1995)");
    result.put("PTE", "Portuguese Escudo");
    result.put("PYG", "Paraguayan Guarani");
    result.put("QAR", "Qatari Rial");
    result.put("RHD", "Rhodesian Dollar");
    result.put("ROL", "Old Romanian Leu");
    result.put("RON", "Romanian Leu");
    result.put("RSD", "Serbian Dinar");
    result.put("RUB", "Russian Ruble");
    result.put("RUR", "Russian Ruble (1991-1998)");
    result.put("RWF", "Rwandan Franc");
    result.put("SAR", "Saudi Riyal");
    result.put("SBD", "Solomon Islands Dollar");
    result.put("SCR", "Seychellois Rupee");
    result.put("SDD", "Old Sudanese Dinar");
    result.put("SDG", "Sudanese Pound");
    result.put("SDP", "Old Sudanese Pound");
    result.put("SEK", "Swedish Krona");
    result.put("SGD", "Singapore Dollar");
    result.put("SHP", "Saint Helena Pound");
    result.put("SIT", "Slovenian Tolar");
    result.put("SKK", "Slovak Koruna");
    result.put("SLL", "Sierra Leonean Leone");
    result.put("SOS", "Somali Shilling");
    result.put("SRD", "Surinamese Dollar");
    result.put("SRG", "Suriname Guilder");
    result.put("STD", "São Tomé and Príncipe Dobra");
    result.put("SUR", "Soviet Rouble");
    result.put("SVC", "Salvadoran Colón");
    result.put("SYP", "Syrian Pound");
    result.put("SZL", "Swazi Lilangeni");
    result.put("THB", "Thai Baht");
    result.put("TJR", "Tajikistani Ruble");
    result.put("TJS", "Tajikistani Somoni");
    result.put("TMM", "Turkmenistani Manat");
    result.put("TMT", "Turkmenistani New Manat");
    result.put("TND", "Tunisian Dinar");
    result.put("TOP", "Tongan Paʻanga");
    result.put("TPE", "Timorese Escudo");
    result.put("TRL", "Old Turkish Lira");
    result.put("TRY", "Turkish Lira");
    result.put("TTD", "Trinidad and Tobago Dollar");
    result.put("TWD", "New Taiwan Dollar");
    result.put("TZS", "Tanzanian Shilling");
    result.put("UAH", "Ukrainian Hryvnia");
    result.put("UAK", "Ukrainian Karbovanets");
    result.put("UGS", "Ugandan Shilling (1966-1987)");
    result.put("UGX", "Ugandan Shilling");
    result.put("USD", "US Dollar");
    result.put("USN", "US Dollar (Next day)");
    result.put("USS", "US Dollar (Same day)");
    result.put("UYI", "Uruguayan Peso en Unidades Indexadas");
    result.put("UYP", "Uruguayan Peso (1975-1993)");
    result.put("UYU", "Uruguayan Peso");
    result.put("UZS", "Uzbekistan Som");
    result.put("VEB", "Venezuelan Bolívar");
    result.put("VEF", "Venezuelan Bolívar Fuerte");
    result.put("VND", "Vietnamese Dong");
    result.put("VNN", "Old Vietnamese Dong");
    result.put("VUV", "Vanuatu Vatu");
    result.put("WST", "Samoan Tala");
    result.put("XAF", "CFA Franc BEAC");
    result.put("XAG", "Silver");
    result.put("XAU", "Gold");
    result.put("XBA", "European Composite Unit");
    result.put("XBB", "European Monetary Unit");
    result.put("XBC", "European Unit of Account (XBC)");
    result.put("XBD", "European Unit of Account (XBD)");
    result.put("XCD", "East Caribbean Dollar");
    result.put("XDR", "Special Drawing Rights");
    result.put("XEU", "European Currency Unit");
    result.put("XFO", "French Gold Franc");
    result.put("XFU", "French UIC-Franc");
    result.put("XOF", "CFA Franc BCEAO");
    result.put("XPD", "Palladium");
    result.put("XPF", "CFP Franc");
    result.put("XPT", "Platinum");
    result.put("XRE", "RINET Funds");
    result.put("XTS", "Testing Currency Code");
    result.put("XXX", "Unknown or Invalid Currency");
    result.put("YDD", "Yemeni Dinar");
    result.put("YER", "Yemeni Rial");
    result.put("YUD", "Yugoslavian Hard Dinar");
    result.put("YUM", "Yugoslavian Noviy Dinar");
    result.put("YUN", "Yugoslavian Convertible Dinar");
    result.put("YUR", "Yugoslavian Reformed Dinar");
    result.put("ZAL", "South African Rand (financial)");
    result.put("ZAR", "South African Rand");
    result.put("ZMK", "Zambian Kwacha");
    result.put("ZRN", "Zairean New Zaire");
    result.put("ZRZ", "Zairean Zaire");
    result.put("ZWD", "Zimbabwean Dollar");
    result.put("ZWL", "Zimbabwean Dollar (2009)");
    result.put("ZWR", "Zimbabwean Dollar (2008)");
    return result;
  }
  
  @Override
  protected JavaScriptObject loadNamesMapNative() {
    return overrideMap(super.loadNamesMapNative(), loadMyNamesMapOverridesNative());
  }
  
  private native JavaScriptObject loadMyNamesMapOverridesNative() /*-{
    return {
      "ADP": "Andorran Peseta",
      "AED": "United Arab Emirates Dirham",
      "AFA": "Afghan Afghani (1927-2002)",
      "AFN": "Afghan Afghani",
      "ALL": "Albanian Lek",
      "AMD": "Armenian Dram",
      "ANG": "Netherlands Antillean Guilder",
      "AOA": "Angolan Kwanza",
      "AOK": "Angolan Kwanza (1977-1990)",
      "AON": "Angolan New Kwanza (1990-2000)",
      "AOR": "Angolan Kwanza Reajustado (1995-1999)",
      "ARA": "Argentine Austral",
      "ARL": "Argentine Peso Ley",
      "ARM": "Argentine Peso Moneda Nacional",
      "ARP": "Argentine Peso (1983-1985)",
      "ARS": "Argentine Peso",
      "ATS": "Austrian Schilling",
      "AUD": "Australian Dollar",
      "AWG": "Aruban Florin",
      "AZM": "Azerbaijani Manat (1993-2006)",
      "AZN": "Azerbaijani Manat",
      "BAD": "Bosnia-Herzegovina Dinar",
      "BAM": "Bosnia-Herzegovina Convertible Mark",
      "BAN": "Bosnia-Herzegovina New Dinar",
      "BBD": "Barbadian Dollar",
      "BDT": "Bangladeshi Taka",
      "BEC": "Belgian Franc (convertible)",
      "BEF": "Belgian Franc",
      "BEL": "Belgian Franc (financial)",
      "BGL": "Bulgarian Hard Lev",
      "BGM": "Bulgarian Socialist Lev",
      "BGN": "Bulgarian Lev",
      "BGO": "Old Bulgarian Lev",
      "BHD": "Bahraini Dinar",
      "BIF": "Burundian Franc",
      "BMD": "Bermudan Dollar",
      "BND": "Brunei Dollar",
      "BOB": "Bolivian Boliviano",
      "BOL": "Old Bolivian Boliviano",
      "BOP": "Bolivian Peso",
      "BOV": "Bolivian Mvdol",
      "BRB": "Brazilian Cruzeiro Novo (1967-1986)",
      "BRC": "Brazilian Cruzado",
      "BRE": "Brazilian Cruzeiro (1990-1993)",
      "BRL": "Brazilian Real",
      "BRN": "Brazilian Cruzado Novo",
      "BRR": "Brazilian Cruzeiro",
      "BRZ": "Old Brazilian Cruzeiro",
      "BSD": "Bahamian Dollar",
      "BTN": "Bhutanese Ngultrum",
      "BUK": "Burmese Kyat",
      "BWP": "Botswanan Pula",
      "BYB": "Belarusian New Ruble (1994-1999)",
      "BYR": "Belarusian Ruble",
      "BZD": "Belize Dollar",
      "CAD": "Canadian Dollar",
      "CDF": "Congolese Franc",
      "CHE": "WIR Euro",
      "CHF": "Swiss Franc",
      "CHW": "WIR Franc",
      "CLE": "Chilean Escudo",
      "CLF": "Chilean Unidades de Fomento",
      "CLP": "Chilean Peso",
      "CNY": "Chinese Yuan Renminbi",
      "COP": "Colombian Peso",
      "COU": "Unidad de Valor Real",
      "CRC": "Costa Rican Colón",
      "CSD": "Old Serbian Dinar",
      "CSK": "Czechoslovak Hard Koruna",
      "CUC": "Cuban Convertible Peso",
      "CUP": "Cuban Peso",
      "CVE": "Cape Verdean Escudo",
      "CYP": "Cypriot Pound",
      "CZK": "Czech Republic Koruna",
      "DDM": "East German Mark",
      "DEM": "German Mark",
      "DJF": "Djiboutian Franc",
      "DKK": "Danish Krone",
      "DOP": "Dominican Peso",
      "DZD": "Algerian Dinar",
      "ECS": "Ecuadorian Sucre",
      "ECV": "Ecuadorian Unidad de Valor Constante (UVC)",
      "EEK": "Estonian Kroon",
      "EGP": "Egyptian Pound",
      "ERN": "Eritrean Nakfa",
      "ESA": "Spanish Peseta (A account)",
      "ESB": "Spanish Peseta (convertible account)",
      "ESP": "Spanish Peseta",
      "ETB": "Ethiopian Birr",
      "EUR": "Euro",
      "FIM": "Finnish Markka",
      "FJD": "Fijian Dollar",
      "FKP": "Falkland Islands Pound",
      "FRF": "French Franc",
      "GBP": "British Pound Sterling",
      "GEK": "Georgian Kupon Larit",
      "GEL": "Georgian Lari",
      "GHC": "Ghanaian Cedi (1979-2007)",
      "GHS": "Ghanaian Cedi",
      "GIP": "Gibraltar Pound",
      "GMD": "Gambian Dalasi",
      "GNF": "Guinean Franc",
      "GNS": "Guinean Syli",
      "GQE": "Equatorial Guinean Ekwele",
      "GRD": "Greek Drachma",
      "GTQ": "Guatemalan Quetzal",
      "GWE": "Portuguese Guinea Escudo",
      "GWP": "Guinea-Bissau Peso",
      "GYD": "Guyanaese Dollar",
      "HKD": "Hong Kong Dollar",
      "HNL": "Honduran Lempira",
      "HRD": "Croatian Dinar",
      "HRK": "Croatian Kuna",
      "HTG": "Haitian Gourde",
      "HUF": "Hungarian Forint",
      "IDR": "Indonesian Rupiah",
      "IEP": "Irish Pound",
      "ILP": "Israeli Pound",
      "ILR": "Old Israeli Sheqel",
      "ILS": "Israeli New Sheqel",
      "INR": "Indian Rupee",
      "IQD": "Iraqi Dinar",
      "IRR": "Iranian Rial",
      "ISJ": "Old Icelandic Króna",
      "ISK": "Icelandic Króna",
      "ITL": "Italian Lira",
      "JMD": "Jamaican Dollar",
      "JOD": "Jordanian Dinar",
      "JPY": "Japanese Yen",
      "KES": "Kenyan Shilling",
      "KGS": "Kyrgystani Som",
      "KHR": "Cambodian Riel",
      "KMF": "Comorian Franc",
      "KPW": "North Korean Won",
      "KRH": "South Korean Hwan",
      "KRO": "Old South Korean Won",
      "KRW": "South Korean Won",
      "KWD": "Kuwaiti Dinar",
      "KYD": "Cayman Islands Dollar",
      "KZT": "Kazakhstan Tenge",
      "LAK": "Laotian Kip",
      "LBP": "Lebanese Pound",
      "LKR": "Sri Lanka Rupee",
      "LRD": "Liberian Dollar",
      "LSL": "Lesotho Loti",
      "LTL": "Lithuanian Litas",
      "LTT": "Lithuanian Talonas",
      "LUC": "Luxembourgian Convertible Franc",
      "LUF": "Luxembourgian Franc",
      "LUL": "Luxembourg Financial Franc",
      "LVL": "Latvian Lats",
      "LVR": "Latvian Ruble",
      "LYD": "Libyan Dinar",
      "MAD": "Moroccan Dirham",
      "MAF": "Moroccan Franc",
      "MCF": "Monegasque Franc",
      "MDC": "Moldovan Cupon",
      "MDL": "Moldovan Leu",
      "MGA": "Malagasy Ariary",
      "MGF": "Malagasy Franc",
      "MKD": "Macedonian Denar",
      "MKN": "Old Macedonian Denar",
      "MLF": "Malian Franc",
      "MMK": "Myanma Kyat",
      "MNT": "Mongolian Tugrik",
      "MOP": "Macanese Pataca",
      "MRO": "Mauritanian Ouguiya",
      "MTL": "Maltese Lira",
      "MTP": "Maltese Pound",
      "MUR": "Mauritian Rupee",
      "MVP": "Maldivian Rupee",
      "MVR": "Maldivian Rufiyaa",
      "MWK": "Malawian Kwacha",
      "MXN": "Mexican Peso",
      "MXP": "Mexican Silver Peso (1861-1992)",
      "MXV": "Mexican Unidad de Inversion (UDI)",
      "MYR": "Malaysian Ringgit",
      "MZE": "Mozambican Escudo",
      "MZM": "Old Mozambican Metical",
      "MZN": "Mozambican Metical",
      "NAD": "Namibian Dollar",
      "NGN": "Nigerian Naira",
      "NIC": "Nicaraguan Cordoba",
      "NIO": "Nicaraguan Cordoba Oro",
      "NLG": "Dutch Guilder",
      "NOK": "Norwegian Krone",
      "NPR": "Nepalese Rupee",
      "NZD": "New Zealand Dollar",
      "OMR": "Omani Rial",
      "PAB": "Panamanian Balboa",
      "PEI": "Peruvian Inti",
      "PEN": "Peruvian Nuevo Sol",
      "PES": "Peruvian Sol",
      "PGK": "Papua New Guinean Kina",
      "PHP": "Philippine Peso",
      "PKR": "Pakistani Rupee",
      "PLN": "Polish Zloty",
      "PLZ": "Polish Zloty (1950-1995)",
      "PTE": "Portuguese Escudo",
      "PYG": "Paraguayan Guarani",
      "QAR": "Qatari Rial",
      "RHD": "Rhodesian Dollar",
      "ROL": "Old Romanian Leu",
      "RON": "Romanian Leu",
      "RSD": "Serbian Dinar",
      "RUB": "Russian Ruble",
      "RUR": "Russian Ruble (1991-1998)",
      "RWF": "Rwandan Franc",
      "SAR": "Saudi Riyal",
      "SBD": "Solomon Islands Dollar",
      "SCR": "Seychellois Rupee",
      "SDD": "Old Sudanese Dinar",
      "SDG": "Sudanese Pound",
      "SDP": "Old Sudanese Pound",
      "SEK": "Swedish Krona",
      "SGD": "Singapore Dollar",
      "SHP": "Saint Helena Pound",
      "SIT": "Slovenian Tolar",
      "SKK": "Slovak Koruna",
      "SLL": "Sierra Leonean Leone",
      "SOS": "Somali Shilling",
      "SRD": "Surinamese Dollar",
      "SRG": "Suriname Guilder",
      "STD": "São Tomé and Príncipe Dobra",
      "SUR": "Soviet Rouble",
      "SVC": "Salvadoran Colón",
      "SYP": "Syrian Pound",
      "SZL": "Swazi Lilangeni",
      "THB": "Thai Baht",
      "TJR": "Tajikistani Ruble",
      "TJS": "Tajikistani Somoni",
      "TMM": "Turkmenistani Manat",
      "TMT": "Turkmenistani New Manat",
      "TND": "Tunisian Dinar",
      "TOP": "Tongan Paʻanga",
      "TPE": "Timorese Escudo",
      "TRL": "Old Turkish Lira",
      "TRY": "Turkish Lira",
      "TTD": "Trinidad and Tobago Dollar",
      "TWD": "New Taiwan Dollar",
      "TZS": "Tanzanian Shilling",
      "UAH": "Ukrainian Hryvnia",
      "UAK": "Ukrainian Karbovanets",
      "UGS": "Ugandan Shilling (1966-1987)",
      "UGX": "Ugandan Shilling",
      "USD": "US Dollar",
      "USN": "US Dollar (Next day)",
      "USS": "US Dollar (Same day)",
      "UYI": "Uruguayan Peso en Unidades Indexadas",
      "UYP": "Uruguayan Peso (1975-1993)",
      "UYU": "Uruguayan Peso",
      "UZS": "Uzbekistan Som",
      "VEB": "Venezuelan Bolívar",
      "VEF": "Venezuelan Bolívar Fuerte",
      "VND": "Vietnamese Dong",
      "VNN": "Old Vietnamese Dong",
      "VUV": "Vanuatu Vatu",
      "WST": "Samoan Tala",
      "XAF": "CFA Franc BEAC",
      "XAG": "Silver",
      "XAU": "Gold",
      "XBA": "European Composite Unit",
      "XBB": "European Monetary Unit",
      "XBC": "European Unit of Account (XBC)",
      "XBD": "European Unit of Account (XBD)",
      "XCD": "East Caribbean Dollar",
      "XDR": "Special Drawing Rights",
      "XEU": "European Currency Unit",
      "XFO": "French Gold Franc",
      "XFU": "French UIC-Franc",
      "XOF": "CFA Franc BCEAO",
      "XPD": "Palladium",
      "XPF": "CFP Franc",
      "XPT": "Platinum",
      "XRE": "RINET Funds",
      "XTS": "Testing Currency Code",
      "XXX": "Unknown or Invalid Currency",
      "YDD": "Yemeni Dinar",
      "YER": "Yemeni Rial",
      "YUD": "Yugoslavian Hard Dinar",
      "YUM": "Yugoslavian Noviy Dinar",
      "YUN": "Yugoslavian Convertible Dinar",
      "YUR": "Yugoslavian Reformed Dinar",
      "ZAL": "South African Rand (financial)",
      "ZAR": "South African Rand",
      "ZMK": "Zambian Kwacha",
      "ZRN": "Zairean New Zaire",
      "ZRZ": "Zairean Zaire",
      "ZWD": "Zimbabwean Dollar",
      "ZWL": "Zimbabwean Dollar (2009)",
      "ZWR": "Zimbabwean Dollar (2008)",
    };
  }-*/;
}
