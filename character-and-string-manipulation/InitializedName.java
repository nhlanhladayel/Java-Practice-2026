import java.util.Scanner;
public class InitializedName{
	public static String getInitials(String names){
		names = names.trim();
		String[] parts = names.split(" ");
		String initials = " ";
		
		String lastname = parts[parts.length -1];
		for(int i = 0; i < parts.length - 1; i++){
			initials += Character.toUpperCase(parts[i].charAt(0)) + ". ";
		}
		
		return initials + lastname;
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter your names: ");
		String names = kb.nextLine();
		
		String initial = getInitials(names);
		System.out.print("Initials: " + initial);
	}
}
