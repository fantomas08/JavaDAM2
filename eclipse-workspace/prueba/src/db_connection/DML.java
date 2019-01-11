package db_connection;

import java.sql.*;

public class DML {
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement s = null;
	
	public static void addHousing(Connection con, String name, String adress, String tlf, int n_hab) {
		try {
			s = con.createStatement();
			s.executeUpdate("INSERT INTO alojamientos VALUES ('"
					+ name + "', '" 
					+ adress + "', '" 
					+ tlf + "', " 
					+ n_hab
					+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
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
	
	public static void addRoom(Connection con, int id_hab, String type, boolean bath, float price, String h_name) {
		try {
			s = con.createStatement();
			s.executeUpdate("INSERT INTO habitaciones VALUES ("
					+ id_hab + ", '"
					+ type + "', "
					+ bath + ", "
					+ price + ", '"
					+ h_name
					+ "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
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
	
	public static void deleteRoom(Connection con, int id_hab) {
		try {
			s = con.createStatement();
			s.executeUpdate("DELETE FROM habitaciones WHERE id_hab=" + id_hab
					+ "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
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
	
	public static void modifyHousing(Connection con, String name, String adress, String tlf, int n_hab) {
		try {
			s = con.createStatement();
			s.executeUpdate("UPDATE alojamientos "
					+ "SET dir='" + adress + "', "
					+ "tlf='" + tlf + "', "
					+ "n_hab=" + n_hab +
					" WHERE nombre='" + name + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
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
	

}
