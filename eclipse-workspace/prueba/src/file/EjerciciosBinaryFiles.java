package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EjerciciosBinaryFiles {

	private static String route = "E://DAM2/Acceso a datos/raiz/";
	private static File file;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	private static Scanner scan;
	
	public static void exercise1() throws IOException {
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
				fos = new FileOutputStream(file);
				dos = new DataOutputStream(fos);
				dos.writeUTF(key);
				System.out.println("Input your age");
				key = scan.nextLine();
				dos.writeInt(Integer.parseInt(key));
				System.out.println("Input your DNI");
				key = scan.nextLine();
				dos.writeUTF(key);
				fos.close();
				dos.close();
				break;
			case "b": 
				System.out.println("Input file name");
				key = scan.nextLine();
				file = new File(route + key);
				fis = new FileInputStream(file);
				dis = new DataInputStream(fis);
				System.out.println("nombre : " + dis.readUTF() + System.lineSeparator() +
						"edad : " + dis.readInt() + System.lineSeparator() + "DNI :" + dis.readUTF());
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
	
	public static void exercise2() throws IOException {
		file = new File(route + "dni.bin");
		fos = new FileOutputStream(file, true);
		dos = new DataOutputStream(fos);
		scan = new Scanner(System.in);
		System.out.println("Input your DNI");
		String dni = scan.nextLine();
		char last = dni.charAt(dni.length() - 1);
		if (Character.isDigit(last)) {
			System.out.println("Incorrect format");
		} else {
			String number = "";
			char[] digits = dni.toCharArray();
			for (int i = 0; i < digits.length - 1; ++i) {
				number += digits[i];
			}
			int rest = Integer.parseInt(number)%23;
			char[] letter = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
					'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
			if (letter[rest] == last) {
				dos.writeUTF(dni);
				
			} else {
				System.out.println("Incorrect DNI");
			}
		}
	}
	
	public static void exercise3(int x, int y) throws IOException {
		float [][] matrix = new float [x][y];
		//fill matrix
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				matrix[i][j] = (float) Math.random();
			}
		}
		
		//write on file
		file = new File(route + "matrix");
		fos = new FileOutputStream(file);
		dos = new DataOutputStream(fos);
		for (int i = 0; i < matrix.length; ++i) {
			 for (int j = 0; j < matrix[i].length; ++j) {
			   dos.writeFloat(matrix[i][j]);
			 }
		}
		
		//clean
		matrix = new float [x][y];
		
		//read from file
		file = new File(route + "matrix");
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
		scan = new Scanner(file);
		for (int i = 0; i < matrix.length; ++i) {
			 for (int j = 0; j < matrix[i].length; ++j) {
				  matrix[i][j] = dis.readFloat();
			 }
		}
		
		//print matrix
		for (int i = 0; i < matrix.length; ++i) {
			 for (int j = 0; j < matrix[i].length; ++j) {
			   System.out.println (matrix[i][j]);
			 }
		}
	}
	
	public static void exercise4() throws IOException {
		file = new File(route + "agenda");
		fos = new FileOutputStream(file, true);
		dos = new DataOutputStream(fos);
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
		scan = new Scanner(System.in);
		
		System.out.println("1. New Contact");
		System.out.println("2. Read Contact");
		String key = scan.nextLine();
		switch (key) {
		case "1":
			System.out.println("Name:");
			key = scan.nextLine();
			dos.writeUTF(key);
			System.out.println("Surname:");
			key = scan.nextLine();
			dos.writeUTF(key);
			System.out.println("Adress:");
			key = scan.nextLine();
			dos.writeUTF(key);
			System.out.println("Email:");
			key = scan.nextLine();
			dos.writeUTF(key);
			System.out.println("Phone:");
			key = scan.nextLine();
			dos.writeUTF(key);
			break;
		case "2":
			ArrayList<String> contacts = new ArrayList<String>();
			ArrayList<String> array = new ArrayList<String>();
			while (dis.available() > 0) {
				array.add(dis.readUTF());
			}
			System.out.println("Input Name");
			key = scan.nextLine();
			for (int i = 0; i < array.size(); ++i) {
				if (array.get(i).equals(key)) {
					contacts.add(array.get(i));
					contacts.add(array.get(i + 1));
					contacts.add(array.get(i + 2));
					contacts.add(array.get(i + 3));
					contacts.add(array.get(i + 4));
				}
			}
			System.out.println(contacts.toString());
			//System.out.println(array.toString());
		default:
			break;
		}
		
	}
	
	public static void exercise5() throws IOException {
		System.out.println("1. Registrar solicuitud");
		System.out.println("2. Analizar solicuitud");
		System.out.println("1. Analizar todas");
		scan = new Scanner(System.in);
		String inp = scan.nextLine();
		int num = 0;
		fis = new FileInputStream(file);
		dis = new DataInputStream(fis);
		switch (inp) {
		case "1":
			file = new File(route + "//becas//beca" + num);
			fos = new FileOutputStream(file, true);
			dos = new DataOutputStream(fos);
			System.out.println("Introduce nombre");
			inp = scan.nextLine();
			dos.writeUTF(inp);
			System.out.println("Introduce apellido");
			inp = scan.nextLine();
			dos.writeUTF(inp);
			System.out.println("Introduce edad");
			inp = scan.nextLine();
			dos.writeInt(Integer.parseInt(inp));
			System.out.println("Introduce nº modulos suspensos");
			inp = scan.nextLine();
			dos.writeInt(Integer.parseInt(inp));
			System.out.println("Introduce si vive en residencia familiar(si/no)");
			inp = scan.nextLine();
			if (inp == "si") {
				dos.writeBoolean(true);
			} else {
				dos.writeBoolean(false);
			}
			System.out.println("Introduce ingresos anuales(sin decimales)");
			inp = scan.nextLine();
			dos.writeInt(Integer.parseInt(inp));
			++num;
			dos.close();
			fos.close();
			break;
		case "2":
			int base = 100;
			System.out.println("Introduce numero fichero");
			inp = scan.nextLine();
			file = new File(route + "//becas//beca" + inp);
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			int age = dis.readInt();
			int susp = dis.readInt();
			boolean fr = dis.readBoolean();
			int entry = dis.readInt();
			if (entry <= 12000) {
				base += 500;
			}
			if (age < 25) {
				base += 200;
			}
			if (!fr) {
				base += 1000;
			}
			if (susp == 0) {
				base += 500;
			}
			if (susp >= 2) {
				base = 0;
			}
			System.out.println("Beca: " + base);
		default:
			break;
		}
	}
	
	//53906425Z
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		exercise4();
	}

}
