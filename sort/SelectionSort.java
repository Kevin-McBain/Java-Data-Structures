package sort;

import list.*;

public class SelectionSort<E extends Comparable> implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		for(int i = 0; i < list.size()-1; i++)
		{
			swap(i, posSmallest(i));
		}
	}
	
	private int posSmallest(int start)
	{
		int result = start;
		for(int i = start + 1; i < list.size(); i ++)
		{
			if(list.get(i).compareTo(list.get(result)) <0)
			{
				result = i;
			}
		}
		return result;
	}
	
	public void swap(int i, int j)
	{
		E temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}
}
