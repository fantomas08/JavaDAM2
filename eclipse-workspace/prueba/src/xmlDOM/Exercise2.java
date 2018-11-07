package xmlDOM;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class Exercise2 {

	public static void writeTable(String[][] ar) {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element root = doc.createElement("hechos");
			doc.appendChild(root);
			
			for (int i = 0; i < ar.length; ++i) {
				Element e = doc.createElement("hecho");
				root.appendChild(e);
				
				Element dis = doc.createElement("descripcion");
				dis.appendChild(doc.createTextNode(ar[i][0]));
				e.appendChild(dis);
				
				Element date = doc.createElement("fecha");
				e.appendChild(date);
				
				Element day = doc.createElement("dia");
				day.appendChild(doc.createTextNode(ar[i][1]));
				date.appendChild(day);
				Element month = doc.createElement("mes");
				month.appendChild(doc.createTextNode(ar[i][2]));
				date.appendChild(month);
				Element year = doc.createElement("año");
				year.appendChild(doc.createTextNode(ar[i][3]));
				date.appendChild(year);
			}
			
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("tabla.xml"));
			transform.transform(source, result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) {
		String[][] ar = {{"IBM da a conocer el PC.","12","8","1981"},{"Se funda Google.","4","9","1998"},
				{"Se funda Facebook.","4","2","2004"}};
		writeTable(ar);
	}

}
