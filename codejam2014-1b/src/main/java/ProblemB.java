import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemB {

	// private static final String PROBLEM_NAME = "B-test";

	private static final String PROBLEM_NAME = "B-small-attempt0";

	// private static final String PROBLEM_NAME = "B-small-attempt1";
	// private static final String PROBLEM_NAME = "B-small-attempt2";
	// private static final String PROBLEM_NAME = "B-small-attempt3";

	// private static final String PROBLEM_NAME = "B-large";

	public static void solve(Scanner in, PrintStream out) {
		int a = in.nextInt();
		int b = in.nextInt();
		int k = in.nextInt();
		int result = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if ((i & j) < k) {
					result++;
				}
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
