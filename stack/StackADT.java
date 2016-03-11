package stack;

/**
 * An ADT to implement a Last in First Out Data Structure
 * @author Kevin McBain
 */
public interface StackADT<E> {
	/*Add a given value to the top of the stack */
	E push(E value);
	
	/*Remove the top item in the stack */
	E pop();
	
	/*Return the top item in the stack */
	E peek();
	
	boolean isEmpty();
	
	void clear();
	
	String toString();
	
	//String reverse(String str);
}
