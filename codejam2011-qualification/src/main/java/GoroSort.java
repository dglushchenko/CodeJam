import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoroSort {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("D-large-practice.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int n = scanner.nextInt();
			int result = 0;
			for (int i = 0; i < n; i++) {
				if (scanner.nextInt() != i + 1) {
					result++;
				}
			}

			System.out.println("Case #" + caseNumber++ + ": " + result + ".000000");
		}
	}

}
