package Project;

public class Movie {

	private String title;
	private String director;
	private int grade;
	private String genre;

	public Movie() {

	}

	public Movie(String title, String director, int grade, String genre) {
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Project.Movie{" +
				"title='" + title + '\'' +
				", director='" + director + '\'' +
				", grade=" + grade +
				", genre='" + genre + '\'' +
				'}';
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
