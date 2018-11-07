package file;

import java.io.*;

public class TextFiles {
	
	public static void Reader() {
		File file = new File("E://DAM2/Acceso a datos/raiz/a.txt");
		int i;
		FileReader fr;
		try {
			fr = new FileReader(file);
			char[] buf = new char[20];
			
			while ((i=fr.read(buf))!= -1) {
				System.out.println(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Writer() {
		
	}

	public static void main(String[] args) {
		
		
		
	}

}
