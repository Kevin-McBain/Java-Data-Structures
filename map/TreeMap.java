package map;

import list.Iterator;
import set.*;
import tree.*;

public class TreeMap<K extends Comparable, V> implements Map<K,V> {

	BinaryTree<Entry<K,V>> tree = new EmptyBinarySearchTree<Entry<K,V>>();
	int size;
	
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		return tree.containsKey(entry);
	}

	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
		{
			return null;
		}
		return entry.value;
	}

	public V put(K key, V value) {
		Entry<K,V> newentry = new Entry<K,V>(key, value);
		Entry<K,V> oldentry = tree.get(newentry);
		if(oldentry == null)
		{
			tree = tree.add(newentry);
			size++;
			return null;
		}
		else{
		V result = oldentry.value;
		oldentry.value = value;
		return result;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
		{
			return null;
		}
		tree.remove(entry);
		size--;
		return entry.value;
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			return "[]";
		}
		return tree.toString();
	}
	
	public Set<K> keySet() {
		Set<K> result = new TreeSet<K>();
		Iterator<Entry<K,V>> itty = this.iterator();
		while(itty.hasNext())
		{
			result.add(itty.next().key);
		}
		return result;
	}

	public Iterator<Entry<K, V>> iterator() {
		return tree.iterator();
	}

}
