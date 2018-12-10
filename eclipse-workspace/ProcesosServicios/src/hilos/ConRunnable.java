package hilos;

public class ConRunnable implements Runnable {

	
	@Override
	public void run() {
		for (int i = 2; i < 100; ++i) {
			
			boolean primo = true;
			
			for (int j = 2; j < i; ++j) {
				if (i % j == 0) {
					primo = false;
				}
			}
			
			if (primo) {
				System.out.println(i + Thread.currentThread().getName());
			}
			
		}
		System.out.println("Proceso finalizado " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		new Thread(new ConRunnable(), "Thread1").start();
		new Thread(new ConRunnable(), "Thread2").start();
	}


	

}
