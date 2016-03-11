package tree;
import list.Iterator;
/**
 * 
 * Kevin McBain
 */
public class EmptyBinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {

	public BinaryTree<E> getLeft() 
	{return null;}

	public BinaryTree<E> getRight()
	{return null;	}

	public E getValue()
	{return null;}

	public BinaryTree<E> add(E value)
	{
		return new BinarySearchTree<E>(value);
	}

	public boolean containsKey(E value)
	{return false;}

	public E get(E value) 
	{return null;}

	public BinaryTree<E> remove(Object obj) 
	{return this;}

	public Iterator<E> iterator() 
	{
		return new EmptyIterator<E>();
	}
	
	public String toString()
	{
		return "[]";
	}

	public void setValue(E value) {
		
		
	}

	public void setLeft(BinaryTree<E> left) {
		
	}

	public void setRight(BinaryTree<E> right) {
		
	}

	public boolean isEmpty() {
		return true;
	}

	public E getLargest() {
		return null;
	}

	public int size() {
		return 0;
	}

}
