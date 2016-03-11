package set;

import hash.*;
import list.*;

/**
 * 
 * Kevin McBain
 * 
 */
public class HashSet<E> implements Set<E> {
	HashTable<E> table = new HashTable<E>();

	public boolean add(E value) {
		if (table.containsKey(value)) {
			return false;
		}

		table.put(value);
		return true;
	}

	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}

	public boolean remove(Object obj) {
		return table.remove(obj);
	}

	public Iterator<E> iterator() {
		return table.iterator();
	}

	public boolean isEmpty() {
		return table.isEmpty();
	}

	public String toString() {
		return table.toString();
	}

	public void clear() {
		table.clear();
	}

	public int size() {
		return table.size();
	}

	public boolean equals(Object other)
	{
		if(!(other instanceof Set))
			{
				return false; //not a set, not equal
			}
		Set set = (Set) other; //other is a set, cast as such
		if(set.size() != this.size())
		{
			return false; //not the same number of elements, not equal
		}
		
		Iterator<E> itty = this.iterator();
		while(itty.hasNext())
		{
			if(!set.contains(itty.next()))
			{
				return false;
			}
		}
		return true;
		
	}
	
	public boolean subsetOf(Set<E> other)
	{
		Iterator<E> itty = this.iterator();
		while(itty.hasNext())
		{
			if(!other.contains(itty.next()))
			{
				return false;
			}
		}
		return true;
	}

	public Set<E> intersection(Set<E> set) {
		Iterator<E> itty = set.iterator();
		Set<E> temp = new HashSet<E>();
		while(itty.hasNext())
		{
			temp.add(itty.next());				//populates a new temporary set as a copy of the given set to avoid
		}										//adding values that we do not mean to
		Set<E> result = new HashSet<E>();
		itty = this.iterator();
		while(itty.hasNext())
		{
			E nxt = itty.next();
			if(temp.add(nxt))
			{
				//do nothing
			}
			else{
				result.add(nxt);
			}
		}
		return result;
	}

	
	public Set<E> difference(Set<E> other) {
		Set<E> result = new HashSet<E>();
		Iterator<E> itty = this.iterator();
		E element;
		while (itty.hasNext())
		{
			element = itty.next();
			if(!(other.contains(element)))
			{
				result.add(element);
			}
		}
		return result;
	}
}
