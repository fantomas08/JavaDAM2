package db_connection;

import java.sql.*;
import java.util.Scanner;

public class Menu {
	
	private static Scanner scan = new Scanner(System.in);
	private static String input = "";
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement s = null;
	//private static PreparedStatement ps = null;
	
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
				//next
				SQLMenu();
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (!input.equals("6"));
		
	}
	
	public static void SQLMenu() {
		do {
			System.out.println("Select Query");
			System.out.println("1) Search rooms under your price");
			System.out.println("2) See housing number phone");
			System.out.println("3) Search housing with bath");
			System.out.println("4) See housing individuals rooms");
			System.out.println("5) See housing double rooms");
			System.out.println("6) See housing triple rooms");
			System.out.println("7) See housing adress");
			System.out.println("8) See all housings");
			System.out.println("9) Exit");
			
			input = scan.nextLine();
			switch (input) {
			case "1":
				System.out.println("Input price");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE precio<" + Float.parseFloat(input));
					if (rs.next()) {
						while (rs.next()) {
							Room room = new Room(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getFloat(4), rs.getString(5));
							System.out.println(room.toString());
						}
						System.out.println();
					} else {
						System.out.println("No result");
						System.out.println();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":
				System.out.println("Input housing name");
				input = scan.nextLine();
				try {
					s = con.createStatement();
					rs = s.executeQuery("SELECT * FROM habitaciones WHERE precio<" + Float.parseFloat(input));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				
				break;
			case "4":
		
				break;
			case "5":
		
				break;
			case "6":
				
				break;
			case "7":
				
				break;
			case "8":
	
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
