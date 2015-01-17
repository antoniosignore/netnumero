package com.numhero.server.utils;

import com.numhero.shared.pojoc.EntityPojo;

import java.util.List;

public class XmlUtils {


    public static void serializeEntity(StringBuffer xml, EntityPojo entity) {
        xml.append("<entity type=\"" + entity.getClass().getSimpleName() + "\" >");

        List<String> l = entity.getFieldNamesOrderedList();
        for (String s : l) {
            if (entity.getAttributeAsString(s) != null) {
                xml.append("<" + s + ">");
                xml.append(entity.getAttributeAsString(s));
                xml.append("</" + s + ">");
            }
        }
        xml.append("</entity>");
    }

//    public static BasePojoC deserializePojoC(String xml) {
//
//        Document document;
//
//        try {
//            document = DocumentHelper.parseText(xml);
//        } catch (DocumentException e) {
//            throw new RuntimeException("Error parsing xml", e);
//        }
//
//        Element el = document.getRootElement();
//
//        System.out.println("EL  "  + el);
//        System.out.println("EL  "  + el.node(0).valueOf("@type"));
//
//        String classname = "com.numhero.client.model.pojoc." + el.valueOf("@type");
//        BasePojoC entity = createPojoC(classname);
//
//        for (Iterator i = el.elementIterator(); i.hasNext();) {
//            Element element = (Element) i.next();
//            String val = element.getStringValue();
//            String attr = element.getName();
//            System.out.println("attr " + attr + "  val " + val);
//            entity.setAttribute(attr, val);
//        }
//
//
//        return entity;
//    }


}
