// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XML.java

package com.dtmc.server.analytics.util;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package com.dtmc.server.analytics.util:
//            SortedAttribute

public class XML
{

    public XML()
    {
    }

    public static String toString(Node node)
    {
        return toString(node, true, false);
    }

    public static String toString(Node node, boolean format)
    {
        return toString(node, true, format);
    }

    public static String toString(Node node, boolean escapeEntities, boolean format)
    {
        StringWriter w = new StringWriter();
        try
        {
            write(node, w, escapeEntities, format);
        }
        catch(IOException ioe) { }
        return w.toString();
    }

    public static void write(Node node, OutputStream os, boolean format)
        throws IOException
    {
        write(node, os, true, format);
    }

    public static void write(Node node, OutputStream os, boolean escapeEntities, boolean format)
        throws IOException
    {
        Writer w = new OutputStreamWriter(os);
        write(node, w, escapeEntities, format);
        w.flush();
    }

    public static void write(Node node, Writer writer, boolean format)
        throws IOException
    {
        write(node, writer, true, format);
    }

    public static void write(Node node, Writer writer, boolean escapeEntities, boolean format)
        throws IOException
    {
        if(node == null)
            return;
        switch(node.getNodeType())
        {
        case 9: // '\t'
        case 11: // '\013'
            if(!node.hasChildNodes())
                break;
            NodeList nl = node.getChildNodes();
            for(int i = 0; i < nl.getLength(); i++)
                write(nl.item(i), writer, escapeEntities, format);

            break;

        case 1: // '\001'
            Element element = (Element)node;
            int depth = getDepth(node);
            String indent = "";
            if(format && depth > 0)
            {
                for(int i = 0; i < depth; i++)
                    indent = (new StringBuilder()).append(indent).append("  ").toString();

                writer.write((new StringBuilder()).append("\n").append(indent).toString());
            }
            writer.write(60);
            writer.write(element.getTagName());
            NamedNodeMap nnm = element.getAttributes();
            for(int i = 0; i < nnm.getLength(); i++)
            {
                writer.write(32);
                write(nnm.item(i), writer, escapeEntities, format);
            }

            if(element.hasChildNodes())
            {
                writer.write(62);
                NodeList nl = element.getChildNodes();
                for(int i = 0; i < nl.getLength(); i++)
                    write(nl.item(i), writer, escapeEntities, format);

                if(format && hasChildElements(element))
                    writer.write((new StringBuilder()).append("\n").append(indent).toString());
                writer.write("</");
                writer.write(element.getTagName().toString());
                writer.write(62);
            } else
            {
                writer.write("/>");
            }
            break;

        case 2: // '\002'
            Attr attribute = (Attr)node;
            writer.write(attribute.getName());
            writer.write("=\"");
            writer.write(escapeEntities ? escapeXMLEntities(attribute.getValue()) : attribute.getValue());
            writer.write(34);
            break;

        case 7: // '\007'
            ProcessingInstruction pi = (ProcessingInstruction)node;
            writer.write("<?");
            writer.write(pi.getTarget());
            writer.write(32);
            writer.write(pi.getData());
            writer.write("?>");
            break;

        case 8: // '\b'
            Comment comment = (Comment)node;
            writer.write("<!--");
            writer.write(comment.getData());
            writer.write("-->");
            break;

        case 3: // '\003'
            Text text = (Text)node;
            writer.write(escapeEntities ? escapeXMLEntities(text.getData()) : text.getData());
            break;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
        default:
            writer.write(escapeEntities ? escapeXMLEntities(node.toString()) : node.toString());
            break;
        }
    }

    public static String escapeXMLEntities(String text)
    {
        if(text == null)
            return text;
        StringBuffer esc_buffer = new StringBuffer(text);
        for(int n = 0; n < esc_buffer.length(); n++)
        {
            char c = esc_buffer.charAt(n);
            if(c == '&')
            {
                esc_buffer.setCharAt(n, '&');
                esc_buffer.insert(n + 1, "amp;");
                n += 4;
                continue;
            }
            if(c == '"')
            {
                esc_buffer.setCharAt(n, '&');
                esc_buffer.insert(n + 1, "quot;");
                n += 5;
                continue;
            }
            if(c == '<')
            {
                esc_buffer.setCharAt(n, '&');
                esc_buffer.insert(n + 1, "lt;");
                n += 3;
                continue;
            }
            if(c == '>')
            {
                esc_buffer.setCharAt(n, '&');
                esc_buffer.insert(n + 1, "gt;");
                n += 3;
                continue;
            }
            if(c == '\'')
            {
                esc_buffer.setCharAt(n, '&');
                esc_buffer.insert(n + 1, "apos;");
                n += 5;
            }
        }

        return esc_buffer.toString();
    }

    public static void toFile(String fileName, String data)
        throws IOException
    {
        FileWriter fw = new FileWriter(fileName);
        fw.write(data);
        fw.flush();
        fw.close();
    }

    public static boolean hasAttributes(Node tree)
    {
        Node node = tree;
        boolean val = false;
        if(isElementNode(node))
            val = node.getAttributes().getLength() > 0;
        return val;
    }

    public static List getChildElements(Node n)
    {
        NodeList kids = n.getChildNodes();
        List answer = new ArrayList();
        int size = kids.getLength();
        for(int i = 0; i < size; i++)
        {
            Node kid = kids.item(i);
            if(kid.getNodeType() == 1)
                answer.add(kid);
        }

        return answer;
    }

    public static Node getFirstChildElementNode(Node node)
    {
        Node result = null;
        if(node != null && node.hasChildNodes())
        {
            NodeList nl = node.getChildNodes();
            int i = 0;
            do
            {
                if(i >= nl.getLength())
                    break;
                Node child = nl.item(i);
                if(isElementNode(child))
                {
                    result = child;
                    break;
                }
                i++;
            } while(true);
        }
        return result;
    }

    public static Node getNextSiblingElementNode(Node node)
    {
        if(node == null)
            return null;
        Node sibling = null;
        String name = node.getNodeName();
        for(sibling = node.getNextSibling(); sibling != null; sibling = sibling.getNextSibling())
            if(sibling.getNodeName().equalsIgnoreCase(name))
                return sibling;

        return null;
    }

    public static Node getFirstChildTextNode(Node node)
    {
        Node result = null;
        if(node != null && node.hasChildNodes())
        {
            NodeList nl = node.getChildNodes();
            int i = 0;
            do
            {
                if(i >= nl.getLength())
                    break;
                Node child = nl.item(i);
                if(isTextNode(child))
                {
                    result = child;
                    break;
                }
                i++;
            } while(true);
        }
        return result;
    }

    public static Node findNode(Node node, int index)
    {
        Node child = null;
        int ind = -1;
        String path = getPath(node, "/");
        NodeList nodes = node.getOwnerDocument().getElementsByTagName(node.getNodeName());
        for(int i = 0; i < nodes.getLength(); i++)
        {
            child = nodes.item(i);
            if(getPath(child, "/").equalsIgnoreCase(path) && ++ind == index)
                return child;
        }

        return null;
    }

    public static List findAllSiblingNodes(Node node)
    {
        List siblings = new ArrayList();
        Node child = null;
        int ind = 0;
        String path = getPath(node, "/");
        NodeList nodes = node.getOwnerDocument().getElementsByTagName(node.getNodeName());
        for(int i = 0; i < nodes.getLength(); i++)
        {
            child = nodes.item(i);
            if(getPath(child, "/").equalsIgnoreCase(path) && i > 0)
                siblings.add(child);
        }

        return siblings;
    }

    public static Node findNode(Node node, String name)
    {
        if(node == null)
            throw new IllegalArgumentException("node cannot be null");
        if(node.getNodeName().equals(name))
            return node;
        if(node.hasChildNodes())
        {
            NodeList list = node.getChildNodes();
            int size = list.getLength();
            for(int i = 0; i < size; i++)
            {
                if(!isElementNode(list.item(i)))
                    continue;
                Node found = findNode(list.item(i), name);
                if(found != null)
                    return found;
            }

        }
        return null;
    }

    public static Node findNodeWithAttributeValue(Node node, String name, String value)
    {
        if(node == null)
            throw new IllegalArgumentException("node cannot be null");
        String attrvalue = getAttributeValue(node, name);
        if(!attrvalue.equals("") && attrvalue.equals(value))
            return node;
        if(node.hasChildNodes())
        {
            NodeList list = node.getChildNodes();
            int size = list.getLength();
            for(int i = 0; i < size; i++)
            {
                if(!isElementNode(list.item(i)))
                    continue;
                Node found = findNodeWithAttributeValue(list.item(i), name, value);
                if(found != null)
                    return found;
            }

        }
        return null;
    }

    public static Node findNodeWithEmptyData(Node node, String name)
    {
        if(node.getNodeName().equals(name))
            return node;
label0:
        for(Node sibling = node; sibling != null; sibling = sibling.getNextSibling())
        {
            if(!sibling.hasChildNodes())
                continue;
            NodeList list = sibling.getChildNodes();
            int size = list.getLength();
            int i = 0;
            do
            {
                if(i >= size)
                    continue label0;
                Node found = findNode(list.item(i), name);
                if(found != null && getData(found).trim().equals(""))
                    return found;
                i++;
            } while(true);
        }

        return null;
    }

    public static void getData(List list, Node tree)
    {
        String data = null;
        if(isTextNode(tree))
            data = tree.getNodeValue();
        if(data != null && !data.trim().equals(""))
            list.add(data);
        for(Node child = tree.getFirstChild(); child != null; child = child.getNextSibling())
            getData(list, child);

    }

    public static boolean isEmptyData(Node tree)
    {
        String data = null;
        if(isTextNode(tree))
            data = tree.getNodeValue();
        boolean result = true;
        if(data != null && !data.trim().equals(""))
            result = false;
        Node child = tree.getFirstChild();
        do
        {
            if(child == null)
                break;
            result = isEmptyData(child);
            if(!result)
                break;
            child = child.getNextSibling();
        } while(true);
        return result;
    }

    public static String getData(Node tree)
    {
        if(tree.getNodeType() == 9)
            tree = ((Document)tree).getDocumentElement();
        if(isTextNode(tree) || isAttributeNode(tree) || isCDATANode(tree))
            return tree.getNodeValue();
        NodeList kids = tree.getChildNodes();
        int size = kids.getLength();
        StringBuffer answer = new StringBuffer();
        int i = 0;
        do
        {
            if(i >= size)
                break;
            Node node = kids.item(i);
            if(isTextNode(node) || isCDATANode(node))
            {
                String part = node.getNodeValue();
                answer.append(part);
            }
            if(isElementNode(node))
                break;
            i++;
        } while(true);
        return answer.toString();
    }

    public static String getAttributeData(Node tree)
    {
        String data = "";
        if(!isAttributeNode(tree))
            return data;
        if(tree != null)
            data = tree.getNodeValue();
        return data;
    }

    public static void setData(Node tree, String value)
    {
        if(tree.getFirstChild() != null && isTextNode(tree.getFirstChild()))
            tree.getFirstChild().setNodeValue(value);
        else
            tree.appendChild(tree.getOwnerDocument().createTextNode(value));
    }

    public static void setAttributeData(Node tree, String value)
    {
        if(isAttributeNode(tree))
            tree.setNodeValue(value);
    }

    public static String getPath(Node node, String delimiter)
    {
        String path = "";
        if(node.getParentNode() != node.getOwnerDocument())
            path = (new StringBuilder()).append(getPath(node.getParentNode(), delimiter)).append(delimiter).append(node.getNodeName()).toString();
        else
            path = node.getNodeName();
        return path;
    }

    public static String getAllLabels(Node node, String delimiter)
    {
        String path = "";
        if(node.getParentNode() != node.getOwnerDocument())
            path = (new StringBuilder()).append(getAllLabels(node.getParentNode(), delimiter)).append(delimiter).append(getAttributeValue(node, "label").trim()).toString();
        else
            path = getAttributeValue(node, "label").trim();
        return path;
    }

    public static String getRelativePath(Node node, Node ancestor, String delimiter)
    {
        StringBuffer answer = new StringBuffer();
        getRelativePath(node, ancestor, delimiter, answer);
        return answer.toString();
    }

    private static void getRelativePath(Node node, Node ancestor, String delimiter, StringBuffer answer)
    {
        if(node == null)
            return;
        if(node.getNodeType() == 9)
        {
            answer.delete(0, answer.length());
            return;
        }
        if(node == ancestor)
            return;
        if(answer.length() > 0)
            answer.insert(0, delimiter);
        answer.insert(0, node.getNodeName());
        getRelativePath(node.getParentNode(), ancestor, delimiter, answer);
    }

    public static String getXPath(Node node)
    {
        String path = "";
        String delimiter = "/";
        if(node.getNodeType() == 2)
            path = (new StringBuilder()).append(getXPath(((Node) (((Attr)node).getOwnerDocument())))).append(delimiter).append(getLocalXPath(node)).toString();
        else
        if(node.getParentNode() != node.getOwnerDocument())
            path = (new StringBuilder()).append(getXPath(node.getParentNode())).append(delimiter).append(getLocalXPath(node)).toString();
        else
            path = getLocalXPath(node);
        return path;
    }

    public static String getLocalXPath(Node node)
    {
        String path = "";
        String delimiter = "/";
        if(node.getNodeType() == 2)
            path = (new StringBuilder()).append("@").append(node.getNodeName()).toString();
        else
        if(node.getParentNode() == node.getOwnerDocument())
        {
            path = node.getNodeName();
        } else
        {
            int idx = getRelativeSiblingPosition(node);
            if(idx > 1)
                path = (new StringBuilder()).append(node.getNodeName()).append("[").append(idx).append("]").toString();
            else
                path = node.getNodeName();
        }
        return path;
    }

    public static int getRelativeSiblingCount(Node node)
    {
        int count = 0;
        if(node.getParentNode() == node.getOwnerDocument())
        {
            count++;
        } else
        {
            NodeList siblings = node.getParentNode().getChildNodes();
            for(int i = 0; i < siblings.getLength(); i++)
            {
                Node sib = siblings.item(i);
                if(sib.getNodeName().equals(node.getNodeName()))
                    count++;
            }

        }
        return count;
    }

    public static int getRelativeSiblingPosition(Node node)
    {
        int position = 0;
        if(node.getParentNode() == node.getOwnerDocument())
        {
            position++;
        } else
        {
            NodeList siblings = node.getParentNode().getChildNodes();
            int i = 0;
            do
            {
                if(i >= siblings.getLength())
                    break;
                Node sib = siblings.item(i);
                if(sib.getNodeName().equals(node.getNodeName()))
                    position++;
                if(sib == node)
                    break;
                i++;
            } while(true);
        }
        return position;
    }

    public static Node getAttributeNode(Node tree, String attributeName)
    {
        if(attributeName.startsWith(ATTRIBUTE_PREFIX))
            attributeName = attributeName.substring(1);
        if(tree != null && isElementNode(tree))
        {
            NamedNodeMap atts = tree.getAttributes();
            for(int i = 0; i < atts.getLength(); i++)
            {
                Node att = atts.item(i);
                if(isAttributeNode(att) && att.getNodeName().equalsIgnoreCase(attributeName))
                    return att;
            }

        }
        return null;
    }

    public static String getAttributeValue(Node node, String attributeName)
    {
        if(node == null)
            throw new IllegalArgumentException("node cannot be null");
        String val = "";
        if(isElementNode(node))
        {
            NamedNodeMap atts = node.getAttributes();
            for(int i = 0; i < atts.getLength(); i++)
            {
                Node att = atts.item(i);
                if(isAttributeNode(att) && att.getNodeName().equalsIgnoreCase(attributeName))
                {
                    val = att.getNodeValue();
                    return val;
                }
            }

        }
        return val.trim();
    }

    public static Document streamToDocument(InputStream file)
        throws IOException, ParserConfigurationException, SAXException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        return doc;
    }

    public static NodeList getChildNodes(Node node)
    {
        if(node.getOwnerDocument() == null)
            return getFirstChildElementNode(node).getChildNodes();
        if(isElementNode(node))
            return node.getChildNodes();
        else
            return null;
    }

    public static String getNodeAttribute(Node node, String name)
    {
        if(node instanceof Element)
        {
            Element element = (Element)node;
            return element.getAttribute(name);
        } else
        {
            return null;
        }
    }

    public static String getNodeName(Node n)
    {
        return n.getNodeName();
    }

    public static String getNodeValue(Node n)
    {
        return n.getNodeValue();
    }

    public static Node cloneNode(Node n)
    {
        return n.cloneNode(true);
    }

    public static boolean isElementNode(Node n)
    {
        return n.getNodeType() == 1;
    }

    public static boolean isAttributeNode(Node n)
    {
        return n.getNodeType() == 2;
    }

    public static boolean isTextNode(Node n)
    {
        return n.getNodeType() == 3;
    }

    public static boolean isCDATANode(Node n)
    {
        return n.getNodeType() == 4;
    }

    public static boolean isPINode(Node n)
    {
        return n.getNodeType() == 7;
    }

    public static boolean isCommentNode(Node n)
    {
        return n.getNodeType() == 8;
    }

    public static boolean isRootNode(Node n)
    {
        return n.getNodeType() != 2 && n.getParentNode() == null;
    }

    public static int getDepth(Node node)
    {
        Node parent = node.getParentNode();
        if(parent != null && parent.getNodeType() == 1)
            return getDepth(parent) + 1;
        else
            return 0;
    }

    public static boolean hasChildElements(Node node)
    {
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++)
        {
            Node n = nl.item(i);
            if(n.getNodeType() == 1)
                return true;
        }

        return false;
    }

    public static String getAttributeValue(Element element, String attributeName)
    {
        Node node = element.getAttributeNode(attributeName);
        return node != null ? node.getNodeValue() : "";
    }

    public static Document newDocument()
        throws ParserConfigurationException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.newDocument();
    }

    public static Document newDocument(String elementName)
        throws ParserConfigurationException
    {
        Document doc = newDocument();
        Element element = doc.createElement(elementName);
        doc.appendChild(element);
        return doc;
    }

    public static Document stringToDocument(String xml)
        throws ParserConfigurationException, SAXException, IOException
    {
        if(xml != null)
        {
            Document doc = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
            return doc;
        } else
        {
            return null;
        }
    }

    public static Document fileToDocument(String fileName)
        throws IOException, ParserConfigurationException, SAXException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(fileName));
        return doc;
    }

    public static Document fileToDocument(File file)
        throws IOException, ParserConfigurationException, SAXException
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(file));
        return doc;
    }

    public static List getImmediateChildren(Node node)
    {
        List children = new ArrayList();
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++)
        {
            Node n = nl.item(i);
            if(n.getNodeType() == 1)
                children.add(n);
        }

        return children;
    }

    public static Element getFirstChildElement(Element el)
    {
        Element result = null;
        if(el.hasChildNodes())
        {
            NodeList nl = el.getChildNodes();
            int i = 0;
            do
            {
                if(i >= nl.getLength())
                    break;
                Node node = nl.item(i);
                if(node.getNodeType() == 1)
                {
                    result = (Element)node;
                    break;
                }
                i++;
            } while(true);
        }
        return result;
    }

    public static Element getFirstChildElement(Element el, String name)
    {
        Element result = null;
        if(el.hasChildNodes())
        {
            NodeList nl = el.getChildNodes();
            int i = 0;
            do
            {
                if(i >= nl.getLength())
                    break;
                Node node = nl.item(i);
                if(node.getNodeType() == 1 && node.getNodeName().equals(name))
                {
                    result = (Element)node;
                    break;
                }
                i++;
            } while(true);
        }
        return result;
    }

    public static String extractAttributeValue(String xml, String attributeName)
    {
        StringBuffer result = new StringBuffer();
        String token = (new StringBuilder()).append(" ").append(attributeName).append("=\"").toString();
        int attrNameStart = xml.indexOf(token);
        if(attrNameStart != -1)
        {
            int attrValStart = attrNameStart + token.length();
            boolean done = false;
            int i = attrValStart;
            do
            {
                if(i >= xml.length())
                    break;
                char c = xml.charAt(i);
                switch(c)
                {
                case 34: // '"'
                    done = true;
                    break;

                default:
                    result.append(c);
                    break;
                }
                if(done)
                    break;
                i++;
            } while(true);
        }
        return result.toString();
    }

    public static String extractElementName(String xml)
    {
        StringBuffer result = new StringBuffer();
        boolean done = false;
        int i = 0;
        do
        {
            if(i >= xml.length())
                break;
            char c = xml.charAt(i);
            switch(c)
            {
            case 32: // ' '
            case 47: // '/'
            case 62: // '>'
                done = true;
                break;

            default:
                result.append(c);
                break;

            case 60: // '<'
                break;
            }
            if(done)
                break;
            i++;
        } while(true);
        return result.toString();
    }

    public static void appendElementWithData(Element root, String elementName, String elementValue)
    {
        Element child = root.getOwnerDocument().createElement(elementName);
        root.appendChild(child);
        Node text = root.getOwnerDocument().createTextNode(elementValue);
        child.appendChild(text);
    }

    public static void clearAttributes(Element el)
    {
        List list = new ArrayList();
        NamedNodeMap map = el.getAttributes();
        for(int i = 0; i < map.getLength(); i++)
            list.add(map.item(i).getNodeName());

        for(int i = 0; i < list.size(); i++)
        {
            String name = (String)list.get(i);
            el.removeAttribute(name);
        }

    }

    public static String getElementText(Element el)
    {
        String result = null;
        Node child = el.getFirstChild();
        if(child != null && child.getNodeType() == 3)
            result = child.getNodeValue();
        else
            result = "";
        return result;
    }

    public static String getChildElementsAsText(Element el)
    {
        StringBuffer buf = new StringBuffer();
        if(el.hasChildNodes())
        {
            NodeList nl = el.getChildNodes();
            for(int i = 0; i < nl.getLength(); i++)
            {
                Node node = nl.item(i);
                buf.append(toString(node));
            }

        }
        return buf.toString();
    }

    public static String formatXML(String xml)
    {
        Document doc = stringToDocument(xml);
        return toString(doc, true);
        Exception exc;
        exc;
        return xml;
    }

    public static boolean compareChildrenNodeAttributes(Node nOne, Node nTwo)
    {
        boolean result = false;
        if(nOne.getOwnerDocument() == null)
            nOne = getFirstChildElementNode(nOne);
        if(nTwo.getOwnerDocument() == null)
            nTwo = getFirstChildElementNode(nTwo);
        List l1 = getImmediateChildren(nOne);
        List l2 = getImmediateChildren(nTwo);
        for(int i = 0; i < l1.size(); i++)
        {
            Node n1 = (Node)l1.get(i);
            Node n2 = (Node)l2.get(i);
            result = compareNodeAttributes(n1, n2);
            if(!result)
                return result;
        }

        return result;
    }

    public static boolean compareNodeAttributes(Node nOne, Node nTwo)
    {
        NamedNodeMap atts1 = nOne.getAttributes();
        NamedNodeMap atts2 = nTwo.getAttributes();
        if(atts1.getLength() != atts2.getLength())
            return false;
        for(int i = 0; i < atts1.getLength(); i++)
        {
            Node n1 = atts1.item(i);
            for(int j = 0; j < atts2.getLength(); j++)
            {
                Node n2 = atts2.item(j);
                if(n2.getNodeName().equals(n1.getNodeName()) && !n1.getNodeValue().equals(n2.getNodeValue()))
                    return false;
            }

        }

        return true;
    }

    private static int compareAttributeValues(SortedAttribute sAtt, String val1, String val2)
    {
        int returnVal = -1;
        if(sAtt.getAttType().equals("String"))
            returnVal = val1.compareTo(val2);
        else
        if(sAtt.getAttType().equals("float") || sAtt.getAttType().equals("int"))
        {
            float f1 = Float.parseFloat(val1);
            float f2 = Float.parseFloat(val2);
            if(f1 > f2)
                returnVal = 1;
            else
            if(f1 < f2)
                returnVal = -1;
            else
            if(f1 == f2)
                returnVal = 0;
        } else
        {
            System.err.println((new StringBuilder()).append("Incompatible attribute type: ").append(sAtt.getAttType()).toString());
        }
        return returnVal;
    }

    public static final Node getFirstSibling(Node node)
    {
        Node answer = node.getPreviousSibling();
        if(answer == null)
            return node;
        else
            return getFirstSibling(answer);
    }

    public static Document cloneBranchToNewDocument(Element el)
    {
        Document res = null;
        String branchAsText = toString(el);
        try
        {
            res = stringToDocument(branchAsText);
        }
        catch(Exception exc) { }
        return res;
    }

    public static void ricorsiva(Node n, HashMap map)
    {
        if(n == null)
            return;
        if(getFirstChildElementNode(n) == null)
        {
            map.put(getNodeName(n).trim(), getData(n).trim());
        } else
        {
            List children = getImmediateChildren(n);
            for(int i = 0; i < children.size(); i++)
                ricorsiva((Node)children.get(i), map);

        }
    }

    public static void main(String args[])
        throws ParserConfigurationException, SAXException, XPathExpressionException, IOException
    {
        String s = "<widgets> \t<widget name=\"a\" style=\"red\" quantity=\"6\"/> \t<widget name=\"b\" style=\"blue\"/> \t<widget name=\"c\"> \t\t<style>green</style>\t</widget> </widgets>";
        Document doc = stringToDocument(s);
        XPath xpath = XPathFactory.newInstance().newXPath();
        String expression = "/widgets/widget[@name='a']/@quantity";
        Double quantity = (Double)xpath.evaluate(expression, doc, XPathConstants.NUMBER);
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("quantity = ").append(quantity).toString());
        String quantitystr = (String)xpath.evaluate(expression, doc, XPathConstants.STRING);
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("quantitystr = ").append(quantitystr).toString());
        expression = "/widgets/widget[@name='a']";
        Node node = (Node)xpath.evaluate(expression, doc, XPathConstants.NODE);
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("node = ").append(toString(node, true)).toString());
        expression = "/widgets/widget[@name='a']/@quantity";
        node = (Node)xpath.evaluate(expression, doc, XPathConstants.NODE);
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("node = ").append(toString(node, true)).toString());
        Attr attr = (Attr)node;
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("attr.getName() = ").append(attr.getName()).toString());
        if(logger.isInfoEnabled())
            logger.info((new StringBuilder()).append("attr.getValue() = ").append(attr.getValue()).toString());
        expression = "/widgets/widget";
        NodeList list = (NodeList)xpath.evaluate(expression, doc, XPathConstants.NODESET);
        for(int i = 0; i < list.getLength(); i++)
        {
            node = list.item(i);
            if(logger.isInfoEnabled())
                logger.info((new StringBuilder()).append("node = ").append(toString(node, true)).toString());
        }

        expression = "//*";
        list = (NodeList)xpath.evaluate(expression, doc, XPathConstants.NODESET);
        for(int i = 0; i < list.getLength(); i++)
        {
            node = list.item(i);
            if(logger.isInfoEnabled())
                logger.info((new StringBuilder()).append("node = ").append(toString(node, true)).toString());
        }

    }

    public static String ATTRIBUTE_PREFIX = "@";
    private static Log logger = LogFactory.getLog(com/dtmc/server/analytics/util/XML);

}
