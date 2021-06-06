public class ArrayDemo {

	public static void main(String[] args) {
		int[] arr = new int[10];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 4;
		arr[3] = 5;

		ArrayDemo obj = new ArrayDemo();
		obj.print(arr);
		obj.insertAtFirst(arr, 1);
		System.out.println();
		obj.print(arr);
		obj.insertAtLast(arr, 7);
		System.out.println();
		obj.print(arr);
		obj.insertAtPosition(arr, 5, 6);
		System.out.println();
		obj.print(arr);
		obj.deleteFirst(arr);
		System.out.println();
		obj.print(arr);

	}

	private void deleteFirst(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
	}

	private void insertAtPosition(int[] arr, int position, int value) {
		for (int i = arr.length - 1; i > position; i--) {
			arr[i] = arr[i - 1];
		}
		arr[position] = value;
	}

	private void insertAtLast(int[] arr, int value) {
		arr[5] = value;
	}

	private void insertAtFirst(int[] arr, int value) {
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = value;
	}

	private void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
