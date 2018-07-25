import java.util.Scanner;

// 数列
public class Test4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int q = in.nextInt();
			int[] A = new int[n];
			int[] B = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
				B[i] = in.nextInt();
			}
			int[][] query = new int[q][2];
			for (int i = 0; i < q; i++) {
				for (int j = 0; j < 2; j++) {
					query[i][j] = in.nextInt();
				}
			}
			int index = 0;
			int[] result = new int[q];
			for (int i = 0; i < q; i++) {
				while (index < n) {
					if (A[index] >= query[i][0] && B[index] >= query[i][1]) {
						result[i]++;
					}
					index++;
				}
				index = 0;
			}
			for (int i = 0; i < result.length; i++) {
				if (i == result.length - 1) {
					System.out.print(result[i]);
				} else {
					System.out.println(result[i]);
				}
			}
		}

	}
}
