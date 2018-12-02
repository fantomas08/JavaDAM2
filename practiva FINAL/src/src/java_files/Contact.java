package java_files;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3249875777694181953L;
	private String name;
	private String surname;
	private String alias;
	private ArrayList<String> email;
	private String adress;
	private String phone;
	private ArrayList<String> mobile;
	
	public Contact(String name, String surname, String alias, ArrayList<String> email, String adress, String phone,
			ArrayList<String> mobile) {
		this.name = name;
		this.surname = surname;
		this.alias = alias;
		this.email = email;
		this.adress = adress;
		this.phone = phone;
		this.mobile = mobile;
	}
	
	public Contact() {
		this.name = "";
		this.surname = "";
		this.alias = "";
		this.email = new ArrayList<String>();
		this.adress = "";
		this.phone = "";
		this.mobile = new ArrayList<String>();
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

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
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

	public ArrayList<String> getMobile() {
		return mobile;
	}

	public void setMobile(ArrayList<String> mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", surname=" + surname + ", alias=" + alias + ", email=" + email.toString() + ", adress="
				+ adress + ", phone=" + phone + ", mobile=" + mobile.toString() + "]";
	}
	
	
	/* Special string that i use to export and import as text file
	 * It use & as only delimiter, because i think is not probably to find this symbol in strings we gonna use
	 * It write space when the attribute is empty.
	 */
	public String toTextFile() {
		String string = name + "&" + surname + "&";
		if (alias.equals("")) {
			string += " ";
		} else {
			string += alias;
		}
		string += "&";
		string += emailToString();
		if (adress.equals("")) {
			string += " ";
		} else {
			string += adress;
		}
		string += "&";
		if (phone.equals("")) {
			string += " ";
		} else {
			string += phone;
		}
		string += "&";
		string += mobileToString();
		return string;
	}
	
	
	//write array size of email and mobile to write properly
	private String emailToString() {
		String string = email.size() + "&";
		if (email.size() > 0) {
			for (int i = 0; i < email.size(); ++i) {
				string += email.get(i) + "&";
			}
		}
		return string;
	}
	
	private String mobileToString() {
		String string = mobile.size() + "&";
		if (mobile.size() > 0) {
			for (int i = 0; i < mobile.size(); ++i) {
				string += mobile.get(i) + "&";
			}
		}
		return string;
	}
}
