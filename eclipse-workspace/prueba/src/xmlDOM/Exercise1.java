package xmlDOM;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Exercise1 {

	private static File file;
	private static DocumentBuilderFactory dbf;
	private static DocumentBuilder db;
	private static Document doc;
	
	public static void write(String xml) {
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			Element root = doc.createElement("ciudades");
			doc.appendChild(root);
			
			Element e = doc.createElement("ciudad");
			root.appendChild(e);
			
			Attr at = doc.createAttribute("continente");
			at.setValue("America");
			e.setAttributeNode(at);
			
			Element name = doc.createElement("nombre");
			name.appendChild(doc.createTextNode("Medellin"));
			e.appendChild(name);
			
			Element country = doc.createElement("pais");
			country.appendChild(doc.createTextNode("Colombia"));
			e.appendChild(country);
			
			//XML Transformation
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transform = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(xml));
			transform.transform(source, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read(String xml) {
		try {
			file = new File(xml);
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.parse(file);
			
			NodeList list = doc.getElementsByTagName("ciudad");
			
			for (int i = 0; i < list.getLength(); ++i) {
				Node node = (Node) list.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					
					System.out.println("Ciudad continente: " + e.getAttribute("continente"));
					System.out.println("Nombre: " + e.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Pais: " + e.getElementsByTagName("pais").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		read("ciudades2.xml");
	}

}
