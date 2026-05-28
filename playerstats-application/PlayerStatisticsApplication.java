public static void updateRuns(int[] runs, String[] playerNames){
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter player name to update: ");
		String player = kb.nextLine();
		
		for(int i = 0; i < playerNames.length; i++){
			if(player.equalsIgnoreCase(playerNames[i])){
				System.out.println("Enter new runs: ");
				runs[i] = kb.nextInt();
			}
		}
	}
public static int searchPlayer(String[] playerNames){
		Scanner kb = new Scanner(System.in);
		System.out.print("Search a player: ");
		String search = kb.nextLine();
		int index = -1;
		for(int i = 0; i < playerNames.length; i++){
			if(search.equalsIgnoreCase(playerNames[i])){
				index = i;
				break;
			}
		}
		return index;
	
public static void viewPlayers(String[] playerNames, String[] country, int[] runs, int[] matches){
		System.out.println("Names\t\tCountry\t\tRuns\tMatches");
		for(int i = 0; i <  playerNames.length; i++){
			System.out.println(playerNames[i] + "\t\t" + country[i] + "\t" + runs[i] + "\t" + matches[i]);
		}
	}
public static void addPlayerStats(String[] playerNames, int[] runs, int[] matches){
		Scanner kb = new Scanner(System.in);
		for(int i = 0; i < playerNames.length; i++){
			System.out.print("Enter runs for " + playerNames[i] + ": ");
			runs[i] = kb.nextInt();
			System.out.print("Enter matches played for " + playerNames[i] + ": ");
			matches[i] = kb.nextInt();
		}
	}
public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		String[] playerNames = {"BAVUMA", "KOHLI", "SMITH", "ROOT", "KANE", "BABAR", "RABADA"};
		String[] country = {"SOUTH AFRICA", "INDIA", "AUSTRALIA", "ENGLAND","NEW ZEALAND", "PAKISTAN", "SOUTH AFRICA"};
	
		int[] runs = new int[playerNames.length];
		int[] matches = new int[playerNames.length];
		
		System.out.println("===== WELCOME =====");
		System.out.println("1. Add player stats.\n2. View Player stats.\n3. Search player. \n4. Update runs. \n5. Sort players stats. \n6. Exit application...");
		System.out.print("Enter option: ");
		int option = kb.nextInt();
		while(option != 6){
			switch(option){
			case 1:
				addPlayerStats(playerNames,runs,matches);
				break;
			case 2: 
				viewPlayers(playerNames,country,runs,matches);
				break;
			case 3: 
				int searchPlay = searchPlayer(playerNames);
				if(searchPlay == -1){
					System.out.println("Player not found.");
					
				}else{
					System.out.println("Player found");
				}
				break;
			case 4:
				updateRuns(runs,playerNames);
				break;
			case 5:
				sortPlayers(playerNames,country,runs,matches);
				break;
			case 6:
				System.out.println("Closing...");
				break;
		
		}
		
		System.out.print("Enter option: ");
		option = kb.nextInt();
		}
		
	}
}
