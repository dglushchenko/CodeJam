import java.util.Arrays;


public class MinimumScalarProduct {

	public static void main(String[] args) {
		long[] x = new long[] {1, 3, -5};
		long[] y = new long[] {-2, 4, 1};
		
		Arrays.sort(x);
		Arrays.sort(y);
		int i = 0;
		int j = x.length - 1;
		long product = 0;
		while (i < x.length) {
			product += x[i++] * y[j--];
		}
		System.out.println(product);
	}
	
}
