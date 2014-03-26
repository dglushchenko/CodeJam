import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Magicka {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("B-large-practice.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int c = scanner.nextInt();
			String[] combines = new String[c];
			int cIndex = 0;
			while (cIndex < c) {
				combines[cIndex++] = scanner.next();
			}
			int d = scanner.nextInt();
			String[] opposes = new String[d];
			int dIndex = 0;
			while (dIndex < d) {
				opposes[dIndex++] = scanner.next();
			}
			scanner.nextInt();
			String invokes = scanner.next();
			
			String result= "";
			for (char invoke : invokes.toCharArray()) {
				result += invoke;
				if (result.length() > 1) {
					String lastTwo = result.substring(result.length() - 2);
					for (String combine : combines) {
						if (combine.startsWith(lastTwo) || String.valueOf(new char[] {combine.charAt(1), combine.charAt(0)}).startsWith(lastTwo)) {
							result = result.substring(0, result.length() - 2) + combine.charAt(2);
							break;
						}
					}
					for (String oppose : opposes) {
						if (result.indexOf(oppose.charAt(0)) != -1 && result.indexOf(oppose.charAt(1)) != -1) {
							result = "";
							break;
						}
					}
				}
			}
			
			System.out.println("Case #" + caseNumber++ + ": " + Arrays.toString(result.toCharArray()));
		}
	}
}
