package procesos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Media {

	public float media(String route) {
		float media = 0;
		float total = 0;
		float count = 0;
		String file_string = "";
		FileReader fr = null;
		try {
			fr = new FileReader(route);
			int j;
			while ((j = fr.read()) != -1){
				file_string += (char) j;
			}
			for (int i = 0; i < file_string.length(); ++i) {
				if (Character.isDigit(file_string.charAt(i))) {
					total += Character.getNumericValue((file_string.charAt(i)));
					++count;
				}
			}
			media = total / count;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return media;
		}
	}
	
	public static void main(String[] args) {
		Media m = new Media();
		float result = m.media(args[0]);
		//float result = m.media("2ºDAM.txt");
		System.out.println(result);
	}

}
