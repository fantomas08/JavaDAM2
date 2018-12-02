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
		String text = args[0];
		char vocal = args[1].charAt(0);
		int result = v.vocalCount(text, vocal);
		System.out.println(result);
	}

}
