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
	
	public void launchVocal(String text, char vocal, String resultFile) {
		String clase = "procesos.Vocal";
		try {
			ProcessBuilder pb = new ProcessBuilder("java", clase, text, Character.toString(vocal));
			pb.directory(new File("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\bin"));
			pb.redirectError(new File("errores.txt"));
			pb.redirectOutput(new File(resultFile));
			pb.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchMedia(String route, String resultFile) {
		String clase = "procesos.Media";
		try {
			ProcessBuilder pb = new ProcessBuilder("java", clase, route);
			pb.directory(new File("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\bin"));
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
		/*l.launchSum(1, 5, "result1.txt");
		l.launchSum(6, 10, "result2.txt");
		System.out.println("Ok");*/
		
		/*l.launchVocal("Cuenta las a", 'a', "result1.txt");
		l.launchVocal("Cuenta las e", 'e', "result2.txt");
		System.out.println("Ok");*/
		
		l.launchMedia("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\1ºSMR.txt", "Notas-1SMR.txt");
		l.launchMedia("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\2ºSMR.txt", "Notas-2SMR.txt");
		l.launchMedia("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\1ºDAM.txt", "Notas-1DAM.txt");
		l.launchMedia("E:\\DAM2\\JavaDAM2\\eclipse-workspace\\ProcesosServicios\\2ºDAM.txt", "Notas-2DAM.txt");
		System.out.println("Ok");
	}

}
