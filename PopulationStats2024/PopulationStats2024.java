import java.util.Scanner;
import java.util.Random;
public class PopulationStats2024{
	public static int avgHousholdOccupants(int[] occupants){
		int count = 0;
		for(int i = 0; i < occupants.length; i++){
			if(occupants[i] == 0){
				count++;
			}
		}
		return count;
	}
	public static double housholdsNotCounted(int[] occupants){
		int total = 0; 
		for(int i = 0; i < occupants.length; i++){
			total += occupants[i];
		}
		return (double) total / occupants.length;
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		
		int[] occupants = new int[100000];
		for(int i = 0; i < occupants.length; i++){
			occupants[i] = rand.nextInt(9);
		}
		double average = housholdsNotCounted(occupants);
		int notCounted = avgHousholdOccupants(occupants);
		
		System.out.println("Average occupants per household: " + average);
		System.out.println("Households that are not counted: " + notCounted);
		
	}
}
