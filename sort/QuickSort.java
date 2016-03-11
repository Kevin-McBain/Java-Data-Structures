package sort;
import list.*;

/**
 * QuickSorts an ArrayList
 * @author Kevin McBain
 *
 */
public class QuickSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	int counter = 0;
	
	public void sort(List<E> list)
	{
		this.list = list;
		qSort(0, list.size()-1);
	}
	
	public void qSort(int start, int end)
	{
		if(end - start < 1)
		{
			return;
		}
		
		int p = partition(start, end);
		counter++;
		System.out.print(counter + " ");
		qSort(start, p-1);
		qSort(p+1, end);
	}
	
	private int partition(int start, int end)
	{
		int p = (start + end)/2;
		E pivotValue = list.get(p);
		list.set(p, list.get(start));
		//list.set(start, pivotValue);
		p = start;
		
		for(int i = start + 1; i <= end; i++)
		{
			if(list.get(i).compareTo(pivotValue) < 0)
			{
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		}
		list.set(p, pivotValue);
		return p;
	}
}
