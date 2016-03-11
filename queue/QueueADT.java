package queue;

public interface QueueADT<E> 
{
	/*add the given value to the front of the queue */
	void add(E value);
	
	/*remove the value at the front of the queue */
	E remove();
	
	/*@return the value at the front of the queue, or a null if queue is empty */
	E peek();
	
	String toString();
	
	boolean isEmpty();
	
	int size();
}
