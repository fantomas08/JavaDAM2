package db_connection;

import java.sql.*;

public class DBMetaData {
	
	public static void main(String[] args) {
		//Get SQLite DB connection
		Connection con = SQLite.getConnection();
		try {
			DatabaseMetaData dmeta = con.getMetaData();
			
			ResultSet result = dmeta.getTables(null, null, null, null);
			
			//exising Tables
			while (result.next()) {
				System.out.println("Catalog: " + result.getString("TABLE_CAT"));
				System.out.println("Schema: " + result.getString("TABLE_SCHEM"));
				System.out.println("Table Name: " + result.getString("TABLE_NAME"));
				System.out.println("Table Type: " + result.getString("TABLE_TYPE"));
				System.out.println("------------------------");
			}
			System.out.println();
			
			//table alojamientos
			Statement s = con.createStatement();
			result = s.executeQuery("SELECT * FROM alojamientos");
			ResultSetMetaData rsmd = result.getMetaData();
			System.out.println("TABLE alojamientos:");
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				System.out.println("Column name: " + rsmd.getColumnName(i));
				System.out.println("Column type: " + rsmd.getColumnType(i));
				System.out.println("Column size: " + rsmd.getColumnDisplaySize(i));
				System.out.println("Column nullable: " + rsmd.isNullable(i));
			}
			
			//primary key
			result = dmeta.getPrimaryKeys(null, null, "alojamientos");
			while (result.next()) {
				System.out.println("Primary Key: " + result.getString("COLUMN_NAME"));
			}
			
			//foreign key
			result = dmeta.getImportedKeys(null, null, "alojamientos");
			while (result.next()) {
				System.out.println("Foreign key: " + result.getString("FKCOLUMN_NAME") + " REFERENCES Catalog: " + result.getString("PKTABLE_CAT") + " ,Schema: " + result.getString("PKTABLE_SCHEM") + " ,Table: " +
						result.getString("PKTABLE_NAME") + " ,Column: " + result.getString("PKCOLUMN_NAME")); 
			} 
			System.out.println();
			
			//table habitaciones
			s = con.createStatement();
			result = s.executeQuery("SELECT * FROM habitaciones");
			rsmd = result.getMetaData();
			System.out.println("TABLE habitaciones:");
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				System.out.println("Column name: " + rsmd.getColumnName(i));
				System.out.println("Column type: " + rsmd.getColumnType(i));
				System.out.println("Column size: " + rsmd.getColumnDisplaySize(i));
				System.out.println("Column nullable: " + rsmd.isNullable(i));
			}
			
			//primary key
			result = dmeta.getPrimaryKeys(null, null, "habitaciones");
			while (result.next()) {
				System.out.println("Primary Key: " + result.getString("COLUMN_NAME"));
			}
			
			//foreign key
			result = dmeta.getImportedKeys(null, null, "habitaciones");
			while (result.next()) {
				System.out.println("Foreign key: " + result.getString("FKCOLUMN_NAME") + " REFERENCES Catalog: " + result.getString("PKTABLE_CAT") + " ,Schema: " + result.getString("PKTABLE_SCHEM") + " ,Table: " +
						result.getString("PKTABLE_NAME") + " ,Column: " + result.getString("PKCOLUMN_NAME")); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
