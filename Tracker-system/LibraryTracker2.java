import java.util.Scanner;
public class LibraryTracker2{
	public static void displayResults(int fictionCount, int nonfictionCount, int mysteryCount, int fantasyCount, int total, String genre1, String genre2, String genre3, String genre4){
		System.out.println("====== STATS ======");
		double percentage1 = (fictionCount / (double) total) * 100;
		System.out.printf("%s %.2f%%%n", genre1, percentage1);
		double percentage2 = (nonfictionCount / (double) total) * 100;
		System.out.printf("%s %.2f%%%n", genre2, percentage2);
		double percentage3 = (mysteryCount / (double) total) * 100;
		System.out.printf("%s %.2f%%%n", genre3, percentage3);
		double percentage4 = (fantasyCount / (double) total) * 100;
		System.out.printf("%s %.2f%%%n", genre4, percentage4);
		
		String popular = genre1;
		int max = fictionCount;
		
		if(nonfictionCount > max){
			max = nonfictionCount; 
			popular = genre2;
		}
		if(mysteryCount > max){
			max = mysteryCount;
			popular = genre3;
		}
		if(fantasyCount > max){
			max = fantasyCount;
			popular = genre4;
		}
		
		System.out.println("Most popular: " + popular);
		
	}
	public static String abbreviateGenre(String genre){
		String upperCase = genre.toUpperCase();
		if(upperCase.equalsIgnoreCase("NONFICTION")){
			upperCase = "NF";
		}else{
			return upperCase.substring(0,1);
		}
		return upperCase;
	}
	public static boolean validGenreName(String genre1, String genre2,String genre3, String genre4, String genre){
		
		if(genre.equalsIgnoreCase(genre1) || genre.equalsIgnoreCase(genre2) || genre.equalsIgnoreCase(genre3) || genre.equalsIgnoreCase(genre4)){
			return true;
		}else{
			System.out.println("Invalid genre name. Please try again.");
			return false;
		}
	}
	public static boolean validateCardNumber(long cardNumber){
		String numStr = String.valueOf(cardNumber);
		if(numStr.length() == 6){
			return true;
		}else{
			System.out.println("Invalid card number, length must be 6!");
			return false;
		}
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		int fictionCount = 0;
		int nonfictionCount = 0;
		int mysteryCount = 0; 
		int fantasyCount = 0;
		int total = 0;
		
		String genre1 = "FICTION";
		String genre2 = "NONFICTION";
		String genre3 = "MYSTERY";
		String genre4 = "FANTASY";
		
		while(true){
			System.out.print("Enter Library Card Number (6 digits) or -1 to exit: ");
			long cardNumber = kb.nextLong();
			
			if(cardNumber == -1){
				break;
			}
			
			if(validateCardNumber(cardNumber)){
				System.out.print("Are you an active member? (y/n): ");
				char active = kb.next().charAt(0);
				kb.nextLine();
				
				if(active == 'y' || active == 'Y'){
					
					boolean validGenre = true;
					while(validGenre){
						System.out.print("Enter favorite genre (Fiction, Nonfiction, Mystery, Fantasy): ");
						String genre = kb.nextLine();
						
						if(validGenreName(genre1,genre2,genre3,genre4,genre)){
							String abbrivated = abbreviateGenre(genre);
							validGenre = false;
							
							System.out.println("Abbriviated: " + abbrivated);
							
							if(genre.equalsIgnoreCase(genre1)){
								fictionCount++;
							}else if(genre.equalsIgnoreCase(genre2)){
								nonfictionCount++;
							}else if(genre.equalsIgnoreCase(genre3)){
								mysteryCount++;
							}else if(genre.equalsIgnoreCase(genre4)){
								fantasyCount++;
							}
							total++;
						}
					}
				}else{
					System.out.println("Only active members can select a genre.");
				}
			}
			
		}
		if(total > 0){
				displayResults(fictionCount,nonfictionCount,mysteryCount,fantasyCount,total,genre1,genre2,genre3,genre4);
			}else{
				System.out.println("No popular genre");
			}
	}
}
