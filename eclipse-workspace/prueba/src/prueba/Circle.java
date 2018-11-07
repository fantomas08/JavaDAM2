package prueba;

public class Circle {

	private double x;
	private double y;
	private double radius;
	
	public Circle() {
		super();
	}

	public Circle(double radio) {
		super();
		this.radius = radio;
	}

	public Circle(double x, double y, double radio) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radio;
	}
	
	public double Area() {
		double area = Math.PI * (radius*radius);
		return area;
	}
	
	public double Perimeter() {
		double longitud = 2 * Math.PI * radius;
		return longitud;
	}
	
	public String toString() {
		String s = "Radius: " + radius + " Area: " + Area() + " Perimeter: " + Perimeter();
		return s;
	}
}
