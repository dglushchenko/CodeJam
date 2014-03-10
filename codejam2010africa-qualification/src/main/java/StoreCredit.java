
public class StoreCredit {

	// Try on large input. If does not work, try binary search for the second item.
	public static void main(String[] args) {
		int c = 200;
		int[] p = new int[] {150, 24, 79, 50, 88, 345, 3};
		
		for (int i = 0; i < p.length - 1; i++) {
			if (p[i] >= c) {
				continue;
			}
			for (int j = i + 1; j < p.length; j++) {
				if ((p[i] + p[j]) == c) {
					System.out.println((i + 1) + ", " + (j + 1));
				}
			}
		}
		
	}
	
}
