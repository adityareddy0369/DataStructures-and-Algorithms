public class HashTableLinearProbing {

	private int currentSize, maxSize;
	private Integer[] keys;
	private String[] values;

	public HashTableLinearProbing(int capacity) {
		this.currentSize = 0;
		this.maxSize = capacity;
		this.keys = new Integer[maxSize];
		this.values = new String[maxSize];
	}

	public static void main(String[] args) {

		HashTableLinearProbing lp = new HashTableLinearProbing(10);
		lp.put(1, "a");
		lp.put(4, "b");
		lp.put(14, "H");
		// lp.put(24, "H");
		lp.put(36, "F");
		//lp.put(34, "H");
		lp.put(3, "c");
		lp.printkeyValuePairs();
		System.out.println(lp.get(14));
		lp.remove(14);
		lp.printkeyValuePairs();
	}

	private void remove(int key) {
		if (get(key) == null) {
			return;
		}
		int i = getHashkey(key);

		while (!keys[i].equals(key)) {
			i = (i + 1) % maxSize;
		}
		keys[i] = null;
		values[i] = null;

		// rehash all keyvalue pairs
		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			Integer tmp1 = keys[i];
            String	tmp2 = values[i];
			keys[i] = null;
			values[i] = null;
			currentSize--;
			put(tmp1, tmp2);
		}
		currentSize--;
	}

	private String get(int key) {
		int i = getHashkey(key);
		while (keys[i] != null) {
			if (keys[i].equals(key)) {
				return values[i];
			}
			i = (i + 1) % maxSize;
		}
		return null;
	}

	private void printkeyValuePairs() {
		for (int i = 0; i < maxSize; i++) {
			if (keys[i] != null) {
				System.out.println("Index: " + i + " key: " + keys[i] + " value: " + values[i]);
			}
		}

	}

	private Integer getHashkey(Integer key) {
		return key % maxSize;
	}

	private void put(Integer key, String value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key or value not found");
		}

		int temp = getHashkey(key);
		int i = temp;
		do {
			if (keys[i] == null) {
				keys[i] = key;
				values[i] = value;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}

			i = (i + 1) % maxSize;
		}
		while (i != temp);
	}

}
