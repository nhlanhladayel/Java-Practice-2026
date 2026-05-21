import java.util.Scanner;
public class StudentGradingSystem{
		static final String COURSE_CS = "Computer Science";
		static final String COURSE_IS = "Information System";
		static final String COURSE_SE = "Software Engineering";
		
		static int csTotal = 0;
		static int isTotal = 0;
		static int seTotal = 0;
		
		static int csPass = 0;
		static int isPass = 0;
		static int sePass = 0;
		
		static int highestMark = 0;
		static long highestStudent = 0;
		
		public static void displayResults(){
			System.out.println("Final results:");
			System.out.println(COURSE_CS + " pass rate: " + (csPass*100) / csTotal);System.out.println(COURSE_CS + " pass rate: " + (csPass*100) / csTotal); 
			System.out.println(COURSE_IS + " pass rate: " + (isPass*100) / isTotal);System.out.println(COURSE_CS + " pass rate: " + (csPass*100) / csTotal); 
			System.out.println(COURSE_SE + " pass rate: " + (sePass*100) / seTotal);System.out.println(COURSE_CS + " pass rate: " + (csPass*100) / csTotal); 
			System.out.println("Highest scoring student " + highestStudent + " with " + highestStudent);
		}
		public static void recordMarks(long studentNumber, String course, int mark){
			if(course.equalsIgnoreCase(COURSE_CS)){
				csTotal++;
				if(mark >= 50){
					csPass++;
				}
			}
			else if(course.equalsIgnoreCase(COURSE_IS)){
				isTotal++;
				if(mark >= 50){
					isPass++;
				}
			}
			else if(course.equalsIgnoreCase(COURSE_SE)){
				seTotal++;
				if(mark >= 50){
					sePass++;
				}
			}
			if(mark > highestMark){
				highestMark = mark;
				highestStudent = studentNumber;
			}
		}
		public static String determineGrade(int mark){
			String finalLetter = "";
			
			if(mark >= 70){
				finalLetter = "A";
			}
			else if(mark >= 65){
				finalLetter = "B";
			}
			else if(mark >= 50){
				finalLetter = "C";
			}
			else if(mark >= 40){
				finalLetter = "D";
			}
			else if(mark < 40){
				finalLetter = "F";
			}
			
			return finalLetter;
		}
		public static boolean validateMark(int mark){
			return mark >= 0 && mark <= 100;
		}
		public static boolean validCourse(String course){
			return course.equalsIgnoreCase(COURSE_CS) || course.equalsIgnoreCase(COURSE_IS) || course.equalsIgnoreCase(COURSE_SE);
		}
		public static boolean validateStudentNumber(long studentNumber){
			
			String strNum = String.valueOf(studentNumber);
			return strNum.length() == 9 && strNum.substring(0,4).equals("2025");
			
		}
		public static void main(String[] args){
			Scanner kb = new Scanner(System.in);
			
			while(true){
				System.out.print("Enter student number: ");
				long studentNumber = kb.nextLong();
				kb.nextLine();
				if(!validateStudentNumber(studentNumber)){
					System.out.println("Invalid student number, Try again!");
					continue;
				}
				
				System.out.print("Enter student name: ");
				String studentName = kb.nextLine();
				
				System.out.print("Enter Course (Computer Science / Information Systems / Software Engineering): ");
				String course = kb.nextLine();
				
				if(!validCourse(course)){
					System.out.println("Invalid course name!");
					continue;
				}
				
				System.out.print("Enter final mark (0-100): ");
				int mark = kb.nextInt();
				
				if(!validateMark(mark)){
					System.out.println("Invalid mark. Must be between 0 and 100.");
					continue;
				}
				
				String grade = determineGrade(mark);
				System.out.print("Grade achieved: " + grade);
				
				recordMarks(studentNumber,course,mark);
				displayResults();
			}
		}
}
