import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemC {

	private static final String PROBLEM_NAME = "C-test";

	// private static final String PROBLEM_NAME = "C-small-attempt0";
	// private static final String PROBLEM_NAME = "C-small-attempt1";
	// private static final String PROBLEM_NAME = "C-small-attempt2";
	// private static final String PROBLEM_NAME = "C-small-attempt3";

	// private static final String PROBLEM_NAME = "C-large";

	public static void solve(Scanner in, PrintStream out) {
		
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
