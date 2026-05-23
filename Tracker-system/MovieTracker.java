import java.util.Scanner;
public class MovieTracker{
	public static void displayResults(int actionCount, int comedyCount, int horrorCount, int romanceCount, int total, String movie1, String movie2, String movie3, String movie4){
		
	}
	public static String abbreviateGenre(String genre){
		String upperCase = genre.toUpperCase();
		if(upperCase == "ACTION"){
			upperCase = "AC";
		}else if(upperCase == "COMEDY"){
			upperCase = "CO";
		}else{
			return upperCase.substring(0,1);
		}
		return upperCase;
	}
	public static boolean validGenreName(String movie1, String movie2, String movie3, String movie4, String genre){
		if(genre.equalsIgnoreCase(movie1) || genre.equalsIgnoreCase(movie2) || genre.equalsIgnoreCase(movie3) || genre.equalsIgnoreCase(movie4)){
			return true;
		}else{
			System.out.println("Invalid genre selected, try again.");
			return false;
		}
	}
	public static boolean validateCustomerAge(int age){
		if(age >= 5 && age <= 120){
			return true;
		}else{
			System.out.println("Invalid age!");
			return false;
		}
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		int actionCount = 0;
		int comedyCount = 0;
		int horrorCount = 0; 
		int romanceCount = 0;
		int total = 0;
		
		String movie1 = "ACTION";
		String movie2 = "COMEDY";
		String movie3 = "HORROR";
		String movie4 = "ROMANCE";
		
		boolean validAge = true;
		while(validAge){
			System.out.print("Enter customer age (or 0 to exit): ");
			int age = kb.nextInt();
			if(age == 0){
				break;
			}
			if(validateCustomerAge(age)){
				System.out.print("Does customer have membership? (y/n): ");
				char activeMember = kb.next().charAt(0);
				kb.nextLine();
				validAge = false;
				
				boolean validGenre = true;
				while(validGenre){
					System.out.print("Enter favourite genre (Action, Comedy, Horror, Romance): ");
					String genre = kb.nextLine();
				
					if(validGenreName(movie1,movie2,movie3,movie4,genre)){
						String abbreviated = abbreviateGenre(genre);
						System.out.println("Abbreviated: " + abbreviated);
						validGenre = false;
					}
				}
			}
			else{
				System.out.println("Only active members can rate.");
			}
			
		}
	}
}
