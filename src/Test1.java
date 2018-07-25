import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {//注意while处理多个case
		    String a = in.nextLine();
			int i = 0;
			int result = 0;
			while (i < a.length() - 1) {
				if (i == 0) {
					int num1 = Integer.valueOf(String.valueOf(a.charAt(i)));
					int num2 = Integer.valueOf(String.valueOf(a.charAt(i + 2)));
					char operator = a.charAt(i + 1);
//					System.out.println(a.charAt(i));
//					System.out.println(a.charAt(i + 2));
					switch (operator) {
					case '+':
						result = num1 + num2;
						break;

					case '-':
						result = num1 - num2;
						break;

					case '*':
						result = num1 * num2;
						break;
					}
//					System.out.println(result);
					i += 3;
				} else {
					int num1 = result;
					char operator = a.charAt(i);
					int num2 = Integer.valueOf(String.valueOf(a.charAt(i + 1)));
					switch (operator) {
						case '+':
							result = num1 + num2;
						break;

						case '-':
							result = num1 - num2;
						break;

						case '*':
							result = num1 * num2;
						break;
					}
//				System.out.println(result);
					i += 2;
				}
			}
			System.out.println(result);
            result = 0;
		}
	}
}