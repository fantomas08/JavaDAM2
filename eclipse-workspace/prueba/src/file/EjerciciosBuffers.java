package file;

import java.io.*;
import java.util.Scanner;

public class EjerciciosBuffers {

	private static String delim = System.getProperty("line.separator");
	private static String route = "E://DAM2/Acceso a datos/raiz/";
	private static File file;
	private static FileReader fr;
	private static FileWriter fw;
	private static Scanner scan = new Scanner(System.in);
	private static BufferedReader br;
	private static BufferedWriter bw;
	
	public static void exercise1() throws IOException {
		file = new File(route + "a.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		int i = 0;
		String chain = "";
		while ((i = br.read()) != -1) {
			if (i != ((int)' ')) {
				chain += ((char)i);
			}
		}
		System.out.println(chain);
	}
	
	public static void exercise2() throws IOException {
		file = new File(route + "numeros.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		int result = 0;
		String chain;
		while ((chain = br.readLine()) != null) {
			result += Integer.parseInt(chain);
		}
		System.out.println(result);
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
				bw = new BufferedWriter(fw);
				bw.write(key);
				bw.newLine();
				System.out.println("Input your last name");
				key = scan.nextLine();
				bw.write(key);
				bw.newLine();
				System.out.println("Input your born city");
				key = scan.nextLine();
				bw.write(key);
				bw.close();
				fw.close();
				break;
			case "b": 
				System.out.println("Input file name");
				key = scan.nextLine();
				String content = "";
				String output = "";
				file = new File(route + key);
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while (br.ready()) {
					output += br.readLine();
				}
				System.out.println(output);
				br.close();
				fr.close();
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

	public void exercise4() {
	
	}
	
	public static void main(String[] args) throws IOException {
		exercise3();
	}

}
