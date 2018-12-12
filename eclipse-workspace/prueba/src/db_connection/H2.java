package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2 {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:E:\\DAM2\\Acceso a datos\\tema2\\H2\\alojamientos\\alojamientos", "", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return con;
		}
		
	}

	/*public static void main(String[] args) {
		ResultSet rs = null;
		Statement query = null;
		Connection con = null;
		
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:E:\\DAM2\\Acceso a datos\\tema2\\H2\\alojamientos\\alojamientos", "", "");
			
			query = con.createStatement();
			rs = query.executeQuery("SELECT * FROM habitaciones");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + rs.getString(2) + rs.getBoolean(3) + rs.getDouble(4) + rs.getString(5));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				query.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}*/

}
