package db_connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Menu {
	
	private static Scanner scan = new Scanner(System.in);
	private static String input = "";
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement s = null;
	
	//start menu
	public static void launchMenu() {
		do {
			System.out.println("Select Data Base");
			System.out.println("1) SQLite");
			System.out.println("2) Apache Derby");
			System.out.println("3) HSQLDB");
			System.out.println("4) H2");
			System.out.println("5) DB4O");
			System.out.println("6) Exit");
			
			input = scan.nextLine();
			switch (input) {
			case "1":
				con = SQLite.getConnection();
				SQLMenu();
				break;
			case "2":
				con = ApacheDerby.getConnection();
				SQLMenu();
				break;
			case "3":
				con = HSQLDB.getConnection();
				SQLMenu();
				break;
			case "4":
				con = H2.getConnection();
				SQLMenu();
				break;
			case "5":
				DB4OMenu();
				break;
			case "6":
				System.out.println("Bye");
				
				//close connection on exit
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (!input.equals("6"));
		
	}
	
	//query menu
	public static void SQLMenu() {
		do {
			System.out.println("Select Query");
			System.out.println("1) Search rooms under your price");
			System.out.println("2) See housing number phone");
			System.out.println("3) Search housing with bath");
			System.out.println("4) See housing individual rooms number");
			System.out.println("5) See housing double rooms number");
			System.out.println("6) See housing triple rooms number");
			System.out.println("7) See housing adress");
			System.out.println("8) See all housings");
			System.out.println("9) Exit");
			
			input = scan.nextLine();
			switch (input) {
			case "1":
				DBMetaData.getBDMetaData(con);
				System.out.println("Input price");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE precio<" + Float.parseFloat(input));
					boolean bool = false;
					
					while (rs.next()) {
						bool = true;
						Room room = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getFloat(4), rs.getString(5));
						System.out.println(room.toString());
					}
					if (!bool) {
						System.out.println("No result");
					}
					System.out.println();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "2":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT tlf FROM alojamientos WHERE nombre='" + input + "'");
					
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
					System.out.println();
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "3":
				
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT aloj FROM habitaciones WHERE bano=true");
					ArrayList array = new ArrayList();
					
					while (rs.next()) {
						boolean bool = true;
						for (int i = 0; i < array.size(); ++i) {
							if (array.get(i).equals(rs.getString(1))) {
								bool = false;
							}
						}
						if (bool) {
							array.add(rs.getString(1));
						}
					}
					System.out.println(array.toString());
					System.out.println();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "4":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE tipo='i' AND aloj='" + input + "'");
					int count = 0;
					
					while (rs.next()) {
						++count;
					}
					System.out.println(count + " individual rooms");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "5":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE tipo='d' AND aloj='" + input + "'");
					int count = 0;
					
					while (rs.next()) {
						++count;
					}
					System.out.println(count + " double rooms");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "6":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE tipo='t' AND aloj='" + input + "'");
					int count = 0;
					
					while (rs.next()) {
						++count;
					}
					System.out.println(count + " triple rooms");
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			case "7":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT dir FROM alojamientos WHERE nombre='" + input + "'");
					
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
					System.out.println();
	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break; 
				
			case "8":
	
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM alojamientos");
					
					while (rs.next()) {
						Housing housing = new Housing(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						System.out.println(housing.toString());
					}
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
						if (s != null) {
							s.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
				
			default:
				System.out.println("Invalid option");
				break;
				
			}
		} while (!input.equals("9"));
	}

	//query menu for DB4O
	public static void DB4OMenu() {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "E:\\DAM2\\JavaDAM2\\bd_db4o\\ALOJAMIENTOS.yap");
		Housing h = null;
		Room r = null;
		ObjectSet<Housing> hr = null;
		ObjectSet<Room> rr = null;
		
		/* This is used once to store Objects
		 *  
		Housing h1 = new Housing("Villa Aurora", "calle Aurora 23", "698745218", 10);
		Housing h2 = new Housing("Las Rosas", "avenida Rosas 14", "952458712", 20);
		Housing h3 = new Housing("Villa Nueva de Odon", "carrera San Jorge km 45", "956312547", 10);
		
		Room r1 = new Room(1, "i", true, 65.50f, "Villa Aurora");
		Room r2 = new Room(2, "d", false, 75.40f, "Villa Aurora");
		Room r3 = new Room(3, "d", true, 89.50f, "Las Rosas");
		Room r4 = new Room(4, "t", true, 112.30f, "Las Rosas");
		Room r5 = new Room(5, "t", false, 88.40f, "Villa Nueva de Odon");
		Room r6 = new Room(6, "t", true, 89.50f, "Villa Nueva de Odon");
		
		db.store(h1);
		db.store(h2);
		db.store(h3);
		db.store(r1);
		db.store(r2);
		db.store(r3);
		db.store(r4);
		db.store(r5);
		db.store(r6);*/
		
		do {
			System.out.println("Select Query");
			System.out.println("1) Search rooms under your price");
			System.out.println("2) See housing number phone");
			System.out.println("3) Search housing with bath");
			System.out.println("4) See housing individual rooms number");
			System.out.println("5) See housing double rooms number");
			System.out.println("6) See housing triple rooms number");
			System.out.println("7) See housing adress");
			System.out.println("8) See all housings");
			System.out.println("9) Exit");
			
			input = scan.nextLine();
			switch (input) {
			case "1":
				
				System.out.println("Input price");
				input = scan.nextLine();
				
				r = new Room(0, null, false, 0, null);
				rr = db.queryByExample(r);
				
				while (rr.hasNext()) {
					Room obj;
					if ((obj = rr.next()).getPrice() < Float.parseFloat(input)) {
						System.out.println(obj.toString());
					}
				}
				break;
				
			case "2":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				
				h = new Housing(input, null, null, 0);
				hr = db.queryByExample(h);
				
				if (hr.size() == 0) {
					System.out.println("No result");
				} else {
					h = hr.next();
					System.out.println(h.getTlf());
					System.out.println();
				}
				break;
				
			case "3":
				
				r = new Room(0, null, true, 0, null);
				rr = db.queryByExample(r);
				ArrayList list = new ArrayList();
				
				while (rr.hasNext()) {
					boolean bool = true;
					Room obj = rr.next();
					for (int i = 0; i < list.size(); ++i) {
						if (list.get(i).equals(obj.getH_name())) {
							bool = false;
						}
					}
					if (bool) {
						list.add(obj.getH_name());
					}
				}
				System.out.println(list.toString());
				System.out.println();
				break;
				
			case "4":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				
				r = new Room(0, null, false, 0, input);
				rr = db.queryByExample(r);
				int icount = 0;
				ArrayList<Room> ilist = new ArrayList<Room>();
				
				while (rr.hasNext()) {
					ilist.add(rr.next());
				}
				for (Room item : ilist) {
					if (item.getType().equals("i")) {
						++icount;
					}
				}
				System.out.println(icount + " individual rooms");
				System.out.println();
				break;
				
			case "5":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				
				r = new Room(0, "d", false, 0, input);
				rr = db.queryByExample(r);
				int dcount = 0;
				ArrayList<Room> dlist = new ArrayList<Room>();
				
				while (rr.hasNext()) {
					dlist.add(rr.next());
				}
				for (Room item : dlist) {
					if (item.getType().equals("d")) {
						++dcount;
					}
				}
				System.out.println(dcount + " double rooms");
				System.out.println();
				break;
				
			case "6":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				
				r = new Room(0, "t", false, 0, input);
				rr = db.queryByExample(r);
				int tcount = 0;
				ArrayList<Room> tlist = new ArrayList<Room>();
				
				while (rr.hasNext()) {
					tlist.add(rr.next());
				}
				for (Room item : tlist) {
					if (item.getType().equals("t")) {
						++tcount;
					}
				}
				System.out.println(tcount + " triple rooms");
				System.out.println();
				break;
				
			case "7":
				
				System.out.println("Input housing name");
				input = scan.nextLine();
				
				h = new Housing(input, null, null, 0);
				hr = db.queryByExample(h);
				
				if (hr.size() == 0) {
					System.out.println("No result");
				} else {
					h = hr.next();
					System.out.println(h.getAdress());
					System.out.println();
				}
				break;
				
			case "8":
	
				h = new Housing(null, null, null, 0);
				hr = db.queryByExample(h);
				
				if (hr.size() == 0) {
					System.out.println("No result");
				} else {
					while (hr.hasNext()) {
						h = hr.next();
						System.out.println(h.toString());
					}
					System.out.println();
				}
				break;
				
			case "9":
				//close connection on exit
				db.close();
				break;
				
			default:
				System.out.println("Invalid option");
				break;
				
			}
		} while (!input.equals("9"));
	}
	
	public static void main(String[] args) {
		launchMenu();
	}

}
