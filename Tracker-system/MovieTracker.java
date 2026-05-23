import java.util.Scanner;
public class MovieTracker{
	public static void displayResults(int actionCount, int comedyCount, int horrorCount, int romanceCount, int total, String movie1, String movie2, String movie3, String movie4){
		System.out.println("======STATS=======");
		
		double perc1 = (actionCount / (double)total) * 100;
		System.out.printf("%s %.2f%%%n", movie1, perc1);
		double perc2 = (comedyCount / (double)total) * 100;
		System.out.printf("%s %.2f%%%n", movie2, perc2);
		double perc3 = (horrorCount / (double)total) * 100;
		System.out.printf("%s %.2f%%%n", movie3, perc3);
		double perc4 = (romanceCount / (double)total) * 100;
		System.out.printf("%s %.2f%%%n", movie4, perc4);
		
		String popular = movie1;
		int max = actionCount;
		
		if(comedyCount > max){
			max = comedyCount;
			popular = movie2;
		}
		if(horrorCount > max){
			max = horrorCount;
			popular = movie3;
		}
		if(romanceCount > max){
			max = romanceCount;
			popular = movie4;
		}
		
		System.out.println("Highest movie: " + popular);
	}
	public static String abbreviateGenre(String genre){
		String upperCase = genre.toUpperCase();
		if(upperCase.equalsIgnoreCase("ACTION")){
			upperCase = "AC";
		}else if(upperCase.equalsIgnoreCase("COMEDY")){
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
		
		while(true){
			System.out.print("Enter customer age (or 0 to exit): ");
			int age = kb.nextInt();
			if(age == 0){
				break;
			}
			if(validateCustomerAge(age)){
				System.out.print("Does customer have membership? (y/n): ");
				char activeMember = kb.next().charAt(0);
				kb.nextLine();
				
				boolean validGenre = true;
				if(activeMember == 'y' || activeMember == 'Y'){
					while(validGenre){
					System.out.print("Enter favourite genre (Action, Comedy, Horror, Romance): ");
					String genre = kb.nextLine();
				
					if(validGenreName(movie1,movie2,movie3,movie4,genre)){
						String abbreviated = abbreviateGenre(genre);
						System.out.println("Abbreviated: " + abbreviated);
						validGenre = false;
						
						if(genre.equalsIgnoreCase(movie1)){
						actionCount++;
					}if(genre.equalsIgnoreCase(movie2)){
						comedyCount++;
					}if(genre.equalsIgnoreCase(movie3)){
						horrorCount++;
					}if(genre.equalsIgnoreCase(movie4)){
						romanceCount++;
					}
					total++;
					}
				}
				
			}
			else{
				System.out.println("Only active members can rate.");
			}
			
		}
		if(total > 0){
			displayResults(actionCount,comedyCount,horrorCount,romanceCount,total,movie1,movie2,movie3,movie4);
		}
	}
	}
}
