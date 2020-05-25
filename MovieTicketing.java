import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MovieTicketing {
	private Scanner s;
	private List<User> UserInformation = new ArrayList<User>();
	private List<Theatre> Theatres = new ArrayList<>();
	private List<Movie> Movies = new ArrayList<>();
	private List<Show> Shows = new ArrayList<>();
	private List<Ticket> Bookings = new ArrayList<>();
	private boolean loggedIn;
	
	public MovieTicketing(Scanner s) {
		User Admin = new User();
		UserInformation.add(Admin);
		this.s = s;
		loggedIn = false;
	}
	
	private int theatreExist(String TheatreName){
		for(int i = 0; i<Theatres.size();i++)
			if(Theatres.get(i).getTheatreName().equals(TheatreName))
				return i;
		return -1;
	}
	private Theatre createNewTheatre() {
		System.out.print("Enter the Theatre Name(String): ");
		String TheatreName = s.nextLine();
		System.out.print("Enter the Theatre Location(String): ");
		String TheatreLocation = s.nextLine();
		System.out.println("Enter the Theatre Ratings(0.5<->5.0): ");
		double TheatreRatings = s.nextDouble();s.nextLine();
		if(theatreExist(TheatreName) >= 0) {
			System.out.println("Theatre Name Already Exist!! Enter Unique Theatre Name!!");
			return null;
		}
		Theatre TheatreObject = new Theatre(TheatreName, TheatreLocation, TheatreRatings);
		return TheatreObject;
	}
	private void addTheatre(){
		Theatre newTheatre = createNewTheatre();
		if(newTheatre==null) {
			System.out.println("Theatre Addition Unsuccessfull");
			return;
		}
		Theatres.add(newTheatre);
		System.out.println("Theatre Added Successfully");				
	}
	private void updateTheatre() {
		System.out.print("Enter the Name of the Theatre to be updated(String): ");
		String OrigTheatreName = s.nextLine();
		int i = theatreExist(OrigTheatreName);
		if(i>=0) {
			System.out.println("What do you want to update?: ");
			System.out.println("1. Name\t\t2. Location");
			System.out.println("3. Ratings\t4. All Data");
			int choice=GetChoice();
			switch(choice) {
				case 1: 
					System.out.print("Enter the Theatre Name(String): ");
					String TheatreName = s.nextLine();
					Theatres.get(i).setTheatreName(TheatreName);
					break;
				case 2:
					System.out.print("Enter the Theatre Location(String): ");
					String TheatreLocation = s.nextLine();
					Theatres.get(i).setTheatreLocation(TheatreLocation);
					break;
				case 3:
					System.out.println("Enter the Theatre Ratings(0.5<->5.0): ");
					double TheatreRatings = s.nextDouble();s.nextLine();
					Theatres.get(i).setTheatreRatings(TheatreRatings);
					break;
				case 4:
					System.out.println("Enter the updated values: ");
					Theatre updatedTheatre = createNewTheatre();
					if(updatedTheatre==null) {
						System.out.println("Update Unsuccessfull");
						return;
					}
					Theatres.remove(i);
					Theatres.add(i,updatedTheatre);
					break;
				default:
					System.out.println("Invalid Selcetion!!");
			}
			System.out.println("Theatre Updated Successfully");
			return;
		}		
		System.out.println("Theatre Not Found, Update Unsuccessfull!!");
		return;
	}
	
	private int movieExist(String MovieName, String Language) {
		for(int i = 0; i<Movies.size(); i++) {
			if(Movies.get(i).getMovieName().equals(MovieName)){
				if(Movies.get(i).getLanguage().equals(Language)) {
					return i;
				}
			}
		}
		return -1;
	}
	private Movie createNewMovie() {
		System.out.print("Enter the Movie Name(String): ");
		String MovieName = s.nextLine();
		System.out.print("Enter the Genre(String): ");
		String Genre = s.nextLine();
		System.out.println("Enter the Certificate details(char): ");
		char Certificate = s.next().charAt(0);
		System.out.println("Enter the Movie Ratings(0.5<->5.0): ");
		double MovieRatings = s.nextDouble();s.nextLine();
		System.out.println("Enter the Language(String): ");
		String Language = s.nextLine();
		System.out.println("Enter the Movie Length(minutes)");
		int Length = s.nextInt();s.nextLine();
		if(movieExist(MovieName, Language) >= 0) {
			System.out.println("Movie Already Exist!! Enter Unique Deatils");
			return null;
		}
		Movie MovieObject = new Movie(MovieName, Genre, Certificate, MovieRatings, Language, Length);
		return MovieObject;
	}
	private void addMovie() {
		Movie newMovie = createNewMovie();
		if(newMovie==null) {
			System.out.println("Movie Addition Unsuccessfull");
			return;
		}
		Movies.add(newMovie);
		System.out.println("Movie Added Successfully");	
	}
	private void updateMovie() {
		System.out.print("Enter the Name of the Movie to be updated(String): ");
		String OrigMovieName = s.nextLine();
		System.out.print("Enter the Language of the Movie to be updated(String): ");
		String OrigLanguage = s.nextLine();
		int index = movieExist(OrigMovieName, OrigLanguage);
		if(index>=0) {
			System.out.println("What do you want to update?: ");
			System.out.println("1. Name\t\t2. Genre\t3. Certificate");
			System.out.println("4. Ratings\t5. Language\t6. Length");
			System.out.println("\t\t7. All Data");
			int choice=GetChoice();
			switch(choice) {
				case 1: 
					System.out.print("Enter the Movie Name(String): ");
					String MovieName = s.nextLine();
					Movies.get(index).setMovieName(MovieName);
					break;
				case 2:
					System.out.print("Enter the Genre(String): ");
					String Genre = s.nextLine();
					Movies.get(index).setGenre(Genre);
					break;
				case 3:
					System.out.println("Enter the Certificate details(char): ");
					char Certificate = s.next().charAt(0);
					Movies.get(index).setCertificate(Certificate);
					break;
				case 4: 
					System.out.println("Enter the Movie Ratings(0.5<->5.0): ");
					double MovieRatings = s.nextDouble();s.nextLine();
					Movies.get(index).setMovieRatings(MovieRatings);
					break;
				case 5:
					System.out.println("Enter the Language(String): ");
					String Language = s.nextLine();
					Movies.get(index).setLanguage(Language);
					break;
				case 6:
					System.out.println("Enter the Movie Length(minutes)");
					int Length = s.nextInt();s.nextLine();
					Movies.get(index).setLength(Length);
					break;
				case 7:
					System.out.println("Enter the updated values: ");
					Movie updatedMovie = createNewMovie();
					if(updatedMovie==null) {
						System.out.println("Update Unsuccessfull");
						return;
					}
					Movies.remove(index);
					Movies.add(index,updatedMovie);
					break;
				default:
					System.out.println("Invalid Selcetion!!");
			}
			System.out.println("Movie Updated Successfully");
			return;
		}
		System.out.println("Movie Not Found, Update Unsuccessfull!!");
		return;
	}
	
	private int showExist(int ShowNumber){
		for(int i = 0; i<Shows.size();i++)
			if(Shows.get(i).getShowNumber() == ShowNumber)
				return i;
		return -1;
	}
	private Show createNewShow() {
		System.out.print("Enter the Show Number: ");
		int ShowNumber = s.nextInt();s.nextLine();
		if(showExist(ShowNumber)>=0) {
			System.out.println("ShowNumber already exist!! Enter Unique ShowNumber");
			return null;
		}
		System.out.print("Enter the Movie Name(String): ");
		String MovieName = s.nextLine();
		System.out.println("Enter the Language(String): ");
		String Language = s.nextLine();
		if(movieExist(MovieName, Language)<0) {
			System.out.println("This Movie does not exist!!");
			return null;
		}
		System.out.print("Enter the Theatre Name(String): ");
		String TheatreName = s.nextLine();
		if(theatreExist(TheatreName)<0) {
			System.out.println("This Theatre does not exist!!");
			return null;
		}
		Date ShowDate = inputDate();
		Time ShowTime = inputTime();
		System.out.print("Enter the CostPerTicket(int): Rs. ");
		int CostPerTicket = s.nextInt();s.nextLine();
		Show ShowObject = new Show(ShowNumber, MovieName, Language, TheatreName, ShowDate, ShowTime, CostPerTicket);
		return ShowObject;
	}
	private void addShow() {
		Show newShow = createNewShow();
		if(newShow==null) {
			System.out.println("Show Addition Unsuccessfull");
			return;
		}
		Shows.add(newShow);
		System.out.println("Show Added Successfully");	
	}
	private void updateShow() {
		System.out.print("Enter the Show Number of the Show to be updated(int): ");
		int OrigShowNumber = s.nextInt();
		int index = showExist(OrigShowNumber);
		if(index>=0) {
			System.out.println("What do you want to update?: ");
			System.out.println("1. Show Number\t\t2. Movie Name");
			System.out.println("3. Language\t\t4. Theatre Name");
			System.out.println("5. Date\t\t\t6. Time");
			System.out.println("7. Cost Per Ticket\t8. All Data");
			int choice=GetChoice();
			switch(choice) {
				case 1: 
					System.out.print("Enter the Show Number: ");
					int ShowNumber = s.nextInt();s.nextLine();
					Shows.get(index).setShowNumber(ShowNumber);
					break;
				case 2:
					System.out.print("Enter the Movie Name(String): ");
					String MovieName = s.nextLine();
					Shows.get(index).setMovieName(MovieName);
					break;
				case 3:
					System.out.println("Enter the Language(String): ");
					String Language = s.nextLine();
					Shows.get(index).setLanguage(Language);
					break;
				case 4: 
					System.out.print("Enter the Theatre Name(String): ");
					String TheatreName = s.nextLine();
					Shows.get(index).setTheatreName(TheatreName);
					break;
				case 5:
					Date ShowDate = inputDate();
					Shows.get(index).setShowDate(ShowDate);
					break;
				case 6:
					Time ShowTime = inputTime();
					Shows.get(index).setShowTime(ShowTime);
					break;
				case 7:
					System.out.print("Enter the Cost Per Ticket: ");
					int CostPerTicket = s.nextInt();
					Shows.get(index).setCostPerTicket(CostPerTicket);
					break;
				case 8:
					System.out.println("Enter the updated values: ");
					Show updatedShow = createNewShow();
					if(updatedShow==null) {
						System.out.println("Update Unsuccessfull");
						return;
					}
					Shows.remove(index);
					Shows.add(index,updatedShow);
					break;
				default:
					System.out.println("Invalid Selcetion!!");
			}
			System.out.println("Show Updated Successfully");
			return;			
		}
		System.out.println("Show Not Found, Update Unsuccessfull!!");
		return;

	}
	private void deleteShow() {
		System.out.print("Enter the Show Number for deletion: ");
		int ShowNumber = s.nextInt();
		int index = showExist(ShowNumber);
		if(index<0) {
			System.out.println("No show found with given Show Number!!");
			return;
		}
		Shows.remove(index);	
		System.out.println("Show Deleted");
	}

	private void displayTheatres() {
		if(Theatres.isEmpty()) {
			System.out.println("No Theatres!!");
			return;
		}
		System.out.println("Displaying Theatre Details: ");
		System.out.println("*********************");
		for(int i = 0; i<Theatres.size(); i++) {
			Theatres.get(i).printTheatreDetails();
		}
	}
	private void displayMovies() {
		if(Movies.isEmpty()) {
			System.out.println("No Movies!!");
			return;
		}
		System.out.println("Displaying Movies Details: ");
		System.out.println("*********************");
		for(int i = 0; i<Movies.size(); i++) {
			Movies.get(i).printMovieDetails();
		}
	}
	private void displayShows() {
		if(Shows.isEmpty()) {
			System.out.println("No Shows!!");
			return;
		}
		System.out.println("Displaying Shows Details: ");
		System.out.println("*********************");
		for(int i = 0; i<Shows.size(); i++) {
			Shows.get(i).printShowDetails();
		}
	}
	
	private int userExist(String Username) {
		for(int i = 0; i<UserInformation.size(); i++)
			if(UserInformation.get(i).getUsername().equals(Username))
				return i;
		return -1;
	}
	private User createNewAgent() {
		System.out.print("Enter the Agent Name: ");
		String Username = s.nextLine();
		if(userExist(Username)>=0) {
			System.out.println("User already exist!!");
			return null;
		}			
		System.out.print("Enter the Agent Password: ");
		String Password = s.nextLine();
		return new User(Username, Password);
	}
	private void addAgent() {
		User newUser = createNewAgent();
		if(newUser==null) {
			System.out.println("Agent Addition Unsuccessfull");
			return;
		}
		UserInformation.add(newUser);
		System.out.println("Agent Added Successfully");
	}
	
	private Date inputDate() {
		System.out.print("Enter the Date: ");
		System.out.print("\tEnter day(DD): ");
		int day = s.nextInt();
		System.out.print("\tEnter month(MM): ");
		int month = s.nextInt();
		System.out.print("\tEnter year(YYYY): ");
		int year = s.nextInt();s.nextLine();
		return new Date(day, month, year);
	}
	private Time inputTime() {
		System.out.print("Enter the Time: ");
		System.out.print("\tEnter Hour(HR): ");
		int hour = s.nextInt();
		System.out.print("\tEnter Minutes(MM): ");
		int minutes = s.nextInt();s.nextLine();
		return new Time(hour, minutes);
	}

	private void bookTicket() {
		System.out.print("Enter the Show Number: ");
		int ShowNumber = s.nextInt();
		int index = showExist(ShowNumber);
		if(index>=0) {
			Show Show = Shows.get(index);
			int movieIndex = movieExist(Show.getMovieName(), Show.getLanguage());
			Movie Movie = Movies.get(movieIndex);
			int theatreIndex = theatreExist(Show.getTheatreName());
			Theatre Theatre = Theatres.get(theatreIndex);
			System.out.println("Cost Per Ticket: "+Show.getCostPerTicket());
			System.out.print("How many persons?: ");
			int NumberOfPersons = s.nextInt();s.nextLine();
			System.out.print("**Confirm Your Booking**(Y/N): ");
			char confirmation = s.next().toUpperCase().charAt(0);
			if(confirmation=='Y') {
				Ticket Ticket = new Ticket(Movie, Theatre, Show, NumberOfPersons);
				Bookings.add(Ticket);
				System.out.println("Booking Connfirmed!!");
			}
			else {
				System.out.println("Booking Cancelled!!");
			}			
		}
	}
	private void printTicket() {
		if(Bookings.size()>0) {
			System.out.println("****Printing Ticket****");
			Bookings.get(Bookings.size()-1).printTicketDetails();
			return;
		}
		System.out.println("No Bookings !!");			
	}

	private void exit() {
		System.out.print("Are you sure you want to logout and exit? (Y/N): ");
		char confirmation = s.nextLine().toUpperCase().charAt(0);
		if(confirmation=='Y') {
			this.loggedIn = false;
			System.out.println("Logged Out Successfully!!\n");
			return;
		}
		System.out.println("Continue Booking!!");
	}
	
	public int GetChoice() {
		System.out.print("Please Enter Your Choice: ");
		int choice = s.nextInt();s.nextLine();
		return choice;
	}

	public void AdminMenu() {
		if(!loggedIn) {
			System.out.println("---Access Denied---");
			System.out.println("Please Login first");
			return;
		}
		System.out.println("\n*****Admin Menu*****");
		System.out.println("1.  Add Theatre\t\t2.  Update Theatre");
		System.out.println("3.  Add Movie\t\t4.  Update Movie");		
		System.out.println("5.  Add Show\t\t6.  Update Show");
		System.out.println("7.  Delete Show\t\t8.  Display Theatres");
		System.out.println("9.  Display Movies\t10. Display Shows");
		System.out.println("11. Add Agent\t\t12. Book Ticket");
		System.out.println("13. Print Ticket\t14. Exit");
		int choice = GetChoice();
		switch(choice) {
			case 1://add theatre
				this.addTheatre();
				break;
			case 2://update theatre
				this.updateTheatre();
				break;
			case 3://add movie
				this.addMovie();
				break;
			case 4://update movie
				this.updateMovie();
				break;
			case 5://add show
				this.addShow();
				break;
			case 6://update show
				this.updateShow();
			case 7://delete show
				this.deleteShow();
				break;
			case 8://display theatres
				this.displayTheatres();
				break;
			case 9://display movies
				this.displayMovies();
				break;
			case 10://display shows
				this.displayShows();
				break;
			case 11://add agent
				this.addAgent();
				break;
			case 12://book ticket
				this.bookTicket();
				break;
			case 13://print ticket
				this.printTicket();
				break;
			case 14://exit
				this.exit();
				break;
			default:
				System.out.println("Invalid Correct Choice!!");
				this.AdminMenu();				
		}
		return;
	}
	
	public void AgentMenu() {
		if(!loggedIn) {
			System.out.println("---Access Denied---");
			System.out.println("Please Login first");
			return;
		}
		System.out.println("\n*****Agent Menu*****");
		System.out.println("1. View Shows\t\t2. New Ticket");
		System.out.println("3. Print Ticket\t\t4. Exit");
		int choice = GetChoice();
		switch(choice) {
			case 1://view shows 
				this.displayShows();
				break;
			case 2://new ticket
				this.bookTicket();
				break;
			case 3://print ticket
				this.printTicket();
				break;
			case 4://exit
				this.exit();
				break;
			default: 
				System.out.println("Enter correct choice!! ");
				this.AgentMenu();			
		}
		return;
	}
	
	public String Login() {
		System.out.print("Enter Username: ");
		String Username = s.nextLine();
		System.out.print("Enter Password: ");
		String Password = s.nextLine();
		for(int i=0; i<UserInformation.size();i++) {
			if(UserInformation.get(i).getUsername().equals(Username)) 
				if(UserInformation.get(i).getPassword().equals(Password)) {
					loggedIn=true; 
					System.out.println("Logged in Successfully as "+UserInformation.get(i).getUserType());
					return UserInformation.get(i).getUserType();
				}					
		}
		return null;
	}
	
	public boolean LoginStatus() {
		return this.loggedIn;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MovieTicketing mt1 = new MovieTicketing(s);
		String UserType = mt1.Login();
		char confirmation='Y';
		int failLoginFlag = 0;
		do{
			do {
				if(UserType==null) {
					System.out.println("Invalid Username or Password");
					System.out.println("Please try again\n");
					failLoginFlag=1;
				}
				else if(UserType.equals("Admin")){
					mt1.AdminMenu();
				}
				else if(UserType.equals("Agent")) { 
					mt1.AgentMenu();
				}
			}while(mt1.LoginStatus());
			if(failLoginFlag==1) {
				System.out.print("Try Login Again? (Y/N)");
				failLoginFlag=0;
			}
			else
				System.out.print("Login Again? (Y/N): ");
			confirmation=s.nextLine().toUpperCase().charAt(0);
			if(confirmation=='Y')
				UserType=mt1.Login();
		}while(confirmation=='Y');
		System.out.println("Closing");
	}

}
