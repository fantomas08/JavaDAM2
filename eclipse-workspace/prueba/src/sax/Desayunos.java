package sax;

public class Desayunos {

	private String name;
	private float price;
	private String description;
	private int calories;
	
	public Desayunos() {
		this.name = null;
		this.price = 0;
		this.description = null;
		this.calories = 0;
	}

	public Desayunos(String name, float price, String description, int calories) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Desayunos [name=" + name + ", price=" + price + ", description=" + description + ", calories="
				+ calories + "]";
	}
	
	
}
