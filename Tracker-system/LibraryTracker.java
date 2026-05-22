import java.util.Scanner;
public class LibraryTracker{
	
	public static void displayResults(int fictionCount, int nonfictionCount, int mysteryCount, int fantasyCount,int total, String FICTION, String NONFICTION, String MYSTERY, String FANTASY){
		System.out.println("===== STATS RESULTS =====");
		double percentage = (fictionCount/(double)total) * 100;
		System.out.println(FICTION + " " + percentage);
		double percentage2 = (nonfictionCount/(double)total) * 100;
		System.out.println(NONFICTION + " " + percentage2);
		double percentage3 = (mysteryCount/(double)total) * 100;
		System.out.println(MYSTERY + " " + percentage3);
		double percentage4 = (fantasyCount/(double)total) * 100;
		System.out.println(FANTASY + " " + percentage4);
		
		String popular = FICTION;
		int max = fictionCount;
		
		if(nonfictionCount > max){
			max = nonfictionCount;
			popular = NONFICTION;
		}
		if(mysteryCount > max){
			max = mysteryCount;
			popular = MYSTERY;
		}
		if(fantasyCount > max){
			max = fantasyCount;
			popular = FANTASY;
		}
		System.out.println("Most pupular genre: " + popular);
	}
	public static void displayCount(String FICTION, String NONFICTION, String MYSTERY, String FANTASY,int fictionCount, int nonfictionCount, int mysteryCount, int fantasyCount,int total, String genreEntered){
		if(genreEntered.equalsIgnoreCase(FICTION)){
			fictionCount++;
		}else if(genreEntered.equalsIgnoreCase(NONFICTION)){
			nonfictionCount++;
		}else if(genreEntered.equalsIgnoreCase(MYSTERY)){
			mysteryCount++;
		}else if(genreEntered.equalsIgnoreCase(FANTASY)){
			fantasyCount++;
		}
		total++;
	}
	public static String abbreviateGenre(String genreEntered){
		String upperCased = genreEntered.toUpperCase();
		if(upperCased.equals("NONFICTION")){
			return "NF";
		}else{
			return String.valueOf(upperCased.charAt(0));
		}
	}
	public static boolean validGenreName(String FICTION, String NONFICTION,String MYSTERY, String FANTASY, String genreEntered){
		boolean validfiction ;
		if(genreEntered.equalsIgnoreCase(FICTION) || genreEntered.equalsIgnoreCase(NONFICTION) || genreEntered.equalsIgnoreCase(MYSTERY) || genreEntered.equalsIgnoreCase(FANTASY)){
			validfiction = true;
		}else{
			System.out.print("Invalid genre, please try again");
			validfiction = false;
		}
		return validfiction;
	}
	public static boolean validateCardNumber(long libraryCardNumber){
		String numStr = String.valueOf(libraryCardNumber);
		if(numStr.length() == 6){
			return true;
		}else{
			System.out.println("Invalid card number!");
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
		
		String FICTION = "FICTION";
		String NONFICTION = "NONFICTION";
		String MYSTERY = "MYSTERY";
		String FANTASY = "FANTASY";
		
		while(true){
			System.out.print("Enter Library card number (6-digits) or -1 to exit: ");
			long libraryCardNumber = kb.nextLong();
			
			if(libraryCardNumber == -1){
				break;
			}
			if(validateCardNumber(libraryCardNumber)){
				System.out.print("Are you an active member?: ");
				char activeMember = kb.next().charAt(0);
				kb.nextLine();
				
				if(activeMember == 'y'){
					boolean validGenre = false;
					while(!validGenre){
						System.out.print("Enter favorite genre (Fiction, Nonfiction, Mystery, Fantasy): ");
						String genreEntered = kb.nextLine();
						
						if(validGenreName(FICTION,NONFICTION,MYSTERY,FANTASY,genreEntered)){
							validGenre = true;
							String validG = abbreviateGenre(genreEntered);
							System.out.println(validG);
							
							displayCount();
						}
					}
					
				}
				else{
					System.out.println(" Only active members can select a genre.");
				}
			}
			if(total > 0){
				displayResults();
			}else{
				System.out.print("No data to display");
			}
		}
	}
}
