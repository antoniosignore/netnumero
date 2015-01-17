package com.numhero.server.utils;

import com.numhero.client.model.pojoc.User;
import com.numhero.shared.enums.UserRoleEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Stack;

import static com.numhero.server.utils.StringUtils.strToEnumDef;


public class XmlResponseParser {
    public static void parseGetUserData(InputStream xml, User u) {


        GetUserDataHandler ur = new GetUserDataHandler(u);
        SAXParser p = null;
        try {
            p = SAXParserFactory.newInstance().newSAXParser();
        } catch (Exception e) {
            throw new RuntimeException("parser creation exception ", e);
        }
        try {
            p.parse(xml, ur);
        }
        catch (Exception e) {
            throw new RuntimeException("parser parse exception ", e);
        }
        u.fName.setValue(u.fFirstName.getValue() + " " + u.fLastName.getValue());
    }


    private static class GetUserDataHandler extends DefaultHandler {
        private User user;
        private Stack<String> currentTags = new Stack<String>();
        private String currentBAUri = "";

        public GetUserDataHandler(User u) {
            this.user = u;
        }

        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
            if (qName.equals("role")) {
                currentBAUri = atts.getValue("companyId");

//                System.out.println(qName + " " + atts.getValue("companyId"));
            }
            currentTags.push(qName);

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            currentTags.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            String t = currentTags.peek();
            String v = new String(ch, start, length);
            if ("name".equals(t)) {
                user.setFirstName(v);
            }
            if ("surname".equals(t)) {
                user.setLastName(v);
                //System.out.println("lastname " + v + " " + user.getLastName());
            }

            if ("email".equals(t)){
                user.fEmail.setValue(v);
            }
            if ("version".equals(t)){
                user.fVersion.setValue(v);
            }
            if ("country".equals(t)){
                user.fCountryCode.setValue(v);
            }
            if ("role".equals(t)){
                user.fBusinessAccountUri.setValue(currentBAUri);
                user.addRelationToBa(currentBAUri, (UserRoleEnum) strToEnumDef(v, UserRoleEnum.free));
            }

        }
    }
}
