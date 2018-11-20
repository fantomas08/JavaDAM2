package sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Exercise1 extends DefaultHandler {

	private String value;
	private ArrayList<Desayunos> list;
	Desayunos breakfast;
	
	public Exercise1(ArrayList list) {
		this.list = list;
		value = null;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (localName.equals("desayuno")) {
			breakfast = new Desayunos();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		value = new String(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals("desayuno")) {
			list.add(breakfast);
		} 
		if (localName.equals("nombre")) {
			breakfast.setName(value);
		}
		if (localName.equals("precio")) {
			breakfast.setPrice(Float.parseFloat((value)));
		}
		if (localName.equals("descripcion")) {
			breakfast.setDescription(value);
		}
		if (localName.equals("calorias")) {
			breakfast.setCalories(Integer.parseInt(value));
		}
	}

}
