package xmlDOM;

import java.io.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Exercise3 implements Serializable {

	private static Person[] ar;
	
	public static void createFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Persona.dat")));
			for (int i = 0; i < ar.length; ++i) {
				oos.writeObject(ar[i]);
			}
			if (oos != null) {
				oos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void createXML() {
		File file = new File("Persona.dat");
		ObjectInputStream ois = null;
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element root = doc.createElement("persons");
			doc.appendChild(root);
			
			ois = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Person person = (Person) ois.readObject();
				
				Element p = doc.createElement("person");
				root.appendChild(p);
				
				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(person.getName()));
				p.appendChild(name);
				
				Element age = doc.createElement("age");
				age.appendChild(doc.createTextNode(Integer.toString(person.getAge())));
				p.appendChild(age);
				
				Transformer t = TransformerFactory.newInstance().newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("PersonaXML.xml"));
				t.transform(source, result);
			}
		} catch (EOFException e) {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void createArray() {
	
	}
	
	public static void main(String[] args) {
		ar = new Person[] {new Person("Yevgen", 27), new Person("Alex", 19), new Person("Enrique", 23),
				new Person("Leandro", 25)};
		//a
		createFile();
		//b
		createXML();
		
	}

}
