import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 10, 2, 9 };
		sortAsc(arr);
		System.out.println(Arrays.toString(arr));
		sortDesc(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortDesc(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

	private static void sortAsc(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

}
