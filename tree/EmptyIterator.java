package tree;
import list.Iterator;
public class EmptyIterator<E> implements Iterator<E>{

	public boolean hasNext() 
	{return false;}

	public E next() 
	{return null;}

	public void remove() 
	{
		//do nothing, always
	}

}
