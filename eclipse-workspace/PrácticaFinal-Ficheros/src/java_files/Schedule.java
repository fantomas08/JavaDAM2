package java_files;

import java.io.File;
import java.util.ArrayList;

public class Schedule {

	private ArrayList<Contact> list;
	
	public Schedule() {
		list = new ArrayList<Contact>();
	}
	
	public void addC(Contact c) {
		list.add(c);
	}
	
	public ArrayList<Contact> searchC(Contact c) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i = 0; i < list.size(); ++i) {
			if ((list.get(i).getName() == c.getName()) || (list.get(i).getSurname() == c.getSurname()) ||
					(list.get(i).getAlias() == c.getAlias()) ) {
				contacts.add(list.get(i));
			}
		}
		return contacts;
	}
	
	public void modifyC(Contact c, Contact changes) {
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).equals(c)) {
				list.set(i, changes);
			}
		}
	}
	
	public void deleteC(Contact c) {
		list.remove(c);
	}
	
	public void exportC(File file, String ext) {
		//export to text file
		if (ext.equals("txt")) {
			
		}
		
		//export to binary file
		if (ext.equals("bin")) {
			
		}
		
		//export to xml file
		if (ext.equals("xml")) {
			
		}
	}
	
	public void importC(File file) {
		
	}
}
