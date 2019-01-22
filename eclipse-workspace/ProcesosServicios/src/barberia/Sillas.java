package barberia;

public class Sillas {

	boolean[] libres;
	boolean[] ocupadas;
	
	public Sillas(int numSillas) {
		libres = new boolean[numSillas];
		ocupadas = new boolean[numSillas];
	}
	
	public synchronized int buscarAsiento() {
		for (int i = 0; i < libres.length; ++i) {
			if (!libres[i]) {
				libres[i] = true;
				System.out.println("Cliente sentado en silla " + i);
				return i;
			}
		}
	return -1;	
	}
}
