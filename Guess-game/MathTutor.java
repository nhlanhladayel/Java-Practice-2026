import java.util.Scanner;
import java.util.Random;
public class MathTutor{
	public static String hint(int num1, int num2, int answer){
		String str = " ";
		if(answer > num1 * num2){
			str = "Too high";
		}else if(answer < num1 * num2){
			str = "Too low";
		}
		return str;
	}
	public static boolean answerCorrect(int num1, int num2, int answer){
		int total = num1 * num2;
		if(answer == total){
			return true;
		}else{
			return false;
		}
	}
	public static String createQuestion(int num1, int num2){
		String str = "How much is " + num1 + " times " + num2 + " ?";
		return str;
	}
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Enter your name: ");
		String name = kb.nextLine();
		int num1 = rand.nextInt(9) + 1;
		int num2 = rand.nextInt(9) + 1;
		while(true){
			String num = createQuestion(num1,num2);
			System.out.print(num);
			int answer = kb.nextInt();
			kb.nextLine();
			
			if(answerCorrect(num1,num2,answer)){
				System.out.println("Congratulations " + name + " " + answer + " is correct!");
			}else{
				String hintAnswer = hint(num1,num2,answer);
				System.out.println(hintAnswer);
			}
			
			System.out.print("Do you still want to play?: ");
			char choice = kb.next().charAt(0);
			
			if(choice == 'y' || choice == 'Y'){
				num = createQuestion(num1,num2);
				System.out.print(num);
				answer = kb.nextInt();
			}else{
				break;
			}
		}
	}
}
