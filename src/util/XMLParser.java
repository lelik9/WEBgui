package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser
{
	public List<String> XMLParser(String parent, String pName)
	{
		List<String> XMLdata = new ArrayList<String>();
		
	    try {
	    	File fXmlFile = new File("G:/temp/NetMonitor/LNMweb/WebContent/WEB-INF/conf/test.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);

	    	doc.getDocumentElement().normalize();
	     
	     
	        // Navigate down the hierarchy to get to the CEO node
	        NodeList pNodeList = doc.getElementsByTagName(parent);
	        for (int temp2 = 0; temp2 < pNodeList.getLength(); temp2++) {
	        	Node pNode = pNodeList.item(temp2);
	        	Element eElement2 = (Element) pNode;
	        	if(eElement2.getAttribute("name").equals(pName))
	        	{
	        		NodeList childNodeList = pNode.getChildNodes();
	        			for (int temp = 0; temp < childNodeList.getLength(); temp++) {
	        				Node childNode = childNodeList.item(temp);
	        		
	        				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
   					 
	        					Element eElement = (Element) childNode;
	        					XMLdata.add(eElement.getAttribute("name"));
	        				}
	        		
	        			}
	        	}
	        }


	        } catch (Exception e) {
	    	e.printStackTrace();
	        }
		return XMLdata;
	}
	

	 

}
