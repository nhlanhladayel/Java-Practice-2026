import java.util.Scanner;
public class SoshanguveMarathonApp{
	public static String calculateFinishTime(double minuteRan){
		int hours = (int) minuteRan/60;
		int minutes = (int) minuteRan % 60;
		
		if(hours > 1){
			return hours + " hours and " + minutes + " minutes";
		}else{
			return minutes + " minutes";
		}
	}
	public static void determineMedalCategory(double minuteRan, double GOLD, double SILVER,double BRONZE){
		if(minuteRan <= 35){
			System.out.println("Congratulations! You've earned a Gold Medal for completing the 10K race.");
		}else if(minuteRan <= 45){
			System.out.println("Great job! You've earned a Silver Medal for completing the 10K race.");
		}else if(minuteRan <= 150){
			System.out.println("Well done! You've earned a Bronze Medal for completing the 10K race.");
		}else{
				System.out.println("No medal");
			}
	}
	public static boolean validateUserInput(double minuteRan){
		if(minuteRan >= 0 && minuteRan <= 180){
			return true;
		}else{
			System.out.println("Invalid finish time, must not 0 or exceeds 180 minutes.");
			return false;
		}
	}
	public static double getUserInput(Scanner kb){
		System.out.print("Enter the completion time for the 10K race in minutes: ");
		double minutes = kb.nextDouble();
		return minutes;
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		double GOLD = 35;
		double SILVER = 45;
		double BRONZE = 150;
		
		
		boolean time = true;
		while(time){
			double minuteRan = getUserInput(kb);
			
			if(validateUserInput(minuteRan)){
				String timeFormatted = calculateFinishTime(minuteRan);
				System.out.println("Time: " + timeFormatted);
				determineMedalCategory(minuteRan,GOLD,SILVER,BRONZE);
				time = false;
			}
		}	
	}
}	
