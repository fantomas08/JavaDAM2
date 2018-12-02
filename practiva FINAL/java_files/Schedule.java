package java_files;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Schedule {

	private ArrayList<Contact> list;
	
	public Schedule() {
		list = new ArrayList<Contact>();
	}
	
	public ArrayList<Contact> getList() {
		return list;
	}

	private void setList(ArrayList<Contact> list) {
		this.list = list;
	}

	public void loadList() {
		File file = new File("schedule.bin");
		if (file.exists()) {
			importContacts(file);
		}	
	}
	
	public void saveList() {
		exportContacts("schedule", "bin");
	}
	
	
	//add new contact
	public void addContact(Contact c) {
		list.add(c);
	}
	
	
	//search contacts from list
	public ArrayList<Contact> searchForName(String name) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getName().equals(name)) {
				contacts.add(list.get(i));
			}
		}
		return contacts;
	}
	
	public ArrayList<Contact> searchForSurname(String surname) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getSurname().equals(surname)) {
				contacts.add(list.get(i));
			}
		}
		return contacts;
	}

	public ArrayList<Contact> searchForAlias(String alias) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getAlias().equals(alias)) {
				contacts.add(list.get(i));
			}
		}
		return contacts;
	}
	
	
	//delete contact
	public void deleteContact(Contact c) {
		list.remove(c);
	}
	
	
	//export contact
	public void exportContacts(String filename, String ext) {
		File file = new File(filename + "." + ext);
		
		//check the schedule is not empty
		if (!list.isEmpty()) {
			
			//export to text file
			FileWriter fr = null;
			if (ext.equals("txt")) {
				try {
					fr = new FileWriter(file);
					for (int i = 0; i < list.size(); ++i) {
						fr.write(list.get(i).toTextFile());
						fr.write(System.lineSeparator());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			//export to binary file (we will write the list)
			ObjectOutputStream ow = null;
			if (ext.equals("bin")) {
				try {
					ow = new ObjectOutputStream(new FileOutputStream(file));
					ow.writeObject(list);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						ow.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			//export to xml file
			if (ext.equals("xml")) {
				try {
					Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
					Element root = doc.createElement("contacts");
					doc.appendChild(root);
					
					for (Contact con : list) {
						Element element = doc.createElement("contact");
						root.appendChild(element);
						Element name = doc.createElement("name");
						name.appendChild(doc.createTextNode(con.getName()));
						element.appendChild(name);
						Element surname = doc.createElement("surname");
						surname.appendChild(doc.createTextNode(con.getSurname()));
						element.appendChild(surname);
						
						Element alias = doc.createElement("alis");
						alias.appendChild(doc.createTextNode(con.getAlias()));
						element.appendChild(alias);
						
						//write emails
						for (String str : con.getEmail()) {
							Element email = doc.createElement("email");
							email.appendChild(doc.createTextNode(str));
							element.appendChild(email);
						}
							
						Element adress = doc.createElement("adress");
						adress.appendChild(doc.createTextNode(con.getAdress()));
						element.appendChild(adress);
						Element phone = doc.createElement("phone");
						phone.appendChild(doc.createTextNode(con.getPhone()));
						element.appendChild(phone);
						
						//write mobiles
						for (String str : con.getMobile()) {
							Element mobile = doc.createElement("mobile");
							mobile.appendChild(doc.createTextNode(str));
							element.appendChild(mobile);
						}	
					}
					Transformer transform = TransformerFactory.newInstance().newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(file);
					transform.transform(source, result);
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerFactoryConfigurationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Nothing to export");
		}
		
	}
	
	
	public void importContacts(File file) {
		//cheking extention
		String path = file.toString();
		String ext = "";
		for (int i = path.length() - 3; i < path.length(); ++i) {
			ext += path.charAt(i);
		}
		
		//start switch
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		BufferedReader br = null;
		switch (ext) {
		
		//import text file
		case "txt":
			try {
				br = new BufferedReader(new FileReader(file));
				String content = "";
				String line = null;
				
				//each contact is new line
				while ((line = br.readLine()) != null) {
					Contact con = new Contact();
					StringTokenizer token = new StringTokenizer(line, "&");
					int aux = 0;
					String aux1 = "";
					
					//read stringToFile String
					while (token.hasMoreTokens()) {
						con.setName(token.nextToken());
						con.setSurname(token.nextToken());
						
						//when space it found we set attribute as empty
						aux1 = token.nextToken();
						if (aux1.equals(" ")) {
							con.setAlias("");
						} else {
							con.setAlias(token.nextToken());
						}
							
						//check emails array size
						aux = Integer.parseInt(token.nextToken());
						if (aux > 0) {
							for (int i = 0; i < aux; ++i) {
								con.getEmail().add(token.nextToken());
							}
						}
						
						//check space
						aux1 = token.nextToken();
						if (aux1.equals(" ")) {
							con.setAdress("");
						} else {
							con.setAdress(token.nextToken());
						}
						
						//check space
						aux1 = token.nextToken();
						if (aux1.equals(" ")) {
							con.setPhone("");
						} else {
							con.setPhone(token.nextToken());
						}
						
						//check mobiles array size
						aux = Integer.parseInt(token.nextToken());
						if (aux > 0) {
							for (int i = 0; i < aux; ++i) {
								con.getMobile().add(token.nextToken());
							}
						}
					}
					contacts.add(con);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			//import binary file
		case "bin":
			ObjectInputStream or = null;
			try {
				or = new ObjectInputStream(new FileInputStream(file));
				contacts = (ArrayList<Contact>) or.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					or.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
			
			//import xml file
		case "xml":
			try {
				XMLReader reader = XMLReaderFactory.createXMLReader();
				reader.setContentHandler(new SAXHandler(contacts));
				reader.parse(new InputSource(new FileInputStream(file)));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default:
			System.out.println("Invalid file type");
			break;
		}//end switch
		
		//set new schedule list 
		if (!contacts.isEmpty()) {
			setList(contacts);
		}
	}

}
