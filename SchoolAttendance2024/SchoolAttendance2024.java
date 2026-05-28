import java.util.Scanner;
import java.util.Random;
public class SchoolAttendance2024{
	public static int absentLearners(int[] learners){
		int count = 0;
		for(int i = 0; i < learners.length; i++){
			if(learners[i] == 0){
				count++;
			}
		}
		return count;
	}
	public static double avgAttendance(int[] learners){
		int total = 0;
		for(int i = 0; i < learners.length; i++){
			total += learners[i];
		}
		return (double) total/learners.length;
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		
		int[] learners = new int[50000];
		for(int i = 0; i < learners.length; i++){
			learners[i] = rand.nextInt(20);
		}
		
		double avg = avgAttendance(learners);
		int absent = absentLearners(learners);
		
		System.out.println("Average: " + avg);
		System.out.println("Absent: " + absent);
	}
}
