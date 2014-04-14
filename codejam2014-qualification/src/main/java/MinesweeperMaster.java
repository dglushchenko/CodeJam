import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinesweeperMaster {

	public static String findBoard(int r, int c, int m) {
		StringBuilder sb = new StringBuilder();
		int numberOfFullRows = m / c;
		int mForLastTwoRows = m - c * (r - 2);
		if (
			!(r == 1 && c == 1 && m == 0) && 
			(
				(r == 1 && m > c - 2) || 
				(c == 1 && m > r - 2) || 
				(r > 1 && c > 1 && m > r * c - 4) || 
				(numberOfFullRows == r - 2 && mForLastTwoRows % 2 == 1)
			) ||
			(r == 2 && m % 2 == 1) ||
			(c == 2 && m % 2 == 1)
		) {
			sb.append("Impossible\n");
		} else {
			boolean[][] map = new boolean[r][c];

			if (r == 1) {
				for (int i = 0; i < c && m > 0; i++, m--) {
					map[0][i] = true;
				}
			} else if (c == 1) {
				for (int i = 0; i < r && m > 0; i++, m--) {
					map[i][0] = true;
				}
			} else {

				for (int i = 0; i < numberOfFullRows && i < r - 2; i++) {
					for (int j = 0; j < c; j++) {
						map[i][j] = true;
					}
				}

				if (numberOfFullRows < r - 2) {
					if (m % c < c - 1) {
						for (int i = 0; i < m % c; i++) {
							map[numberOfFullRows][i] = true;
						}
					} else if (m % (r - numberOfFullRows) < (r - numberOfFullRows) - 1) {
						if (m % c < r - numberOfFullRows) {
							for (int i = numberOfFullRows, k = m % c; i < r && k > 0; i++, k--) {
								map[i][0] = true;
							}
						} else {
							int k = m % c;
							for (int j = 0; j < c; j++) {
								for (int i = numberOfFullRows; i < r && k > 0; i++) {
									map[i][j] = true;
									k--;
								}
							}
						}
					} else {
						for (int i = 0; i < m % c - 1; i++) {
							map[numberOfFullRows][i] = true;
						}
						map[numberOfFullRows + 1][0] = true;
					}
				} else {
					int k = mForLastTwoRows;
					for (int j = 0; j < c && k > 0; j++) {
						for (int i = r - 2; i < r; i++) {
							map[i][j] = true;
							k--;
						}
					}
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					char charToAppend;
					if (i == r - 1 && j == c - 1) {
						charToAppend = 'c';
					} else {
						charToAppend = map[i][j] ? '*' : '.';
					}
					sb.append(charToAppend);
				}
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C-small-attempt3.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int m = scanner.nextInt();

			System.out.println("Case #" + caseNumber++ + ":");
			System.out.print(findBoard(r, c, m));

		}
	}
}
