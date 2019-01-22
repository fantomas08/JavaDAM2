package filosofos;

import hilos.ConRunnable;

public class Filosofo implements Runnable {

	int left;
	int right;
	Palillos gestor; 
	
	public Filosofo(int left, int right ,Palillos gestor) {
		this.left = left;
		this.right = right;
		this.gestor = gestor;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		while (true) {
			if (gestor.palillosLibres(left, right)) {
				esperar(name, "comiendo");
				gestor.soltarPalillos(left, right);
				esperar(name, "pensando");
			}
		}
		
	}
	
	private void esperar(String name, String accion) {
		try {
			int mils = 1000 + (int)(Math.random() * ((5000 - 1000) + 1));
			System.out.println(name + " " + accion);
			Thread.sleep(mils);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int filosofos = 5;
		Palillos gestor = new Palillos(filosofos);
		
		for (int i = 0; i < 5; ++i) {
			if (i == 0) {
				new Thread(new Filosofo(i, filosofos -1, gestor), ("Filosofo" + i)).start();
			} else {
				new Thread(new Filosofo(i, i - 1, gestor), ("Filosofo" + i)).start();
			}
		}
	}

}
