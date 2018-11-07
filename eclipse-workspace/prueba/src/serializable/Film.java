package serializable;

public class Film {

	private String title;
	private int year;
	private String gender;
	private String study;
	
	public Film(String title, int year, String gender, String study) {
		super();
		this.title = title;
		this.year = year;
		this.gender = gender;
		this.study = study;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", year=" + year + ", gender=" + gender + ", study=" + study + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}
}
