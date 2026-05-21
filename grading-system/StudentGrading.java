public static void recordMarks(long studentNum, int mark, String courseName){
		if(courseName.equalsIgnoreCase(COURSE1)){
			courseStud1++;
		if(mark >= 50){
				studPassed1++;
			}
		}
		else if(courseName.equalsIgnoreCase(COURSE2)){
			courseStud1++;
			if(mark >= 50){
				studPassed2++;
			}
		}
		else if(courseName.equalsIgnoreCase(COURSE3)){
			courseStud3++;
			if(mark >= 50){
				studPassed3++;
			}
		}
		if(mark > highestMark){
			highestMark = mark;
			highestStud = studentNum;
		}
	}
public static String determineGrade(int mark){
		String finalGrade = "";
		if(mark >= 75){
			finalGrade = "A";
		}else if(mark >= 65){
			finalGrade = "B";
		}else if(mark >= 50){
			finalGrade = "C";
		}else if(mark >= 40){
			finalGrade = "D";
		}else if(mark < 40){
			finalGrade = "F";
		}
		return finalGrade;
	}
public static boolean validateMark(int mark){
		return mark >= 0 && mark <= 100;
	}
public static boolean validCourse(String courseName){
		return courseName.equalsIgnoreCase(COURSE1) || courseName.equalsIgnoreCase(COURSE2) || courseName.equalsIgnoreCase(COURSE3);
	}
public static boolean validateStudentNumber(long studentNum){
		String numStr = String.valueOf(studentNum);
		return numStr.length() == 9 && numStr.substring(0,4).equals("2025");
	}
public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		
		while(true){
			System.out.print("Enter Student Number (-1 to Stop): ");
			long studentNum = kb.nextLong();
			kb.nextLine();
			
			if(studentNum == -1)
			{
				System.out.print("Exiting program");
				break;
			}
			if(!validateStudentNumber(studentNum))
			{
				System.out.println("Invalid student number");
				continue;
			}
			System.out.print("Enter course(Computer Science/Informations System/Software Engineering): ");
			String courseName = kb.nextLine();
			
			if(!validCourse(courseName))
			{
				System.out.println("Invalid course! Try again");
				continue;
			}
			System.out.print("Enter Final Mark: ");
			int mark = kb.nextInt();
			
			if(!validateMark(mark))
			{
				System.out.print("Invalid mark");
				continue;
			}
			String grade = determineGrade(mark);
			recordMarks(studentNum,mark,courseName);
			
			System.out.println("Grade: " + grade);
			
		}
		displayResults();
		
	}
}
