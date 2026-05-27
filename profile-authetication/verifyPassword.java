	public static boolean checkLower(String password){
		int lower = 0;
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(Character.isLowerCase(ch)){
				lower++;
			}
		}
		return lower > 0;
	}
public static int countUpper(String password, int upperCount){
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			if(Character.isUpperCase(ch)){
				upperCount++;
			}
		}
		return upperCount;
	}
public static boolean checkUpper(String password){
		int upper = 0;
		for(int i = 0; i < password.length(); i++){
			char ch = password.charAt(i);
			
			if(Character.isUpperCase(ch)){
				upper++;
			}
		}
		return upper > 0;
	}
public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		int lowerCount = 0;
		int upperCount = 0;
		int countDigit = 0; 
		int countSpecial = 0;
		
		while(true){
			System.out.print("Enter your password: ");
			String password = kb.nextLine();
		
			if(password.length() < 8){
				System.out.println("Password must be atleast 8 or more...");
				continue;
			}else{
				boolean valid = checkUpper(password) && checkLower(password) && checkDigit(password) && checkSpecial(password);
				if(valid){
					System.out.println("Password id strong.");
					int upperC = countUpper(password,upperCount);
					int lowerC = countLower(password,lowerCount);
					int speacialC = countSpecial(password,countSpecial);
					int digitC = countDigit(password,countDigit);
					System.out.println("Has " + upperC + " upper cases.");
					System.out.println("Has " + lowerC + " lower cases.");
					System.out.println("Has " + speacialC + " speacial cases.");
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
