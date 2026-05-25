import java.util.Scanner;
public class InitializedName{
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter your names: ");
		String names = kb.nextLine();
		
		String initial = getInitials(names);
		System.out.print("Initials: " + initial);
	}
}
