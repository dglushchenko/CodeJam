import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class ProblemB {

	private static final String PROBLEM_NAME = "B-test";
	
	public static void solve(Scanner in, PrintStream out) {
		int n = in.nextInt();
		int[][] tree = new int[n][2];
		int[] relations = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			tree[i][0] = in.nextInt();
			tree[i][1] = in.nextInt();
			relations[tree[i][0]]++;
			relations[tree[i][1]]++;
		}
		int maxWidth = 0;
		int maxIndex = 0;
		for (int i = 1; i < relations.length; i++) {
			if (relations[i] == 2) {
				int from = i;
				for (int j = i - 1; j >= 0; j--) {
					if (relations[j] == 3) {
						continue;
					}
					from = j + 1;
					break;
				}
				int to = i;
				for (int j = i + 1; j < relations.length; j++) {
					if (relations[j] == 3) {
						continue;
					}
					to = j - 1;
					break;
				}
				if (to - from + 1 > maxWidth) {
					maxWidth = to - from + 1; 
					maxIndex = i;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(PROBLEM_NAME + ".in"));
		PrintStream out = new PrintStream(new File(PROBLEM_NAME + ".out"));
		
		int t = in.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			out.print("Case #" + caseNumber++ + ": ");
			solve(in, out);
		}
	}
	
}
