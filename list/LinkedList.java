package list;

/**
 * A list collection organized in a link based implementation
 * 
 * @author Kevin McBain
 */

public class LinkedList<E> implements List<E> {

	Node<E> head = new Node<E>(null, null, null);
	Node<E> tail = new Node<E>(null, null, null);
	int size = 0;
	Node<E> ref;

	public LinkedList() {
		head.next = tail;
		tail.prev = head;
	}
	
	public LinkedList(List original) 
    {
		head.next = tail;
		tail.prev = head;
        for(int i = 0; i < original.size(); i++)
        {
            add((E) original.get(i));
        }
    }


	public void add(E value) {
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}

	public void add(int index, E value) {
		setRef(index);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		size++;
	}

	public E get(int index) {
		setRef(index);
		return ref.value;
	}

	private void setRef(int index) {
		if (index < size / 2) { // index is in the former half of the linked
								// list
			ref = head;
			for (int i = 0; i <= index; i++) {
				ref = ref.next;
			}
		} else { // index is in the latter half of the linked list
			ref = tail;
			for (int i = size - 1; i >= index; i--) {
				ref = ref.prev;
			}
		}
	}

	public E set(int index, E value) {
		setRef(index);
		E result = ref.value;
		ref.value = value;
		return result;
	}

	public E remove(int index) {
		setRef(index);
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size--;
		return ref.value;
	}

	public int indexOf(Object value) {
		ref = head;
		for (int i = 0; i < size; i++) {
			ref = ref.next;
			if (ref.value.equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(Object value) {
		return this.indexOf(value) != -1;
	}

	public void clear() {
		head.next = tail;
		tail.prev = head;
		ref = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean remove(Object obj) {
		if(!(contains(obj)))
		{
			return false;
		}
		else{
			remove(indexOf(obj));
			return true;
		}
	}

	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}

	public String toString() {
		Iterator<E> itty = this.iterator();
		if (itty.hasNext() == false) {
			return "[]";
		}
		String str = "[" + itty.next().toString();
		while (itty.hasNext()) {
			str = str + ", " + itty.next().toString();
		}
		str = str + "]";
		return str;
	}

	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		List<E> list;
		if (obj instanceof List) {
			list = (List<E>) obj;
		} else {
			return false;
		}
		if (this.size() != list.size()) {
			return false;
		}
		Iterator<E> itty = this.iterator();
		Iterator<E> itty2 = list.iterator();
		while (itty.hasNext() && itty2.hasNext()) {
			if (!itty.next().equals(itty2.next())) {
				return false;
			}
		}
		return true;
	}

	public ListIterator<E> listIterator() {
		return new RefListIterator<E>(this);
	}

	public ListIterator<E> listIterator(int index) {
		return new RefListIterator<E>(this, index);
	}

	public boolean hasDuplicates() {
		Node<E> ref = head, ref2;
		if(size == 0)
		{
			return false;
		}
		while(ref.next.next != tail)
		{
			ref2 = ref.next;
			while(ref2.next != tail)
			{
				if(ref.value.equals(ref2.value))
				{
					return true;
				}
			}
		}
		return false;
	}
}