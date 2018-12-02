package java_files;

import java.io.*;
import java.util.ArrayList;

public class Menu {
	
	private static Schedule schedule = new Schedule();
	private static String input;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void startMenu() {
		//load list when program start
		schedule.loadList();
		
		try {
			do {
				System.out.println("-----------------------");
				System.out.println("1) Add Contact");
				System.out.println("2) Search Contact");
				System.out.println("3) Export Schedule");
				System.out.println("4) Import Schedule");
				System.out.println("5) Exit");
				System.out.println("-----------------------");
				input = br.readLine();
				
				switch (input) {
				case "1":
					//add new contact
					addMenu();
					break;
					
				case "2":
					//search for contacts
					searchMenu();
					break;
					
				case "3":
					//export file
					exportMenu();
					break;
					
				case "4":
					//import file
					break;
					
				default:
					System.out.println("Invalid option");
					System.out.println(schedule.getList().toString());
					break;
					
				case "5":
					//save list on exit
					schedule.saveList();
					System.out.println("Bye");
				}
			} while (!input.equals("5"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void addMenu() throws IOException {
		Contact contact = new Contact();
		do {
			System.out.println("Input name*");
			input = br.readLine();
		} while (input.equals(""));
		contact.setName(input);
		
		do {
			System.out.println("Input surname*");
			input = br.readLine();
		} while (input.equals(""));
		contact.setSurname(input);
		
		System.out.println("Input alias");
		input = br.readLine();
		contact.setAlias(input);
		System.out.println("Input adress");
		input = br.readLine();
		contact.setAdress(input);
		
		do {
			System.out.println("Input email");
			input = br.readLine();
			contact.getEmail().add(input);
			System.out.println("Add another email?");
			System.out.println("1)Yes 2)No");
			input = br.readLine();	
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid option");
				input = br.readLine();
			}
		} while (input.equals("1"));
		
		System.out.println("Input phone");
		input = br.readLine();
		contact.setPhone(input);
		
		do {
			System.out.println("Input mobile");
			input = br.readLine();
			contact.getMobile().add(input);
			System.out.println("Add another mobile?");
			System.out.println("1)Yes 2)No");
			input = br.readLine();	
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid option");
				input = br.readLine();
			}
		} while (input.equals("1"));
		
		//add new contact to the list
		schedule.addContact(contact);
		System.out.println("Succefuly added");
	}
	
	
	private static void searchMenu() throws IOException {
		Contact contact = new Contact();
		ArrayList<Contact> contacts = null;
		System.out.println("-----------------------");
		System.out.println("1) Search by Name");
		System.out.println("2) Search by Surname");
		System.out.println("3) Search by Alias");
		System.out.println("-----------------------");
		input = br.readLine();
		
		//start switch
		switch (input) {
		case "1":
			System.out.println("Input name");
			input = br.readLine();
			contacts = schedule.searchForName(input);
			break;
		case "2":
			System.out.println("Input Surname");
			input = br.readLine();
			contacts = schedule.searchForSurname(input);
			break;
		case "3":
			System.out.println("Input Alias");
			input = br.readLine();
			contacts = schedule.searchForAlias(input);
			break;
		default:
			System.out.println("Invalid option");
			break;
		}//end switch
		
		if (contacts.isEmpty()) {
			System.out.println("Not found");
		} else {
			
			//show or select the contact
			if (contacts.size() > 1) {
				//show all contacts found with index
				for (int i = 0; i < contacts.size(); ++i) {
					System.out.println((i + 1) + ") " + contacts.get(i).toString());
				}
				System.out.println("Chose the contact");
				input = br.readLine();
				if (Integer.parseInt(input) > contacts.size() || Integer.parseInt(input) < 0) {
					System.out.println("Invalid option");
				} else {
					contact = contacts.get( Integer.parseInt(input) - 1 );
				}
			} else {
				contact = contacts.get(0);
			}
			System.out.println(contact.toString());
			
			//modify or delete
			do {
				System.out.println("-----------------------");
				System.out.println("1) Modify Contact");
				System.out.println("2) Delete Contact");
				System.out.println("3) Return");
				System.out.println("-----------------------");
				input = br.readLine();
				
				//start switch
				switch (input) {
				case "1":
					//modify contact
					modifyMenu(contact);
					break;
				case "2":
					//delete contact
					schedule.deleteContact(contact);
					System.out.println("Succefuly deleted");
					break;
				case "3":
					System.out.println("Done");
					break;
				default:
					System.out.println("Invalid option");
					break;
				}//end switch
			} while (!input.equals("3"));
		}
	}
	
	
	private static void exportMenu() throws IOException {
		System.out.println("Input file path (optional)");
		input = br.readLine();
		String filename = input;
		System.out.println("Input file name");
		input = br.readLine();
		filename += input;
		System.out.println("Input file extention");
		System.out.println("-----------------------");
		System.out.println("1) txt");
		System.out.println("2) bin");
		System.out.println("3) xml");
		System.out.println("-----------------------");
		input = br.readLine();
		String ext = input;
		File file = new File(filename + ext);
		if (file.exists()) {
			System.out.println("File with this path already exist. You are going to override it");
		}
		
		//start switch
		switch (input) {
		case "1":
			ext = "txt";
			schedule.exportContacts(filename, ext);
			System.out.println("Contacts list exported");
			break;
		case "2":
			ext = "bin";
			schedule.exportContacts(filename, ext);
			System.out.println("Contacts list exported");
			break;
		case "3":
			ext = "xml";
			schedule.exportContacts(filename, ext);
			System.out.println("Contacts list exported");
			break;
		default:
			System.out.println("Invalid option");
			break;
		}//end switch
	}
	
	
	private static void importMenu() throws IOException {
		System.out.println("Input file path (specify file extention)");
		input = br.readLine();
		File file = new File(input);
		
		//check that file exist
		if (file.exists()) {
			schedule.importContacts(file);
		} else {
			System.out.println("File not found. Unable to import");
		}
	}
	
	
	private static void modifyMenu(Contact contact) throws IOException {
		Contact changed = new Contact();
		do {
			System.out.println("-----------------------");
			System.out.println("1) Change name");
			System.out.println("2) Change surname");
			System.out.println("3) Change alias");
			System.out.println("4) Change adress");
			System.out.println("5) Change email");
			System.out.println("6) Change phone");
			System.out.println("7) Change mobile");
			System.out.println("8) Return");
			System.out.println("-----------------------");
			input = br.readLine();
			
			//start switch
			switch (input) {
			case "1":
				do {
					System.out.println("Input new name*");
					input = br.readLine();
				} while (input.equals(""));
				contact.setName(input);
				break;
				
			case "2":
				do {
					System.out.println("Input new surname*");
					input = br.readLine();
				} while (input.equals(""));
				contact.setSurname(input);
				break;
				
			case "3":
				System.out.println("Input new alias");
				input = br.readLine();
				contact.setAlias(input);
				break;
				
			case "4":
				System.out.println("Input new adress");
				input = br.readLine();
				contact.setAdress(input);
				break;
				
			case "5":
				setEmile(contact);
				break;
				
			case "6":
				System.out.println("Input new phone");
				input = br.readLine();
				contact.setPhone(input);
				break;
				
			case "7":
				modifyMobile(contact);
				break;
				
			case "8":

				break;
			default:
				System.out.println("Invalid option");
				break;
			}//end switch
		} while (!input.equals("8"));
	}
	
	//new
	private static void setEmile(Contact contact) throws IOException {
		do {	
			System.out.println("1) New email");
			System.out.println("2) Modify existent email");
			System.out.println("3) Return");
			input = br.readLine();
			
			switch (input) {
			case "1":
				System.out.println("Input new email");
				input = br.readLine();
				contact.getEmail().add(input);
				System.out.println("New emile added");
				break;
				
			case "2":
				//System.out.println(contact.getEmail().isEmpty());
				//System.out.println(contact.getEmail().size());
				if (contact.getEmail().size() <= 1) {
					System.out.println("This contact dont have email");
				}else {
					System.out.println(contact.getEmail().toString());
					System.out.println("Select array position (start from 0)");
					input = br.readLine();
					int aux = Integer.parseInt(input);
					System.out.println(contact.getEmail().get(aux));
					System.out.println("Input new email");
					input = br.readLine();
					contact.getEmail().set(aux, input);
				}	
			default:
				//System.out.println("Wrong option");
				break;
						}
		} while (!input.equals("3"));		
	}
	
	//old
	private static void modifyEmile(Contact contact) throws IOException {
		do {	
			System.out.println("1) New email");
			System.out.println("2) Modify existent email");
			System.out.println("3) Return");
			input = br.readLine();
			
			if (input.equals("1")) {
				System.out.println("Input new email");
				input = br.readLine();
				contact.getEmail().add(input);
				if (input.equals("2")) {
					
					//check you have any email
					if (!contact.getEmail().isEmpty()) {
						for (int i = 0; i < contact.getEmail().size(); ++i) {
							System.out.println(contact.getEmail().get(i).toString());
						}
						
						
						//check emails you have
						if (contact.getEmail().size() > 1) {
							System.out.println("Select array position (start from 0)");
							input = br.readLine();
							int aux = Integer.parseInt(input);
							System.out.println(contact.getEmail().get(aux));
							System.out.println("Input new email");
							input = br.readLine();
							contact.getEmail().set(aux, input);
						} else {
							System.out.println("Input new email");
							input = br.readLine();
							contact.getEmail().set(0, input);
						}
						
						
					} else {
						System.out.println("This contact dont have any email ");
					}
				} else {
					System.out.println("Invalid option");
				}
			}
		} while (!input.equals("3"));	
	}
	
	
	private static void modifyMobile(Contact contact) throws IOException {
		do {	
			System.out.println("1) New mobile");
			System.out.println("2) Modify existent mobile");
			System.out.println("3) Return");
			input = br.readLine();
			
			if (input.equals("1")) {
				System.out.println("Input new Mobile");
				input = br.readLine();
				contact.getMobile().add(input);
				if (input.equals("2")) {
					
					//check you have any email
					if (!contact.getMobile().isEmpty()) {
						
						if (contact.getMobile().size() > 1) {
							System.out.println(contact.getMobile().toString());
							System.out.println("Select array position (start from 0)");
							input = br.readLine();
							int aux = Integer.parseInt(br.readLine());
							System.out.println(contact.getMobile().get(aux));
							System.out.println("Input new Mobile");
							input = br.readLine();
							contact.getMobile().set(aux, input);
						} else {
							System.out.println(contact.getMobile().toString());
							System.out.println("Input new Mobile");
							input = br.readLine();
							contact.getMobile().set(0, input);
						}
					} else {
						System.out.println("This contact dont have any Mobile ");
					}
				} else {
					System.out.println("Invalid option");
				}
			}
		} while (!input.equals("3"));	
	}
	
	
	public static void main(String[] args) {
		
		startMenu();
	}

}
