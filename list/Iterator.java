package list;

/**Allow client to iterate all elements of a list */
public interface Iterator<E> {

	/**@return true iff there are more items in the list */
	boolean hasNext();
	
	/**@return a reference to the next item in the list	 */
	E next();
	
	void remove();
}
