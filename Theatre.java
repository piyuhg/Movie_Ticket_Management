
public class Theatre {
	
	private String TheatreName;
	private String TheatreLocation;
	private double TheatreRatings;
	
	public Theatre(String TheatreName, String TheatreLocation, double TheatreRatings) {
		this.TheatreName = TheatreName;
		this.TheatreLocation = TheatreLocation;
		this.TheatreRatings = TheatreRatings;
	}
	public void setTheatreName(String TheatreName) {
		this.TheatreName=TheatreName;
	}
	public void setTheatreLocation(String TheatreLocation) {
		this.TheatreLocation=TheatreLocation;
	}
	public void setTheatreRatings(double TheatreRatings) {
		this.TheatreRatings=TheatreRatings;
	}
	public String getTheatreName() {
		return this.TheatreName;
	}
	public String getTheatreLocation() {
		return this.TheatreLocation;
	}
	public double getTheatreRatings() {
		return this.TheatreRatings;
	}	
	public void printTheatreDetails() {
		System.out.println("Theatre Name: "+this.TheatreName);
		System.out.println("Theatre Location: "+this.TheatreLocation);
		System.out.println("Theatre Ratings: "+this.TheatreRatings);
		System.out.println("********************");
	}	
}
