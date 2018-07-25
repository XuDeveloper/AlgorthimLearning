
public class QuickSortDemo {
	public void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = partition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}
	
	public int partition(int[] a, int left, int right) {
		int x = a[left];
		int i = left;
		int j = right;
		while (i <= j) {
			while (i <= right && a[i] <= x) {
				i ++;				
			}
			while (a[j] > x) {
				j --;				
			}
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		a[left] = a[j];
		a[j] = x;
		return j;
	}
	
	public static void main(String[] args) {
		QuickSortDemo demo = new QuickSortDemo();
		int[] a = {1, 4, 5, 9, 9, 0, 8, 3, 90, 12};
		demo.quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
