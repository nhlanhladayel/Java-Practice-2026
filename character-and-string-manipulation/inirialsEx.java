import java.util.Scanner;
public class inirialsEx{
	public static String getInitials(String fullnames){
		fullnames = fullnames.trim();
		String[] parts = fullnames.split(" ");
		String inirials = " ";
		
		String surname = parts[parts.length - 1];
		for(int i = 0; i < parts.length - 1; i++){
			inirials += Character.toUpperCase(parts[i].charAt(0)) + ".";
		}
		return inirials + surname;
		
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter your fullnames: ");
		String fullnames = kb.nextLine();
		
		String initials = getInitials(fullnames);
		System.out.println("Initials: " + initials);
	}
}
