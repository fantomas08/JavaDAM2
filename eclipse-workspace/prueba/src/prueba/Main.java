package prueba;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	ArrayList<Circle> list;
	
	public Main() {
		list = new ArrayList<Circle>();
	}
	
	public void addCircle(Circle c) {
		list.add(c);
	}
	
	public void removeCircle(Circle c) {
		list.remove(c);
	}
	
	public void showCircle(int index) {
		System.out.println(list.get(index).toString());
	}
	
	public void showAllCircles() {
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).toString());
		}
	}
	
	public void showBiggerArea() {
		Iterator it = list.iterator();
		double max_area = 0;
		while (it.hasNext()) {
			
			it = (Iterator) it.next();
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
