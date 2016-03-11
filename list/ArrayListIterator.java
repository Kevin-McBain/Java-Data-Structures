package list;

public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {

	private boolean forward = true;
	
	ArrayListIterator(ArrayList<E> list) 
	{
		super(list);
		index = 0;
	}
	
	ArrayListIterator(ArrayList<E> list, int index)
	{
		this(list);
		super.index = index;
	}
	
	public boolean hasNext()
	{
		return index < list.size;
	}
	
	public E next()
	{
		index ++;
		forward = true;
		return list.get(index - 1);
	}
	
	public boolean hasPrevious() 
	{
		return index > 0;
	}
	
	public E previous()
	{
		index --;
		forward = false;
		return list.get(index);
	}
	
	public void remove()
	{
		if(forward)
		{
			index --;
		}
		list.remove(index);
	}

	public void add(E value) {
		list.add(index, value);
		index++;
	}
}
