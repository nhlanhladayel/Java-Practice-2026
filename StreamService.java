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
