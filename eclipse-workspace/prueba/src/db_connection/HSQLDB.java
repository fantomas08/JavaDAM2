package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDB {

	public static void main(String[] args) {
		ResultSet rs = null;
		Statement query = null;
		Connection con = null;
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:file:G:\\Acceso a datos\\tema2\\hsqldb\\data\\ejemplo\\ejemplo", "", "");
			
			query = con.createStatement();
			rs = query.executeQuery("SELECT * FROM departamentos");
			
			while (rs.next()) {
				System.out.println(rs.getInt("dept_no") + rs.getString("dnombre") + rs.getString("loc"));
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

	}

}