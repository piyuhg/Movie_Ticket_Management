
public class Movie {

	private String MovieName;
	private String Genre;
	private char Certificate;
	private double MovieRatings;
	private String Language;
	private int Length;
	
	public Movie(String MovieName, String Genre, char Certificate, double MovieRatings,String Language, int Length) {
		this.MovieName=MovieName;
		this.Genre=Genre;
		this.Certificate=Certificate;
		this.MovieRatings=MovieRatings;
		this.Language=Language;
		this.Length=Length; 
	}
	public void setMovieName(String MovieName) {
		this.MovieName = MovieName;
	}
	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	public void setCertificate(char Certificate) {
		this.Certificate = Certificate;
	}
	public void setMovieRatings(double MovieRatings) {
		this.MovieRatings = MovieRatings;
	}
	public void setLanguage(String Language) {
		this.Language = Language;
	}
	public void setLength(int Length) {
		this.Length = Length;
	}
	public String getMovieName() {
		return this.MovieName;
	}
	public String getGenre() {
		return this.Genre;
	}
	public char getCertificate() {
		return this.Certificate;
	}
	public double getMovieRatings() {
		return this.MovieRatings;
	}
	public String getLanguage() {
		return this.Language;
	}
	public int getLength() {
		return this.Length;
	}
	
	public void printMovieDetails() {
		System.out.println("Movie Name: "+this.getMovieName());
		System.out.println("Genre: "+this.Genre);
		System.out.println("Certificate: "+this.getCertificate());
		System.out.println("Movie Ratings: "+this.MovieRatings+" stars");
		System.out.println("Language: "+this.Language);
		System.out.println("Length: "+this.getLength()+" minutes");
		System.out.println("*********************");
	}	
	
}
