package db_connection;

import java.sql.*;

public class RSMetaData {

	public static void getQueryMetaData(ResultSet result) {
		try {
			ResultSetMetaData meta = result.getMetaData();
			
			//see rows returned
			int column_count = meta.getColumnCount();
			System.out.println("Rows returned: " + column_count);
			for (int i = 1; i <= column_count; ++i) {
				//name
				System.out.println("Name: " + meta.getColumnName(i));
				//type
				System.out.println("Type: " + meta.getColumnTypeName(i));
				//table
				System.out.println("Table: " + meta.getTableName(i));
				//nullable
				System.out.println("Nullable: " + meta.isNullable(i) + " (1-true/0-false)");
				//writable
				System.out.println("Writable: " + meta.isWritable(i));
				//signed
				System.out.println("Allows negative: " + !meta.isSigned(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
