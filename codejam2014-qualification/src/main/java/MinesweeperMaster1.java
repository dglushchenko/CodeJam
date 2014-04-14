import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinesweeperMaster1 {

	public static String findBoard(int r, int c, int m) {
		StringBuilder sb = new StringBuilder();
		int mForLastTwoRows = m - c * (r - 2);
		int x = mForLastTwoRows / 2;
		if (
			!(r == 1 && c == 1 && m == 0) &&
			((r == 1 && m > c - 2) || 
			(c == 1 && m > r - 2) || 
			(r > 1 && c > 1 && m > r * c - 4) ||
			(mForLastTwoRows % 2 == 1))
		) {
			sb.append("Impossible\n");
		} else {
			int lastRowLength = m % c;
			boolean canPutInColumn = (r - m / c) == lastRowLength;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					boolean theAreStillBombs = m > 0;
					boolean weAreNotCloseToC = i < r - 2 || j < x;
					boolean thisIsNotSecondColumnInLastRow = !(lastRowLength != 0 && c - j <= 2 && m == 1);
					if (theAreStillBombs && weAreNotCloseToC && thisIsNotSecondColumnInLastRow) {
						sb.append("*");
						m--;
					} else {
						if (i == r - 1 && j == c - 1) {
							sb.append("c");
						} else {
							sb.append(".");
						}
					}
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C-test.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int m = scanner.nextInt();

			System.out.println("Case #" + caseNumber++ + ":");
			System.out.println(findBoard(r, c, m));

		}
	}
}
