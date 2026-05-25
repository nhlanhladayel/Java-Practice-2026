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
