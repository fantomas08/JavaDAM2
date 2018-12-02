package java_files;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	private String value;
	private ArrayList<Contact> list;
	private Contact contact;
	
	public SAXHandler(ArrayList list) {
		this.list = list;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName.equals("contact")) {
			contact = new Contact();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		value = new String(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals("contact")) {
			list.add(contact);
		}
		if (localName.equals("name")) {
			contact.setName(value);
		}
		if (localName.equals("surname")) {
			contact.setSurname(value);
		}
		if (localName.equals("alias")) {
			contact.setAlias(value);
		}
		
		if (localName.equals("email")) {
			contact.getEmail().add(value);
		}
		
		if (localName.equals("adress")) {
			contact.setAdress(value);
		}
		
		if (localName.equals("phone")) {
			contact.setPhone(value);
		}
		
		if (localName.equals("mobile")) {
			contact.getMobile().add(value);
		}
		
		value= null;
	}
}
