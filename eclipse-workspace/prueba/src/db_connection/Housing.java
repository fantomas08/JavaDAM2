package db_connection;

public class Housing {

	private String name;
	private String adress;
	private String tlf;
	private int n_hab;
	
	public Housing(String name, String adress, String tlf, int n_hab) {
		this.name = name;
		this.adress = adress;
		this.tlf = tlf;
		this.n_hab = n_hab;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getN_hab() {
		return n_hab;
	}

	public void setN_hab(int n_hab) {
		this.n_hab = n_hab;
	}

	@Override
	public String toString() {
		return "Housing [name=" + name + ", adress=" + adress + ", tlf=" + tlf + ", n_hab=" + n_hab + "]";
	}

}
