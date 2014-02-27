import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class SnapperChain {

	/*
	 * private static long pow(long base, long exp) { long result = 1;
	 * 
	 * while (exp-- > 0) { result *= base; }
	 * 
	 * return result; }
	 */

	private static long pow(long base, long exp) {
		long result = 1;
		while (exp > 0) {
			if (exp % 2 != 0) {
				result *= base;
				exp--;
			}
			base *= base;
			exp /= 2;
		}
		return result;
	}

	public static void main(String[] args) {
		PrintWriter writer = null;
		try {
			Scanner scanner = new Scanner(new FileInputStream("A-large-practice.in"));
			writer = new PrintWriter("A-large-practice.out");
			int numberOfTestCases = scanner.nextInt();
			for (int i = 1; i <= numberOfTestCases; i++) {
				long n = scanner.nextLong();
				long k = scanner.nextLong();

				writer.print("Case #" + i + ": ");
				long mask = pow(2, n) - 1;
				if ((mask & k) == mask) {
					writer.println("ON");
				} else {
					writer.println("OFF");
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
