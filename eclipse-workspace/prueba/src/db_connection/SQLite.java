package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {

	public static void main(String[] args) {
		ResultSet rs = null;
		Statement query = null;
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:G:\\Acceso a datos\\tema2\\sqlite-tools-win32-x86-3250300\\prueba.db", "", "");
			
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

/*
CREATE TABLE departamentos (
dept_no INT NOT NULL PRIMARY KEY,
dnombre VARCHAR(15),
loc VARCHAR(15),
);
INSERT INTO departamentos VALUES (10, 'CONTABILIDAD', 'SEVILLA');
*/