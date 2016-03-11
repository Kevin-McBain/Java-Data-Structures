package list;

/**
 * A List is a collection, order is maintained, duplicated are permitted
 *
 * @author Kevin McBain
 *
 */
public class ArrayList<E> implements List<E> {
	E[] values;
	int size = 0;

	public ArrayList() {
		this(10);
	}

	public ArrayList(int capacity) {
		values = (E[]) new Object[capacity];
	}

	/** Add value to the end of the list */
	public void add(E value) {
		add(size, value);
	}

	/** Add value to given position */
	public void add(int index, E value) {
		if (size == values.length) {
			alloc();
		}
		for (int i = size - 1; i >= index; i--) {
			values[i + 1] = values[i];
		}
		values[index] = value;
		size++;
	}

	private void alloc() {
		E[] temp = (E[]) new Object[values.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = values[i];
		}
		values = temp;
	}

	/** Return the value at the given position */
	public E get(int index) {
		return values[index];
	}

	/** Change the value at the given index */
	public E set(int index, E value) {
		E temp = values[index];
		values[index] = value;
		return temp;
	}

	/** Remove the value at the given index and return it */
	public E remove(int index) {
		E result = values[index];
		for (int i = index; i <= size - 1; i++) {
			values[i] = values[i + 1];
		}
		size--;
		return result;
	}

	/** Clear all elements from the list */
	public void clear() {
		size = 0;
	}

	public int indexOf(Object value) {
		for (int i = 0; i < size; i++) {
			if (values[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(Object value) {
		if (indexOf(value) == -1) {
			return false;
		} else
			return true;
	}

	public String toString() {
		if (values[0] == null) {
			return "[]";
		}
		String str = "[" + values[0];
		for (int i = 1; i <= size - 1; i++) {
			str = str + ", " + values[i];
		}
		str = str + "]";
		return str;
	}

	public boolean equals(Object other) {
		List list;
		if (other instanceof List) {
			list = (List) other;
		} else {
			return false;
		}
		if (this.size() != list.size()) {
			return false;
		}
		for (int i = 0; i < size; i++) {
			if (!list.get(i).equals(this.values[i])) {
				return false;
			}
		}
		return true;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Remove the first occurrence of obj from this List if possible
	 * @return true only if obj was removed
	 */
	public boolean remove(Object obj) 
	{
		for (int i = 0; i < size; i++) 
		{
			if(values[i].equals(obj))
			{
				this.remove(i);
				return true;
			}
		}
		return false;
	}

	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}
	
	public ListIterator<E> listIterator()
	{
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int index)
	{
		return new ArrayListIterator<E>(this, index);
	}

	@Override
	public boolean hasDuplicates() {
		// TODO Auto-generated method stub
		return false;
	}
} // end ArrayList