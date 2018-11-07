package prueba;

import java.io.File;

public class FileExample {

	
	
	public static void main(String[] args) {

		//crear un fichero y nos muestra el nombre, la ruta relativa, absoluta, el tamaño,
		//y decir si es un fichero o directorio
		
		File f = new File("E://DAM2/Acceso a datos/fichero_prueba.txt");
		System.out.println("Nombre: " + f.getName());
		System.out.println("Ruta relativa: " + f.getPath());
		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
		System.out.println("Tamaño(byte): " + f.length());
		if (f.isDirectory()) {
			System.out.println("Es un directorio");
		} else {
			System.out.println("Es un fichero");
		}
		
	}

}

