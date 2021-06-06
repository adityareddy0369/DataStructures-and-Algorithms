public class HashTableChaining {

	private HashNode[] buckets;
	private int noOfBuckets; // capacity
	private int size; // Number of key value pairs or hash nodes in a hash table

	public class HashNode {
		private Integer key;
		private String value;
		private HashNode next;

		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public HashTableChaining(int noOfBuckets) {
		this.noOfBuckets = noOfBuckets;
		this.buckets = new HashNode[noOfBuckets];
		this.size = 0;
	}

	public void put(Integer key, String value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key or value not found");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node = new HashNode(key, value);
		node.next = head;
		buckets[bucketIndex] = node;
	}

	private int getBucketIndex(Integer key) {
		return key % noOfBuckets;
	}

	private int size() {
		return size;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public String get(Integer key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public String remove(Integer key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		HashNode previous = null;
		while (head != null) {
			if (head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		size--;
		if (previous == null) {
			buckets[bucketIndex] = head.next;
		} else {
			previous.next = head.next;
		}
		return head.value;

	}

	public static void main(String[] args) {
		HashTableChaining node = new HashTableChaining(10);
		node.put(13, "a");
		node.put(35, "aa");
		node.put(23, "aaa");
		node.put(13, "aaaa");
		System.out.println(node.size);
		System.out.println(node.get(13));
		System.out.println(node.get(10));
		System.out.println(node.remove(35));
		System.out.println(node.get(35));
		System.out.println(node.size);
	}

}
