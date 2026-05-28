public static void populateRatings(int[] userRatings, String[] serviceProviders){
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < userRatings.length; i++){
			System.out.print("Enter user for (1-5) for " + serviceProviders[i] + " : ");
			userRatings[i] = input.nextInt();
			
			while(userRatings[i] < 1 || userRatings[i] > 5){
				System.out.println("Invalid ratings, must be between 1 - 5");
				System.out.print("Enter user for (1-5) for " + serviceProviders[i] + " : ");
				userRatings[i] = input.nextInt();
			}
		}
	}
public static void populateSubscribers(int[] subscribers){
		Random rand = new Random();
		for(int i = 0; i < subscribers.length; i++){
			subscribers[i] = rand.nextInt(400000) + 100000;
		}
	}
public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String[] serviceProviders = {"Youtube", "Netflix", "DSTV", "Showmax", "PrimeTV", "SABC"};
		String[] originCountry = {"SA", "USA", "SA", "SA", "USA", "SA"};
		
		int[] userRatings = new int[serviceProviders.length];
		int[] subscribers = new int[serviceProviders.length];
		
		populateSubscribers(subscribers);
		populateRatings(userRatings,serviceProviders);
		int mostStreamed = mostWatchedService(subscribers);
		System.out.println("Most streamed is : " + subscribers[mostStreamed]);
		
		sortServiceProvider(serviceProviders,originCountry,subscribers,userRatings);
		displayStreamingServices(serviceProviders,originCountry,subscribers,userRatings);
		System.out.print("Search a country: ");
		String search = input.nextLine(); 
		
		int searchCountry = searchCountry(originCountry,search);
		if(searchCountry == -1){
			System.out.println(search + " was not found");
		}else{
			System.out.println(search + " was found.");
		}
	}
}
