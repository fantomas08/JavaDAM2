package serializable;

import java.io.*;
import java.util.ArrayList;

public class Agenda implements Serializable {

	private static File file = new File("Agenda");
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static Contact contact;
	//private static ArrayList<Contact> list = new ArrayList<Contact>();
	
	public static ArrayList read() {
		ArrayList list = new ArrayList();
		try {
			if (!file.exists()) {
				return list;
			}
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			while (true) {
				list.add(ois.readObject());
			}
		} catch (EOFException e) {
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public static void add(String name, String lastname) {
		contact = new Contact(name, lastname);
		try {
			ArrayList list = read();
			list.add(contact);
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < list.size(); ++i) {
				oos.writeObject(list.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		add("yevgen", "chaynykov");
		add("alex", "maliga");
		System.out.println(read().toString());
	}

}
