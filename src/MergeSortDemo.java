
public class MergeSortDemo {
	
	public void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) >>> 1;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}
	
	public void merge(int[] a, int left, int mid, int right) {
		int[] b = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				b[k++] = a[i++];
			}else {
				b[k++] = a[j++];
			}			
		}
		while (i <= mid) {
			b[k++] = a[i++];
		}
		while (j <= right) {
			b[k++] = a[j++];
		}
		for (i = left, k = 0; i <= right; i++, k++) {
			a[i] = b[k];
		}
	}
	
	public static void main(String[] args) {
		MergeSortDemo demo = new MergeSortDemo();
		int[] a = {1, 4, 5, 9, 9, 0, 8, 3, 90, 12};
		demo.mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

}
