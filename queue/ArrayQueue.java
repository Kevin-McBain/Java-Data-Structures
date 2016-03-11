package queue;
import list.*;

/**
 * An ArrayList implementation of an ADT in FIFO order
 * @author Kevin McBain
 */
public class ArrayQueue<E> implements QueueADT<E> {

	List<E> values;
	int qsize = 0;
	int front = 0;
	int back = 0;
	
	public ArrayQueue()
	{
		values = new ArrayList<E>();
	}
	
	public void add(E value) {
		if(qsize == values.size())
		{
			values.add(back, value);
			front = (front + 1) % values.size();
		}
		else{values.set(back, value);}
		back = (back + 1) % values.size();
		qsize++;
	}

	
	public E remove() {
		E result = values.get(front);
		front = (front + 1) % values.size();
		qsize--;
		return result;
	}

	public E peek() {
		if (values.isEmpty()) {
			return null;
		}
		return values.get(front);
	}
	
	public boolean isEmpty()
	{
		return qsize == 0;
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			return "[]";
		}
		String str = "[" + values.get(front);
		for(int i = 1; i < qsize; i++) {
			str = str + ", " + values.get((front + i) % (values.size()));
		}
		str = str + "]";
		return str;
	}
	
	public int size()
	{
		return qsize;
	}

}
