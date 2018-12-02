package files;

import java.io.*;

public class TextFiles {

	public static void ex4() {
		File file = new File("even.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileWriter fw = new FileWriter(file);
			System.out.println("Input a number");
			int num = Integer.parseInt(br.readLine());
			for (int i = num + 1; i <= num + 100; ++i) {
				if (i%2 == 0) {
					fw.write(i + System.getProperty("line.separator"));
				}
			}
			fw.close();
			br.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ex5() {
		File file = new File("even.txt");
		try {
			FileReader fr = new FileReader(file);
			int i = 0;
			while ((i = fr.read()) != -1) {
				if (Character.isDigit((char)i)) {
					System.out.println((char)i);
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//ex4();
		ex5();
	}

}
