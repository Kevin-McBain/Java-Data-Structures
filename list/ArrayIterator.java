package list;

public class ArrayIterator<E> implements Iterator<E> {

	int index;
	ArrayList<E> list;
	
	ArrayIterator(ArrayList<E> list)
	{
		this.list = list;
		index = -1;
	}

	public boolean hasNext() {
		return index < list.size() -1;
	}

	public E next() {
		index++;
		return list.get(index);
	}

	public void remove() {
		list.remove(index);
		index--;
	}

}
