import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DeceitfulWar {

	public static int war(double[] naomisBlocks, double[] kensBlocks) {
		Arrays.sort(naomisBlocks);
		Arrays.sort(kensBlocks);

		int length = naomisBlocks.length;
		
		int result = 0;

		int low = 0;
		int high = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (kensBlocks[high] == 0) {
				for (int j = high; j >=0; j--) {
					if (kensBlocks[j] == 0) {
						high--;
					} else {
						break;
					}
				}
			}
			
			if (naomisBlocks[i] > kensBlocks[high]) {
				low++;
				result++;
			} else {
				for (int j = low; j <= high; j++) {
					if (naomisBlocks[i] < kensBlocks[j]) {
						kensBlocks[j] = 0;
						break;
					}
				}
			}
		}
	
		return result;
	}

	public static int deceitfulWar(double[] naomisBlocks, double[] kensBlocks) {
		Arrays.sort(naomisBlocks);
		Arrays.sort(kensBlocks);
		
		int length = naomisBlocks.length;

		int result = 0;

		for (int i = 0, j = 0; i < length; i++) {
			if (naomisBlocks[i] > kensBlocks[j]) {
				j++;
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("D-large.in"));
		int t = scanner.nextInt();
		int caseNumber = 1;
		while (caseNumber <= t) {
			int n = scanner.nextInt();
			double[] naomisBlocks = new double[n];
			double[] kensBlocks = new double[n];
			for (int i = 0; i < n; i++) {
				naomisBlocks[i] = scanner.nextDouble();
			}
			for (int i = 0; i < n; i++) {
				kensBlocks[i] = scanner.nextDouble();
			}

			System.out.println("Case #" + caseNumber++ + ": " + deceitfulWar(naomisBlocks, kensBlocks) + " " + war(naomisBlocks, kensBlocks));
		}
	}

}
