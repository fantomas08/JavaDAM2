package db_connection;

import java.sql.*;

public class PrepStatement {

	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	
	public static void modifyHousing(Connection con, String name, String adress, String tlf, int n_hab) {
		try {
			ps = con.prepareStatement("UPDATE alojamientos "
					+ "SET dir=?, tlf=?, n_hab=?");
			
			ps.setString(1, adress);
			ps.setString(2, tlf);
			ps.setInt(3, n_hab);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void mostrar(Connection con) {
		try {
			Statement s = con.createStatement();
			rs = s.executeQuery("SELECT * FROM alojamientos");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4) + System.lineSeparator());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		mostrar(SQLite.getConnection());
		//modifyHousing(SQLite.getConnection(), "Alojamiento5", "nuevo", "666", 10);
	}

}
