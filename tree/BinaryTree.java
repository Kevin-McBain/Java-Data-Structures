package tree;

import list.Iterator;

/**
 * 
 * @author Kevin McBain
 *
 */
public interface BinaryTree<E> {

	/**
	 * @return the left child of the current BT
	 */
	BinaryTree<E> getLeft();
	
	/**
	 * @return the right child of the current BT
	 */
	BinaryTree<E> getRight();
	
	/**
	 * @return the value of the current BT
	 */
	E getValue();
	
	/**
	 * @return the value of the current BT
	 */
	BinaryTree<E> add(E value);
	
	/** 
	 * @return true if the BT has the given value somewhere in its family
	 */
	boolean containsKey(E value);
	
	/**
	 * @return the given value if found in this family's BT, or otherwise null
	 */
	E get(E value);
	
	/**
	 * Remove the given object
	 * @return the updated BT
	 */
	BinaryTree<E> remove(Object obj);
	
	/**
	 * @return an Iterator for this BT's family
	 */
	Iterator<E> iterator();
	
	void setValue(E value);
	
	void setLeft(BinaryTree<E> left);
	
	void setRight(BinaryTree<E> right);
	
	String toString();

	boolean isEmpty();
	
	/** @return the largest value in the family of this BinaryTree 
    Pre:   This BinaryTree is not empty
	 */
	E getLargest( );
	
	/** @return the size of this BinaryTree */
	int size();
}
