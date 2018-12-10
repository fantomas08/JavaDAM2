package hilos;

public class SinHilos {

	//muestra los 100 primeros numeros primos
		public static void numerosPrimos() {
			for (int i = 2; i < 100; ++i) {
				
				boolean primo = true;
				
				for (int j = 2; j < i; ++j) {
					if (i % j == 0) {
						primo = false;
					}
				}
				
				if (primo) {
					System.out.println(i);
				}
				
			}
			System.out.println("Proceso finalizado");
		}
		
		
		public static void main(String[] args) {
			numerosPrimos();
			numerosPrimos();
		}

}
