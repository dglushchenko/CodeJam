import java.util.Scanner;

public class SnapperChain {

	private static long pow(long base, long exp) {
		long result = 1;
		
		while (exp-- > 0) {
			result *= base;
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		for (int i = 1; i <= numberOfTestCases; i++) {
			long n = scanner.nextLong();
			long k = scanner.nextLong();
			
			System.out.print("Case #" + i + ": ");
			long mask = pow(2, n) - 1;
			if ((mask & k) == mask) {
				System.out.println("ON");
			} else {
				System.out.println("OFF");
			}
		}
	}
}
