package map;

import list.Iterator;
import set.Set;

public interface Map<K, V> {

	boolean containsKey(K key);
	V get(K key);
	V put(K key, V value);
	boolean isEmpty();
	int size();
	V remove(K key);
	String toString();
	/** @return all the keys in this Map as a Set  */
	Set<K> keySet();
	Iterator<Entry<K,V>> iterator();

	}
