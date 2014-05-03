import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemA {

	//private static final String PROBLEM_NAME = "A-test";

	//private static final String PROBLEM_NAME = "A-small-attempt0";
	// private static final String PROBLEM_NAME = "A-small-attempt1";
	// private static final String PROBLEM_NAME = "A-small-attempt2";
	// private static final String PROBLEM_NAME = "A-small-attempt3";

	private static final String PROBLEM_NAME = "A-large-Ratmir";

	private static boolean checkFeglaWon(String[] array) {
		String[] strings = new String[array.length];
		System.arraycopy(array, 0, strings, 0, array.length);
		
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			for (int j = 0; j < s.length() - 1;) {
				if (s.charAt(j) == s.charAt(j + 1)) {
					s = s.substring(0, j) + s.substring(j + 1);
				} else {
					j++;
				}
			}
			strings[i] = s;
		}
		for (int i = 1; i < strings.length; i++) {
			if (!strings[0].equals(strings[i])) {
				return true;
			}
		}
		return false;
	}

	public static void solve(Scanner in, PrintStream out) {
		int n = in.nextInt();
		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = in.next();
		}

		if (checkFeglaWon(strings)) {
			out.println("Fegla Won");
			return;
		}

		int diffLetters = 1;
		for (int i = 0; i < strings[0].length() - 1; i++) {
			if (strings[0].charAt(i) != strings[0].charAt(i + 1)) {
				diffLetters++;
			}
		}
		int[][] letters = new int[n][diffLetters];
		for (int i = 0; i < n; i++) {
			String s = strings[i];
			int index = 0;
			for (int j = 0; j < s.length() - 1; j++) {
				letters[i][index]++;
				if (s.charAt(j) != s.charAt(j + 1)) {
					index++;
				}
			}
			letters[i][index]++;
		}
		
		int result = 0;
		for (int i = 0; i < diffLetters; i++) {
			/*double average = 0.0;
			for (int j = 0; j < n; j++) {
				average += letters[j][i];
			}
			average /= n;
			int mid = -1;
			double minDelta = Double.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (Math.abs(average - letters[j][i]) < minDelta) {
					minDelta = Math.abs(average - letters[j][i]);
					mid = letters[j][i];
				}
			}*/
			long minSum = Long.MAX_VALUE;
			int mid = -1;
			for (int j = 0; j < n; j++) {
				long sum = 0;
				for (int k = 0; k < n; k++) {
					if (j == k) {
						continue;
					}
					sum += Math.abs(letters[j][i] - letters[k][i]);
				}
				if (sum < minSum) {
					minSum = sum;
					mid = letters[j][i];
				}
			}
			for (int j = 0; j < n; j++) {
				result += Math.abs(letters[j][i] - mid);
			}
		}
		
		out.println(result);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(PROBLEM_NAME + ".in"));
		PrintStream out = new PrintStream(new File(PROBLEM_NAME + ".out"));

		int t = in.nextInt();
		int caseNumber = 1;
		long start = System.currentTimeMillis();
		while (caseNumber <= t) {
			System.out.println((System.currentTimeMillis() - start) + ": Case #" + caseNumber);
			out.print("Case #" + caseNumber++ + ": ");
			solve(in, out);
		}
	}

}
