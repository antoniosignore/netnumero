package com.numhero.server.utils;

import com.numhero.shared.pojoc.SearchablePojo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.Stack;

public class XmlEntityParser {

    public static SearchablePojo parseEntityData(InputStream xml) {


        GetEntityDataHandler ur = new GetEntityDataHandler();
        SAXParser p;
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

        return ur.pojoc;

    }


    private static class GetEntityDataHandler extends DefaultHandler {
        private Stack<String> currentTags = new Stack<String>();
        private Attributes currentAtts;
        private SearchablePojo pojoc;

        public GetEntityDataHandler() {
        }

        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
            if (atts != null) {
                currentAtts = atts;

//                System.out.println(qName + " " + atts.getValue("companyId"));
            }
            currentTags.push(qName);

            if (qName.equals("entity")) {
                String classname = atts.getValue("type");
                pojoc = createPojoC(classname);
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            currentTags.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            //          System.out.println(" --------" + currentTags.toString());

            String t = currentTags.peek();
            if ("entity".equals(t)) {


            } else {
                String val = new String(ch, start, length);
                //               System.out.println("attr " + t + "  val " + val);

                pojoc.setAttributeAsString(t, val);

            }
        }

        private static SearchablePojo createPojoC(String classname) {
            SearchablePojo entity;
            try {
                Class<SearchablePojo> reqClazz = (Class<SearchablePojo>) Class.forName("com.numhero.client.model.pojoc." + classname);
                entity = reqClazz.newInstance();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("request not found " + classname, e);
            } catch (InstantiationException e) {
                throw new RuntimeException("newInstance error for " + classname, e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("newInstance illegal error for" + classname, e);
            }
            return entity;
        }
    }
}
