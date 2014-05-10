import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	private static final String PROBLEM_NAME = "A-large";

	// private static final String PROBLEM_NAME = "A-small-attempt0";
	// private static final String PROBLEM_NAME = "A-small-attempt1";
	// private static final String PROBLEM_NAME = "A-small-attempt2";
	// private static final String PROBLEM_NAME = "A-small-attempt3";

	// private static final String PROBLEM_NAME = "A-large";

	private static String flip(String s) {
		return s.replaceAll("1", "x").replaceAll("0", "1").replaceAll("x", "0");
	}
	
	public static void solve(Scanner in, PrintStream out) {
		int n = in.nextInt();
		int l = in.nextInt();
		String[] sockets = new String[l];
		for (int i = 0; i < n; i++) {
			int number = in.nextInt();
			for (int j = 0; j < l; j++) {
				int mask = 1 << j;
				if ((number & mask) == mask) {
					sockets[j] += "1";
				} else {
					sockets[j] += "0";
				}
			}
		}

		String[] devices = new String[l];
		for (int i = 0; i < n; i++) {
			int number = in.nextInt();
			for (int j = 0; j < l; j++) {
				int mask = 1 << j;
				if ((number & mask) == mask) {
					devices[j] += "1";
				} else {
					devices[j] += "0";
				}
			}
		}

		int count = 0;
		boolean possile = true;
		for (int j = 0; j < l; j++) {
			if (sockets[j] == devices[j]) {
				//con
			}
		}
		if (possile) {
			out.println(count);
		} else {
			out.println("NOT POSSIBLE");
		}
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
