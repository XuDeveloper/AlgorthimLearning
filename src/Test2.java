import java.util.Scanner;

//魔力手环
public class Test2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {//注意while处理多个case
			int n = in.nextInt();
			int k = in.nextInt();
			int[] number = new int[n];
			for(int i = 0; i < n; i++) {
				number[i] = in.nextInt();
			}
			while(k >= 300) {
				k = k % 300;
			}			
			while (k != 0) {
				k--;
				int temp = number[0];
				for (int i = 0; i < number.length; i++) {
					if (i == number.length - 1) {
						number[i] += temp;
						if (number[i] >= 100) {
							number[i] = number[i] % 100;
						}
					} else {
						number[i] += number[i + 1];
						if (number[i] >= 100) {
							number[i] = number[i] % 100;
						}
					}				
				}
				
			}
			for (int i = 0; i < number.length; i++) {				
				if (i == number.length - 1) {
					System.out.print(number[i]);
				} else {
					System.out.print(number[i] + " ");
				}
			}
		}
		
	}
}
