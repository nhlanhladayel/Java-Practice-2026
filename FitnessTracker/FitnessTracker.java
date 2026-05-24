import java.util.Scanner;
public class FitnessTracker{
	public static void displayMetrics(int cardioC, int coreC, int pilatesC, int strengthC, int total, String a1, String a2, String a3, String a4){
		System.out.println("====RESULTS====");
		
		double perc1 = (cardioC / (double) total) * 100;
		System.out.printf("%.2f%%%n",a1,perc1);
		double perc2 = (coreC / (double) total) * 100;
		System.out.printf("%.2f%%%n",a2,perc2);
		double perc3 = (pilatesC / (double) total) * 100;
		System.out.printf("%.2f%%%n",a3,perc3);
		double perc4 = (strengthC / (double) total) * 100;
		System.out.printf("%.2f%%%n",a4,perc4);
		
		String popular = a1;
		int max = cardioC;
		
		if(coreC > max){
			max = coreC;
			popular = a2;
		}
		if(pilatesC > max){
			max = pilatesC;
			popular = a3;
		}
		if(strengthC > max){
			max = strengthC;
			popular = a4;
		}
		
		System.out.println("Most popular: " + popular);
	}
	public static String abbreviateActivity(String activity){
		String upperCased = activity.toUpperCase();
		if(upperCased.equalsIgnoreCase("CARDIO")){
			upperCased = "CA";
		}else if(upperCased.equalsIgnoreCase("CORE")){
			upperCased = "CO";
		}else{
			return upperCased.substring(0,1);
		}
		return upperCased;
	}
	public static boolean validActivityName(String a1, String a2, String a3, String a4, String activity){
		if(activity.equalsIgnoreCase(a1) || activity.equalsIgnoreCase(a2) || activity.equalsIgnoreCase(a3) || activity.equalsIgnoreCase(a4)){
			return true;
		}else{
			System.out.println("Invalid activity name. Please try again...");
			return false;
		}
	}
	public static boolean validateMemberAge(int age){
		if(age >= 5 && age <= 120){
			return true;
		}else{
			System.out.println("Invalid age.");
			return false;
		}
	}
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		String a1 = "CARDIO";
		String a2 = "CORE";
		String a3 = "PILATES";
		String a4 = "STRENGTH";
		
		int cardioC = 0;
		int coreC = 0; 
		int pilatesC = 0;
		int strengthC = 0;
		
		int total = 0;
		
		boolean validAge = true;
		
		while(validAge){
			System.out.print("Enter member age (or 0 to exit): ");
			int age = kb.nextInt();
			
			if(age == 0){
				break;
			}
			 if(validateMemberAge(age)){
				System.out.print("Does member have membership? (y/n): ");
				char validMember = kb.next().charAt(0);
				kb.nextLine();
				
				if(validMember == 'y' || validMember == 'Y'){
					
					boolean validAct = true;
					while(validAct){
						
						System.out.print("Enter favourite activity (Cardio, Core, Pilates, Strength): ");
						String activity = kb.nextLine();
						validAge = false;
						
						if(validActivityName(a1,a2,a3,a4,activity)){
							String abbriviated = abbreviateActivity(activity);
							validAct = false;
							
							System.out.println("Abbriviated: " + abbriviated);
							
							if(activity.equalsIgnoreCase(a1)){
								cardioC++;
							}
							if(activity.equalsIgnoreCase(a2)){
								coreC++;
							}
							if(activity.equalsIgnoreCase(a3)){
								pilatesC++;
							}
							if(activity.equalsIgnoreCase(a4)){
								strengthC++;
							}
							total++;
						}
					}	
				}else{
					System.out.println("Only those has membership can rate.");
				}
				
			 }
			
		}
		if(total > 0){
			displayMetrics(cardioC,coreC,pilatesC,strengthC,total,a1,a2,a3,a4);
		}else{
			System.out.println("No popular found.");
		}
		
	}
}
