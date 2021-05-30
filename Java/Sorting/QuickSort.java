import java.util.Arrays;

// source: youtube: QuickSort in Java (explanation and code)
// yotube:(Java: QuickSort Explained) for concept explanation
public class QuickSort {

	public static void main(String[] args) {
		// int[] arr = { 5, 1, 10, 2, 9 };
		int[] arr = { 17, 54, 5, 22, 19, 6, 29, 3, 13 };
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int mid = (high + low) / 2;
		int pivot = arr[mid];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		// Till now i and j crossed each other
		System.out.println(Arrays.toString(arr));
		if (low < j) {
			sort(arr, low, j);
		}
		if (high > i) {
			sort(arr, i, high);
		}
	}

}
