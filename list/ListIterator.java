package list;

/**
 * A List Iterator has all the capabilities of an iterator, plus:
 * Can go from tail to head
 * Can start at a given position
 * 
 * @author Kevin McBain
 */
public interface ListIterator<E> extends Iterator<E>{

	/**
	 * @return true only if there are more elements in the list
	 */
	boolean hasPrevious();
	
	/**
	 * @return the element previous to the last one obtained
	 */
	E previous();
	
	/**
	 * remove the last value obtained from a next or previous call
	 */
	void remove();
	
	/** add the given value at the cursor position.  A subsequent call to next() will be unaffected; a subsequent call to previous() will return the value added */

	void add (E value);
}
