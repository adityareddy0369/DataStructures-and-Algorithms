public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {13, 5, 27, 43, 19, 3, 7};
		int size = arr.length;
		BubbleSort bs = new BubbleSort();
		int[] sortedArr = bs.sort(arr, size);
		for(int i= 0; i< size; i++) {
			System.out.print(sortedArr[i] + " ");
		}
	}

	private int[] sort(int[] arr, int size) {
		boolean isSwapped = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1-i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if(isSwapped == false) {
				break;
			}
		}
		return arr;
	}

}
