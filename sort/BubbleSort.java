package sort;
import list.*;

public class BubbleSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		for(int i = 0; i < list.size() -1; i++)
		{
			for(int j = 0; j < list.size() - i - 1; j++)
			{
				E value = list.get(j);
				if(value.compareTo(list.get(j + 1)) > 0)
				{
					swap(j, j + 1);
				}
			}
		}
	}
	
	/**
	 * Swap the values at positions n and k in an ArrayList
	 * @param n one of the positions to be swapped
	 * @param k the other position to be swapped
	 */
	private void swap(int n, int k)
	{
		E temp = list.get(n);
		list.set(n, list.get(k));
		list.set(k, temp);
	}
}
