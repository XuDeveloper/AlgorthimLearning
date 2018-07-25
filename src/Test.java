import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int L = in.nextInt();
		int cur = L + 1;
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (cur <= 100) {
			int x = (2 * N + cur - cur * cur) % (2 * cur);
			if (x == 0) {
				int result = (2 * N + cur - cur * cur) / (2 * cur);
				if (result < 0) {
					break;
				}
				for (int i = result; i < result + cur; i++) {
					results.add(i);
				}
				break;
			} else {
				cur++;
			}
		}
		if (cur > 100 || results.size() == 0) {
			System.out.println("No");
		} else {
			for (int i = 0; i < results.size(); i++) {
				if (i == results.size() - 1) {
					System.out.print(results.get(i));
				} else {
					System.out.print(results.get(i) + " ");
				}
			}
		}
	}
}