package map;
import list.Iterator;
import set.*;
import hash.*;

/**
 * Implementation of the Map interface using a HashTable
 * @author (Kevin McBain)
 */
public class HashMap<K,V> implements Map<K,V>
{
    HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
    public HashMap(int capacity)
    {
        table = new HashTable<Entry<K,V>>(capacity);
    }
    
    public HashMap()
    {
    	this(10);
    }
    
    public boolean containsKey(K key)
    {
        return table.containsKey(key);
    }
    public V get(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key, null);
        entry = table.get(entry);
        if(entry == null)
        {
            return null;
        }
        return entry.value;
    }
    public V put(K key, V value)
    {
        Entry<K,V> newEntry = new Entry<K,V>(key,value),
            oldEntry = table.get(newEntry);
        if(oldEntry == null)
        {
            table.put(newEntry);
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }
    public V remove(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        Entry<K,V> result = table.get(entry);
        if(table.remove(entry))
        {
            return result.value;
        }
        return null;
    }
    public int size()
    {
        return table.size();
    }
    public boolean isEmpty()
    {
        if(table.size() == 0)
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
    	if(this.isEmpty())
		{
			return "[]";
		}
		return table.toString();
    }
    
	public Set<K> keySet() {
		Set<K> result = new HashSet<K>();
		Iterator<Entry<K,V>> itty = this.iterator();
		while(itty.hasNext())
		{
			result.add(itty.next().key);
		}
		return result;
	}
	
	public Iterator<Entry<K, V>> iterator() {
		return table.iterator();
	}
}












