public class MaxHeap {
	Integer[] heap;
	int n;
	
	public MaxHeap(int capacity) {
		heap = new Integer[capacity + 1];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(3);
		maxHeap.insert(4);
		maxHeap.insert(5);
		maxHeap.insert(2);
		maxHeap.insert(6);
		maxHeap.insert(1);
		maxHeap.insert(3);
		System.out.println(maxHeap.size());
		maxHeap.printMaxHeap();
	}

	private void printMaxHeap() {
		for(int i = 1; i <= n; i++) {
			System.out.print(heap[i] + " ");
		}
	}

	private void insert(int x) {
		if(n == heap.length - 1) {
			resize(2*heap.length);
		}
		n++;
		heap[n] = x;
		swim(n);
		
	}

	private void resize(int capacity) {
		Integer[] temp = new Integer[capacity];
		for(int i = 0; i < heap.length; i++) {
			temp[i] = heap[i]; 
		}
		heap = temp;
	}
	
	private void swim(int k) {
		// while(k > 1 && heap[k] < heap[k/2]) { // Min heap
		while(k > 1 && heap[k/2] < heap[k]) {
			int temp = heap[k];
			heap[k] = heap[k/2];
			heap[k/2] = temp;
			k = k/2; //  because we need to continue shifting up till new value inserted is at correct position.
		}
	}
}
