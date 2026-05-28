	public static void sortServiceProvider(String[] serviceProviders, String[] originCountry, int[] subscribers, int[] userRatings){
		for(int i = 0; i < serviceProviders.length - 1; i++){
			for(int x = 0; x < serviceProviders.length - i - 1; x++){
				if(serviceProviders[x].compareTo(serviceProviders[x+1]) > 0){
					String tempProvide = serviceProviders[x];
					serviceProviders[x] = serviceProviders[x+1];
					serviceProviders[x+1] = tempProvide;
					
					String tempCountry = originCountry[x];
					originCountry[x] = originCountry[x+1];
					originCountry[x+1] = tempCountry;
					
					int tempSub = subscribers[x];
					subscribers[x] =  subscribers[x+1];
					subscribers[x+1] = tempSub;
					
					int tempRate = userRatings[x];
					userRatings[x] = userRatings[x+1];
					userRatings[x+1] = tempRate;
				}
			}
		}
	}
public static int mostWatchedService(int[] subscribers){
		int index = 0;
		int high = subscribers[0];
		for(int i = 0; i < subscribers.length; i++){
			if(subscribers[i] > high){
				high = subscribers[i];
				index = i;
			}
		}
		return index;
	}
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
