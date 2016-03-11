package list;

/**
 * ListIterator for Linked Lists
 * 
 * @author mcbain41
 */
public class RefListIterator<E> extends RefIterator<E> implements
		ListIterator<E>{

	private boolean forward = true;
	
	RefListIterator(LinkedList<E> list) {
		super(list);
	}

	RefListIterator(LinkedList<E> list, int index)
	{
		this(list);
		for(int i = 0; i < index; i++)
		{
			cursor = cursor.next;
		}
	}
	
	public boolean hasNext()
	{
		if(forward)
		{
			return cursor.next != list.tail;
		}
		return !list.isEmpty();
	}
	
	public E next()
	{
		if(forward)
		{
			cursor = cursor.next;
		}
		forward = true;
		return cursor.value;
	}
	
	public void remove(int index) {
		cursor.next.prev = cursor.prev;
		cursor.prev.next = cursor.next;
		list.size--;
		if(!forward)
		{
			cursor = cursor.next;
		}
	}

	public boolean hasPrevious() {
		if(!forward)
		{
			return cursor.prev != list.head;
		}
		return !list.isEmpty();
	}

	
	public E previous() {
		if(!forward)
		{
			cursor = cursor.prev;
		}
		forward = false;
		return cursor.value;
	}

	public void add(E value) {
		Node<E> temp = new Node<E>(value, cursor.next, cursor);
		cursor.next.prev = temp;
		cursor.next = temp;
		list.size++;
		cursor = cursor.next;
	}

}
