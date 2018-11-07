package serializable;

import java.io.Serializable;

public class Contact implements Serializable {

	private String name;
	private String lastname;
	private String adress;
	private String email;
	private String tlf;
	
	public Contact(String name, String lastname, String adress, String email, String tlf) {
		this.name = name;
		this.lastname = lastname;
		this.adress = adress;
		this.email = email;
		this.tlf = tlf;
	}
	
	public Contact(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
		this.adress = null;
		this.email = null;
		this.tlf = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", lastname=" + lastname + ", adress=" + adress + ", email=" + email + ", tlf="
				+ tlf + "]";
	}
}
