package procesos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Vocal {
	
	public int vocalCount(String text, char vocal) {
		int count = 0;
		for (int i = 0; i < text.length(); ++i) {
			if (vocal == text.charAt(i)) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Vocal v = new Vocal();
		String text = "";
		int j = 0;
		File file = new File("texto.txt");
		FileReader fr = new FileReader(file);
		while ((j = fr.read()) != -1) {
			text += (char) j;			
		}
		
		char c;
		int result;
		for (int i = 0; i < args.length; ++i) {
			c = args[i].charAt(0);
			result = v.vocalCount(text, c);
			System.out.println(result);
		}
	}

}
