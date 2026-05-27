import java.util.Scanner;
public class VerifyPassword{
	public static int countDigit(String password){
		int countDigit = 0; 
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(Character.isDigit(ch)){
				countDigit++;
			}
		}
		return countDigit;
	}
	public static boolean checkDigit(String password){
		return countDigit(password) > 0;
	}
	public static int countSpecial(String password){
		int countSpecial = 0;
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(!Character.isLetterOrDigit(ch)){
				countSpecial++;
			}
		}
		return countSpecial;
	}
	public static boolean checkSpecial(String password){
		return countSpecial(password) > 0;
	}
	public static int countLower(String password){
		int lowerCount = 0;
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(Character.isLowerCase(ch)){
				lowerCount++;
			}
		}
		return lowerCount;
	}
	public static boolean checkLower(String password){
		return countLower(password) > 0;
	}
	public static int countUpper(String password){
		int upperCount = 0;
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(Character.isUpperCase(ch)){
				upperCount++;
			}
		}
		return upperCount;
	}
	public static boolean checkUpper(String password){
		return countUpper(password) > 0;
	}
	public static boolean validateCard(long studentCard){
		String numStr = String.valueOf(studentCard);
		if(numStr.length() == 9 && numStr.substring(0,4).equals("2026")){
			return true;
		}else{
			System.out.println("Invalid student number!");
			return false;
		}
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
	
		
		while(true){
			System.out.print("Enter your student card: ");
			long studentCard = kb.nextLong();
			kb.nextLine();
			if(validateCard(studentCard)){
				System.out.print("Enter your password: ");
				String password = kb.nextLine();
			if(password.length() < 8){
				System.out.println("Password must be at least 8 or more...");
				continue;
			}else{
				boolean valid = checkUpper(password) && checkLower(password) && checkDigit(password) && checkSpecial(password);
				if(valid){
					System.out.println("Password is strong.");
					int upperC = countUpper(password);
					int lowerC = countLower(password);
					int speacialC = countSpecial(password);
					int digitC = countDigit(password);
					System.out.println("Has " + upperC + " upper cases.");
					System.out.println("Has " + lowerC + " lower cases.");
					System.out.println("Has " + speacialC + " special cases.");
					System.out.println("Has " + digitC + " digits.");
					break;
				}else{
					if(!checkUpper(password)){
						System.out.println("No upper case.");
					}
					if(!checkLower(password)){
						System.out.println("No lower case.");
					}
					if(!checkDigit(password)){
						System.out.println("No digits.");
					}
					if(!checkSpecial(password)){
						System.out.println("No speacial case.");
					}
				}
				System.out.print("Do you wish to continue checking? (y/n): ");
				char check = kb.next().charAt(0);
				kb.nextLine();
				if(check == 'n' || check == 'N'){
					System.out.println("Thank you.");
					break;
				}
			}
		}
		
	}		
	
	}
}
