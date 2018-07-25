import java.util.ArrayList;
import java.util.Scanner;
// 工程师
public class Test3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {//注意while处理多个case
			int n = in.nextInt();
			int[] works = new int[7];
			ArrayList<String> workers = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				String string = in.nextLine();
				workers.add(string);
			}
			for (int i = 0; i < works.length; i++) {
				String temp = workers.get(i);
				for (int j = 0; j < temp.length(); j++) {
					System.out.println(temp);
					int tempIndex = Integer.valueOf(String.valueOf(temp.charAt(j)));
					works[tempIndex]++;
					System.out.println(works[tempIndex]);
				}
			}
			int result = 0;
			for (int i = 1; i < works.length; i++) {
				if (i == 0) {
					result *= works[i];
				} else {
					result *= (works[i] - 1);
				}
			}
			System.out.println(result);
		}
	}
}
