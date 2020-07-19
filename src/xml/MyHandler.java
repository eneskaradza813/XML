
package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
    
    private String actualNodeName;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing start");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing end");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.actualNodeName = qName;
        System.out.println("Start element: " + qName);
        
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("    Attribute: " + attributes.getLocalName(i) + ":" + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
        if(!actualNodeName.equals("name")){
            return;
        }
        
        String nodeValue = new String(ch, start, length);
        if(!nodeValue.trim().equals(""))
        {
            System.out.println("Node value: " + nodeValue);
        }
    }
    
    
}
