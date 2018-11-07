package prueba;

import java.io.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean b = true;
		int num = 0;
		int max = 0;
		int max_count = 0;
		
		do {
			System.out.println("input a number");
			try {
				num = Integer.parseInt(br.readLine());
				if (num < 0) {
					b = false;
				}
				if (num > max) {
					max = num;
					max_count = 0;
				}
				if (num == max) {
					++max_count; 
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (b);
		System.out.println("mayor es " + max);
		System.out.println("se repite " + max_count + " veces");
	}

}
