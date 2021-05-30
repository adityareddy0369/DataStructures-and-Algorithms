import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 10, 2, 9 };
		SelectionSort ss = new SelectionSort();
		ss.sortLeft(arr);
		System.out.println(Arrays.toString(arr));
		ss.sortRight(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void sortLeft(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	private void sortRight(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int maxIndex = i;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[i];
			arr[i] = temp;
		}
	}

}
