package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDB {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:file:E:\\DAM2\\Acceso a datos\\tema2\\hsqldb\\data\\ejemplo\\ejemplo", "", "");
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
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:file:E:\\DAM2\\Acceso a datos\\tema2\\hsqldb\\data\\ejemplo\\ejemplo", "", "");
			
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
