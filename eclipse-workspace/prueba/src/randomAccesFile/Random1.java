package randomAccesFile;

import java.io.*;


public class Random1 {

	private static RandomAccessFile file;
	
	private static void modify(int pointer, int number) {
		int bytes = Integer.BYTES;
		try {
			file.seek(0);
			file.seek(pointer*bytes);
			file.writeInt(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void showFile() {
		try {
			file.seek(0);
			while (true) {
				System.out.println(file.readInt());
			}
		} catch (EOFException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			file = new RandomAccessFile("INT.txt", "rw");
			/*for (int i = 0; i < 10; ++i) {
				file.writeInt((int) (Math.random()*100));
			}*/
			modify(0, 10);
			showFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println((int) (Math.random()*100));
	}

}
