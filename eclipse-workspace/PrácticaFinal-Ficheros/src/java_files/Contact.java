package java_files;

public class Contact {
	
	private String name;
	private String surname;
	private String alias;
	private String email;
	private String adress;
	private String phone;
	private String mobile;
	
	public Contact(String name, String surname, String alias, String email, String adress, String phone,
			String mobile) {
		this.name = name;
		this.surname = surname;
		this.alias = alias;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", surname=" + surname + ", alias=" + alias + ", email=" + email + ", adress="
				+ adress + ", phone=" + phone + ", mobile=" + mobile + "]";
	}
	
	
}
