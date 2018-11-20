package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main {

	final static String DB = "E:\\DAM2\\JavaDAM2\\bd_db4o\\EMPLEDEP.yap";
	
	public static void main(String[] args) {
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB);
		
		Departamentos dept1 = new Departamentos(1, "dept1", "loc1");
		Departamentos dept2 = new Departamentos(2, "dept2", "loc2");
		Departamentos dept3 = new Departamentos(3, "dept3", "loc3");
		
		Empleados emp1 = new Empleados(1, "emp1", "oficio", 0, "fecha", 0, 0, dept1);
		Empleados emp2 = new Empleados(2, "emp2", "oficio", 0, "fecha", 0, 0, dept1);
		Empleados emp3 = new Empleados(3, "emp3", "oficio", 0, "fecha", 0, 0, dept2);
		Empleados emp4 = new Empleados(4, "emp4", "oficio", 0, "fecha", 0, 0, dept2);
		Empleados emp5 = new Empleados(5, "emp5", "oficio", 0, "fecha", 0, 0, dept3);
		Empleados emp6 = new Empleados(6, "emp6", "oficio", 0, "fecha", 0, 0, dept3);
		/*
		db.store(dept1);
		db.store(dept2);
		db.store(dept3);
		db.store(emp1);
		db.store(emp2);
		db.store(emp3);
		db.store(emp4);
		db.store(emp5);
		db.store(emp6);
		*/
		Empleados empleado = new Empleados(0, null, null, 0, null, 0, 0, dept1);
		
		ObjectSet<Empleados> result = db.queryByExample(empleado);
		
		if (result.size() == 0) {
			System.out.println("No hay registros");
		} else {
			while (result.hasNext()) {
				Empleados emp = result.next();
				System.out.println(emp.toString());
			}
		}
		
		db.close();
	}

}
