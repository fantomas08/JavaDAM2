package filosofos;

public class Palillos {

	boolean[] palillos;
	
	public Palillos(int num) {
		palillos = new boolean[num];
	}
	
	public synchronized boolean palillosLibres(int left, int right) {
		if (!palillos[left] && !palillos[right]) {
			palillos[left] = true;
			palillos[right] = true;
			return true;
		}
		return false;
	}
	
	public synchronized void soltarPalillos(int left, int right) {
		palillos[left] = false;
		palillos[right] = false;
	}
}
