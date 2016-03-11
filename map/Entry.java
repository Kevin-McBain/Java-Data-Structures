package map;

public class Entry<K, V> implements Comparable<Entry<K,V>>{
	K key;
	V value;
	
	Entry(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(Entry<K,V> other)
	{
		Comparable thisKey = (Comparable) key;
		Comparable otherKey = (Comparable) other.key;
		return thisKey.compareTo(otherKey);
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Entry))
		{
			return false;
		}
		Entry entry = (Entry) obj;
		return key.equals(entry.key);
	}
	
	public int hashCode()
	{
		return key.hashCode();
	}

	public String toString()
	{
		return key.toString() + " = " + value.toString();
	}
}
