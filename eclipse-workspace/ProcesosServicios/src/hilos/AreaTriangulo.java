package hilos;

public class AreaTriangulo implements Runnable {

	
	private int base;
	private int altura;
	
	public AreaTriangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public void run() {
		float area = base * altura / 2;
		System.out.println("Base: " + base);
		System.out.println("Altura: " + altura);
		System.out.println("Area " + area);
		System.out.println(Thread.currentThread().getName() + " finalizado");
		//System.out.println();
	}

	public static int getRandomValue() {
		return (int)(Math.random()*100);
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 11; ++i) {
			new Thread(new AreaTriangulo(getRandomValue(), getRandomValue()), "Thread " + i).start();
		}
	}
	
}
