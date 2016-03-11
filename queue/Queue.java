package queue;

import list.*;

/**
 * A LinkedList implementation of an ADT in FIFO order
 * @author Kevin McBain
 */
public class Queue<E> implements QueueADT<E> {

	List<E> values;

	public Queue() {
		values = new LinkedList<E>();
	}

	public void add(E value) {
		values.add(value);
	}

	public E remove() {
		return values.remove(0);
	}

	public E peek() {
		if (values.isEmpty()) {
			return null;
		}
		return values.get(0);
	}
	
	public String toString()
	{
		return values.toString();
	}
	
	public boolean isEmpty()
	{
		return values.isEmpty();
	}
	
	public int size()
	{
		return values.size();
	}

}
