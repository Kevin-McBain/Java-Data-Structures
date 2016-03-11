package queue;
import list.*;

/**
 * Priority Queue
-Each value has a priority
-Remove the value with highest priority.
Using a linked list it's O(n)
Can this be logarithmic?
Use a heap.
Pos | Left child | Right child | Parent
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0   |     1      |      2      |    0
1   |     3      |      4      |    0
2   |     5      |      6      |    0
3   |     7      |      8      |    1 
4   |     9      |      10     |    1
n   |   2n+1     |     2n+2    | (n-1)/2

If the list is maintained as a heap, the root must have the highest priority.

    15   
   /  \
  9    10 --> remove() 
 / \   /
6   8 7

    10   
   /  \
  9    7 --> remove()
 / \   
6   8 

    9   
   /  \
  8    7 --> remove()
 /    
6 

    8   
   /  \
  6    7
  
  root is the result.
  Swap it with its biggerChild, until heap
 * 
 * @author (K) 
 * @version (a version number or a date)
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {
	List<E> values = new ArrayList<E>();
	int size = 0;

	public E remove() {
		E result = values.get(0);
		int avail = 0;
		int bigger = biggerChild(avail);
		size--;
		while (avail * 2 + 1 < size && greater(bigger, size)) {
			values.set(avail, values.get(bigger));
			avail = bigger;
			bigger = biggerChild(avail);
		}
		values.set(avail, values.get(size));
		values.remove(size);
		return result;
	}

	public void add(E value) {
		int added = size;
		int parent = (size - 1) / 2;
		if (size == values.size()) {
			values.add(value);
		} else {
			values.set(size, value);
		}
		size++;
		while (added > 0 && greater(added, parent)) {
			swap(added, parent);
			added = parent;
			parent = (added - 1) / 2;
		}
	}

	public E peek() {
		return values.get(0);
	}

	public int size() {
		return this.size();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// return position of the parent's bigger child
	private int biggerChild(int parent) {
		int left = 2 * parent + 1, right = 2 * parent + 2;
		if (right >= size)
			return left;
		if (greater(left, right))
			return left;
		return right;
	}

	private boolean greater(int i, int j) {
		return values.get(i).compareTo(values.get(j)) > 0;
	}

	private void swap(int i, int j) {
		E temp = values.get(j);
		values.set(j, values.get(i));
		values.set(i, temp);
	}
	public String toString()
	{
		return values.toString();
	}
}
