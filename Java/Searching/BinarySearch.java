public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
		int size = arr.length;
		int value = 19;
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.findIndex(arr, size, value));
	}

	private int findIndex(int[] arr, int size, int value) {
		int low=0;
		int high=size-1;
		while(low<=high) {
			int mid =(low+high)/2;
			if(arr[mid] == value) {
				return mid;
			}else if(arr[mid] < value) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}
}
