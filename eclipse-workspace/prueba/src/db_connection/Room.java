package db_connection;

public class Room {

	private int id_hab;
	private String type;
	private boolean bath;
	private float price;
	private String h_name;
	
	public Room(int id_hab, String type, boolean bath, float price, String h_name) {
		this.id_hab = id_hab;
		this.type = type;
		this.bath = bath;
		this.price = price;
		this.h_name = h_name;
	}
	
	public int getId_hab() {
		return id_hab;
	}
	
	public void setId_hab(int id_hab) {
		this.id_hab = id_hab;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isBath() {
		return bath;
	}
	
	public void setBath(boolean bath) {
		this.bath = bath;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getH_name() {
		return h_name;
	}
	
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	@Override
	public String toString() {
		return "Room [id_hab=" + id_hab + ", type=" + type + ", bath=" + bath + ", price=" + price + ", h_name="
				+ h_name + "]";
	}
	
}
