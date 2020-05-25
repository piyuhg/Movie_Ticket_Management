
public class Show {

	private int ShowNumber;
	private String MovieName;
	private String TheatreName;
	private String Language;
	private Date ShowDate;
	private Time ShowTime;
	private int CostPerTicket;
	
	public Show(int ShowNumber, String MovieName,String Language, String TheatreName, Date ShowDate, Time ShowTime, int CostPerTicket) {
		this.ShowNumber=ShowNumber;
		this.MovieName=MovieName;
		this.TheatreName=TheatreName;
		this.Language = Language;
		this.ShowDate=ShowDate;
		this.ShowTime=ShowTime; 
		this.CostPerTicket=CostPerTicket; 
	}
	
	public void setShowNumber(int ShowNumber) {
		this.ShowNumber=ShowNumber;
	}
	public void setMovieName(String MovieName) {
		this.MovieName = MovieName;
	}
	public void setLanguage(String Language) {
		this.Language = Language;
	}
	public void setTheatreName(String TheatreName) {
		this.TheatreName = TheatreName;
	}
	public void setShowDate(Date ShowDate) {
		this.ShowDate = ShowDate;
	}
	public void setShowTime(Time ShowTime) {
		this.ShowTime = ShowTime;
	}
	public void setCostPerTicket(int CostPerTicket) {
		this.CostPerTicket = CostPerTicket;
	}
	public int getShowNumber() {
		return this.ShowNumber;
	}
	public String getMovieName() {
		return this.MovieName;
	}
	public String getLanguage() {
		return this.Language;
	}
	public String getTheatreName() {
		return this.TheatreName;
	}
	public Date getShowDate() {
		return this.ShowDate;
	}
	public Time getShowTime() {
		return this.ShowTime;
	}
	public int getCostPerTicket() {
		return this.CostPerTicket;
	}
	
	public void printShowDetails() {
		System.out.println("Show Number: "+this.getShowNumber());
		System.out.println("Movie Name: "+this.getMovieName());
		System.out.println("Movie Language: "+this.getLanguage());
		System.out.println("Theatre Name: "+this.getTheatreName());
		System.out.print("Show ");this.getShowDate().printDate();
		System.out.print("Show ");this.getShowTime().printTime();
		System.out.println("Cost Per Ticket: Rs."+this.getCostPerTicket());
		System.out.println("*********************");
	}
	
}

class Date{
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public void setDay(int day) {
		this.day=day;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	
	public void printDate() {
		System.out.println("Date: "+this.getDay()+"/"+this.getMonth()+"/"+this.getYear());
	}
}


class Time{
	private int hour;
	private int minutes;
	
	public Time(int hour, int minutes) {
		this.hour=hour;
		this.minutes=minutes;
	}
	public void setHour(int hour) {
		this.hour=hour;
	}
	public void setMinutes(int minutes) {
		this.minutes=minutes;
	}
	public int getHour() {
		return this.hour;
	}
	public int getMinutes() {
		return this.minutes;
	}
	
	public void printTime() {
		System.out.println("Time: "+this.getHour()+":"+this.getMinutes());
	}
	
}

