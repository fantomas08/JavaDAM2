package serializable;

import java.io.*;
import java.util.ArrayList;

public class Filomteca {

	private static File file;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	private static Film film;
	private static ArrayList<Film> films = new ArrayList<Film>();
	
	public static void consult(String title) {
		for (int i = 0; i < films.size(); ++i) {
			if (films.get(i).getTitle() == title) {
				film = films.get(i);
			}
			break;
		}
		if (film != null) {
			System.out.println(film.toString());;
		}
	}
	
	public static void modify(String title, String new_title, int year, String gender, String study) {
		for (int i = 0; i < films.size(); ++i) {
			if (films.get(i).getTitle() == title) {
				film = films.get(i);
			}
			if (film != null) {
				film = new Film(new_title, year, gender, study);
				films.set(i, film);
			}
			break;
		}
	}
	
	public static void add(String title, int year, String gender, String study) {
		films.add(new Film(title, year, gender, study));
	}
	
	public static void delete(String title) {
		for (int i = 0; i < films.size(); ++i) {
			if (films.get(i).getTitle() == title) {
				film = films.get(i);
			}
			break;
		}
		if (film != null) {
			films.remove(film);
		}
	}
	
	public static void main(String[] args) {
		add("peli1", 1990, "accion", "lostfilm");
		add("peli2", 1999, "accion", "lostfilm");
		modify("peli1", "peli3", 2000, "accion", "lostfilm");
		System.out.println(films.toString());
		//System.out.println(film.toString());

	}

}
