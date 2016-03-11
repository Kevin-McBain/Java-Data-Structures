package hash;

import list.*;

/**
 * Implement HashTable for quick access to data. The data is stored as keys
 * 
 * @author Kevin McBain
 */
public class HashTable<K> {
	List<List<K>> table = new ArrayList<List<K>>();
	int keyCount; // number of keys in table

	public HashTable(int tablesize) {
		for (int i = 0; i < tablesize; i++) {
			table.add(new LinkedList<K>());
		}
	}

	public HashTable() {
		this(10);
	}

	public boolean containsKey(Object obj) {
		K key;
		try {
			key = (K) obj;
			int code = getCode(key);
			List<K> list = table.get(code);
			return list.indexOf(key) >= 0;
		} catch (ClassCastException cce) {
			return false;
		}

	}

	private int getCode(K key) {
		return Math.abs(key.hashCode()) % table.size();
	}

	public K get(K key) {
		int code = getCode(key);
		int index = table.get(code).indexOf(key);
		if (index < 0) {
			return null;
		} else
			return table.get(code).get(index);
	}

	public void put(K key) {
		int code = getCode(key);
		table.get(code).add(key);
		keyCount++;
	}

	public boolean remove(Object obj) {
		K key;
		try {
			key = (K) obj;
			int code = getCode(key);
			if (table.get(code).remove(key)) {
				keyCount--;
				return true;
			}
			return false;
		} catch (ClassCastException cce) {
			return false;
		}
	}

	public boolean isEmpty() {
		return keyCount == 0;
	}

	public int size() {
		return keyCount;
	}

	public void clear() {
		for (int i = 0; i < table.size(); i++) {
			table.set(i, new LinkedList<K>());

		}
		keyCount = 0;
	}

	public Iterator<K> iterator() {
		return new TableIterator<K>(this);
	}

	public String toString() {
		if(this.isEmpty())
		{
			return "[]";
		}
		Iterator itty = new TableIterator(this);
		String str = "[";
		while (itty.hasNext()) {
			str = str + itty.next().toString() + ", ";
		}
		return str.substring(0, str.length() - 2) + "]";
	}
}
