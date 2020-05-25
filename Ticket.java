
public class Ticket {
	private static int TicketNumber;
	private Movie Movie;
	private Theatre Theatre;
	private Show Show;
	private int NumberOfPersons;
	private double TotalCost;
	private int TicketID;
	
	public Ticket(Movie Movie, Theatre Theatre, Show Show, int NumberOfPersons) {
		this.Movie=Movie;
		this.Theatre=Theatre;
		this.Show=Show;
		this.NumberOfPersons=NumberOfPersons;
		this.TicketID = ++TicketNumber;
	}
	public void setMovie(Movie movie) {
		Movie = movie;
	}
	public void setTheatre(Theatre theatre) {
		Theatre = theatre;
	}
	public void setShow(Show show) {
		Show = show;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		NumberOfPersons = numberOfPersons;
	}
	public int getTicketId() {
		return this.TicketID;
	}
	public Movie getMovie() {
		return Movie;
	}
	public Theatre getTheatre() {
		return Theatre;
	}
	public Show getShow() {
		return Show;
	}
	public int getNumberOfPersons() {
		return NumberOfPersons;
	}
	public double getTotalCost() {
		this.calculateTotalCost();
		return TotalCost;
	}
	private void calculateTotalCost() {
		this.TotalCost = this.getShow().getCostPerTicket()*this.getNumberOfPersons();
	}
	public void printTicketDetails() {
		System.out.println("Movie: "+this.getMovie().getMovieName());
		System.out.println("Movie Genre: "+this.getMovie().getGenre());
		System.out.println("Language: "+this.getMovie().getLanguage());
		System.out.println("Certificate: "+this.getMovie().getCertificate());
		System.out.println("Show Number: "+this.getShow().getShowNumber());
		System.out.print("Show: ");this.getShow().getShowTime().printTime();
		System.out.print("Show: ");this.getShow().getShowDate().printDate();
		System.out.println("Theatre: "+this.getTheatre().getTheatreName());
		System.out.println("Location: "+this.getTheatre().getTheatreLocation());
	}
}
