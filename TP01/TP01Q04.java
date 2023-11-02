import java.util.Random;
import java.util.Scanner;

public class TP104 {
	public static void main(String[] args) {
		
		Random random = new Random();
		random.setSeed(4);
		Scanner scanner = new Scanner(System.in,"ASCII");
		
		
		char char1;
		char char2;
		String text = "";
		String str = "";
		
		do {
			text = scanner.nextLine();
			char1 = (char)('a' + (Math.abs(random.nextInt()) %26));
			char2 = (char)('a' + (Math.abs(random.nextInt()) %26));
			str = text.replace(char1, char2);	
			
			
			System.out.println(str);
		}while(!text.equals("FIM"));
		scanner.close();
	}
}