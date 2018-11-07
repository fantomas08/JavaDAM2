package file;

import java.io.*;

public class EjerciciosFile {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static File file;
	
	public static void ex1(String route) {
		file = new File(route);
		if (file.isDirectory()) {
			
			if (!file.delete()) {
				if(file.list().length != 0) {
					System.out.println("el directorio no esta vacio");
				}
			}
		}
	}
	
	public static void ex2(String route) {
		file = new File(route);
		if (file.isDirectory()) {
			
			if(file.list().length == 0) {
				file.delete();
			} else {
				System.out.println("el directorio contiene elementos");
				System.out.println("desea borrar el directorio y todos sus elementos ?(S/N)");
				try {
					if( ((br.readLine().equals("S")) || (br.readLine().equals("s")))) {
						RecursiveDelete(file);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	private static void RecursiveDelete(File file) {
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; ++i) {
			if (!list[i].delete()) {
				RecursiveDelete(list[i]);
			}
		}
		file.delete();
	}
	
	public static void ex3(String route) {
		file = new File(route);
		if (file.exists()) {
			System.out.println(file.getName());
			try {
				System.out.println(file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("tamaño: " + file.length() + " bytes");
		} else {
			file.mkdirs();
		}
	}
	
	public static boolean ex4(String dir, String name) throws IOException {
		file = new File(dir);
		File [] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				if (f.getName().equals(name)) {
					System.out.println(f.getCanonicalPath());
					return true;
				} else {
					if (ex4(f.getPath(), name)) {
						return true;
					}
				}
			}
		}
		System.out.println("No encontrado");
		return false;
	}
	
	public static void main(String[] args) {
		
		try {
			ex4("E://DAM2", "b.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
