package file;

import java.io.*;
import java.util.*;

public class EjerciciosTextFiles {
	
	private static String delim = System.getProperty("line.separator");
	private static String route = "E://DAM2/Acceso a datos/raiz/";
	private static File file;
	private static FileReader fr;
	private static FileWriter fw;
	private static Scanner scan;
	
	public static void exercise1() {
		file = new File(route + "a.txt");
		int i;
		String chain = "";
		try {
			fr = new FileReader(file);
			while ((i = fr.read()) != -1) {
				if (i != ((int)' ')) {
					chain += ((char)i);
				}
			}
			System.out.println(chain);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void exercise2() {
		file = new File(route + "numeros.txt");
		int i;
		int number = 0;
		String chain = "";
		try {
			fr = new FileReader(file);
			while ((i = fr.read()) != -1) {
				chain += ((char)i);
			}
			StringTokenizer token = new StringTokenizer(chain, delim);
			while (token.hasMoreTokens()) {
				number += Integer.parseInt(token.nextToken());
			}
			System.out.println(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void exercise3() throws IOException {
		scan = new Scanner(System.in);
		String key = "";
		boolean bool = true;
		while (bool) {
			System.out.println("Exercise 3");
			System.out.println("a) Create file");
			System.out.println("b) Read file");
			System.out.println("c) Exit");
			key = scan.nextLine();
			switch (key) {
			case "a": 
				System.out.println("Input file name");
				key = scan.nextLine();
				file = new File(route + key);
				file.createNewFile();
				System.out.println("Input your name");
				key = scan.nextLine();
				fw = new FileWriter(file);
				fw.write(key);
				System.out.println("Input your last name");
				key = scan.nextLine();
				fw.write(delim + key);
				System.out.println("Input your born city");
				key = scan.nextLine();
				fw.write(delim + key);
				fw.close();
				break;
			case "b": 
				System.out.println("Input file name");
				key = scan.nextLine();
				int i = 0;
				String content = "";
				file = new File(route + key);
				fr = new FileReader(file);
				while ((i = fr.read()) != -1) {
					content += (char)i;
				}
				System.out.println(content);
				break;
			case "c":
				bool = false;
				System.out.println("Bye");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}
	
	public static void exercise4() throws IOException {
		file = new File(route + "even.txt");
		scan = new Scanner(System.in);
		System.out.println("Input a number");
		String key = scan.nextLine();
		int num = Integer.parseInt(key);
		fw = new FileWriter(file);
		for (int i = num; i < num + 100; ++i) {
			if (i%2 == 0) {
				key += i + " ";
			}
		}
		fw.write(key);
		fw.close();
	}
	
	public static void main(String[] args) throws IOException {
		exercise4();

	}

}
