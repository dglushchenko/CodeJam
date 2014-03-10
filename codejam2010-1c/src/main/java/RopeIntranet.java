
public class RopeIntranet {

	public static void main(String[] args) {
		int[][] ropes = new int[][] {{1, 10}, {5, 5}, {7, 7}};
		
		int count = 0;
		for (int i = 0; i < ropes.length; i++) {
			for (int j = 0; j < ropes.length; j++) {
				int[] a = ropes[i];
				int[] b = ropes[j];
				if ((a[0] > b[0] && a[0] < b[1]) || (a[1] > b[0] && a[1] < b[1])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
}
