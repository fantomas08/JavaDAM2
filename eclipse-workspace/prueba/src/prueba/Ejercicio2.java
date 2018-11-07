package prueba;

import java.io.*;

public class Ejercicio2 {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("input a number");
        int n = Integer.parseInt(br.readLine());
        boolean b1 = true;
        int count = 0;
        
        for (int i = 2; i < n; ++i) {
        	b1 = true;
        	for (int j = 2; j < i; ++j) {
            	if (i%j == 0) {
            		b1 = false;
            	}
            }
            if (b1 == true) {
            	System.out.println(i);
            	count ++;
            }
        }
        System.out.println(n + " tiene " + count + " numeros primos");
        
        
		
	}//main
}
