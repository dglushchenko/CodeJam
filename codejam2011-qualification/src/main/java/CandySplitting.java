import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CandySplitting {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C-large-practice.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int n = scanner.nextInt();
			int xor = 0;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			while (n-- > 0) {
				int number = scanner.nextInt();
				xor ^= number;
				sum += number;
				if (number < min) {
					min = number;
				}
			}
			
			System.out.println("Case #" + caseNumber++ + ": " + (xor == 0 ? (sum - min) : "NO"));
		}
	}
	
}
