import java.util.Scanner;
public class fileExtension{
	public static void displayDetails(String ini, String extension,long studNum){
		System.out.println("File downloading...\nFile downloaded");
		System.out.println(studNum + "_" + ini + "." + extension);
	}
public static boolean validateStudNum(long studNum){
		String numStr = String.valueOf(studNum);
		if(numStr.length() == 9 && numStr.substring(0,4).equals("2025") ){
			System.out.println("Correct student number format!");
			return true;
		}else{
			System.out.println("Invalid student number!");
			return false;
		}
	}
public static String getInitials(String fullnames){
		fullnames = fullnames.trim();
		String[] parts = fullnames.split(" ");
		String initials = "";
		String surname = parts[parts.length - 1];
		
		for(int i = 0; i < parts.length - 1; i++){
			initials += Character.toUpperCase(parts[i].charAt(0));
		}
		return initials + surname;
	}
public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String extension;
		
		while(true){
			System.out.print("Enter your fullnames: ");
			String fullnames = kb.nextLine();
			System.out.print("Enter your the file extension you want: ");
			extension = kb.nextLine();
		
			long studNum;
			while(true){
				System.out.print("Enter your student number: ");
                studNum = kb.nextLong();
				if(validateStudNum(studNum)){
					String ini = getInitials(fullnames);
					displayDetails(ini,extension,studNum);
					break;
				}
			}
			System.out.print("Still want to continue? (y/n): ");
            char c = kb.next().charAt(0);
            kb.nextLine();
			
            if (c != 'y' && c != 'Y') {
                break;
            }
		}
	}
}
