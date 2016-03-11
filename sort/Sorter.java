package sort;

import list.*;

/**
 * An interface for a sorting algorithm
 */
public interface Sorter<E extends Comparable> {
	void sort(List<E> list);

}
