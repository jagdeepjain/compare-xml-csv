/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
    
    public ArrayList<String> getHeaders() throws ParserConfigurationException,
            SAXException, IOException {
        ArrayList<String> xml = new ArrayList<String>();
        File file = new File(
                "src/test/resources/sample.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("customField");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                xml.add(eElement.getAttribute("label"));
            }
        }
        return xml;
    }
    
    public static ArrayList<String> xmlToArrayList(String xml) {
        ArrayList<String> csvLines = new ArrayList<String>();
        if (xml != null) {
            String[] splitData = xml.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    csvLines.add(splitData[i].trim());
                }
            }
        }
        return csvLines;
    }
    
}
