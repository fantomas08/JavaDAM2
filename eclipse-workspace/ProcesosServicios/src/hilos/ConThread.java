package hilos;

public class ConThread extends Thread {

	public ConThread(String str) {
		super(str);
	}
	
	public void run() {
		for (int i = 2; i < 100; ++i) {
			
			boolean primo = true;
			
			for (int j = 2; j < i; ++j) {
				if (i % j == 0) {
					primo = false;
				}
			}
			
			if (primo) {
				System.out.println(i + " " + getName());
			}
			
		}
		System.out.println("Proceso " +getName() + " finalizado");
	}
	
	
	public static void main(String[] args) {
		new ConThread("Thread1").start();
		new ConThread("Thread2").start();
	}

}
