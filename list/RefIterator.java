package list;

public class RefIterator<E> implements Iterator<E> {

	Node<E> cursor;
	LinkedList<E> list;
	
	RefIterator(LinkedList<E> list)
	{
		this.list = list;
		cursor = list.head;
	}
	public boolean hasNext() {
		return cursor.next != list.tail;
	}

	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}
	
	public void remove() {
		if(cursor != list.head && cursor != list.tail)
		{
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		list.size--;
		cursor = cursor.prev;
		}		
	}

}
