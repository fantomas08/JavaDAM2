package db_connection;

import java.sql.*;
import java.util.ArrayList;

public class DBMetaData {
	
	public static void getBDMetaData(Connection con) {
		try {
			DatabaseMetaData dmeta = con.getMetaData();
			
			ResultSet result = dmeta.getTables(null, null, null, null);
			ArrayList<String> tables = new ArrayList<String>();
			int l = 0;
			
			//exising Tables
			while (result.next()) {
				System.out.println("Catalog: " + result.getString("TABLE_CAT"));
				System.out.println("Schema: " + result.getString("TABLE_SCHEM"));
				tables.add(result.getString("TABLE_NAME"));
				System.out.println("Table Name: " + tables.get(l));
				++l;
				System.out.println("Table Type: " + result.getString("TABLE_TYPE"));
				System.out.println("------------------------");
			}
			System.out.println();
			
			//for each table
			for (String tab : tables) {
				Statement s = con.createStatement();
				result = s.executeQuery("SELECT * FROM " + tab);
				ResultSetMetaData rsmd = result.getMetaData();
				System.out.println("TABLE " + tab + ":");
				for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
					System.out.println("Column name: " + rsmd.getColumnName(i));
					System.out.println("Column type: " + rsmd.getColumnType(i));
					System.out.println("Column size: " + rsmd.getColumnDisplaySize(i));
					System.out.println("Column nullable: " + rsmd.isNullable(i));
				}
				
				//primary key
				result = dmeta.getPrimaryKeys(null, null, tab);
				while (result.next()) {
					System.out.println("Primary Key: " + result.getString("COLUMN_NAME"));
				}
				
				//foreign key
				result = dmeta.getImportedKeys(null, null, tab);
				while (result.next()) {
					System.out.println("Foreign key: " + result.getString("FKCOLUMN_NAME") + " REFERENCES Catalog: " + result.getString("PKTABLE_CAT") + " ,Schema: " + result.getString("PKTABLE_SCHEM") + " ,Table: " +
							result.getString("PKTABLE_NAME") + " ,Column: " + result.getString("PKCOLUMN_NAME")); 
				} 
				System.out.println();
			}
			
			//close connection
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
