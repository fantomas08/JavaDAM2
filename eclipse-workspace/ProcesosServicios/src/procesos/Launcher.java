package procesos;

import java.io.File;
import java.io.IOException;

public class Launcher {

	public void launchSum(Integer n1, Integer n2, String resultFile) {
		String clase = "procesos.Sum";
		try {
			ProcessBuilder pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
			pb.directory(new File("E:\\DAM2\\eclipse-workspace\\ProcesosServicios\\bin"));
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(resultFile));
			pb.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Launcher l=new Launcher();
		l.launchSum(1, 5, "result1.txt");
		l.launchSum(6, 10, "result2.txt");
		System.out.println("Ok");
	}

}
