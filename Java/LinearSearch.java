public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = {3, 5, 12, 43, 1, 14};
		int size = arr.length;
		int value = 3;
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.findIndex(arr, size, value));
	}
	
	public int findIndex(int[] arr, int size, int value) {
		for(int i=0; i < size; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return -1;
		
	}

}
