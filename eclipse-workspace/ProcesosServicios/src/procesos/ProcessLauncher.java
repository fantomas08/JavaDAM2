package procesos;

import java.io.IOException;

public class ProcessLauncher {

	public static void execute(String route) {
		ProcessBuilder pb = new ProcessBuilder(route);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String route = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		for (int i = 0; i < 100; ++i) {
			execute(route);
		}
		System.out.println("Finalizado");
	}

}
