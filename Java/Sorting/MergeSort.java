// source: youtube: How to Code The Merge Sort Algorithm in Java
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 13, 5, 27, 43, 19, 3, 7 };
		int size = arr.length;
		MergeSort ms = new MergeSort();
		int[] sortedArr = ms.sort(arr, size);
		for (int value : sortedArr) {
			System.out.print(value + " ");
		}
		// System.out.println(Arrays.toString(sortedArr));
	}

	private int[] sort(int[] arr, int size) {
		if (size <= 1) {
			return arr;
		}
		
		int midPoint = size/2;
		int[] left = new int[midPoint]; // left array length
		int[] right;
		
		if(size%2== 0) {
			right = new int[midPoint]; // right array length
		} else {
			right = new int[midPoint + 1]; // right array length
		}
		
		for(int i= 0; i< midPoint; i++) {
			left[i] = arr[i];
		}
		for(int j=0; j< right.length; j++) {
			right[j] = arr[midPoint+j];
		}
		
		int[] result = new int[size];
		left = sort(left, left.length);
		right = sort(right, right.length);
		
		result = merge(left, right);
		
		return result;
	}

	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		while (leftPointer < left.length || rightPointer < right.length) { // left or right arrays have elements in them
			if (leftPointer < left.length && rightPointer < right.length) { // Both left and right arrays have elements
																			// in them
				if(left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				} else {
					result[resultPointer++] = right[rightPointer++];
				}
			} else if(leftPointer < left.length){
				result[resultPointer++] = left[leftPointer++];
			} else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		return result;
	}

}
